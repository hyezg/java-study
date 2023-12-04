## Ch07. 자바랭 다음으로 많이 쓰는 얘들은 컬렉션-Part3 (Map)
##### <Map이란?> <br>
- Map 컬렉션 클래스 : Map인터페이스는 구현한 Map컬렉션 클래스들은 키와 값을 하나의 쌍으로 저장하는 방식을 사용함(Map은 인터페이스로 선언되어 있고, Map interface 구현체로는 HashMap,TreeMap,LinkedHashMap)
  키 = 값을 찾기 위한 이름의 역할
- map : Key와 Value 한쌍으로 이루어진 자료형ㅇ. 리스트나 배열처럼 순차적으로 해당 요소 값을 구하지 않고 key를 통해 value를 얻음.
- 특징 : 요소의 저장 순서를 유지하지 않음.
  + key: 중복 허용X 고유한값O (키를 통해 값을 얻어내기 때문에) / value(값): 중복 허용 O.
  + Key에 해당하는 값이 이미 존재하면 값 갱신함.
- put 메소드 : 
<Map을 구현한 주요 클래스들을 살펴보자> <br>
- put(Object key, Object value): key에 해당되는 value객체를 저장
  putAll(Map m)  <br>
- value get() : key에 해당되는 value 반환 
- remove() : key에 해당하는 value 삭제
- void clear() : map의 모든 객체를 삭제
- boolean isEmpty() : map이 비어있는지 확인
- Set keySet() : map에 저장된 모든 값들을 collection으로 반환
- boolean contatinsKey() : map에 지정된 key가 있는지 boolean으로 반환
- boolean containsValue() : map에 지정된 value가 있는지 boolean으로 반환
- int size() : map에 저장된 객쳉의 갯수
```java
map1.put("a","A");
map1.get("a"); //A
```
##### <HashMap 클래스에 대해서 자세히 살펴보자> <br>
- HashMap :  키나 값에 null 저장O (Hash Table 방식 사용)
- key를 index로 변경하여 데이터를 접근
- Hash Table 자료구조 :
![image](https://github.com/hyezg/java-study/assets/112006114/50480992-cc50-433d-85ac-09d4fb704bac)
  + 특정 key는 해시 함수를 통하영 bucket에 접근할 수 있는 index로 변환됨.
  + index를 이용하여 bucket에 접근함.
  + bucket에 맞는 index에 key와 value를 저장함.
(ArrList와 LinkeddList는 index를 통해 데이터를 접근한다고 본다면 Hahsh Table은 Key를 index로 변경하여 데이터를 접근함.)
- key가 해시함수를 통해서 key에 대한 index가 만들어지고 index를 통하여 bucket에 접근하기 때문에 저장되는 데이터가 많을수록, bucket의 크기가 적을 수록 index 충돌이 발생할 가능성이 높음.

  - bucket은 배열 기반 구조임/ 충분히 큰 데이터를 가지고 있을 겨웅, 충돌시 entry의 저장방식을 LinkedList->TreeNode로 변경함.
  - 장점 : key가 index로 변환되어 bucket에 대응하는 곳에 저장하기 때문에 값을 검색하는 것은 선형적으로 접근하는 ArrayList나 LinkedList 대비 더 빠름 / key를 null 값으로 할 일은 별로 없지만 null key가 가능함.
  - 단점 : bucket의 크기가 가득 차서 크기 조정이 필요할 경우 더 큰 해시맵으로 변경되기 때문에 지연시간이 걸릴 수 있음/ 데이터를 저장하는데 필요한 메모리보다 더 많은 메모리를 필요로 함/ HashMap에 저장된 key를 추출했을 때, 정렬되지 않음.
  - 사용용도 : index가 아닌 key를 이용하여 데이터 저장과 접근이 필요할 경우 사용함/ 데이터의 크기가 어느 정도 예상되는 경우 사용함/ 삽입 삭제가 빈번할 경우 사용함.
<HashMap 객체에 값을 넣고 확인해보자> <br>
- 값 넣기 : put()
- 
<HashMap 객체의 값을 확인하는 다른 방법들을 알아보자> <br>
- 값 확인 : get()
<정렬된 키의 목록을 원한다면 TreeMap을 사용하자> <br>
- TreeMap : Key를 기준응로 정렬하는 것. (숫자 -> 알파벳 대문자 -> 알파벳 소문자 -> 한글)
- firstKey() :
- lastKey() :
- higherKey() :
- lowerKey() :
- 
<Map을 구현한 Properties 클래스는 알아두면 편리하다> <br>
- Properties : hashtable을 상속받아 구현한것으로 (String,String)형태로 저장하는 단순화된 컬렉션클래스. 데이터를 파일로 읽고 쓰는 편리한 기 제공함
- 메서드 :
  + Properties() : 객체 생성
  + void setProperty(String key, String value) : key에 해당되는 value 객체를 저장
  + String getProperty(String key) : key에 해당하는 String형 value 반환
  + Enumeration<Object> keys() : Properties에 저장되있는 모든 key를 enumeration<object>로 반환
  + Set<Object> keySet() : properties에 저장되어 있는 모든 key를 Set<Object>로 반환
  + Collection<Object> values() : properties에 저장되어 있는 모든 value를 Collection<Object>로 반환
 + boolean replace(key, oldValue) : key에 해당하는 value값인 olValue를 newValue로 변환 해당하는 key객체가 있으면 true, 없으면 false
<자바의 자료구조를 정리해보자>


## Ch08. 그 다음으로 많이 쓰는 얘들은 자바 유틸
<java.lang 다음으로 많이 사ㅛ되는 java.util 패키지> <br>
- List,Map,Set,Collection 등 클래스들 있음
- Collection framework : 자료구조 클래스들
- interface collection interface 중복O,순서 기억 못함
- add() : 자료 추가해줌
- iterator(): 자료 하나씩 꺼내기위한 메소드
- size() : 저장된 자료의 수 반환하는 메소드
  
- Set : collection interface를 상속받는 클래스. 중복X,순서X
- list : 중복O,순서O 저장공간이 필요에 따라 자유롭게 변경
- Map : key value가지는 자료구조, key는 중복X,순서X

  
<날짜를 처리하기 위한 Date와 Calender> <br>
- Calndar : 기존 date클래스는 지역화를 지원안함. (지역화 : 국가별로 현재 날짜와 시간을 다를 수 있고 부분 지원하는 것)

<컬렉션 객체들의 도우미 Collections> <br>
- Collection list,set,collection,map 자료구조 포함함
- collection 인터페이스 : collection 프레임워크에서 가장 기존이 되는 인터페이스
  - 중복O,자료 저장 순서 기억X,
  - iterator를 활용해 찾아냄 
  - iterator interface :
    + hashNext() : boolean 반
    + next() : Object
  + - 대표메서드 : add(),size(),iterator()
- 
<배열을 쉽게 처리해주는 Arrays> <br>

<임의의 값을 생성하기 위한 Random> <br>
- Random 클래스 사용
```java
import java.util.Random;
Ranodm r = new Random();
// Random random1 = new Random(4) //seed 지정해서 생성
int value = r.nextInt(10);
//int randomValueWithRange = random.nextInt(max - min) + min; // 난수 범위 지정하는 법
```
- nextInt(int i) : 0부터 i까지 랜덤한 숫자 리턴함
- nextInt() : int 타입의 최소~최대범위 안에서 랜덤한 숫자 리턴함
- nextBoolean() : boolean타입의 true,false 랜덤한 값 리턴함
- 특징 : 유사 난수가 생서될 수 있
<문자열을 자르기 위한 String Tokenzior> <br>

<java.math 패키지의 BigDecimal 클래스를 활용하자> <br>
