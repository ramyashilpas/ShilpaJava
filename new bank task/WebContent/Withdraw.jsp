<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Withdraw</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<link rel="stylesheet" href="css/jquery.css">
</head>
<body style="background-color:silver;">
<jsp:include page="header2.jsp"></jsp:include>
<br><br>
<h1 align="center"><b>Withdraw Form</b></h1>
 <br>
<form action="Withdraw1" method="post">
<table cellspacing="5" cellpadding="5" align="center" >
   <tr><td align="right"  ><b> Account Id:</b></td><td>&nbsp;</td>
   <td><input type="text" name="A_Id" placeholder="Enter Acc_Id eg:1000" /><br></td></tr>
    <tr><td><br></td></tr>
   <tr><td align="right" ><b> Withdraw Amount:</b></td><td>&nbsp;</td> 
   <td> <input type="text"name="wAmount" placeholder="Enter Amount for Withdraw"/><br></td></tr>
 <tr><td><br></td></tr> 
   
     <tr><td align="right"><button type="submit" class="btn btn-success" value="Withdraw">Withdraw</button></td>
      <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
       <td><a href="Withdraw.jsp"><button type="button"value="cancel" class="btn btn-danger">Cancel</button></a>  </td>
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
<h5 id="welcome"><marquee behavior="slide" direction="left"><b style="font-family:cursive; ">Withdraw Money</b></marquee></h5> -->
<jsp:include page="footer.jsp"></jsp:include> 
</html>