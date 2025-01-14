package pe.edu.upc.aaw.tf_finanzas.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.tf_finanzas.entities.ValorDolar;
import pe.edu.upc.aaw.tf_finanzas.repositories.IValorDolarRepository;
import pe.edu.upc.aaw.tf_finanzas.servicesinterfaces.IValorDolarService;

import java.util.List;

@Service
public class ValorDolarServiceImpl implements IValorDolarService {
    @Autowired
    private IValorDolarRepository vdR;


    @Override
    public void insert(ValorDolar dolar) {
        vdR.save(dolar);
    }

    @Override
    public List<ValorDolar> list() {
        return vdR.findAll();
    }

    @Override
    public void delete(int idDolar) {
        vdR.deleteById(idDolar);
    }

    @Override
    public ValorDolar listarId(int idDolar) {
        return vdR.findById(idDolar).orElse(new ValorDolar());
    }

    @Override
    public Double findLastDolarValue() {
        return vdR.findLastDolarValue();
    }
}
