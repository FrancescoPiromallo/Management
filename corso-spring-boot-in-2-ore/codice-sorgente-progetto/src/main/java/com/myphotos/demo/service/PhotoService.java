package com.myphotos.demo.service;

import com.myphotos.demo.model.Watch;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PhotoService implements IPhotoService {

	private List<Watch> list;
	
	private int lastId;
	
	public PhotoService() {
		
		list = new ArrayList<Watch>();
		(int id, String description, int price, String serial)
		list.add(1,"")
		
		lastId = 3;
	}
	
	@Override
	public Iterable<Watch> getAll() {
		
		return list;
	}
	
	@Override
	public Optional<Watch> getById(int id) {
		
		Optional<Watch> photo = list.stream().filter(item->item.getId() == id).findFirst();
		
		return photo;
	}
	
	@Override
	public Watch create(Watch watch) {
		
		lastId++;
		
		watch.setId(lastId);
		
		list.add(watch);
		
		return watch;
	}
	
	@Override
	public Optional<Watch> update(int id, Watch watch) {
		
		Optional<Watch> foundPhoto = list.stream().filter(item->item.getId() == id).findFirst();
		
		if (foundPhoto.isEmpty()) {
			
			return Optional.empty();
		}
		
		foundPhoto.get().setDescription(watch.getDescription());
		
		return foundPhoto;
	}
	
	@Override
	public Boolean delete(int id) {
		
		Optional<Watch> foundPhoto = list.stream().filter(item->item.getId() == id).findFirst();
		
		if (foundPhoto.isEmpty()) {

			return false;
		}
		
		list.remove(foundPhoto.get());
		
		return true;
	}
}
