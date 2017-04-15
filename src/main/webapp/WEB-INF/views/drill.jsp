<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ignat
  Date: 09.04.17
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Drilling page</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/round-scripts.js"/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/drill.css"/>">
</head>
<body>
<div style="margin-top:200px"></div>
<table>
    <tr>
        <th colspan="2" width="300" height="60"><p id="pronoun"></p></th>
    </tr>
    <tr>
        <td width="150" height="50"><p id="firstOption"></p></td>
        <td width="150" height="50"><p id="secondOption"></p></td>
    </tr>
    <tr>
        <td><input type="submit" value="Choose" class="button" onclick="validateRound(1)"></td>
        <td><input type="submit" value="Choose" class="button" onclick="validateRound(2)"></td>
    </tr>
    <tr>
        <td id="generateButtonTd" colspan="2" height="75"><input id="generateButton" type="submit" value="Generate"
                                                                 class="button" onclick="generateButton()"></td>
        <td id="isAnswerCorrectTd" style="display: none; font-weight: bold" colspan="2" height="75"><span
                id="isAnswerCorrect" style="font-size: 30px;"></span></td>
    </tr>
</table>
<div style="margin-top:90px"></div>
<div align="center"><input type="submit" value="Show settings" class="button" onclick="showSettings()"/></div>
<br/>
<table id="settingsTable" style="display:none">
    <tr>
        <td>More pronouns</td>
        <td><input type="checkbox" onclick="checkShowAllPronouns()"/></td>
    </tr>
    <tr>
        <td>More verbs</td>
        <td><input type="checkbox" onclick="checkShowAllVerbs()"/></td>
    </tr>
</table>
</body>
</html>
