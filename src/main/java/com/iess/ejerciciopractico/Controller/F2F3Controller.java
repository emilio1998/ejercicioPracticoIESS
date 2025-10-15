package com.iess.ejerciciopractico.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iess.ejerciciopractico.Excepciones.FondosInsuficientesExcepcion;
import com.iess.ejerciciopractico.Models.Movimientos;
import com.iess.ejerciciopractico.Services.MovimientosService;
import com.iess.ejerciciopractico.modelsDTO.CrearMovimientoDTO;
import com.iess.ejerciciopractico.modelsDTO.ReporteMovimientosDTO;

@RestController
public class F2F3Controller {

    @Autowired
    private MovimientosService movimientosService;

    @GetMapping(value = "/obtenerMovimiento/{identificacion}")
    public ResponseEntity<List<Movimientos>> obtenerMovimiento(@PathVariable String identificacion) {
        List<Movimientos> movimientos = movimientosService.obtenerMovimiento(identificacion);
        return ResponseEntity.ok(movimientos);
    }

    @PostMapping(value = "/movimientos")
    public Map<String, Object> generarMovimiento(@RequestBody CrearMovimientoDTO movimientoDTO) {
        Map<String, Object> response = new HashMap<>();

        try{
            ReporteMovimientosDTO reporteDTO = movimientosService.generarMovimiento(movimientoDTO);
            response.put("mensaje", "Movimiento Generado");
            response.put("resultado", reporteDTO);
            response.put("codigo", 200);
        } catch (FondosInsuficientesExcepcion e) {
            response.put("mensaje", "Error: " + e.getMessage());
            response.put("codigo", 400);
        } catch (Exception e) {
            response.put("mensaje", "Error inesperado al eliminar el cliente");
            response.put("codigo", 500);
        }
        return response;
    }
}
