package review;

class Parent5 {
	int no = 100;
}

public class Child5 extends Parent5{
	int no2 = 200;
	
	@Override
	public String toString() {
		return "데이터 : " + no + " " + no2;
	}
	
	static Object getData() { 
		return "playdata"; 
	}
	
	static void printLength(Object v) { 
		System.out.println( ( (String)v ).length() ); 
	}
	
	static void arrayType() {
		Object [] o = new Object[2]; 
		o[0] = "문자열 객체";
		o[1] = new Child5(); 

		String v1 = (String)o[0];
		int length = v1.length(); 
		System.out.println(length);
		
		//? 한문장화
		System.out.println( ( (String)o[0] ).length() );		
	}
	
	
	
	public static void main(String[] args) {
		arrayType();
		
		printLength("encore");
		
		Parent5 o1 = new Child5();
		System.out.println(o1);
		
		String v = (String)getData();
		System.out.println(v.length());
	}

}
