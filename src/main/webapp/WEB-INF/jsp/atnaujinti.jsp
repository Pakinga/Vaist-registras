<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Vaisto duomenų atnaujinimas</title>
        <jsp:include page="style.jsp"/>
        <jsp:include page="menu.jsp"/>
    </head>
    <body class="container">
        <form:form name="vaistas" action="/atnaujintiVaista" method="post">
            <!-- id būtina pateikti formoje, kitaip į back-end nueis null. Todėl darome hiden, kad nerdaguotų -->
            <input type="hidden" name="id" value="${vaistas.id}"><p>
            Vaisto pavadinimas:<br>
            <input type="text" name="vaistoPav" value="${vaistas.vaistoPav}"><p>
            Vaistų grupė:<br>
            <input type="text" name="vaistuGrupe" value="${vaistas.vaistuGrupe}"><p>
            Vaisto forma:<br>
            <input type="text" name="vaistoForma" value="${vaistas.vaistoForma}"><p>
            Veiklioji medžiaga:<br>
            <input type="text" name="veiklMedziaga" value="${vaistas.veiklMedziaga}"><p>
            Medžiagos kiekis:<br>
            <input type="number" name="medziagosKiekis" value="${vaistas.medziagosKiekis}"><p>
            <input type="submit" value="Atnaujinti"><p>
        </form:form>

    </body>
    <jsp:include page="footer.jsp"/>
</html>