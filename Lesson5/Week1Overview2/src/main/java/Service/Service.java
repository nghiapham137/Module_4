package Service;

public interface Service<T> {
    Iterable<T> findAll();
    T findById(int id);
    T save(T t);
    T delete(int id);
}
