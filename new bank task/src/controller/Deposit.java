package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
//import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Deposit
 */
@WebServlet("/Deposit")
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deposit() {
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
        	//conn=datasource.getInstance().getConnection();
        	Class.forName(driver).newInstance();  
            conn = DriverManager.getConnection(url,"root", "root");

            String A_Id1 = request.getParameter("A_Id");
          	int A_Id=Integer.parseInt(A_Id1);
         
            String Amount1=request.getParameter("dAmount");	     
            int Amount= Integer.parseInt(Amount1);
    
   	    PreparedStatement pstcd=(PreparedStatement) conn.prepareStatement( "select * from account where A_Id=?");
	      pstcd.setInt(1,A_Id);
	       ResultSet result=pstcd.executeQuery();
	      int cid=0;
	       while(result.next()){
	    	  cid=result.getInt(2);
	    	 // System.out.println(aid);
	       }
	      
		  PreparedStatement pst =(PreparedStatement) conn.prepareStatement( "insert into Transactions(A_Id,C_Id,Amount,Tr_Type,currentbal,new_date) values(?,?,?,?,?,localTimeStamp())");//try2 is the name of the table  
            String x="Deposit";
            pst.setInt(1,A_Id); 
            pst.setInt(2,cid);
             pst.setInt(3,Amount);
           pst.setString(4, x);
          
           
           
            PreparedStatement ps =(PreparedStatement) conn.prepareStatement( "select * from Transactions where A_Id=?");
            ps.setInt(1, A_Id);
            ResultSet rs=ps.executeQuery();
            
          
            int currentTotalBalance=0;
            while(rs.next()){
            	  
            	int Amt=rs.getInt(6);
            	
            		
            	currentTotalBalance=Amount+Amt;
            	
                 }
               System.out.println(currentTotalBalance);
           
             
              pst.setInt(5,currentTotalBalance);
              int i = pst.executeUpdate();             
              
           
              RequestDispatcher rd=request.getRequestDispatcher("Deposit.jsp");
    	      rd.include(request, response);
    	     
    	      
               if((i!=0)){ 
            	   pw.println("<html>");
       	        pw.println("<head>");      	     
       	        pw.println("</head>");
       	        pw.println("<body>");      	     
       	        pw.println(" <link href=\"controller.css/bootstrap.min.css\" rel=\"stylesheet\">");                
       	        pw.println("<h3 style=\"margin-left:500px; margin-bottom:20px;\">");
       	        pw.println("<span class=\"label label-success\" ><i>Successfully Deposited!</i>"+"&nbsp;"+"&nbsp;&nbsp;"+"Total amount is :"+currentTotalBalance+"</span>");
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
          	         pw.println("alert('Transaction is failed')");          	      
          	         pw.println("</script>");
          	         pw.println("</body>");
          	         pw.println("</html>");
                
                }  
    	     
             /*  rs.close();
               ps.close();
*/          
        }
             catch (Exception e){  
            	 RequestDispatcher rd=request.getRequestDispatcher("Deposit.jsp");
       	      rd.include(request, response);
       	   pw.println("<script type=\"text/javascript\">");
	         pw.println("alert('Enter Valid Details')");          	      
	         pw.println("</script>");
              /* pw.println(e);  
               e.printStackTrace();*/
             }  

	}

}
