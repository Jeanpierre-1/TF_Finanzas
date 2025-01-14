package pe.edu.upc.aaw.tf_finanzas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.tf_finanzas.entities.Documentos;

import java.util.List;

@Repository
public interface IDocumentosRepository extends JpaRepository<Documentos, Integer> {
    @Query("SELECT d FROM Documentos d WHERE d.cartera.id = :idCartera")
    List<Documentos> findDocumentosByIdCartera(@Param("idCartera") int idCartera);
}
