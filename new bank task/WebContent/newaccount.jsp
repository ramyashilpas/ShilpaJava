<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Account</title>
 <link href="css/bootstrap.min.css" rel="stylesheet">
 <link rel="stylesheet" href="css/jquery.css">
 <script type="text/javascript" src="js/jquery-1.9.1.min.js">


 /*  
    $(document).ready(function Validation(){
    	$('#contact_name').on('input',function Validation(){
    		var input=$(this);
    		var is_name=input.val();
    		if(is_name{remove})
    	});
    });  */
    
 
        function Validation()
     {  
    	//name
    	 var p=document.form.Cname.value;
        if(p==" "){
 		alert("please Enter the Name");
 		document.form.phoneNo.focus();
 		return false;
 	}
 	if(!isNaN(p)){
 		alert("please Enter the Only Characters");
 		document.form.phoneNo.select();
 		return false;
 	}
 	if((p.length<5)||(p.length>15)){
 		alert("Your mobile Number must be 5 to 15 Characters");
 		document.form.phoneNo.select();
 		return false;
 	}
 	
 	//address
 	 var q=document.form.Address.value;
     if(q==" "){
 		alert("please Enter the Your Address");
 		document.form.phoneNo.focus();
 		return false;
 	}
     	var a=document.form.PhoneNo.value;
    	if(a==" "){
    		alert("please Enter the Contact Number");
    		document.form.phoneNo.focus();
    		return false;
    	}
    	if(isNaN(a)){
    		alert("please Enter the  valid mobile Number(Like:995648943)");
    		document.form.phoneNo.focus();
    		return false;
    	}
    	if((a.length<1)||(a.length>10)){
    		alert("Your mobile Number must be 1 to 10 Integers");
    		document.form.phoneNo.select();
    		return false;
    	}
    	
    	
    	
    	
    	var b=document.form.email.value;
    	if(b==" "){
    		alert("please Enter the email");
    		document.form.email.focus();
    		return false;
    	}
    	if(!isNaN(b)){
    		alert("please Enter the  valid email(Like:abc@gmail.com)");
    		document.form.email.focus();
    		return false;
    	} 	 }
     
     
</script>
</head>
<body style="background-color:silver;">
<jsp:include page="header.jsp"></jsp:include>
<!-- <h1 align="center">Create New Account</h1>
 <br> -->
  <h5 id="welcome"><marquee behavior="slide" direction="left"><b style="font-family:cursive; ">To Open Account</b></marquee></h5>
<form name="form"  method="post"  onsubmit="return Validation(); return false;" action="Createaccount1" >

<h3 align="center"><b>Customer Details</b></h3><br>
<table cellspacing="5" cellpadding="5" align="center" >
 
  
   <tr><td align="right"><b>CustomerName:</b></td><td>&nbsp;</td> 
   <td> <input type="text"name="Cname" id="contact_name"  placeholder="Enter Name" required/><br></td></tr>
   <tr><td><br></td></tr>
   <tr><td align="right"> <b>Address:</b> </td> <td>&nbsp;</td>    
   <td ><textarea id="Address" name="Address" placeholder="EnterAddress" required></textarea><br></td></tr>
   <tr><td><br></td></tr>
   <tr><td align="right"> <b>PhoneNo:</b>  </td> <td>&nbsp;</td> 
   <td><input type="text" id="phone"name="PhoneNo"  placeholder="Enter Number" required/></td></tr>
   <tr><td><br></td></tr>
   <tr><td align="right"> <b>Email: </b> </td> <td>&nbsp;</td>
   <td> <input type="text"id="contact_email" name="email"  placeholder="Email" /></td></tr>
<tr><td><br></td></tr>

    </table>
   
    <h3 align="center"><b>Account Details</b> </h3>
    
    <table  cellspacing="5" cellpadding="5" align="center">
    <tr><td><br></td></tr>
  <tr>
  <td><b>Account Type:</b></td><td>&nbsp;</td>
  <td><select name="Acc_Type" style="width: 100px;" >
 
 <option selected>Please select one</option>
  <option>Savings</option>
 <option >Current</option>
 </select>
 
 </td>
 </tr>
 <tr><td><br></td></tr>
   <tr>
  <td><b>Account Branch:</b></td><td>&nbsp;</td>
  
  <td>
  <select name="branch" style="width: 100px;" >  
 <option selected>Please select one</option>
  <option>Bangalore</option>
   <option>Delhi</option>
    <option>Mumbai</option>
  <option>Hyderabad</option>
 <option  >Pune</option>
 </select>
 </td>
 </tr>
 <tr><td><br></td></tr>
 </table>
 
 <h3 align="center"><b>Transaction Details</b></h3>

<table cellspacing="5" cellpadding="5" align="center" >

   <tr><td align="right"><b>Initial Deposit:</b></td><td>&nbsp;</td>
   <td><input type="text" name="iAmount"  placeholder="Give Inital amount" /><br></td></tr>
   
      <tr><td><br></td></tr> 
 
  
    <tr><td align="right"><button type="submit" class="btn btn-success" value="submit">Create</button></td>
      <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
       <td><a href="newaccount.jsp"><button type="button"value="cancel" class="btn btn-danger">Cancel</button></a>  </td>
    </tr>
   <tr><td><br></td></tr> 
  <tr><td><br></td></tr>   
   </table>
  
   </form> 
</body>

</html>

<jsp:include page="footer.jsp"></jsp:include>
