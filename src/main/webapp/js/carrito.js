// definir el carrito
const cart = [];

// función para agregar un elemento al carrito
function addToCart(item) {
    cart.push(item);
    updateCart();
}

// función para actualizar el carrito
function updateCart() {
    const cartList = document.getElementById('cart-items');
    const cartTotal = document.getElementById('cart-total');

// limpiar el carrito anterior
    cartList.innerHTML = '';

// calcular el total
    let total = 0;

// mostrar cada artículo en el carrito
    cart.forEach(item => {
        const listItem = document.createElement('li');
        listItem.textContent = item.name + ' - $' + item.price.toFixed(2);
        cartList.appendChild(listItem);
        total += item.price;
    });

// mostrar el total
    cartTotal.textContent = 'Total: $' + total.toFixed(2);
}

// función para enviar el pedido
function submitOrder() {
    // obtener datos del formulario de pedidos
    const orderForm = document.getElementById('order-form');
    const formData = new FormData(orderForm);

// construir elemento de pedido
    const order = {};
    formData.forEach((value, key) => {
        order[key] = value;
    });

// agregar el carrito al pedido
    order.cart = cart;

// simular el envío del pedido (ajustar esta parte en el backend)
    console.log('Pedido enviado:', order);

// limpiar el carrito y actualizar 
    cart.length = 0;
    updateCart();
}