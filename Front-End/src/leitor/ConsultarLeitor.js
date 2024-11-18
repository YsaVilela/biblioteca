const msgErro = document.getElementById('msg_erro');
var resultados = [];
var filtroSelecionado = '';
const nenhumResultadoEncontrado = document.createElement('li');
nenhumResultadoEncontrado.innerHTML = "Nenhum Resultado Encontrado";

function selecionarFiltro(filtro) {
    filtroSelecionado = filtro;
    document.getElementById('filtro').textContent = filtro;
    msgErro.textContent = "";       
    validarInput(); 
}

function validarInput() {
    const campo = document.getElementById('conteudo');
    
    if (filtroSelecionado == 'Carteirinha') {
      campo.setAttribute('type', 'number'); 
      campo.setAttribute('pattern', '[0-9]*'); 
      campo.setAttribute('inputmode', 'numeric'); 
    } else {
      campo.setAttribute('type', 'text');
      campo.removeAttribute('pattern');
      campo.removeAttribute('inputmode');
    }
}

async function consultarLeitor() {
    document.getElementById('resultados').innerHTML = "";
    const conteudo = document.getElementById('conteudo').value;
    const filtro = document.getElementById('filtro').textContent;

    if (filtro == "Selecione Filtro") {
        msgErro.textContent = "Selecione um filtro para realizar a busca";        
    } else if (conteudo == ""){
        msgErro.textContent = "Digite algo para realizar a busca";        
    } else {
        console.log(filtro);
        msgErro.textContent = "";
        if (filtro == "Nome") {
            resultados = await buscarLeitor("buscarNome", conteudo);
        } else if (filtro == "Carteirinha"){
            resultados = await buscarLeitor("buscarId", conteudo);
        } else if (filtro == "Email"){
            resultados = await buscarLeitor("buscarEmail", conteudo);
        }
        if (resultados.length == 0) {
            document.getElementById('resultados').appendChild(nenhumResultadoEncontrado);
        }else {            
            resultados.forEach(leitor => {
                var linhaLeitor = resultado(leitor.nome, leitor.id)
                document.getElementById('resultados').appendChild(linhaLeitor);
            });
        }
    }
}

function resultado(nome, numeroCarterinha) {
    const li = document.createElement('li');
    li.innerHTML = `
    <li">
        <div class="container-fluid d-flex align-items-center p-3">
          <div
            class="profile-icon bg-success rounded-circle d-flex justify-content-center align-items-center me-3 flex-shrink-0"
            style="width: 60px; height: 60px"
          >
            <span class="material-symbols-outlined text-white fs-4"
              >person</span
            >
          </div>
          <div class="d-flex flex-column flex-grow-1">
            <span class="fw-bold text-truncate">${nome}</span>
            <span class="text-muted text-truncate">Carteirinha: ${numeroCarterinha}</span>
          </div>
          <button type="button" class="btn flex-shrink-0 ms-3" onclick="visualizarDadosLeitor(${numeroCarterinha})">
            <span class="material-symbols-outlined fs-5">visibility</span>
          </button>
        </div>
      </li>
    `
    return li;
}

function visualizarDadosLeitor(id) {
    const leitor = resultados.find((resultado) => resultado.id == id);
    conteudoModalVisualisarLeitor(leitor);
    var myModal = new bootstrap.Modal(document.getElementById('modalDadosLeitor'));
    myModal.show(); 
}

function conteudoModalVisualisarLeitor(leitor) {
    const conteudoModalLeitor = document.getElementById('modalContent');
    conteudoModalLeitor.innerHTML = `
    <div class="container p-3">
        <div class="d-flex align-items-center mb-4">
            <div class="profile-icon bg-success rounded-circle d-flex justify-content-center align-items-center me-3 flex-shrink-0" style="width: 70px; height: 70px;">
            <span class="material-symbols-outlined text-white fs-4">person</span>
            </div>
            <div>
            <h5 class="mb-1">${leitor.nome}</h5>
            <p class="mb-1 text-muted">Email: ${leitor.email ?? ""}</p>
            <p class="mb-0 text-muted">Telefone: ${leitor.telefone ?? ""}</p>
            </div>
        </div>
  
        <div class="accordion" id="accordionExample">
            <div class="accordion-item">
                <h2 class="accordion-header" id="headingOne">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                        Endereço
                    </button>
                </h2>
            <div id="collapseOne" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                <div class="accordion-body">
                    <p><strong>Logradouro:</strong> ${leitor.endereco.rua ?? ""}</p>
                    <p><strong>Bairro:</strong> ${leitor.endereco.bairro ?? ""}</p>
                    <p><strong>Número:</strong> ${leitor.endereco.numero ?? ""}</p>
                    <p><strong>Complemento:</strong> ${leitor.endereco.complemento ?? ""}</p>
                    <p><strong>CEP:</strong> ${leitor.endereco.cep ?? ""}</p>
                </div>
            </div>
        </div>
  
        <div class="accordion-item">
            <h2 class="accordion-header" id="headingTwo">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                    Empréstimos
                </button>
            </h2>
            <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
                <div class="accordion-body">
                    <p>Vazio temporariamente</p>
                </div>
            </div>
        </div>
    </div>
    `
}

async function buscarLeitor(path, dado) {
    try {
        const response = await fetch(`${url}/leitor/${path}/${dado}`);
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        const data = await response.json();
        return data.content; 
    } catch (error) {
        console.error('Erro na requisição:', error);
        throw error; 
    }
}
