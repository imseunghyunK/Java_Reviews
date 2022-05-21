//무효한 정보로 로그인 시도시 발생시키는 예외 클래스
/* 사용자 정의 Exception 클래스 개발 방법
 * 1. java.lang.Exception 상속
 * 		- message 변수를 보유
 * 		- 하위클래스에서 멤버 변수와 메소드 상속
 * 2. 기본 생성자와 멤버변수 초기화 하는 생성자
 */
package user.exception;

public class InvalidateUserExcepetion extends Exception{
	public InvalidateUserExcepetion() {}
	public InvalidateUserExcepetion(String m) {
		super(m);//Exception(String m){ message = m;} 생성자 호출 의미
		}
	}

