package io.altar.jseproject.repositories;

import java.util.Collection;
//import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import io.altar.jseproject.model.Entity;

public abstract class EntityRepository<T extends Entity> {

	private Map<Long, T> map = new LinkedHashMap<Long, T>();
	private long actualId = 0;


	private long nextId(){
		return actualId ++;
	}

	public long CreateEntities(T ent) {
		long newId = nextId();
		ent.setId(newId);
		map.put(ent.getId(), ent);
		return newId;
	}
	//public Iterator<T> ConsultEntities2() {
		//return map.values().iterator();	
	//}
	public Collection<T> ConsultEntities() {
		return map.values();	
	}
	public T ConsultEntityById(Long id){
		return map.get(id);
	}
	public void EditEntityById(long id, T ent){
		map.replace(id,ent);
	}
	public void RemoveEntityById(Long id){
		map.remove(id);
	}

}
