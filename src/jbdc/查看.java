package jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class �鿴 {

	public static void main(String[] args) {
		String url="jdbc:mysql://192.168.80.133:3306/aaaa";
		String user="root";
		String password="123456";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//�������� ����Ip �˿ں� �û��� ���� ѡ��Ҫ���������ݿ�
			con=DriverManager.getConnection(url,user,password);
			//sql���
			pstmt=con.prepareStatement("select * from aa");
			//����sql���
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
