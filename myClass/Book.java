package myClass; // 6장: 패키지 선언


/**
 * Book 클래스의 설명을 작성하세요. DB_Element클래스를 상속받고 도서관 '책' 한 권의 정보를 저장하는 데이터 클래스입니다.
 *
 * @author (20220320011_김민겸)
 * @version (2025.10.19)
 */
public class Book extends DB_Element
{
    private String author;
    private String bookID;
    private String publisher;
    private String title;
    private int year;

    public Book(String author, String bookID, String publisher, String title, int year)
    {
        this.author = author;
        this.bookID = bookID;
        this.publisher = publisher;
        this.title = title;
        this.year = year;
    }

    public String getID()
    {
        return this.bookID;
    }
    // 6장: Object 클래스의 'toString()' 메소드 오버라이딩
    public String toString()
    {
        return "(" + this.bookID + ") " + this.title + ", " + this.author + ", " + this.publisher + ", " + this.year;
    }
}