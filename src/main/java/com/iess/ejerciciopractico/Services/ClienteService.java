package com.iess.ejerciciopractico.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iess.ejerciciopractico.Excepciones.FormatoNumericoExcepcion;
import com.iess.ejerciciopractico.Models.Cliente;
import com.iess.ejerciciopractico.Repo.ClienteRepo;
import com.iess.ejerciciopractico.modelsDTO.CrearClienteDTO;
import com.iess.ejerciciopractico.modelsDTO.EditarClienteDTO;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepo clienteRepo;

    public Cliente obtenerCliente(String identificacion) {
        return clienteRepo.findByIdentificacion(identificacion)
            .orElseThrow(() -> new RuntimeException("No encontrada"));
    }

    public Cliente crearCliente(CrearClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();

        if(!esSoloNumerosYLongitudValida(clienteDTO.getIdentificacion()))
            throw new FormatoNumericoExcepcion("La cédula debe tener 10 dígitos y no puede tener otro caracter más que números");

        if(!esSoloNumerosYLongitudValida(clienteDTO.getTelefono()))
            throw new FormatoNumericoExcepcion("El número de teléfono debe tener 10 dígitos y no puede tener otro caracter más que números");

        cliente.setIdentificacion(clienteDTO.getIdentificacion());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setGenero(clienteDTO.getGenero());
        cliente.setEdad(clienteDTO.getEdad());
        cliente.setDireccion(clienteDTO.getDireccion());
        cliente.setTelefono(clienteDTO.getTelefono());
        cliente.setContrasenia(clienteDTO.getContrasenia());
        cliente.setEstado(clienteDTO.getEstado());
        return clienteRepo.save(cliente);
    }

    private static boolean esSoloNumerosYLongitudValida(String texto) {
        return texto.matches("\\d{10}");
    }

    public Cliente editarCliente(EditarClienteDTO clienteDTO, String identificacion) {
        Cliente cliente = clienteRepo.findByIdentificacion(identificacion)
            .orElseThrow(() -> new RuntimeException("No encontrada"));

            if(!esSoloNumerosYLongitudValida(clienteDTO.getTelefono()))
                throw new FormatoNumericoExcepcion("El número de teléfono debe tener 10 dígitos y no puede tener otro caracter más que números");

            cliente.setNombre(clienteDTO.getNombre());
            cliente.setGenero(clienteDTO.getGenero());
            cliente.setEdad(clienteDTO.getEdad());
            cliente.setDireccion(clienteDTO.getDireccion());
            cliente.setTelefono(clienteDTO.getTelefono());
            cliente.setContrasenia(clienteDTO.getContrasenia());
            cliente.setEstado(clienteDTO.getEstado());
        return clienteRepo.save(cliente);
    }

    public void eliminarCliente(String identificacion) {
        Cliente cliente = clienteRepo.findByIdentificacion(identificacion)
            .orElseThrow(() -> new RuntimeException("No encontrada"));
        clienteRepo.delete(cliente);
    }

    public List<Cliente> obtenerUsuarios() {
        return clienteRepo.findAll();
    }
}
