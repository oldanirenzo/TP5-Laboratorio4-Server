package com.LAB4.UTN.controller;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.LAB4.UTN.entities.Instrumento;
import com.LAB4.UTN.service.InstrumentoService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })
@RequestMapping(path = "api/v1/instrumento")
public class InstrumentoController {
	InstrumentoService service;

	public InstrumentoController(InstrumentoService service) {
		super();
		this.service = service;
	}

	@GetMapping(value = "/all")
	@Transactional
	public ResponseEntity<?> getAll() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"message\": \"Error. Registro NO encontrado.\"}");
		}
	}// getAll()

	@GetMapping(value = "/find/{id}")
	@Transactional
	public ResponseEntity<?> getOne(@PathVariable int id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. NO encontrado.\"}");
		}
	}// getOne()

	@PostMapping(value = "/save")
	@Transactional
	public ResponseEntity<?> post(@RequestBody Instrumento instrumentoForm) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.save(instrumentoForm));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{\"message\": \"Error. NO encontrado. Metodo usado: save\"}");
		}
	}// save()

	@PutMapping(value = "/put/{id}")
	@Transactional
	public ResponseEntity<?> put(@PathVariable int id, @RequestBody Instrumento instrumentoForm) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.update(id, instrumentoForm));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{\"message\": \"Error. NO encontrado. Metodo usado: put\"}");
		}
	}// put()

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		boolean borrado = service.delete(id);
		if (borrado) {
			return ResponseEntity.status(204).body("'messsage': 'Eliminado'");
		} else {
			return ResponseEntity.status(400).body("'messsage': 'Error al eliminar'");
		}
	}// delete()
}
