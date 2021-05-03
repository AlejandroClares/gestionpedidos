
console.log("Funciona!!!!!");

setInterval(()=>{

	let promesa = new Promise(function(resolve, reject){
	
		let promesaRequest = new XMLHttpRequest();
		
		promesaRequest.onreadystatechange = function() {
			if (promesaRequest.readyState === 4) {
				resolve(JSON.parse(promesaRequest.responseText));
			}
		}
	
		promesaRequest.onerror = function() {
			reject("error en la petición al backend");
		}
	
		promesaRequest.open("GET","http://localhost:8086/pedidos/ultimo");
		promesaRequest.send(null);
	
	});	

	promesa.then(pedido => {
		console.log(pedido);
		pintarDom(pedido);
	});
	
	function pintarDom(pedido){

		document.getElementById("idCodigo").innerHTML = pedido.id;
		document.getElementById("idMesa").innerHTML = pedido.mesa;
		document.getElementById("idHora").innerHTML = pedido.fecha;
		document.getElementById("idCamarero").innerHTML = pedido.camarero.nombre;
		
		let table = document.getElementById("idTablaProductos");
		let numeroColumnas = table.rows.length;


		for(let i = numeroColumnas -1; i > 0; i--){
			table.deleteRow(i);
		}

		for(let lineaPedido of pedido.lineasPedido){
			let row = table.insertRow();
			let celda1 = row.insertCell(0);
			let celda2 = row.insertCell(1);
			celda1.innerHTML = lineaPedido.cantidad;
			celda2.innerHTML = lineaPedido.producto.nombre;
		}
	}

},4000);




