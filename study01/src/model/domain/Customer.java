package model.domain;

import org.junit.Test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//여성 전용 쇼핑몰의 고객 정보 관리 프로그램이라 가정
//회원 - 여자(제약, 조건)

@NoArgsConstructor
@Getter
@Setter
public class Customer {
	private String id; //null
	private int pw; //0
	private char gender;
	
	public Customer(String id, int pw, char gender) {
		this.id = id;
		this.pw = pw;
		setGender(gender);
	}
	
	public void setGender(char gender) {
		if(gender == 'F') {
			this.gender = gender;
		}else {
			System.out.println("F 여야만 합니다. 삑!!");
		}
	}
	

	public static void main(String [] args){
		Customer c = new Customer("tester", 1, 'F');
		System.out.println(c.gender);
		
		Customer c2 = new Customer("tester", 1, 'M');
		System.out.println("-" + c2.gender + "-");	
	}
}

