package FourParks.Api.Parametrizacion.ApiParametrizacion.Controladores;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FourParks.Api.Parametrizacion.ApiParametrizacion.Repositorios.ParqueaderoRepositorio;

@RestController
@CrossOrigin
@RequestMapping("/reportes")
public class ReportesController {

    @Autowired
    public ParqueaderoRepositorio parqueaderoRepositorio;
    
    @GetMapping("/reporteParqueaderos/{gerente}")
    public ResponseEntity<Map<String,Object>> generarReporteCiudad(@PathVariable("gerente") String gerente){
        try {
            return ResponseEntity.ok().body(parqueaderoRepositorio.crearReporteParqueaderos(gerente));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("response",e.getMessage()));
        }
    }

}
