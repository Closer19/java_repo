package dbpackate;
import java.sql.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.xdevapi.Result;

import java.sql.SQLException;

import java.sql.PreparedStatement;

public class DBManager {
	
	private String driver="com.mysql.cj.jdbc.Driver";
	private String url="jdbc:mysql://127.0.0.1:3306/cookdb?serverTimeZone=UTC";
	private String id="root";
	private String pw="1234";
	
	private Connection conn=null;
	private Statement stmt=null;

	public DBManager() {
		// TODO Auto-generated constructor stub
	}
	
	public void initDBConnect() {
		try {
			Class.forName(driver);
			this.conn=DriverManager.getConnection(this.url, this.id, this.pw);
			this.stmt=conn.createStatement();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();	
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public int recordCount() {
		String sql="select count(*) as cnt from usertbl";
		int recount=0;
		try {
			ResultSet rs=stmt.executeQuery(sql);		
			if(rs.next()) {
			recount=rs.getInt("cnt");	
			}
			rs.close();			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return recount;
	}
	
	public User[] allFetch() {
		int recount=this.recordCount();
		User[] userList=new User[recount];
		int userCount=0;
		String sql="select * from usertbl";
		try {			
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				String id=rs.getString("userid");
				String username=rs.getString("username");
				int birthyear=rs.getInt("birthyear");
				String addr=rs.getString("addr");
				String mobile1=rs.getString("mobile1");
				String mobile2=rs.getString("mobile2");
				int height =rs.getInt("height");
				Date mdate=rs.getDate("mdate");
				userList[userCount++]=new User(id, username, birthyear, addr, 
						mobile1, mobile2, height, mdate);				
			}
			rs.close();				
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return userList;
	}
	
	public void selectUser(String username) {
//		String sql="select * from usertbl where username='"+username+"'";
		String sql="select * from usertbl where username=?";
		
		try {			
//			ResultSet rs=this.stmt.executeQuery(sql);
			PreparedStatement pstmt=this.conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				String id=rs.getString("userid");
				String name=rs.getString("username");
				int birthyear=rs.getInt("birthyear");
				String addr=rs.getString("addr");
				String mobile1=rs.getString("mobile1");
				String mobile2=rs.getString("mobile2");
				int height =rs.getInt("height");
				Date mdate=rs.getDate("mdate");
				System.out.println(id);
				System.out.println(name);
				System.out.println(birthyear);
			}
			rs.close();		
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void inputUser(User user) {
		String sql="insert into usertbl values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt=this.conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserName());
			pstmt.setInt(3, user.getBirthYear());
			pstmt.setString(4, user.getAddr());
			pstmt.setString(5, user.getMobile1());
			pstmt.setString(6, user.getMobile2());
			pstmt.setInt(7, user.getHeight());
			pstmt.setDate(8, user.getMdate());
			pstmt.executeUpdate();			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void releaseDB() {
		try {
			this.conn.close();
			this.stmt.close();			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}	

}
