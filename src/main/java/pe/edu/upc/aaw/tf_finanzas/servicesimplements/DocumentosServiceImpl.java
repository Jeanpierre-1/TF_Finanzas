package pe.edu.upc.aaw.tf_finanzas.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.tf_finanzas.entities.Deudores;
import pe.edu.upc.aaw.tf_finanzas.entities.Documentos;
import pe.edu.upc.aaw.tf_finanzas.repositories.IDocumentosRepository;
import pe.edu.upc.aaw.tf_finanzas.servicesinterfaces.IDocumentosService;

import java.util.List;

@Service
public class DocumentosServiceImpl implements IDocumentosService {
    @Autowired
    private IDocumentosRepository vrDr;


    @Override
    public void insert(Documentos documentos) {
        vrDr.save(documentos);
    }

    @Override
    public List<Documentos> vrlist() {
        return vrDr.findAll();
    }

    @Override
    public void delete(int idDocumentos) {
        vrDr.deleteById(idDocumentos);
    }

    @Override
    public Documentos listId(int idDocumentos) {
        return vrDr.findById(idDocumentos).orElse(new Documentos());
    }

    @Override
    public List<Documentos> findDocumentosByIdCartera(int idCartera) {
        return vrDr.findDocumentosByIdCartera(idCartera);
    }
}
