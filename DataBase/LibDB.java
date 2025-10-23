package DataBase; // 6장: 패키지 선언

import myClass.DB_Element; // 6장: 다른 패키지의 클래스 import
import java.util.ArrayList; // 7장: 컬렉션 프레임워크 (ArrayList)
import java.util.Iterator; // 7장: 컬렉션 프레임워크 (Iterator)


/**
 * LibDB 클래스의 설명을 작성하세요. User객체들이나 Book객체들을 List로 관리하는 제네릭 데이터베이스 클래스입니다.
 *
 * @author (20220320011_김민겸)
 * @version (2025.10.19)
 */


/**
* 제네릭 클래스를 작성하는 방법은 기전의 클래스 작성 방법과
* 교과서 436페이지 제네릭 클래스 참고
*/
public class LibDB<T extends DB_Element>
{
    private ArrayList<T> db;

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

    public void printAllElements()
    {
        for (T element : db)
        { 
            System.out.println(element);
        }
    }
}