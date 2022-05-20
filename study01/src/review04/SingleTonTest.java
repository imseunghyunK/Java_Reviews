package review04;

public class SingleTonTest {

	public static void main(String[] args) {
		//step02 = 권장 구조 실습
		
		SingleTon st = SingleTon.getInstance();
		System.out.println(st.getCompanyName());
		
		
		//step01 - instance 변수가 public으로 선언되었을 경우 발생되는 문제 확인
//		SingleTon st = SingleTon.instance; //0x
//		System.out.println(st.getCompanyName()); //playdata
//		
//		SingleTon.instance = null;
//		System.out.println(st.getCompanyName()); //playdata
//		
//		SingleTon st2 = SingleTon.instance;
//		System.out.println(st2.getCompanyName()); //java.lang.NullPointerExc
	}

}
