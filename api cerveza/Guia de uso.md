# **Documentación de la API de Cervezas**

Esta API permite gestionar la información relacionada con cervezas, cervecerías, categorías y estilos. Los recursos pueden ser consultados, creados, actualizados y eliminados a través de peticiones HTTP.

---

### **1. Endpoints de Cervezas**

**Recurso:** `/api/beers`

**GET /api/beers**

Obtiene una lista paginada de todas las cervezas.

**Ejemplo:**
``` http
GET http://localhost:8080/api/beers
```
**Respuesta:**
```http
[
    {
        "id": 1,
        "breweryId": 812,
        "name": "Hocus Pocus",
        "categoryId": null,
        "styleId": 116,
        "abv": 4.5,
        "ibu": 0.0,
        "srm": 0.0,
        "upc": 0,
        "filepath": "",
        "descript": "Our take on a classic summer ale.  A toast to weeds, rays, and summer haze.  A light, crisp ale for mowing lawns, hitting lazy fly balls, and communing with nature, Hocus Pocus is offered up as a summer sacrifice to clodless days.\r\n\r\nIts malty sweetness finishes tart and crisp and is best apprediated with a wedge of orange.",
        "addUser": 0,
        "lastModified": null
    },
    {
        "id": 5915,
        "breweryId": 1,
        "name": "Lager Especial",
        "categoryId": 5,
        "styleId": 3,
        "abv": 5.2,
        "ibu": 15.0,
        "srm": 8.0,
        "upc": 123456789012,
        "filepath": "/images/beer1.jpg",
        "descript": "Una cerveza lager refrescante y suave.",
        "addUser": 1,
        "lastModified": "2024-11-11T14:30:00"
    }, ...
]
```

**GET /api/beer/{id}**

Obtiene la información de una cerveza específica por su ID.

**Ejemplo:**
``` http
GET http://localhost:8080/api/beer/1
```
**Respuesta:**
```http
[
    {
        "id": 1,
        "breweryId": 812,
        "name": "Hocus Pocus",
        "categoryId": null,
        "styleId": 116,
        "abv": 4.5,
        "ibu": 0.0,
        "srm": 0.0,
        "upc": 0,
        "filepath": "",
        "descript": "Our take on a classic summer ale.  A toast to weeds, rays, and summer haze.  A light, crisp ale for mowing lawns, hitting lazy fly balls, and communing with nature, Hocus Pocus is offered up as a summer sacrifice to clodless days.\r\n\r\nIts malty sweetness finishes tart and crisp and is best apprediated with a wedge of orange.",
        "addUser": 0,
        "lastModified": null
    }
]
```
**POST /api/beer**

Crea una nueva cerveza. Debes enviar los datos de la cerveza en el cuerpo de la solicitud.

**Ejemplo:**
``` http
POST http://localhost:8080/api/beer
Content-Type: application/json

{
    "name": "New Beer",
    "breweryId": 1,
    "categoryId": 2,
    "styleId": 3,
    "abv": 5.5,
    "ibu": 18,
    "srm": 8,
    "upc": "987654321098",
    "filepath": "path/to/file",
    "descript": "Description of New Beer",
    "addUser": 1
}
```
**Respuesta:**
```http
{
    "name": "New Beer",
    "breweryId": 1,
    "categoryId": 2,
    "styleId": 3,
    "abv": 5.5,
    "ibu": 18,
    "srm": 8,
    "upc": "987654321098",
    "filepath": "path/to/file",
    "descript": "Description of New Beer",
    "addUser": 1
}
```
**PUT /api/beer/{id}**

Actualiza la información de una cerveza específica por su ID.

**Ejemplo:**
``` http
PUT http://localhost:8080/api/beer/9
Content-Type: application/json

{
    "name": "New Edited Beer",
    "breweryId": 2,
    "categoryId": 3,
    "styleId": 4,
    "abv": 5.6,
    "ibu": 19,
    "srm": 9,
    "upc": "987654321098",
    "filepath": "path/to/file",
    "descript": "Description of New Beer",
    "addUser": 1
}
```
**Respuesta:**
```http
{
    "name": "New Edited Beer",
    "breweryId": 2,
    "categoryId": 3,
    "styleId": 4,
    "abv": 5.6,
    "ibu": 19,
    "srm": 9,
    "upc": "987654321098",
    "filepath": "path/to/file",
    "descript": "Description of New Beer",
    "addUser": 1
}
```

**DELETE /api/beer/{id}**

Elimina una cerveza específica por su ID.

**Ejemplo:**
``` http
DELETE http://localhost:8080/api/beer/4
```
**Respuesta:**
```http
204 No Content
```

### **2. Endpoints de Cervecerías**

**Recurso:** `/api/breweries`

**GET /api/breweries**

Obtiene una lista paginada de todas las cervecerías'.

**Ejemplo:**
``` http
GET http://localhost:8080/api/breweries
```
**Respuesta:**
```http
[
    {
        "id": 1,
        "name": "(512) Brewing Company",
        "address1": "407 Radam, F200",
        "address2": "",
        "city": "Austin",
        "state": "Texas",
        "code": "78745",
        "country": "United States",
        "phone": "512.707.2337",
        "website": "http://512brewing.com/",
        "filepath": "",
        "description": null,
        "addUser": 0,
        "lastModified": null
    },
    {
        "id": 2,
        "name": "21st Amendment Brewery Cafe",
        "address1": "563 Second Street",
        "address2": "",
        "city": "San Francisco",
        "state": "California",
        "code": "94107",
        "country": "United States",
        "phone": "1-415-369-0900",
        "website": "http://www.21st-amendment.com/",
        "filepath": "",
        "description": null,
        "addUser": 0,
        "lastModified": null
    }, ...
]
```

**GET /api/brewerie/{id}**

Obtiene la información de una cervecería específica por su ID.

**Ejemplo:**
``` http
GET http://localhost:8080/api/brewerie/3
```
**Respuesta:**
```http
{
	"id": 9,
	"name": "Aberdeen Brewing",
	"address1": "210 Aberdeen Dr.",
	"address2": "",
	"city": "Valparaiso",
	"state": "Indiana",
	"code": "",
	"country": "United States",
	"phone": "(219) 548-3300",
	"website": "",
	"filepath": "",
	"description": null,
	"addUser": 0,
	"lastModified": null
}
```

### **3. Endpoints de Categorías**

**Recurso:** `/api/categories`

**GET /api/categories**

Obtiene una lista paginada de todas las categorías.

**Ejemplo:**
``` http
GET http://localhost:8080/api/categories
```
**Respuesta:**
```http
[
    {
        "id": 1,
        "catName": "British Ale",
        "lastModified": null
    },
    {
        "id": 2,
        "catName": "Irish Ale",
        "lastModified": null
    }, ...
]
```

**GET /api/categorie/{id}**

Obtiene la información de una categoría específica por su ID.

**Ejemplo:**
``` http
GET http://localhost:8080/api/categorie/9
```
**Respuesta:**
```http
{
	"id": 9,
	"catName": "Other Lager",
	"lastModified": null
}
```

### **4. Endpoints de Cervecerías**

**Recurso:** `/api/styles`

**GET /api/styles**

Obtiene una lista paginada de todos los estilos.

**Ejemplo:**
``` http
GET http://localhost:8080/api/styles
```
**Respuesta:**
```http
[
    {
        "id": 1,
        "catId": 1,
        "styleName": "Classic English-Style Pale Ale",
        "lastMod": "2010-10-24T13:53:31"
    },
    {
        "id": 2,
        "catId": 1,
        "styleName": "English-Style India Pale Ale",
        "lastMod": "2010-06-15T19:14:38"
    }, ...
]
```

**GET /api/style/{id}**

Obtiene la información de una cervecería específica por su ID.

**Ejemplo:**
``` http
GET http://localhost:8080/api/style/9
```
**Respuesta:**
```http
{
    "id": 9,
    "catId": 1,
    "styleName": "Scottish-Style Export Ale",
    "lastMod": "2010-06-15T19:15:45"
}
```