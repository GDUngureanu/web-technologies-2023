package web.technologies.lab05.service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import web.technologies.lab05.model.Item;

@Service
public class ToDoService {

    private final Map<Long, Item> toDoRepository = new ConcurrentHashMap<>();
    private final AtomicLong counter = new AtomicLong();

    public Item create(Item item) {
        long id = counter.incrementAndGet();
        item.setId(id);
        toDoRepository.put(id, item);
        return item;
    }

    public Item findById(Long id) {
        return toDoRepository.get(id);
    }

    public Collection<Item> findAll() {
        return toDoRepository.values();
    }

    public Item update(Long id, Item item) {
        item.setId(id);
        toDoRepository.put(id, item);
        return item;
    }

    public void delete(Long id) {
        toDoRepository.remove(id);
    }

}
