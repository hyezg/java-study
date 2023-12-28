## ch10. 파일에 있는 것을 읽고 쓰려면 아이오를 알아야죠
#### <I/O는>
- I/O는 무엇인가 ? Input Output, 파일을 읽거나 저장할 때, 다른 서버나 디바이스로 보낼 때 사용함.
  I: 읽는 작업, O: 쓰는 작업 함
  
#### <자바의 File과 Files 클래스>
- java.io 패키지에 있는 File클래스는 파일과 파일의 경로(path)정보를 포함함.
- File 클래스 : 파일 및 경로 정보를 통제하기 위한 클래스.(불분명함)
  생성한 파일 객체가 가리키고 있는 것이 존재하는지, 파일인지 경로인지,읽거나 쓰거나 실행할 수 있는지 언제 수정되었는지 확인하는 기능을 제공함.
- Files 클래스 : 모든 메소드가 static으로 선언되어 있어서 별도의 객체를 생성할 필요X.
Q) File과 Files의 차이점?
A) Files의 모든 메소드는 static 이라 객체를 생성할 필요X./

Q) file클래스의 list() 메소드와 listfiles() 메소드의 차이는?
A) file은 디렉터리 하위 목록을 String 배열로 리턴하지만 listfiles는 하위 목록을 file 배열로 리턴함.

#### <File 클래스를 이용하여 파일의 경로와 상태를 확인해 보자>
```java
boolean exists() // 해당 경로가 존재하는지 확인.
boolean mkdir() // 디렉터리를 하나만 만듦
boolean mkdirs() // 여러 개의 하위 디렉터리 만듦.
boolean isDirectory() // file 객체가 경로를 나타내는지 확인. 
boolean isFile() // File 객체가 파일을 나타내는지 확인.
boolean isHidden() // File 객체가 숨긴 파일인지 확인.
boolean canRead() // 현재 수행중인 자바 프로그램이 해당 File객체에 읽을 수 있는 권한이 있는지 확인.
boolean canWrite() // 현재 수행중인 자바 프로그램이 해당 File객체에 쓸 수 있는 권한이 있는지 확인.
boolean canExecute() // 현재 수행중인 자바 프로그램이 해당 File객체를 실행할 수 있는 권한이 있는지 확인.
long lastModified() // 파일이나 경로가 언제 생성되었는지 확인. long타입의 현재 시간 리턴.
boolean delete() // 파일 삭제.
```

#### <File 클래스를 이용하여 파일을 처리하자>
```java
boolean createNewFile() // 파일 생성했는지 확인, 이미 존재하면 false 리턴함
File getAbsoluteFile() // file 객체 리턴.
String getAbsolutePath() //전체 경로 String 리턴. 절대 경
String getName() // 파일일 경우 파일의 이름, 경로는 전체 경로 리턴
String getPath() // 경로+파일 이름 리턴
String getPatent() // 객체가 file을 가지고 있다면, 파일 이름을 제외한 경로만 리턴
String getCanonicalPath() // 객체의 상대 경로를 String로 리턴.
```
- Absolute : 절대 경로.
- Canonical : 절대적, 유일한 경로.

#### <디렉터리에 있는 목록을 살펴보기 위한 list 메소드들>
```java
static File[] listRoots() //사용중인 파일의 루트이렉터리 목록을 File 배열로 리턴함.
String[] list() //현재 디렉터리의 하위 목록을 리턴함.
File[] listFiles(FileFilter filter) // 현재 디렉터리 하위 목록 중, filter 조건에 맞는 목록File배열로 리턴함
```

#### <inputStream과 OutStream은 자바 스트림의 부모들이다>
```java
public abstract class InputStream extends Object implements Closeable
```
- Closeable 인터페이스 : 열었으면 이걸로 닫으라는 것.
- 리소스는 파일이 될 수도, 네트워크 연결도 될 수 O.

Q) 스트림을 다룰 때 다른 메소드를 호출하지 않아도 x는 반드시 호출해야함. x?
A) close()

#### <Reader와 Writer>
- 바이트가 아닌 char기반의 문자열로만 되어있는 파일처리함
- Reader : 읽음 , Writer :  씀
- reader의 abstrct 메소드는 close() 와 read().
- 
#### <텍스트 파일을 써보자>
- FileWriter : 메소드들이 호출할 때마다 데이터를 씀
- BufferedWriter : 더 효율적.
Q) 생성자들은 모두 첫번째 매개변수로 Writer객체를 넘겨줘야하는 것은?
A) BufferedWriter

#### <텍스트 파일을 읽어보자>
- FileReader
- BufferedReader

Q) 파일을 읽고 문자열을 처리하기 위해서 필요한 scanner 클래스가 속해있는 패키지는?
A)java.util


## ch11. Serializable과 NIO도 살펴 봅시다
- Serialization : 객체를 데이터 스트림으로 변환하는 작업.
- Deserialization : 데이터 스트림을 객체로 변환하는 작업.
- 
- Serilizable  interface : 파일을 읽거나 쓰고, 다른 서버로 보내거나 받을 때 반드시 구현해야함.(직렬화,역직렬화 가능함)
- transient : 직렬화되면 안되는 값에 대해서 transient를 사용할 수 o.
- ObjectOutputStream & ObjectInputStream : 기반 스트림을 필요로 하는 보조스트림. 객체를 생성할 때 입출력할 기반 스트림을 지정해줘야함, 자바 데이터를 직렬화, 역직렬화 해주는 클래스

- NIO
#### <네트워크 프로그래밍이란?>

#### <소켓 통신을 하기 위해서 알아야 하는 Socket 클래스>

#### <간단하게 소켓 통신을 해보자?>

#### <UDP통신을 위해서 알아야 하는 Datagram 관련 클래스>

#### <간단하게 UDP 통신을 해보자>

#### <자바에서 웹 페이지 요청을 하려면 어떻게 해야 하지?>

 
참고 : <a href="https://velog.io/@always/%EC%9E%90%EB%B0%94%EC%9D%98-%EC%8B%A0-26%EC%9E%A5-%ED%8C%8C%EC%9D%BC%EC%97%90-%EC%9E%88%EB%8A%94-%EA%B2%83%EC%9D%84-%EC%9D%BD%EA%B3%A0-%EC%93%B0%EB%A0%A4%EB%A9%B4-%EC%95%84%EC%9D%B4%EC%98%A4%EB%A5%BC-%EC%95%8C%EC%95%84%EC%95%BC%EC%A3%A0">링크1</a>
