package pe.edu.upc.aaw.tf_finanzas.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.tf_finanzas.entities.Deudores;
import pe.edu.upc.aaw.tf_finanzas.repositories.IDeudoresRepository;
import pe.edu.upc.aaw.tf_finanzas.servicesinterfaces.IDeudoresService;

import java.util.List;

@Service
public class DeudoresServiceImpl implements IDeudoresService {
    @Autowired
    private IDeudoresRepository vrdR;


    @Override
    public void insert(Deudores deudores) {
        vrdR.save(deudores);
    }

    @Override
    public List<Deudores> vrlist() {
        return vrdR.findAll();
    }

    @Override
    public void delete(int idDeudores) {
        vrdR.deleteById(idDeudores);
    }

    @Override
    public Deudores listId(int idDeudores) {
        return vrdR.findById(idDeudores).orElse(new Deudores());
    }
}
