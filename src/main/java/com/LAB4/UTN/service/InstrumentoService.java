package com.LAB4.UTN.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.LAB4.UTN.entities.Instrumento;
import com.LAB4.UTN.repositories.InstrumentoRepository;

@Service
public class InstrumentoService {
	private InstrumentoRepository repository;
	
	public InstrumentoService(InstrumentoRepository repository) {
		super();
		this.repository = repository;
	}

	@Transactional
	public List<Instrumento> findAll() throws Exception {
		try {
			List<Instrumento> entities = repository.findAll();
			return entities;
		} catch (Exception e) {

			throw new Exception();
		}
	}// findAll()

	@Transactional
	public Instrumento findById(int id) throws Exception {
		try {
			Optional<Instrumento> varOptional = repository.findById(id);
			Instrumento entity = varOptional.get();

			return entity;
		} catch (Exception e) {
			throw new Exception();
		}
	}// findById()

	@Transactional
	public Instrumento save(Instrumento instrumentoForm) throws Exception {

		Instrumento entity = new Instrumento();
		try {
			entity = repository.save(instrumentoForm);
			return entity;
		} catch (Exception e) {
			throw new Exception();
		}
	}// save()

	@Transactional
	public Instrumento update(int id, Instrumento instrumentoForm) throws Exception {

		Optional<Instrumento> entityOptional = repository.findById(id);
		Instrumento temp = new Instrumento();

		try {
			temp = entityOptional.get();
			repository.save(instrumentoForm);
			return temp;
		} catch (Exception e) {
			throw new Exception();
		}

	}// update()

	public boolean delete(int id) {
		try {
			repository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}

	} // delete()

}
