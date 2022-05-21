package mvc.view;

import mvc.model.domain.Customer;

public class Endview {

	public static void printName(String name) {//객체 생성없이 클래스명으로 호출 가능
		System.out.println("검색된 이름 : " + name);
	}
	public static void failmsg(String msg) {
			System.out.println(msg);
	}
	public static void printCustomer(Customer customer) {
		System.out.println(customer.getId() + " " + customer.getPw() + " " + customer.getCar().getCarName());
	}
	}
	


