## ch10. 파일에 있는 것을 읽고 쓰려면 아이오를 알아야죠
#### <I/O는>
- I/O는 무엇인가 ? Input Output, 파일을 읽거나 저장할 때, 다른 서버나 디바이스로 보낼 때 사용함.
  
#### <자바의 File과 Files 클래스>
- File 클래스 : 파일 및 경로 정보를 통제하기 위한 클래스.
  생성한 파일 객체가 가리키고 있는 것이 존재하는지, 파일인지 경로인지,읽거나 쓰거나 실행할 수 있는지 언제 수정되었는지 확인하는 기능을 제공함.
- Files 클래스 : 모든 메소드가 static으로 선언되어 있어서 별도의 객체를 생성할 필요 X.
  
#### <File 클래스를 이용하여 파일의 경로와 상태를 확인해 보자>

#### <File 클래스를 이용하여 파일을 처리하자>
```java
boolean createNewFile() // 파일 생성했는지 확인, 이미 존재하면 fale 리턴함
File getAbsoluteFile() // file 객체 리턴.
String getAbsolutePath() //전체 경로 String 리턴
String getName() // 파일일 경우 파일의 이름, 경로는 전체 경로 리턴
String getPath() // 경로+파일 이름 리턴
String getPatent() // 객체가 file을 가지고 있다면, 파일 이름을 제외한 경로만 리턴
```

#### <디렉터리에 있는 목록을 살펴보기 위한 list 메소드들>
```java
static File[] listRoots() //사용중인 파일의 루트이렉터리 목록을 File 배열로 리턴함.
String[] list() //현재 디렉터리의 하위 목록을 리턴함.
File[] listFiles(FileFilter filter) // 현재 디렉터리 하위 목록 중, filter 조건에 맞는 목록File배열로 리턴함
```

#### <inputStream과 OutStream은 자바 스트림의 부모들이다>
#### <Reader와 Writer>
#### <텍스트 파이를 써보자>
#### <텍스트 파이을 읽어보자>

## ch11. Serializable과 NIO도 살펴 봅시다
#### <네트워크 프로그래밍이란?>
#### <소켓 통신을 하기 위해서 알아야 하는 Socket 클래스>
#### <간단하게 소켓 통신을 해보자?>
#### <UDP통신을 위해서 알아야 하는 Datagram 관련 클래스>
#### <간단하게 UDP 통신을 해보자>
#### <자바에서 웹 페이지 요청을 하려면 어떻게 해야 하지?>

 
참고 (https://velog.io/@always/%EC%9E%90%EB%B0%94%EC%9D%98-%EC%8B%A0-26%EC%9E%A5-%ED%8C%8C%EC%9D%BC%EC%97%90-%EC%9E%88%EB%8A%94-%EA%B2%83%EC%9D%84-%EC%9D%BD%EA%B3%A0-%EC%93%B0%EB%A0%A4%EB%A9%B4-%EC%95%84%EC%9D%B4%EC%98%A4%EB%A5%BC-%EC%95%8C%EC%95%84%EC%95%BC%EC%A3%A0) 
