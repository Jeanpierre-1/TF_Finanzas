package pe.edu.upc.aaw.tf_finanzas.servicesinterfaces;

import pe.edu.upc.aaw.tf_finanzas.entities.Role;

import java.util.List;

public interface IRoleService {
    public void insert(Role rol);

    public List<Role> list();

    public void delete(Long idRol);

    public Role listarId(Long idRol);
}
