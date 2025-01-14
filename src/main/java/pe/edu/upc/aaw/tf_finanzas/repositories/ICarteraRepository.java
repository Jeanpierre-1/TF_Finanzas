package pe.edu.upc.aaw.tf_finanzas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.tf_finanzas.entities.Cartera;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ICarteraRepository extends JpaRepository<Cartera, Integer> {
    @Query("SELECT c FROM Cartera c WHERE c.usuarios.id = :idUsuario")
    List<Cartera> findCarteraByIdUser(@Param("idUsuario") long idUsuario);

    @Query(value = "SELECT c.fecha_descuento AS diasCartera " +
            "FROM Cartera c " +
            "WHERE c.id = :idCartera")
    List<LocalDate> getDiasCarteraById(@Param("idCartera") int idCartera);
}
