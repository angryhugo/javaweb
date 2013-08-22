package yhc;

import java.io.Serializable;
import java.sql.*;

public class Db implements Serializable{
	private  String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private  String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=JavaWeb";
	private String userName = "sa";
	private  String userPwd = "123456";
	public Connection con;
	// ����
	public Connection getConnection() throws Exception {
			Class.forName(driverName);
			con=DriverManager.getConnection(dbURL, userName, userPwd);
			return con;
	}
	//ִ��stmt select���
	public void excuteStmt(String sql) throws Exception
	{
		Connection con = getConnection();
		Statement stmt = con.createStatement(); // ����SQL�������
		stmt.executeQuery(sql);//����SQL����ѯ�����(����)
	}
	//ִ��stmt insert update delete���
	public int excuteStmtIUD(String sql) throws Exception
	{
		Connection con = getConnection();
		Statement stmt = con.createStatement(); // ����SQL�������
		return stmt.executeUpdate(sql);
	}
	//ȡResultSet
	public ResultSet getRs(String sql) throws Exception
	{
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		return rs;
	}
	
}
