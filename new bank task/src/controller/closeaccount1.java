package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class closeaccount1
 */
@WebServlet("/closeaccount1")
public class closeaccount1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public closeaccount1() {
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
        	//conn=datasource.getInstance().getConnection();
        	 Class.forName(driver).newInstance();  
    	     conn = DriverManager.getConnection(url,"root", "root");
       	   String A_Id = request.getParameter("A_Id");
       	  int A_Id1= Integer.parseInt(A_Id);
       	 String C_Id = request.getParameter("C_Id");
      	 int C_Id1= Integer.parseInt(C_Id);
            
           
            
            PreparedStatement psts =(PreparedStatement) conn.prepareStatement( "DELETE  FROM Transactions where A_Id=?");//try2 is the name of the table  

      	      psts.setInt(1,A_Id1);
      	           
      	   int i=psts.executeUpdate();   
           
            
            PreparedStatement psts1 =(PreparedStatement) conn.prepareStatement( "DELETE  FROM Account where A_Id=?");//try2 is the name of the table  

    	      psts1.setInt(1,A_Id1);
    	           
    	    
    		int j=psts1.executeUpdate();
    		
       
    	 PreparedStatement psts2 =(PreparedStatement) conn.prepareStatement( "DELETE  FROM Customer where C_Id=?");//try2 is the name of the table  

    	     psts2.setInt(1,C_Id1);
    	     
    	     
    		int k=psts2.executeUpdate();
    		
    		/* PreparedStatement psts3 =(PreparedStatement) conn.prepareStatement( "DELETE C_Id FROM Customer LEFT JOIN Account ON Customer.C_Id=Account.A_Id where A_Id IS NULL");  
     	   int l= psts3.executeUpdate();    
         
          PreparedStatement ps =(PreparedStatement) conn.prepareStatement( "select * from Account where A_Id=?");
           ps.setInt(1, A_Id1);
           ResultSet rs=ps.executeQuery();
           
           
           int aid=0;        
           while(rs.next()){           	 
         	aid= rs.getInt("A_Id");        
           }
         */  
   	   
           RequestDispatcher rd=request.getRequestDispatcher("closeaccount.jsp");
  	      rd.include(request, response);
             	        
            if((i!=0)&&(j!=0)&&(k!=0)){  
            	pw.println("<html>");
		        pw.println("<head>");
		        pw.println("</head>");
		        pw.println("<body>");
	            pw.println("<script type=\"text/javascript\">");
		        pw.println("alert('Record Not Deleted')");		       
		        pw.println("</script>");
		        pw.println("</body>");
		        pw.println("</html>");                      	
            	}                     
        else{                   	      	
        	pw.println("<html>");
	        pw.println("<head>");
	        pw.println("</head>");
	        pw.println("<body>");
	        pw.println(" <link href=\"controller.css/bootstrap.min.css\" rel=\"stylesheet\">");                
      	    pw.println("<h3 style=\"margin-left:500px; margin-bottom:20px;\">");
      	    pw.println("<span class=\"label label-success\"><i>Successfully deleted!</i></span>");    	 
      	    pw.println("</h3>");
	        pw.println("</body>");
	        pw.println("</html>");
           }
        	       	               	     	
       
            
            psts.close();
            psts1.close();
            
     }
        
        catch (Exception e2)

       {
        	  RequestDispatcher rd=request.getRequestDispatcher("closeaccount.jsp");
      	      rd.include(request, response);
      	    pw.println("<script type=\"text/javascript\">");
	        pw.println("alert('AccountId is not Valid')");		       
	        pw.println("</script>");   	        

          /* e2.printStackTrace();*/

       }    
     finally{
     	pw.close();

       }

	}

}
