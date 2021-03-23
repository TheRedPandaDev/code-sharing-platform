# Code Sharing Platform

## API [/api](http://localhost:8889/api)

#### GET [/code](http://localhost:8889/api/code)
Get the code snippet

#### POST [/code/new](http://localhost:8889/api/code/new)
Update the code snippet

Consumes a JSON:
```javascript
{
  "code": "YOUR CODE SNIPPET" // Must not be null
}
```

## Web Interface [/](http://localhost:8889/)

#### GET [/code](http://localhost:8889/code)
Get the code snippet html page

#### GET [/code/new](http://localhost:8889/code/new)
Get the html page for updating the code snippet
