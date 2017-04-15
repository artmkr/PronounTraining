var lastJson;
var allPronouns = false;
var allVerbs = false;


function generateButton() {
    generateRound();
    document.getElementById("generateButtonTd").style.display = "none";
    document.getElementById("isAnswerCorrectTd").style.display = "";
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
        }]
    });
}

function validateRound(option) {
    lastJson.chosenAnswer = (option === 1) ? lastJson.verbPair.first : lastJson.verbPair.second;
    $.ajax({
        type: 'post',
        url: 'round/validate',
        dataType: 'json',
        contentType: "application/json;",
        data: JSON.stringify(lastJson),
        success: [function (data) {
            var isAnswerCorrect = data.isAnswerCorrect.toString();
            if ("true" === isAnswerCorrect) {
                document.getElementById("isAnswerCorrect").style.color = "green";
            } else if ("false" === isAnswerCorrect) {
                document.getElementById("isAnswerCorrect").style.color = "red";
            }
            document.getElementById("isAnswerCorrect").innerHTML = isAnswerCorrect;
            generateRound();
        }]
    })
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
    generateRound();
}

function checkShowAllVerbs() {
    allVerbs = !allVerbs;
    generateRound();
}
