# Game Shop Mongo GraphQL

This application was used for learning purposes, keep in mind that the code does not reflect any functionality and its main reason is be a POC.

The queries are findAllCarts and findCartByUser.

Theres only one mutation exposed:

    mutation {
      addItemToCart(cartId: "mongo_cart_id", value: 100.00, type: "Cyberpunk 2077") {
        id
      }
    }
    
Theres also a normal HTTP endpoint on /carts that return all data from Mongo.