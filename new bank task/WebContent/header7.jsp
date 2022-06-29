
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SYS Bank</title><link rel="shortcut icon" href="images/barclays.png" type="image/png"/>
<link href="css/bootstrap.min.css" rel="stylesheet">
<style>
.nav{
  
}
 #menu ul{
        height:30px;
        length:10px;    
     
  }
  .nav>li>a{
  margin-left:30px;
   padding-right: 2px;
   font-weight: bold;
   font-size: large;
   font: italic;
  }
 #menu {
    /*  display:inline; 
      text-align:center;   
      padding:12px;
      padding-right:inherit;   */    
  }
   #menu  a:hover,hover-outline:hover{
color:menu;
outline:4px thick silver;
outline-offset:10px;
}
</style>

</head>
<body style="background-color:#cccccc;">
<h1 style="align-text:center;margin-left:650px;color:black;font-family:Monotype Corsiva; ">&nbsp;SYS Bank</h1>
<br>
<br>
<nav class="navbar navbar-inverse" role="navigation" >
<div class="navbar-header"  id="menu">
<ul class="nav navbar-nav">
<li >
<a class="navbar-brand" href="newaccount.jsp">Create Account</a>
</li>
<li class="active"><a  class="nav navbar-nav" href="viewprofile.jsp">View profile</a></li>
<li ><a class="nav navbar-nav" href="Deposit.jsp" >Deposit</a></li>
<li ><a class="nav navbar-nav"  href="Withdraw.jsp">Withdraw</a></li>
<li ><a  class="nav navbar-nav" href="amttransfer.jsp">Amount Transfer</a></li>
<li ><a  class="nav navbar-nav" href="checkbalance.jsp">Check Balance</a></li>
<li ><a  class="nav navbar-nav" href="MiniStatement.jsp">Mini Statement</a></li>
<li ><a  class="nav navbar-nav" href="closeaccount.jsp">Close Account</a></li>
</ul>
</div>
</nav>

</body>

</html>