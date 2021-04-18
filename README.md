# Code Sharing Platform

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

## Examples

### Example 1

    Request POST /api/code/new with the following body:

    {
        "code": "class Code { ...",
        "time": 0,
        "views": 0
    }
    
    Response: { "id" : "7dc53df5-703e-49b3-8670-b1c468f47f1f" }.

    Request POST /api/code/new with the following body:

    {
        "code": "public static void ...",
        "time": 0,
        "views": 0
    }
    
    Response: { "id" : "e6780274-c41c-4ab4-bde6-b32c18b4c489" }.

    Request POST /api/code/new with the following body:

    {
        "code": "Secret code",
        "time": 5000,
        "views": 5
    }
    Response: { "id" : "2187c46e-03ba-4b3a-828b-963466ea348c" }.

### Example 2

    Request: GET /api/code/2187c46e-03ba-4b3a-828b-963466ea348c

    Response:

    {
        "code": "Secret code",
        "date": "2020/05/05 12:01:45",
        "time": 4995,
        "views": 4
    }
    
    Another request GET /api/code/2187c46e-03ba-4b3a-828b-963466ea348c

    Response:

    {
        "code": "Secret code",
        "date": "2020/05/05 12:01:45",
        "time": 4991,
        "views": 3
    }

### Example 3

    Request: GET /code/2187c46e-03ba-4b3a-828b-963466ea348c

    Response:
    
![image](https://user-images.githubusercontent.com/30018684/115139294-cbefc300-a039-11eb-811b-ef90fbe9b220.png)

### Example 4

    Request: GET /api/code/latest

    Response:

    [
        {
            "code": "public static void ...",
            "date": "2020/05/05 12:00:43",
            "time": 0,
            "views": 0
        },
        {
            "code": "class Code { ...",
            "date": "2020/05/05 11:59:12",
            "time": 0,
            "views": 0
        }
    ]

### Example 5

    Request: GET /code/latest

    Response:

![image](https://user-images.githubusercontent.com/30018684/115139345-0bb6aa80-a03a-11eb-822a-aa77b4117403.png)

### Example 6

    Request: GET /code/new

    Response:

![image](https://user-images.githubusercontent.com/30018684/115139352-18d39980-a03a-11eb-89a7-21cea9a74ad9.png)
