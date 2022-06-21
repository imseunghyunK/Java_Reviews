package step01;

import java.util.Optional;

public class StreamAPI4Optional {

	static void m1() {
		String v = null;
		System.out.println(v.length()); //Cannot invoke "String.length()"
	}
	
	static void m2() {
		String v = null;
		Optional<String> opt = Optional.ofNullable(v);
		System.out.println(opt);	//Optional.empty
		
		// 포함된 데이터 존재 여부 확인 가능한 메소드
		System.out.println(opt.isPresent());	//false
		
		//null과 무관하게 예외 없이 정상 실행
		//end user가 요청시 마다 만약 데이터가 null인 상태가 도래되어도 NullPointerException 볼 수 없음
		opt.ifPresent( v2 -> { // v2는 null
			System.out.println(v.length()); // 실행 되지 않음 
		} );
	}
	
	static void m3() {
		String v = "playdata";
		Optional<String> opt = Optional.ofNullable(v);
		System.out.println(opt);	//Optional[playdata]
		
		System.out.println(opt.isPresent()); 	//true
		
		opt.ifPresent( v2 -> {
			System.out.println(v.length()); // 8
		} );
		
		// 동일한 일반 코드 - 데이터 별로 if 조건식 검증 필수
		if( v != null ) {
			System.out.println(v.length()); // 8
		}
	}
	
	// orElse()
	static void m4() {
		String v = null;
		
		Optional<String> opt = Optional.ofNullable(null);
		System.out.println(opt.isPresent()); //false
		System.out.println(opt.orElse("null인 경우에만 반환되는 값")); //null인 경우에만 반환되는 값
	}
	
	static void m5() {
		String v = null;
		
		Optional<String> opt = Optional.ofNullable(v);
		System.out.println(opt.isPresent()); //true
		System.out.println(opt.orElse("null인 경우에만 반환되는 값")); //encore
	}
	
	
	public static void main(String[] args) {
//		m1(); // NullPointerException 연출
		m2(); // ifPresent() 확인 & null임에도 NullPointerException 발생 되지 않는 안정적인 구현 연출
		m3(); // ifPresent() 확인
		m4();
		m5();
	}

}
