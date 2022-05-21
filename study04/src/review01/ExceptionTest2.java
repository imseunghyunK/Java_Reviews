/* 1. 실행 예외와 컴파일 예외에 따른 구분
 * 2. 예외 처리 방식
 * 3. 실습
 *  1. java.lang.ArrayIndexOutOfBoundsException
 *  	- 실행시 발생된 예외
 *  	- RuntimeException의 하위 클래스
 *  	- 해결점 : 배열의 index값을 유효한 값으로 수정 
 */



package review01;

import user.exception.InvalidateUserExcepetion;

class B{
	static {
		System.out.println("B 클래스 로딩 완료");
	}
}

public class ExceptionTest2 {
	//실행되는 예외 처리 학습
	static void m1() {
		int[] i = {1, 2, 3};
		System.out.println(i[5]);
	}
	
	//컴파일시에 발생되는 예외 처리 학습
	//정상 실행 : B 클래스 로딩 완료 1 2
	static void m2() {
		try {
			//구현 로직 단 예외 발생 경우의 수를 보유하고 있는 block
		Class.forName("step01.exeception.B");
		System.out.println(1);
		
		
	}catch(ClassNotFoundException e) {
		//실제 예외 발생시 실행되는 처리 block
		System.out.println("예외 발생 - 로딩하려는 클래스는 없음");
		}
		System.out.println(2);
	}
	
	//비정상 실행 :
	static void m3() {
		try {
			
		Class.forName("step01.exeception.C"); // 문제 발생시 ClassNotFoundException 객체가 생성되는 원리
		//예외 발생시 실행 불가인 영역
		System.out.println(1);
		
		
	}catch(ClassNotFoundException e) { // 객체를 받으려면 타입과 변수명 선언
		System.out.println("예외 발생 - 로딩하려는 클래스는 없음");
		e.printStackTrace(); //예외 발생된 내부 흐름 정보 확인
		}
		System.out.println(2);
	}
	
	/* 값 비교
	 * 1. 참조 타입(객체, class)
	 *  - 주소값 비교(동일객체여부)
	 *  	==
	 *  - 서로 다른 객체간의 내용값 비교
	 *  	public boolean equals(타입 변수)
	 *  
	 * 2. 기본 타입
	 *  - byte/short/int/long // float/double //char //boolean
	 *  - 값 비교 : == (동등비교연산자)
	 *  && : and 그리고 (빠른 연산자)
	 *   -조건식1 && 조건식2 - 둘 다 true인 경우 {}실행
	 *   -조건식1이 false인 경우 조건식2 검증 자체를 안함
	 */
	//id-root/pw-11이라는 값에 한해서만 유효한 회원
	static boolean m4LoginCheck(String id, int pw) { //walker method
		if(id.equals("root") && pw == 11) {
			System.out.println("유효");
			return true;
		}else {
			System.out.println("무효");
			return false;
		}

	}
	
	// 무효한 경우 예외 발생을 코드로 적용
	/* 무효한 ID라는 의미의 예외 클래스를 개발해서 발생된 예외명만 보고도 동조
	 * 사용자 정의 예외 클래스 다수 개발
	 * InvalidateUserExcpetion.java 개발
	 * 
	 * 개발 방식
	 *  - 로직에 맞게 예외객체 생성
	 *  	메소드 body에서 생성
	 *  		throw new 예외생성자();
	 *  	주의 사항 : throw 후에는 로직 구현 불가
	 *   - 메소드 선언구에 발생될 수도 있나는 싸인으로 반드시 throws 표현
	 */
	static boolean m5UserException(String id, int pw) throws InvalidateUserExcepetion{
		if(id.equals("root") && pw == 11) {
			System.out.println("유효");
			return true;
		}else {
			//System.out.println("무효");
			//InvalidateUserExcepetion("무효") - message라는 변수에 대입되는 값 getMessage()로 사용
			throw new InvalidateUserExcepetion("무효"); //예왜 객체 생성
			//로직 구현 불가 영역
		}

	}
	
	public static void main(String[] args) {
		
		try {
			boolean r = m5UserException("root", 11);
			System.out.println("정상 로그인 완료");
		}catch(InvalidateUserExcepetion e) {
				System.out.println(e.getMessage()); //무효
				System.out.println("비정상 재시도 하세요!!!");
			}
		
//		boolean r = m4LoginCheck("root", 11); // caller method
//		System.out.println(r);
		
//		m1();
//		m2();
//		m3();
		
		
	}
	
}

