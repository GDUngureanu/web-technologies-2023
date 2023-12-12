## Request Examples

### Category

```
POST /categories
Content-Type: application/json

{
  "name": "Electronics",
  "description": "All kinds of electronic devices and gadgets."
}
```

```
POST /categories
Content-Type: application/json

{
  "name": "Sports Equipment",
  "description": "Equipment and accessories for various sports like football, basketball, tennis, and outdoor activities."
}
```

```
POST /categories
Content-Type: application/json

{
  "name": "Home Decor",
  "description": "Decorative items and furniture to enhance your living space, including vases, paintings, lamps, and more."
}
```

```
POST /categories
Content-Type: application/json

{
  "name": "Gardening Tools",
  "description": "Tools and supplies for gardening enthusiasts, including spades, gloves, planters, and fertilizers."
}
```

```
POST /categories
Content-Type: application/json

{
  "name": "Kitchen Appliances",
  "description": "Modern and efficient appliances for your kitchen needs, including blenders, ovens, toasters, and coffee makers."
}
```

```
POST /categories
Content-Type: application/json

{
  "name": "Books",
  "description": "A wide range of books from various genres including fiction, non-fiction, educational, and more."
}
```

```
PUT /categories/1
Content-Type: application/json

{
  "name": "Home Electronics",
  "description": "Electronic appliances and gadgets for home use."
}
```

```
PUT /categories/3
Content-Type: application/json

{
  "name": "Fashion Accessories",
  "description": "Latest trends in fashion accessories."
}
```

```
GET /categories
```

```
GET /categories/1
```

```
DELETE /categories/2
```

### Product

```
POST /products
Content-Type: application/json

{
  "name": "Wireless Earbuds",
  "description": "High-quality wireless earbuds with noise cancellation.",
  "price": 99.99,
  "categoryIds": [1, 3]
}
```

```
POST /products
Content-Type: application/json

{
  "name": "4K HDR TV",
  "description": "65-inch 4K HDR television with smart features.",
  "price": 1200.00,
  "categoryIds": [1, 5]
}
```

```
POST /products
Content-Type: application/json

{
  "name": "UltraSlim Laptop",
  "description": "Lightweight and powerful laptop with a 15-inch screen and 10-hour battery life.",
  "price": 899.99,
  "categoryIds": [1, 6]
}
```

```
POST /products
Content-Type: application/json

{
  "name": "Automatic Coffee Maker",
  "description": "Brews perfect coffee every time with programmable features and built-in grinder.",
  "price": 249.99,
  "categoryIds": [5, 7]
}
```

```
POST /products
Content-Type: application/json

{
  "name": "Family Board Game",
  "description": "Fun and engaging board game suitable for all ages, perfect for family game nights.",
  "price": 34.99,
  "categoryIds": [9]
}
```

```
POST /products
Content-Type: application/json

{
  "name": "Advanced Fitness Tracker",
  "description": "Track your fitness progress with this state-of-the-art waterproof fitness tracker.",
  "price": 129.99,
  "categoryIds": [2, 10]
}
```

```
PUT /products/4
Content-Type: application/json

{
  "name": "Smartwatch",
  "description": "Latest model smartwatch with health tracking features.",
  "price": 199.99,
  "categoryIds": [2, 4]
}
```

```
PUT /products/3
Content-Type: application/json

{
  "name": "Bluetooth Speaker",
  "description": "Portable Bluetooth speaker with surround sound.",
  "price": 59.99,
  "categoryIds": [3]
}
```

```
GET /products
```

```
GET /products/2
```

```
DELETE /products/7
```

### Customer

```
POST /customers
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "deliveryAddress": {
    "street": "123 Apple St",
    "city": "New York",
    "postalCode": "10001",
    "country": "USA",
    "deliveryInstructions": "Leave at the front desk"
  }
}
```

```
POST /customers
Content-Type: application/json

{
  "name": "Jane Smith",
  "email": "jane.smith@example.com",
  "deliveryAddress": {
    "street": "456 Orange Ave",
    "city": "Los Angeles",
    "postalCode": "90001",
    "country": "USA",
    "deliveryInstructions": "Ring the doorbell twice"
  }
}
```

```
POST /customers
Content-Type: application/json

{
  "name": "Alice Johnson",
  "email": "alice.johnson@example.com",
  "deliveryAddress": {
    "street": "789 Banana Blvd",
    "city": "Chicago",
    "postalCode": "60601",
    "country": "USA"
  }
}
```

```
POST /customers
Content-Type: application/json

{
  "name": "Carlos Rodriguez",
  "email": "carlos.rodriguez@example.com",
  "deliveryAddress": {
    "street": "1234 Pineapple Street",
    "city": "Mexico City",
    "postalCode": "11000",
    "country": "Mexico",
    "deliveryInstructions": "Call upon arrival"
  }
}
```

```
PUT /customers/1
Content-Type: application/json

{
  "name": "John Doe",
  "email": "new.john.doe@example.com",
  "deliveryAddress": {
    "street": "321 New Apple St",
    "city": "New York",
    "postalCode": "10001",
    "country": "USA",
    "deliveryInstructions": "Leave at the door"
  }
}
```

```
PUT /customers/2
Content-Type: application/json

{
  "name": "Jane Doe",
  "email": "jane.smith@example.com",
  "deliveryAddress": {
    "street": "456 Orange Ave",
    "city": "Los Angeles",
    "postalCode": "90001",
    "country": "USA",
    "deliveryInstructions": "Ring the doorbell twice"
  }
}
```

```
PUT /customers/3
Content-Type: application/json

{
  "name": "Alice Johnson",
  "email": "alice.johnson@example.com",
  "deliveryAddress": {
    "street": "789 Banana Blvd",
    "city": "Chicago",
    "postalCode": "60601",
    "country": "USA",
    "deliveryInstructions": "Leave with the neighbor if not home"
  }
}
```

```
GET /customers
```

```
GET /customers/1
```

```
DELETE /customers/4
```

```
POST /customers
Content-Type: application/json

{
  "name": "Emma Wilson",
  "email": "emma.wilson@example.com"
}
```

```
PUT /customers/5
Content-Type: application/json

{
  "name": "Robert Brown",
  "email": "robert.brown@example.com",
  "deliveryAddress": {
    "street": "100 Cherry Road",
    "city": "Boston",
    "postalCode": "02101",
    "country": "USA"
  }
}
```

```
PUT /customers/6
Content-Type: application/json

{
  "name": "Sophia Green",
  "email": "sophia.green@example.com",
  "deliveryAddress": {
    "street": "200 Lemon Lane",
    "city": "San Francisco",
    "postalCode": "94102",
    "country": "USA",
    "deliveryInstructions": "Contact before delivery"
  }
}
```

```
POST /customers
Content-Type: application/json

{
  "name": "Liam Johnson",
  "email": "liam.johnson@example.com",
  "deliveryAddress": {
    "street": "300 Grape Street",
    "city": "Seattle",
    "postalCode": "98101",
    "country": "USA",
    "deliveryInstructions": "Deliver to back door, ring bell"
  }
}
```

### Orders

```
POST /orders
Content-Type: application/json

{
  "customerId": 1,
  "items": [
    {
      "productId": 100,
      "quantity": 2
    },
    {
      "productId": 101,
      "quantity": 1
    }
  ]
}
```

```
POST /orders
Content-Type: application/json

{
  "customerId": 2,
  "items": [
    {
      "productId": 102,
      "quantity": 1
    }
  ]
}
```

```
POST /orders
Content-Type: application/json

{
  "customerId": 3,
  "items": [
    {
      "productId": 103,
      "quantity": 3
    },
    {
      "productId": 104,
      "quantity": 2
    },
    {
      "productId": 105,
      "quantity": 4
    }
  ]
}
```

```
POST /orders
Content-Type: application/json

{
  "customerId": 4,
  "items": [
    {
      "productId": 106,
      "quantity": 1
    }
  ]
}
```

```
PUT /orders/1
Content-Type: application/json

{
  "customerId": 1,
  "items": [
    {
      "productId": 107,
      "quantity": 2
    },
    {
      "productId": 108,
      "quantity": 3
    }
  ]
}
```

```
PUT /orders/2
Content-Type: application/json

{
  "customerId": 2,
  "items": [
    {
      "productId": 100,
      "quantity": 1
    }
  ]
}
```

```
PUT /orders/3
Content-Type: application/json

{
  "customerId": 3,
  "items": [
    {
      "productId": 109,
      "quantity": 1
    },
    {
      "productId": 110,
      "quantity": 1
    }
  ]
}
```

```
GET /orders
```

```
GET /orders/1
```

```
DELETE /orders/4
```

```
POST /orders
Content-Type: application/json

{
  "customerId": 5,
  "items": [
    {
      "productId": 111,
      "quantity": 2
    }
  ]
}
```

```
PUT /orders/5
Content-Type: application/json

{
  "customerId": 5,
  "items": [
    {
      "productId": 112,
      "quantity": 1
    },
    {
      "productId": 113,
      "quantity": 2
    }
  ]
}
```

```
POST /orders
Content-Type: application/json

{
  "customerId": 6,
  "items": [
    {
      "productId": 114,
      "quantity": 1
    },
    {
      "productId": 115,
      "quantity": 3
    },
    {
      "productId": 116,
      "quantity": 2
    }
  ]
}
```

```
PUT /orders/6
Content-Type: application/json

{
  "customerId": 6,
  "items": [
    {
      "productId": 117,
      "quantity": 2
    },
    {
      "productId": 118,
      "quantity": 1
    },
    {
      "productId": 119,
      "quantity": 1
    }
  ]
}
```

```
POST /orders
Content-Type: application/json

{
  "customerId": 7,
  "items": [
    {
      "productId": 120,
      "quantity": 5
    },
    {
      "productId": 121,
      "quantity": 2
    }
  ]
}
```

```
PUT /orders/7
Content-Type: application/json

{
  "customerId": 7,
  "items": [
    {
      "productId": 122,
      "quantity": 1
    }
  ]
}
```

### Delivery Addresses

```
POST /deliveryAddresses
Content-Type: application/json

{
  "customerId": 1,
  "street": "123 Apple St",
  "city": "New York",
  "postalCode": "10001",
  "country": "USA",
  "deliveryInstructions": "Leave at the front desk"
}
```

```
POST /deliveryAddresses
Content-Type: application/json

{
  "customerId": 2,
  "street": "456 Orange Ave",
  "city": "Los Angeles",
  "postalCode": "90001",
  "country": "USA",
  "deliveryInstructions": "Ring the doorbell twice"
}
```

```
POST /deliveryAddresses
Content-Type: application/json

{
  "customerId": 3,
  "street": "789 Banana Blvd",
  "city": "Chicago",
  "postalCode": "60601",
  "country": "USA"
}
```

```
POST /deliveryAddresses
Content-Type: application/json

{
  "customerId": 4,
  "street": "1234 Pineapple Street",
  "city": "Mexico City",
  "postalCode": "11000",
  "country": "Mexico",
  "deliveryInstructions": "Call upon arrival"
}
```

```
PUT /deliveryAddresses/1
Content-Type: application/json

{
  "customerId": 1,
  "street": "321 New Apple St",
  "city": "New York",
  "postalCode": "10002",
  "country": "USA",
  "deliveryInstructions": "Leave at the door"
}
```

```
PUT /deliveryAddresses/2
Content-Type: application/json

{
  "customerId": 2,
  "street": "456 Orange Ave",
  "city": "Los Angeles",
  "postalCode": "90002",
  "country": "USA",
  "deliveryInstructions": "Contact on arrival"
}
```

```
PUT /deliveryAddresses/3
Content-Type: application/json

{
  "customerId": 3,
  "street": "789 Banana Blvd",
  "city": "Miami",
  "postalCode": "33101",
  "country": "USA",
  "deliveryInstructions": "Leave with the neighbor if not home"
}
```

```
GET /deliveryAddresses
```

```
GET /deliveryAddresses/1
```

```
DELETE /deliveryAddresses/4
```

```
POST /deliveryAddresses
Content-Type: application/json

{
  "customerId": 5,
  "street": "100 Cherry Road",
  "city": "Boston",
  "postalCode": "02101",
  "country": "USA",
  "deliveryInstructions": "Third floor, apartment 5B"
}
```

```
PUT /deliveryAddresses/5
Content-Type: application/json

{
  "customerId": 5,
  "street": "200 Lemon Lane",
  "city": "Toronto",
  "postalCode": "M5H 2N2",
  "country": "Canada",
  "deliveryInstructions": "Leave at reception"
}
```

```
POST /deliveryAddresses
Content-Type: application/json

{
  "customerId": 6,
  "street": "500 Grape Street",
  "city": "Rural Town",
  "postalCode": "12345",
  "country": "USA",
  "deliveryInstructions": "At the red mailbox"
}
```
