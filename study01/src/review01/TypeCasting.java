package review01;

public class TypeCasting {

	public static void main(String[] args) {
		byte b = 8; //8bit
		int i = 32; //8bit
		
		//up casting / 자동 형변환
		i = b; //32bit 변수에 8bit 크기의 데이터 대입
		System.out.println(i);
		
		//down casting / 명시적인 형변환
		b = (byte)i; //8bit의 변수에 32bit 대입 시도시에는 압축
		System.out.println(7);
		
		char c = 'A'; // ' ' 문자 하나 표현 16bit
		System.out.println(c);
		b = (byte)c; //16bit -> 8bit
		System.out.println(b); //65
		
		int i2 = 97;
		char c2 = (char)i2; // 32bit -> 16bit
		System.out.println(c2); //a
		
		//실수값만 자바로 처리시 64bit double로 간주
		float f = (float)32.5; // 에러 32.5는 64bit double
		f = 32.5f;
		f = 32.5F;
	}

}
