package yhc;

import java.io.Serializable;
import java.sql.*;

public class Db implements Serializable{
	private  String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private  String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=JavaWeb";
	private String userName = "sa";
	private  String userPwd = "123456";
	public Connection con;
	// 连接
	public Connection getConnection() throws Exception {
			Class.forName(driverName);
			con=DriverManager.getConnection(dbURL, userName, userPwd);
			return con;
	}
	//执行stmt select语句
	public void excuteStmt(String sql) throws Exception
	{
		Connection con = getConnection();
		Statement stmt = con.createStatement(); // 创建SQL命令对象
		stmt.executeQuery(sql);//返回SQL语句查询结果集(集合)
	}
	//执行stmt insert update delete语句
	public int excuteStmtIUD(String sql) throws Exception
	{
		Connection con = getConnection();
		Statement stmt = con.createStatement(); // 创建SQL命令对象
		return stmt.executeUpdate(sql);
	}
	//取ResultSet
	public ResultSet getRs(String sql) throws Exception
	{
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		return rs;
	}
	
}
