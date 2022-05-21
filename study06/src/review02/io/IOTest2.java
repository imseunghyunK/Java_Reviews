package review02.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class IOTest2 {
	// 공공데이터 read해서 데이터 가공후에 시군구값이 경기도 남양주시 데이터 row값만 출력

	@Test
	public void m4() {
		BufferedReader in = null;
		
		try { 
			in = new BufferedReader(new FileReader("C:\\20220509_lab\\00.dataSet\\국가보훈처 보훈의료 위탁병원 코로나-19 병원 정보_20200520.csv"));							
			String readData = null;
			String [] row = null;
			
			while(( readData = in.readLine()) != null) {
				row = readData.split(",");
				row[0] = row[0].replace("\"", "");
				
				if(row[0].equals("경기도 남양주시")) {
				System.out.println(row[0]);
				System.out.println(readData);
				}
			}
	
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
}	
	
	
	//step03 - 공공 데이터 read해서 콘솔 출력
//	@Test
	public void m3() {
		BufferedReader in = null;
	
		try { 

			in = new BufferedReader(new FileReader("C:\\20220509_lab\\00.dataSet\\국가보훈처 보훈의료 위탁병원 코로나-19 병원 정보_20200520.csv"));					
		
			String readData = null;
			
			//step02 - head와 첫 데이터만 read
			for(int i = 1; i < 3; i++) {
				readData = in.readLine();
				if(i==1) {
					continue; //조건식이 true 경우 해당 다음 로직 생략 후 다시 i++ 영역으로 실행 유지
				}
				System.out.println(readData); // i가 1인 경우에만 무시되는 로직
			}
			//시군구 정보만 출력

		String [] row =readData.split(",");
		System.out.println(row[0]); // "강원도,강릉시"
		row[0] = row[0].replace("\"", "");
		System.out.println(row[0]); // 강원도,강릉시
			
			
//			step01 - 전체데이터 read
			while( ( readData = in.readLine() ) != null ) {
				System.out.println(readData);
			}
			
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
	}	
	
	
	
	//step02
	@Test
	public void m2() {
		BufferedReader in = null;
		BufferedWriter out = null;
		try { 
		
			in = new BufferedReader(new FileReader("레알마드리드.txt"));					
			out = new BufferedWriter(new FileWriter("세계최고의축구팀.txt"));
			
			
			String readData = null;
			
			while( ( readData = in.readLine() ) != null ) {
				out.write(readData + "\n");
			}
			
		} catch (IOException e) { //FileNotFoundException의 상위 타입. 다형성
			  	e.printStackTrace();			 
		} finally {
			try {
				if(in != null) {
					in.close(); 
					in = null;
				}
				if(out != null) {
					out.close();
					out = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


//step01
	@Test
	public void m1() {
		BufferedReader in = null;
		try { 
	
			in = new BufferedReader(new FileReader("220517학습내용.txt"));
	
			// read한 데이터를 대입받는 변수, 데이터가 있으면 String객체, 없을 경우 null
			String readData = null;
		
			while( ( readData = in.readLine() ) != null ) {
				System.out.println(readData);
			}
		
		} 	catch (FileNotFoundException e) {
			e.printStackTrace();
			//file이 없을 경우에만 실행되는 예외 처리 화면 지정
	} 		catch (IOException e) {
		  	e.printStackTrace();
		  	//데이터 read시에 발생되는 예외 처리 화면 지정
	} 	finally {
			try {
				if(in != null) {
					in.close(); //예외 발생 여부와 무관하게 실행되는 블록
					in = null;
				}
			} 	catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
