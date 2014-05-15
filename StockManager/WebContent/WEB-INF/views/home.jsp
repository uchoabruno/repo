<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Confira seu jogo aqui</title>
</head>
<!-- Place this asynchronous JavaScript just before your </body> tag -->
<script type="text/javascript">
      (function() {
       var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
       po.src = 'https://apis.google.com/js/client:plusone.js';
       var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
     })();


     function signinCallback(authResult) {
    	  if (authResult['status']['signed_in']) {
    	    // Update the app to reflect a signed in user
    	    // Hide the sign-in button now that the user is authorized, for example:
    	    document.getElementById('signinButton').setAttribute('style', 'display: none');
    	  } else {
    	    // Update the app to reflect a signed out user
    	    // Possible error values:
    	    //   "user_signed_out" - User is signed-out
    	    //   "access_denied" - User denied access to your app
    	    //   "immediate_failed" - Could not automatically log in the user
    	    console.log('Sign-in state: ' + authResult['error']);
    	  }
    	}
    	      
    </script>
<body>

	<sf:form method="POST" modelAttribute="jogo">
		<fieldset style="width: -moz-fit-content">
			<sf:input path="dez01" size="2" maxlength="2" />
			<sf:input path="dez02" size="2" maxlength="2" />
			<sf:input path="dez03" size="2" maxlength="2" />
			<sf:input path="dez04" size="2" maxlength="2" />
			<sf:input path="dez05" size="2" maxlength="2" />
			<sf:input path="dez06" size="2" maxlength="2" />
		</fieldset>
		<input type="submit" value="Conferir" />
	</sf:form>


	<span id="signinButton"> <span class="g-signin"
		data-callback="signinCallback" data-clientid="938279477729.apps.googleusercontent.com"
		data-cookiepolicy="single_host_origin"
		data-requestvisibleactions="http://schemas.google.com/AddActivity"
		data-scope="https://www.googleapis.com/auth/plus.login"> </span>
	</span>


</body>
</html>