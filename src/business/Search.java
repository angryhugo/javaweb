package business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import yhc.Db;

public class Search extends Db {
	// 查询员工信息
	public StringBuilder search_salesman(String sql) throws Exception {
		StringBuilder s = new StringBuilder();
		ResultSet rs = getRs(sql);
		s = s.append("<table id=\"theTable\" width='100%'>");
		s = s.append("<thead>");
		s = s.append("<tr>");
		s = s.append("<th>" + "工号");
		s = s.append("<th>" + "姓名");
		s = s.append("<th>" + "性别");
		s = s.append("<th>" + "年龄");
		s = s.append("<th>" + "籍贯");
		s = s.append("<th>" + "学历");
		s = s.append("<th>" + "修改");
		s = s.append("<th>" + "删除");
		s = s.append("</tr>");
		s = s.append("</thead>");
		// 循环输出每一条记录
		while (rs.next()) {
			// 输出每个字段
			s = s.append("<tr>");
			s = s.append("<td>" + rs.getString("Sid") + "</td>");
			s = s.append("<td>" + rs.getString("Sname") + "</td>");
			s = s.append("<td>" + rs.getString("Sgender") + "</td>");
			s = s.append("<td>" + rs.getString("Sage") + "</td>");
			s = s.append("<td>" + rs.getString("Saddress") + "</td>");
			s = s.append("<td>" + rs.getString("Seducation") + "</td>");
			s = s.append("<td><a href=\"/VehicleSystem/UpdSalesman?id="+rs.getString("Sid")+"\">修改</a></td>");
			s = s.append("<td><a href=\"/VehicleSystem/DelSalesman?name="+rs.getString("Sname")+"\">删除</a></td>");
			s = s.append("</tr>");
		}
		s = s.append("</table>");
		// 关闭连接
		rs.close();
		return s;
	}

	// 查询客户信息(管理员可以修改删除)
	public StringBuilder search_customer(String sql) throws Exception {
		StringBuilder s = new StringBuilder();
		ResultSet rs = getRs(sql);
		s = s.append("<table id=\"theTable\" width='100%'>");
		s = s.append("<thead>");
		s = s.append("<tr>");
		s = s.append("<th>" + "编号");
		s = s.append("<th>" + "姓名");
		s = s.append("<th>" + "性别");
		s = s.append("<th>" + "年龄");
		s = s.append("<th>" + "联系方式");
		s = s.append("<th>" + "地址");
		s = s.append("<th>" + "修改");
		s = s.append("<th>" + "删除");
		s = s.append("</tr>");
		s = s.append("</thead>");
		// 循环输出每一条记录
		while (rs.next()) {
			// 输出每个字段
			s = s.append("<tr>");
			s = s.append("<td>" + rs.getString("Cid") + "</td>");
			s = s.append("<td>" + rs.getString("Cname") + "</td>");
			s = s.append("<td>" + rs.getString("Cgender") + "</td>");
			s = s.append("<td>" + rs.getString("Cage") + "</td>");
			s = s.append("<td>" + rs.getString("Ccontact") + "</td>");
			s = s.append("<td>" + rs.getString("Caddress") + "</td>");
			s = s.append("<td><a href=\"/VehicleSystem/UpdCustomer?id="+rs.getString("Cid")+"\">修改</a></td>");
			s = s.append("<td><a href=\"/VehicleSystem/DelCustomer?name="+rs.getString("Cname")+"\">删除</a></td>");
			s = s.append("</tr>");
		}
		s = s.append("</table>");
		// 关闭连接
		rs.close();
		return s;
	}
	
	// 查询顾客信息
		public StringBuilder search_customer_forS(String sql) throws Exception {
			StringBuilder s = new StringBuilder();
			ResultSet rs = getRs(sql);
			s = s.append("<table id=\"theTable\" width='100%'>");
			s = s.append("<thead>");
			s = s.append("<tr>");
			s = s.append("<th>" + "编号");
			s = s.append("<th>" + "姓名");
			s = s.append("<th>" + "性别");
			s = s.append("<th>" + "年龄");
			s = s.append("<th>" + "联系方式");
			s = s.append("<th>" + "地址");
			s = s.append("</tr>");
			s = s.append("</thead>");
			// 循环输出每一条记录
			while (rs.next()) {
				// 输出每个字段
				s = s.append("<tr>");
				s = s.append("<td>" + rs.getString("Cid") + "</td>");
				s = s.append("<td>" + rs.getString("Cname") + "</td>");
				s = s.append("<td>" + rs.getString("Cgender") + "</td>");
				s = s.append("<td>" + rs.getString("Cage") + "</td>");
				s = s.append("<td>" + rs.getString("Ccontact") + "</td>");
				s = s.append("<td>" + rs.getString("Caddress") + "</td>");
				s = s.append("</tr>");
			}
			s = s.append("</table>");
			// 关闭连接
			rs.close();
			return s;
		}

	// 查询车辆信息(管理员可以修改删除)
	public StringBuilder search_vehicle(String sql) throws Exception {
		StringBuilder s = new StringBuilder();
		ResultSet rs = getRs(sql);
		s = s.append("<table id=\"theTable\" width='100%'>");
		s = s.append("<thead>");
		s = s.append("<tr>");
		s = s.append("<th>" + "编号");
		s = s.append("<th>" + "型号");
		s = s.append("<th>" + "颜色");
		s = s.append("<th>" + "生产厂商");
		s = s.append("<th>" + "出厂年份");
		s = s.append("<th>" + "价格");
		s = s.append("<th>" + "修改");
		s = s.append("<th>" + "删除");
		s = s.append("</tr>");
		s = s.append("</thead>");
		// 循环输出每一条记录
		while (rs.next()) {
			// 输出每个字段
			s = s.append("<tr>");
			s = s.append("<td>" + rs.getString("Vnum") + "</td>");
			s = s.append("<td>" + rs.getString("Vmodel") + "</td>");
			s = s.append("<td>" + rs.getString("Vcolor") + "</td>");
			s = s.append("<td>" + rs.getString("Vmanu") + "</td>");
			s = s.append("<td>" + rs.getString("Vdate") + "</td>");
			s = s.append("<td>" + rs.getFloat("Vprice") + "</td>");
			s = s.append("<td><a href=\"/VehicleSystem/UpdVehicle?id="+rs.getString("Vnum")+"\">修改</a></td>");
			s = s.append("<td><a href=\"/VehicleSystem/DelVehicle?name="+rs.getString("Vnum")+"\">删除</a></td>");
			s = s.append("</tr>");
		}
		s = s.append("</table>");
		// 关闭连接
		rs.close();
		return s;
	}
	
	// 查询车辆信息
		public StringBuilder search_vehicle_forS(String sql) throws Exception {
			StringBuilder s = new StringBuilder();
			ResultSet rs = getRs(sql);
			s = s.append("<table id=\"theTable\" width='100%'>");
			s = s.append("<thead>");
			s = s.append("<tr>");
			s = s.append("<th>" + "编号");
			s = s.append("<th>" + "型号");
			s = s.append("<th>" + "颜色");
			s = s.append("<th>" + "生产厂商");
			s = s.append("<th>" + "出厂年份");
			s = s.append("<th>" + "价格");
			s = s.append("</tr>");
			s = s.append("</thead>");
			// 循环输出每一条记录
			while (rs.next()) {
				// 输出每个字段
				s = s.append("<tr>");
				s = s.append("<td>" + rs.getString("Vnum") + "</td>");
				s = s.append("<td>" + rs.getString("Vmodel") + "</td>");
				s = s.append("<td>" + rs.getString("Vcolor") + "</td>");
				s = s.append("<td>" + rs.getString("Vmanu") + "</td>");
				s = s.append("<td>" + rs.getString("Vdate") + "</td>");
				s = s.append("<td>" + rs.getFloat("Vprice") + "</td>");
				s = s.append("</tr>");
			}
			s = s.append("</table>");
			// 关闭连接
			rs.close();
			return s;
		}

	// 查询销售信息(管理员可以修改删除)
	public StringBuilder search_sale(String sql) throws Exception {
		StringBuilder s = new StringBuilder();
		ResultSet rs = getRs(sql);
		s = s.append("<table id=\"theTable\" width='100%'>");
		s = s.append("<thead>");
		s = s.append("<tr>");
		s = s.append("<th>" + "销售流水号");
		s = s.append("<th>" + "车辆编号");
		s = s.append("<th>" + "型号");
		s = s.append("<th>" + "颜色");
		s = s.append("<th>" + "价格");
		s = s.append("<th>" + "销售日期");
		s = s.append("<th>" + "销售数量");
		s = s.append("<th>" + "客户");
		s = s.append("<th>" + "销售员");
		s = s.append("<th>" + "修改");
		s = s.append("<th>" + "删除");
		s = s.append("</tr>");
		s = s.append("</thead>");
		// 循环输出每一条记录
		while (rs.next()) {
			// 输出每个字段
			s = s.append("<tr>");
			s = s.append("<td>" + rs.getString("Snum") + "</td>");
			s = s.append("<td>" + rs.getString("Vnum") + "</td>");
			s = s.append("<td>" + rs.getString("Vmodel") + "</td>");
			s = s.append("<td>" + rs.getString("Vcolor") + "</td>");
			s = s.append("<td>" + rs.getFloat("Vprice") + "</td>");
			s = s.append("<td>" + rs.getString("Sdate") + "</td>");
			s = s.append("<td>" + rs.getInt("Samount") + "</td>");
			s = s.append("<td>" + rs.getString("Cname") + "</td>");
			s = s.append("<td>" + rs.getString("Sname") + "</td>");
			s = s.append("<td><a href=\"/VehicleSystem/UpdSale?id="+rs.getString("Snum")+"\">修改</a></td>");
			s = s.append("<td><a href=\"/VehicleSystem/DelSale?name="+rs.getString("Snum")+"\">删除</a></td>");
			s = s.append("</tr>");
		}
		s = s.append("</table>");
		// 关闭连接
		rs.close();
		return s;
	}
	
	// 查询销售信息
		public StringBuilder search_sale_forS(String sql) throws Exception {
			StringBuilder s = new StringBuilder();
			ResultSet rs = getRs(sql);
			s = s.append("<table id=\"theTable\" width='100%'>");
			s = s.append("<thead>");
			s = s.append("<tr>");
			s = s.append("<th>" + "销售流水号");
			s = s.append("<th>" + "车辆编号");
			s = s.append("<th>" + "型号");
			s = s.append("<th>" + "颜色");
			s = s.append("<th>" + "价格");
			s = s.append("<th>" + "销售日期");
			s = s.append("<th>" + "销售数量");
			s = s.append("<th>" + "客户");
			s = s.append("<th>" + "销售员");
			s = s.append("</tr>");
			s = s.append("</thead>");
			// 循环输出每一条记录
			while (rs.next()) {
				// 输出每个字段
				s = s.append("<tr>");
				s = s.append("<td>" + rs.getString("Snum") + "</td>");
				s = s.append("<td>" + rs.getString("Vnum") + "</td>");
				s = s.append("<td>" + rs.getString("Vmodel") + "</td>");
				s = s.append("<td>" + rs.getString("Vcolor") + "</td>");
				s = s.append("<td>" + rs.getFloat("Vprice") + "</td>");
				s = s.append("<td>" + rs.getString("Sdate") + "</td>");
				s = s.append("<td>" + rs.getInt("Samount") + "</td>");
				s = s.append("<td>" + rs.getString("Cname") + "</td>");
				s = s.append("<td>" + rs.getString("Sname") + "</td>");
				s = s.append("</tr>");
			}
			s = s.append("</table>");
			// 关闭连接
			rs.close();
			return s;
		}

	// 按员工分组查询销售信息
	public StringBuilder search_sale_byS(String sql) throws Exception {
		StringBuilder s = new StringBuilder();
		ResultSet rs = getRs(sql);
		s = s.append("<table id=\"theTable\" width='100%'>");
		s = s.append("<thead>");
		s = s.append("<tr>");
		s = s.append("<th>" + "工号");
		s = s.append("<th>" + "姓名");
		s = s.append("<th>" + "性别");
		s = s.append("<th>" + "年龄");
		s = s.append("<th>" + "地址");
		s = s.append("<th>" + "学历");
		s = s.append("<th>" + "总销售量");
		s = s.append("<th>" + "总销售额");
		s = s.append("</tr>");
		s = s.append("</thead>");
		// 循环输出每一条记录
		while (rs.next()) {
			// 输出每个字段
			s = s.append("<tr>");
			s = s.append("<td>" + rs.getString("Sid") + "</td>");
			s = s.append("<td>" + rs.getString("Sname") + "</td>");
			s = s.append("<td>" + rs.getString("Sgender") + "</td>");
			s = s.append("<td>" + rs.getFloat("Sage") + "</td>");
			s = s.append("<td>" + rs.getString("Saddress") + "</td>");
			s = s.append("<td>" + rs.getString("Seducation") + "</td>");
			s = s.append("<td>" + rs.getString("saleamount") + "</td>");
			s = s.append("<td>" + rs.getString("totalprice") + "</td>");
			s = s.append("</tr>");
		}
		s = s.append("</table>");
		// 关闭连接
		rs.close();
		return s;
	}

	// 按厂商分组查询销售信息
	public StringBuilder search_sale_byM(String sql) throws Exception {
		StringBuilder s = new StringBuilder();
		ResultSet rs = getRs(sql);
		s = s.append("<table id=\"theTable\" width='100%'>");
		s = s.append("<thead>");
		s = s.append("<tr>");
		s = s.append("<th>" + "生产厂商");
		s = s.append("<th>" + "总销售量");
		s = s.append("<th>" + "总销售额");
		s = s.append("</tr>");
		s = s.append("</thead>");
		// 循环输出每一条记录
		while (rs.next()) {
			// 输出每个字段
			s = s.append("<tr>");
			s = s.append("<td>" + rs.getString("Vmanu") + "</td>");
			s = s.append("<td>" + rs.getString("saleamount") + "</td>");
			s = s.append("<td>" + rs.getString("totalprice") + "</td>");
			s = s.append("</tr>");
		}
		s = s.append("</table>");
		// 关闭连接
		rs.close();
		return s;
	}

	// 查询排行榜 1.
	public StringBuilder search_phb_amout(String sql)throws Exception {
		StringBuilder s = new StringBuilder();
		int count=1;//统计人数
		int pre_ranking=1;//前一次名次
		int ranking=1;//当前名次
		int pre_amount=0;//前一位总销售量
		int amount=0;//当前总销售量
		ResultSet rs = getRs(sql);
		s = s.append("<table  width='100%'>");
		s = s.append("<thead>");
		s = s.append("<tr>");
		s = s.append("<th>" + "名次");//
		s = s.append("<th>" + "工号");
		s = s.append("<th>" + "姓名");
		s = s.append("<th>" + "总销售量");
		s = s.append("</tr>");
		s = s.append("</thead>");
		// 循环输出每一条记录
		while (rs.next()) {
			// 输出每个字段
			s = s.append("<tr>");
			amount=Integer.parseInt(rs.getString("saleamount"));
			if(amount==pre_amount)
			{
				s = s.append("<td>" + pre_ranking+ "</td>");
				ranking=pre_ranking;
			}
			else
			{
				s = s.append("<td>" + count+ "</td>");
				ranking=count;
			}
			s = s.append("<td>" + rs.getString("Sid") + "</td>");
			s = s.append("<td>" + rs.getString("Sname") + "</td>");
			s = s.append("<td>" + rs.getString("saleamount") + "</td>");
			s = s.append("</tr>");
			pre_amount=amount;
			pre_ranking=ranking;
			count++;
		}
		s = s.append("</table>");
		// 关闭连接
		rs.close();
		return s;
	}
	// 查询排行榜 2.
		public StringBuilder search_phb_price(String sql)throws Exception {
			StringBuilder s = new StringBuilder();
			int count=1;//统计人数
			int pre_ranking=1;//前一次名次
			int ranking=1;//当前名次
			double pre_price=0;//前一位总销售额
			double price=0;//当前总销售额
			ResultSet rs = getRs(sql);
			s = s.append("<table  width='100%'>");
			s = s.append("<thead>"); 
			s = s.append("<tr>");
			s = s.append("<th>" + "名次");//
			s = s.append("<th>" + "工号");
			s = s.append("<th>" + "姓名");
			s = s.append("<th>" + "总销售额");
			s = s.append("</tr>");
			s = s.append("</thead>");
			// 循环输出每一条记录
			while (rs.next()) {
				// 输出每个字段
				s = s.append("<tr>");
				price=Double.parseDouble(rs.getString("totalprice"));
				if(price==pre_price)
				{
					s = s.append("<td>" + pre_ranking+ "</td>");
					ranking=pre_ranking;
				}
				else
				{
					s = s.append("<td>" + count+ "</td>");
					ranking=count;
				}
				s = s.append("<td>" + rs.getString("Sid") + "</td>");
				s = s.append("<td>" + rs.getString("Sname") + "</td>");
				s = s.append("<td>" + rs.getString("totalprice") + "</td>");
				s = s.append("</tr>");
				pre_price=price;
				pre_ranking=ranking;
				count++;
			}
			s = s.append("</table>");
			// 关闭连接
			rs.close();
			return s;
		}
}
