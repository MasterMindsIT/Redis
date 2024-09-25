CRUD MANEJO CACHE CON REDIS

Hola, esto es un ejemplo de como manejar Redis, que son datos en la cache para evitar el costo de recursos en base de datos 

- Primero debes correr el servicio de Redis
Para ello debes estar en la ruta raiz, donde se encuentra el archivo docker-compose.yml y desde luego tener instalado docker
y ejecutar en la terminar: docker-compose up

Luego utilizando postman o algún software similar puedes buscar consumir los recursos que solo se encuentran en cache:
- Para agrgar una nueva orden:
Metodo: Post 
ruta: localhost:8080/api/orders
mensaje en body/raw/json:
{
"id":1,
"details":"Order1",
"quantity":8,
"price":2845
}

- Para buscar una orden específica por su id:
Metodo: Get
ruta: localhost:8080/api/orders/{id}
ejemplo: localhost:8080/api/orders/1
Obtendras una respuesta similar a la siguiente:
{
"id": 3,
"details": "Order3",
"quantity": 8,
"price": 2845
}

- Para buscar todas las órdenes:
Metodo: Get
ruta: localhost:8080/api/orders
ejemplo: localhost:8080/api/orders
Resultado será una colección similar a la siguiente:
[
{
"id": 1,
"details": "Order1",
"quantity": 1,
"price": 100
},
{
"id": 2,
"details": "Order2",
"quantity": 4,
"price": 800
}
]

- Para eliminar una orden específica por su id:
  Metodo: Delete
  ruta: localhost:8080/api/orders/{id}
  ejemplo: localhost:8080/api/orders/1
  Obtendras una respuesta similar a la siguiente:
  "Order deleted successfully"