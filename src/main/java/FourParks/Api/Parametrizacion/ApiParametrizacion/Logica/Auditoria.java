package FourParks.Api.Parametrizacion.ApiParametrizacion.Logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Auditoria")
public class Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    public String usuario;
    public String tipo_cambio;
    public String elemento_cambiado;
    public java.sql.Timestamp fecha;
    public String direccionIP;
}
