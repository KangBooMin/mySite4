<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/assets/css/user.css"
	rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>

	<div id="container">

		<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/includes/navigation.jsp"></jsp:include>

		<div id="wrapper">
			<div id="content">
				<div id="user">

					<form id="join-form" name="joinForm" method="post" action="${pageContext.request.contextPath}/user/modify">
						<label class="block-label" for="name">이름</label> <input id="name" name="name" type="text" value="${userVo.name}" /> 
						<label class="block-label" for="email">이메일</label> <strong>${userVo.email}</strong>
						<label class="block-label">패스워드</label> <input name="password" type="password" value="" />

						<fieldset>
							<legend>성별</legend>
							<c:choose>
								<c:when test="${userVo.gender == male }">
									<label>남</label>
									<input type="radio" name="gender" value="male"
										checked="checked">
									<label>여</label>
									<input type="radio" name="gender" value="female">
								</c:when>
								<c:otherwise>
									<label>남</label>
									<input type="radio" name="gender" value="male"
										checked="checked">
									<label>여</label>
									<input type="radio" name="gender" value="female">
								</c:otherwise>
							</c:choose>

						</fieldset>

						<input type="submit" value="수정완료">

					</form>
				</div>
				<!-- /user -->
			</div>
			<!-- /content -->
		</div>
		<!-- /wrapper -->

		<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>

	</div>
	<!-- /container -->

</body>
</html>
