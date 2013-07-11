<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
  <jsp:include page="../layout/head.jsp"/>
<body>
  <div class="container">
    <jsp:include page="../layout/top.jsp"/>
    <spring:url value="/resources/images/pets.png" var="ttsImage"/>
    <img src="${ttsImage}"/>
    <h2>Something happened...</h2>
    <p>${exception.message}</p>
    <!-- Exception: ${exception.message}.
		  	<c:forEach items="${exception.stackTrace}" var="stackTrace"> 
				${stackTrace} 
			</c:forEach>
    -->
    <jsp:include page="../layout/footer.jsp"/>
  </div>
</body>
</html>