package review;

class A{
	String msg = "playdata"; 
	A(){} // 
	

	A(String msg){ 
		this.msg = msg;
	}
}

class B{
	A a = new A();
	
	A getA() {
		A a = new A("반환되는 A객체");
		return a;
	}
	
	void printA(A g) { 
		System.out.println(g);
		System.out.println(g.msg);
	}
}
public class ReferenceTest {

	public static void main(String[] args) {
		//? B 객체 생성
		B b = new B();
		
		//? B 객체가 보유하고 있는 getA() 호출 해서 A객체 받아오기
		A g = b.getA(); 
		System.out.println(g);

		//? B 객체의 printA() 메소드 호출 단, getA()가 반환한 A객체를 parameter로 적용
		b.printA(g);
		
		A c2 = new A("Hello, World!");
		b.printA(c2);
	}

}
