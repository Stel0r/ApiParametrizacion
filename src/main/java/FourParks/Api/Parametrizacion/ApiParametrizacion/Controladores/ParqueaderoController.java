package FourParks.Api.Parametrizacion.ApiParametrizacion.Controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FourParks.Api.Parametrizacion.ApiParametrizacion.Repositorios.ParqueaderoRepositorio;

class ParqueaderoCambioInterface {
    public String direccion;
    public String codTarifa;
    public String nombre;
    public String i24Hrs;
    public String horaCierre;
    public double latitud;
    public String horaApertura;
    public double longitud;
    public String codGerente;
    public String tipoParqueadero;
    public String codParqueadero;
    public String iFidelizacion;
    public String ciudad;
    public String iEstado;
    public int numPuestos;
    public double tarifaMoto;
    public double tarifaCarro;
    public double tarifaExtraCarro;
    public double tarifaExtraMoto;
}


@RestController
@CrossOrigin
@RequestMapping("/parqueadero")
public class ParqueaderoController {

    @Autowired
    public ParqueaderoRepositorio parqueaderoRepositorio;

    @PatchMapping("actualizarParqueadero")
    public ResponseEntity<Map<String, Object>> modificarParqueadero(@RequestBody ParqueaderoCambioInterface body) {
        try {
            parqueaderoRepositorio.actualizarParqueadero(
                    body.direccion,
                    body.codTarifa,
                    body.nombre,
                    body.i24Hrs,
                    body.horaCierre,
                    body.latitud,
                    body.horaApertura,
                    body.longitud,
                    body.codGerente,
                    body.tipoParqueadero,
                    body.codParqueadero,
                    body.iFidelizacion,
                    body.ciudad,
                    body.iEstado,
                    body.numPuestos,
                    body.tarifaMoto,
                    body.tarifaCarro,
                    body.tarifaExtraCarro,
                    body.tarifaExtraMoto);
            return ResponseEntity.ok().body(Map.of("response", "Se ha actualizado Con Exito!"));
        } catch (Exception e) {
            String error = e.getMessage().split("##").length ==  0 ?"Error Desconocido, intentalo nuevamente":e.getMessage().split("##")[1];
            return ResponseEntity.badRequest().body(Map.of("response", error));
        }
    }

    @PatchMapping("actualizarParqueaderos")
    public ResponseEntity<Map<String, Object>> modificarParqueaderos(@RequestBody List<ParqueaderoCambioInterface> bodyRequest) {
        ArrayList<String> resSuccess = new ArrayList<String>() ;
        ArrayList<String> resFail = new ArrayList<String>() ;
        for(ParqueaderoCambioInterface body : bodyRequest){
            ResponseEntity<Map<String,Object>> res = modificarParqueadero(body);
            if(res.getBody().get("response").equals((String)"Se ha actualizado Con Exito!")){
                resSuccess.add(body.codParqueadero);
            }
            else{
                resFail.add(body.nombre+" - "+res.getBody().get("response"));
            }
        }
        
        return ResponseEntity.ok().body(Map.of("success", resSuccess,"fail",resFail));
    }
}
