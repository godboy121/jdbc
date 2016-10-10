package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class insertTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stmt=null;
	
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver" );
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			
			conn=DriverManager.getConnection(url,"bitdb","asd");
			//3.statement 객체 생성
			stmt=conn.createStatement();
			//4.sql문
			String title3="왕의귀한";
			int authorNo3=12;
			String sql="insert into author values("+authorNo3+",'"+title3+"')";
			//5.
		
			stmt.executeUpdate(sql);
			
			
			
		}catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패"+e);
		}catch(SQLException e){
			System.out.println("error"+e);
		}finally{
			//자원정리
			try{
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
