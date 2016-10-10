package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver" );
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			
			conn=DriverManager.getConnection(url,"hr","hr");
			//3.statement 객체 생성
			stmt=conn.createStatement();
			//4.sql문
			String sql="select employee_id,first_name,salary from employees";
			rs=stmt.executeQuery(sql);
			//5.결과가져오기
			while(rs.next())
			{
				Long employeeId=rs.getLong(1);
				String firstName=rs.getString(2);
				Integer salary=rs.getInt(3);
				System.out.println(employeeId+", "+firstName+", "+salary);
			}
			
		}catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패"+e);
		}catch(SQLException e){
			System.out.println("error"+e);
		}finally{
			//자원정리
			try{
				if(rs!=null)
					rs.close();
				if(conn!=null)
					conn.close();
				if(stmt!=null)
					stmt.close();
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

	}

}
