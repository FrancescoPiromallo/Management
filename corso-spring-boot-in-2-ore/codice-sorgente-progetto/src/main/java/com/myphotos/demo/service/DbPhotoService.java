package com.myphotos.demo.service;

import com.myphotos.demo.model.Watch;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myphotos.demo.repository.IPhotoRepository;

@Service("mainPhotoService")
public class DbPhotoService implements IPhotoService {

	@Autowired
	private IPhotoRepository photoRepository;
	
	@Override
	public Iterable<Watch> getAll() {

		return photoRepository.findAll();
	}
	
	@Override
	public Optional<Watch> getById(int id) {
		
		return photoRepository.findById(id);
	}
	
	@Override
	public Watch create(Watch watch) {
		
		return photoRepository.save(watch);
	}
	
	@Override
	public Optional<Watch> update(int id, Watch watch) {
		
		Optional<Watch> foundPhoto = photoRepository.findById(id);
		
		if (foundPhoto.isEmpty()) {
			
			return Optional.empty();
		}
		
		foundPhoto.get().setDescription(watch.getDescription());
		
		photoRepository.save(foundPhoto.get());
		
		return foundPhoto;
	}
	
	@Override
	public Boolean delete(int id) {
		
		Optional<Watch> foundPhoto = photoRepository.findById(id);
		
		if (foundPhoto.isEmpty()) {
			
			return false;
		}
		
		photoRepository.delete(foundPhoto.get());
		
		return true;
	}
}
