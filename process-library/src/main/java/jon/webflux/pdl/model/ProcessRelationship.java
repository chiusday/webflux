package jon.webflux.pdl.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
public class ProcessRelationship implements Serializable {
	private static final long serialVersionUID = -7097711727490129746L;

	@Id
	private String id;
	private String parentId;
	private String childId;
	private int sequence;
	private String relationshipType;
}
