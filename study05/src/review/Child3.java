package review;

class Parent3 extends Object {
	int a = 100;
	Parent3(){
		super();
	}
	
	String printData() {
		return "a 데이터" + a;
	}
}

public class Child3 extends Parent3 {
	
	float b = 56.5f;
	
	public Child3() {
		super();
	}
	
	//? printData()를 보유하고 있는 모든 멤버값이 한번에 return 되게 재정의
	// super.printData() 호출 필수
	//	"a 데이터100 b 데이터 56.2"
	
	String printData() {
		return super.printData() + " b 데이터 " + b;
	}
	
	public static void main(String[] args) {
		Child3 c = new Child3();
		System.out.println(c.printData());
	}

}
