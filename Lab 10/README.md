# Web Technologies - Laboratory 10 - Testing

## Introduction to JUnit 5

JUnit 5 is the latest version of JUnit, a popular testing framework in the Java ecosystem. It's used for writing and running repeatable tests,
ensuring that code works as intended. JUnit 5 is not just an upgrade to JUnit 4 but a complete rewrite, offering new features and a more modular
architecture.

### Key Features of JUnit 5

- **Modularity:** JUnit 5 is composed of several modules, including JUnit Platform, JUnit Jupiter, and JUnit Vintage.
- **Annotations:** Introduces new annotations like `@Nested`, `@DisplayName`, `@Tag`, and more.
- **Lambda Support:** JUnit 5 leverages Java 8 features, such as lambda expressions for more readable and concise tests.
- **Dynamic Tests:** Allows the creation of tests at runtime, providing more flexibility.
- **Extension Model:** Offers a powerful extension model to customize test execution.

### Setting Up JUnit 5

#### Dependencies

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.x.x</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.x.x</version>
    <scope>test</scope>
</dependency>
```

#### Basic Test Structure

A basic JUnit 5 test class looks like this:

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyFirstJUnitJupiterTests {

    @Test
    void addition() {
        assertEquals(2, 1 + 1);
    }
}
```

### Important Annotations

- `@Test`: Denotes a method as a test method.
- `@BeforeEach`: Executed before each test. Useful for setting up test data.
- `@AfterEach`: Executed after each test. Useful for cleanup.
- `@BeforeAll`: Executed once before all tests. Must be static.
- `@AfterAll`: Executed once after all tests. Must be static.
- `@DisplayName`: Provides a custom name for the test.
- `@Disabled`: Disables a test method or class.
- `@Nested`: Allows nesting test classes to group related tests.

### Assertions

JUnit 5 provides a range of assertion methods in `org.junit.jupiter.api.Assertions`, like:

- `assertEquals(expected, actual)`: Checks if two values are equal.
- `assertTrue(condition)`: Checks if a condition is true.
- `assertThrows(exceptionClass, executable)`: Expects an exception.

### Assumptions

Assumptions are used to run tests only if certain conditions are met, using methods from `org.junit.jupiter.api.Assumptions`. For
example, `assumeTrue(condition)` only runs the test if `condition` is true.

### Writing Tests

#### Basic Test

```java
@Test
@DisplayName("Simple multiplication test")
void testMultiply() {
    assertEquals(20, 4 * 5, "Optional failure message");
}
```

#### Testing Exceptions

```java
@Test
void whenExceptionThrown_thenAssertionSucceeds() {
    Exception exception = assertThrows(NumberFormatException.class, () -> {
        Integer.parseInt("one");
    });
    assertEquals("For input string: \"one\"", exception.getMessage());
}
```

#### Parameterized Tests

JUnit 5 supports parameterized tests, allowing you to run the same test with different parameters.

```java
@ParameterizedTest
@ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
void palindromes(String candidate) {
    assertTrue(StringUtils.isPalindrome(candidate));
}
```

### Notes

JUnit 5 is a powerful tool for ensuring the reliability of your Java code. By writing comprehensive tests, you can catch bugs early and maintain high
code quality. As a college student, mastering JUnit 5 will greatly enhance your programming and testing skills, preparing you for professional
software development.

## Introduction to Mockito

Mockito is a popular Java-based mocking framework used in conjunction with testing frameworks like JUnit. It simplifies the creation of mock objects
and is particularly useful for testing behavior in isolation. Mockito allows you to simulate the behavior of complex dependencies so you can test
individual components without relying on the actual implementations of those dependencies.

### Key Features of Mockito

- **Easy Mock Creation:** Quickly create mock objects for interfaces and classes.
- **Behavior Stubbing:** Define return values and behavior for your mock methods.
- **Verification:** Ensure certain methods are called with specified arguments.
- **Argument Matchers:** Use matchers to allow flexible verification or stubbing.

### Dependencies

To use Mockito, you need to include it in your project's dependencies:

```xml
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>5.x.x</version>
    <scope>test</scope>
</dependency>
```

### Basic Usage

#### Mock Creation

Mockito allows you to create a mock object for an interface or a class:

```java
List mockedList = Mockito.mock(List.class);
```

#### Stubbing

Stubbing defines the behavior of a mock for specific method calls:

```java
when(mockedList.get(0)).thenReturn("first element");
```

#### Verification

Verify if a specific method was called with certain arguments:

```java
Mockito.verify(mockedList).add("one");
```

### Advanced Features

#### Argument Matchers

Mockito provides argument matchers to create flexible interactions:

```java
when(mockedList.get(anyInt())).thenReturn("element");
```

#### Spy

Create a spy to partially mock an object, keeping some of the real behavior:

```java
List<String> list = new ArrayList<>();
List<String> spyList = Mockito.spy(list);

// Optional: override some methods
when(spyList.size()).thenReturn(100);

spyList.add("one");
spyList.add("two");

Mockito.verify(spyList).add("one");
Mockito.verify(spyList).add("two");
assertEquals(100, spyList.size());
```

### Integrating Mockito with JUnit 5

JUnit 5 integration is straightforward using the Mockito extension.

#### Example with `@ExtendWith(MockitoExtension.class)`

```java
@ExtendWith(MockitoExtension.class)
public class SomeServiceTest {

    @Mock
    private Dependency dependency;

    @InjectMocks
    private SomeService someService;

    @Test
    void testSomeBehavior() {
        when(dependency.someMethod()).thenReturn("Mocked Response");
        
        String result = someService.useDependency();
        
        assertEquals("Mocked Response", result);
        verify(dependency).someMethod();
    }
}
```

In this example, `@Mock` creates a mock instance of `Dependency`, and `@InjectMocks` creates an instance of `SomeService` with the mock injected into
it.

### Notes

Mockito is an invaluable tool for unit testing in Java, enabling you to focus on the behavior of individual components without relying on their
dependencies. It is particularly useful in a test-driven development (TDD) environment. As a college student, getting comfortable with Mockito can
significantly improve your ability to write effective and reliable unit tests, making you better prepared for real-world software development
challenges.

## Introduction to MockMvc

MockMvc is a powerful tool provided by the Spring Framework, specifically designed for testing Spring MVC applications. It allows you to simulate HTTP
requests and assert various aspects of the resulting responses, making it ideal for testing web controllers without starting an actual HTTP server.

### Key Features of MockMvc

- **Simulate HTTP Requests:** Test GET, POST, PUT, DELETE, and other HTTP request types.
- **Assert Responses:** Check status codes, content types, headers, and body content.
- **Spring Integration:** Seamlessly integrates with Spring Boot and Spring MVC.

### Setting Up MockMvc

To use MockMvc in your tests, include the Spring Boot Test Starter in your project's dependencies:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <version>{version}</version>
    <scope>test</scope>
</dependency>
```

### Basic Usage

#### Test Class Setup

To start writing tests with MockMvc, set up your test class with the necessary annotations:

```java
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class MyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Test methods will be added here
}
```

In this setup:

- `@SpringBootTest` starts the whole Spring context for the test.
- `@AutoConfigureMockMvc` automatically configures `MockMvc`.
- `@ExtendWith(SpringExtension.class)` integrates the test with Spring TestContext Framework.

#### Writing Test Methods

MockMvc allows you to build a request to a specific URL and then assert various aspects of the response:

```java
@Test
public void shouldReturnDefaultMessage() throws Exception {
    this.mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("Hello, World")));
}
```

In this example, a GET request is made to the root URL (`"/"`), and the test asserts that the response has a status code of 200 (OK) and the content
includes "Hello, World".

### Advanced Usage

#### Testing POST Requests

You can also test POST requests and send data as part of the request:

```java
@Test
public void createUserTest() throws Exception {
    String userJson = "{\"name\":\"John\", \"email\":\"john@example.com\"}";
    this.mockMvc.perform(post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(userJson))
            .andExpect(status().isCreated());
}
```

#### Testing Error Scenarios

MockMvc can be used to test various error scenarios, such as a 404 Not Found status:

```java
@Test
public void shouldReturnNotFound() throws Exception {
    this.mockMvc.perform(get("/unknown"))
            .andExpect(status().isNotFound());
}
```

### Notes

MockMvc is an essential tool for testing Spring MVC applications, providing a way to simulate HTTP requests and assert responses without the overhead
of starting an actual server. It's a must-learn for college students aiming to develop and test robust Spring applications. By mastering MockMvc, you
can ensure your Spring controllers behave as expected under various scenarios, greatly enhancing the quality and reliability of your web applications.