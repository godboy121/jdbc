package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class updateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver" );
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			
			conn=DriverManager.getConnection(url,"bitdb","asd");
			//3.statement 객체 생성
			
			String sql=	"insert into author values(?,?)" ;
			//String sql=	"update author set author_no=? where author_no=?" ;
			pstmt=conn.prepareStatement(sql);
			//4.값 바인딩
			//int no=50;
			//int no1=12;
			int no2=155;
			String author_name="개미";
			
			//pstmt.setInt(1, no);
			//pstmt.setInt(2,no1);
			pstmt.setInt(1, no2);
			pstmt.setString(2, author_name);
			
			//5.sql실행
			pstmt.executeUpdate();
		
			
			
		}catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패"+e);
		}catch(SQLException e){
			System.out.println("error"+e);
		}finally{
			//자원정리
			try{
				if(pstmt!=null)
					pstmt.close();
				if(conn!=null)
					conn.close();

			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

	}

}
