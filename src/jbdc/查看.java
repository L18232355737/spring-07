package jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class 查看 {

	public static void main(String[] args) {
		String url="jdbc:mysql://192.168.80.133:3306/aaaa";
		String user="root";
		String password="123456";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//创建连接
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接 主机Ip 端口号 用户名 密码 选择要操作的数据库
			con=DriverManager.getConnection(url,user,password);
			//sql语句
			pstmt=con.prepareStatement("select * from aa");
			//运行sql语句
			rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("id")+"  "+rs.getString("name"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
