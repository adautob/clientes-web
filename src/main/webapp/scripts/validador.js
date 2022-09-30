/**
 * Validação dos campos
 */

function validar(){
	let nome = frmCliente.nome.value
	let email = frmCliente.email.value
	let telefone = frmCliente.telefone.value
	
	if (nome === ""){
		alert("Preencha o campo Nome")
		frmCliente.nome.focus()
		return false
	} else if (email === ""){
		alert ("Preencha o campo Email")
		frmCliente.email.focus()
		return false
	} else if (telefone === ""){
		alert ("Preencha o campo Telefone")
		frmCliente.telefone.focus()
		return false
	} else {
		document.forms["frmCliente"].submit()
	}
	
}