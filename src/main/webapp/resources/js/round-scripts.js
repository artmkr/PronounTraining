var lastJson;
function generateButton() {
    generateJson();
    document.getElementById("first").style.display = "none";
    document.getElementById("second").style.display = "";
    document.getElementById("second").style.columnSpan = "2";
}

function generateJson() {
    $.ajax({
        type: 'get',
        url: 'roundGet?coreNouns=0&coreVerbs=0',
        dataType: 'json',
        contentType: "application/json;",
        success: [function (data) {
            document.getElementById("pronoun").innerHTML = data.pronoun.pronoun;
            document.getElementById("firstVerb").innerHTML = data.verbPair.first.verb;
            document.getElementById("secondVerb").innerHTML = data.verbPair.second.verb;
            lastJson = data;
        }]
    });
}

function validateJsonRound(variant) {
    lastJson.chosenAnswer = (variant === 1) ? lastJson.verbPair.first : lastJson.verbPair.second;
    $.ajax({
        type: 'post',
        url: 'roundValidate',
        dataType: 'json',
        contentType: "application/json;",
        data: JSON.stringify(lastJson),
        success: [function (data) {
            document.getElementById("printCorrect").innerHTML = data.isAnswerCorrect;
            generateJson();
        }]
    })
}