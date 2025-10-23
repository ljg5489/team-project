import java.util.*;
import java.io.*;
import myClass.*;
import DataBase.*;
/**
 * LibraryManagementSystem 클래스의 설명을 작성하세요.
 * 
 * 외부 txt 파일을 읽어와서 이용자 객체와 책 객체를 만들고 해당 객체를 각각 이용자DB와 책DB에 저장하는 역할을 합니다.
 * 저장한 DB정보를 HashMap을 이용해 대출DB에 저장하는 형태로 관리하며 추가로 도서 대출 및 대출 목록 출력을 수행하는 도서관 관리 시스템입니다.
 *
 * @author (2022320039 정하경)
 * @version (2025.10.22)
 */
public class LibraryManagementSystem
{
    LibDB<Book> bookDB;
    HashMap<User,Book> loanDB;
    LibDB<User> userDB;
    
    /*
     * LibraryManagementSystem의 생성자로서 bookDB과 loanDB, userDB 객체를 생성하고, 각 객체를 초기화
     * 교과서 199 페이지 생성자 참고
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
     * 교과서 425페이지 HashMap 참고
     */
    public void borrowBook(String userID, String bookID){
        User user = userDB.findElement(userID);
        Book book = bookDB.findElement(bookID);
        loanDB.put(user,book);
    }
    
    /*
     * 파라미터로 전달받은 책DB 또는 이용자DB를 출력
     * 교과서 440페이지 제네릭 메소드 참고
     */
    public <T extends DB_Element> void printDB(LibDB<T> db){
        db.printAllElements();
    }
    
    /*
     * loanDB에 있는 키값들을 set형식으로 얻어온다음
     * 해당 키값들을 이용해 iterator 객체를 생성
     * 생성한 Iterator 객체로 while문을 실행
     * 교과서 422 페이지 Iterator, 교과서 429 페이지 HashMap, Set, Iterator 사용 참고
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
     * 전달받은 파라미터값으로 FileReader를 이용해 파일에서 문자를 읽어오는 스트림 객체 생성
     * Scanner 클래스를 이용해서 파일의 내용을 한 줄 단위로 읽음
     * Scanner 클래스를 이용해 만들어진 객체에 다음 내용이 있는 경우 while문을 진행
     * 파일에서 읽어드린 한줄의 문자열을 StringTokenizer를 이용해서 "/" 를 기준으로 토큰을 분리
     * 분리한 토큰들을 이용해 책 객체를 생성
     * 생성한 책 객체를 bookList에 넣어 저장
     * 저장한 값으로 Iterator를 사용해 책DB에 추가
     * 마지막으로 책DB를 리턴
     * 교과서 376장 StringTokenizer, 교과서 489장 FileReader, 교과서 495페이지 Scanner를 이용하여 한 줄 씩 읽기 참고
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
            src.close();
            sc.close();
        }catch(IOException e){
            System.out.println("파일 경로가 올바르지 않습니다.");
        }
        return bookDB;
    }
    
    /*
     * 오류가 날 수 있으니 try-catch 를 사용해 예외처리 진행
     * 전달받은 파라미터값으로 FileReader를 이용해 파일에서 문자를 읽어오는 스트림 객체 생성
     * Scanner 클래스를 이용해서 파일의 내용을 한 줄 단위로 읽음
     * Scanner 클래스를 이용해 만들어진 객체에 다음 내용이 있는 경우를 활용하여 for문 반복
     * 파일에서 읽어드린 한 줄의 문자열을 StringTokenizer를 이용해 "/" 를 기준으로 토큰을 분리
     * 분리한 토큰을 이용해 이용자 객체를 생성
     * 생성한 이용자 객체를 이용자DB에 추가
     * 마지막으로 이용자DB를 리턴
     * 교과서 376장 StringTokenizer, 교과서 489장 FileReader, 교과서 495페이지 Scanner를 이용하여 한 줄 씩 읽기 참고
     */
    public LibDB<User> setUserDB(String userFile){
        String str = "";
        
        try{
            FileReader src = new FileReader(userFile);
            Scanner sc = new Scanner(src);
            for(int i=0;sc.hasNext();i++){
                str = sc.nextLine();
                StringTokenizer stz = new StringTokenizer(str, "/");
                Integer stID = Integer.valueOf(stz.nextToken());
                String name = stz.nextToken();
                User u = new User(name, stID);
                userDB.addElement(u);
            }
            src.close();
            sc.close();
        }catch(IOException e){
            System.out.println("파일 경로가 올바르지 않습니다.");
        }
        return userDB;
    }
}