package io.altar.jseproject.repositories;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import io.altar.jseproject.model.Entity;

public abstract class EntityRepository<T extends Entity> {

	private Map<Long, T> map = new LinkedHashMap<Long, T>();
	private long actualId = 0;


	private long nextId(){
		return actualId + 1;
	}

	public long CreateEntities(T ent) {
		long newId = nextId();
		ent.setId(newId);
		map.put(ent.getId(), ent);
		return newId;
	}
	public Collection<T> ConsultEntities() {
		return map.values();	
	}
	public T ConsultEntityById(Long id){
		return map.get(id);
	}
	public void EditEntityById(T ent){
		map.replace(ent.getId(),ent);
	}
	public void RemoveEntityById(Long id){
		map.remove(id);
	}


}
