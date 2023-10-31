package web.technologies.lab04.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import web.technologies.lab04.model.Item;

@Service
public class ToDoService {

    private final Map<Long, Item> todos = new ConcurrentHashMap<>();
    private final AtomicLong counter = new AtomicLong();

    public List<Item> findAll() {
        return new ArrayList<>(todos.values());
    }

    public Item findById(Long id) {
        return todos.get(id);
    }

    public Item save(Item todo) {
        if (todo.getId() == null) {
            todo.setId(counter.incrementAndGet());
        }
        todos.put(todo.getId(), todo);
        return todo;
    }

    public void deleteById(Long id) {
        todos.remove(id);
    }

}

