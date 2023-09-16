// Call the dataTables jQuery plugin
$(document).ready(function() {
  // Lo dejo vacío
});

async function cargarUsuarios() {
  try {
    const response = await fetch('api/usuarios', {
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    });

    if (!response.ok) {
      throw new Error('Error al cargar usuarios desde la API');
    }

    const usuarios = await response.json();

    // Llena el desplegable de usuarios con los datos obtenidos
    const usuarioSelect = document.getElementById('usuario');
    usuarioSelect.innerHTML = '<option value="">Selecciona un usuario</option>';
    usuarios.forEach(usuario => {
      const option = document.createElement('option');
      option.value = usuario.id;
      option.textContent = usuario.nombre;
      usuarioSelect.appendChild(option);
    });
  } catch (error) {
    console.error(error);
  }
}

// Función para cargar patinetes desde la API
async function cargarPatinetes() {
  try {
    const response = await fetch('api/patinetes', {
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      }
    });

    if (!response.ok) {
      throw new Error('Error al cargar patinetes desde la API');
    }

    const patinetes = await response.json();

    // Llena el desplegable de patinetes con los datos obtenidos
    const patineteSelect = document.getElementById('patinete');
    patineteSelect.innerHTML = '<option value="">Selecciona un patinete</option>';
    patinetes.forEach(patinete => {
      const option = document.createElement('option');
      option.value = patinete.id;
      option.textContent = patinete.modelo;
      patineteSelect.appendChild(option);
    });
  } catch (error) {
    console.error(error);
  }
}

async function registraAlquiler(){
  console.log("Función registraAlquiler llamada");
  let datos={};
  datos.usuario_id=document.getElementById('usuario').value;
  datos.patinete_id=document.getElementById('patinete').value;
  datos.fecha_inicio=document.getElementById('txtFechaInicio').value;
  datos.fecha_fin=document.getElementById('txtFechaFin').value;

  console.log("Datos a enviar:", datos);

  const response = await fetch('api/alquileres', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body:JSON.stringify(datos)
  });
  alert(' Alquiler registrado');
}

$(document).ready(function() {
  cargarUsuarios();
  cargarPatinetes();
});