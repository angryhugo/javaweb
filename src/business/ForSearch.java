package business;
import business.Fordate;

public class ForSearch extends Search {
	public StringBuilder queryOpition(String option) throws Exception
	{
		StringBuilder s=new StringBuilder();
		if(option.equals("SA"))
		{
			s=s.append("<p align='center' class='style1'>全部销售员信息</p>");
			s=s.append(search_salesman("select * from V_sman"));
		}
		else if(option.equals("SH"))
		{
			s=s.append("<p align='center' class='style1'>有业绩销售员信息</p>");
			s=s.append(search_salesman("select * from V_sman_haverecond"));
		}
		else if(option.equals("SN"))
		{
			s=s.append("<p align='center' class='style1'>无业绩销售员信息</p>");
			s=s.append(search_salesman("select * from V_sman_norecond"));
		}
		else if(option.equals("CH"))
		{
			s=s.append("<p align='center'  class='style1'>成交客户信息</p>");
			s=s.append(search_customer("select * from V_cmer_haverecond"));
		}
		else if(option.equals("CN"))
		{
			s=s.append("<p align='center'  class='style1'>未成交客户信息</p>");
			s=s.append(search_customer("select * from V_cmer_norecond"));
		}
		else if(option.equals("CA"))
		{
			s=s.append("<p align='center' class='style1'>全部客户信息</p>");
			s=s.append(search_customer("select * from V_cmer"));
		}
		else if(option.equals("VA"))
		{
			s=s.append("<p align='center' class='style1'>全部车辆信息</p>");
			s=s.append(search_vehicle("select * from V_vcle"));
		}
		else if(option.equals("VCB"))
		{
			s=s.append("<p align='center'  class='style1'>黑色车辆信息</p>");
			s=s.append(search_vehicle("select * from V_vcle_black"));
		}
		else if(option.equals("VCW"))
		{
			s=s.append("<p align='center'  class='style1'>白色车辆信息</p>");
			s=s.append(search_vehicle("select * from V_vcle_white"));
		}
		else if(option.equals("VCS"))
		{
			s=s.append("<p align='center'  class='style1'>银色车辆信息</p>");
			s=s.append(search_vehicle("select * from V_vcle_silvery"));
		}
		else if(option.equals("VCO"))
		{
			s=s.append("<p align='center'  class='style1'>其他颜色车辆信息</p>");
			s=s.append(search_vehicle("select * from V_vcle_cother"));
		}
		else if(option.equals("VMBenz"))
		{
			s=s.append("<p align='center'  class='style1'>奔驰车辆信息</p>");
			s=s.append(search_vehicle("select * from V_vcle_benz"));
		}
		else if(option.equals("VMBMW"))
		{
			s=s.append("<p align='center'  class='style1'>宝马车辆信息</p>");
			s=s.append(search_vehicle("select * from V_vcle_bmw"));
		}
		else if(option.equals("VMAUDI"))
		{
			s=s.append("<p align='center'  class='style1'>奥迪车辆信息</p>");
			s=s.append(search_vehicle("select * from V_vcle_audi"));
		}
		else if(option.equals("VMO"))
		{
			s=s.append("<p align='center'  class='style1'>其他品牌车辆信息</p>");
			s=s.append(search_vehicle("select * from V_vcle_omanu"));
		}
		else if(option.equals("VD1"))
		{
			s=s.append("<p align='center'  class='style1'>2009年前出厂车辆信息</p>");
			s=s.append(search_vehicle("select * from V_vcle_date1"));
		}
		else if(option.equals("VD2"))
		{
			s=s.append("<p align='center'  class='style1'>2010-2011年出厂车辆信息</p>");
			s=s.append(search_vehicle("select * from V_vcle_date2"));
		}
		else if(option.equals("VD3"))
		{
			s=s.append("<p align='center'  class='style1'>2012年后出厂车辆信息</p>");
			s=s.append(search_vehicle("select * from V_vcle_date3"));
		}
		else if(option.equals("VP1"))
		{
			s=s.append("<p align='center'  class='style1'>50万以下车辆信息</p>");
			s=s.append(search_vehicle("select * from V_vcle_price1"));
		}
		else if(option.equals("VP2"))
		{
			s=s.append("<p align='center'  class='style1'>50-100万车辆信息</p>");
			s=s.append(search_vehicle("select * from V_vcle_price2"));
		}
		else if(option.equals("VP3"))
		{
			s=s.append("<p align='center'  class='style1'>100万以上车辆信息</p>");
			s=s.append(search_vehicle("select * from V_vcle_price3"));
		}
		else if(option.equals("SaSo"))
		{
			String sql = "select salesman.Sid,Sname,Sgender,Sage,Saddress,Seducation,sum(sale.Samount)'saleamount',SUM(vehicle.Vprice)'totalprice' from salesman left join sale on sale.Sid=salesman.Sid,vehicle where vehicle.Vnum=sale.Vnum and left(Sdate,6)= '"
					+ Fordate.getNow_date()
					+ "' group by salesman.Sid,Sname,Sgender,Sage,Saddress,Seducation";
			s = s.append("<p align='center'  class='style1'>按员工分组本月销售业绩</p>");
			s = s.append(search_sale_byS(sql));
		}
		else if(option.equals("SaSt"))
		{
			String sql = "select salesman.Sid,Sname,Sgender,Sage,Saddress,Seducation,sum(sale.Samount)'saleamount',SUM(vehicle.Vprice)'totalprice' from salesman left join sale on sale.Sid=salesman.Sid,vehicle where vehicle.Vnum=sale.Vnum and left(Sdate,6) between '"
					+ Fordate.getPre_date()
					+ "' and '"+Fordate.getNow_date()+"' group by salesman.Sid,Sname,Sgender,Sage,Saddress,Seducation";
			s = s.append("<p align='center'  class='style1'>按员工分组近三个月销售业绩</p>");
			s = s.append(search_sale_byS(sql));
		}
		else if(option.equals("SaSa"))
		{
			s=s.append("<p align='center'  class='style1'>按员工分组总销售业绩</p>");
			s=s.append(search_sale_byS("select * from V_sale_sall"));
		}
		else if(option.equals("SaMo"))
		{
			String sql = "select vehicle.Vmanu,Sum(sale.Samount)'saleamount',SUM(vehicle.Vprice*sale.Samount)'totalprice' from vehicle,sale where vehicle.Vnum=sale.Vnum and left(Sdate,6)= '"
					+ Fordate.getNow_date()
					+ "' group by vehicle.Vmanu";
			s=s.append("<p align='center'  class='style1'>按厂商分组本月销售业绩</p>");
			s=s.append(search_sale_byM(sql));
		}
		else if(option.equals("SaMt"))
		{
			String sql = "select vehicle.Vmanu,Sum(sale.Samount)'saleamount',SUM(vehicle.Vprice*sale.Samount)'totalprice' from vehicle,sale where vehicle.Vnum=sale.Vnum and left(Sdate,6) between '"
					+ Fordate.getPre_date()
					+ "' and '"+Fordate.getNow_date()+"' group by vehicle.Vmanu";
			s=s.append("<p align='center'  class='style1'>按厂商分组近三个月销售业绩</p>");
			s=s.append(search_sale_byM(sql));
		}
		else if(option.equals("SaMa"))
		{
			s=s.append("<p align='center'  class='style1'>按厂商分组总销售业绩</p>");
			s=s.append(search_sale_byM("select * from V_sale_mall"));
		}
		else if(option.equals("SaAo"))
		{
			s=s.append("<p align='center'  class='style1'>本月销售记录明细</p>");
			s=s.append(search_sale("select * from V_sale where LEFT(V_Sale.Sdate,6)='"+Fordate.getNow_date()+"'"));
		}
		else if(option.equals("SaAt"))
		{
			s=s.append("<p align='center'  class='style1'>近三个月销售记录明细</p>");
			s=s.append(search_sale("select * from V_sale where LEFT(V_Sale.Sdate,6) between '"+Fordate.getPre_date()+"' and '"+Fordate.getNow_date()+"'"));
		}
		else if(option.equals("SaAa"))
		{
			s=s.append("<p align='center'  class='style1'>全部销售记录明细</p>");
			s=s.append(search_sale("select * from V_sale"));
		}
		else if (option.equals("SaPao")) {
			String sql = "select salesman.Sid,Sname,sum(sale.Samount)'saleamount' from salesman,sale where LEFT(sale.Sdate,6)= '"
					+ Fordate.getNow_date()
					+ "'and sale.Sid=salesman.Sid group by salesman.Sid,Sname order by saleamount desc";
			s = s.append("<p align='center'  class='style1'>本月销售量排行榜</p>");
			s = s.append(search_phb_amout(sql));
		}
        else if (option.equals("SaPat")) {
			String sql = "select salesman.Sid,Sname,sum(sale.Samount)'saleamount' from salesman,sale where LEFT(sale.Sdate,6) between '"
					+ Fordate.getPre_date()
					+ "' and '"
					+ Fordate.getNow_date()
					+ "'and sale.Sid=salesman.Sid group by salesman.Sid,Sname order by saleamount desc";
			s = s.append("<p align='center'  class='style1'>近三个月销售量排行榜</p>");
			s = s.append(search_phb_amout(sql));
		}
		else if(option.equals("SaPaa"))
		{
			s=s.append("<p align='center'  class='style1'>全部销售量排行榜</p>");
			s=s.append(search_phb_amout("select * from V_phb_amount order by saleamount desc"));
		}
		else if(option.equals("SaPpo"))
		{
			String sql="select salesman.Sid,Sname,SUM(vehicle.Vprice*sale.Samount)'totalprice' from salesman,sale,vehicle where LEFT(sale.Sdate,6)= '"
					+ Fordate.getNow_date()
					+ "'and vehicle.Vnum=sale.Vnum and sale.Sid=salesman.Sid group by salesman.Sid,Sname order by totalprice desc";
			s=s.append("<p align='center'  class='style1'>本月销售额排行榜</p>");
			s=s.append(search_phb_price(sql));
		}
		else if(option.equals("SaPpt"))
		{
			String sql = "select salesman.Sid,Sname,SUM(vehicle.Vprice*sale.Samount)'totalprice' from salesman,sale,vehicle where LEFT(sale.Sdate,6) between '"
					+ Fordate.getPre_date()
					+ "' and '"
					+ Fordate.getNow_date()
					+ "'and vehicle.Vnum=sale.Vnum and sale.Sid=salesman.Sid group by salesman.Sid,Sname order by totalprice desc";
			s = s.append("<p align='center'  class='style1'>近三个月销售额排行榜</p>");
			s = s.append(search_phb_price(sql));
		}
		else if(option.equals("SaPpa"))
		{
			s=s.append("<p align='center'  class='style1'>全部销售额排行榜</p>");
			s=s.append(search_phb_price("select * from V_phb_totalprice order by totalprice desc"));
		}
		return s;
	}
/*
	public StringBuilder queryOpition(String option,String name) throws Exception{
		StringBuilder s=new StringBuilder();
		if(option.equals("Sao"))
		{
			s=s.append("<p align='center'  class='style1'>本月销售记录明细</p>");
			s=s.append(search_sale("select * from V_sale where Sname='"+name+"' and LEFT(V_Sale.Sdate,6)='"+Fordate.getNow_date()+"'"));
		}
		else if(option.equals("Sat"))
		{
			s=s.append("<p align='center'  class='style1'>近三个月销售记录明细</p>");
			s=s.append(search_sale("select * from V_sale where Sname='"+name+"' and LEFT(V_Sale.Sdate,6) between '"+Fordate.getPre_date()+"' and '"+Fordate.getNow_date()+"'"));
		}
		else if(option.equals("Saa"))
		{
			s=s.append("<p align='center'  class='style1'>全部销售记录明细</p>");
			s=s.append(search_sale("select * from V_sale where Sname='"+name+"'"));
		}
		//受理的客户
		else if(option.equals("CM"))
		{
			s=s.append("<p align='center'  class='style1'>受理客户信息</p>");
			s=s.append(search_customer("select distinct customer.Cid,Cname,Cgender,Cage,Ccontact,Caddress from customer,salesman,sale where sale.Cid=customer.Cid and sale.Sid=salesman.Sid and salesman.Sname='"+name+"'"));
		}
		return s;
	}*/
}
