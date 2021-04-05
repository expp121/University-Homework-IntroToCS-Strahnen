package objvector;

public class DateException extends RuntimeException {
    private OrderedObject offender;

    public DateException(){
        super();
    } 

    public DateException(OrderedObject offender) {
        super();
        this.offender = offender;
    }

    public OrderedObject getOffender() {
        return offender;
    }
}
