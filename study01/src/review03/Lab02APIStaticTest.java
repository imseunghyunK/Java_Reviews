package review03;

public class Lab02APIStaticTest {

	public static void main(String[] args) {
		//두개의 숫자값으로 대소 비교해서 최대값
		System.out.println(Math.max(3, 5));	//5
		
		//? 에러사유? 동일한 현 클래스에 max() 미존재
		//System.out.println(max(3, 5));
		
		//? 최소값
		System.out.println(Math.min(3, 5));	//3
		
		//?0.0 <= 난수값 < 1.0 까지의 실수
		System.out.println(Math.random());

		//"5" -> int인 5값으로 변경
		//"오" -> int인 5값으로 변경
		int v = Integer.parseInt("5");
		System.out.println(v);
		System.out.println(v+3);
	}

}
