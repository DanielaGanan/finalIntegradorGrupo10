/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

//function calcularMontoTotal() {
//    console.log("Calculando monto total");
//    // Obtener los valores necesarios del formulario
//    var cantidad = parseFloat(document.getElementById("cantidad").value);
//    var precioUnitario = obtenerPrecioUnitario(); // Debes implementar esta función en tu código
//
//    // Realizar el cálculo
//    var montoTotal = cantidad * precioUnitario;
//
//    // Actualizar el campo de entrada "Monto Total"
//    document.getElementById("monto_total").value = montoTotal.toFixed(2); // Redondear a dos decimales
//}
//
//function obtenerPrecioUnitario() {
//    // Implementar lógica para obtener el precio unitario según la torta seleccionada
//    // Puedes hacer esto en el servidor (en el servlet) o usando datos en el cliente (en JavaScript)
//    // Aquí un ejemplo básico:
//    var tortaSeleccionada = document.getElementById("torta").value;
//    var precios = {
//        "chocolate": 5000.0,
//        "frutos_rojos": 4000.0,
//        "pavlova": 6000.0,
//        "selva_negra": 7000.0
//    };
//    return precios[tortaSeleccionada] || 0.0; // Devolver 0 si no se encuentra la torta
//}