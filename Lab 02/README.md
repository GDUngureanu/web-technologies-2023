# Web Technologies - Laboratory 02

## Topics

- **Spring Core**: At its essence, Spring Core is the foundational part of the larger Spring Framework, responsible for providing dependency injection
  features. Think of Spring Core as the blueprint of a movie set. It defines where everything should be and ensures every part of the production has
  what it needs to function smoothly.

    - **Dependency Injection**: This fundamental principle allows an object to supply the dependencies of another object. To imagine this in the movie
      realm, think of it as the main method actors receive their scripts, costumes, and props. They don't have to look for them; everything they need
      is provided to them when they step onto the set.

        - **Constructor Injection**: Dependencies are provided through the class constructor, just like handing over a full script and costume when an
          actor first steps on set.
        - **Setter Injection**: Dependencies are added post-object creation using setter methods, akin to adjusting an actor’s outfit or giving them
          additional props after they're already on set.
        - **Method Injection**: This lets you override methods to return a specific bean. It's like a special technique an actor employs during a
          scene.
        - **Bean Factory**: This is the core mechanism of Spring responsible for creating and assembling beans, comparable to the backstage crew
          setting up everything behind the scenes.

    - **Spring Context**: This is the core of the Spring Framework, ensuring that every component is instantiated, configured, and assembled. If we
      relate this to a movie set, the Spring Context is like the environment of the movie — where every scene takes place and all interactions occur.

        - **ApplicationContext**: The primary interface for accessing the Spring context, letting you retrieve and manage beans. It functions like the
          director's clipboard, allowing access to every character and prop in the film.
        - **Lifecycle Management**: Spring context manages the entire lifecycle of beans from their creation to their destruction. This mirrors the
          journey of an actor from their first audition to the wrap-up party.

    - **Stereotypes and Annotations**: These are the labels or tags attached to Spring beans to guide the framework on how to treat them. Picture
      everyone on a movie set wearing a badge specifying their role, so everyone knows who's the director, who's an actor, and who's handling the
      camera.

        - **@Component**: This general-purpose annotation indicates the class is a Spring component whose lifecycle is managed by Spring.
        - **@Service**: Denotes the class is a service component, mainly used for business logic, acting like the badge of the lead actor or actress.
        - **@Repository**: This annotation points out the class deals with database operations. It's like the badge for those managing archives and
          props on set.
        - **@Controller**: Classes with this annotation handle incoming web requests, functioning as the traffic directors of our movie set.
        - **@Bean**: Used to declare a Spring-managed object, it's like specifying a unique role or character in our movie.
        - **@Qualifier**: It resolves ambiguities by specifying which exact bean should be autowired. In movie terms, when multiple actors could fit a
          role, the director picks the perfect match with clarity.

- **Maven**: This is a powerful project management tool primarily used for Java projects. It manages building, reporting, and documentation using a
  consistent approach. Think of Maven as a renowned chef in a well-organized kitchen. This chef not only knows all the recipes but also has a
  systematic approach to cooking dishes, ensuring that the right ingredients and tools are always used.

    - **Project Structure and Lifecycle**: Every Maven project adheres to a specific directory layout and undergoes a sequence of steps (lifecycle
      phases) during its build process. Just as a kitchen has designated areas for different utensils, spices, and ingredients, Maven projects are
      organized in a structured manner for clarity and standardization.
        - **Standard Layout**: Maven projects have a recommended directory layout (e.g., src/main/java for Java source files, src/test/java for test
          sources). This structure is akin to a kitchen organized with specific spots for utensils, spices, and ingredients.
        - **Build Lifecycle**: Maven follows a sequence of steps (lifecycle phases) during its build process. These phases are like the series of
          steps a chef follows to prepare a dish, from the initial validation of the dish (validate phase) to its final presentation (package phase).

    - **Dependencies**: These are external libraries that your project requires to function correctly.
        - **POM (pom.xml)**: This is the core of a Maven project, where you specify the libraries and versions your project needs. Think of it as a
          chef's recipe book, detailing the required ingredients.
        - **Central Repository**: Maven's main storage for dependencies. It's like a vast grocery store, stocked with all necessary ingredients.
        - **Transitive Dependencies**: Maven ensures that if your project requires a specific library, any other related libraries are also fetched.
          It's akin to knowing that a dish with tomatoes might also need some basil and mozzarella.

    - **Plugins**: Plugins are tools that extend Maven's capabilities, aiding various aspects of the build lifecycle. Think of them as specialized
      kitchen gadgets each having a distinct purpose.
        - **Plugin Goals**: Each plugin can perform specific tasks during the software development process. Just as each kitchen tool, like a blender
          or oven, has its unique function, each plugin goal serves a distinct purpose in Maven.
        - **Configuration**: In Maven, you can adjust settings for these plugins in the pom.xml, tailoring their behavior for your project's needs.
          This customization is like chefs adjusting settings on their kitchen tools for the perfect dish.

#### Useful Links

- Spring Core:
    - Spring Framework: https://spring.io/projects/spring-framework
    - Spring Documentation: https://docs.spring.io/spring-framework/docs/current/reference/html/core.html
    - Baeldung Spring Tutorials: https://www.baeldung.com/spring-tutorial
    - Spring Community on Stack Overflow: https://stackoverflow.com/questions/tagged/spring
    - Spring Forum: https://forum.spring.io/

- Maven:
    - Maven Homepage: https://maven.apache.org/
    - Maven User Documentation: https://maven.apache.org/users/index.html
    - Maven Repository: https://mvnrepository.com/
    - Spring Core Dependency: https://mvnrepository.com/artifact/org.springframework/spring-core
    - Baeldung Maven Tutorials: https://www.baeldung.com/maven
    - Tutorialspoint Maven Tutorial: https://www.tutorialspoint.com/maven/index.htm
    - Maven on Stack Overflow: https://stackoverflow.com/questions/tagged/maven 
   