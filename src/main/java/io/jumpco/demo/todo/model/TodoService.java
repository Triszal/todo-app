package io.jumpco.demo.todo.model;

public interface TodoService {
    Todo create(Todo item);
    Todo update(Todo item) throws EntityNotFoundException;
    void delete(Long id);
    Todo find(Long id) throws EntityNotFoundException;

    /**
     * If completed is null all will be returned
     * @param completed
     */
    Iterable<Todo> list(Boolean completed);

    /**
     * Change status to complete
     * @param id
     * @return
     */
    Todo complete(Long id) throws EntityNotFoundException;
}
