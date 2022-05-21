package review01.api;

import java.util.ArrayList;

import org.junit.Test;

public class ListTest {

	@Test
	public void m4 () {
		//autoboxing
		Integer i = 10; 
		byte b = i.byteValue(); //생성된 Integer객체가 보유한 메소드로 값 byte반환 기능의 메소드
		
		int i2 = 10; //기본값을 기본 타입 변수에 대입
//		byte b2 = i2.byteValue(); 에러
		byte b2 = (byte)i2; //기본 타입 간의 형 변환
		
		//제네릭
//		ArrayList<Integer> al = new ArrayList<>();
		ArrayList<Integer> al = new ArrayList<Integer>();
//		ArrayList<Integer> al = new ArrayList();
		
		al.add(2); // al.add(new Integer(2))으로 변경, autoboxing 코드 권장
		Integer i3 = al.get(0); //제네릭 따라서 형변환 문법 불필요
		System.out.println(i3.byteValue()); //2
	}
	
	

	@Test
	public void m3() {
		int i = 3;	// 기본타입
		Integer i2 = new Integer(3); //참조타입
		
		//unboxing
		//객체 생성 후에 intValue()로 int인 기본타입으로 변환해서 대입
		int i3 = new Integer(3); //int i3 = (new Integer(3)).intValue()
		
		//autoboxing
		//int 기본값 3을 객체로 변환해서 대입
		Integer i4 = 3; //Integer i4 = new Integer(3);
	}
	
	//step02 - 제네릭 미반영
	@Test
	public void m1() {
		ArrayList al = new ArrayList();
		al.add("string"); //0번째 저장 단 Object 상위타입으로 자동 형변환
		al.add(new Integer(3));
		
		System.out.println(al.toString()); //[string, 3]
		
		String v = (String)al.get(0); //0번째 Object타입의 객체 반환
		System.out.println(v.charAt(1)); //t
	}
	
	
	//step03 - 제네릭 반영
	@Test
	public void m2() {
		ArrayList <String> al = new ArrayList<String>();
		al.add("string"); //index 0번째 저장
//		al.add(new Integer(3)); error
		al.add("3");
		
		System.out.println(al.toString()); //[string, 3]
		
		String v = al.get(0); //0번째 
		System.out.println(v.charAt(1)); //t
	}
	
	

	public static void test1(String[] args) {
		//step01
		//String만 저장 가능한 ArrayList 타입 - String[] 타입과 흡사
		ArrayList<String> datas = new ArrayList<String>();
		//5개의 데이터 저장
		datas.add("a"); //index 0번째 자동 저장
		datas.add("ab");
		datas.add("abc");
		datas.add("a");
		datas.add("ab");
		System.out.println(datas); //datas.toString() [a.ab,abc,a,ab]
		
		System.out.println(datas.get(0)); //a
		
		System.out.println(datas.size()); // 저장된 데이터 개수
		
		datas.remove(0); //0번째 저장된 데이터 삭제
		
		System.out.println(datas.get(0)); // ab (index 1이상의 데이터들이 재정렬)
		
		System.out.println(datas.size()); // 4
		
		//index 0번째에 test 데이터 저장
		//기존에 해당 index에 저장되어 있었던 데이터들은 자동으로 뒤로 밀려서 재정렬
		datas.add(0,"test");
		System.out.println(datas); //[test, ab, abc, a, ab]
		System.out.println(datas.get(1)); //ab
		
		
	}

}
