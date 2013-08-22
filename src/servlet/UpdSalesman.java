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
import business.InsDelUpd;

;

/**
 * Servlet implementation class UpdSalesman
 */
@WebServlet("/UpdSalesman")
public class UpdSalesman extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdSalesman() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static String change(String s) throws Exception {
		byte b[] = s.getBytes("ISO-8859-1");// ��������ת��������
		String snew = new String(b);
		return snew;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		Search search = new Search();
		InsDelUpd update = new InsDelUpd();
		String name = request.getParameter("name");
		String gender = request.getParameter("genderselect");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
		String education = request.getParameter("education");
		String sid = request.getParameter("id");
		out.println("<HTML>");
		out.println("<HEAD><meta http-equiv='Content-Type' content='text/html; charset=gb2312'><link rel=\"stylesheet\" type=\"text/css\" href=\"test.css\"><script src='JavaScript/checkUpdnull.js'></script><script src='JavaScript/doUpdSalesman.js'></script><style type='text/css'>.style1 {font-family: '�����п�'; font-size: 24px; font-style: normal; color: #666666; }</style></HEAD>");
		out.println("<BODY>");
		out.println("<p align='center' class='style1'>�޸�Ա����Ϣ</p>");
		out.println("<form id=\"form1\" name=\"form1\" action='UpdSalesman'>������Ҫ�޸ĵ�Ա�����ţ�<input name='id' type='text' size='12'/>");
		out.println("<input type='button' value='ȷ��' onclick='checkUpdnull();'/></form>");
		if (sid != null && name == null) {
			try {
				ResultSet rs = search.getRs("select * from V_sman where Sid='"
						+ sid + "'");
				if (rs.next()) {    //���ж��Ƿ���ڣ�
					out.print("<form id=\"form2\" name=\"form2\" action='UpdSalesman'> ");
					out.print("<table width=\"29%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">");
					out.print(" <tr><td width=\"18%\">���ţ�</td><td width=\"82%\"><label><input name=\"id\" type=\"text\"  readonly=\"readonly\" value=\""
							+ sid + "\"/></label></td></tr>");
					out.print(" <tr><td >������</td><td ><label><input name=\"name\" type=\"text\" value=\""
							+ rs.getString("Sname") + "\"/></label></td></tr>");
					if (rs.getString("Sgender").trim().equals("M"))// �˴�������trim����ȥ������Ŀո񣡣���
						out.print("<tr><td>�Ա�</td><td><select name='genderselect' size='1' id='select'><option value='M' selected='selected'>��</option><option value='F'>Ů</option></select></td></tr>");
					else
						out.print("<tr><td>�Ա�</td><td><select name='genderselect' size='1' id='select'><option value='M'>��</option><option value='F' selected='selected'>Ů</option></select></td></tr>");
					out.print("<tr><td>���䣺</td><td><input name=\"age\" type=\"text\" size=\"1\" value=\""
							+ rs.getString("Sage") + "\" /></td></tr>");
					out.print("<tr><td>���᣺</td><td><input name=\"address\" type=\"text\" value=\""
							+ rs.getString("Saddress") + "\" /></td></tr>");
					out.print("<tr><td>ѧ����</td><td><input name=\"education\" type=\"text\" value=\""
							+ rs.getString("Seducation") + "\" /></td></tr>");
					out.print("<tr><td></td><td><input type=\"button\" value=\"�޸�\" onclick='doUpdSalesman();'/></td></tr>");
					out.print("</table></form>");
				} else
					out.print("<script language=javascript>alert('�����ڸ�Ա����');</script>");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (sid != null && name != null && gender != null && age != null
				&& address != null && education != null) {
			try {// ������ת�� ��Ȼ����
				name = change(name);
				address = change(address);
				education = change(education);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String sql = "update salesman set Sname='" + name + "',Sage='"
					+ age + "',Sgender='" + gender + "',Saddress='" + address
					+ "',Seducation='" + education + "' where Sid='" + sid
					+ "'";
			try {
				if (update.doIDU(sql))
					out.print("<script language=javascript>alert('�޸ĳɹ���');</script>");
				else
					out.print("<script language=javascript>alert('�޸�ʧ�ܣ�');</script>");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print("<script language=javascript>alert('�޸�ʧ�ܣ�');</script>");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
