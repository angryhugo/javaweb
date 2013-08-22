package business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import yhc.Db;

public class InsDelUpd extends Db {
	public  boolean doIDU(String sql) throws Exception
	{
		if(excuteStmtIUD(sql)==0)
		{
			return false;
		}
		else 
			return true;
	}
}
