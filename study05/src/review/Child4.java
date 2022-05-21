package review;

class Parent4 extends Object {
	int a = 100;
	Parent4(){
		super();
		System.out.println("부모");
	}
	
	String printData() {
		return "a 데이터" + a;
	}
}

public class Child4 extends Parent4 {
	
	float b = 56.5f;
	
	public Child4() {
		super();
		System.out.println("자식");
	}
	

	
	String printData() {
		return super.printData() + " b 데이터 " + b;
	}
	
	public static void main(String[] args) {
		//upcasting = 자동 형변환
		Child4 c = new Child4(); //다형성 자바 문법
		System.out.println(c.printData());
		c.a = 20;
//		c.b = 60.5f; 불가
		
		//이미 생성된 객체를 참조하는 변수 타입의 변수만 새로 선언해서 c가 참조하는 객체를 d가 함께 참조
		// downcasting = 명시적인 형변환
		
		Child4 d = (Child4)c;
		d.b = 60.5f;
		System.out.println(d.b); //60.5
		c.a = 100;
		System.out.println(d.a); //100
		d.a = 1000;
		System.out.println(c.a); //1000
	}

}
