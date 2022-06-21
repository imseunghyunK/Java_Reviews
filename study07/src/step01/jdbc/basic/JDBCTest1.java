package step01.jdbc.basic;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



public class JDBCTest1 {
	//mysql 실습
	public static void main(String[] args) {
		//1단계 - driver 로딩
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("해당 mysql db의 driver가 없습니다.");
		}
		
		
		//2단계 - 접속 객체 생성
		/* jdbc: db와 java 언어의 통신 규약
		 *  jdbc:벤더사별 다름
		 * 
		 */
		String url = "url";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		try {
			 conn = DriverManager.getConnection(url, "id", "pw");
			//dept table만 검색 -  select * from dept;
			
			//3단계 - 문장 실행 객체 생성
			 stmt = conn.createStatement();
			
			//4단계 - sql문장 실행
			 rset = stmt.executeQuery("select * from dept");
			
			while(rset.next()) {
				System.out.println(rset.getInt("deptno") + " "
						+ rset.getString("dname") + " " 
						+ rset.getString("loc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("db 접속 문제 발생");
		} finally {
			try {
				//5단계 - 자원 반환 : 순서 중요
				if( rset != null ) {
				rset.close();
				rset = null;
				}
				if( stmt != null ) {
				stmt.close();
				stmt = null;
				}
				if( conn != null ) {
				conn.close();
				conn = null;
				}
			}catch(SQLException e) {
				System.out.println("자원반환 실패");
			}
		}
		
	
	
		
	}
	
	//oracle 접속용
	public static void oracle() {
		try {
			//driver 로딩(설치)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//접속 객체 생성 - 정상 실행인 경우 java로 mysql 접속 성공
			String url = "url";
			Connection con = DriverManager.getConnection(url, "id", "pw");
			
			//정상적인 접속 객체는 주소값 보유
			System.out.println(con);	
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	// mysql 접속용
	public static void mysql() {
		try {
			//driver 로딩(설치)
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//접속 객체 생성 - 정상 실행인 경우 java로 mysql 접속 성공
			String url = "url";
			Connection con = DriverManager.getConnection(url, "id", "pw");
			
			//정상적인 접속 객체는 주소값 보유
			System.out.println(con);	
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
