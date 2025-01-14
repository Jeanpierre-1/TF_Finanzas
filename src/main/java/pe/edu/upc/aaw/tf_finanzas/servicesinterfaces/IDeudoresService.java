package pe.edu.upc.aaw.tf_finanzas.servicesinterfaces;

import pe.edu.upc.aaw.tf_finanzas.entities.Deudores;

import java.util.List;

public interface IDeudoresService {
    public void insert(Deudores deudores);
    public List<Deudores> vrlist();
    public void delete(int idDeudores);
    public Deudores listId(int idDeudores);
}
