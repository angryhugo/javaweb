package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Fordate;
import business.Search;
import business.InsDelUpd;;

/**
 * Servlet implementation class InsSale
 */
@WebServlet("/InsSale")
public class InsSale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsSale() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Search search = new Search();
		StringBuilder s = new StringBuilder();
		InsDelUpd insert=new InsDelUpd();
		String Sid=request.getParameter("salesmanselect");
		String Cid=request.getParameter("customerselect");
		String Vnum=request.getParameter("vehicleselect");
		String date=request.getParameter("sdate");
		String amount=request.getParameter("amountselect");
		int Samount=1;
		String Snum=null;
		String Sdate =null;
		if(date!=null)
		{
			Sdate=Fordate.Change(date);
		}
		if(amount!=null)
		{
			Samount=Integer.parseInt(amount);
		}
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><meta http-equiv='Content-Type' content='text/html; charset=gb2312'><link rel='stylesheet' href='Business/script04.css'><script src='JavaScript/checkdate.js'></script><script src='Business/jQuery.js'></script><script src='Business/jquery/jquery.tablesorter.js'></script><script src='Business/script05.js'></script><link rel='stylesheet' href='Business/jquery-ui/jquery-ui-1.9.2.custom.css'><script src='Business/jquery-ui/jquery-1.8.3.js'></script><script src='Business/jquery-ui/jquery-ui-1.9.2.custom.js'></script><script src='Business/jquery-ui/calendar.js'></script><style type='text/css'>.style1 {font-family: '华文行楷'; font-size: 24px; font-style: normal; color: #666666; }.style2 {font-family: Arial, Helvetica, sans-serif; font-size: 12px; font-style: normal; color: #006666; }</style></HEAD>");
		out.println("<BODY>");
		out.println("<p align='center' class='style1'>录入销售信息</p>");
		out.println("<form id=\"form1\" name=\"form1\" action='InsSale'><p class='style2'>员工：<select name='salesmanselect' size='1' id='select'>");
		try {
			ResultSet rs  = search.getRs("select * from V_sman");
			while(rs.next())
			{
				out.print("<option value='"+rs.getString("Sid")+"'>"+rs.getString("Sname")+"</option>");
			}
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("</select>");
		out.println("客户：<select name='customerselect' size='1' id='select'>");
		try {
			ResultSet rs  = search.getRs("select * from V_cmer");
			while(rs.next())
			{
				out.print("<option value='"+rs.getString("Cid")+"'>"+rs.getString("Cname")+"</option>");
			}
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("</select>");
		out.println("车辆：<select name='vehicleselect' size='1' id='select'>");
		try {
			ResultSet rs  = search.getRs("select * from V_vcle");
			while(rs.next())
			{
				out.print("<option value='"+rs.getString("Vnum")+"'>"+rs.getString("Vmodel")+"</option>");
			}
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("</select>");
		out.println("<label for=\"sdate\">销售日期</label><input type=\"text\" id=\"sdate\" name=\"sdate\"  size='12'/> ");
		out.println("数量：<select name='amountselect' size='1' id='select'><option value='1'  selected='selected'>1</option><option value='2'>2</option><option value='3'>3</option><option value='4'>4</option><option value='5'>5</option></select>");
		out.println("<input type='button' value='录入' onclick='checkdate();'/></p></form>");
		
		try {
			ResultSet rs  = search.getRs("select * from sale");
			while(rs.next())
			{
				Snum=rs.getString("Snum");
			}
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(Snum!=null)
		{
			int num=Integer.parseInt(Snum.substring(1, 4));
			num++;
			if(num<10)
				Snum="S00"+String.valueOf(num);
			else if(num<100)
				Snum="S0"+String.valueOf(num);
			else
				Snum="S"+String.valueOf(num);
		}
		if(Snum!=null && Sid!=null && Cid!=null && Vnum!=null && Sdate!=null)
		{
			String sql="insert into sale values('"+Snum+"','"+Sid+"','"+Cid+"','"+Vnum+"','"+Sdate+"','"+Samount+"')";
			try {
				if(insert.doIDU(sql))
					out.print("<script language=javascript>alert('录入成功！');</script>");
				else
					out.print("<script language=javascript>alert('录入失败！');</script>");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print("<script language=javascript>alert('录入失败！');</script>");
			}
		}
		try {
			s = search.search_sale("select * from V_sale");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(s);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
