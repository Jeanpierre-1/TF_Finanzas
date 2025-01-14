package pe.edu.upc.aaw.tf_finanzas.servicesinterfaces;

import pe.edu.upc.aaw.tf_finanzas.entities.ValorDolar;

import java.util.List;

public interface IValorDolarService {
    public void insert(ValorDolar dolar);
    public List<ValorDolar> list();
    public void delete(int idDolar);
    public ValorDolar listarId(int idDolar);
    public Double findLastDolarValue();
}
