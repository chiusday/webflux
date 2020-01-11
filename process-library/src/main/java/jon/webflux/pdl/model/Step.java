package jon.webflux.pdl.model;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

/**
 *Process (as a child) + Relationship attributes. Therefore, Process that "has-a" "Relationship".
 *Represent a child Process and it's relationship with another Process (which is the parent Work).
 *But Parent Work is not reflected here, instead it is found in the Work model.
 */

@Setter
@Getter
public class Step extends Process implements Comparable<Step> {
	private static final long serialVersionUID = 2678277046697797405L;
	private ProcessRelationship relationship;
	
	public Step() {
		super();
	}
	
	public Step(int orderNumber, Process child, ProcessRelationship relationship) {
		super(child);
		this.relationship = relationship;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Step)) { return false; }
		return this.getRelationship().getId().equals
				(((Step)o).getRelationship().getId());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(relationship.getSequence());
	}

	@Override
	public int compareTo(Step o) {
		return relationship.getSequence() - o.getRelationship().getSequence();
	}
}
