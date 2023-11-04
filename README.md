## a CRUD Rest API Todo App
- this will be a basic Todo Application with CRUD Operations

- we'll be using H2 Database for storing Todos, Lombok, Spring Web, Spring Data JPA & Actuater will be uses ad the Dependencies

- firstly we'll configure the database in application.properties

    - username, password: for H2, default is `sa` as username and `password` as password.

    - for Data JPA Implementation spring boot uses Hibernate, so we need to mention that too, i.e. `spring.jpa.database-platform=org.hibernate.dialect.H2Dialect`

    - `spring.datasource.url=jdbc:h2:mem:todo`species the database url and the database name. In our case the database name is `todo`.

- Now in Model Package we'll create a Java Enum for TodoStatus : Completed, Not\_Completed

- Now in model package i'll create a entity for a Todo

    - @Entity annotation shows that the class is a persistent Java class.

    - @Id annotation shows that the annotated field is the primary key.

    - @GeneratedValue annotation is used to specify the generation strategy used for the primary key.

    - @Column annotation defines the column in the database that maps the annotated field.

    - @CreationTimestamp annotation is a JPA annotation that automatically updates the todo creation timestamp.

    - @UpdateTimestamp annotation is a JPA annotation that automatically updates the todo last modified timestamp.

    - @Data annotation is from project Lombok. It generates the getters and setters for all the fields that we have in the todo class, equals method, and a toString method.

    - @NoArgsConstructor annotation is from project Lombok and it generates an empty constructor for our Todo class.

    - @AllArgsConstructor annotation is from project Lombok and it generates a constructor with all the fields that are available in our Todo class.

- Now we need to create a repository in repositories package ,it'll be an interface which will extend the CrudRepository, which will allow us to use methods like save(), findOne(), findById(), findAll(), count(), delete() etc. without providing their implementation.

    - also @Repository annotation marks this interface as a Spring Data JPA repository.

- Now it's time to create a service and it's implementation

    - Let's begin with Service Interface, here we'll declare all the required functions for our Implementation

        - getTodos() for getting list of all todos.

        - getTodoById(id) for getting a specific todo by ID

        - insert(todo) for inserting todo in a db

        - update(id,todo) to update a todo by id

        - delete(id) to delete a todo by id.

    - Let's talk about implementation

        - @service annotation makes Spring context be aware of this class as a service.

        - getTodos() - findAll()

        - getTodoById(id) - findById(id)

        - insert(todo) - save(todo)

        - update(id,todo) - findById(id), then setTodoStatus(todo.getStatus), then setTitle(todo,getTitle) and then save(todoFromDB)

        - delete(id) - deleteById(id)

- Now for Rest API Controller we need to create a controller class which will map APIs for us and Response will be managed here

    - @RestController annotation marks this class as a controller that can process the incoming HTTP requests.

    - @RequestMapping("/api/v1/todo") annotation sets the base path to the resource endpoints in the controller as /api/v1/todo.

    - We inject the TodoService through our constructor to be able to use the various methods defined in it within the TodoController class.

    - CRUD APIs

        - @GetMapping annotation indicates that the function processes a GET request.

            - getAllTodos() - The function receives a GET request, processes it and gives back a list of Todo as a response.

            - getTodo(@PathVariable Long todoId) - The function receives a GET request, processes it, and gives back a list of Todo as a response.

        - @PostMapping annotation indicates that a function processes a POST request.

            - save(@RequestBody Todo todo) - The function receives a POST request, processes it, creates a new Todo and saves it to the database, and returns a resource link to the created todo.

        - @PutMapping annotation indicates that a function processes a PUT request

            - update(@PathVariable("todoId")Long todoId, @RequestBody Todo todo) - The function receives a PUT request, updates the Todo with the specified Id and returns the updated Todo

        - @DeleteMapping annotation indicates that a function processes a DELETE request.

            - delete(@PathVariable("tododId") Long todoId) - The function receives a DELETE request, deletes the Todo with the specified Id.





