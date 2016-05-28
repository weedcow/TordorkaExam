<!-- Modal LOGIN -->
<div class="modal fade" id="myLogin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Login</h4>
      </div>
      <div class="modal-body">
        <form action="${pageContext.request.contextPath}/Controller?action=logIn" method="post">
			<input type="text" name="username" value="" placeholder="Username"></input>
			<input type="password" name="password" value="" placeholder="Password"></input>
			<button class="loginBtn" type="submit" name="">Login <i class="fa fa-lock"></i></button>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<!-- Modal CREATE -->
<div class="modal fade" id="myCreate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Create user</h4>
      </div>
      <div class="modal-body">
 		<form action="${pageContext.request.contextPath}/Controller?action=createUser" method="post">
			<input type="text" name="username" value="" placeholder="Username"></input>
			<input type="password" name="password" value="" placeholder="Password"></input>
			<input type="text" name="email" value="" placeholder="E-mail"></input>
			<input type="text" name="firstName" value="" placeholder="First Name"></input>
			<input type="text" name="lastName" value="" placeholder="Last Name"></input>
			<input type="text" name="phone" value="" placeholder="Phone Number"></input>
			<button class="loginBtn" type="submit" name="">Create <i class="fa fa-lock"></i></button>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>