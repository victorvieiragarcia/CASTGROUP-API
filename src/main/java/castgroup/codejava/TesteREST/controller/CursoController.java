package castgroup.codejava.TesteREST.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import castgroup.codejava.TesteREST.model.Categoria;
import castgroup.codejava.TesteREST.model.Curso;
import castgroup.codejava.TesteREST.service.CursoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CursoController {

	@Autowired
	private CursoService cursoService;

	@GetMapping("/cursos")
	public List<Curso> list() {
		return cursoService.listAll();
	}

	@GetMapping("/cursos/{codigo}")
	public ResponseEntity<Curso> get(@PathVariable Integer codigo) {
		try {
			Curso curso = cursoService.get(codigo);
			return new ResponseEntity<Curso>(curso, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/cursos")
	public ResponseEntity add(@RequestBody Curso curso) {
		try {
			List<Curso> validaCursoPorPeriodo = cursoService.buscaCursoPorPeriodo(curso.getData_inicio(),
					curso.getData_termino());
			if (!validaCursoPorPeriodo.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
						.body("Existe(m) curso(s) planejados(s) dentro do período informado.");
			}
			return new ResponseEntity<Curso>(cursoService.save(curso), HttpStatus.OK);
		} catch (NoSuchMethodError e) {
			return new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/cursos/{codigo}")
	public ResponseEntity update(@RequestBody Curso curso, @PathVariable Integer codigo) {
		try {
			cursoService.get(codigo);
			List<Curso> validaCursoPorPeriodo = cursoService.buscaCursoPorPeriodoECodigo(curso.getData_inicio(),
					curso.getData_termino(), codigo);
			if (!validaCursoPorPeriodo.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
						.body("Existe(m) curso(s) planejados(s) dentro do período informado.");
			}
			
			cursoService.save(curso);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/cursos/{codigo}")
	public ResponseEntity<?> delete(@PathVariable Integer codigo) {
		try {
			cursoService.delete(codigo);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
