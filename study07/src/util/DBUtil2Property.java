/* 1. db의 설정 정보를 외부 properties 파일로 분리
 * 2. key와 value 구조의 설정 파일
 * 3. 주의 사항
 * 		key는 절대 중복
 * 4. java 코드 상에서 properties 파일 사용하는 개발 단계
 * 	1단계 - Properties 객체 생성
 *  2단계 - 외부 파일 read 가능한 input Stream 으로 파일을 read
 *  3단계 - 생성된 Properties 객체에 로딩(저장, 적재)
 *  		- 한번만 실행
 *  4단계 - Properties 객체에서 key로 value값 획득 가능한 getProperty() 로 활용
 */

package util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DBUtil2Property {
	
	static Properties dbinfo = new Properties();
	
	static {
		try {
			
			dbinfo.load(new FileReader("dbinfo.properties"));
			Class.forName(dbinfo.getProperty("jdbc.driver"));
			
		} catch (ClassNotFoundException  e) {
			e.printStackTrace();
			System.out.println("해당 mysql db의 driver가 없습니다.");
		} catch (IOException e) {
			System.out.println("properties 파일이 없습니다");
		}
	}
	

	public static Connection getConnection() throws SQLException  {
		return DriverManager.getConnection(dbinfo.getProperty("jdbc.url"), 
										   dbinfo.getProperty("jdbc.id"), 
										   dbinfo.getProperty("jdbc.pw"));
	}
	
	
	//select 용 자원 반환 메소드 
	public static void close(Connection conn, Statement stmt, ResultSet rset) {
		try {
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
	
	//DML 용 자원 반환 메소드 
	public static void close(Connection conn, Statement stmt) {
		try {			
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




