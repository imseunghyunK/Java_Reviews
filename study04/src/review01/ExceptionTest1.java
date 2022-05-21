package review01;

//A.java -> A.class
class A{
	static {//A.java -> A.class
		System.out.println("A야");
	}
	//... 다양한 핵심 로직이 있다 가정
}




public class ExceptionTest1 {

	static String m() {
		return null; //참조타입의 기본값
	}
	public static void main(String[] args) {
			//step02 - 외부로 부터 제공받은 class(외부 library, API)의 byte code를 메모리에 로딩해야 한다.
			//java.lang.Class.forName("String fileName"){byte code를 메모리에 코딩}
			try {
				Class.forName("step01.exeception.A4"); //정상 로딩시 static{} 자동 실행
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			

		
		
		    //step01
			//"3" -> 3 / "삼" -> 3
//			int v = Integer.parseInt("3");
//			System.out.println(v); //3
			
			//컴파일 정상, 실행시 발생 예외 (값 수정해서 재실행시 문제 없음)
//			int v2 = Integer.parseInt("삼");
//			System.out.println(v2); //java.lang.NumberFormatException: For input string: "삼"
			
			//컴파일 정상, 실행시 발생 예외
//			String v3 = m();//null
//			System.out.println(v3.length()); // java.lang.NullPointerException: Cannot invoke "String.length()" because "v3" is null
			
			
	}

}
