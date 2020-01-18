package jon.webflux.pdl.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import jon.webflux.pdl.model.Process;

public interface IProcessRepository extends ReactiveMongoRepository<Process, String>{

}
