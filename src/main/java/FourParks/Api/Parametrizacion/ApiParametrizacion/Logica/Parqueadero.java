package FourParks.Api.Parametrizacion.ApiParametrizacion.Logica;

import java.time.LocalTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Parqueadero")
public class Parqueadero {

    @Id
    @Column(name="K_COD_PARQUEADERO")
    public String codParqueadero;
    @Column(name="N_NOMBRE")
    public String nombre;
    @Column(name="I_ESTADO")
    public String iEstado;
    @Column(name="I_24Hrs")
    public String i24Hrs;
    @Column(name="F_HORA_APERTURA")
    public LocalTime horaApertura;
    @Column(name="F_HORA_CIERRE")
    public LocalTime horaCierre;
    @Column(name="I_FIDELIZACION")
    public String iFidelizacion;
    @Column(name="O_DIRECCION")
    public String direccion;
    @Column(name="O_LATITUD")
    public float latitud;
    @Column(name="O_LONGITUD")
    public float longitud;
    @Column(name="K_COD_GERENTE")
    public String codGerente;
    @Column(name="K_COD_TIPO_PARQ")
    public String tipoParqueadero;
    @Column(name="K_COD_CIUDAD")
    public String codCiudad;
    @Column(name="K_COD_TARIFA")
    public String codTarifa;
    @Column(name = "N_NUM_PUESTOS")
    public int numPuestos;
    
}