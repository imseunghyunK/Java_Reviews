package review01;

public class StaticTest {
	
	int no1;
	static int no2;
	//멤버 변수들 값 1씩 증가 시키는 로직
	StaticTest(){
		no1 += 1; //nol = no1+1;
		no2 += 1; //0 -> 1 -> 2
	}
	
	void m1() {
		System.out.println("일반 메소드");
	}
	
	static void m2() {
		System.out.println("static 메소드");
	}
	
	public static void main(String[] args) {
		m2();
		StaticTest.m2(); 

		System.out.println(no2);

		StaticTest s1 = new StaticTest();
		System.out.println(s1.no1 + " " + no2);
		
		StaticTest s2 = new StaticTest();
		System.out.println(s2.no1 + " " + no2);
	}

}
