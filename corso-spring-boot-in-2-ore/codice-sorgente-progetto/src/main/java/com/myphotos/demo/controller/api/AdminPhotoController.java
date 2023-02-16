package com.myphotos.demo.controller.api;

import com.myphotos.demo.model.Watch;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.myphotos.demo.service.IPhotoService;

@RestController
public class AdminPhotoController {

	@Autowired
	@Qualifier("mainPhotoService")
	private IPhotoService photoService;
	
	public AdminPhotoController() {
		
	}
	
	@RequestMapping("/admin/api/photos")
	public Iterable<Watch> getAll() {
		
		return photoService.getAll();
	}
	
	@RequestMapping("/admin/api/photos/{id}")
	public Watch getById(@PathVariable int id) {
		
		Optional<Watch> photo = photoService.getById(id);
		
		if (photo.isEmpty()) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
		}
		
		return photo.get();
	}
	
	@RequestMapping(value = "/admin/api/photos", method = RequestMethod.POST)
	public Watch create(@Valid @RequestBody Watch watch) {
		
		return photoService.create(watch);
	}
	
	@RequestMapping(value = "/admin/api/photos/{id}", method = RequestMethod.PUT)
	public Watch update(@PathVariable int id, @Valid @RequestBody Watch watch) {
		
		Optional<Watch> updatedPhoto = photoService.update(id, watch);
		
		if (updatedPhoto.isEmpty()) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
		}
		
		return updatedPhoto.get();
	}
	
	@RequestMapping(value = "/admin/api/photos/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		
		Boolean isDeleted = photoService.delete(id);
		
		if (isDeleted == false) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
		}
	}
}
