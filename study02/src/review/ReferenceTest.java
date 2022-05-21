package review;

class A{
	String msg = "playdata"; //멤버변수
	A(){}
	
	//heap에서 msg 변수가 생성되서 초기화 되는 순서 : null -> playdata -> 반환되는 A객체
	A(String msg){
		this.msg = msg;
	}
}

class B{
	A a = new A();
	
	A getA() {
		A a = new A("반환되는 A객체");
		return a; //주소값 반환, 반환타입과 동일한 객체의 주소값
	}
	
	void printA(A g) {
		System.out.println(g);
		System.out.println(g.msg);
	}
}
public class ReferenceTest {

	public static void main(String[] args) {
	
		B b = new B();
		
		//? B 객체가 보유하고 있는 getA() 호출 해서 A객체 받아오기
		A g = b.getA(); // 반환 받은 객체의 주소값 보유, getA()메소드에서 생성
		System.out.println(g); //step01.app.A@cac736f

		//? B 객체의 printA() 메소드 호출 단, getA()가 반환한 A객체를 parameter로 적용
		b.printA(g);
		
		A c2 = new A("Hello, World!");
		b.printA(c2);
	}

}
