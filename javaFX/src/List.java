/*public class List {

    private ListElement first;

    public List() {
        this.first = null;
    }

    public void insert(Comparable obj) {
        if (first == null) first = new ListElement(obj);
        else {
            ListElement temp = first;
            while (temp != null) {

                if (temp.getData().CompareTo(obj) < 0) {
                    if (temp.getNext() == null) {
                        temp.setNext(new ListElement(obj));
                        temp.getNext().setPrior(temp);
                        break;
                    } else {
                        if (temp.getNext().getData().CompareTo(obj) >= 0) {
                            temp.getNext().setPrior(new ListElement(obj));
                            temp.getNext().getPrior().setPrior(temp);
                            temp.getNext().getPrior().setNext(temp.getNext());
                            temp.setNext(temp.getNext().getPrior());
                        }
                    }
                } else {
                    if (temp.getPrior() == null) {
                        temp.setPrior(new ListElement(obj));
                        temp.getPrior().setNext(temp);
                        first = temp.getPrior();
                        break;
                    }
                }
                temp = temp.getNext();
            }
        }
    }
}

class ListElement {

    private Comparable data;
    private ListElement next;
    private ListElement prior;

    public ListElement(Comparable obj) {
        this.data = obj;
    }

    public Comparable getData() {
        return data;
    }

    public void setData(Comparable data) {
        this.data = data;
    }

    public ListElement getNext() {
        return this.next;
    }

    public void setNext(ListElement next) {
        this.next = next;
    }

    public ListElement getPrior() {
        return this.prior;
    }

    public void setPrior(ListElement prior) {
        this.prior = prior;
    }
}

*/

public class List {

    private ListElement first;

    public List() {
        this.first = null;
    }

    public int elementCount() {
        if (first == null) return 0;

        int elements = 0;
        for (ListElement l = first; l != null; l = l.next)
            elements++;

        return elements;
    }

    public void deleteFirst() throws ListError {
        if (first == null) throw new ListError();
        if (first.next == null) first = null;
        else {
            first = first.next;
            first.prior = null;
        }
    }

    public void insert(Ordered obj) {
        if (this.first == null) first = new ListElement(obj);
        else {
            for (ListElement l = first; l != null; l = l.next) {

                if (l.data.compareTo(obj) < 0) {
                    if (l.next == null) {
                        l.next = new ListElement(obj);
                        l.next.prior = l;
                    } else {
                        if (l.next.data.compareTo(obj) >= 0) {
                            ListElement temp = new ListElement(obj);
                            temp.prior = l;
                            temp.next = l.next;
                            l.next.prior = temp;
                            l.next = temp;
                        }
                    }
                } else {
                    if (first.prior == null && first.data.compareTo(obj) >=0) {
                        first.prior = new ListElement(obj);
                        first.prior.next = first;
                        first = first.prior;
                    }
                }


            }

        }
    }

    public void printElements(){
        for (ListElement l = first; l != null; l = l.next) {
            Terminal.put(l.data.toString());
        }
    }

    private class ListElement {

        private Ordered data;
        private ListElement prior;
        private ListElement next;

        public ListElement(Ordered obj) {
            this.data = obj;
            this.prior = null;
            this.next = null;
        }
    }
}