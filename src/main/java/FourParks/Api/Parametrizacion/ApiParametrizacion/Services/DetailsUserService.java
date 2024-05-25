package FourParks.Api.Parametrizacion.ApiParametrizacion.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import FourParks.Api.Parametrizacion.ApiParametrizacion.Repositorios.UsuarioRepository;


@Service
public class DetailsUserService implements UserDetailsService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findById(username).orElseThrow();
    }
    
}
