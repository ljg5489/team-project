import java.util.*;
import myClass.*;
import DataBase.*;
/**
 * App 클래스의 설명을 작성하세요.
 *
 * @author (2022320005 이진규)
 * @version (2025.10.18)
 */
public class App
{
    /**
     * main 메소드 - 도서관관리시스템의 메인 실행 메소드로 myClass 패키지와 DataBase 패키지, 
     *              LibraryManagementSystem Class를 활용해 이용자와 책을 등록하고 대출을 진행합니다.
     * 강의 자료 7장 31페이지 HashMap 참고
     */
    public static void main(String[] args)
    {
        LibraryManagementSystem lbMS = new LibraryManagementSystem();
        HashMap<User,Book> loanDB = new HashMap<>();
        
        LibDB userDB = lbMS.setUserDB("C:/Temp/UserData2025.txt");
        System.out.println("----- 이용자 목록 출력 -----");
        lbMS.printDB(userDB);
        
        LibDB bookDB = lbMS.setBookDB("C:/Temp/BookData2025.txt");
        System.out.println("----- 책 목록 출력 -----");
        lbMS.printDB(bookDB);
        
        lbMS.borrowBook("2025320001","B02");
        lbMS.borrowBook("2024320002", "B03");
        lbMS.borrowBook("2023320003", "B04");
        System.out.println("----- 대출 현황 -----");
        lbMS.printLoanList();
        System.out.println("--------------------");
    }
}