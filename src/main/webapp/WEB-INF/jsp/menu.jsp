<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- puslapio turinio keliui nustatyti -->

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<jsp:include page="style.jsp"/>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href ="http://localhost:8080/">Registravimo forma</a>
        </div>
        <ul class="nav navbar-nav navbar-left">
            <li class="active"><a href="/vaistuSarasas">Vaistų sąrašas</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <form id="logoutForm" method="POST" action="${contextPath}/logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
                <a onclick="document.forms['logoutForm'].submit()">Atsijungti, ${pageContext.request.userPrincipal.name}</a>
            </c:if>
        </ul>
    </div>
</nav>