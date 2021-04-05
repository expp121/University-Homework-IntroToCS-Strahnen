package objvector;

public abstract class OrderedObject {
	
	public abstract boolean equals(Object cmp);
	public abstract boolean lessThan(OrderedObject cmp);
	public abstract String toString();
	
}