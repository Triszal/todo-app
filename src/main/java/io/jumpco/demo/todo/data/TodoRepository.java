package io.jumpco.demo.todo.data;

import io.jumpco.demo.todo.model.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface TodoRepository extends CrudRepository<Todo, Long> {
    Iterable<Todo> findByCompletedInOrderByOrderAscTitleAsc(Collection<Boolean> completed);
}
