<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<table class="footer">
    <tr>
        <td></td>
        <td align="right"><img src="<spring:url value="/resources/images/springsource-logo.png" htmlEscape="true" />" alt="Sponsored by SpringSource"/></td>
    </tr>
</table>
<spring:url value="/webjars/jquery/1.9.0/jquery.js" var="jQuery"/><script src="${jQuery}"></script>
<spring:url value="/webjars/jquery-ui/1.9.2/js/jquery-ui-1.9.2.custom.js" var="jQueryUi"/><script src="${jQueryUi}"></script>