## ch12. 인터페이스와 추상클래스, 그리고enum
- 인터페이스 : 서로 다른 하드웨어 장치들이 상호 데이터를 주고받을 수 있는 규격.
  -> 만드는 이유? 컴퓨터 메인 보드를 만드는 회사와 주변 장치를 만드는 회사 사잉는 약속이 필요하기 때문.
예) 110v인터페이스인데 어느 회사는 220v인 경우 안맞음.

- 인터페이스 구성 : 5종류의 멤버로 구성, 필드(멤버변수)를 만들 수 X.
 - 상수와 추상 메소드 : public abstract로 정해져있음, 생략O, 다른 접근 지정으로 지정될 수 O
 - default 메소드 : public로 고정되어있음.
 - private 메소드 : 인터페이스 내에서만 호출 가능함.
 - static 메소드 : 접근 지정이 생략되면 public이며, private으로 지정될 수 O.
- 인터페이스 특징 : 
 - 인터페이스는 객체를 생성할 수 X : 구현되지 않은 추상 메소드를 가질 수 있기 때문에 객체를 생성할 수 X
 - 인터페이스 타입의 레퍼런스 변수는 선언 가능함.
 - 인터페이스끼리 상속됨
 - 인터페이스를 상속받아 클래스를 작성하면 인터페이스의 모든 추상 메소드를 구현해야함
- 인터페이스 구현 : implements 키워드 사용해서 함 
- 추상클래스와 비교
추상클래스는 추상메소드와 일반 메소드 모두 포함함, 상수와 변수 필드 모두 포함함
인터페이스는 변수 필드는 포함하지 않음 , 다중 상속 지원함
추상의 목적 - 서브클래스에서 필요하는 하는 대부분의 기능을 구현하여 두고 서브 클래스가 상속받아 활용할 수 있도록 하되, 서브 클래스에서 구현 할 수 밖에 없는 기능만을 추상 메소드로 선언하ㅕㅇ 서브클래스에서 구현하도록 한는 목적 (다형성)

- 서로 유사한 점 : 객체를 생성할 수 없다. 상속을 위한 슈퍼클래스로 사용됨

## ch13. 클래스 안에 클래스가 들어갈 수도 있구나


## ch14. 다 배운 거 같지만, 예외라는 중요한 게 있어요
- 예외 :
 - 예시 ) 정수를 0으로 나누는 경우/ 배열의 크기보다 큰 인덱스로 배열의 원소를 접근하는 경우 / 존재하지 않는 파일을 읽으려고 하는 경우 / 정수 입력을 기다리는 코드가 기다리고 있는데 사용자가 문자를 입력한 경우
- 컴파일 오류 : 문법에 맞지않는 것
- try-catch-finally 문 :
```java
try {
  예외발생할 가능성 있는 실행문}
catch(처리할 예외 타입 선언){
  예외 처리문}
finally{
  예외 발생 여부와 상관없이 무조건 실행되는 문장}
```
- ArithemeticException : 정수 0으로 나눈 경우
- IOException : 입출력 동작 실패 또는 인터럽트 시 발생


1) 인터페이스를 정의하는 키워드는 ? interface 키워드
2) 인터페이스는 다중 상속을 한다? (o,x)
  ->O
3) 인터페이스와 추상클래스의 유사한 점은? 
-> 객체 생성 못함, 상속을 위한 슈퍼 크랠스로 사용됨, 다형성을 실현하기 위한 것
4) 예외의 예시를 하나만 말하세요
-> 정수를 0으로 나누는 경우/ 배열의 크기보다 큰 인덱스로 배열의 원소를 접근하는 경우 / 존재하지 않는 파일을 읽으려고 하는 경우 / 정수 입력을 기다리는 코드가 기다리고 있는데 사용자가 문자를 입력한 경우
5) IOException는 어떤 예외가 발생하는 경우일까?
-> 입출력 동작 실패 또는 인터럽트 시 발생