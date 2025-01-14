package pe.edu.upc.aaw.tf_finanzas.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.tf_finanzas.entities.Role;
import pe.edu.upc.aaw.tf_finanzas.repositories.IRoleRepository;
import pe.edu.upc.aaw.tf_finanzas.servicesinterfaces.IRoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleRepository rR;

    @Override
    public void insert(Role rol) {
        rR.save(rol);
    }

    @Override
    public List<Role> list() {
        return rR.findAll();
    }

    @Override
    public void delete(Long idRol) {
        rR.deleteById(idRol);
    }

    @Override
    public Role listarId(Long idRol) {
        return rR.findById(idRol).orElse(new Role());
    }
}