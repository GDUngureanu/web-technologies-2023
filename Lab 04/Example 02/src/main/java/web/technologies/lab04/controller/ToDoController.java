package web.technologies.lab04.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.technologies.lab04.model.Item;
import web.technologies.lab04.service.ToDoService;

@Controller
@RequestMapping("/todos")
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService toDoService;

    @GetMapping
    public String listTodos(Model model) {
        model.addAttribute("todos", toDoService.findAll());
        return "todoList";
    }

    @GetMapping("/new")
    public String newTodoForm(Model model) {
        model.addAttribute("todo", new Item());
        return "todoForm";
    }

    @GetMapping("/edit/{id}")
    public String editTodoForm(@PathVariable Long id, Model model) {
        Item todo = toDoService.findById(id);
        model.addAttribute("todo", todo);
        return "todoForm";
    }

    @PostMapping("/save")
    public String saveTodo(@ModelAttribute Item todo) {
        toDoService.save(todo);
        return "redirect:/todos";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        toDoService.deleteById(id);
        return "redirect:/todos";
    }

    @GetMapping("/view/{id}")
    public String viewTodo(@PathVariable Long id, Model model) {
        Item todo = toDoService.findById(id);
        model.addAttribute("todo", todo);
        return "viewTodo";
    }
}
