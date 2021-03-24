# Code Sharing Platform
*currently in development*

## API [/api](http://localhost:8889/api)

### GET [/code/{id}](http://localhost:8889/api/code/{id})
Get code snippet by id

Returns JSON:
```javascript
{
  "code": "CODE SNIPPET",
  "date": "THE DATE IT WAS POSTED"
}
```

### GET [/code/latest](http://localhost:8889/api/code/latest)
Get 10 latest code snippets

Returns JSON array:
```javascript
[
  {
    "code": "CODE SNIPPET 10",
    "date": "THE DATE IT WAS POSTED"
  },
  ...
  {
    "code": "CODE SNIPPET 1",
    "date": "THE DATE IT WAS POSTED"
  }
]
```

### POST [/code/new](http://localhost:8889/api/code/new)
Post a code snippet

Consumes JSON:
```javascript
{
  "code": "YOUR CODE SNIPPET" // Must not be null
}
```
Returns JSON:
```javascript
{
  "id": "YOUR CODE SNIPPET ID"
}
```

## Web Interface [/](http://localhost:8889/)

### GET [/code/{id}](http://localhost:8889/code/{id})
Get code snippet by id

### GET [/code/latest](http://localhost:8889/code/latest)
Get 10 latest code snippets

### GET [/code/new](http://localhost:8889/code/new)
Get the html page for updating the code snippet
