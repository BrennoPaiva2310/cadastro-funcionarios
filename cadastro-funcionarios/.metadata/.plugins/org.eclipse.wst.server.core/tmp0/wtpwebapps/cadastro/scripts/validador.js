function verificarCPF(strCpf) {
	if (!/[0-9]{11}/.test(strCpf)) return false;
	if (strCpf === "00000000000") return false;

	var soma = 0;

	for (var i = 1; i <= 9; i++) {
		soma += parseInt(strCpf.substring(i - 1, i)) * (11 - i);
	}

	var resto = soma % 11;

	if (resto === 10 || resto === 11 || resto < 2) {
		resto = 0;
	} else {
		resto = 11 - resto;
	}

	if (resto !== parseInt(strCpf.substring(9, 10))) {
		return false;
	}

	soma = 0;

	for (var i = 1; i <= 10; i++) {
		soma += parseInt(strCpf.substring(i - 1, i)) * (12 - i);
	}
	resto = soma % 11;

	if (resto === 10 || resto === 11 || resto < 2) {
		resto = 0;
	} else {
		resto = 11 - resto;
	}

	if (resto !== parseInt(strCpf.substring(10, 11))) {
		return false;
	}

	return true;
}




function validarCampos() {
	let nome = frmFuncionario.nome.value
	let strCpf = frmFuncionario.cpf.value
	let telefone = frmFuncionario.telefone.value

	if (nome === "") {
		alert("Preencha o campo nome");
		frmFuncionario.nome.focus();
		return false


	} else if (!verificarCPF(strCpf)) {
		alert("CPF inválido");
		frmFuncionario.cpf.focus();
		return false;
	}

	else if (telefone === "") {
		alert("Preencha o campo telefone");
		frmFuncionario.telefone.focus();
		return false
	} else {
		document.forms["frmFuncionario"].submit()

	}
}

function confirmarExclusao(idfunc) {
	let resposta = confirm("Confirma a exclusão deste contato?")
	if (resposta === true) {
		alert(idfunc);
		window.location.href="delete?idfunc=" + idfunc
	}



}



