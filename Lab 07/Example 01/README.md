# Web Technologies - Laboratory 07 - Exercise 01

## Example for a Marketplace

1. **Register User/Company**

- Path: `/api/users/register`
- Type: `POST`
-

Body: `{ userType: "client/individualDistributor/companyDistributor/deliverer", name: String, email: String, password: String, companyName: String (optional for companyDistributor) }`

- Response: `{ userId: UUID, userType: String, name: String, email: String, companyName: String (if applicable) }`

2. **Sign In**

- Path: `/api/users/login`
- Type: `POST`
- Body: `{ email: String, password: String }`
- Response: `{ token: String, userId: UUID, name: String, userType: String }`

3. **Create Product**

- Path: `/api/products`
- Type: `POST`
- Body: `{ userId: UUID, name: String, description: String, price: Float, quantity: Int }`
- Response: `{ productId: UUID, userId: UUID, name: String, description: String, price: Float, quantity: Int }`

4. **Update Product**

- Path: `/api/products/{productId}`
- Type: `PUT`
- Params: `productId (UUID)`
- Body: `{ name: String, description: String, price: Float, quantity: Int }`
- Response: `{ productId: UUID, userId: UUID, name: String, description: String, price: Float, quantity: Int }`

5. **Delete Product**

- Path: `/api/products/{productId}`
- Type: `DELETE`
- Params: `productId (UUID)`
- Response: `{ message: String }`

6. **Get Product(s)**

- Path: `/api/products` (all or filter by distributor), `/api/products/{productId}` (single)
- Type: `GET`
- Params: `productId (UUID)`, `userId (UUID)` (optional for distributor filter)
- Response: `{ productId: UUID, userId: UUID, name: String, description: String, price: Float, quantity: Int }` (single or array)

7. **Buy Product and Trigger Delivery**

- Path: `/api/purchases`
- Type: `POST`
- Body: `{ userId: UUID (customer), productId: UUID, quantity: Int }`
- Response: `{ purchaseId: UUID, userId: UUID (customer), productId: UUID, quantityPurchased: Int, total: Float, deliveryId: UUID }`

8. **Assign Deliverer to Delivery**

- Path: `/api/deliveries/{deliveryId}/assign`
- Type: `PUT`
- Params: `deliveryId (UUID)`
- Body: `{ delivererId: UUID }`
- Response: `{ deliveryId: UUID, purchaseId: UUID, delivererId: UUID, status: String }`

9. **Get Delivery Status**

- Path: `/api/deliveries/{deliveryId}`
- Type: `GET`
- Params: `deliveryId (UUID)`
- Response: `{ deliveryId: UUID, purchaseId: UUID, delivererId: UUID, status: String }`

10. **Update Delivery Status**

- Path: `/api/deliveries/{deliveryId}/status`
- Type: `PUT`
- Params: `deliveryId (UUID)`
- Body: `{ status: String }`
- Response: `{ deliveryId: UUID, purchaseId: UUID, delivererId: UUID, status: String }`

11. **Get Deliveries for a Distributor/Customer**

- Path: `/api/users/{userId}/deliveries`
- Type: `GET`
- Params: `userId (UUID)`
- Response: `[ { deliveryId: UUID, purchaseId: UUID, delivererId: UUID, status: String }, ... ]`

12. **Get Sales History for Distributor**

- Path: `/api/distributors/{userId}/sales-history`
- Type: `GET`
- Params: `userId (UUID)`
- Response: `[ { productId: UUID, name: String, quantitySold: Int, dateSold: Date, total: Float }, ... ]`

13. **Get Purchase History for Customer**

- Path: `/api/customers/{userId}/purchase-history`
- Type: `GET`
- Params: `userId (UUID)`
- Response: `[ { purchaseId: UUID, productId: UUID, name: String, quantityPurchased: Int, datePurchased: Date, total: Float }, ... ]`

These endpoints provide a comprehensive API for your marketplace, covering user