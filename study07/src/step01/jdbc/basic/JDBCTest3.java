package step01.jdbc.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;

import model.domain.Dept01DTO;
import model.domain.Emp01DTO;
import util.DBUtil;

public class JDBCTest3 {

	public void insert(int newDeptno, String newDname, String newLoc) {
		System.out.println("------------- insert() ------------");
		Connection conn = null;
		Statement stmt = null;
		int count = 0;

		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();

			String sql = "insert into dept01 values (" + newDeptno + ", '" + newDname + "', '" + newLoc + "')";
			System.out.println(sql);
			count = stmt.executeUpdate(sql);

			if (count == 1) {
				System.out.println("저장 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("db 접속 문제 발생");
		} finally {
			DBUtil.close(conn, stmt);
		}
	}

	// PreparedStatement API 활용하기
	/*
	 * - sql 문장으로 생성시키는 문장 실행 객체 - 그 이외의 다른 sql문장 실행 불가 - 가변적인 데이터 표현은 메소드와 ? 표기로
	 * 매핑해서 설정 - 동일한 sql문장을 다수가 실행하게 되는 로직인 경우 db 자체적으로 컴파일은 한번만 이미 존재하는 실행 코드로 실행하기
	 * 때문에 실행 속도가 빠름 - 참고 : Statement는 client가 요청시 실행시 마다 무조건 컴파일 -> 실행
	 */
	public void insert2(int newDeptno, String newDname, String newLoc) {
		System.out.println("------------- insert2() ------------");

		Connection conn = null;
		PreparedStatement pstmt = null;

		int count = 0;
		String sql = "insert into dept01 values (?, ?, ?)";

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql); // insert만 실행시키는 문장 객체

			pstmt.setInt(1, newDeptno); // 첫번째 물음표 부분에 값 대입
			pstmt.setString(2, newDname); // 두번째 물음표 부분에 값 대입
			pstmt.setString(3, newLoc); // 두번째 물음표 부분에 값 대입

			count = pstmt.executeUpdate();

			if (count == 1) {
				System.out.println("저장 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("db 접속 문제 발생");
		} finally {
			DBUtil.close(conn, pstmt);
		}
	}

	// ? 동적 요청 처리 하는 update, PreparedStatement로 변환
	public void update(int upDeptno, String newLoc) {
		System.out.println("------------- update() ------------");
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("update dept01 set loc=? where deptno=?");

			pstmt.setString(1, newLoc);
			pstmt.setInt(2, upDeptno);

			count = pstmt.executeUpdate();

			if (count != 0) {
				System.out.println("수정 성공 " + count);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("db 접속 문제 발생");
		} finally {
			DBUtil.close(conn, pstmt);
		}
	}

	/*
	 * 모든 부서 정보 검색 단, 메소드의 반환값으로 검색된 모든 부서 정보 반환 - 타입? - 부서별 데이터를 명확하게 구분하기 위해서는 어떻게
	 * 반환???
	 * 현 시점의 직원수는 14명, 5분 후 퇴사 13, 내일 5명 유입 ..???
	 * 
	 * 모든 직원의 데이터를 반환하는 메소드의 타입은 가장 이상적인 타입이 어떤 타입이 좋을까요?
	 * select empno, ename, sal*12+ifnull(comm, 0) as sal from emp01
	 * 
	 * 배열 : 배열 생성 후에 배열 내에 해당 index에 Emp01DTO 객체들 저장
	 * 	- 배열 생성시 크기정보 필요
	 * 리스트 : 리스트 생성후에 해당 index에 Emp01DTO 객체들 저장
	 */
	public ArrayList<Emp01DTO> selectAll(){
		System.out.println("------------- selectAll() ------------");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		ArrayList<Emp01DTO> all = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select empno, ename, sal*12+ifnull(comm, 0) as sal from emp01");
			rset = pstmt.executeQuery();

			all = new ArrayList<>();
			while (rset.next()) {
				all.add(new Emp01DTO(rset.getInt("empno"), rset.getString("ename"), rset.getDouble("sal")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("db 접속 또는 sql 실행 문제 발생");
		} finally {
			DBUtil.close(conn, pstmt, rset);
		}
		return all;
	}
		
	
	
	
	
	
	/*
	 * 하나의 부서 정보는 어떻게 반환? - DTO - 모든 컬럼값과 일치되는 변수들로 구성된 객체를 반환 - 메소드 실행 결과값은 데이터가
	 * 존재할 경우엔 Dept01DTO 객체 반환 데이터가 미 존재할 경우 ? null
	 * 
	 */
	// select * from dept where deptno=?; deptno는 pk
	public Dept01DTO selectOne(int deptno) {
		System.out.println("------------- selectOne() ------------");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from dept where deptno=?");

			pstmt.setInt(1, deptno);
			// table이 무조건 존재할 경우엔 null 절대 아님
			// 데이터 존재시 검색 결과 객체 반환 / 없어도 검색 결과 객체 반환
			rset = pstmt.executeQuery();

			// 데이터 존재 여부는 필수로 next()
			// 존재할 경우 true 따라서 Dept01DTO 객체 생성 및 반환
			if (rset.next()) {
				return new Dept01DTO(rset.getInt("deptno"), rset.getString("dname"), rset.getString("loc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("db 접속 또는 sql 실행 문제 발생");
		} finally {
			DBUtil.close(conn, pstmt, rset);
		}
		return null;
	}

	/*? create table emp01 as select empno, ename, sal, comm from emp;
	 * 검색 메소드
	 * 1. 기능 : 해당 사원의 모든 정보 검색해서 반환
	 * 2. 단, 연봉(월급여 12개월분, comm도 포함)
	 * 3. Emp01DTO 로 반환 및 출력 
	 * 4. 사번으로 해당 사원의 정보 검색후 DTO로 반환
	 * 5. 단, DTO 클래스는 꼭 컬럼과 100% 일치하지 않아도 됩니다. 
	 * 	- 즉 필요에 의해서 DTO 클래스 들은 다수 개발 가능
	 * 
	 * select empno, ename, sal*12+ifnull(comm, 0) as sal from emp01;
	 */
	public Emp01DTO getEmp(int empno) {
		
		System.out.println("------------- getEmp() ------------");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select empno, ename, sal*12+ifnull(comm, 0) as sal from emp01 where empno=?");

			pstmt.setInt(1, empno);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				//public Emp01DTO(int empno, String ename, double sal) {}
				return new Emp01DTO(rset.getInt("empno"), rset.getString("ename"), rset.getDouble("sal"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("db 접속 또는 sql 실행 문제 발생");
		} finally {
			DBUtil.close(conn, pstmt, rset);
		}
		return null;
	}
	
	
	@Test
	public void runTest() {
		
		//모든 사원 정보 검색
		ArrayList<Emp01DTO> all = selectAll();
		if(all != null) {
			for(Emp01DTO emp : all) {
				System.out.println(emp);
			}
		} else {
			System.out.println("현 시점에 직원이 없습니다.");
		}
			
		
//		Emp01DTO emp = getEmp(7369);
//		if (emp != null) {
//			System.out.println(emp); // emp.toString() 호출 코드와 동일
//		} else {
//			System.out.println("요청하신 사번에 맞는 사원의 정보는 없습니다");
//		}
		
//		insert2(60, "교육부", "서초");
//		update(50, "강남");

//		Dept01DTO v1 = selectOne(10);
//
//		if (v1 != null) {
//			System.out.println(v1); // v1.toString() 호출 코드와 동일
//		} else {
//			System.out.println("요청하신 부서 정보는 없습니다");
//		}
	}

}










