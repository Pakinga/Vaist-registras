<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Vaistų sąrašas</title>
        <jsp:include page="style.jsp"/>
        <jsp:include page="menu.jsp"/>
    </head>
    <body class="container">
        <div class="table-responsive">
            <table class="table table-striped"
                <tr>
                    <th>Vaisto pavadinimas</th>
                    <th>Vaistų grupė</th>
                    <th>Vaisto forma</th>
                    <th>Veiklioji medžiaga</th>
                    <th>Medžiagos kiekis</th>
                </tr>

                <!-- iteruoja per visą vaistų sarašą-->
                <c:forEach var="vaistas" items="${vaistuSarasa}">

                <!-- konstruoja įrašo atnaujinimo adresą su vaisto id-->
                <c:url var="atnaujinti" value="/atnaujinti">
                    <c:param name="id" value="${vaistas.id}"/>
                </c:url>

                <!-- konstruoja įrašo trynimo adresą su vaisto id-->
                <c:url var="trinti" value="/trinti">
                    <c:param name="id" value="${vaistas.id}"/>
                </c:url>

                <!-- konstruoja įrašo peržiūros adresą su vaisto id-->
                <c:url var="rodyti" value="/rodyti">
                    <c:param name="id" value="${vaistas.id}"/>
                </c:url>
                <tr>
                    <td>${vaistas.vaistoPav}</td>
                    <td>${vaistas.vaistuGrupe}</td>
                    <td>${vaistas.vaistoForma}</td>
                    <td>${vaistas.veiklMedziaga}</td>
                    <td>${vaistas.medziagosKiekis}</td>
                    <td>
                        <!-- Atvaizduoti atnaujinimo adresą-->
                        <a href="${atnaujinti}">Keisti</a> |
                        <!-- Atvaizduoti trinimo adresą-->
                        <a href="${trinti}" onclick="if (!(confirm('Ar tikrai norite ištrinti šį įrašą?'))) return false">Trinti</a> |
                        <!-- Atvaizduoti rodymo adresą-->
                        <a href="${rodyti}">Rodyti</a>
                    </td>
                </tr>
                </c:forEach>
            </table>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>