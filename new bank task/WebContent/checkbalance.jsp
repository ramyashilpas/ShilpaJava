<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check Balance</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<link rel="stylesheet" href="css/jquery.css">
</head>
<body style="background-color:silver;">
<jsp:include page="header3.jsp"></jsp:include>
<br><br>
<center><h2><b>Check Balance Form</b></h2></center>
<br>
 <form  action="CheckBal" method="post">
<table align="center">
   <tr><td> <b> Enter Account Id:</b></td> <td>&nbsp;</td> 
    <td>
    <input type="text" name="A_Id" placeholder="Enter Acc_Id eg:1000" /><br></td></tr>
   
   <tr><td><br></td></tr>
   <tr><td align="right"><button type="submit" class="btn btn-success" value="submit">Submit</button></td>  
   <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
       <td><a href="checkbalance.jsp"><button type="button"value="cancel" class="btn btn-danger">Cancel</button> </a> </td>
     </tr>
     <tr><td><br></td></tr> 
  <tr><td><br></td></tr> 
  <tr><td><br></td></tr> 
  <tr><td><br></td></tr> 
  <tr><td><br></td></tr> 
  <tr><td><br></td></tr> 
   <tr><td><br></td></tr> 
   
   
   </table>
   </form>
</body>
<!-- <br><br><br><br><br><br>
<h5 id="welcome"><marquee behavior="slide" direction="left"><b style="font-family:cursive; ">Check Account Balance</b></marquee></h5> -->
<jsp:include page="footer.jsp"></jsp:include>
</html>