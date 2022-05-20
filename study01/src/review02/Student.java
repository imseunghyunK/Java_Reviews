package review02;

public class Student {
	String name;
	int age;
	//생성자라는게 자동생성
	//Student(){}
	
	public String getName() {
		return name;
	}
	public Student(String name, int age) {
	
		this.name = name;
		this.age = age;
	}
	public Student() {
		super();
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	
}
