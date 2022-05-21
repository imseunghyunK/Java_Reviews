package review;

class Parent extends Object{//class 선언구에 extends 가 없을 경우 무조건 자동 추가
	String name;
	int age;
	
	Parent(){}
	Parent(String n, int a){
		this.name = n;
		age = a;		
		System.out.println("Parent(String n, int a)");
	}
	
	void printAll() {
		System.out.println(name);
		System.out.println(age);
	}
}

public class Child extends Parent {//Parent를 상속받는 Child 클래스 
	String job;
	
	Child(){
//		super();//parameter가 일치가 되는 부모 생성자 호출, Object 객체 -> Parent 객체 
		super("test", 10);
		System.out.println("Child()");
	}
	public static void main(String[] args) {
		Child c = new Child()    ; //Object 객체 -> Parent 객체 -> Child 객체 생성 순으로 진행
	}

}