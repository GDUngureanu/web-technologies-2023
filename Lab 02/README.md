# Web Technologies - Laboratory 02

## Topics

### Spring Core

- **Spring Context**: It's essentially the heart of the Spring Framework. The Spring context brings everything together, ensuring that every component
  gets what it needs to operate. It's like the director of a movie; it oversees all the actors, props, and stages to make sure the movie gets made.
    - **ApplicationContext**: The primary interface for accessing the Spring context. This is the medium through which beans can be retrieved.
    - **Lifecycle Management**: The Spring context manages the complete lifecycle of beans from creation to destruction.

<p>

- **Dependency Injection**: At a basic level, Dependency Injection is like giving your class everything it needs to function rather than letting the
  class find or make them on its own. It's like going to a hotel where everything you need is provided versus camping in the wild.
    - **Constructor Injection**: Dependencies are provided through the constructor.
    - **Setter Injection**: Dependencies are set using setter methods.
    - **Method Injection**: Advanced feature where we can override methods to return a lookup for a particular bean.
    - **Bean Factory**: The mechanism within Spring that creates and wires together various beans (objects).
    - **@Bean**: Used to declare a Spring-managed object at the method level. It signals that the method will return an object that should be
      registered as a bean in the Spring application context. Typically used inside @Configuration classes or any class annotated with Spring’s
      stereotype annotations. This allows developers to use Java code to define beans explicitly.
    - **@Qualifier**: Helps in resolving ambiguities where multiple beans of the same type exist in the context. It specifies which exact bean should
      be autowired when there are multiple candidates. Used alongside @Autowired to specify the name of the bean that should be injected. It can also
      be used on methods annotated with @Bean to assign a qualifier value (or alias) to a bean.

<p> 

- **Stereotypes**: They are like labels or tags that you attach to classes to tell Spring how to treat them. It's like wearing different hats on a
  film set: one for the director, one for the actor, and one for the cameraperson. Spring sees the hat and knows what role you play.
    - **@Component**: General-purpose stereotype indicating that a class is a Spring-managed component.
    - **@Service**: Indicates that a class is a service component (often used for business logic).
    - **@Repository**: Suggests that a class is a repository (typically used with database operations).
    - **@Controller**: Marks a class as a web controller, capable of handling incoming web requests.

#### Maven

- **Dependencies**: Think of dependencies as the various ingredients needed to make a particular dish. Your Java project is the dish, and it may need
  several libraries or components (ingredients) to work. Instead of gathering and managing each ingredient individually, Maven does it for you.
    - **POM (pom.xml)**: The "recipe book" where you list down all the ingredients you need. Here, you specify which libraries and versions your
      project requires.
    - **Central Repository**: Maven's main storage area where it fetches the required dependencies. It's like a gigantic pantry stocked with every
      imaginable ingredient.
    - **Transitive Dependencies**: The idea that if you need one ingredient, you might automatically need a few others. For example, if a library A
      you've added depends on library B, Maven will fetch both for you.

<p>

- **Plugins**: If dependencies are the ingredients, plugins are the kitchen gadgets and tools. They help in processing, building, and managing your
  project. For instance, you might have a tool (plugin) for blending, one for baking, one for frying, and so on.
    - **Build Lifecycle**: Maven has a default build lifecycle with phases like compile, test, and package. Think of it as the step-by-step cooking
      instructions. Each step (phase) might need a specific tool (plugin).
    - **Plugin Goals**: Each plugin can achieve specific tasks. For instance, the maven-compiler-plugin has goals like compile and testCompile to
      handle source code compilation.
    - **Configuration**: Sometimes, you need to adjust the settings on your kitchen gadget (plugin). In Maven, you configure plugins in the pom.xml to
      specify things like which Java version to use for compilation.

<p>

- **Project Structure and Lifecycle**: Every Maven project follows a standard directory layout and a series of steps (lifecycle phases) that dictate
  the build process.
    - **Standard Layout**: Maven projects have a recommended directory layout (e.g., src/main/java for Java source files, src/test/java for test
      sources). It’s like organizing your kitchen with specific spots for utensils, spices, and so on.
    - **Build Lifecycle**: As mentioned, it's a series of steps Maven follows to build a project. From validating the project structure (validate
      phase) to compiling code (compile phase) to packaging it into a JAR or WAR (package phase) and more.

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
   