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
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/training.css"/>">
</head>
<body>
<div style="margin-top:200px"></div>
<table class="quizTable">
    <tr>
        <th colspan="2" width="300" height="60"><p id="pronoun">Pronoun here</p></th>
    </tr>
    <tr>
        <td width="150" height="50"><p id="firstOption">First verb</p></td>
        <td width="150" height="50"><p id="secondOption">Second verb</p></td>
    </tr>
    <tr>
        <td><input id="firstOptionButton" type="submit" value="Choose" class="button" onclick="validateRound(1)"></td>
        <td><input id="secondOptionButton" type="submit" value="Choose" class="button" onclick="validateRound(2)"></td>
    </tr>
    <tr>
        <td id="generateButtonTd" colspan="2" height="75">
            <input id="generateButton" type="submit" value="PRESS HERE TO START" class="button"
                   onclick="generateButton()">
        </td>
        <td id="isAnswerCorrectTd" style="display: none; font-weight: bold" colspan="2" height="75">
            <span id="isAnswerCorrect" style="font-size: 30px;"></span>
        </td>
    </tr>
</table>
<br/>
<%--<div align="center"><input type="submit" value="Definition" class="button" onclick="showDefinition()"/></div>--%>
<div id="definitionDiv" align="center" style="display: none">
    <table class="definitionTable">
        <tr>
            <td align="justify">
                <span id="verbDefinition">Loading definition...</span>
            </td>
        </tr>
    </table>
</div>
<div style="margin-top:50px"></div>
<div align="center"><input type="submit" value="Show / hide settings" class="button" onclick="showSettings()"/></div>
<br/>
<table id="settingsTable" style="display:none" class="settingsTableClass">
    <tr>
        <td style="width: 200px">More pronouns</td>
        <td style="width:20px"><input type="checkbox" onclick="checkShowAllPronouns()"/></td>
    </tr>
    <tr>
        <td>More verbs</td>
        <td><input type="checkbox" onclick="checkShowAllVerbs()"/></td>
    </tr>
    <tr id="showDefinitionSettings" style="display: none">
        <td>Show definition for verbs</td>
        <td><input type="checkbox" onclick="changeShowDefinitionTable()"/></td>
    </tr>
</table>
</body>
</html>
