package com.bit2016.jdbc.exer01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HREmpList {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver" );
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			
			conn=DriverManager.getConnection(url,"hr","hr");
			stmt=conn.createStatement();
			String sql="select e.first_name,m.last_name from employees e,employees m where e.manager_id=m.employee_id order by e.first_name desc";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				String employeeId=rs.getString(1);
				String firstName=rs.getString(2);
			
				System.out.println(employeeId+", "+firstName);
			}

		}catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패"+e);
		}catch(SQLException e){
			System.out.println("error"+e);
		}finally{
			try{
				if(conn!=null)
					conn.close();
				if(stmt!=null)
					stmt.close();
				if(rs!=null)
					rs.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
			
			
		}
			}
	}
}


