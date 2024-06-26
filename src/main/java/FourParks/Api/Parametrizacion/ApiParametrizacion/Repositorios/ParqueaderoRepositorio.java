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

    @Query(value = "select p.K_COD_PARQUEADERO as codParqueadero,count(K_COD_RESERVA) as cantReservas,p.N_NOMBRE as nombre,sum(Q_SUB_TOTAL) as total from RESERVA r ,Parqueadero p WHERE p.K_COD_PARQUEADERO = r.K_COD_PARQUEADERO and (F_FECHA_RESERVA BETWEEN CURDATE() - INTERVAL 15 DAY AND CURDATE()) and p.K_COD_GERENTE = ? GROUP BY p.K_COD_PARQUEADERO,p.N_NOMBRE",nativeQuery = true)
    public List<Map<String,Object>> crearReporteParqueaderos(String gerente);

    @Query(value = "select r.F_FECHA_RESERVA as fecha, sum(r.Q_SUB_TOTAL) total, count(r.K_COD_RESERVA) as cantReservas , COUNT(distinct K_COD_PUESTO)/p.N_NUM_PUESTOS as mayorOcupacion from RESERVA r, Parqueadero p WHERE r.F_FECHA_RESERVA BETWEEN CURDATE() - INTERVAL 15 DAY AND CURDATE() AND r.K_COD_PARQUEADERO = ? GROUP BY r.F_FECHA_RESERVA",nativeQuery = true)
    public List<Map<String,Object>> crearReporteParqueadero(String parqueadero);

    @Query(value = "select p.K_COD_PARQUEADERO as codParqueadero,count(K_COD_RESERVA) as cantReservas,p.N_NOMBRE as nombre,sum(Q_SUB_TOTAL) as total from RESERVA r ,Parqueadero p WHERE p.K_COD_PARQUEADERO = r.K_COD_PARQUEADERO and (F_FECHA_RESERVA BETWEEN  CURDATE() AND CURDATE() + INTERVAL 15 DAY) GROUP BY p.K_COD_PARQUEADERO,p.N_NOMBRE",nativeQuery = true)
    public List<Map<String,Object>> crearReporteParqueaderoFuturo();
}