## ch05. 계산을 하고 싶어요
- 연산자 <p>

|연산의 종류|연산자|연산의 종류|연산자|
|---------|--------|--------|----------|
|증감|++ --|비트 |& "|" ^~|
|산술|+ - * / %|논리|&& || ! ^|
|시프트|>> << >>>|조건|? :|
|비교|> < >= <= !=|대입|= *= +=|

- 연산자 순서
  - 우선순위 높은 순서대로
  - ++,+(양수부호),형변환,*,+(덧셈),<<,==,&,^,'|',&&,'|''|'
  
- 증감 연산
  - a++ : a를 1 증가하고 증가전의 값 반환.
  - ++a : a를 1 증가하고 증가된 값 반환.
- 조건 연산
  - 삼항 연산자 : condition ? opr2 : pro3  (조건 ? true : false)
- 비트 논리 연산
  - a&b : and 연산 : 모두 1이면 1,아니면0


## ch06. 제가 좀 조건을 따져요
- for문 :
```java
for(초기문; 조건식; 반복 후 작업) {
    작업문
  }
```
  + 순서 : 1-초기문, 2-조건식, 3-작업문, 4- 반복 후 작업
 
- while문 :
```java
while(조건식) {
    작업문
      }
```
  + 반복 조건이 true면 반복, false면 반복 종료, 조건에 맞는게 없다면 컴파일 오류, 처음부터 반복조건을 통과한 후 작업문 수행

- do while :
```java
  do{
      작업문
  } while(조건식);
```
- if문 :
```java
if(조건식) {
  실행문장
}
```
  + 조건식은 비교연산,논리연산이 혼합된 식으로 결과값은 boolean값. (boolean타입의 변수 하나만으로도 가능함)
- if else :
```java
if(조건식) {
  실행문장1
}
  else   {
  실행문장2
}
```
- 다중 if-else :
```java
if() {}
  else if() {}
  else if() {}
  else{}
```
- switch문 :
```java
switch(식) {
case 값1:
실행문장1;
break;
case 값2:
실행문장2;
break;
default:
실행문장 n;
```

### Q) i = a>b? a-b:b-a;를 if-else 문으로 바꾸면?
-> if(a>b)
i= a-b;
else
i = b-a;

### Q) default문은 생략가능하다(o,x)
->o

### Q) switch문에서 case문의 값은 어떤 리터럴을 허용하나?(3개) 
-> 정수리터럴,문자리터럴,문자열리터럴 ( case문에는 변수(a)나 식(a>3) X )



## ch07. 여러 개를 하나에 넣을 수는 없을까요? 배열~
- 배열(array) : 인덱스(index)에 같은 종류의 데이터들이 순차적으로 저장되는것
- 배열의 선언 및 생성의 단계
  1. 배열에 대한 레퍼런스 변수 선언
  2. 배열생성-배열의 저장 공간 할당
1. 배열에 대한 레퍼런스 변수 선언
```java
int intArray [];
```
( int(배열타입)  intArray(배열에 대한 레퍼런스 변수) [](배열선언) )  <p>
2. 배열 생성
```
intArray = new int [5]
```
( intArray(배열에 대한 레퍼런스 변수) new(배열 생성) int(타입) 5(원소개수) )

- 레퍼런스 변수 : 배열에 대한 주소값을 가지는 변수( 레퍼런스:배열의 주소 )
- 배열 선언 :
```
int intArray[];
int [] intArray;
```
  + 주의 사항 : 배열 선언시 []에 크기를 지정하면 안됨!!
- 배열 생성 : new 연산자 이용.
```
intArray = new int[5];
int intArray[] = new int[5]; //선언과 동시에 생성
```
- 배열 초기화
```
int intArray[] = {4,3,2,1,0};
```

- 배열의 인데스 : 정수만 가능, 0부터 시작함
- 배열 공유: 다수의 레퍼런스 변수가 하나의 배열 공간을 가리키는 것.
```java
int intArray[] = new int[5];  //예시
int myArray[] = intArray;  //치환
```
- 배열의 크기 : length 필드를 이용해 배열의 크기를 알 수 있음
```java
int intArry [] = new int [5];
int size = intArray.length;
```

- for-each문 : 
```
int [] num = {1,2,3,4,5};
int sum=0;
for(int k : num)  //num이 배열자리, k는 n[0], n[1]...n[4]로 반복
  sum +=k;
Systerm.out.println("합은 "+sum);  //합은 15
```
- 2차원 배열 선언
```
int intArray[][];   //방법1
char charArray[][];
int[][] intArray;  //방법2
```
- 2차원 배열 생성
```
intArray = new int[2][5];  //방법1
int intArray[][] = new int[2][5];  //방법2
```
- 2차원 배열 선언, 생성, 초기화
```
int intArray[][] = {{0,1,2},{3,4,5},{6,7,8}};
```
### Q) 2차원 배열의 length
```
int i[][] = new int[2][5];  //
```
- i.length 몇일까? ->2차원 배열의 행의 개수로서 2
- i[0].length 는 몇일까? -> 0번째 행의 열의 개수로서 5
- i[1].length 는 몇일까? -> 1번째 행의 열의 개수로서 5

- ArrayList : 배열의 크기가 자동으로 변경되는 배열
  + ex) add(),get(i),remove(), set()
  + get(i) :  요소값밖에 못옴
- ArrayList<String> list = new ArrayList<>();
  + Sting : 자료형 못옴, int (X), Integer (O), 클래스밖에 못옴
  + ex) list.add("철수");
  + ex) String name = list.get(0);
  + ex) list.remove(0);  //1번째 요소 삭제
## ch08. 참조 자료형에 대해서 알아봅시다.
- 열거 : 한정된 값만을 갖는 자료형. 주로 상수들의 묶음으로 쓰임
```
publi enum Week {
  MON,TUE,WED,THR,FRI,SAT,SUN
}
```
```
Week today;  //열거 변수 선언
Week today = Week.SUN;  //열거 변수에 상수 저장
```java
- 열거형 메소드
  + valueOf() : 인자는 주로 문자열과 동일한 문자열을 열거 객체에서 가져옴
    ```java
    Week today = Week.valueOf("SUN");
    ```
  + values() : 열거형의 모든 열거 객체들을 배열로 만들어 리턴함.
  + name() : 열거 객체가 가지고 있는 문자열을 리턴함.
  + ordinal() : 전체 열거 객체 중 몇 번째 열거 객체인지 알려줌.
  ```java
  for(Week today : Week.valus())  {
    System.out.println(today.name()+"의 순서는 "+today.ordinal());
  }
  ```

