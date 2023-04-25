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

import com.galmov.core.pq.app.model.entity.Seguimiento;
import com.galmov.core.pq.app.model.entity.Solicitud;
import com.galmov.core.pq.app.model.service.ISeguimientoService;
import com.galmov.core.pq.app.model.service.ISolicitudService;

@CrossOrigin(origins= {"http://localhost:4200/"})
@RestController
@RequestMapping("/api")
public class SeguimientoRestController {
	
	@Autowired
	private ISeguimientoService seguimientoService;
	
	@Autowired
	private ISolicitudService solicitudService;
	
	@GetMapping("/seguimientos")
	public List<Seguimiento> index(){
		return seguimientoService.findAll();
	}
	

	@GetMapping("/seguimientos/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Seguimiento seguimiento = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			seguimiento = seguimientoService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(seguimiento == null) {
			response.put("mensaje", "la solicitud ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Seguimiento>(seguimiento, HttpStatus.OK);
	}
	
	
	@PostMapping("/seguimientos")
	public ResponseEntity<?> create(@Valid @RequestBody Seguimiento seguimiento, BindingResult result) {
		
		Seguimiento seguimientoNew = null;
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
			seguimientoNew = seguimientoService.save(seguimiento);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "el seguimiento ha sido creado con éxito!");
		response.put("solicitud ", seguimientoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	

	@PutMapping("/seguimientos/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Seguimiento seguimiento, BindingResult result, @PathVariable Long id) {

		Seguimiento seguimientoActual = seguimientoService.findById(id);

		Seguimiento seguimientoUpdate = null;

		Map<String, Object> response = new HashMap<>();

		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (seguimientoActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el seguimiento con ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			
			seguimientoActual.setTitulo(seguimiento.getTitulo());
			seguimientoActual.setDescripcion(seguimiento.getDescripcion());
			seguimientoActual.setFechaRealizado(seguimiento.getFechaRealizado());
		
			
			seguimientoUpdate = seguimientoService.save(seguimientoActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la Solicitud en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La solicitud ha sido actualizado con éxito!");
		response.put("solicitud", seguimientoUpdate);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	

	@DeleteMapping("/seguimientos/{id}")
	public ResponseEntity<?>delete(@PathVariable Long id)
	 {
		Map<String, Object> response = new HashMap<>();
		try {
			seguimientoService.delete(id);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la solicitud en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
		
		response.put("mensaje", "El solpq ha sido eliminado con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	
	}

	/*@GetMapping("/seguimientos/solicitudes")
	public Optional<Seguimiento> findBySolicitudId(Solicitud solicitudId){
		return seguimientoService.findBySolicitudId(solicitudId);
	}
	
	@GetMapping("/seguimientos/usuarios")
	public Optional<Seguimiento> findByUsuarioId(Usuario usuarioId){
		return seguimientoService.findByUsuarioId(usuarioId);
	}*/
	
 

}
