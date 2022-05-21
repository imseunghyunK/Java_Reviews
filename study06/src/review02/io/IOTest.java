package review02.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class IOTest {
	//step02 - line 단위로 read해서 한번에 출력 기능으로 확장

	@Test
	public void m2() {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			
//			String data = in.readLine();
//			
//			while(   data != null    ) {
//				System.out.println(data);
//				data = in.readLine();
//			}
//			
			
			String data2 = null;
			
			while( ( data2 = in.readLine() ) != null ) {
				
				System.out.println(data2);
				
			}
			
			
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally { //try 문장에 옵션, 기능 : 예외 발생 여부와 무관하게 100% 실행 보장
			try {
				in.close();
				in = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
		
	}
	
	
	//step01 - 가장 기초
//	@Test
	public void m1() {
		InputStreamReader in = new InputStreamReader(System.in);
		try {

			System.out.println( (char)in.read() );  //2byte 문자 하나만 read해서 int로 반환 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
