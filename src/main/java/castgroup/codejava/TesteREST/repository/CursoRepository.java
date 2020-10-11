package castgroup.codejava.TesteREST.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import castgroup.codejava.TesteREST.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

	@Query("select c from Curso c where c.data_inicio between :data_inicio and :data_termino or c.data_termino between :data_inicio and :data_termino")
    List<Curso> buscaCursoPorPeriodo(
    		@Param("data_inicio") Date data_inicio,
      @Param("data_termino") Date data_termino);
	
	@Query("select c from Curso c where c.data_inicio between :data_inicio and :data_termino and c.data_termino between :data_inicio and :data_termino and c.codigo != :codigo")
    List<Curso> buscaCursoPorPeriodoECodigo(
    		@Param("data_inicio") Date data_inicio,
      @Param("data_termino") Date data_termino,
      @Param("codigo") Integer codigo);
}
