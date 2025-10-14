package com.iess.ejerciciopractico.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.iess.ejerciciopractico.Excepciones.FechaExcepcion;
import com.iess.ejerciciopractico.Services.MovimientosService;
import com.iess.ejerciciopractico.modelsDTO.ReporteMovimientosDTO;

@RestController
public class F4Controller {

    @Autowired
    private MovimientosService movimientosService;

    @GetMapping(value = "/reporte")
    public Map<String, Object> obtenerMovimientos(@RequestParam String fechaInicio, @RequestParam String fechaFin) {
        Map<String, Object> response = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd")
            .withResolverStyle(ResolverStyle.STRICT);

        try{
            LocalDate inicio = LocalDate.parse(fechaInicio, formatter);
            LocalDate fin = LocalDate.parse(fechaFin, formatter);
            List<ReporteMovimientosDTO> movimientos = movimientosService.obtenerMovimientos(inicio, fin);
            response.put("mensaje", "Movimiento Generado");
            response.put("datos", movimientos);
            response.put("codigo", 200);
        } catch (FechaExcepcion e) {
            response.put("mensaje", "Error: " + e.getMessage());
            response.put("codigo", 400);
        } catch (MethodArgumentTypeMismatchException e) {
            response.put("mensaje", "Las fechas deben estar en este formato (YYYY-MM-DD)");
            response.put("codigo", 500);
        } catch (Exception e) {
            response.put("mensaje", "Error inesperado al eliminar el cliente");
            response.put("codigo", 500);
        }
        return response;
    }
}
