<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<jsp:include page="../layout/head.jsp"/>
<body>
  <div class="container">
    <jsp:include page="../layout/top.jsp"/>
    <h2><fmt:message key="welcome"/></h2>
    <spring:url value="/resources/images/pets.png" htmlEscape="true" var="ttsImage"/>
    <img src="${ttsImage}"/>
    <jsp:include page="../layout/footer.jsp"/>
  </div>
</body>
</html>