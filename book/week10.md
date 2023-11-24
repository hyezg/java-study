## Part 2.
## ch05. 자바랭 다음으로 많이 쓰는 얘들은 컬렉션-Part-1(List)
##### <List 인터페이스와 그 동생들>
- List 인터페이스 : 중복 허용, 저장 순서 유지되는 컬렉션을 구현하는데 사용됨, 데이터를 일렬로 늘어놓은 구조임(배열과 비슷)
- 공통점 : 동일한 특성의 데이터를 묶음
- list : 길이가 가변적임(동적할당), 데이터들이 연속적으로 나열됨, 데이터 사이에 빈 공간을 허용하지 않음
- 메소드 :
![image](https://github.com/hyezg/java-study/assets/112006114/d39dcfd4-ec06-46f6-9574-13b1746e7ebb)
(출처 : https://st-lab.tistory.com/146)
##### <ArrayList에 대해서 파해쳐보자>
- ArrayList : 배열을 구현할 컬렉션 클래스로 경로명은 java.util.ArrayList(java.lang이 아닌 util이라서 첨에 import 해줘야함), Vector와 비슷함.
- 특징 :
- 데이터의 저장 순서 유지, 중복 값 허용(인터페이스를 구현하기때문에)
- 스레드 간에 동기화를 지원하지 않음 -> 다수의 스레드가 동시에 ArrayList에 요소를 삽입하거나 삭제할 때 ArrayList의 데이터가 훼손될 수 O.
-  객체의 내부 구성을 보여줌, 내부에 배열을 가지고 있으며 배열을 가변크기로 관리함.
-  인덱스로 요소를 접근할 수 O. (인덱스는 0부터시작함)
-  Vector와의 차이점 : Vector보다 속도가 빠름/ 단일 스레드 응용에 효과적/ 현재 용량을 리턴하는 메소드 없음/ 동적메모리임
  (* 동적메모리 : 인덱스 칸 아라서 늘이고 줄임, 몇칸인지 선언할 필요 X)
- 배열과 ArrayList 의 차이 : 배열은 길이에 제한을 두어야 할 때 사용됨, ArrayList는 몇개인지 모를 때 사용함. 
```java
import Interface_form.List;
 
public class ArrayList<E> implements List<E> {
 
	private static final int DEFAULT_CAPACITY = 10;	// 최소(기본) 용적 크기 
	private static final Object[] EMPTY_ARRAY = {};	// 빈 배열
    
	private int size;	// 요소 개수 
 
	Object[] array;	// 요소를 담을 배열 
 
	// 생성자1 (초기 공간 할당 X)
	public ArrayList() {
		this.array = EMPTY_ARRAY;
		this.size = 0;
 
	}
 
	// 생성자2 (초기 공간 할당 O)
	public ArrayList(int capacity) {
		this.array = new Object[capacity];
		this.size = 0;
	}
}
```
(출처 : https://st-lab.tistory.com/161#%ED%81%B4%EB%9E%98%EC%8A%A4)

- DEFAULT_CAPACITY : 배열이 생성될 때의 최초 할당 크기(용)이자 최소 할당 용적 변수로 기본값은 10으로 설정해둠.
- EMPTY_ARRAY : 아무것도 없는 빈 배열(용적이 0인 배열)
- size : 배열에 담긴 요소의 개수 변수(용적 크기 아님)
- array : 요소들을 담을 배열 


##### <ArrayList의 생성자는 3개다>
- ArrayList() : 기본 크기가 10인 배열 생성함
- ArrayList(크기지정) : 크기를 지정함
- ArrayList<제네릭>() : 배열 값의 타입을 지정
##### <ArrayList에서 데이터를 담아보자>
- add() 메소드 : String타입의 문자열을 넣을 수 있음,null도 가능함(객체나, 값 X)
```java
a.add("Hi");
a.add(2,"apple"); //중간에 요소 삽입가능
-boolena
```

##### <ArrayList에서 데이터를 꺼내자>
- get() 메소드 : 요소를 알아낼 수 O.
- elementAt() 메소드 :
```java
String str = a.get(1); // 인덱스1의 값 리턴함
```
- 크기 알아내기 : size() 메소드 사용
- 요소 삭제하기 : remove() 메소드
```java
int len = a.size(); // ArrayList에 들어있는 요소의 개수
a.remove(1); // 인덱스 1의 위치의 요소 삭제함
```
##### <Stack 클래스는 뭐가 다른데?>



## ch06. 자바랭 다음으로 많이 쓰는 얘들은 컬렉션-Part-1(Set,Queue)
##### <Set이 왜 필요하지?>

##### <HashSet에 대해서 파헤쳐 보자>

##### <HashSet의 생성자들도 여러 종류가 있다>

##### <HashSet의 주요 메소드를 살펴보자>

##### <Queue의 주요 메소드를 살펴보자>

##### <LinkedList를 파헤쳐보자>

##### <LinkedList의 생성자와 주요 메소드를 살펴보자>
