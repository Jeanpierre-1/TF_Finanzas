package pe.edu.upc.aaw.tf_finanzas.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.aaw.tf_finanzas.entities.Documentos;

import java.util.List;

public interface IDocumentosService {
    public void insert(Documentos documentos);
    public List<Documentos> vrlist();
    public void delete(int idDocumentos);
    public Documentos listId(int idDocumentos);
    List<Documentos> findDocumentosByIdCartera(int idCartera);
}
