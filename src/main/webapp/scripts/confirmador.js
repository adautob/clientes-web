/**
 * Confirmar a exclusão de um cliente
 */

function confirmar(id){
	let resposta = confirm("Confirma a exclusão desse cliente?");
	if (resposta === true){
		window.location.href = "delete?id=" + id
	}
}