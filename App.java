import java.util.*;
import LibraryManagementSystem;
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
        System.out.println("----- 이용자 목록 출력 -----");
        lbMS.printDB(userDB);
        
        lbMS.setBookDB("c\\Temp\\BookData2025.txt");
        System.out.println("----- 책 목록 출력 -----");
        lbMS.printDB(userDB);
        
        lbMS.borrowBook("2025230001","B02");
        lbMS.borrowBook("2024320002", "B03");
        lbMS.borrowBook("2023320003", "B04");
        System.out.println("----- 대출 현황 -----");
        lbMS.printLoanList();
        System.out.println("--------------------");
    }
}