package business;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import yhc.Db;

public class Salesman extends Db {
	public Salesman(){
	}
	// 验证登录
		public boolean checkSalesman(String id, String password) throws Exception {
			con = getConnection();
			// 利用PreparedStatement防止sql注入
			PreparedStatement pstmt = con
					.prepareStatement("SELECT * FROM salesman WHERE Sid=? and Spassword=?");
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			boolean b = false;
			if(rs.next())
			{//SQL不区分大小写 所以用java判断区分大小写
				if(rs.getString("Sid").trim().equals(id)&&rs.getString("Spassword").trim().equals(password))
					b=true;
			}
			rs.close();
			con.close();
			return b;
		}
		//取销售员姓名
		public String getSname(String sid, String password) throws Exception {
			con = getConnection();
			Statement stmt = con.createStatement(); // 创建SQL命令对象
			ResultSet rs = stmt.executeQuery("SELECT * FROM salesman WHERE Sid='"
					+ sid + "' and Spassword='" + password + "'");// 返回SQL语句查询结果集(集合)
			rs.next();
			String sname = rs.getString("Sname");
			rs.close();
			con.close();
			return sname;
		}
}
