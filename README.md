## Sample-Service
Simple account server.

#### Accounts service
List all accounts [http://localhost:8000/account](http://localhost:8000/account)
```json
[  
   {  
      "id":1,
      "name":"Lex Luthor",
      "email":"lex_luthor@gmail.com",
      "age":35,
      "links":[  
         {  
            "rel":"self",
            "href":"http://localhost:8000/account/1"
         }
      ]
   },
   {  
      "id":2,
      "name":"Lionel Luthor",
      "email":"lionel_luthor@gmail.com",
      "age":35,
      "links":[  
         {  
            "rel":"self",
            "href":"http://localhost:8000/account/2"
         }
      ]
   },
   {  
      "id":3,
      "name":"Lois Lane",
      "email":"lois_lane@gmail.com",
      "age":35,
      "links":[  
         {  
            "rel":"self",
            "href":"http://localhost:8000/account/3"
         }
      ]
   },
   {  
      "id":4,
      "name":"Lana Lang",
      "email":"lana_lang@gmail.com",
      "age":35,
      "links":[  
         {  
            "rel":"self",
            "href":"http://localhost:8000/account/4"
         }
      ]
   }
]
```

Get 1 account [http://localhost:8000/account/1(http://localhost:8000/account/1)
```json
{
  "id": 1,
  "name": "Lex Luthor",
  "email": "lex_luthor@gmail.com",
  "age": 35
}
```