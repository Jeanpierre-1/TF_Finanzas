package pe.edu.upc.aaw.tf_finanzas.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.tf_finanzas.entities.Bancos;
import pe.edu.upc.aaw.tf_finanzas.repositories.IBancosRepository;
import pe.edu.upc.aaw.tf_finanzas.servicesinterfaces.IBancosService;

import java.util.List;

@Service
public class BancosServiceImpl implements IBancosService {
    @Autowired
    private IBancosRepository vbR;


    @Override
    public void insert(Bancos bancos) {
        vbR.save(bancos);
    }

    @Override
    public List<Bancos> vrlist() {
        return vbR.findAll();
    }

    @Override
    public void delete(int idBancos) {
        vbR.deleteById(idBancos);
    }

    @Override
    public Bancos listId(int idBancos) {
        return vbR.findById(idBancos).orElse(new Bancos());
    }
}
