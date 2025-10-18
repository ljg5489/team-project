package myClass;

import java.util.ArrayList;
import java.util.Iterator;

// 7장: <T>를 사용한 '제네릭 클래스' 선언
// 7장: <T extends DB_Element> '제한된 제네릭 타입' 선언
public class LibDB<T extends DB_Element>
{ 
    // 7장: 타입 매개변수 'T'를 사용한 제네릭 컬렉션 선언
    private ArrayList<T> db;

    public LibDB()
    {
        // 7장: 제네릭 타입 <T>로 ArrayList 객체 생성
        db = new ArrayList<T>();
    }

    public void addElement(T element)
    {
        // 7장: ArrayList의 add 메소드로 요소 추가
        db.add(element);
    }

    // 7장: 제네릭 타입 'T'를 반환 타입으로 사용
    public T findElement(String s)
    {
        // 7장: 'Iterator' 객체 생성 (db.iterator() 호출)
        Iterator<T> it = db.iterator();
        
        // 7장: 'Iterator'의 hasNext() 메소드를 이용한 루프
        while (it.hasNext())
        {
            // 7장: 'Iterator'의 next() 메소드로 다음 요소 가져오기
            T currentElement = it.next();
            // 6장: 'String 클래스'의 equals() 메소드로 문자열 비교
            if (currentElement.getID().equals(s))
            {
                return currentElement;
            }
        }
        return null; // 못 찾으면 null 반환
    }
    public void printAllElements()
    {
        System.out.println("--- 전체 데이터베이스 출력 ---");
        // 7장: 요구사항에 맞게 'Iterator'를 사용하여 전체 순회
        Iterator<T> it = db.iterator();
        while (it.hasNext())
        {
            T currentElement = it.next();
            // 6장: System.out.println이 객체의 'toString()' 메소드를 자동 호출
            System.out.println(currentElement);
        }
        System.out.println("---------------------------");
    }
}