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
    <script type="text/javascript">
        function generateButton() {
            generateJson();
            document.getElementById("first").style.display = "none";
            document.getElementById("second").style.display = "";
            document.getElementById("second").style.columnSpan = "2";
        }

        function generateJson() {
            $.ajax({
                url: 'getRound?coreNouns=0&coreVerbs=0',
                dataType: 'json',
                success: [function (data) {
                    document.getElementById("pronoun").innerHTML = data.pronoun.pronoun;
                    document.getElementById("firstVerb").innerHTML = data.verbPair.first.verb;
                    document.getElementById("secondVerb").innerHTML = data.verbPair.second.verb;
                }]
            });
        }

        function validateRound(variant) {
            $.ajax({
                url: 'validateRound',
                data: ({choice: variant}),
                success: [function (data) {
                    $('#printCorrect').html(data);
                    generateJson();
                }]
            });

        }
    </script>
    <style>

        table {
            margin: 0 auto;
        }

        .tg {
            border-collapse: collapse;
            border-spacing: 0;
        }

        table, th, td {
            border: 1px solid black;
            border-spacing: 2px;
            text-align: center;
        }

        th {
            font-size: 30px;
        }

        td {
            font-size: 23px;
            padding: 10px;
        }

        .buttonGenerate {
            border: none;
            padding: 12px 84px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 4px;
        }

        .buttonChoose {
            border: none;
            padding: 6px 54px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 4px;
        }

        .space {
            margin-top: 200px;
        }
    </style>
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
        <td><input type="submit" value="Choose" class="buttonChoose" onclick="validateRound(1)"></td>
        <td><input type="submit" value="Choose" class="buttonChoose" onclick="validateRound(2)"></td>
    </tr>
    <tr>
        <td id="first" colspan="2"><input type="submit" value="Generate" class="buttonGenerate"
                                          onclick="generateButton()"></td>
        <td id="second" style="display: none; font-weight: bold" colspan="2" height="70"><span id="printCorrect"></span>
        </td>
    </tr>
</table>
<br/>
</body>
</html>
