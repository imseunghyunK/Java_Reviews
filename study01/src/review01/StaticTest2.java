package review01;

public class StaticTest2 {
	static int v = 100;
	static {
		System.out.println(2);
	}
	
	public static void main(String[] args) {
		System.out.println("main()");
	}
	static {
		System.out.println(1);
	}
}
