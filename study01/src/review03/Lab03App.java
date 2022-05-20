package review03;

class Person{
	String name;
	int age;
	
	Person(){}
	int getAge() {
		return age;
	}
	
	void setAge(int newAge) {
		age = newAge;
	}

	String getName() {
		return name;
	}
	
	void setName(String newName) {
		name = newName;
	}
}

public class Lab03App {
	
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setName("손흥민");
		p1.setAge(29);
		
		System.out.println(p1.name + " " + p1.age); //손흥민 29
			
		p1 = null;

	}

}
