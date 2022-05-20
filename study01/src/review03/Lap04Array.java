package review03;

import org.junit.Test;

import model.domain.Person;

public class Lap04Array {
	
	public int [] m1() {	
		int [] i = {1, 2, 3};
		return i;
	}
	public void m2(int[] v) {
		System.out.println(v[0]);
	}
	
	@Test
	public void m3() {
		System.out.println("\nm3()---");
		
		Person[] p = {new Person("연아",20), 
					  new Person("연아2",50)};
	
		// 연아2 -> 손흥민 변경 및 출력
		p[1].setName("손흥민");
		System.out.println(p[1].getName());
		
		String [] names = {"연아", "흥민", "동엽"};
		
		// 손흥민을 흥민으로 변경 단 String[] 로부터 데이터 발췌해서 활용	
		//제약조건 한 문장으로 만들기
		System.out.println(names[1]); //흥민
		
		p[1].setName(names[1]);
		
		System.out.println(p[1].getName()); // 흥민
		}
	
	@Test 
	public void at() {
		//? Person 객체 생성시 m1()의 반환값으로 age값 대입
		int[] ages = m1();
		Person p = new Person("동엽", ages[0]);
		System.out.println(p.getName());
	}
}
