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
<div id="firstMarginTopDiv" style="margin-top:200px; display:none"></div>
<div id="trainingTutorial" align="center" style="margin-top: 100px;">
    <table class="" width="500">
        <tr>
            <td align="justify">
                Not sure <b>when to add 'S' to the end of the verb</b>? Have to constantly think about it and remember
                silly rules?
                It's just a <b>matter of practice</b>, I say.
                <ul>
                    <li><b>Practice makes perfect</b> - the more you see, hear & practice the correct usage of grammar,
                        the less you'll think about it while speaking
                    </li>
                    <li><b>Practice regularly</b> - visit this website for a 5-10 minutes a day
                        and practice the correct usage of present simple
                    </li>
                    <li><b>Think less, do more</b> - Try not to think too much about rules and examples, let it be
                        automatic.
                        Just <b>give answers as quick as you can</b>, and sooner or later you'll start getting it right.
                    </li>
                </ul>
            </td>
        </tr>
    </table>
</div>
<table class="quizTable">
    <tr>
        <th colspan="2" width="300" height="60"><p id="pronoun">Pronoun here</p></th>
    </tr>
    <tr>
        <td width="150" height="50"><p id="firstOption">First verb</p></td>
        <td width="150" height="50"><p id="secondOption">Second verb</p></td>
    </tr>
    <tr>
        <td><input id="firstOptionButton" type="submit" value="Choose [1]" class="button" onclick="validateRound(1)">
        </td>
        <td><input id="secondOptionButton" type="submit" value="Choose [2]" class="button" onclick="validateRound(2)">
        </td>
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
<div id="definitionDiv" align="center" style="display: none">
    <table class="definitionTable">
        <tr>
            <td align="justify">
                <span id="verbDefinition">Loading definition...</span>
            </td>
        </tr>
    </table>
</div>
<div id="settingsTutorial" align="center" style="margin-top:50px;">
    <table class="" width="430">
        <tr>
            <td align="justify">
                Be sure to checkout <b>settings</b> down below. There you can:
                <ul>
                    <li>Enable <b>more pronouns</b> - adds more random pronouns</li>
                    <li>Enable <b>more verbs</b> - adds more random verbs</li>
                    <li>Show <b>verb definition</b> - shows dictionary definition for current verb (with example). <i>[only
                        with more verbs enabled]</i></li>
                </ul>
            </td>
        </tr>
    </table>
</div>
<br/>
<div align="center"><input type="submit" value="Show / hide settings" class="button" onclick="showSettings()"/></div>
<br/>
<table id="settingsTable" class="settingsTableClass">
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
