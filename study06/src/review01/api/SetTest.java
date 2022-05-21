package review01.api;

import java.util.HashSet;
import java.util.Iterator;

import org.junit.Test;

public class SetTest {

	@Test
	public void m1() {
		HashSet<String> set = new HashSet<String>();
		set.add("a"); //저장
		set.add("b"); //저장
		set.add("c");
		set.add("d");
		set.add("a"); //저장 - 기존에 이미 저장된 동일한 데이터 삭제하는 원리
		System.out.println(set); // set.toString() [a,b,c,d]

		Iterator<String> forData = set.iterator();

		while(forData.hasNext()) {
			System.out.println(forData.next());
		}
		
		Iterator<String> forData2 = set.iterator();
		//각각의 문자열에 길이 출력 - String클래스에 length()
		String v = null;
		while(forData2.hasNext()) {
				v = forData2.next(); //Iterator<String> 따라서 형변환 불필요
				System.out.println(v.length());
		}
		
		System.out.println("*******3*******");
		Iterator<String> forData3 = set.iterator();
		while(forData3.hasNext()) {
			System.out.println(forData3.next().length());
		}
		
	}
	
}
