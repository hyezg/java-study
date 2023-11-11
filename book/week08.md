## ch16. 클래스 안에 클래스가 들어갈 수도 있구나
- 클래스 안의 클래스 - 내부 클래스 :외부 클래스와 내부 클래스가 연관되어 있을 때, 사용성을 높이기 위한 수단.
 - 종류 :
   - 인스턴스 내부 클래스 : 외부 클래스의 멤버 선언위치에 선언해야하며, 외부 인스턴스 변수와 외부 전역 변수를 사용할 수 O.
      + 정적 변수, 정적 메서드는 인스턴스 내부 클래스에서 선언할 수 X.
      + 객체 내부에 멤버의 형태로 존재함.
      + 외부 클래스의 모든 접근 지정자의 멤버에 접근할 수 O.
```java
class OuterClass {
    private String str1 = "외부 클래스 인스턴스 변수입니다.";
    private static String str2 = "외부 클래스 정적 변수입니다.";

    private InnerClass innerClass; // 내부 클래스 변수 선언

    // 외부 클래스 생성자
    public OuterClass() {
        innerClass = new InnerClass();
    }

    // 인스턴스 내부 클래스
    class InnerClass {
        String innerStr1 = "내부 클래스 인스턴스 변수입니다.";
        // static String innerStr2 = "내부 클래스 정적변수는 선언 불가능";

        void Test() {
            System.out.println(str1);
            System.out.println(str2);
            System.out.println(innerStr1);
        }
    }

    public void testClass() {
        innerClass.Test();
    }
}
출처: https://ittrue.tistory.com/123 [IT is True:티스토리]
```
   - 정적 내부 클래스 : 외부 클래스의 멤버 변수 선언위치에 선언해야하며, 외부 전역 변수만을 사용할 수 있음.
  
   - 
   - 지역 내부 클래스 : 외부 클래스의 메서드나 초기화 블럭 안에 선언함, 외부 인스턴스 변수와 외부 전역 변수를 사용할 수 있음.
  
   - 
   - 익명 내부 클래스 : 클래스의 선언과 객체의 생성을 동시에 할 수 있는 일회용 익명 클래스로, 외부 인스턴스 변수와 외부 전역변수를 사용할 수 O.
     (멤버 내부 클래스 = 인스턴스 내부 클래스 + 정적 내부 클래스)
     
- Static nested 클래스의 특징
- 
- 내부 클래스와 익명 클래스
- 
- nested 클래스의 특징은 꼭 알아야 한다

## ch17. 어노테이션이라는 것도 알아야 한다
- 어노테이션이란?
- 미리 정해져 있는 어노테이션들은 딱 3개뿐
- 어노테이션을 선언하기 위한 메타 어노테이션
- 어노테이션을 선언해 보자
- 어노테이션에 선언한 값은 어떻게 확인하지?
- 어노테이션도 상속이 안돼요
- 
