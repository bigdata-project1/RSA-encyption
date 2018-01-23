<html>


<body background="black.jpg">  

<br></br>
<br></br><br></br>
<center><b><h1><u><font color="white" size="8">ADMINISTRATOR LOGIN</font></u></b></h1></center>

<form name="loginform" action="administrator.php" method="post">
<table width="315" border="0" align="center" cellpadding="10" cellspacing="20">
  <tr>
    <td colspan="2">
		
		 <?php
			if( isset($_SESSION['ERRMSG_ARR']) && is_array($_SESSION['ERRMSG_ARR']) && count($_SESSION['ERRMSG_ARR']) >0 ) {
			echo '<ul class="err">';
			foreach($_SESSION['ERRMSG_ARR'] as $msg) {
				echo '<li>',$msg,'</li>'; 
				}
			echo '</ul>';
			unset($_SESSION['ERRMSG_ARR']);
			}
		?>
	</td>
  </tr>
  
  <tr>
    <td width="116"><div align="right"><B><font color="white" size="6">USERNAME</font></B></div></td>
    <td width="177"><input name="name" type="text" required /></td>
  </tr>
  <br></br>
  <tr>
    <td><div align="right"><b><font color="white" size="6">PASSWORD</font></b></div></td>
    <td><input name="password" type="password" required /></td>
  </tr>
 <br></br>
  <tr>
    <td><div align="right"></div></td>
    <td><input name="" type="submit" value="LOGIN" /></td>
  </tr>

  
  
		  
  
  
  
  
  
</table>

</form>

</body>
</html>