# Code Sharing Platform
*currently in development*

## API [/api](http://localhost:8889/api)

### GET [/code/{UUID}](http://localhost:8889/api/code/{UUID})
Get code snippet by UUID

Returns JSON:
```javascript
{
  "code": "CODE SNIPPET",
  "date": "THE DATE IT WAS POSTED",
  "time": 0, // Time left to view the snippet (0 - unlimited)
  "views": 0 // Number of views left for the snippet (0 - unlimited)
}
```

### GET [/code/latest](http://localhost:8889/api/code/latest)
Get 10 latest unrestricted code snippets

Returns JSON array:
```javascript
[
  {
    "code": "CODE SNIPPET 10",
    "date": "THE DATE IT WAS POSTED",
    "time": 0, // Time left to view the snippet (0 - unlimited) (guarenteed to be 0)
    "views": 0 // Number of views left for the snippet (0 - unlimited) (guarenteed to be 0)
  },
  ...
  {
    "code": "CODE SNIPPET 1",
    "date": "THE DATE IT WAS POSTED",
    "time": 0, // Time left to view the snippet (0 - unlimited) (guarenteed to be 0)
    "views": 0 // Number of views left for the snippet (0 - unlimited) (guarenteed to be 0)
  }
]
```

### POST [/code/new](http://localhost:8889/api/code/new)
Post a code snippet

Consumes JSON:
```javascript
{
  "code": "YOUR CODE SNIPPET", // Must not be null
  "time": 0, // Time left to view the snippet (0 - unlimited)
  "views": 0 // Number of views left for the snippet (0 - unlimited)
}
```
Returns JSON:
```javascript
{
  "id": "YOUR CODE SNIPPET UUID"
}
```

## Web Interface [/](http://localhost:8889/)

### GET [/code/{UUID}](http://localhost:8889/code/{UUID})
Get code snippet by UUID

### GET [/code/latest](http://localhost:8889/code/latest)
Get 10 latest unrestricted code snippets

### GET [/code/new](http://localhost:8889/code/new)
Get the html page for updating the code snippet
