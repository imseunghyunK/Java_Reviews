package mvc.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {
	String id;
	String pw;
	Car car; //생성된 Car 객체의 주소값 보유하게되는 멤버(타입관점 : 참조)

}
