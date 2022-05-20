package review01;

class A{
	String name = "유재석";
	int age = 30;
	
	A(){
		System.out.println("A 생성자");
	}
}
class B{
	A a = new A();
	
	B(){
		System.out.println("B 생성자");}
}

public class MethodTest2 {
	B b = new B();
	
	MethodTest2(){
		System.out.println("MethodTest2 생성자");
	}
	
	public static void main(String[] args) {
		System.out.println("data");
		
		MethodTest2 m =new MethodTest2();
		
		System.out.println(m.b.a.name);
		System.out.println(m.b.a.name.charAt(0));
		
	}

}
