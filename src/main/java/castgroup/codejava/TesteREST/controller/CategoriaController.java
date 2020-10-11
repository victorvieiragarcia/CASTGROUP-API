package castgroup.codejava.TesteREST.controller;

import java.util.List;
import java.util.NoSuchElementException;

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
import castgroup.codejava.TesteREST.service.CategoriaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")   
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/categorias")
	public List<Categoria> list() {
		return categoriaService.listAll();
	}

	@GetMapping("/categorias/{codigo}")
	public ResponseEntity<Categoria> get(@PathVariable Integer codigo) {
		try {
			Categoria categoria = categoriaService.get(codigo);
			return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Categoria>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/categorias")
	public void add(@RequestBody Categoria categoria) {
		categoriaService.save(categoria);
	}

	@PutMapping("/categorias/{codigo}")
	public ResponseEntity<?> update(@RequestBody Categoria categoria, @PathVariable Integer codigo) {
		try {
			categoriaService.get(codigo);
			categoriaService.save(categoria);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/categorias/{codigo}")
	public ResponseEntity<?> delete(@PathVariable Integer codigo) {
		try {
			categoriaService.delete(codigo);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
