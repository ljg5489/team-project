import java.util.*;
import java.io.*;
import myClass.*;
import DataBase.*;
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
        User user = userDB.findElement(userID);
        Book book = bookDB.findElement(bookID);
        loanDB.put(user,book);
    }
    
    public <T extends DB_Element> void printDB(LibDB<T> db){
        db.printAllElements();
    }
    
    public void printLoanList(){
        Set<User> user = loanDB.keySet();
        Iterator<User> it = user.iterator();
        while(it.hasNext()){
            System.out.println(it.next() + "===>" + loanDB.get(it));
        }
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
        return bookDB;
    }
    
    public LibDB<User> setUserDB(String userFile){
        String str = "";
        
        try{
            FileReader src = new FileReader(userFile);
            Scanner sc = new Scanner(src);
            while(sc.hasNext()){
                str = sc.nextLine();
                StringTokenizer stz = new StringTokenizer(str, "/");
                String name = "";
                Integer stID = 0;
                int stz_i = stz.countTokens();
                int j = 0;
                for(int i=0;i<stz_i;i++){
                    if(i==0){
                        stID = Integer.parseInt(stz.nextToken());
                    }else if(i==1){
                        name = stz.nextToken();
                    }
                }
                User u = new User(name, stID);
                userDB.addElement(u);
            }
        }catch(IOException e){
            System.out.println("파일 경로가 올바르지 않습니다.");
        }
        return userDB;
    }
}