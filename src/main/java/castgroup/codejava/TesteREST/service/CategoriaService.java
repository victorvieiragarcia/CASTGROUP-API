package castgroup.codejava.TesteREST.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import castgroup.codejava.TesteREST.model.Categoria;
import castgroup.codejava.TesteREST.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Categoria> listAll() {
		return categoriaRepository.findAll();
	}
	
	public Categoria get(Integer codigo) {
		return categoriaRepository.findById(codigo).get();
	}
	
	public void save(Categoria categoria) {
		categoriaRepository.save(categoria);
	}
	
	public void delete(Integer codigo) {
		categoriaRepository.deleteById(codigo);
	}
}
