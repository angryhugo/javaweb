package business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import yhc.Db;

public class Manager extends Db {
	public Manager() {
	}

	// ��֤��¼
	public boolean checkManager(String name, String password) throws Exception {
		con = getConnection();
		// ����PreparedStatement��ֹsqlע��
		PreparedStatement pstmt = con
				.prepareStatement("SELECT * FROM manager WHERE Mname=? and Mpassword=?");
		pstmt.setString(1, name);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		boolean b=false;
		if(rs.next())
		{//SQL�����ִ�Сд ������java�ж����ִ�Сд
			if(rs.getString("Mname").trim().equals(name)&&rs.getString("Mpassword").trim().equals(password))
				b=true;
		}
		rs.close();
		con.close();
		return b;
	}
}
