package com.myphotos.demo.service;

import com.myphotos.demo.model.Watch;
import java.util.Optional;

public interface IPhotoService {

	public Iterable<Watch> getAll();
	
	public Optional<Watch> getById(int id);
	
	public Watch create(Watch watch);
	
	public Optional<Watch> update(int id, Watch watch);
	
	public Boolean delete(int id);
}
