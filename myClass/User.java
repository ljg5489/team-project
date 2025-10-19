package myClass; // 6장: 패키지 선언


/**
 * User 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class User extends DB_Element
{
    private String name; // 6장: 기본 타입이 아닌 'Wrapper 클래스' 사용
    private Integer stID;

    public User(String name, Integer stID)
    {
        this.name = name;
        this.stID = stID;
    }

    public String getID()
    {
        return this.stID.toString();
    }
    // 6장: Object 클래스의 'toString()' 메소드 오버라이딩
    public String toString()
    {
        return "[" + this.stID + "] " + this.name;
    }
}