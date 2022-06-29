package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
//import java.sql.Timestamp;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MiniStatement
 */
@WebServlet("/MiniStatement")
public class MiniStatement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MiniStatement() {
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
      PrintWriter out= response.getWriter(); 
         
         Connection conn=null;
         String url="jdbc:mysql://localhost:3306/info";
         
         String driver="com.mysql.jdbc.Driver";
     try{  
    	// conn=datasource.getInstance().getConnection();
  	   String A_Id = request.getParameter("A_Id");
  	  int A_Id1= Integer.parseInt(A_Id);
  	 Class.forName(driver).newInstance();  
     conn = DriverManager.getConnection(url,"root", "root");
    
     PreparedStatement ps=conn.prepareStatement("select A_Id,C_Id,Amount,Tr_Type,currentbal,new_date  from Transactions where A_Id=? ORDER BY new_date desc limit 5");

     ps.setInt(1,A_Id1);                   

    

     ResultSet rs=ps.executeQuery();                
    
     /* Printing column names */
   
     RequestDispatcher rd=request.getRequestDispatcher("MiniStatement.jsp");
     rd.include(request, response);
   
     out.println("<h3 style=\"margin-left:200px; margin-bottom:20px;\"><span class=\"label label-info\">All Transactions of Your Account</span></h3>");
     out.println("<br>");
     out.println("<h4 style=\"margin-left:300px; margin-bottom:20px;\">"+"<table>"+"<tr><th>"+"A_Id"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"C_Id"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"Amount"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"Tr_Type"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"CurrentBal"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"Date&Time"+"</th></tr>"+"</table>"+"</h4>"); 
    
    
     int aid=0;
     String cid=null;     
     String Amount=null;
     String tr_type=null;
     int curbal=0;
     Date new_date=null;
     Time new_time=null;
     
    
    
    
     while(rs.next()){    	                           
       aid=rs.getInt(1);
      cid=rs.getString(2);
       Amount=rs.getString(3);
       tr_type=rs.getString(4);
       curbal=rs.getInt(5);
       new_date=rs.getDate("new_date");
       new_time=rs.getTime("new_date");
       out.println("<h4 style=\"margin-left:300px; margin-bottom:20px;\">");
      // out.print("<br>");
       
       out.print("<table  style=\"text-align:right; border:thin; \">"+"<tr><td>"+aid+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp");
       out.print("<tl><td>"+cid+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"/*+"&nbsp"+"&nbsp"*/+"</tl></td>");
       out.print("<tl><td>"+Amount+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"</tl></td>");
       out.print("<tl><td>"+tr_type+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"</tl></td>");
       out.print("<tl><td>"+curbal+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"</tl></td>");
      out.print("<tl><td>"+new_date+"||");
      out.print(new_time+"</tl></td>");
      out.print("<br>");
      out.println("</tr></td>"+"</table>");
       out.println("</h4>");
      
     }
     
     PreparedStatement pst=conn.prepareStatement("select A_Id,C_Id,Amount,Tr_Type,currentbal,new_date  from Transactions where A_Id=? ORDER BY new_date limit 5");
     pst.setInt(1,A_Id1);                   

     ResultSet rs1=pst.executeQuery(); 
     ResultSetMetaData rsmd=rs1.getMetaData(); 
     String col1=null;            
     String col2=null;
     String col3=null;
     String col4=null;
     String col5=null;
     String col6=null;
     int aid1=0;
     String cid1=null;     
     String Amount1=null;
     String tr_type1=null;
     int curbal1=0;
     Date new_date1=null;
     Time new_time1=null;
     
     while(rs1.next()){    	                           
       col1=rsmd.getColumnName(1);
       col2=rsmd.getColumnName(2);
       col3=rsmd.getColumnName(3);
       col4=rsmd.getColumnName(4);
       col5=rsmd.getColumnName(5);
       col6=rsmd.getColumnName(6);
       aid1=rs1.getInt(1);
       cid1=rs1.getString(2);
        Amount1=rs1.getString(3);
        tr_type1=rs1.getString(4);
        curbal1=rs1.getInt(5);
        new_date1=rs1.getDate("new_date");
        new_time1=rs1.getTime("new_date");
     }
     out.println("<br>");     
     if(A_Id1==aid) 
        {
	    	 
     out.println("<h4 style=\"margin-left:300px; margin-bottom:20px;\">");
     out.print("<table width=25% >");
     
     out.print("<h3 style=\"margin-left:40px; margin-bottom:20px;\"><span class=\"label label-info\">Last Updated Transaction</span></h3>"); 
     out.println("<br>");
      out.println("<tr><th>"+col1+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+col2+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+col3+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+col4+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+col5+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+col6+"</th></tr>");  
      out.println("<tr><td><br></td></tr>");
      out.println("<tr><td>");  
      out.print(aid1+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp");
      out.print(cid1+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"/*+"&nbsp"+"&nbsp"*/);
      out.print(Amount1+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp");
      out.print(tr_type1+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp");
      out.print(curbal1+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp"+"&nbsp");
     out.print(new_date1+"||");
     out.print(new_time1);
      out.println("</td></tr>");
      // out.println("<h6 style=\"margin-left:700px; margin-bottom:20px; font:light; \">");
     // out.println(rs.getInt(1)+"&nbsp"+"&nbsp"+"&nbsp"+rs.getInt(2)+"&nbsp"+"&nbsp"+"&nbsp"+rs.getString(3)+"&nbsp"+"&nbsp"+"&nbsp"+rs.getString(4)+"&nbsp"+"&nbsp"+"&nbsp"+rs.getString(5)+"&nbsp"+"&nbsp"+"&nbsp"+rs.getInt(6)+"&nbsp"+"&nbsp"+"&nbsp"+rs.getTimestamp("new_date"));  
     // out.println("</h6>");
      out.print("</table>");
      out.println("</h4>");  
      out.println("<br>");
      out.println("<br>");
      out.println("<br>");
   
    	 }
    	
        
	     else if(A_Id1!=aid) {
		  //  System.out.println("account not exists;");
		     out.println("<script type=\"text/javascript\">");
	         out.println("alert('Account doesnot exist')");    	       
	         out.println("</script>");
	    }
       
     
     }
     catch (Exception e2)

     {
    	   RequestDispatcher rd=request.getRequestDispatcher("MiniStatement.jsp");
    	     rd.include(request, response); 
    	     out.println("<script type=\"text/javascript\">");
	         out.println("alert('Account doesnot exist')");    	       
	         out.println("</script>");
       /*  e2.printStackTrace();*/

     }



   finally{
   	out.close();

     }

   	}

}
