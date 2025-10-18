<<<<<<< HEAD
import java.io.*;
import java.util.*;
/**
 * App 클래스의 설명을 작성하세요.
 *
 * @author (2022320005 이진규)
 * @version (2025.10.18)
 */
public class App
{
    /**
     * main 메소드 - 도서관관리시스템의 메인 실행 메소드입니다.
     *
     */
    public static void main(String[] args)
    {
        LibraryManagementSystem lbMS = new LibraryManagementSystem();
        
        HashMap<User,Book> loanDB = new HashMap<>();
        
        lbMS.setUserDB("C\\Temp\\UserData2025.txt");
        
        lbMS.printDB(userDB);
        
        lbMS.setBookDB("c\\Temp\\BookData2025.txt");
        
        lbMS.printDB(userDB);
        
        lbMS.borrowBook("2025230001","B02");
        
        lbMS.printLoanList();
        
    }
=======

/**
 * App 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class App
{
    
>>>>>>> b020fd619e788afea889dc141c54c8ce0d7143db
}