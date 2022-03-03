# KBTG Classnet Java assignment 01

================================================================

#### **TEST USER Authorization Token = `C217FD98A57B1BAAFC1758ABC586E`

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

| Description                | Method    | URL                                           | Header                                                     | Body                                   | Response         |
|----------------------------|-----------|-----------------------------------------------|------------------------------------------------------------|----------------------------------------|------------------|
| Get all products           | `GET`     | /api/products                                 | -                                                          | -                                      | List of Products |
| Get product details by Id  | `GET`     | /api/products/{id}                            | -                                                          | -                                      | Product          |
| Get product by search text | `GET`     | /api/products/search?productName={searchText} | -                                                          | -                                      | List of Products |
| Add product to cart        | `POST`    | /api/cart                                     | ```{"Authorization":"C217FD98A57B1BAAFC1758ABC586E"}```    | ```{"productId":20001,"quantity":5}``` | -                |
| Get items in cart          | `GET`     | /api/cart                                     | ```{"Authorization":"C217FD98A57B1BAAFC1758ABC586E"}```    | -                                      | List of Orders   |