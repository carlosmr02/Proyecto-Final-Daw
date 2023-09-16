// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargaAlquileres();
  $('#alquileres').DataTable();
});

async function cargaAlquileres(){

  const request = await fetch('api/alquileres', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  const alquileres = await request.json();
  let listadoHTML='';
  for (let alquiler of alquileres){

    let alquilerHTML= '<tr><td>'+alquiler.id+
                     '<td>'+alquiler.usuario.email+
                     '</td><td>'+alquiler.patinete.marca+ ' ' +alquiler.patinete.modelo+
                     '</td><td>'+alquiler.fecha_inicio+
                     '</td><td>'+alquiler.fecha_fin+'</td><tr>';
    listadoHTML+=alquilerHTML;
  }
  console.log(alquileres);

  document.querySelector('#alquileres tbody').outerHTML=listadoHTML;
}

