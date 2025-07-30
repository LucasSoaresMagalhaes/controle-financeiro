async function listar() {
  const res = await fetch('/api/transacoes');
  const transacoes = await res.json();
  // renderize na tabela...
}

async function adicionar() {
  const payload = {
    tipo: document.getElementById('tipo').value,
    valor: parseFloat(document.getElementById('valor').value),
    descricao: document.getElementById('descricao').value,
    data: document.getElementById('data').value
  };
  await fetch('/api/transacoes', {
    method: 'POST',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(payload)
  });
  listar();
}

document.getElementById('form').addEventListener('submit', e => {
  e.preventDefault();
  adicionar();
});
