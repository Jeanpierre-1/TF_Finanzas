package pe.edu.upc.aaw.tf_finanzas.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.aaw.tf_finanzas.entities.Cartera;

import java.time.LocalDate;
import java.util.List;

public interface ICarteraService {
    public void insert(Cartera cartera);
    public List<Cartera> vrlist();
    public void delete(int idCartera);
    public Cartera listId(int idCartera);
    List<Cartera> findCarteraByIdUser(long idUsuario);
    List<LocalDate> getDiasCarteraById(@Param("idCartera") int idCartera);
    void updateCalculos(int idCartera);
}
