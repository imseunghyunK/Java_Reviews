package mvc.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //기본 생성자, set/getXxx() 자동생성
@AllArgsConstructor //멤버변수 초기화 기능이 있는 생성자 // 추가시 기본 생성자는 자동 삭제되는 현상
@NoArgsConstructor // 추가시 기본 생성자는 자동 삭제되는 현상
public class Car {
	String carName;
	String carNo;
	
	//@Data  //기본 생성자, set/getXxx() 자동 생성
	//@AllArgsConstructor 추가시 기본 생성자는 자동 삭제되는 현상
}
 