package FourParks.Api.Parametrizacion.ApiParametrizacion.Controladores;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import FourParks.Api.Parametrizacion.ApiParametrizacion.Repositorios.AuditoriaRepository; // Import the AuditoriaRepository class
import FourParks.Api.Parametrizacion.ApiParametrizacion.Repositorios.ParqueaderoRepositorio;
import FourParks.Api.Parametrizacion.ApiParametrizacion.Logica.Auditoria; // Import the Auditoria class
import FourParks.Api.Parametrizacion.ApiParametrizacion.Logica.Parqueadero;

@RestController
@CrossOrigin
@RequestMapping("/administrador")
public class AdminController {
    @Autowired
    public AuditoriaRepository auditoriaRepository; // Declare the auditoriaRepository variable

    @Autowired
    private ParqueaderoRepositorio parqueaderoRepositorio;


    @GetMapping("/auditoria")
    public ResponseEntity<List<Auditoria>>  getAdmin() {
        return ResponseEntity.ok().body(auditoriaRepository.findAll());
    }

     @GetMapping("/estadisticas")
    public ResponseEntity<Map<String,Object>> generarReporteParqueadero(){
        try {
            Map<String,Object> res = Map.of();
            for(Parqueadero p : parqueaderoRepositorio.findAll()){
                res.put(p.codParqueadero, parqueaderoRepositorio.crearReporteParqueaderoFuturo(p.codParqueadero));
            }
            return ResponseEntity.ok().body(res);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("response",e.getMessage()));
        }
    }
}
