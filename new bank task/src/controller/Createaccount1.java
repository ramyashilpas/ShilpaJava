package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Createaccount1
 */
@WebServlet("/Createaccount1")
public class Createaccount1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Createaccount1() {
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
		Connection conn=null;
		String url="jdbc:mysql://localhost:3306/info";
        
        String driver="com.mysql.jdbc.Driver";
	        PrintWriter pw = response.getWriter(); 
		try{ 
			Class.forName(driver).newInstance();  
	       conn = DriverManager.getConnection(url,"root", "root");
			//conn=datasource.getInstance().getConnection();
	      String custname = request.getParameter("Cname"); 
	      String Address = request.getParameter("Address"); 
	      String PhoneNo = request.getParameter("PhoneNo"); 
	      String email = request.getParameter("email");  
	      String account_type=request.getParameter("Acc_Type");
	      String Branch=request.getParameter("branch");
	      String Amount1=request.getParameter("iAmount");	     
          int Amount= Integer.parseInt(Amount1);
       
   
	       PreparedStatement pst =(PreparedStatement) conn.prepareStatement( "insert into Customer(Cname,Address,PhoneNo,email,openacc_date) values(?,?,?,?,localtimestamp())",Statement.RETURN_GENERATED_KEYS);//try2 is the name of the table  	    
	      pst.setString(1,custname);        
	      pst.setString(2,Address);
	      pst.setString(3,PhoneNo);
	      pst.setString(4,email);	       
	      int i = pst.executeUpdate();
		    
	      PreparedStatement pstcid =(PreparedStatement) conn.prepareStatement( "Select C_Id from Customer where Cname=? and PhoneNo=?");//try2 is the name of the table  
        pstcid.setString(1, custname);
        pstcid.setString(2,PhoneNo);
        ResultSet rs1=pstcid.executeQuery();
	        int cid=0;
        while(rs1.next()){
	       cid=rs1.getInt(1);
	       System.out.println("CID"+cid);
	       }	
	        
      
	        PreparedStatement pst1=(PreparedStatement) conn.prepareStatement( "insert into Account(Acc_Type,C_Id,branch,new_date) values(?,?,?,localtimestamp())");
	       // pst1.setInt(1,A_Id);
	      pst1.setString(1, account_type);
	      pst1.setInt(2,cid); 
	      pst1.setString(3, Branch);
	      
	      int j = pst1.executeUpdate();
	      
	      PreparedStatement pstcd=(PreparedStatement) conn.prepareStatement( "select * from account where branch=?");
	      pstcd.setString(1,Branch);
	       ResultSet result=pstcd.executeQuery();
	      int aid=0;
	       while(result.next()){
	    	  aid=result.getInt(1);
	    	 // System.out.println(aid);
	       }
	      PreparedStatement pst2=(PreparedStatement) conn.prepareStatement( "insert into Transactions(A_Id,C_Id,Amount,currentbal,new_date) values(?,?,?,?,localtimestamp())");
	      		//+ ",Statement.RETURN_GENERATED_KEYS);
	     pst2.setInt(1, aid);
	     pst2.setInt(2, cid);
	      pst2.setInt(3, Amount);
	      pst2.setInt(4, Amount);
	      
	      int k= pst2.executeUpdate();	      
	   
	      RequestDispatcher rd=request.getRequestDispatcher("newaccount.jsp");
	      rd.include(request, response);
	      
	     
	      if((i!=0)&&(j!=0)&&(k!=0)){ 
       
	        pw.println("<html>");
	        pw.println("<head>");
	        pw.println("</head>");
	        pw.println("<body>");
	        pw.println(" <link href=\"controller.css/bootstrap.min.css\" rel=\"stylesheet\">");                
      	     pw.println("<h3 style=\"margin-left:500px; margin-bottom:20px;\">");
      	      pw.println("<span class=\"label label-success\"><i>Successfully inserted!</i></span>");
      	   // pw.println("<a class=\"close\" value=\"close\" style=\"margin-right:50px;\">&times;</a>");
      	       pw.println("</h3>");
	         pw.println("</body>");
	         pw.println("</html>");
	      }  
	      else{  
	    	  pw.println("<html>");
		        pw.println("<head>");
		        pw.println("</head>");
		        pw.println("<body>");
	            pw.println("<script type=\"text/javascript\">");
		         pw.println("alert('Record Not Inserted')");
		        // pw.println("location='newaccount.jsp';");
		         pw.println("</script>");
		         pw.println("</body>");
		         pw.println("</html>");
	       }  
	      rs1=pst.getGeneratedKeys();
	      result=pst1.getGeneratedKeys();
	      if(((rs1!=null)&&(rs1.next()))&&((result!=null)&&(result.next()))){
	    	  pw.println("<h5 style=\"margin-left:500px; margin-bottom:20px;color:blue;\">");
	    	  pw.println("<b>Generated CustomerId :</b>"+"&nbsp;"+rs1.getInt(1));
	    	  pw.println("&nbsp;&nbsp;&nbsp;");
	    	  pw.print("<b>Generated AccountId :</b>"+"&nbsp;"+result.getInt(1));
	    	  pw.println("</h5>");
	      }   	     
	    	    
	      pst.close();
	    
	    } 
	    catch (Exception e){  
	    	 RequestDispatcher rd=request.getRequestDispatcher("newaccount.jsp");
		      rd.include(request, response);
		      pw.println("<script type=\"text/javascript\">");
		         pw.println("alert('Enter Correct Details')");		        
		         pw.println("</script>");
	    /*  pw.println(e);  
	      e.printStackTrace();*/
	    }  
	}

}
