 const productos = [];
 
function guardarDatos() {
            const codigo = document.getElementById("codigo").value;
            const nombre = document.getElementById("nombre").value;
            const cantidad = document.getElementById("cantidad").value;
            const vencimiento = document.getElementById("vencimiento").value;
            const descripcion = document.getElementById("descripcion").value;
            const precio = document.getElementById("precio").value;

            const producto = {
                codigo: codigo,
                nombre: nombre,
                cantidad: cantidad,
                vencimiento: vencimiento,
                descripcion: descripcion,
                precio: precio
            };

            
                console.log(producto);
                document.getElementById("form").reset();//limpiar

         
}

function eliminarDatos(){
    const caja = document.getElementById("caja").value;

            for (let i = 0; i < productos.length; i++) {
                if (productos[i].codigo === caja) {
                    productos.splice(i, 1);
                    break;
                }
            }
}

function limpiarDatos(idElemento){
    idElemento.value="";
    console.log(idElemento.value);
}

function mostrarDatos(){
            const resultados = document.getElementById("resultados");
            resultados.innerHTML = '';

            if (productos.length === 0) {
                resultados.innerHTML = "No hay productos registrados.";
                return;
            }

            for (const producto of productos) {
                const productoInfo = `
                    <p><strong>Código:</strong> ${producto.codigo}</p>
                    <p><strong>Nombre:</strong> ${producto.nombre}</p>
                    <p><strong>Cantidad:</strong> ${producto.cantidad}</p>
                    <p><strong>Vencimiento:</strong> ${producto.vencimiento}</p>
                    <p><strong>Descripción:</strong> ${producto.descripcion}</p>
                    <p><strong>Precio:</strong> ${producto.precio}</p>
                    <hr>
                `;

                resultados.innerHTML += productoInfo;
            }
        }