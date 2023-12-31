// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargaUsuarios();
  $('#usuarios').DataTable();
});

async function cargaUsuarios(){
  const request = await fetch('api/usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  const usuarios = await request.json();
  let listadoHTML='';
  for (let usuario of usuarios){
    let botonEliminar ='<a href="#" onclick="eliminarUsuario('+usuario.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>'

    let telefonoTexto = usuario.telefono == null ? '-' : usuario.telefono;
    let usuarioHTML= '<tr><td>'+usuario.id+
                     '<td>'+usuario.nombre+ ' ' +usuario.apellidos+
                     '</td><td>'+usuario.email+
                     '</td><td>'+telefonoTexto+
                     '</td><td>'+botonEliminar+'</td><tr>';
    listadoHTML+=usuarioHTML;
  }
  console.log(usuarios);

  document.querySelector('#usuarios tbody').outerHTML=listadoHTML;
}

async function eliminarUsuario(id){
    if (!confirm('¿Desea borrar el usuario?')){
        return;
    }
    alert(' voy a eliminar el usuario '+id);
    const request = await fetch('api/eliminar/'+id, {
        method: 'DELETE',
        headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
        }
    });
    location.reload();
}
