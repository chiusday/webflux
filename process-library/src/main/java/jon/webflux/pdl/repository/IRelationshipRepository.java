package jon.webflux.pdl.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import jon.webflux.pdl.model.ProcessRelationship;

public interface IRelationshipRepository 
		extends ReactiveMongoRepository<ProcessRelationship, String> {

}
