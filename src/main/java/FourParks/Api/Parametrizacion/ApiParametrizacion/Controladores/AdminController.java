package FourParks.Api.Parametrizacion.ApiParametrizacion.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import FourParks.Api.Parametrizacion.ApiParametrizacion.Repositorios.AuditoriaRepository; // Import the AuditoriaRepository class
import FourParks.Api.Parametrizacion.ApiParametrizacion.Logica.Auditoria; // Import the Auditoria class

@RestController
@CrossOrigin
@RequestMapping("/administrador")
public class AdminController {
    @Autowired
    public AuditoriaRepository auditoriaRepository; // Declare the auditoriaRepository variable

    @GetMapping("/auditoria")
    public ResponseEntity<List<Auditoria>>  getAdmin() {
        return ResponseEntity.ok().body(auditoriaRepository.findAll());
    }
}
