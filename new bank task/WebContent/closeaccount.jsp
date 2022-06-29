<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Close Account</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<link rel="stylesheet" href="css/jquery.css">
</head>
<body style="background-color:silver;">
<jsp:include page="header4.jsp"></jsp:include>
<br>
<br>
<h2 align="center" Style="margin-left:0px;"><b>Close Account</b></h2>
<br>
<form action="closeaccount1" method="post">
<table  align="center" >
   <tr><td align="right"> <b>AccountId:</b> <td>&nbsp;</td> 
     <td><input type="text" name="A_Id"  placeholder="Enter Acc_Id eg:1000" /><br></td></tr>
    <tr><td><br></td></tr>
      <tr><td align="right"> <b>CustomerId:</b>   <td>&nbsp;</td>   
   <td> <input type="text" name="C_Id"  placeholder="Enter Cust_Id eg:100"/><br></td></tr>
    <tr><td><br></td></tr>
   
    <tr><td align="right" ><button type="submit" class="btn btn-success" value="close account" >Close account</button></td>
      <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
       <td><a href="closeaccount.jsp"><button type="button"value="cancel" class="btn btn-danger">Cancel</button> </a> </td>
     </tr>
    <tr><td><br></td></tr>
     <tr><td><br></td></tr>
      <tr><td><br></td></tr>   
   </table>
   </form>
</body>
<!-- <br><br><br><br><br><br>
<h5 id="welcome"><marquee behavior="slide" direction="left"><b style="font-family:cursive; "> For Closing Your Account</b></marquee></h5> -->
<jsp:include page="footer.jsp"></jsp:include>
</html>