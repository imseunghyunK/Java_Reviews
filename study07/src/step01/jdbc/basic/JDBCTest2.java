package step01.jdbc.basic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import util.DBUtil;

public class JDBCTest2 {
	
	@Test
	//deptno값으로 부서 하나의 정보 검색
	public void selectOne() {
		System.out.println("---------selectOne()-----------");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			 conn = DBUtil.getConnection();		
			 stmt = conn.createStatement();
			 rset = stmt.executeQuery("select * from dept where deptno=10");
			
			if(rset.next()) {
				System.out.println(rset.getInt("deptno") + " "
						+ rset.getString("dname") + " " 
						+ rset.getString("loc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("db 접속 문제 발생");
		} finally {
			DBUtil.close(conn, stmt, rset);
		}
		
	}
	
	// table 복제해서 생성시에는 dept의 제약조건까지 복제되지 않음
	@Test
	//insert - insert into dept01 values (50, '교육부', '서초');
	public void insert() {
		System.out.println("---------insert()-----------");
		Connection conn = null;
		Statement stmt = null;
		int count = 0;
		
		try {
			 conn = DBUtil.getConnection();		
			 stmt = conn.createStatement();
			 count = stmt.executeUpdate("insert into dept01 values (50, '교육부', '서초')");
			
			if(count == 1) {
				System.out.println("저장 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("db 접속 문제 발생");
		} finally {
			DBUtil.close(conn, stmt);
		}
	}
	
	
	//update
	@Test

	public void update() {
		System.out.println("---------update()-----------");
		Connection conn = null;
		Statement stmt = null;
		int count = 0;
		
		try {
			 conn = DBUtil.getConnection();		
			 stmt = conn.createStatement();
			 count = stmt.executeUpdate("update dept01 set loc='강남' where deptno=50");
			
			if(count == 1) {
				System.out.println("수정 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("db 접속 문제 발생");
		} finally {
			DBUtil.close(conn, stmt);
		}
	}
	
	// delete 
	// delete from dept01 where deptno=50
	
	@Test
	//delete
	public void delete() {
		System.out.println("---------delete()-----------");
		Connection conn = null;
		Statement stmt = null;
		int count = 0;
		
		try {
			 conn = DBUtil.getConnection();		
			 stmt = conn.createStatement();
			 count = stmt.executeUpdate("delete from dept01 where deptno=50");
			
			if(count != 0) {
				System.out.println("삭제 성공" + count);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("db 접속 문제 발생");
		} finally {
			DBUtil.close(conn, stmt);
		}
	}
	
	@Test
	// 모든 검색
	public void selectAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			 conn = DBUtil.getConnection();		
			 stmt = conn.createStatement();	//접속된 접속 객체로 부터 생성, 즉 해당 db와만 소통하는 문장 객체
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
			DBUtil.close(conn, stmt, rset);
		}
	
		
	}
	
}
