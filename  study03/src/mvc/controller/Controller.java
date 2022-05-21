package mvc.controller;
//외부 package의 class 사용을 위한 필수 설정
import mvc.model.Model;
import mvc.view.Endview;

public class Controller {
	
	public static void reqRes(int reqNo) {
		if(reqNo == 1) {
			//Model에서 getName() 호출해서 반환받아 이름 출력 로직 실행
			
			
			Endview.printName(Model.getName());
			
		}else if(reqNo == 2) {
			
			Endview.printCustomer(Model.getCustomer());
			
		}else {
			Endview.failmsg("잘못된 요청입니다. 재확인 하세요");
		}
	}
}
