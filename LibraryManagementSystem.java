import java.util.*;
import java.io.*;
import myClass.*;
import DataBase.*;
/**
 * LybraryManagementSystem 클래스의 설명을 작성하세요.
 * 외부 txt 파일을 읽어와서 이용자 객체와 책 객체를 만들고 해당 객체를 각각 이용자DB와 책DB에 저장합니다
 * 저장한 DB정보를 HashMap을 이용해 loanDB에 저장하는 형태로 관리하며 추가로 도서 대출 및 대출 목록 출력을 수행하는 도서관 관리 시스템입니다.
 *
 * @author (2022320039 정하경)
 * @version (2025.10.19)
 */
public class LibraryManagementSystem
{
    LibDB<Book> bookDB;
    HashMap<User,Book> loanDB;
    LibDB<User> userDB;
    
    /*
     * LibraryManagementSystem의 생성자로서 bookDB와 loanDB, userDB를 초기화
     * 강의자료 4장: 생성자 참고
     */
    public LibraryManagementSystem(){
        bookDB = new LibDB<Book>();
        loanDB = new HashMap<User, Book>();
        userDB = new LibDB<User>();
        this.bookDB = bookDB;
        this.loanDB = loanDB;
        this.userDB = userDB;
    }
    /*
     * 파라미터로 전달받은 값들을 이용해 각 객체가 DB에 있는지 검색한 뒤,
     * loanDB에 새로운 대출기록 추가
     * 강의자료 7장: HashMap 참고
     */
    public void borrowBook(String userID, String bookID){
        User user = userDB.findElement(userID);
        Book book = bookDB.findElement(bookID);
        loanDB.put(user,book);
    }
    
    /*
     * 파라미터로 전달받은 책DB 또는 이용자DB를 출력
     * 강의자료 7장: 제네릭 참고
     */
    public <T extends DB_Element> void printDB(LibDB<T> db){
        db.printAllElements();
    }
    
    /*
     * loanDB에 있는 키값들을 set형식으로 얻어온다음
     * 해당 키값들을 이용해 iterator 객체를 생성
     * 생성한 객체로 while문을 실행
     * 강의자료 7장: Iterator 참고
     */
    public void printLoanList(){
        Set<User> user = loanDB.keySet();
        Iterator<User> it = user.iterator();
        while(it.hasNext()){
            User u = it.next();
            System.out.println(u + " ===> " + loanDB.get(u));
        }
    }
    
    /*
     * 우선 파일입력 중 오류가 날 수 있으니 try-catch 를 사용해서 예외처리를 진행
     * 전달받은 파라미터값을 이용해 문자 스트림 객체를 생성
     * Scanner 클래스를 이용해서 파일의 내용을 한 줄 단위로 읽음
     * Scanner 클래스를 이용해 만들어진 객체에 다음 내용이 있는 경우 while문을 진행
     * 파일에서 읽어드린 한줄의 문자열을 StringTokenizer를 이용해서 "/" 를 기준으로 토큰을 분리
     * 읽어드리는 파일 값은 bookID,title,author,pulisher,year 순 이기에 switch문을 이용해서 각각의 적절한 값을 입력받음
     * 한 줄을 다 입력받은 후에 새로운 Book 객체를 생성
     * 생성한 Book 객체를 bookDB에 추가
     * 마지막으로 bookDB를 리턴
     * 강의자료 6장: StringTokenizer, 8장: FileReader 와 교과서 495페이지 참고
     */
    public LibDB<Book> setBookDB(String bookFile){
        ArrayList<Book> bookList = new ArrayList<>();
        String str = "";
        
        try{
            FileReader src = new FileReader(bookFile);
            Scanner sc = new Scanner(src);
            while(sc.hasNext()){
                str = sc.nextLine();
                StringTokenizer stz = new StringTokenizer(str, "/");
                String bookID = stz.nextToken();
                String title = stz.nextToken();
                String author = stz.nextToken();
                String publisher = stz.nextToken();
                int year = Integer.parseInt(stz.nextToken());
                Book b = new Book(author,bookID,publisher,title,year);
                bookList.add(b);
            }
            Iterator<Book> book_it = bookList.iterator();
            while(book_it.hasNext()){
                bookDB.addElement(book_it.next());
            }
        }catch(IOException e){
            System.out.println("파일 경로가 올바르지 않습니다.");
        }
        return bookDB;
    }
    
    /*
     * setBookDB와 마찬가지로 파일입력 중 오류가 날 수 있으니 try-catch 를 사용해 예외처리 진행
     * 전달받은 파라미터값을 이용해 문자 스트림 객체 생성
     * Scanner 클래스를 이용해 파일의 내용을 한 줄 단위로 읽음 그렇게 만들어진 객체로 while문을 돌림
     * 파일에서 읽어드린 한 줄의 문자열을 StringTokenizer를 이용해 "/" 를 기준으로 토큰을 분리
     * 읽어드리는 파일 값은 for문과 if 문을 이용해 각각 저장
     * 그렇게 읽어드린 값으로 새로운 User 객체 생성
     * 방금 만들어진 User 객체를 userDB에 추가
     * 마지막으로 userDB를 리턴
     * 강의자료 6장: StringTokenizer, 8장: FileReader 와 교과서 495페이지 참고
     */
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
                        stID = Integer.valueOf(stz.nextToken());
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