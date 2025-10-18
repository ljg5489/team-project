package myClass;


/**
 * User 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class User extends DB_Element
{
    private String name;
    // 6장: 기본 타입 int가 아닌 'Wrapper 클래스' Integer 사용
    private Integer stID;

    public User(String name, Integer stID)
    {
        this.name = name;
        this.stID = stID;
    }

    public String getID()
    {
        // 6장: Wrapper 클래스(Integer)의 메소드(toString) 사용
        return this.stID.toString();
    }

    public String toString()
    {
        // 6장: 모든 클래스의 최상위 부모인 'Object 클래스'의 toString() 메소드를 '오버라이딩'
        return "User [학번: " + stID + ", 이름: " + name + "]";
    }
}