package review01;

public class CustomerTest {
	//멤버 변수 선언(이름, 나이, 등급(vvip..문자열)
	String name;
	int age;
	String grade;
	
	public static void main(String[] args) {
		//한명의 정보로 객체 생성(멤버 변수들 공간이 메모리에 생성)
		CustomerTest ct = new CustomerTest();
		CustomerTest ct2 = new CustomerTest();
		
		ct.name = "유재석";
		ct.age = 40;
		ct.grade = "vvip";
		
		ct2.name = "카리나";
		ct2.age = 21;
		ct2.grade = "vip";
		
		System.out.println(ct.name + " " + ct2.name);
		
		CustomerTest ct3 = new CustomerTest();
		
		ct3.name = "윈터";
		ct3.age = 22;
		ct3.grade = "vvip";
		
		System.out.println(ct.name + " " + ct2.name + " " + ct3.name);
		
	}
}
