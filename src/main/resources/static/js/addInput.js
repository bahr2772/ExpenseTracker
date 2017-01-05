var counter = 1;
var limit = 10;

function addInput(divName) {
    var newdiv = document.createElement('div');
    newdiv.innerHTML = "Entry " + (counter + 1) + " <br><input type='text' th:field='*{expense[" + counter + "].name}' name='myInputs[]'/>";
    document.getElementById(divName).appendChild(newdiv);
    counter++;
}