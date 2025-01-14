package pe.edu.upc.aaw.tf_finanzas.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.tf_finanzas.entities.Cartera;
import pe.edu.upc.aaw.tf_finanzas.entities.Documentos;
import pe.edu.upc.aaw.tf_finanzas.repositories.ICarteraRepository;
import pe.edu.upc.aaw.tf_finanzas.servicesinterfaces.ICarteraService;
import pe.edu.upc.aaw.tf_finanzas.servicesinterfaces.IDocumentosService;
import pe.edu.upc.aaw.tf_finanzas.servicesinterfaces.IValorDolarService;

import java.time.LocalDate;
import java.util.List;

@Service
public class CarteraServiceImpl implements ICarteraService {
    @Autowired
    private ICarteraRepository vrCR;

    @Autowired
    private IDocumentosService documentosService;

    @Autowired
    private IValorDolarService valorDolarService;

    @Override
    public void insert(Cartera cartera) {
        vrCR.save(cartera);
    }

    @Override
    public List<Cartera> vrlist() {
        return vrCR.findAll();
    }

    @Override
    public void delete(int idCartera) {
        vrCR.deleteById(idCartera);
    }

    @Override
    public Cartera listId(int idCartera) {
        return vrCR.findById(idCartera).orElse(new Cartera());
    }

    @Override
    public List<Cartera> findCarteraByIdUser(long idUsuario) {
        return vrCR.findCarteraByIdUser(idUsuario);
    }

    @Override
    public List<LocalDate> getDiasCarteraById(int idCartera) {
        return vrCR.getDiasCarteraById(idCartera);
    }

    @Override
    public void updateCalculos(int idCartera) {
        try {
            Cartera cartera = vrCR.findById(idCartera)
                    .orElseThrow(() -> new RuntimeException("Cartera no encontrada"));
            List<Documentos> documentos = documentosService.findDocumentosByIdCartera(idCartera);
            String monedaCartera = cartera.getMoneda();
            Double valorDolar = valorDolarService.findLastDolarValue();

            double totalValorNeto = 0.0;
            double totalValorNominal = 0.0;

            for (Documentos doc : documentos) {
                int diasDescuento = doc.getDias_descuento();
                double tasaDescuento = doc.getTasa_descuento() / 100;
                double tasa_descuento_anual;

                if (diasDescuento == 360) {
                    // Si los días son 360, usar la tasa de descuento original
                    tasa_descuento_anual = tasaDescuento;
                } else {
                    // Si no, hacer el cálculo normal
                    // 1. Calcular i' (tasa efectiva)
                    double tasaDescontoPrima = tasaDescuento / (1 - tasaDescuento);

                    // 2. Calcular TEA
                    double tea = Math.pow(1 + tasaDescuento, 360.0 / diasDescuento) - 1;

                    // 3. Calcular tasa de descuento anual
                    tasa_descuento_anual = tea / (1 + tea);
                }

                // 4. Obtener valor nominal y calcular nuevo valor neto
                double valorNominal = doc.getValor_nominal();
                String monedaDoc = doc.getMoneda();

                // 5. Calcular nuevo valor neto con la tasa de descuento anual
                double nuevoValorNeto = valorNominal * (1 - tasa_descuento_anual);

                if (!monedaDoc.equals("SOLES") && !monedaDoc.equals("DOLARES")) {
                    throw new RuntimeException("Moneda inválida en documento: " + monedaDoc);
                }

                // 6. Sumar a los totales según la moneda
                if (monedaCartera.equals(monedaDoc)) {
                    totalValorNeto += nuevoValorNeto;
                    totalValorNominal += valorNominal;
                } else {
                    if (monedaCartera.equals("SOLES")) {
                        totalValorNeto += nuevoValorNeto * valorDolar;
                        totalValorNominal += valorNominal * valorDolar;
                    } else {
                        totalValorNeto += nuevoValorNeto / valorDolar;
                        totalValorNominal += valorNominal / valorDolar;
                    }
                }
            }

            double tcea = 0.0;
            if (totalValorNominal != 0) {
                tcea = (totalValorNeto / totalValorNominal) - 1;
                tcea = tcea * 100; // Convertir a porcentaje
            }

            cartera.setTotal_valor_neto(totalValorNeto);
            cartera.setTotal_valor_nominal(totalValorNominal);
            cartera.setTcea(tcea);
            vrCR.save(cartera);

        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar los cálculos: " + e.getMessage());
        }
    }

}
