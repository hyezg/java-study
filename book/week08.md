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
#### - 어노테이션이란?
- 어노테이션 Annotation : 자바 소스 코드에 추가하여 사용할 수 있는 메타데이터의 일종. 보통@를 붙여서 사용함.
 + 클래스 파일에 임베디드되어 컴파일러에 의해 생성된 후 JVM에 포함되어 작동함.
 + 메소드,필드,클래스의 윗라인에 작성하여 사용
- 종류 : 표준(내장) 어노테이션/ 메타 어노테이션/ 사용자 정의 어노테이션 <p>
- 규칙 :
  + 요소의 타입은 기본형, String, enum, 어노테이션, Class만 허용함.
  + 괄호 ( ) 안에 매개변수를 선언할 수 X.
  + 예외를 선언할 수X.
  + 요소의 타입을 매개변수로 정의할 수 X.
```java
@interface AnnoConfigTest{
    int id = 100; // 상수 ok
    String major(int i, int j) //매개변수를 괄호 안에 선언할 수 없다
    String minor() throws Exception; // 예외는 선언할 수 없다
    ArrayList<T> list(); // 요소의 타입을 매개변수로 정의할 수 없다
```[출처] https://blog.naver.com/youbeen2798/222860971321)
<p>
  
#### - 미리 정해져 있는 어노테이션들은 딱 3개뿐
- @Override : 선언한 메서드가 오버라이드 되었다는 것으 나타냄.
  + 메소드 이름 잘못 적는 실수 방지해줌
- @Deprecated : 해당 메서드가 더 이상 사용되지 않음을 나타냄.(취소선이 표시됨)
- @SuppressWarnings : 선언한 곳의 컴파일 경고를 무시해서 경고 안.
- 
#### - 어노테이션을 선언하기 위한 메타 어노테이션
- 메타 어노테이션 : 어노테이션을 위한 어노테이션
- 종류 :
+ ElementType.PACKAGE : 패키지 선언
+ ElementType.TYPE : 타입 선언
+ ElementType.ANNOTATION_TYPE : 어노테이션 타입 선언
+ ElementType.CONSTRUCTOR : 생성자 선언
+ ElementType.FIELD : 멤버 변수 선언
+ ElementType.LOCAL_VARIABLE : 지역 변수 선언
+ ElementType.METHOD : 메서드 선언
+ ElementType.PARAMETER : 전달인자 선언
+ ElementType.TYPE_PARAMETER : 전달인자 타입 선언
+ ElementType.TYPE_USE : 타입 선언
#### - 어노테이션을 선언해 보자
```java
@interface 이름{
	타입 요소 이름(); // 어노테이션의 요소를 선언
	    ...
}
@interface DateTime{
	String yymmdd();
    String hhmmss();
}
```
- 요소 특징 : 적용할 때 값을 지정하지 않으면 사용될 기본 값을 지정할 수 있음.
  + 이름이 value일때 요소 이름 생략가능함
#### - 어노테이션에 선언한 값은 어떻게 확인하지?
#### - 어노테이션도 상속이 안돼요
- Annotation은 모든 어노테이션의 조상이지만 상속은 불가능함.
- @Inherited : 어노테이션의 상속을 가능하게
