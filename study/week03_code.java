// Q 양수 5개 입력받아 배열에 저장하고 제일 큰 수 출력하기
import java.util.Scanner;
public class Ex01 {

	public static void main(String[] args) {
		int intArray[];
		intArray = new int [5];
		int n=0;
		int max=0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수를 입력하세요: ");
		for(int i=0; i<intArray.length; i++) {
			intArray[i] = sc.nextInt();
			if(intArray[i] > max)
				max = intArray[i];
		}
		
		System.out.println("가장 큰 수는 : "+max);
		
	}

}
