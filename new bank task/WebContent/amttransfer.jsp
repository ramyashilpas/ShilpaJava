<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Amount Transfer</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<link rel="stylesheet" href="css/jquery.css">
</head>
<body style="background-color:silver;">
<jsp:include page="header6.jsp"></jsp:include>
<br>
<br>
<h2 align="center" Style="margin-left:0px;"><b>Amount Transfer</b></h2>
<br>
<form action="AmountTransfer" method="post">
<table  align="center" >
   <tr><td align="right"> <b>Your Account Id:</b> <td>&nbsp;</td> 
     <td><input type="text" name="A_Id"  placeholder="Enter Acc_Id eg:1000" /><br></td></tr>
    <tr><td><br></td></tr>
      <tr><td align="right"> <b>To Account Id:</b>   <td>&nbsp;</td>   
   <td> <input type="text" name="A_IdT"  placeholder="Amount To be Added To Acc_Id"/><br></td></tr>
    <tr><td><br></td></tr>
   <tr><td align="right"  ><b> Transfer Amount:</b></td><td>&nbsp;</td>
   <td> <input type="text"name="TransAmount" placeholder="Enter Amount to Transfer" /><br></td></tr>
 <tr><td><br></td></tr> 
   
    <tr><td align="right" ><button type="submit" class="btn btn-success" value="Transfer Amount" >Transfer amount</button></td>
      <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
       <td><a href="amttransfer.jsp"><button type="button"value="cancel" class="btn btn-danger">Cancel</button> </a> </td>
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