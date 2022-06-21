package step01;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import model.domain.Employee;
public class StreamAPI6 {
	
    public static void main(String[] args) {
        System.out.println("-- 1 --");
        List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
        long count = strList.stream().filter(x -> x.isEmpty()).count();
        System.out.printf("List %s has %d empty strings %n", strList, count);
        
        System.out.println("-- 2 --");
        long num = strList.stream().filter(x -> x.length() > 3).count();
        System.out.printf("List %s has %d strings of length more than 3 %n", strList, num);
        
        System.out.println("-- 3 --");
        count = strList.stream().filter(x -> x.startsWith("a")).count();
        System.out.printf("List %s has %d strings which startsWith 'a' %n", strList, count);
        
        System.out.println("-- 4 --");
        List<String> filtered = strList.stream().filter(x -> !x.isEmpty()).collect(Collectors.toList());
        System.out.printf("Original List : %s, List without Empty Strings : %s %n", strList, filtered);
        
        System.out.println("-- 5 --");
        filtered = strList.stream().filter(x -> x.length() > 2).collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);
        
        System.out.println("-- 6 --");
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(G7Countries);
        
        System.out.println("-- 7 --");
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s, Square Without duplicates : %s %n", numbers, distinct);
        
        List<Integer> data = numbers.stream().map(i -> i * i).collect(Collectors.toList());
        System.out.printf("--- distince() 없이 %s - %s %n", numbers, data);
        
        
        System.out.println("-- 8 --");
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println(stats); 
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
        
        //예제
        System.out.println();
        System.out.println("--- 예제 ---");
        List<String> G8 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada", "Korea");
        String G8Countries = G8.stream().map(x -> x.toLowerCase()).collect(Collectors.joining(", "));
        System.out.println(G8Countries);
		
        System.out.println();
        List<Integer> primes2 = Arrays.asList(6, 8, 10, 13, 15, 17, 20, 22, 25, 30);
        IntSummaryStatistics stats2 = primes2.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println(stats2); 
        System.out.println("가장 큰 값 : " + stats2.getMax());
        System.out.println("가장 작은 값 : " + stats2.getMin());
        System.out.println("모든 숫자를 더 한 값 : " + stats2.getSum());
        System.out.println("평균값 : " + stats2.getAverage());
        
		// 다음 수 중 제곱근이 정수 형태인 수는 정수로 출력 소수인 수는 출력 X 
        List<Integer> pownumber = Arrays.asList(81, 100, 9, 16, 1, 3, 7);
		List<Double> data1 = pownumber.stream().map(i -> Math.sqrt(i)).filter(x -> x % 1 == 0).
				collect(Collectors.toList());
		
		System.out.println(data1);

        

    }
}

