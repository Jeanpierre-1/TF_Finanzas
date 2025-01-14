package pe.edu.upc.aaw.tf_finanzas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.tf_finanzas.entities.ValorDolar;


@Repository
public interface IValorDolarRepository extends JpaRepository<ValorDolar, Integer> {
    @Query("SELECT v.valor_dolar FROM ValorDolar v ORDER BY v.id DESC LIMIT 1")
    Double findLastDolarValue();
}
