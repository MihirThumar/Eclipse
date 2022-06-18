<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="./base.jsp"%>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">Fill the product detail</h1>

				<form action="Genjutsu" method="post">

					<div class="form-group">
						<label for="name">Product Name </label> <input type="text"
							class="form-control" id="name" name="name"
							placeholder="Enter the Product Name Hree" />
					</div>

					<div class="form-group">
						<label for="description">Product Description</label>
						<textarea rows="5" class="form-control" name="description"
							id="description"></textarea>
					</div>

					<div class="form-group">
						<label for="price">Product price</label> <input type="text"
							class="form-control" id="price" name="price">
					</div>

					<div class="container text-center">
						<a href=" ${pageContext.request.contextPath }/" class="btn btn-outline-danger">Back </a>
						<button type="submit" class="btn btn-primary">Add	</button>
					</div>

				</form>

			</div>
		</div>
	</div>
</body>
</html>