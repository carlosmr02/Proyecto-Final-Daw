// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargaPatinetes();
  $('#patinetes').DataTable();
});

async function cargaPatinetes(){
  const request = await fetch('api/patinetes', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  const patinetes = await request.json();
  let listadoHTML='';
  for (let patinete of patinetes){

    let patineteHTML= '<tr><td>'+patinete.id+
                     '<td>'+patinete.marca+
                     '</td><td>'+patinete.modelo+'</td><td>'+patinete.autonomia+ ' km' +'</td><tr>';
    listadoHTML+=patineteHTML;
  }
  console.log(patinetes);

  document.querySelector('#patinetes tbody').outerHTML=listadoHTML;
}

