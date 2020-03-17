package io.jumpco.demo.todo.services;

import io.jumpco.demo.todo.data.TodoRepository;
import io.jumpco.demo.todo.model.EntityNotFoundException;
import io.jumpco.demo.todo.model.Todo;
import io.jumpco.demo.todo.model.TodoService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service("todoService")
public class TodoServiceImpl implements TodoService {
    private TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo create(Todo item) {
        Assert.isNull(item.getId(), "New item cannot have id" + item);
        return todoRepository.save(item);
    }

    @Override
    public Todo update(Todo item) throws EntityNotFoundException {
        Assert.notNull(item.getId(), "Updating an item requires an id " + item);
        Optional<Todo> existing = todoRepository.findById(item.getId());
        if (!existing.isPresent()) {
            throw new EntityNotFoundException("Cannot find Todo " + item);
        }
        final Todo todo = existing.get();
        todo.setDescription(item.getDescription());
        todo.setOrder(item.getOrder());
        todo.setTitle(item.getTitle());
        return todoRepository.save(todo);
    }

    @Override
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public Iterable<Todo> list(Boolean completed) {
        Set<Boolean> options = new HashSet<>();
        if (completed == null) {
            options.add(Boolean.TRUE);
            options.add(Boolean.FALSE);
        } else {
            options.add(completed);
        }
        return todoRepository.findByCompletedInOrderByOrderAscTitleAsc(options);

    }

    @Override
    public Todo complete(Long id) throws EntityNotFoundException {
        Optional<Todo> existing = todoRepository.findById(id);

        if (!existing.isPresent()) {
            throw new EntityNotFoundException("Cannot find Todo " + id);
        }
        Assert.isTrue(!existing.get().getCompleted(), "Item was already completed");
        existing.get().setCompleted(true);
        return todoRepository.save(existing.get());
    }

    @Override
    public Todo find(Long id) throws EntityNotFoundException {
        Optional<Todo> existing = todoRepository.findById(id);
        if (!existing.isPresent()) {
            throw new EntityNotFoundException("Cannot find Todo " + id);
        }
        return existing.get();
    }
}
