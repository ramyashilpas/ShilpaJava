package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AmountTransfer
 */
@WebServlet("/AmountTransfer")
public class AmountTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AmountTransfer() {
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
          	
          	String A_Id2 = request.getParameter("A_IdT");
          	int A_IdT=Integer.parseInt(A_Id2);
           
          	String TAmount=request.getParameter("TransAmount");	     
            int TransAmount= Integer.parseInt(TAmount);
            
	        //Amount to transfer from account code----here amount is removed from account that is going to transfer
            
            PreparedStatement pstcd=(PreparedStatement) conn.prepareStatement( "select * from account where A_Id=?");
  	      pstcd.setInt(1,A_Id1);
  	       ResultSet result=pstcd.executeQuery();
  	      int aid=0;
  	      int cid=0;
  	       while(result.next()){
  	    	  aid=result.getInt(1); 
  	    	  cid=result.getInt(2);
  	       }
  	     
 		  PreparedStatement pst =(PreparedStatement) conn.prepareStatement( "select * from Transactions where A_Id=?");//try2 is the name of the table  
            
             pst.setInt(1,aid); 
             //pst.setInt(2, cid);
             ResultSet result1=pst.executeQuery();
             int currbal=0;
             int FinalBal=0;
             while(result1.next()){            	
     	    	  currbal=result1.getInt(6); 
     	    	 if(TransAmount<=currbal){     	        	    	
     	    	  FinalBal=currbal-TransAmount;
     	    	 }
     	    	 else{
     	    		
     		       pw.println("<script type=\"text/javascript\">");
         	         pw.println("alert('Transferring Amount is more than CurrentBalance')");          	      
         	         pw.println("</script>"); 
         	         conn.close();
     	    	 }
     	       }
             PreparedStatement pst1 =(PreparedStatement) conn.prepareStatement( "insert into Transactions(A_Id,C_Id,Amount,Tr_Type,currentbal,new_date) values(?,?,?,?,?,localTimeStamp())");
             String x="Transferring";
            pst1.setInt(1, aid);
            pst1.setInt(2, cid);
            pst1.setInt(3,TransAmount);
            pst1.setString(4,x);
	        pst1.setInt(5, FinalBal);
	        int i = pst1.executeUpdate(); 
	        //Amount to transfer into Account code---here amount is added to that account that is being recieved
	       
	        PreparedStatement pstad1=(PreparedStatement) conn.prepareStatement( "select * from account where A_Id=?");
	  	      pstad1.setInt(1,A_IdT);
	  	       ResultSet result3=pstad1.executeQuery();
	  	      int aidT=0;
	  	      int cidT=0;
	  	       while(result3.next()){
	  	    	  aidT=result3.getInt(1);
	  	    	 cidT=result3.getInt(2);
	  	       }
	  	       
	  	     PreparedStatement pst2 =(PreparedStatement) conn.prepareStatement( "select * from Transactions where A_Id=?");//try2 is the name of the table  
	            
             pst2.setInt(1,aidT); 
           //  pst2.setInt(2,cidT); 
             ResultSet result4=pst2.executeQuery();
             int currbalT=0;
             int FinalBalT=0;
             while(result4.next()){
     	    	  currbalT=result4.getInt(6);  
     	    	 if(TransAmount<=currbal){ 
     	    	  FinalBalT=currbalT+TransAmount;
     	    	 }
     	    	 else{
      	    		
       		       pw.println("<script type=\"text/javascript\">");
           	         pw.println("alert('Transferring Amount is more than CurrentBalance')");          	      
           	         pw.println("</script>"); 
           	         conn.close();
       	    	 }
     	       }
             
             PreparedStatement pstT =(PreparedStatement) conn.prepareStatement( "insert into Transactions(A_Id,C_Id,Amount,Tr_Type,currentbal,new_date) values(?,?,?,?,?,localTimeStamp())");
             String y="AmountAdded";
            pstT.setInt(1, aidT);
            pstT.setInt(2, cidT);
            pstT.setInt(3,TransAmount);
            pstT.setString(4,y);
	        pstT.setInt(5, FinalBalT);
	        
	        int j = pstT.executeUpdate(); 
	        
	        RequestDispatcher rd=request.getRequestDispatcher("amttransfer.jsp");
	        rd.include(request, response);
	        if((i!=0)&&(j!=0)){ 
         	   pw.println("<html>");
    	        pw.println("<head>");
    	      //  pw.println("<link rel=\"stylesheet\" href=\"controller.css/style.css\" type=\"text/css\">");
    	        pw.println("</head>");
    	        pw.println("<body>");
    	      //  pw.println("<script type=\"text/javascript\" src=\"controller.js/jquery-1.9.1.min.js\">");
    	      pw.println(" <link href=\"controller.css/bootstrap.min.css\" rel=\"stylesheet\">");                
    	     pw.println("<h3 style=\"margin-left:500px; margin-bottom:20px;\">");
    	      pw.println("<span class=\"label label-success\" ><font style=\"French Script MT\">Successfully Transferred!</font></span>");
    	      pw.println("<br>");pw.println("<br>");
    	      pw.println("<span class=\"label label-success\" >Total Amount Transferred is "+"&nbsp;"+"&nbsp;&nbsp;"+":"+TransAmount+"</span>");
    	      pw.println("<br>");pw.println("<br>");
    	      pw.println("<span class=\"label label-success\" > Account Balance Of Your Account:"+"&nbsp;"+aid+"&nbsp;"+"&nbsp;&nbsp;"+"is :"+FinalBal+"</span>");
    	     // pw.println("<br>");pw.println("<br>");
    	       // pw.println("<span class=\"label label-success\" ><i>Transferred Account Balance is</i>"+"&nbsp;"+"&nbsp;&nbsp;"+":"+FinalBalT+"</span>");
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
	        }
	        catch (Exception e){  
	        	 
		        RequestDispatcher rd=request.getRequestDispatcher("amttransfer.jsp");
		        rd.include(request, response);
		        pw.println("<script type=\"text/javascript\">");
      	         pw.println("alert('Enter Valid Information')");          	      
      	         pw.println("</script>");
	             /*  pw.println(e);  
	               e.printStackTrace();*/
	             }  
	        }

}
