package review01;

public class MethodTest {

	int sum(int v1, int v2) {
		return v1 + v2;
	}
	
	String sum2(int v1, int v2) {
		int r = v1+v2;
		return "합= " + r; //문자열 + 숫자 -> 문자열, 데이터 결합 연산
	}
	
	void sum3(int v1, int v2) {
		System.out.println(v1 + v2);
	}
	
	
	public static void main(String[] args) {

		MethodTest m = new MethodTest();
		int result = m.sum(1, 10);//호출
		System.out.println(result);
		
		String s = m.sum2(10, 20);
		System.out.println(s); //합 = 30
		
		m.sum3(10, 100);
	}

}
