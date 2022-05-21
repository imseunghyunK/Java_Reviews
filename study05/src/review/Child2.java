package review;

class Parent2 extends Object{
	String name;
	int age;
	
	Parent2(){//기본 생성자(default constructor)
		super();
	}
	
	Parent2(String n, int a){//생성자
		super();
		name = n;
		age = a;
		System.out.println("Parent2(String n, int a)");
	}
	
	void printAll() {
		System.out.println(name);
		System.out.println(age);
	}
}

public class Child2 extends Parent2{
	String job;
	
	public Child2(){
		super();//부모의 기본 생성자 호출
	}
	public Child2(String job) {//job멤버 변수값만 명시적인 초기화
		super();//부모의 기본 생성자 호출
		this.job = job;
	}
	public Child2(String n, int a, String job) {//상속받은 변수 두개와 새로 추가된 변수 모두 초기화
		super(n, a); //부모의 parameter가 있는 [일반] 생성자
		this.job = job;
	}

	void printAll() {
		super.printAll()   ;//Parent2의 printAll() 코드와 100% 동일한 단일 문장
		System.out.println(job);
	}

	@Override
	public String toString() {
		return "Child2 [job=" + job + ", name=" + name + ", age=" + age + "]";
	}
	
	public static void main(String[] args) {
		Child2 c = new Child2("연아", 30, "국대");
		c.printAll();
		
		String s = "자동 객체화";
		System.out.println(s); //자동 객체화
		System.out.println(s.toString()); //자동 객체화
	
		System.out.println(c); //step01.basic.Child2@123a439b  저장된 객체의 주소값
		System.out.println(c.toString()); //step01.basic.Child2@123a439b  저장된 객체의 주소값
		
	}


}






