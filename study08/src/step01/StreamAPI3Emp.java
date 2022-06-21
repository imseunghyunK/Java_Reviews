package step01;

import java.util.ArrayList;
import java.util.List;

import model.domain.Employee;

public class StreamAPI3Emp {

	public static void main(String[] args) {
		List<Employee> peoples = new ArrayList<>();
		peoples.add(new Employee(101, "Victor", 23));
		peoples.add(new Employee(102, "Rick", 21));
		peoples.add(new Employee(103, "Sam", 25));
		peoples.add(new Employee(104, "John", 27));
		peoples.add(new Employee(105, "Grover", 23));
		peoples.add(new Employee(106, "Adam", 22));
		peoples.add(new Employee(107, "Samy", 224));
		peoples.add(new Employee(108, "Duke", 29));
		
		//? 나이값들 평균 단 출력되는 데이터는 double
		// mapToInt (parameter로 유입된 데이터를 int로 변환)
		double ageAvg = peoples.stream().mapToInt(e -> e.getAge()).average().getAsDouble();
	
		System.out.println("직원들 평균 나이 : " + ageAvg);
		
		System.out.println(peoples.stream()); //java.util.stream.ReferencePipeline$Head@490d6c15
		System.out.println(peoples.stream().mapToInt(e -> e.getAge())); //java.util.stream.ReferencePipeline$4@449b2d27
		System.out.println(peoples.stream().mapToInt(e -> e.getAge()).average()); //OptionalDouble[49.25]

		//? 나이가 200을 초과하는 직원 데이터를 제외한 나머지 직원들의 평균 나이 계산 및 출력
		ageAvg = peoples.stream().mapToInt(e -> e.getAge()).filter(age -> age < 200).average().getAsDouble();
		System.out.println("이상치를 제외한 직원들 평균 나이 : " + ageAvg);
		
	}
}
