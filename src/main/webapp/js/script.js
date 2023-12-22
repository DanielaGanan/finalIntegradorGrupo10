let menu = document.querySelector('#menu-bars');
let navbar = document.querySelector('header .flex .navbar');

function calcularMontoTotal() {
    console.log("Calculando monto total");
    // Obtener los valores necesarios del formulario
    var cantidad = parseFloat(document.getElementById("cantidad").value);
    var precioUnitario = obtenerPrecioUnitario(); // Debes implementar esta función en tu código

    // Realizar el cálculo
    var montoTotal = cantidad * precioUnitario;

    // Actualizar el campo de entrada "Monto Total"
    document.getElementById("monto_total").value = montoTotal.toFixed(2); // Redondear a dos decimales
}

function obtenerPrecioUnitario() {
    // Implementar lógica para obtener el precio unitario según la torta seleccionada
    // Puedes hacer esto en el servidor (en el servlet) o usando datos en el cliente (en JavaScript)
    // Aquí un ejemplo básico:
    var tortaSeleccionada = document.getElementById("torta").value;
    var precios = {
        "chocolate": 5000.0,
        "frutos_rojos": 4000.0,
        "pavlova": 6000.0,
        "selva_negra": 7000.0
    };
    return precios[tortaSeleccionada] || 0.0; // Devolver 0 si no se encuentra la torta
}

menu.onclick = () =>{
  menu.classList.toggle('fa-times');
  navbar.classList.toggle('active');
}

let section = document.querySelectorAll('section');
let navLinks = document.querySelectorAll('header .navbar a');

window.onscroll = () =>{

  menu.classList.remove('fa-times');
  navbar.classList.remove('active');

  section.forEach(sec =>{

    let top = window.scrollY;
    let height = sec.offsetHeight;
    let offset = sec.offsetTop - 150;
    let id = sec.getAttribute('id');

    if(top >= offset && top < offset + height){
      navLinks.forEach(links =>{
        links.classList.remove('active');
        document.querySelector('header .navbar a[href*='+id+']').classList.add('active');
      });
    };

  });
}

document.querySelector('#search-icon').onclick = () =>{
  document.querySelector('#search-form').classList.toggle('active');
}

document.querySelector('#close').onclick = () =>{
  document.querySelector('#search-form').classList.remove('active');
}

var swiper = new Swiper(".inicio-slider", {
  spaceBetween: 30,
  centeredSlides: true,
  autoplay: {
    delay: 7500,
    disableOnInteraction: false,
  },
  pagination: {
    el: ".swiper-pagination",
    clickable: true,
  },
  loop:true,
});

var swiper = new Swiper(".staff-slider", {
  spaceBetween: 20,
  centeredSlides: true,
  autoplay: {
    delay: 7500,
    disableOnInteraction: false,
  },
  pagination: {
    el: ".swiper-pagination",
    clickable: true,
  },
  loop:true,
  breakpoints: {
    0: {
        slidesPerView: 1,
    },
    640: {
      slidesPerView: 2,
    },
    768: {
      slidesPerView: 2,
    },
    1024: {
      slidesPerView: 3,
    },
  },
});

function loader(){
  document.querySelector('.loader-container').classList.add('fade-out');
}

function fadeOut(){
  setInterval(loader, 3000);
}

window.onload = fadeOut;

