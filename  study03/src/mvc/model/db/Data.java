//Database라 가정

package mvc.model.db;

import mvc.model.domain.Car;
import mvc.model.domain.Customer;

public class Data {
	//모든 요청하는 user들이 공유하는 단일 데이터라 가정
	private static String [] names = {"지민","민정"};
	private static Customer[] cust = {new Customer("tester", "11", new Car("BMW", "77")),
					                  new Customer("tester", "22", new Car("SONATA", "99"))};
	
	private static Data instance = new Data();
	private Data() {}
	public static Data getInstance() {
		return instance;
	}
	
	
	//이름들만 반환 - 두명
	public String [] getNames() {
		return names;
	}
	
	//고객들만 반환 - 두명
	public Customer[] getCustomers() {
		return cust;
	}
}
