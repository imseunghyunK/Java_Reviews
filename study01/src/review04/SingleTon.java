package review04;

public class SingleTon {

	private static SingleTon instance = new SingleTon();	
	private SingleTon() {} //외부에서 호출 불가	
	
	public static SingleTon getInstance() {
		return instance;
	}
	public String getCompanyName() {
		return "playdata";
	}
}
