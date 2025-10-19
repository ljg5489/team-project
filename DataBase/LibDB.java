package DataBase; // 6장: 패키지 선언

import myClass.DB_Element; // 6장: 다른 패키지의 클래스 import
import java.util.ArrayList; // 7장: 컬렉션 프레임워크 (ArrayList)
import java.util.Iterator; // 7장: 컬렉션 프레임워크 (Iterator)


/**
 * LibDB 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class LibDB<T extends DB_Element> // 7장: '제네릭 클래스' 선언 및 '제한된 타입' (<T extends ...>)
{
    private ArrayList<T> db; // 7장: 제네릭을 사용한 ArrayList 선언

    public LibDB()
    {
        db = new ArrayList<T>();
    }

    public void addElement(T element)
    {
        db.add(element);
    }

    public T findElement(String s)
    {
        Iterator<T> it = db.iterator();
        while (it.hasNext())
        {
            T element = it.next();
            if (element.getID().equals(s))
            {
                return element;
            }
        }
        return null;
    }

    public void printDB()
    {
        System.out.println("--- DB Elements List ---");
        for (T element : db)
        { 
            System.out.println(element); // 6장: println이 객체의 toString()을 자동 호출
        }
        System.out.println("--------------------------");
    }
}