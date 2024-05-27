package FourParks.Api.Parametrizacion.ApiParametrizacion.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import FourParks.Api.Parametrizacion.ApiParametrizacion.Logica.Auditoria;
import FourParks.Api.Parametrizacion.ApiParametrizacion.Repositorios.AuditoriaRepository;

@Service
public class AuditoriaService {

    //importar el repositorio de auditoria
    @Autowired
    private AuditoriaRepository auditoriaRepository;


    
    public void registrar(String accion, String elemento,String ip){
        Auditoria auditoria = new Auditoria();
        auditoria.usuario = SecurityContextHolder.getContext().getAuthentication().getName();
        auditoria.tipo_cambio = accion;
        auditoria.elemento_cambiado = elemento;
        auditoria.direccionIP = ip;
        auditoriaRepository.save(auditoria);
    }

}
