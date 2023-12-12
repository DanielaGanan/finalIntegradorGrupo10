/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

// barra de navegación
let menu = document.querySelector('#menu-icon');
let navbar = document.querySelector('.navbar');

menu.onclick = () => {
    navbar.classList.toggle('active');
};

window.onscroll = () => {
    navbar.classList.remove('active');
};

// botón de modo oscuro
let darkmode = document.querySelector('#modooscuro');

darkmode.onclick = () => {
    if (darkmode.classList.contains('bx-moon')) {
        darkmode.classList.replace('bx-moon', 'bx-sun');
        document.body.classList.add('active');
    } else {
        darkmode.classList.replace('bx-sun', 'bx-moon');
        document.body.classList.remove('active');
    }
};

// animación de scroll
const sr = ScrollReveal({
    origin: 'top',
    distance: '40px',
    duration: 2000,
    reset: true
});

const elementsToReveal = document.querySelectorAll(`
    .home-text, .home-img,
    .about-img, .about-text,
    .box, .s-box,
    .btn, .connect-text,
    .contact-box
`);

elementsToReveal.forEach((element) => {
    sr.reveal(element, {
        interval: 200
    });
});

