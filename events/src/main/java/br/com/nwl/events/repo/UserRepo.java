package br.com.nwl.events.repo;

import org.springframework.data.repository.CrudRepository;

import br.com.nwl.events.model.User;

public interface UserRepo extends CrudRepository<User, Integer> {
    public User findByEmail(String email);  
}
