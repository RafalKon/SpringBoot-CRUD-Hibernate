package hello.repository;

import org.springframework.data.repository.CrudRepository;

import hello.model.Groups;

public interface GroupRepository extends CrudRepository<Groups, Long> {

}
