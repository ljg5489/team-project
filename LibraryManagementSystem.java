import java.util.*;
import java.io.*;
import myClass.*;
/**
 * LybraryManagementSystem 클래스의 설명을 작성하세요.
 *
 * @author (2022320039 정하경)
 * @version (2025.10.19)
 */
public class LibraryManagementSystem
{
    LibDB<Book> bookDB = new LibDB<Book>();
    HashMap<User,Book> loanDB = new HashMap<>();
    LibDB<User> userDB = new LibDB<User>();
    
    public LibraryManagementSystem(){
        this.bookDB = bookDB;
        this.loanDB = loanDB;
        this.userDB = userDB;
    }
    
    public void borrowBook(String userID, String bookID){
        
    }
    
    public void printDB(LibDB<T> db){
        
    }
    
    public void printLoanList(){
        
    }
    
    public LibDB<Book> setBookDB(String bookFile){
        String str = "";
        
        try{
            FileReader src = new FileReader(bookFile);
            Scanner sc = new Scanner(src);
            while(sc.hasNext()){
                str = sc.nextLine();
                StringTokenizer stz = new StringTokenizer(str, "/");
                String author = "";
                String bookID = "";
                String publisher = "";
                String title = "";
                int year = 0;
                int i = 0;
                while(stz.hasMoreTokens()){
                    i++;
                    switch(i){
                        case 1:
                            author = stz.nextToken();
                            break;
                        case 2:
                            bookID = stz.nextToken();
                            break;
                        case 3:
                            publisher = stz.nextToken();
                            break;
                        case 4:
                            title = stz.nextToken();
                            break;
                        case 5:
                            year = Integer.parseInt(stz.nextToken());
                            break;
                    }
                }
                Book b = new Book(author,bookID,publisher,title,year);
                bookDB.addElement(b);
            }
        }catch(IOException e){
            System.out.println("파일 경로가 올바르지 않습니다.");
        }
    }
    
    public LibDB<User> setUserDB(String userFile){
        
    }
}