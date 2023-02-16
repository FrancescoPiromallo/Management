package com.myphotos.demo.controller.api;

import com.myphotos.demo.model.Watch;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.myphotos.demo.service.IPhotoService;

@RestController
public class PhotoController {

	@Autowired
	@Qualifier("mainPhotoService")
	private IPhotoService photoService;
	
	public PhotoController() {
		
	}
	
	@RequestMapping("/api/photos")
	public Iterable<Watch> getAll() {
		
		return photoService.getAll();
	}
	
	@RequestMapping("/api/photos/{id}")
	public Watch getById(@PathVariable int id) {
		
		Optional<Watch> photo = photoService.getById(id);
		
		if (photo.isEmpty()) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
		}
		
		return photo.get();
	}
}
