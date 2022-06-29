package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewProfile
 */
@WebServlet("/ViewProfile")
public class ViewProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	    PrintWriter pw = response.getWriter(); 
		Connection conn=null;
		String url="jdbc:mysql://localhost:3306/info";
        
        String driver="com.mysql.jdbc.Driver";
        try{
        	
        	Class.forName(driver).newInstance();  
   	       conn = DriverManager.getConnection(url,"root", "root");
        	
   	    String A_Id = request.getParameter("A_Id");
      	int A_Id1=Integer.parseInt(A_Id);
   	       
      	 PreparedStatement pstad=(PreparedStatement) conn.prepareStatement( "select * from Account where A_Id=?");
   	       pstad.setInt(1, A_Id1);
   	       ResultSet rs=pstad.executeQuery();
   	       int cid=0;
   	       int aid=0;
   	       while(rs.next()){
   	    	   cid=rs.getInt(2);
   	    	   aid=rs.getInt(1);
   	       }
   	      
   	    	   
   	       PreparedStatement pstcd=(PreparedStatement) conn.prepareStatement( "select * from Customer where C_Id=?");
	      pstcd.setInt(1,cid);
	       ResultSet result=pstcd.executeQuery();	     	 
	       String Cname=null;
	       String Address=null;
	       String phoneNo=null;
	       String email=null;
	       Date openacc_date=null;
	       Time openacc_time=null;
	       while(result.next()){
	    	 Cname=result.getString(2);
	    	 Address=result.getString(3);
	    	 phoneNo=result.getString(4);
	    	 email=result.getString(5);
	    	 openacc_date=result.getDate(6);
	    	 openacc_time=result.getTime(6);    	 
	       }
	      
	       PreparedStatement ps =(PreparedStatement) conn.prepareStatement( "select * from Transactions where A_Id=(select max(?) from Transactions)");
	       ps.setInt(1, aid);
	       ResultSet rs1=ps.executeQuery();
	       int Amt=0;
	       while(rs1.next()){
	    	   Amt=rs1.getInt(6);
	       }
        	
	       RequestDispatcher rd=request.getRequestDispatcher("viewprofile.jsp");
	       rd.include(request, response);
        	
	       if(A_Id1==aid)
		      {
	    	    pw.println("<html>");
		        pw.println("<head>");
		        pw.println("</head>");
		        pw.println("<body>");
		        pw.println(" <link href=\"controller.css/bootstrap.min.css\" rel=\"stylesheet\">"); 
		        pw.println("<h4 style=\"margin-left:580px; margin-bottom:20px;\"><b>Account  Id </b>"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"<b>:</b>"+"&nbsp"+"&nbsp"+aid+"</h4>");
		        pw.println("<h4 style=\"margin-left:580px; margin-bottom:20px;\"><b>Customer Id </b>"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"<b>:</b>"+"&nbsp"+"&nbsp"+cid+"</h4>");
		        pw.println("<h4 style=\"margin-left:580px; margin-bottom:20px;\"><b>Customer Name </b>"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"<b>:</b>"+"&nbsp"+"&nbsp"+Cname+"</h4>");
		        pw.println("<h4 style=\"margin-left:580px; margin-bottom:20px;\"><b>Address </b>"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"<b>:</b>"+"&nbsp"+"&nbsp"+Address+"</h4>");
		        pw.println("<h4 style=\"margin-left:580px; margin-bottom:20px;\"><b>PhoneNo </b>"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"<b>:</b>"+"&nbsp"+"&nbsp"+phoneNo+"</h4>");
		        pw.println("<h4 style=\"margin-left:580px; margin-bottom:20px;\"><b>Email </b>"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"<b>:</b>"+"&nbsp"+"&nbsp"+email+"</h4>");
		        pw.println("<h4 style=\"margin-left:580px; margin-bottom:20px;\"><b>Account Opened Date&Time </b>"+"&nbsp"+"&nbsp"+"<b>:</b>"+"&nbsp"+"&nbsp"+openacc_date+"&nbsp"+openacc_time+"</h4>");
		        pw.println("<h4 style=\"margin-left:580px; margin-bottom:20px;\"><b>Current Account Balance </b>"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"<b>:</b>"+"&nbsp"+"&nbsp"+Amt+"</h4>");
		        pw.println("</body>");
		        pw.println("</html>");
		      }
	       else
		      {
		    	  pw.println("<html>");
	    	        pw.println("<head>");
	    	        pw.println("</head>");
	    	        pw.println("<body>");
	                pw.println("<script type=\"text/javascript\">");
	    	         pw.println("alert('Account Id is Invalid')");	    	       
	    	         pw.println("</script>");
	    	         pw.println("</body>");
	    	         pw.println("</html>");	  
		      }
           	
        }
        catch (Exception e){  
        	 RequestDispatcher rd=request.getRequestDispatcher("viewprofile.jsp");
  	       rd.include(request, response);
  	     pw.println("<script type=\"text/javascript\">");
         pw.println("alert('Account Id is Invalid')");      
         pw.println("</script>");
  	     /* pw.println(e);  
  	      e.printStackTrace();*/
  	    }  
	}

}
