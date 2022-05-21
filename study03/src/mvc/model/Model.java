/*database와 실제 연동되는 class 가정
 * - sql -> java + sql API(JDBC)로 개발 예정
 * - 데이터를 이름값 Customer 자체를 변환 및 출력 구조로 변환
 * 
 * 로직은 동일 단 개선하는 작업 : 리팩토링
 */

package mvc.model;

import mvc.model.db.Data;
import mvc.model.domain.Customer;

public class Model {
	//1단계
	public static String getName() {
		Data d = Data.getInstance();
		String [] ns = d.getNames();
		return ns[0];
		}
	//2단계 - 개선	
		public static String getName2() {
			String [] ns = Data.getInstance().getNames();
			return ns[0];
	}
		
	//3단계 - 개선	
	/* Data.getInstance().getNames()[0]
	 	* Data.getInstance() : Data
	 	* Data.getInstance().getNames() : String
	 	* Data.getInstance().getNames()[0] :String
	 	*/
		public static String getName3() {
			return Data.getInstance().getNames()[0];
	}
		

	public static Customer getCustomer() {
		Customer[] cs = Data.getInstance().getCustomers();
		return cs[0];	
	}
	
	

}
