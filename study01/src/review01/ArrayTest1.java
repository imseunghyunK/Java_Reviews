package review01;

import org.junit.Test;

import model.domain.Person;

public class ArrayTest1 {
	//기본 타입으로 배열
	@Test
	public void m1() {

		int [] i = {1, 2, 3}; // 0~2까지의 index값을 보유한 int 배열 생성
		System.out.println(i[0] + " " + i.length);
		System.out.println("----");
		
		//for for(초기치;조건식;증감식){ 조건식이 true인 경우 실행}
		for(int index = 0; index < i.length ; index++) {
			System.out.print(i[index] + "\t");
		}
		
		System.out.println(); // new line 반영		
		
		//for Each
		//for(타입 변수 : 배열)
		for(int v : i) {
			System.out.print(v + "\t");
		}
		System.out.println();
	}

	@Test
	public void m2() {
		System.out.println("m2() ---");
		String [] s = {"일", "이", "삼"};
		for(String v : s) {
			System.out.println(v);
		}
	
	}
	
	//Person 객체 타입으로 배열
	@Test
	public void m3() {
		System.out.println("\nm3()---");
		
		Person[] p = {new Person("연아",20), 
					  new Person("연아2",50)};

		System.out.println(p[0].getName());
		
		p[0].setName("동엽");
		System.out.println(p[0].getName()); //동엽
		
		p[1].setName(p[0].getName());
		System.out.println(p[1].getName()); //동엽
	}
	
	
	public static void main(String[] args) {

	}

}
