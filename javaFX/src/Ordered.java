public interface Ordered {
    // compareTo returns 1, 0, -1 // if "this" is greater than, // equal to, or less than "other"
    int compareTo(Ordered other);
}