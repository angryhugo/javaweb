package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.Salesman;
import business.InsDelUpd;

/**
 * Servlet implementation class UpdPsw_S
 */
@WebServlet("/UpdPsw_S")
public class UpdPsw_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdPsw_S() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		Salesman salesman=new Salesman();
		InsDelUpd update = new InsDelUpd();
		String opsw = request.getParameter("opsw");
		String npsw1 = request.getParameter("npsw1");
		String npsw2 = request.getParameter("npsw2");
		HttpSession session = request.getSession();
		String sid=(String) session.getAttribute("用户名");
		out.println("<HTML>");
		out.println("<HEAD><meta http-equiv='Content-Type' content='text/html; charset=gb2312'><link rel=\"stylesheet\" type=\"text/css\" href=\"test.css\"><script src='JavaScript/checkUpdPsw.js'></script><style type='text/css'>.style1 {font-family: '华文行楷'; font-size: 24px; font-style: normal; color: #666666; }</style></HEAD>");
		out.println("<BODY>");
		out.println("<p align='center' class='style1'>修改密码</p>");
		out.println("<form id=\"form1\" name=\"form1\" action='UpdPsw_S'>");
		out.print("<table width=\"29%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">");
		out.print("<tr><td>用户名：</td><td><input name='id' type='text' readonly='readonly' value='"+sid+"' size='12'/>");
		out.print("<tr><td>旧密码：</td><td><input name=\"opsw\" type=\"password\" size=\"16\"/></td></tr>");
		out.print("<tr><td>新密码：</td><td><input name=\"npsw1\" type=\"password\" size=\"16\"/></td></tr>");
		out.print("<tr><td>新密码：</td><td><input name=\"npsw2\" type=\"password\" size=\"16\"/></td></tr>");
		out.print("<tr><td></td><td><input type=\"button\" value=\"修改\" onclick='checkUpdPsw();'/></td></tr>");
		out.print("<tr><td>提示：</td><td>密码只能由字母、数字或者下划线组成；长度为6-16位。</td></tr>");
		out.print("</table></form");
		out.println("<BODY><HTML>");
		if(sid!=null && opsw!=null && npsw1!=null)
		{
			try {
				if(salesman.checkSalesman(sid, opsw))
				{
					String sql="update salesman set Spassword='"+npsw1+"' where Sid='"+sid+"'";
					if(update.doIDU(sql))
						out.print("<script language=javascript>alert('修改成功,请重新登录！');window.parent.location='login.jsp';</script>");//window.parent父页面
					else 
						out.print("<script language=javascript>alert('修改失败！');</script>");
				}
				else
					out.print("<script language=javascript>alert('旧密码不正确！');</script>");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
