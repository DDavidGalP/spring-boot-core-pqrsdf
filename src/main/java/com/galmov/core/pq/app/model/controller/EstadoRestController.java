package com.galmov.core.pq.app.model.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galmov.core.pq.app.model.entity.Estado;
import com.galmov.core.pq.app.model.service.IEstadoService;

@CrossOrigin(origins= {"http://localhost:4200/"})
@RestController
@RequestMapping("/api")
public class EstadoRestController {


	@Autowired
	private IEstadoService estadoService;
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/estados")
	public List<Estado> index() {
		return estadoService.findAll();
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/estados/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Estado estado = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			estado = estadoService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(estado == null) {
			response.put("mensaje", "la estado ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Estado>(estado, HttpStatus.OK);
	}
	

	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@PostMapping("/estados")
	public ResponseEntity<?> create(@Valid @RequestBody Estado estado, BindingResult result) {
		
		Estado estadoNew = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			estadoNew = estadoService.save(estado);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La estado ha sido creado con éxito!");
		response.put("estado ", estadoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	

	@PutMapping("/estados/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Estado estado, BindingResult result, @PathVariable Long id) {

		Estado estadoActual = estadoService.findById(id);

		Estado estadoUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (estadoActual == null) {
			response.put("mensaje", "Error: no se pudo editar, la estado con ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			
			estadoActual.setNombre(estado.getNombre());
			
			estadoUpdated = estadoService.save(estadoActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la estado en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La estado ha sido actualizado con éxito!");
		response.put("estado", estadoUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	

	@DeleteMapping("/estados/{id}")
	public ResponseEntity<?>delete(@PathVariable Long id)
	 {
		Map<String, Object> response = new HashMap<>();
		try {
			estadoService.delete(id);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la estado en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
		
		response.put("mensaje", "la estado ha sido eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	
	}

}
