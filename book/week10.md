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
- stack : 데이터를 순서대로 쌓는 자료구조. 후입선출 구조(LIFO : Last in First Out)
- 특징 : 단방향 입출력 구조(한쪽에서 들어옴)
 + 깊이 우선 탐색(DFS)에 이용됨
 + 재귀 함수의 동작 흐름과 같은 구조를 가짐
 + 공격을 받으면 스택 메모리 영역에서함(?)
- 선언
-
```java
//선
import java.util.Stack; //import
Stack<Integer> stack1 = new Stack<>();
//값 추가
stackInt.push(1); 
stackInt.push(2);
stackInt.push(3);
// 값 제거
stackInt.pop(); 
stackInt.pop();
stackInt.pop(); //3,2,1 순으로 값 제거
//값 추가
stackInt.push(1); // 1,2,3 순으로 값 추가
stackInt.clear(); //값 모두 제거 (메서드 반환 값X)
```
- peek() : 스택의 마지막 요소를 반환함. (스택에 변화안줌), 스택이 비어있을 경우 peek()호출 시 예외 발생함
- pop() : 스택의 마지막 요소 제거함과 동시에 해당 값 반환함.
- empty() : 스택이 비어있는지의 여뷰를 반환함. 비어있을 경우 true, 비어있지 않을 경우 false
- search() : 메서드의 인자를 스택에서 검색하여 해당 위치를 반환함. 해당 인자가 여러 개일 경우 마지막 위치를 반환함.
  (위치:빠져나오는순서, 거꾸로 생각해야)
```java
stackInt.peek();
stackInt.pop();
stackInt.isEmpty();
stackInt.search(2); // 뒤에서 두번째
stack.size();     // 크기 출력
stack.contains(1) // 스택에 1검색 후 있다면 true, search와 비슷
```

## ch06. 자바랭 다음으로 많이 쓰는 얘들은 컬렉션-Part-1(Set,Queue)
##### <Set이 왜 필요하지?>
- set : HashSet: 중복x 순서x, TreeSet: 오름차순으로 데이터 정렬함, LinkeddHashSet : 중복X, 입력한 순서대로 저장함
- 특징 :
  + 중복 저장 허용X, 하나의 null값만 저장가능.
  + 순서없음(HashSet은 순서 바뀔 수도 O)
  + 빠른 액세스 시간
  + 인터페이스로 직접 생성해서 사용X. 클래스로 구현해서 사용해야
  + Indexing 없음 : Array,List같은 인덱싱 제공안함. 인덱스 없다는뜻거의
  + primitive type 없음 : set은 객체만 저장하고 primitive type은 저장안함. (Integer,String 등 클래스 사용해야함, int 안됨)

##### <HashSet에 대해서 파헤쳐 보자>
- HashSet : 데이터 중복할 수 x, 순서 보장X, null허용
- 

```java
Set<String> color = new HashSet<>();
set.add("red");
System.out.println(color); // 순서없이 요소 출력
```

##### <HashSet의 생성자들도 여러 종류가 있다>

##### <HashSet의 주요 메소드를 살펴보자>
```java
color.add("yellow"); // 내부에  "yellow "값이 존재하지 않는다면 그값을 추가하고 true 반환함 존재하면 false 반환함
color.size(); //
//요소 값 삭제
color.remove(2); //
color.clear(); //
//요소 값 검색
color.contains("red");
//요소 값 출력
System.out.println(color);	// 출력 : ["yellow","red"]
Iterate iter = color.iterator() ;
While(iter.hashNext()) {	//hashNext() : 가져올 객체가 있다면 true 없다면 false 리턴
	System.out.println(iter.next()); // 출력 : yellow,red 
}
```


##### <Queue의 주요 메소드를 살펴보자>
- Queue : 선입 선출(FIFO:First In First Out)
```java
import java.util.Queue; //선언
Queue<Integer> q = new LinkedList<>();
// 삽입
q.add(2); //삽입 성공시 true, 아니면 Exception 발생
q.offer(1); // 삽입 성공시 true 아니면 false
q.poll(); // 삭제된 value 공백 큐면 null 반환
//value 반환
q.element(); // 큐 head에 위치한 value, 공백 큐면 예외 발생
q.peek(); // 큐 head에 위치한 value, 공백 큐면 null 반환
//큐 초기화
q.clear(); // 반환값 X.
//큐 크기
q.size();
//원소 찾기
q.contains(value); //있으면 true 없으면 false
//공백 큐인가?
q/isEmpty(); //맞으면 true, 아니면 false
```


##### <LinkedList를 파헤쳐보자>
- LinkedList : ArrayList와 같이 인덱스로 접근하여 조회함, 삽입 가능하지만 내부 구조는 완전히 다르게 구성됨,
- LinkedList와 ArrayList 의 차이점 : arraylist는 배열을 이용하여 메서드로 조작하지만 linkedlist는 노드끼리 주소 포인터를 서로 가리키며 링크(참조)함으로써 이어지는 구조/ linkedlist는 초기값을 미리 지정할 수 o.
- 특징 : 노드=객체, 객체를 만들면 객체의 주소가 생기고, 노드마다 객체의 주소를 서로 참조함으로써 연결 형태를 구성함.
![image](https://github.com/hyezg/java-study/assets/112006114/77a3aa84-b9ab-445e-9b11-e40b3327fbde)
- 종류 : 단방향 연결 리스트/ 양방향 연결 리스트 / 양방향 원형 연결 리스트
- 단방향 연결 리스트 : 다음 노드를 가리키기 위한 포인터 필드 next만을 가지고 있는 링크드 리스트. 현재요소에서 이전 요소로 접근해야할 때 매우 부접합한 특징
- 양방향 연결 리스트 : 기존의 단일 연결 노드 객체에서 이전 노드 주소를 담고있는 필드가 추가된 형태. 역순으로도 검색 가능함
- 양방향 원형 연결 리스트 : 첫번째 노드와 마지막 노드를 각각 연결시켜, 마치 원형 리스트 처럼 만든것. 티비채널,오디오플레이어같이 데이터를 순차적 방식으로 처리하는것.


##### <LinkedList의 생성자와 주요 메소드를 살펴보자>
- 생성자 :
 + LinkedList() : 링크드리스트 객체 생성
 + LinkedList(Collection c) : 주어진 컬렉션을 포함하는 링크드리스트 객체 생성
```java
LinkedList<Integer> list = new LinkedList; // int 타입 
LinkedList<Integer> list2 = new LinkedList<Integer>(Arrays.asList(1,2)); // 생성시 초기값 설정
```
- 초기값 설정 : 내부 데이터 집합 구조가 배열처럼 미리 공간을 할당하고 사용하는 방식이 아니라 데이터가 추가될 때마다 노드(객체)들이 새서되어 동적으로 추가되는 방식이기때문.

  
##### 퀴즈
Q) set의 특징은? <br>
A)
  + 중복 저장 허용X, 하나의 null값만 저장가능.
  + 순서없음(HashSet은 순서 바뀔 수도 O)
  + 빠른 액세스 시간
  + 인터페이스로 직접 생성해서 사용X. 클래스로 구현해서 사용해야
  + Indexing 없음 : Array,List같은 인덱싱 제공안함. 인덱스 없다는뜻거의
  + primitive type 없음 : set은 객체만 저장하고 primitive type은 저장안함. (Integer,String 등 클래스 사용해야함, int 안됨)

Q) stack은 너비우선탐색(BFS)이다? <br>
A) X <br>
Q) stack에서 stackInt.search(2)는 무엇? <br>
A) 뒤에서 2번째를 찾는 것 <br>
Q) LinkedList와 ArrayList의 차이점? <br>
A) arraylist는 배열을 이용하여 메서드로 조작하지만 linkedlist는 노드끼리 주소 포인터를 서로 가리키며 링크(참조)함으로써 이어지는 구조/ linkedlist는 초기값을 미리 지정할 수 o. <br>
Q) LinkedList는 초기값을 지정할 수 있는데 이유는? <br>
A)내부 데이터 집합 구조가 배열처럼 미리 공간을 할당하고 사용하는 방식이 아니라 데이터가 추가될 때마다 노드(객체)들이 새서되어 동적으로 추가되는 방식이기때문.
