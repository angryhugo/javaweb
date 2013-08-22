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
 * Servlet implementation class QuerySalesman
 */
@WebServlet("/QuerySalesman")
public class QuerySalesman extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuerySalesman() {
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
		String name=request.getParameter("name");
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><meta http-equiv='Content-Type' content='text/html; charset=gb2312'></script><link rel='stylesheet' href='Business/script04.css'><script src='Business/jQuery.js'></script><script src='Business/jquery/jquery.tablesorter.js'></script><script src='Business/script05.js'></script><style type='text/css'>.style1 {font-family: '华文行楷'; font-size: 24px; font-style: normal; color: #666666; }.style2 {font-family: Arial, Helvetica, sans-serif; font-size: 12px; font-style: normal; color: #006666; }</style></HEAD>");
		out.println("<BODY>");
		out.println("<p align='center' class='style1'>员工信息自定义查询</p>");
		out.println("<form action='QuerySalesman'><p class='style2'>姓名关键字：<input name='name' type='text' size='12'/><input type='submit' value='查询' /></p></form>");
	    if(name!=null)
	    {
	    	byte b[]=name.getBytes("ISO-8859-1");//必须先做转换！！！
	    	name=new String(b);
	    	String keyword = "<p class='style2'>您输入的关键字：<font color=\"#36F\">"+name+"</font></p>";
	    	String sql="select * from V_sman where Sname like '%"+name+"%'";
	    	try {
				s=search.search_salesman(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	out.print(keyword);
	    	out.print(s);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
