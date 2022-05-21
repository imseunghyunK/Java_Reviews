package step01_basic;

class Parent5 {
	int no = 100;
}

public class Child5 extends Parent5{
	int no2 = 200;
	
	//? toString()를 모든 멤버값이 결합되어 반환하게 하기
	//데이터 : no no2 형식으로 반환하기
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
		System.out.println(length); //6
				
		//? 한문장화
		System.out.println( ( (String)o[0] ).length() );
		
	}
		
	public static void main(String[] args) {
		arrayType();
		
		printLength("encore");
		
		Parent5 o1 = new Child5();//? 다형성 객체 생성하기
		System.out.println(o1); // o1.toString()으로 자동 변환
		
		String v = (String)getData();
		System.out.println(v.length()); 
	}

}
