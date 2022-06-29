package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckBal
 */
@WebServlet("/CheckBal")
public class CheckBal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckBal() {
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
		 PrintWriter pw= response.getWriter(); 
         
         Connection conn=null;
         String url="jdbc:mysql://localhost:3306/info";
         
         String driver="com.mysql.jdbc.Driver";
     try{  
    	// conn=datasource.getInstance().getConnection();
    	 Class.forName(driver).newInstance();  
         conn = DriverManager.getConnection(url,"root", "root");
  	   String A_Id = request.getParameter("A_Id");
  	  int A_Id1= Integer.parseInt(A_Id);
       
       
       /*PreparedStatement ps=con.prepareStatement("select * from Transactions where A_Id=?");

       ps.setInt(1,A_Id1);                   

     out.print("<table width=25% >");

       out.print("<h3>Result:</h3>");

       ResultSet rs=ps.executeQuery();                

        Printing column names 

       ResultSetMetaData rsmd=rs.getMetaData();
      
       while(rs.next())

          {

     out.print("<tr>");

       //out.print("<td>"+rsmd.getColumnName(6)+"</td>");
          
        out.print("<td>"+rs.getInt(6)+"</td></tr>");
      
         
       }

       out.print("</table>");*/

       PreparedStatement ps =(PreparedStatement) conn.prepareStatement( "select * from Transactions where A_Id=(select max(?) from Transactions)");
       ps.setInt(1, A_Id1);
       ResultSet rs=ps.executeQuery();
       
       int Amt=0;
       int aid=0;
      // int currentTotalBalance=0;
       while(rs.next()){
       	//System.out.println();  
       	 Amt=rs.getInt(6);
       	aid= rs.getInt("A_Id");
      // 	pw.println("amt"+Amt);
       }
       RequestDispatcher rd=request.getRequestDispatcher("checkbalance.jsp");
	      rd.include(request, response);
	      if(A_Id1==aid)
	      {
          pw.println("<html>");
	        pw.println("<head>");
	        pw.println("</head>");
	        pw.println("<body>");
	      pw.println(" <link href=\"controller.css/bootstrap.min.css\" rel=\"stylesheet\">");                
	     pw.println("<h3 style=\"margin-left:580px; margin-bottom:20px;\">");
	      pw.println("<span class=\"label label-success\" ><i>Total amount is :</i>"+Amt+"</span>");
	       pw.println("</h3>");
         /*pw.println("<script type=\"text/javascript\">");
	         pw.println("alert('Transaction is Successfull'+'\n'+'Total Amount is:')"+currentTotalBalance);*/
	        // pw.println("location='newaccount.jsp';");
	         //pw.println("</script>");
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
    	         pw.println("alert('AccountId is Invalid')");
    	        // pw.println("location='newaccount.jsp';");
    	         pw.println("</script>");
    	         pw.println("</body>");
    	         pw.println("</html>");	  
	      }

}catch (Exception e2)

  {   
	   RequestDispatcher rd=request.getRequestDispatcher("checkbalance.jsp");
	      rd.include(request, response);
	
	  pw.println("<script type=\"text/javascript\">");
      pw.println("alert('AccountId doesnot exist')");    	       
      pw.println("</script>");
     /* e2.printStackTrace();*/

  }



finally{
	pw.close();

  }

	}

}
