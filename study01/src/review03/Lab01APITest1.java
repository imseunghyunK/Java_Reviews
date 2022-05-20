package review03;

public class Lab01APITest1 {

	public static void main(String[] args) {
		String endName = "encore playdata";

		System.out.println(endName.length());

		System.out.println(endName.charAt(0)); //e
		System.out.println(endName.charAt(1)); //n
		System.out.println(endName.charAt(7)); //p

		//index 7부터 그 이후 모든 문자열 반환
		System.out.println(endName.substring(7));//playdata
		//index 7부터 시작 마지막 parameter-1 위치까지 발췌
		System.out.println(endName.substring(7, 9));//pl
	}

}