# KBTG Classnet Java assignment 01

================================================================

#### **TEST USER Authorization Token = `C217FD98A57B1BAAFC1758ABC586E`
#### **For this project we use `stubby4j` to mock payment request/response please run `java -jar stubby4j-7.5.2.jar -d stub.yaml` before making a payment

User : `
{
id<Long>,
firstName<String>,
lastName<String>,
emailAddress<String>,
token<String>
}
`

Product : `
{
id<Long>,
name<String>,
description<String>,
price<BigDecimal>
}
`

Order : `
{
id<Long>,
product<Product>,
quantity<Integer>
}
`

| Description                | Method | URL                                           | Headers                                                 | Body                                   | Response                      |
|----------------------------|--------|-----------------------------------------------|---------------------------------------------------------|----------------------------------------|-------------------------------|
| Get all products           | `GET`  | /api/products                                 | -                                                       | -                                      | List of Products              |
| Get product details by Id  | `GET`  | /api/products/{id}                            | -                                                       | -                                      | Product                       |
| Get product by search text | `GET`  | /api/products/search?productName={searchText} | -                                                       | -                                      | List of Products              |
| Add product to cart        | `POST` | /api/cart                                     | ```{"Authorization":"C217FD98A57B1BAAFC1758ABC586E"}``` | ```{"productId":20001,"quantity":5}``` | -                             |
| Get items in cart          | `GET`  | /api/cart                                     | ```{"Authorization":"C217FD98A57B1BAAFC1758ABC586E"}``` | -                                      | List of Orders                |
| Checkout Cart              | `POST` | /api/cart/checkout                            | ```{"Authorization":"C217FD98A57B1BAAFC1758ABC586E"}``` | -                                      | Response From Payment gateway |
| Get Own user profile       | `GET`  | /api/me                                       | ```{"Authorization":"C217FD98A57B1BAAFC1758ABC586E"}``` | -                                      | User                          |