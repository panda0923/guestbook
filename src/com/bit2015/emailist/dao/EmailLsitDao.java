package com.bit2015.emailist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.bit2015.emaillist.vo.EmailListVo;
	
	public class EmailLsitDao {
		public Connection getConnection()throws SQLException{
			Connection  conn = null;
			try{
			//1.드라이버 로딩
			Class.forName( "oracle.jdbc.driver.OracleDriver" );
			
			//2.커넥션 만들기(ORACLE DB)
			String dbURL  = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection( dbURL, "webdb", "webdb" );
		
			}catch( ClassNotFoundException ex ) {
				System.out.println( "드라이버 로딩 실패-" + ex  );
			}
			return conn;
		}
		public void insert( EmailListVo vo ) {
			try {
				//1.Connection 가져오기
				Connection  conn = getConnection();
				//3. Statement 준비
				String sql = 
					" insert" +
					" into email_list" + 
					" values( email_list_no_seq.nextval, ?, ?, ? )";
				PreparedStatement pstmt = conn.prepareStatement( sql );
				
				//4. binding
				pstmt.setString( 1, vo.getFirstname() );
				pstmt.setString( 2, vo.getLastname() );
				pstmt.setString( 3, vo.getEmail() );
				
				//5. query 실행
				pstmt.executeUpdate();
				
				//6. 자원정리
				pstmt.close();
				conn.close();
				
			} catch( SQLException ex ) {
				System.out.println( "SQL 오류-" + ex );
			}
		}
	public List<EmailListVo> getList(){
		List<EmailListVo> list=new ArrayList<EmailListVo>();
		
		
		try{
			
		Connection  conn = getConnection();	
		//3.statement 생상
		Statement stmt = conn.createStatement();
		//4.SQL문 실행
		String sql = "select *from email_list";
		ResultSet rs = stmt.executeQuery(sql);//쿼리를 실행해라
		//5.row가져오기
		while(rs.next()==true){
			Long no=rs.getLong(1);
			String firstname = rs.getString(2);
			String lastname =rs.getString(3);
			String email = rs.getString(4);
			
			EmailListVo vo = new EmailListVo();
			vo.setNo(no);
			vo.setFirstname(firstname);
			vo.setLastname(lastname);
			vo.setEmail(email);
			list.add(vo);
		}
		
		//6.자원정리
		rs.close();
		stmt.close();
		conn.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL 오류:"+e);
		}
		return list;
	}
}
