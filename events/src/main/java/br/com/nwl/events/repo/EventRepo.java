package br.com.nwl.events.repo;

import org.springframework.data.repository.CrudRepository;

import br.com.nwl.events.model.Event;

public interface EventRepo extends CrudRepository<Event, Integer>{
	public Event findByPrettyName(String prettyName);
}
