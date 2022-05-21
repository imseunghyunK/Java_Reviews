package review01.api;

import org.junit.Test;

public class StringTest {
	//step01 - String API
	@Test
	public void m1() {
		String s1 = "data"; //생성
		String s2 = "data"; // 이미 존재하는 String 재사용
		String s3 = new String("data"); // 'new' 새로운 메모리 생성
		String s4 = new String("data"); // 새로운 메모리 생성
		
		System.out.println(s1 == s2); //true
		System.out.println(s2 == s3); //false
		System.out.println(s2 == s4); //false
		
		//존재하는 문자열에 새로운 데이터 결합
		s1.concat(" data2 "); // "data data2"라는 새로운 객체 새로 생성 
		System.out.println(s1); //data
		
		s1 = s1.concat(" data2 "); // "data data2"라는 새로운 객체 새로 생성후 s1변수에 대입 
		System.out.println(s1); //data data2
		
		StringBuilder sb = new StringBuilder("data");
		sb.append(" data2");
		System.out.println(sb); // data data2
		
		/*생성되는 객체
		 * a / b / c
		 * a -> b -> ab -> c -> abc
		 */
		System.out.println("a" + "b" + "c"); //abc
		
		
	}
}
