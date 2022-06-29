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
 * Servlet implementation class Withdraw1
 */
@WebServlet("/Withdraw1")
public class Withdraw1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Withdraw1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd=request.getRequestDispatcher("Withdraw.jsp");
        rd.include(request, response);
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
         /* String custname = request.getParameter("Cname"); 
          	  String PhoneNo = request.getParameter("PhoneNo"); */
           
          //	 String Branch=request.getParameter("branch");
            String Amount1=request.getParameter("wAmount");	     
            int Amount= Integer.parseInt(Amount1);
            
           /* String tamount1=request.getParameter("iamount"); 
            int tamount=Integer.parseInt(tamount1);*/
           //int totalamount=Initialdeposit+Damount;         
            //int t=0;
           /* PreparedStatement psts =(PreparedStatement) conn.prepareStatement( "insert into Customer(Cname,PhoneNo) values(?,?)");//try2 is the name of the table  

   	     // pst.setInt(1,C_Id);
   	      psts.setString(1,custname);        
   	    
   	      psts.setString(2,PhoneNo);
   	           
   	       psts.executeUpdate();
   		    */
       
   	    PreparedStatement pstcd=(PreparedStatement) conn.prepareStatement( "select * from account where A_Id=?");
	      pstcd.setInt(1,A_Id);
	       ResultSet result=pstcd.executeQuery();
	      int cid=0;
	       while(result.next()){
	    	  cid=result.getInt(2);
	    	 // System.out.println(aid);
	       }
	      
		  PreparedStatement pst =(PreparedStatement) conn.prepareStatement( "insert into Transactions(A_Id,C_Id,Amount,Tr_Type,currentbal,new_date) values(?,?,?,?,?,localtimestamp())");//try2 is the name of the table  
            String x="Withdraw";
            pst.setInt(1,A_Id); 
            pst.setInt(2,cid);
             pst.setInt(3,Amount);
           pst.setString(4, x);
          
           
           
            PreparedStatement ps =(PreparedStatement) conn.prepareStatement( "select * from Transactions where A_Id=?");
            ps.setInt(1, A_Id);
            ResultSet rs=ps.executeQuery();
            
            int aid=0;
            int currentTotalBalance=0;
            while(rs.next()){
            	//System.out.println();  
            	int Amt=rs.getInt(6);
            	//System.out.println("Amt is "+Amt);
            		if((Amt!=0)&&(Amount<=Amt)){
            	currentTotalBalance=Amt-Amount;
            		}
            		else
            		{
            			  pw.println("<script type=\"text/javascript\">");
              	         pw.println("alert('Withdraw Amount is more than CurrentBalance Or CurrentBalance is Zero')");          	      
              	         pw.println("</script>"); 
              	         conn.close();
            		}
            	aid= rs.getInt("A_Id");
                
            		}
               System.out.println(currentTotalBalance);
              // pw.println("AMOUNT IS WITHDRAWN");
               
               
            //  pw.println("total amount is"+currentTotalBalance);  		
             //Total Balance code -END
             
              pst.setInt(5,currentTotalBalance);
              int i = pst.executeUpdate(); 
             
             
            //  String msg=" ";
           /*  RequestDispatcher rd=request.getRequestDispatcher("Withdraw.jsp");
             rd.include(request, response);*/
    	      if(A_Id==aid){
               if((i!=0)){ 
            	   pw.println("<html>");
          	        pw.println("<head>");
          	        pw.println("</head>");
          	        pw.println("<body>");
          	      pw.println(" <link href=\"controller.css/bootstrap.min.css\" rel=\"stylesheet\">");                
            	     pw.println("<h3 style=\"margin-left:500px; margin-bottom:20px;\">");
            	      pw.println("<span class=\"label label-success\" ><i>Successfully Withdrawn!</i>"+"&nbsp;"+"&nbsp;&nbsp;"+"Total amount is :"+currentTotalBalance+"</span>");
            	      pw.println("<a class=\"close\">&times;</a>");
            	      pw.println("</h3>");
                      /*pw.println("<script type=\"text/javascript\">");
          	         pw.println("alert('Transaction is Successfull'+'\n'+'Total Amount is:')"+currentTotalBalance);*/
          	        // pw.println("location='newaccount.jsp';");
          	         
          	         pw.println("</body>");
          	         pw.println("</html>");
                }  
    	      }
               else{  
            	   pw.println("<html>");
          	        pw.println("<head>");
          	        pw.println("</head>");
          	        pw.println("<body>");
                      pw.println("<script type=\"text/javascript\">");
          	         pw.println("alert('Transaction is failed')");
          	        // pw.println("location='newaccount.jsp';");
          	         pw.println("</script>");
          	         pw.println("</body>");
          	         pw.println("</html>");
                
                }  
               rs.close();
	              ps.close();
          
        }
        catch (Exception e){  
        	 pw.println("<script type=\"text/javascript\">");
  	         pw.println("alert('Enter Valid Details')");
  	        // pw.println("location='newaccount.jsp';");
  	         pw.println("</script>");
             /*  pw.println(e);  
               e.printStackTrace();*/
             }  

	}

}
