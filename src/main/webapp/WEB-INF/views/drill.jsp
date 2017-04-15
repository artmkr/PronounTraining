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
<div class="space"></div>
<table class="tg">
    <tr>
        <th colspan="2" width="300" height="60"><p id="pronoun"></p></th>
    </tr>
    <tr>
        <td width="150" height="50"><p id="firstVerb"></p></td>
        <td width="150" height="50"><p id="secondVerb"></p></td>
    </tr>
    <tr>
        <td><input type="submit" value="Choose" class="buttonChoose" onclick="validateJsonRound(1)"></td>
        <td><input type="submit" value="Choose" class="buttonChoose" onclick="validateJsonRound(2)"></td>
    </tr>
    <tr>
        <td id="first" colspan="2"><input type="submit" value="Generate" class="buttonGenerate"
                                          onclick="generateButton()"></td>
        <td id="second" style="display: none; font-weight: bold" colspan="2" height="70"><span id="printCorrect"></span>
        </td>
    </tr>
</table>
<p id="jsonAnswer"></p>
<br/>
</body>
</html>
