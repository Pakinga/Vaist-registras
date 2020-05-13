<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>Vaistų registracija</title>
    <jsp:include page="style.jsp"/>
    <jsp:include page="menu.jsp"/>
    <style>
       .error{color:red}
    </style>
</head>
    <body class="container">
        <h2>Vaisto registravimo forma</h2>
        <form:form method= "post" action="#" class="form-data">
        <table>
            <tr>
                <td class="text-right">Vaisto pavadinimas:</td>
                <td><form:input type="text" path="vaistoPav" class="form-control"></form:input></td>
                <td><form:errors path="vaistoPav" cssClass="error"></form:errors><br><br></td>
            </tr>
            <tr>
                <td class="text-right">Vaistų grupė:</td>
                <td>
                <select name="vaistuGrupe">
                    <option  value="none">-- Pasirinkti --</option>
                    <option  value="vitaminai">Vitaminai</option>
                    <option  value="priesuzdegiminiai">Priešuždegiminiai</option>
                    <option  value="analgetikai">Analgetikai</option>
                    <option  value="antihistamininiai">Antihistamininiai</option>
                    <option  value="akfInhibitoriai">AKF inhibitoriai</option>
                    <option  value="antibiotikai">Antibiotikai</option>
                </select><br><br>
                </td>
            </tr>
            <tr>
                <td class="text-right">Vaisto forma:</td>
                <td><select name="vaistoForma">
                     <option  value="none">-- Pasirinkti --</option>
                     <option  value="tabletes">Tabletės</option>
                     <option  value="kapsules">Kapsulės</option>
                     <option  value="tinktura">Tinktūra</option>
                     <option  value="injekciniai">Injekciniai</option>
                     <option  value="zvakutes">Žvakutės</option>
                     <option  value="milteliai">Milteliai</option>
                </select><br><br>
                </td>
            </tr>
            <tr>
                <td class="text-right">Veiklioji medžiaga:</td>
                <td><form:input type="text" path="veiklMedziaga" class="form-control"/></td>
                <td><form:errors path="veiklMedziaga" cssClass="error"/><br></td>
            </tr>
            <tr>
                <td class="text-right">Veikl. medžiagos kiekis:</td>
                <td>
                <form:input type="text" path="medziagosKiekis" class="form-control"/>
                <span class="input-group-append">mg</span>
                </td>
                <td><form:errors path="medziagosKiekis" cssClass="error"/><br><br></td>
            </tr>
            <tr>
                <td class="text-right"></td>
                <td><input type="submit" value="Įrašyti"></td>
            </tr>
        </table>
     </form:form>

    </body>
    <jsp:include page="footer.jsp"/>
</html>