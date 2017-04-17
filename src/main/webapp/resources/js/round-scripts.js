var lastJson = null;
var allPronouns = false;
var allVerbs = false;
var showDefinition = false;

function generateButton() {
    generateRound();
    document.getElementById("generateButtonTd").style.display = "none";
    document.getElementById("isAnswerCorrectTd").style.display = "";
    document.getElementById("settingsTutorial").style.display = "none";
    document.getElementById("trainingTutorial").style.display = "none";
    document.getElementById("firstMarginTopDiv").style.display = "";
}

function generateRound() {
    $.ajax({
        type: 'get',
        url: 'round/get?allNouns=' + allPronouns + '&allVerbs=' + allVerbs,
        dataType: 'json',
        contentType: "application/json;",
        success: [function (data) {
            document.getElementById("pronoun").innerHTML = data.pronoun.pronoun;
            document.getElementById("firstOption").innerHTML = data.verbPair.first.verb;
            document.getElementById("secondOption").innerHTML = data.verbPair.second.verb;
            lastJson = data;
            printVerbDefinition(data.verbPair.first.verb);
        }]
    });
}

function validateRound(option) {
    if (lastJson !== null) {
        lastJson.chosenAnswer = (option === 1) ? lastJson.verbPair.first : lastJson.verbPair.second;
        $.ajax({
            type: 'post',
            url: 'round/validate',
            dataType: 'json',
            contentType: "application/json;",
            data: JSON.stringify(lastJson),
            success: [function (data) {
                var isAnswerCorrect = data.isAnswerCorrect;
                if (isAnswerCorrect) {
                    document.getElementById("isAnswerCorrect").style.color = "green";
                    document.getElementById((option === 1) ? "secondOptionButton" : "firstOptionButton").disabled = false;
                    generateRound();
                } else {
                    document.getElementById("isAnswerCorrect").style.color = "red";
                    document.getElementById((option === 1) ? "firstOptionButton" : "secondOptionButton").disabled = true;
                }
                document.getElementById("isAnswerCorrect").innerHTML = isAnswerCorrect ? "Correct" : "Wrong";
            }]
        })
    }
}

function changeShowDefinitionTable() {
    if (showDefinition) {
        document.getElementById("definitionDiv").style.display = "none";
    } else {
        document.getElementById("definitionDiv").style.display = "";
    }
    showDefinition = !showDefinition;
    generateButton();
}

function printVerbDefinition(verb) {
    if (showDefinition) {
        $.ajax({
            type: 'get',
            url: 'dictionary/simpleDefinition?word=' + verb + '&partOfSpeech=verb',
            dataType: 'json',
            contentType: "application/json;",
            success: [function (data) {
                document.getElementById("verbDefinition").innerHTML = "<b>" + data.word + "</b>: " + data.definition +
                    "<br/><br/><i>" + data.example + "</i>";
            }]
        });
    }
}

function showSettings() {
    var settingsTableStyle = document.getElementById("settingsTable").style;
    if (settingsTableStyle.display === "none")
        settingsTableStyle.display = "";
    else
        settingsTableStyle.display = "none";
}

function checkShowAllPronouns() {
    allPronouns = !allPronouns;
    generateButton();
}

function checkShowAllVerbs() {
    allVerbs = !allVerbs;
    if (allVerbs) {
        document.getElementById("showDefinitionSettings").style.display = "";
    } else {
        document.getElementById("showDefinitionSettings").style.display = "none";
    }
    generateButton();
}
