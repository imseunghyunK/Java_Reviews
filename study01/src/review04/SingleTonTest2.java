package review04;

class Log{
	private static Log instance = new Log();
	private Log() {}
	
	public static Log getInstance() {
		return instance;
	}
	//log기록용 메소드들 다수 존재한다 가정
}

public class SingleTonTest2 {

	public static void main(String[] args) {
		Log log = Log.getInstance(); // new 불가
	}

}
