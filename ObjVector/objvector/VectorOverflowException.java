package objvector;

public class VectorOverflowException extends Exception {

	private OrderedObject offender;

	public VectorOverflowException(OrderedObject offender) {
		super();
		this.offender = offender;
	}

	public OrderedObject getOffender() {
		return offender;
	}

};