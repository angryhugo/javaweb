package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.Search;

/**
 * Servlet implementation class QueryCar
 */
@WebServlet("/QueryCar")
public class QueryCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryCar() {
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
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		String color = request.getParameter("colorselect");
		String manu = request.getParameter("manuselect");
		String year = request.getParameter("yearselect");
		String price = request.getParameter("priceselect");
		out.println("<HTML>");
		out.println("<HEAD><meta http-equiv='Content-Type' content='text/html; charset=gb2312'><link rel='stylesheet' href='Business/script04.css'><script src='Business/jQuery.js'></script><script src='Business/jquery/jquery.tablesorter.js'></script><script src='Business/script05.js'></script><style type='text/css'>.style1 {font-family: '华文行楷'; font-size: 24px; font-style: normal; color: #666666; }.style2 {font-family: Arial, Helvetica, sans-serif; font-size: 12px; font-style: normal; color: #006666; }</style></HEAD>");
		out.println("<BODY>");
		out.println("<p align='center' class='style1'>车辆信息自定义查询</p>");
		out.println("<form action='QueryCar'><p class='style2'>颜色：<select name='colorselect' size='1' id='select'><option value='black'>黑色</option><option value='white'>白色</option><option value='silvery'>银色</option><option value='else'>其他</option><option value='all'  selected='selected'>不限</option></select>");
		out.println("厂商：<select name='manuselect' size='1' id='select'><option value='benz'>奔驰</option><option value='bmw'>宝马</option><option value='audi'>奥迪</option><option value='else'>其他</option><option value='all'  selected='selected'>不限</option></select>");
		out.println("出厂年份：<select name='yearselect' size='1' id='select'><option value='2009'>2009年前</option><option value='2010'>2010-2011年</option><option value='2012'>2012年后</option><option value='all'  selected='selected'>不限</option></select>");
		out.println("价格：<select name='priceselect' size='1' id='select'><option value='b50'>50万以下</option><option value='50'>50-100万</option><option value='u100'>100万以上</option><option value='all'  selected='selected'>不限</option></select>");
		out.println("<input type='submit' value='查询' /></p></form>");
		if (color != null && manu != null && year != null && price != null) {
			String sql = "select * from vehicle where ";
			String youroption = "<p class='style2'>您的选择：";
			if (color.equals("black")) {
				sql = sql + "Vcolor='黑色'";
				youroption = youroption + "颜色：<font color=\"#36F\">黑色</font>";
			} else if (color.equals("white")) {
				sql = sql + "Vcolor='白色'";
				youroption = youroption + "颜色：<font color=\"#36F\">白色</font>";
			} else if (color.equals("silvery")) {
				sql = sql + "Vcolor='银色'";
				youroption = youroption + "颜色：<font color=\"#36F\">银色</font>";
			} else if (color.equals("else")) {
				sql = sql + "Vcolor not in('黑色','白色','银色')";
				youroption = youroption + "颜色：<font color=\"#36F\">其他</font>";
			} else if (color.equals("all")) {
				sql = sql + "Vcolor is not null";
				youroption = youroption + "颜色：<font color=\"#36F\">不限</font>";
			}

			if (manu.equals("benz")) {
				sql = sql + " and Vmanu='奔驰'";
				youroption = youroption + " 厂商：<font color=\"#36F\">奔驰</font>";
			} else if (manu.equals("bmw")) {
				sql = sql + " and Vmanu='宝马'";
				youroption = youroption + " 厂商：<font color=\"#36F\">宝马</font>";
			} else if (manu.equals("audi")) {
				sql = sql + " and Vmanu='奥迪'";
				youroption = youroption + " 厂商：<font color=\"#36F\">奥迪</font>";
			} else if (manu.equals("else")) {
				sql = sql + " and Vmanu not in ('奔驰','宝马','奥迪')";
				youroption = youroption + " 厂商：<font color=\"#36F\">其他</font>";
			} else if (manu.equals("all")) {
				sql = sql + " and Vmanu is not null";
				youroption = youroption + " 厂商：<font color=\"#36F\">不限</font>";
			}

			if (year.equals("2009")) {
				sql = sql + " and Vdate<='2009'";
				youroption = youroption + " 出厂年份：<font color=\"#36F\">2009年前</font>";
			} else if (year.equals("2010")) {
				sql = sql + " and Vdate between '2010' and '2011'";
				youroption = youroption + " 出厂年份：<font color=\"#36F\">2010-2011年</font>";
			} else if (year.equals("2012")) {
				sql = sql + " and Vdate>='2012'";
				youroption = youroption + " 出厂年份：<font color=\"#36F\">2012年后</font>";
			} else if (year.equals("all")) {
				sql = sql + " and Vdate is not null";
				youroption = youroption + " 出厂年份：<font color=\"#36F\">不限</font>";
			}

			if (price.equals("b50")) {
				sql = sql + " and Vprice<500000";
				youroption = youroption + " 价格：<font color=\"#36F\">50万以下</font></p>";
			} else if (price.equals("50")) {
				sql = sql + " and Vprice between 500000 and 1000000";
				youroption = youroption + " 价格：<font color=\"#36F\">50-100万</font></p>";
			} else if (price.equals("u100")) {
				sql = sql + " and Vprice>1000000";
				youroption = youroption + " 价格：<font color=\"#36F\">100万以上</font></p>";
			}else if (price.equals("all")) {
				sql = sql + " and Vprice is not null";
				youroption = youroption + " 价格：<font color=\"#36F\">不限</font></p>";
			}

			try {
				s = search.search_vehicle(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.print(youroption);//StringBulider不能直接用equals的方法 否则比较的是地址
			if(s.toString().equals("<table id=\"theTable\" width='100%'><thead><tr><th>编号<th>型号<th>颜色<th>生产厂商<th>出厂日期<th>价格</tr></thead>"))
				out.print("<script language=javascript>alert('对不起，没有符合选项的车辆信息！');</script>");
			else
				out.print(s);
		}

		out.println("<BODY></HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
