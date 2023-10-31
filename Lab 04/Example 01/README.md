# Web Technologies - Laboratory 04 - Exercise 01

## Exercise

### Building a TODO List REST API with Thymeleaf

- [ ] List all Items:
    - Operation type: **GET**
    - Path: /todos
    - Request body: Model
    - Action: Add "items" as mode attribute with all todo items
    - Response: "template"

- [ ] Save an Item:
    - Operation type: **POST**
    - Path: /todos
    - Request body: Item
    - Response: "redirect:/todos"

- [ ] Trigger edit:
    - Operation type: **GET**
    - Path: /todos/edit/{id}
    - Path variable: Item id
    - Request body: Model
    - Action: Add "editItem" as mode attribute with the item to be edited
    - Response: "template"

- [ ] Edit an Item:
    - Operation type: **POST**
    - Path: /todos/edit/{id}
    - Path variable: Item id
    - Request body: Item
    - Response: "redirect:/todos"

- [ ] Mark an Item as done:
    - Operation type: **GET**
    - Path: /todos/delete/{id}
    - Path variable: Item id
    - Response: "redirect:/todos"
