package mvc.view;

import mvc.controller.Controller;

public class Startview {
	//4개의 class 실행의 시작 point
	//서버가 없이 순수자바 소스로만 실행시 사용되는 특화된 메소드
	public static void main(String[] args) {
		System.out.println("---이름 검색 ---");
		Controller.reqRes(1);
		
		System.out.println("---고객 검색 ---");
		Controller.reqRes(2); //tester 11
		
		System.out.println("---고객 실수로 1과 2가 아닌 데이터 요청시 ---");
		Controller.reqRes(5); 
		}

}
