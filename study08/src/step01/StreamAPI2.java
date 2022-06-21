package step01;

import java.util.Arrays;
import java.util.List;


public class StreamAPI2 {

	public static void main(String[] args) {
		List<Integer> datas2 = Arrays.asList(1, 2, 3, 4, 5);
		// 짝수값만 받아서 합 구하기
		System.out.println(datas2.stream().filter(v -> v%2 == 0).mapToInt(v -> v).sum());
		
		// 홀수값만 받아서 합 구하기
		System.out.println(datas2.stream().filter(v -> v%2 == 1).mapToInt(v -> v).sum());
		
		// 홀수 개수 출력하기
		System.out.println(datas2.stream().filter(v -> v%2 == 1).mapToInt(v -> v).count());
		
		// 홀수 중 최대값(max) 출력하기
		System.out.println(datas2.stream().filter(v -> v%2 == 1).mapToInt(v -> v).max().getAsInt());
		
		// 홀수 중 최소값(min) 출력하기
		System.out.println(datas2.stream().filter(v -> v%2 == 1).mapToInt(v -> v).min().getAsInt());
		
		// 2만 빼고 출력
		// skip / for each()
		datas2.stream().filter(v -> v != 2).forEach(System.out::println);
		
		// skip(int index) : 지정한 데이터의 순번까지는 skip
		datas2.stream().skip(2).forEach(System.out::println);
		Arrays.asList(11, 12, 13, 14, 15).stream().skip(2).forEach(System.out::println);
	
		
	}

}
