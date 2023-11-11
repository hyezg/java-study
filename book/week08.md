## ch16. 클래스 안에 클래스가 들어갈 수도 있구나
#### - 클래스 안의 클래스 - 내부 클래스 :외부 클래스와 내부 클래스가 연관되어 있을 때, 사용성을 높이기 위한 수단.
- 종류 : 인스턴스 내부 클래스/ 정적 내부 클래스/ 지역 내부 클래스/ 익명 클래스.
##### - 인스턴스 내부 클래스 : 외부 클래스의 멤버 선언위치에 선언해야하며, 외부 인스턴스 변수와 외부 전역 변수를 사용할 수 O.
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
public class Main {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();

        outer.testClass();
    }
}
출처: https://ittrue.tistory.com/123 [IT is True:티스토리]
```
##### - 정적 내부 클래스 : 외부 클래스의 멤버 변수 선언위치에 선언해야하며, 외부 전역 변수만을 사용할 수 있음.
  + 내부 클래스가 외부 클래스와 상관없이 정적 변수를 사용할 수 O.
```java
class OuterClass {
    private String str1 = "외부 클래스 인스턴스 변수입니다.";
    private static String str2 = "외부 클래스 정적 변수입니다.";

    void getPrintInstance() {
        System.out.println("인스턴스 메서드");
    }

    static void getPrintStatic() {
        System.out.println("정적 메서드");
    }

    static class StaticInnerClass {
        void test() {
            System.out.println(str2);
            getPrintStatic();

            // 인스턴스 변수 및 인스턴스 메서드는 사용 불가
            // System.out.println(str1);
            // getPrintInstance();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        OuterClass.StaticInnerClass innerClass = new OuterClass.StaticInnerClass();
        innerClass.test();
    }
}
출처: https://ittrue.tistory.com/123 [IT is True:티스토리]
```
##### - 지역 내부 클래스 : 메서드안에서 선언 클래스.
  + 외부 클래스의 메서드나 초기화 블럭 안에 선언함, 외부 인스턴스 변수와 외부 전역 변수를 사용할 수 O.
  + 메서드 내부에서만 사용가능함 -> 메서드 안에서 선언 후 객체 생성해서 사용함.
  + 접근 제한자와 static 키워드 사용X.
  + 정적 필드 및 메소드 선언 X.
```java
class OuterClass {
    String str1 = "외부 클래스 인스턴스 변수";

    void test() {
        String str2 = "지역 변수";

        // 지역 내부 클래스
        class LocalInnerClass {
            void getPrint() {
                System.out.println(str1);
                System.out.println(str2);
            }
        }
        // 메서드 내에서 객체를 생성 후 사용
        LocalInnerClass localInnerClass = new LocalInnerClass();
        localInnerClass.getPrint();
    }
}

public class Main{
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.test();
    }
}
출처: https://ittrue.tistory.com/123 [IT is True:티스토리]
```
<p> 
 
##### - 익명 내부 클래스 : 클래스의 선언과 객체의 생성을 동시에 할 수 있는 일회용 익명 클래스로, 외부 인스턴스 변수와 외부 전역변수를 사용할 수 O.
(** 멤버 내부 클래스 = 인스턴스 내부 클래스 + 정적 내부 클래스)
#### - Static nested 클래스의 특징
#### - 내부 클래스와 익명 클래스
- 익명 클래스 : 클래스의 선언과 객체 생성을 동시에 해서 한번만 사용 가능한 일회용 클래스.(이름이 없는 지역클래스)
  + 미구현된 멤버를 구현하여 일회용으로 객체를 생성하기 위해 사용함.
  + 인터페이스를 구현하는 익명클래스를 객체화함(up casting)
    (upcastig : )
  + 여러개의 인터페이스를 구현X+ 상속과 인터페이스 같이 사용X -> 상속과 인터페이스 중 한개만 사용 가능함.
  + 인터페이스와 클래스 모두 익명 함수로 객체 만들 수 O.
  + static 멤버를 가질 수 X.
  + 외부 클래스의 지역 변수가 final로 선언되야만 접근할 수 O.
- 익명 클래스를 사용하는 이유 : 프로그램 내에서 한번만 객체로 만드는데 사용되는 클래스의 경우 정의하고 생성하는 것이 비효율적이기 때문.
                          (Runnable 이나 EventListener 객체 생성에 주로 사용됨)/ 캡슐화에 유용함.

#### - nested 클래스의 특징은 꼭 알아야 한다
- nested 클래스 = 중첩 클래스 : 클래스 내부에 "정의된" 클래스
- 종류 : static: 정적 중첩 클래스 / non-static: 내부 클래스라고도함.
- Static Nested Class = 정적 중첩 클래스
  + 자신을 감싸고 있는 클래스에서만 사용해야함.
  + 자신을 감싸고 있는 클래스의 static 멤버에만 점근할 수 O.
```java
class OuterClass {
    ...
    class NestedClass {
        ...
    }
}
```
- 정적 중첩 클래스와 내부 클래스 비교 :
  + 공통점 : 클래스 안에 선언된 클래스임.
  + 차이점 : 내부 클래스는 외부 클래스의 모든 멤버에 접근할 수 O (private 포함).
<p>(링크 참조 : https://limdevbasic.tistory.com/28)
<p>

##  ch17. 어노테이션이라는 것도 알아야 한다
- 어노테이션이란?
- 
- 미리 정해져 있는 어노테이션들은 딱 3개뿐
- 
- 어노테이션을 선언하기 위한 메타 어노테이션
- 
- 어노테이션을 선언해 보자
- 
- 어노테이션에 선언한 값은 어떻게 확인하지?
- 
- 어노테이션도 상속이 안돼요
- 
