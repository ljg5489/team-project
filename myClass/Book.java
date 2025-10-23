package myClass; // 6장: 패키지 선언


/**
 * Book 클래스의 설명을 작성하세요. DB_Element클래스를 상속받고 도서관 '책' 한 권의 정보를 저장하는 데이터 클래스입니다.
 *
 * @author (20220320011_김민겸)
 * @version (2025.10.19)
 */


/**
 * 상속을 선언할 때 확장한다는 뜻을 가진 extends 키워드 사용
 * 교과서 258페이지 자바의 상속 선언 참고
 */
public class Book extends DB_Element
{
    private String author;
    private String bookID;
    private String publisher;
    private String title;
    private int year;

    /**
     * this는 현재 실행되고 있는 메소드가 속한 객체에 대한 레퍼런스
     * 교과서 197페이지 this의 필요성 참고
     */
    public Book(String author, String bookID, String publisher, String title, int year)
    {
        this.author = author;
        this.bookID = bookID;
        this.publisher = publisher;
        this.title = title;
        this.year = year;
    }

    /**
     * 슈퍼 클래스에 선언된 모든 추상 메소드를 서브 클래스에서 오버라이딩라여 싱행 가능한 코드로 구현하는 것
     * 교과서 299페이지 추상 클래스 구현과 목적 참고
     */
    public String getID()
    {
        return this.bookID;
    }
    /**
     * toString메소드는 객체의 클래스의 이름을 얻어 와서 객체의 해시코드 값을 16진수로
     * 변환하여 연결하는 문자열 리런
     * 교과서 353페이지 객체를 문자열로 변, toString()메소드 참고
     */
    public String toString()
    {
        return "(" + this.bookID + ") " + this.title + ", " + this.author + ", " + this.publisher + ", " + this.year;
    }
}