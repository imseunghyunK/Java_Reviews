package review01.api;

import java.util.HashMap;
import java.util.Hashtable; //key와 value 구조의 동적 메모리 클래스
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class MapTest {
	
//	@Test
//	public void m2() {	
//		Hashtable<String, Donator> map = new Hashtable<String, Donator>();
//		map.put("7369", new Donator(7369, "김의사", "kimdoc@company.com", "슈바이처 프로젝트"));
//		map.put("7156", new Donator(7156, "신예능", "shin@company.com", "오드리햅번 프로젝트")); 
//		map.put("8012", new Donator(8012, "이레사", "lee@company.com", "마더테레사 프로젝트")); 
//		map.put("7777", new Donator(7777, "박메너", "parkdoc@company.com", "슈바이처 프로젝트"));
//		
//		Donator data1 = map.get("7369");
//		System.out.println(data1.getEname());//김의사
//		
//		map.remove("7369");
//		System.out.println(map.get("7369")); //null
//	}
	
	
	@Test
	public void m1() {
		Hashtable<String, String> map = new Hashtable<String, String>();
		
		//key와 value 구조의 상위타입
		//HashMap 과 HashTable을 같은 map 단 조금씩 기질이 다름
		//Map<String, String> map = new HashMap<>();

		// 데이터 저장
		map.put("일", "김연아"); // 일이라는 이름으로 김연아 데이터 구분 의미
		map.put("이", "마동석"); // 이이라는 이름으로 마동석 데이터 구분 의미
		map.put("삼", "신동엽");
		map.put("사", "유재석");
		System.out.println(map); // {이=마동석, 일=김연아, 삼=신동엽, 사=유재석}

		// 데이터 반환
		// get(key) - key로 매핑될 value 하나만 반환
		System.out.println(map.get("일")); // 김연아
		map.put("일", "연아");
		System.out.println(map.get("일")); // 연아

		
		System.out.println("*** Map.Entry ***");

		for (Map.Entry<String, String> header : map.entrySet()) {
			System.out.println(header.getKey() + " - " + header.getValue());
		}

		Set<Entry<String, String>> all2 = map.entrySet();
		System.out.println(all2.isEmpty()); //false

	}
}
