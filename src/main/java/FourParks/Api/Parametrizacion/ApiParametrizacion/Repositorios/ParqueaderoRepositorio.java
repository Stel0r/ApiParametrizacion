package FourParks.Api.Parametrizacion.ApiParametrizacion.Repositorios;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import FourParks.Api.Parametrizacion.ApiParametrizacion.Logica.Parqueadero;

@Repository
public interface ParqueaderoRepositorio extends CrudRepository<Parqueadero,String>{    
    public List<Parqueadero> findBycodCiudad(String ciudad);


    @Procedure("actualizar_parqueadero")
    public void actualizarParqueadero(
        String direccion,
        String codTarifa,
        String nombre,
        String i24Hrs,
        String horaCierre,
        double latitud,
        String horaApertura,
        double longitud,
        String codGerente,
        String tipoParqueadero,
        String codParqueadero,
        String iFidelizacion,
        String ciudad,
        String iEstado,
        int numPuestos,
        double tarifaMoto,
        double tarifaCarro,
        double tarifaExtraCarro,
        double tarifaExtraMoto
    );
}