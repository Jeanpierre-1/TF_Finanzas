package pe.edu.upc.aaw.tf_finanzas.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.tf_finanzas.entities.Users;
import pe.edu.upc.aaw.tf_finanzas.repositories.IUserRepository;
import pe.edu.upc.aaw.tf_finanzas.servicesinterfaces.IUserService;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository uR;

    @Override
    public void insert(Users usuario) {
        uR.save(usuario);
    }

    @Override
    public List<Users> list() {
        return uR.findAll();
    }

    @Override
    public void delete(Long idUsuario) {
        uR.deleteById(idUsuario);
    }

    @Override
    public Users listarId(Long idUsuario) {
        return uR.findById(idUsuario).orElse(new Users());
    }

    @Override
    public List<Users> buscarUsername(String username) {
        return uR.buscarUsername(username);
    }
}
