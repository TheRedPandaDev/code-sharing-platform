function send() {
    let object = {
        "code": document.getElementById("code_snippet").value
    };

    let json = JSON.stringify(object);

    let jsonResponse;

    let xhr = new XMLHttpRequest();
    xhr.open("POST", '/api/code/new', false)
    xhr.onload  = function() {
        jsonResponse = JSON.parse(xhr.responseText);
    };
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.send(json);

    if (xhr.status === 200) {
        alert("Success! Snippet ID: " + jsonResponse.id);
    }
}
