package business;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import yhc.Db;

public class Salesman extends Db {
	public Salesman(){
	}
	// ��֤��¼
		public boolean checkSalesman(String id, String password) throws Exception {
			con = getConnection();
			// ����PreparedStatement��ֹsqlע��
			PreparedStatement pstmt = con
					.prepareStatement("SELECT * FROM salesman WHERE Sid=? and Spassword=?");
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			boolean b = false;
			if(rs.next())
			{//SQL�����ִ�Сд ������java�ж����ִ�Сд
				if(rs.getString("Sid").trim().equals(id)&&rs.getString("Spassword").trim().equals(password))
					b=true;
			}
			rs.close();
			con.close();
			return b;
		}
		//ȡ����Ա����
		public String getSname(String sid, String password) throws Exception {
			con = getConnection();
			Statement stmt = con.createStatement(); // ����SQL�������
			ResultSet rs = stmt.executeQuery("SELECT * FROM salesman WHERE Sid='"
					+ sid + "' and Spassword='" + password + "'");// ����SQL����ѯ�����(����)
			rs.next();
			String sname = rs.getString("Sname");
			rs.close();
			con.close();
			return sname;
		}
}
