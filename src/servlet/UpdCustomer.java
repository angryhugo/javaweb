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

/**
 * Servlet implementation class UpdCustomer
 */
@WebServlet("/UpdCustomer")
public class UpdCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static String change(String s) throws Exception {
		byte b[] = s.getBytes("ISO-8859-1");// ��������ת��������
		String snew = new String(b);
		return snew;
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		Search search = new Search();
		InsDelUpd update = new InsDelUpd();
		String name = request.getParameter("name");
		String gender = request.getParameter("genderselect");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		String cid = request.getParameter("id");
		out.println("<HTML>");
		out.println("<HEAD><meta http-equiv='Content-Type' content='text/html; charset=gb2312'><link rel=\"stylesheet\" type=\"text/css\" href=\"test.css\"><script src='JavaScript/checkUpdnull.js'></script><script src='JavaScript/doUpdCustomer.js'></script><style type='text/css'>.style1 {font-family: '�����п�'; font-size: 24px; font-style: normal; color: #666666; }</style></HEAD>");
		out.println("<BODY>");
		out.println("<p align='center' class='style1'>�޸Ŀͻ���Ϣ</p>");
		out.println("<form id=\"form1\" name=\"form1\" action='UpdCustomer'>������Ҫ�޸ĵĿͻ���ţ�<input name='id' type='text' size='12'/>");
		out.println("<input type='button' value='ȷ��' onclick='checkUpdnull();'/></form>");
		if (cid != null && name == null) {
			try {
				ResultSet rs = search.getRs("select * from V_cmer where Cid='"
						+ cid + "'");
				if (rs.next()) {    //���ж��Ƿ���ڣ�
					out.print("<form id=\"form2\" name=\"form2\" action='UpdCustomer'> ");
					out.print("<table width=\"29%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">");
					out.print(" <tr><td width=\"18%\">��ţ�</td><td width=\"82%\"><label><input name=\"id\" type=\"text\"  readonly=\"readonly\" value=\""
							+ cid + "\"/></label></td></tr>");
					out.print(" <tr><td >������</td><td ><label><input name=\"name\" type=\"text\" value=\""
							+ rs.getString("Cname") + "\"/></label></td></tr>");
					if (rs.getString("Cgender").trim().equals("M"))// �˴�������trim����ȥ������Ŀո񣡣���
						out.print("<tr><td>�Ա�</td><td><select name='genderselect' size='1' id='select'><option value='M' selected='selected'>��</option><option value='F'>Ů</option></select></td></tr>");
					else
						out.print("<tr><td>�Ա�</td><td><select name='genderselect' size='1' id='select'><option value='M'>��</option><option value='F' selected='selected'>Ů</option></select></td></tr>");
					out.print("<tr><td>���䣺</td><td><input name=\"age\" type=\"text\" size=\"1\" value=\""
							+ rs.getString("Cage") + "\" /></td></tr>");
					out.print("<tr><td>��ϵ��ʽ��</td><td><input name=\"contact\" type=\"text\" value=\""
							+ rs.getString("Ccontact") + "\" /></td></tr>");
					out.print("<tr><td>��ַ��</td><td><input name=\"address\" type=\"text\" value=\""
							+ rs.getString("Caddress") + "\" /></td></tr>");
					out.print("<tr><td></td><td><input type=\"button\" value=\"�޸�\" onclick='doUpdCustomer();'/></td></tr>");
					out.print("</table></form");
				} else
					out.print("<script language=javascript>alert('�����ڸÿͻ���');</script>");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (cid != null && name != null && gender != null && age != null
				&& address != null && contact != null) {
			try {// ������ת�� ��Ȼ����
				name = change(name);
				address = change(address);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String sql = "update customer set Cname='" + name + "',Cage='"
					+ age + "',Cgender='" + gender + "',Caddress='" + address
					+ "',Ccontact='" + contact + "' where Cid='" + cid
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
