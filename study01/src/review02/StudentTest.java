package review02;

public class StudentTest {
	
	
	Student getOne2() {
		return new Student();
	}
	
	public static void main(String[] args) {
		
		Student s1 = new Student();
		s1.name = "재석";
		s1.age = 10;
		System.out.println(s1.name);
		
		Student s2 = new Student();
		s2.name = "동엽";
		s2.age = 20;
		System.out.println(s2.name);
		
		System.out.println(s1.name + " " + s2.name);
	}

}