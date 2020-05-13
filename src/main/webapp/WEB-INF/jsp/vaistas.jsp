<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Vaistas</title>
        <jsp:include page="style.jsp"/>
        <jsp:include page="menu.jsp"/>
    </head>
    <body class="container">
        <div class="table-responsive">
            <caption>Vaisto informacija</caption>
            <table class="table table-striped"
                <tr>
                    <td><b>Id</b></td>
                    <td>${vaistas.id}</td>
                </tr>
                <tr>
                    <td><b>Vaisto pavadinimas:</b></td>
                    <td>${vaistas.vaistoPav}</td>
                </tr>
                <tr>
                    <td><b>Vaistų grupė:</b></td>
                    <td>${vaistas.vaistuGrupe}</td>
                </tr>
                <tr>
                    <td><b>Vaisto forma:</b></td>
                    <td>${vaistas.vaistoForma}</td>
                </tr>
                <tr>
                    <td><b>Veiklioji medžiaga:</b></td>
                    <td>${vaistas.veiklMedziaga}</td>
                </tr>
                <tr>
                    <td><b>Medžiagos kiekis:</b></td>
                    <<td>${vaistas.medziagosKiekis}</td>
                </tr>
            </table>
        </div>
        <br>
        <a type="button" href="/vaistuSarasas" class="button">Atgal</a>

    </body>
    <jsp:include page="footer.jsp"/>
</html>