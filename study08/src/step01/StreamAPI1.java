package step01;

import java.util.Arrays;
import java.util.List;


public class StreamAPI1 {

	public static void main(String[] args) {
		System.out.println("---step01---");
		List<String> datas = Arrays.asList("일", "이", "삼", "사");
		// v라는 변수 선언, 타입은 String 자동 적용
		// -> 람다 의미 : 선언과 동시에 datas 변수가 보유한 데이터들 대입받고 활용
		datas.forEach(v -> System.out.println(v));
		datas.forEach(System.out::println); // -> 더블 콜론(::)
		
		//for 반복문으로 직접 출력해보기
		for(String v : datas) {
			System.out.println(v);
		}
		
		System.out.println("---step02---");
		//Stream API + 람다식 사용해서 출력해보기
		/* List는 ArrayList의 상위 타입
		 * 제약조건 ; 객체 타입만 저장 및 활용 가틍한 동적 배열 구조
		 * Arrays.asList(1, 2, 3, 4, 5) => int로 타이핑은 했으나 컴파일 시에
		 * int -> Integer 객체 타입으로 변경(autoboxing)
		 * 따라서 List<Integer> 으로 변환
		 */
		List<Integer> datas2 = Arrays.asList(1, 2, 3, 4, 5);
		datas2.forEach(i -> System.out.println(i));
		datas2.forEach(System.out::println);
	
		
	}

}
