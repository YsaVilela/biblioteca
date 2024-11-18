function salvarLeitor() {
  const nome = document.getElementById("nome").value;
  const email = document.getElementById("email").value;
  const telefone = document.getElementById("telefone").value;
  const dataNascimento = document.getElementById("dataNascimento").value;
  const rua = document.getElementById("rua").value;
  const bairro = document.getElementById("bairro").value;
  const numero = document.getElementById("numero").value;
  const complemento = document.getElementById("complemento").value;
  const cep = document.getElementById("cep").value;

  const leitor = {
    nome,
    email,
    telefone,
    dataNascimento,
    endereco: {
      rua,
      bairro,
      numero,
      complemento,
      cep,
    },
  };

  cadastrarLeitor(leitor);
}

// async function cadastrarLeitor(leitor) {
//     fetch(`${url}/leitor/cadastrar`, {
//       method: 'POST',
//       headers: {
//         'Content-Type': 'application/json',
//       },
//       body: JSON.stringify(leitor)
//     })
//       .then(response => response.json())
//       .then(data => {
//         console.log('Leitor salvo com sucesso:', data);
//         alert('Leitor cadastrado com sucesso!');
//       })
//       .catch(error => {
//         console.error('Erro ao salvar o leitor:', error);
//         alert('Erro ao cadastrar o leitor.');
//       });
// }

// async function cadastrarLeitor(leitor) {
//     const statusMessageElement = document.getElementById('statusMessage');

//     // Limpa a mensagem anterior
//     statusMessageElement.style.display = 'none';
//     statusMessageElement.classList.remove('alert-success', 'alert-danger');

//     try {
//       const response = await fetch(`${url}/leitor/cadastrar`, {
//         method: 'POST',
//         headers: {
//           'Content-Type': 'application/json',
//         },
//         body: JSON.stringify(leitor),
//       });

//       const data = await response.json();

//       if (response.ok) {
//         // Se a resposta for bem-sucedida
//         statusMessageElement.textContent = 'Leitor cadastrado com sucesso!';
//         statusMessageElement.classList.add('alert-success');
//         statusMessageElement.style.display = 'block';
//       } else {
//         // Se houver um erro na resposta (ex: status 400 ou 500)
//         statusMessageElement.textContent = `Erro: ${data.message || 'Erro desconhecido'}`;
//         statusMessageElement.classList.add('alert-danger');
//         statusMessageElement.style.display = 'block';
//       }
//     } catch (error) {
//       // Se ocorrer um erro na requisição
//       console.error('Erro ao salvar o leitor:', error);
//       statusMessageElement.textContent = 'Erro ao cadastrar o leitor. Tente novamente.';
//       statusMessageElement.classList.add('alert-danger');
//       statusMessageElement.style.display = 'block';
//     }
// }

async function cadastrarLeitor(leitor) {
  const toastElement = document.getElementById("toastMessage");
  const toastTitle = document.getElementById("toastTitle");
  const toastBody = document.getElementById("toastBody");

  const statusMessageElement = document.getElementById("statusMessage");
  statusMessageElement.style.display = "none";
  statusMessageElement.classList.remove("alert-success", "alert-danger");

  toastElement.style.display = "none";
  toastTitle.textContent = "";
  toastBody.textContent = "";

  try {
    const response = await fetch(`${url}/leitor/cadastrar`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(leitor),
    });

    const data = await response.json();

    console.log(data);

    if (response.ok) {
      const modal = bootstrap.Modal.getInstance(
        document.getElementById("modalCadastrarLeitor")
      );
      modal.hide();

      toastTitle.textContent = "Leitor cadastrado com sucesso!";
      toastBody.textContent = `Número da Carteirinha: ${data.id}`;
      toastElement.classList.add("toast-body");
      toastElement.style.display = "block";

      setTimeout(() => {
        toastElement.style.display = "none";
      }, 10000);
    } else {
      statusMessageElement.textContent = `Erro: ${
        data.message || "Erro desconhecido"
      }`;
      statusMessageElement.classList.add("alert-danger");
      statusMessageElement.style.display = "block";
    }
  } catch (error) {
    console.error("Erro ao salvar o leitor:", error);
    statusMessageElement.textContent =
      "Erro ao cadastrar o leitor. Tente novamente.";
    statusMessageElement.classList.add("alert-danger");
    statusMessageElement.style.display = "block";
  }
}
