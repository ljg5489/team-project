package myClass;


/**
 * DB_Element 클래스의 설명을 작성하세요. User클래스외 Book클래스의 슈퍼 클래스가 되는 추상 클래스입니다.
 *
 * @author (20220320011_김민겸)
 * @version (2025.10.19)
 */


/**
 * 추상 클래스가 되는 경우는 모두 abstract 키워드로 선언해야 한다.
 * 교과서 297페이지 추상 클래스 만들기 참고
 */
public abstract class DB_Element
{
    /**
     * 추상 메소드란 선언은 돼있으나 코드가 구현되지 않은 껍데기만 있는 메소드
     * 교과서 296페이지 추상 메소드 참고 
     */
    public abstract String getID(); 
}