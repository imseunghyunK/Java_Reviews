/* 미션?
 * 1.
 * - 용어.txt 파일로부터 데이터 read
 * - 각 문장들을 단어로 분리 단어별로 길이가 3 이상(포함)되는 단어들만 출력
 * 
 * 2.
 * - 스스로 구성한 문제(미션)
 * 소요시간 - ? 몇시까지?
 */

package step01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamAPI8Mission {
	public static void readSplit() {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("용어.txt"));

			String readData = null;
			List<String> row = null;
			List<List<String>> listOfFilter = new ArrayList<>();
			
			while ((readData = in.readLine()) != null) {
				row =  Arrays.asList(readData.split(" |:|\\(|\\)"));
				List<String> filtered = row.stream().map(v -> v.replace(",", "")).map(v -> v.replace(".", ""))
						.filter(x -> x.length() >= 3).peek(e -> System.out.println(e)).collect(Collectors.toList());
				listOfFilter.add(filtered);
			}
			
			List<String> listOfFiltered
			= listOfFilter.stream().flatMap(l -> l.stream()).collect(Collectors.toList());
			System.out.println(listOfFiltered);
			long count = listOfFiltered.stream().count();
			System.out.println("3글자 이상 글자 갯수 : "+ count);
			
		} catch (IOException e) { 
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
					in = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args)  {
		BufferedReader in = null;
		try { 
		
			in = new BufferedReader(new FileReader("용어.txt"));
		
			String readData = null;
			//line 단위로 read한 문장을 여백을 기준으로 단어별로 분맇서 대입 받을 배열
			String [] lineData = null;
			
			List<List<String>> allDatas = new ArrayList<>();
			List<String> listData = null;
			
			
			
			while( ( readData = in.readLine() ) != null ) {
				lineData = readData.split(" ");
				allDatas.add(Arrays.asList(lineData));
			}
			
//			System.out.println(allDatas);
			
			listData = allDatas.stream().flatMap(v -> v.stream()).collect(Collectors.toList());
//			System.out.println(listData);
			
			List<String> words = listData.stream().filter(s -> s.length() >= 3).collect(Collectors.toList());
//			System.out.println(words);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			  	e.printStackTrace();
			  	
		} finally {
			try {
				if(in != null) {
					in.close(); 
					in = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
		
		readSplit();
	}
	
}
