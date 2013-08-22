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
 * Servlet implementation class InsSalesman
 */
@WebServlet("/InsSalesman")
public class InsSalesman extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsSalesman() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static String change(String s) throws Exception
    {
    	byte b[]=s.getBytes("ISO-8859-1");//��������ת��������
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
		String sid=request.getParameter("sid");
		String name=request.getParameter("name");
		String gender=request.getParameter("genderselect");
		String age=request.getParameter("age");
		String address=request.getParameter("address");
		String education=request.getParameter("education");
		
		out.println("<HTML>");
		out.println("<HEAD><meta http-equiv='Content-Type' content='text/html; charset=gb2312'><link rel='stylesheet' href='Business/script04.css'><script src='JavaScript/checkInsSalesman.js'></script><script src='Business/jQuery.js'></script><script src='Business/jquery/jquery.tablesorter.js'></script><script src='Business/script05.js'></script><style type='text/css'>.style1 {font-family: '�����п�'; font-size: 24px; font-style: normal; color: #666666; }.style2 {font-family: Arial, Helvetica, sans-serif; font-size: 12px; font-style: normal; color: #006666; }</style></HEAD>");
		out.println("<BODY>");
		out.println("<p align='center' class='style1'>¼��Ա����Ϣ</p>");
		out.println("<form id=\"form1\" name=\"form1\" action='InsSalesman'><p class='style2'>������<input name='name' type='text' size='12'/>");
		out.println("�Ա�<select name='genderselect' size='1' id='select'><option value='M' selected='selected'>��</option><option value='F'>Ů</option></select>");
		out.println("���䣺<input name='age' type='text' size='4'/>");
		out.println("���᣺<input name='address' type='text' size='12'/>");
		out.println("ѧ����<input name='education' type='text' size='4'/>");
		out.println("<input type='button' value='¼��' onclick='checkInsSalesman();'/></p></form>");
		try {
			ResultSet rs  = search.getRs("select * from V_sman");
			while(rs.next())
			{
				sid=rs.getString("Sid");
			}
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(sid!=null)
		{
			int num=Integer.parseInt(sid.substring(1, 4));
			num++;
			if(num<10)
				sid="T00"+String.valueOf(num);
			else	if(num<100)
				sid="T0"+String.valueOf(num);
			else
				sid="T"+String.valueOf(num);
		}
		if(sid!=null && name!=null && gender!=null && age!=null && address!=null && education!=null)
		{
	    	try {//������ת�� ��Ȼ����
				name=change(name);
				address=change(address);
				education=change(education);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	
			String sql="insert into salesman values('"+sid+"','123456','"+name+"','"+age+"','"+gender+"','"+address+"','"+education+"')";
			try {
				if(insert.doIDU(sql))
					out.print("<script language=javascript>alert('¼��ɹ���');</script>");
				else
					out.print("<script language=javascript>alert('¼��ʧ�ܣ�');</script>");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.print("<script language=javascript>alert('¼��ʧ�ܣ�');</script>");
			}
		}
		try {
			s = search.search_salesman("select * from V_sman");
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
