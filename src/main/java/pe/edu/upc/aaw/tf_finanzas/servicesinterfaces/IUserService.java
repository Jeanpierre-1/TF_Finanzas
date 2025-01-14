package pe.edu.upc.aaw.tf_finanzas.servicesinterfaces;

import pe.edu.upc.aaw.tf_finanzas.entities.Users;

import java.util.List;

public interface IUserService {
    public void insert(Users usuario);

    public List<Users> list();

    public void delete(Long idUsuario);

    public Users listarId(Long idUsuario);

    List<Users> buscarUsername(String username);
}
