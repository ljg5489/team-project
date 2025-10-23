package DataBase; 

import myClass.DB_Element; 
import java.util.ArrayList; 
import java.util.Iterator; 

/**
 * LibDB 클래스의 설명을 작성하세요. User객체들이나 Book객체들을 List로 관리하는 제네릭 데이터베이스 클래스입니다.
 *
 * @author (20220320011_김민겸)
 * @version (2025.10.19)
 */


/**
* 제네릭 클래스를 작성하는 방법은 기전의 클래스 작성 방법과 유사한데,
* 클래스 이름 다음에 일반화된 타입의 매개변수를 <> 사이에 추가한다는 차이가 있다
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
        /**
         * 저장된 컬렉션에서 요소를 순차 검색할 때 java.util 패키지의 Iterator<E> 인터페이스를 사용하면 편리하다
         * 교과서 422페이지 컬렉션의 순차 건색을 위한 Iterator 참고
         */
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
        /**
         * 배열이나 나열의 크기만큼 루프를 돌면서 각 원소를 순차적으로 접근하는데 유용하게 만든 for문을 for-each문
         * 교과서 137페이지 배열과 for-each문 참고
         */
        for (T element : db)
        { 
            System.out.println(element);
        }
    }
}