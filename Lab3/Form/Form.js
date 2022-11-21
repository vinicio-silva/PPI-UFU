function checkForm () {
    var nome = document.getElementById('nome').value;
    var sexo = document.getElementsByName('gridRadios');
    var data = document.getElementById('data_nascimento').value;
    var cpf = document.getElementById('cpf').value;
    var cep = document.getElementById('cep').value;
    
    cepArray = cep.split("-");
    nomeArray = nome.split(" ");

    if (cepArray.length == 1) {
        msgErro = "CEP deve estar no formato (ddddd-ddd)"
    } else {
        if (/^\d+$/.test(cepArray[0]) ==false || /^\d+$/.test(cepArray[1]) == false) {
            msgErro = "CEP deve conter apenas números"
        }
    }
    
    if (/^\d+$/.test(cpf) == false) {
        msgErro = "CPF deve conter apenas números"
    }

    if (nomeArray.length < 2) {
        msgErro = "Nome completo deve conter ao menos dois termos"
    }

    alert(msgErro);
}