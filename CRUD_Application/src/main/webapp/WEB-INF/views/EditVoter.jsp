<%@page import="java.util.List"%>
<%@page import="org.siva.crud.model.Voter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<head>
    	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
    	<title>Voters Dashboard</title>
    	<jsp:include page="./includes/css.jsp"></jsp:include>
    	<style type="text/css">
    		body {
    			background-color: #FFFDF0;
    		}
    		.dashboard-heading {
    			color: #FC4100 !important;
    			text-shadow: 2px 1px #000;
    			font-weight: 700 !important;
    		}
    		.edit {
    			background: #399918 !important;
    			border: none;
    		}
    		.remove {
    			background: #FF0000 !important;
    			border: none;
    		}
    		.bg-primary, .btn-primary {
    			background: #5E1675 !important;
    			border: none;
    		}
    	</style>
	</head>
  	<body>
  		<%
  			Voter v = (Voter) session.getAttribute("voter");
  		%>
    	<div class="container-fluid">
    		<div class="row d-flex justify-content-center mt-2">
    			<div class="col-md-4 col-sm-12 col-lg-4">
    				<div class="card" style="box-shadow: 0px 0px 3px 3px #D9DFC6">
    					<div class="card-head bg-primary text-center p-3 text-light">
    						<h3>Edit Voter</h3>
    					</div>
    					<div class="card-body">
    						<form action="/CRUD_Application/updateVoterInformation" method="post">	
    							<input type="text" id="voterId" name="voterId" class="form-control" value="<%= v.getVoterId() %>" autocomplete="off" required="required" hidden="true">
    							<div class="form-group mt-2">
    								<label for="name">Full Name</label>
    								<input type="text" id="name" name="voterName" class="form-control" value="<%= v.getVoterName() %>" autocomplete="off" required="required">
    							</div>
    							<div class="form-group mt-2">
    								<label for="mobile">Mobile Number</label>
    								<input type="text" id="mobile" name="voterMobile" class="form-control" value="<%= v.getVoterMobile() %>" autocomplete="off" required="required">
    							</div>
    							<div class="form-group mt-2">
    								<label for="age">Age</label>
    								<input type="number" id="age" name="voterAge" class="form-control" value="<%= v.getVoterAge() %>" autocomplete="off" required="required">
    							</div>
    							<div class="form-group mt-2">
								    <label for="gender">Gender</label>
								    <input type="text" id="gender" name="voterGender" class="form-control" value="<%= v.getVoterGender()%>" autocomplete="off" required="required">
								</div>
    							<div class="form-group mt-2">
    								<label for="address">Address</label>
    								<input type="text" class="form-control" id="address" name="voterAddress" value="<%= v.getVoterAddress() %>" autocomplete="off" required="required">
    							</div>
    							<div class="form-group mt-2">
    								<input type="submit" value="Edit" class="form-control btn btn-primary" >
    							</div>
    						</form>
    					</div>
    				</div>
    			</div>
    			<div class="col-md-8 col-sm-12 col-lg-8">
    				<div class="card" style="box-shadow: 0px 0px 3px 3px #D9DFC6">
    					<div class="card-head text-center text-danger p-3">
    						<h2 class="fs-2 fw-bold dashboard-heading" style="text-shadow: 2px 1px #000">Voters Dashboard</h2>
    					</div>    					
    					<div class="card-body">
    						<table class="table table-hover table-resposive">
    							<tr class="table-dark">
    								<td>ID</td>
    								<td>Name</td>
    								<td>Mobile</td>
    								<td>Age</td>
    								<td>Gender</td>
    								<td>Address</td>
    								<td>Action</td>
    							</tr>
    							<%
    								List<Voter> voters = (List<Voter>) session.getAttribute("voters");
    								if (voters.isEmpty()) 
    								{%>
    									<tr>
    										<td colspan="6" class="text-primary">Voters are not present in the list</td>
    									</tr>
    								<%}
    								else 
    								{
    									for (Voter voter : voters) 
    									{%>
    										<tr>
    											<td><%= voter.getVoterId() %></td>
    											<td><%= voter.getVoterName() %></td>
    											<td><%= voter.getVoterMobile() %></td>
    											<td><%= voter.getVoterAge() %></td>
    											<td><%= voter.getVoterGender() %></td>
    											<td><%= voter.getVoterAddress() %></td>
    											<td>
    												<a href="/CRUD_Application/editVoter/<%=voter.getVoterId() %>" class="btn btn-success btn-sm edit"><i class="fa-solid fa-pen-nib"></i> Edit</a>
    												<a href="/CRUD_Application/removeVoter/<%=voter.getVoterId() %>" class="btn btn-danger btn-sm remove"><i class="fa-solid fa-trash-can"></i> Remove</a>
    											</td>
    										</tr>
    									<%}
    								}
    							%>
    						</table>
    					</div>
    				</div>
    			</div>
    		</div>
    	</div>
    
    	<jsp:include page="./includes/js.jsp"></jsp:include>
    </body>
</html>