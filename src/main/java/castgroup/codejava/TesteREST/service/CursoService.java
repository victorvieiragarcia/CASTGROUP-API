package castgroup.codejava.TesteREST.service;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import castgroup.codejava.TesteREST.model.Curso;
import castgroup.codejava.TesteREST.repository.CursoRepository;

@Service
public class CursoService {
	@Autowired
	private CursoRepository cursoRepository;

	public List<Curso> listAll() {
		return cursoRepository.findAll();
	}
	
	public Curso get(Integer codigo) {
		return cursoRepository.findById(codigo).get();
	}
	
	public Curso save(Curso curso) {
		return cursoRepository.save(curso);
	}
	
	public void delete(Integer codigo) {
		cursoRepository.deleteById(codigo);
	}
	
	public List<Curso> buscaCursoPorPeriodo(Date data_inicio, Date data_termino) {
		return cursoRepository.buscaCursoPorPeriodo(data_inicio, data_termino);
	}
	
	public List<Curso> buscaCursoPorPeriodoECodigo(Date data_inicio, Date data_termino, Integer codigo) {
		return cursoRepository.buscaCursoPorPeriodoECodigo(data_inicio, data_termino, codigo);
	}
}
