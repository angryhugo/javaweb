package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Search;
import business.InsDelUpd;;

/**
 * Servlet implementation class InsVehicle
 */
@WebServlet("/InsVehicle")
public class InsVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsVehicle() {
        super();
        // TODO Auto-generated constructor stub
    }
    public static String change(String s) throws Exception
    {
    	byte b[]=s.getBytes("ISO-8859-1");//必须先做转换！！！
    	String snew=new String(b);
    	return snew;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		Search search=new Search();
		InsDelUpd insert=new InsDelUpd();
		StringBuilder s = new StringBuilder();
		String model=request.getParameter("model");
		String color=request.getParameter("color");
		String manu=request.getParameter("manu");
		String year=request.getParameter("yearselect");
		String price=request.getParameter("price");
		String vnum=null;
		out.println("<HTML>");
		out.println("<HEAD><meta http-equiv='Content-Type' content='text/html; charset=gb2312'><link rel='stylesheet' href='Business/script04.css'><script src='JavaScript/checkInsVehicle.js'></script><script src='Business/jQuery.js'></script><script src='Business/jquery/jquery.tablesorter.js'></script><script src='Business/script05.js'></script><style type='text/css'>.style1 {font-family: '华文行楷'; font-size: 24px; font-style: normal; color: #666666; }.style2 {font-family: Arial, Helvetica, sans-serif; font-size: 12px; font-style: normal; color: #006666; }</style></HEAD>");
		out.println("<BODY>");
		out.println("<p align='center' class='style1'>录入车辆信息</p>");
		out.println("<form id=\"form1\" name=\"form1\" action='InsVehicle'><p class='style2'>型号：<input name='model' type='text' size='12'/>");
		out.println("颜色：<input name='color' type='text' size='4'/>");
		out.println("生产厂商：<input name='manu' type='text' size='12'/>");
		out.println("出厂年份：<select name='yearselect' size='1' id='select'><option value='2007'>2007</option><option value='2008'>2008</option><option value='2009'>2009</option><option value='2010'>2010</option><option value='2011'>2011</option><option value='2012' selected='selected'>2012</option><option value='2013'>2013</option></select>");
		out.println("价格：<input name='price' type='text' size='12'/>");
		out.println("<input type='button' value='录入' onclick='checkInsVehicle();'/></p></form>");
		try {
			ResultSet rs  = search.getRs("select * from V_vcle");
			while(rs.next())
			{
				vnum=rs.getString("Vnum");
			}
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(vnum!=null)
		{
			int num=Integer.parseInt(vnum.substring(1, 4));
			num++;
			if(num<10)
				vnum="V00"+String.valueOf(num);
			else	if(num<100)
				vnum="V0"+String.valueOf(num);
			else
				vnum="V"+String.valueOf(num);
		}
		if(vnum!=null && model!=null && color!=null && manu!=null && year!=null && price!=null)
		{
			try {//必须做转换 不然乱码
				model=change(model);
				color=change(color);
				manu=change(manu);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String sql="insert into vehicle values('"+vnum+"','"+model+"','"+color+"','"+manu+"','"+year+"','"+price+"')";
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
			s = search.search_vehicle("select * from V_vcle");
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
