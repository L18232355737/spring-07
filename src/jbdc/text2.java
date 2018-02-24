package jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class text2 {

	public static void main(String[] args) {
		String url="jdbc:mysql://192.168.80.133:3306/aaaa?useUnicode=true&characterEncoding=utf8";
		String user="root";
		String password="123456";
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			//创建连接
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接 主机ip 用户名 密码
			con=DriverManager.getConnection(url,user,password);
			//sql语句
			pstmt=con.prepareStatement("insert into aa(id,name) values (?,?)");
			//运行
			pstmt.setInt(1, 6);
			pstmt.setString(2,"7天");
			int i=pstmt.executeUpdate();
			if(i!=0) {
				System.out.println("添加成功");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
