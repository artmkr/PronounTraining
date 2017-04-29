# PronounTraining
Simple RESTful web-service that allows you to practice the usage of `Present Simple` (endings of verbs in particular). 

## Demo
You can find a live demo here: [beresnev.me](http://beresnev.me/)  
Hosted on a free-tier AWS EC2 (t2.micro, ubuntu): vcpu 1x2.5ghz, 1gb ram, 30gb ssd 

## RESTful API Commands
* **Generating round [GET]**: `/round/get?allNouns=BOOLEAN&allVerbs=BOOLEAN`  
Generates a **JSON** round that consists of a **pronoun** and a **verb pair** (same verb in singular and plural forms).
There are two types of pronouns and verbs: **"core"** and **"all"** *[should change to random]*. **Core pronouns** consist of `he, she, it, they, we, you`. **Core verbs** consist of `does, has, it, was`. All (=random) consist of random pronouns and verbs (over 2k words). Round carries `isPlural` flags for each element for further validation. **Example**:
> {"pronoun":{"pronoun":"Opinions","isPlural":true},"verbPair":{"first":{"verb":"camps","isPlural":false},"second":{"verb":"camp","isPlural":true}}}

* **Validating round [POST]**: `/round/validate` 
Validates the round. Requires the input JSON to have a `chosenAnswer` attribute, containing the information of one of the verbs *[no checking occurs atm]*. **Sample**:  
> {"pronoun":{"pronoun":"he","plural":false},"verbPair":{"first":{"verb":"are","plural":true},"second":{"verb":"is","plural":false}},"chosenAnswer":{"verb":"is","plural":false}}  

   Upon validation it sends a response containing all of the previous data + `isAnswerCorrect` boolean and a `correctAnswer` verb. **Sample**:  
> {"isAnswerCorrect":true,"correctAnswer":{"verb":"is","isPlural":false},"chosenAnswer":{"verb":"is","isPlural":false},"pronoun":{"pronoun":"he","isPlural":false},"verbPair":{"first":{"verb":"are","isPlural":false},"second":{"verb":"is","isPlural":false}}}
