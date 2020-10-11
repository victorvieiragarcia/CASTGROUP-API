package castgroup.codejava.TesteREST.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import castgroup.codejava.TesteREST.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {

	

}
