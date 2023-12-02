## Ch07. 자바랭 다음으로 많이 쓰는 얘들은 컬렉션-Part3 (Map)
<Map이란?> <br>
- Map 컬렉션 클래스 : Map인터페이스는 구현한 Map컬렉션 클래스들은 키와 값을 하나의 쌍으로 저장하는 방식을 사용함(Map은 인터페이스로 선언되어 있고, Map interface 구현체로는 HashMap,TreeMap,LinkedHashMap)
  키 = 값을 찾기 위한 이름의 역할
- map : Key와 Value 한쌍으로 이루어진 자료형ㅇ. 리스트나 배열처럼 순차적으로 해당 요소 값을 구하지 않고 key를 통해 value를 얻음.
- 특징 : 요소의 저장 순서를 유지하지 않음.
  + key: 중복 허용X 고유한값O (키를 통해 값을 얻어내기 때문에) / value(값): 중복 허용 O.
  + Key에 해당하는 값이 이미 존재하면 값 갱신함.
- put 메소드 : 
<Map을 구현한 주요 클래스들을 살펴보자> <br>
- put() : 
- get() : 
- remove() :
```java
map1.put("a","A");
map1.get("a"); //A
```
<HashMap 클래스대해서 자세히 살펴보자> <br>
- HashMap :  키나 값에 null 저장O (Hash Table 방식 사용)
- key를 index로 변경하여 데이터를 접근
- 자료구조 :
  + 특정 key는 해시 함수를 통하영 bucket에 접근할 수 있는 index로 변환됨.
  + index를 이용하여 bucket에 접근함.
  + bucket에 맞는 index에 key와 value를 저장함.
- 
<HashMap 객체에 값을 넣고 확인해보자> <br>

<HashMap 객체의 값을 확인하는 다른 방법들을 알아보자> <br>

<정렬된 키의 목록을 원한다면 TreeMap을 사용하자> <br>
- TreeMap : Key를 기준응로 정렬하는 것. (숫자 -> 알파벳 대문자 -> 알파벳 소문자 -> 한글)
- firstKey() :
- lastKey() :
- higherKey() :
- lowerKey() :
- 
<Map을 구현한 Properties 클래스는 알아두면 편리하다> <br>

<자바의 자료구조를 정리해보자>


## Ch08. 그 다음으로 많이 쓰는 얘들은 자바 유틸
<java.lang 다음으로 많이 사ㅛ되는 java.util 패키지> <br>
<날짜를 처리하기 위한 Date와 Calender> <br>
<컬렉션 객체드르이 도우미 Collections> <br>
<배열을 쉽게 처리해주는 Arrays> <br>
<임의의 값을 생성하기 위한 Random> <br>
<문자열을 자르기 위한 String Tokenzior> <br>
<java.math 패키지의 BigDecimal 클래스를 활용하자> <br>
