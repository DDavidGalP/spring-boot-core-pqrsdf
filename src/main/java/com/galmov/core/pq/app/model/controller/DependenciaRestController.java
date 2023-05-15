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

import com.galmov.core.pq.app.model.entity.Dependencia;
import com.galmov.core.pq.app.model.service.IDependenciaService;

@CrossOrigin(origins= {"http://localhost:4200/"})
@RestController
@RequestMapping("/api")
public class DependenciaRestController {
	
	@Autowired
	private IDependenciaService dependenciaService;
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/dependencias")
	public List<Dependencia> index() {
		return dependenciaService.findAll();
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/dependencias/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Dependencia dependencia = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			dependencia = dependenciaService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(dependencia == null) {
			response.put("mensaje", "la solicitud ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Dependencia>(dependencia, HttpStatus.OK);
	}
	

	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@PostMapping("/dependencias")
	public ResponseEntity<?> create(@Valid @RequestBody Dependencia dependencia, BindingResult result) {
		
		Dependencia dependenciaNew = null;
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
			dependenciaNew = dependenciaService.save(dependencia);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La solicitud ha sido creado con éxito!");
		response.put("dependencia ", dependenciaNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	

	@PutMapping("/dependencias/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Dependencia dependencia, BindingResult result, @PathVariable Long id) {

		Dependencia dependenciaActual = dependenciaService.findById(id);

		Dependencia dependenciaUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (dependenciaActual == null) {
			response.put("mensaje", "Error: no se pudo editar, la dependencia con ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			
			dependenciaActual.setNombre(dependencia.getNombre());
			
			dependenciaUpdated = dependenciaService.save(dependenciaActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la dependencia en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La dependencia ha sido actualizado con éxito!");
		response.put("dependencia", dependenciaUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	

	@DeleteMapping("/dependencias/{id}")
	public ResponseEntity<?>delete(@PathVariable Long id)
	 {
		Map<String, Object> response = new HashMap<>();
		try {
			dependenciaService.delete(id);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la dependencia en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
		
		response.put("mensaje", "la dependencia ha sido eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	
	}

}
