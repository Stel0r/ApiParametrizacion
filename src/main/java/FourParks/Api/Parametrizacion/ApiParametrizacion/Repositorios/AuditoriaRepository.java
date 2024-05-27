package FourParks.Api.Parametrizacion.ApiParametrizacion.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import FourParks.Api.Parametrizacion.ApiParametrizacion.Logica.Auditoria;


public interface AuditoriaRepository extends JpaRepository<Auditoria, Integer>{
    
}
