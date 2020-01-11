package jon.webflux.pdl.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
public class Process implements Serializable {
	private static final long serialVersionUID = 5156081098645109833L;

	@Id
	protected String id;
	protected String name;
	protected String description;
	protected String initiation;
	protected String tag;

	public Process(Process process) {
		this.id = process.id;
		this.name = process.name;
		this.description = process.description;
		this.initiation = process.initiation;
		this.tag = process.tag;
	}
}
