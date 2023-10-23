# Web Technologies - Laboratory 03

## Topics

- **Spring Core**: At its essence, Spring Core is the foundational part of the larger Spring Framework, responsible for providing dependency injection
  features. Think of Spring Core as the blueprint of a movie set. It defines where everything should be and ensures every part of the production has
  what it needs to function smoothly.

    - **Inversion of Control** (IoC): IoC is a design principle where the framework (in this case, Spring) takes control of the flow of a program and
      provides instances of objects to classes rather than the classes creating the objects themselves. In the movie-making process, actors don't
      decide when to come on set; the director calls them in. The director (representing the Spring framework) controls the flow and instructs the
      actors (objects) when and where they're needed. The actors don’t decide this on their own.

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

            - **Singleton**: Singleton is the default scope of Spring beans. Only one instance of a singleton bean is created, and this single
              instance is reused every time the bean is needed. Consider the leading actor in the movie. There's only one actor for that specific role
              throughout the movie, much like how there's only one instance of a singleton bean in the Spring context.
            - **Prototype**: In Spring, a prototype bean is instantiated each time it's requested from the container. It gives you a fresh instance
              every time you ask for it. Imagine prototype beans as the movie extras. In some scenes, you need a crowd. You don’t need the exact same
              crowd every time; any group of extras will do. Each time you shoot a scene with a crowd, you gather a new set of extras, similar to
              getting a new instance of a prototype bean each time.

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
        - **@Lazy**: Think of a prominent actor who doesn't come on set unless their specific scene is being shot. They're not there during the
          initial setup but only arrive when it's absolutely necessary. Similarly, @Lazy means a bean is not created during the initial context setup
          but only when it's first requested.

    - **Spring AOP (Aspect-Oriented Programming)**: AOP is like the special effects team of our movie set. They add additional features and effects to
      the movie without the main actors even knowing about it. They can make an actor fly, add dramatic rain to a scene, or ensure there's an echo
      when someone shouts in a cave.

        - **Aspect**: A specific special effect or a modification in our movie. For instance, every time there's a battle scene, the special effects
          team ensures there are dramatic explosions in the background.
        - **Join Point**: The specific scene or moment the special effect is applied. In our battle scene, it's the exact moment an explosion is
          required.
        - **Advice**: The action taken by the special effects team at a given join point. It could be adding the explosion, ensuring there's rain, or
          making sure there's an echo.
        - **Pointcut**: A specification that determines where the special effects (advice) are applied. For example, every scene that's shot at night
          in the forest will have a certain misty effect.

#### Useful Links

- Spring Core:
    - Spring Bean Scopes: https://www.baeldung.com/spring-bean-scopes
    - Injecting Prototype Beans: https://www.baeldung.com/spring-inject-prototype-bean-into-singleton
    - Spring AOP: https://www.baeldung.com/spring-aop

## [Exercise](Example%2000/README.md)