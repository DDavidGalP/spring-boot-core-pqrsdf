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

import com.galmov.core.pq.app.model.entity.TipoSolicitud;
import com.galmov.core.pq.app.model.service.ITipoSolicitudService;

@CrossOrigin(origins= {"http://localhost:4200/"})
@RestController
@RequestMapping("/api")
public class TipoSolicitudRestController {

	@Autowired
	private ITipoSolicitudService tipoSolicitudService;
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/tipos")
	public List<TipoSolicitud> index() {
		return tipoSolicitudService.findAll();
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/tipos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		TipoSolicitud tipoSolicitud = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			tipoSolicitud =tipoSolicitudService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(tipoSolicitud == null) {
			response.put("mensaje", "la tipoSolicitud ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<TipoSolicitud>(tipoSolicitud, HttpStatus.OK);
	}
	

	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@PostMapping("/tipos")
	public ResponseEntity<?> create(@Valid @RequestBody TipoSolicitud tipoSolicitud, BindingResult result) {
		
		TipoSolicitud tipoSolicitudNew = null;
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
			tipoSolicitudNew = tipoSolicitudService.save(tipoSolicitud);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La estado ha sido creado con éxito!");
		response.put("tipoSolicitud ", tipoSolicitudNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	

	@PutMapping("/tipos/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody TipoSolicitud tipoSolicitud, BindingResult result, @PathVariable Long id) {

		TipoSolicitud tipoSolicitudActual = tipoSolicitudService.findById(id);

		TipoSolicitud tipoSolicitudUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (tipoSolicitudActual == null) {
			response.put("mensaje", "Error: no se pudo editar, la tipoSolicitud con ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			
			tipoSolicitudActual.setNombre(tipoSolicitud.getNombre());
			
			tipoSolicitudUpdated = tipoSolicitudService.save(tipoSolicitudActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la estado en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La estado ha sido actualizado con éxito!");
		response.put("tipoSolicitud",tipoSolicitudUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	

	@DeleteMapping("/tipos/{id}")
	public ResponseEntity<?>delete(@PathVariable Long id)
	 {
		Map<String, Object> response = new HashMap<>();
		try {
			tipoSolicitudService.delete(id);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la tipoSolicitud en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
		
		response.put("mensaje", "la tipoSolicitud ha sido eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	
	}

}