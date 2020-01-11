package jon.webflux.pdl.model;

import java.util.TreeSet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Work extends Process {

	private static final long serialVersionUID = -3522179352153029873L;
	private TreeSet<Step> steps = new TreeSet<>();
	
	public Work() {
		super();
	}
	
	public Work(Process process) {
		super(process);
	}
	
	public Work(Process process, TreeSet<Step> steps) {
		this(process);
		this.steps = steps;
	}
	
	public Work(Work work) {
		super(work);
		this.steps = work.getSteps();
	}
	
}

