package pe.edu.upc.aaw.tf_finanzas.servicesinterfaces;

import pe.edu.upc.aaw.tf_finanzas.entities.Bancos;

import java.util.List;

public interface IBancosService {
    public void insert(Bancos bancos);
    public List<Bancos> vrlist();
    public void delete(int idBancos);
    public Bancos listId(int idBancos);
}
