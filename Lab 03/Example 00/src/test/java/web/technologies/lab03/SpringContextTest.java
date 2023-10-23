package web.technologies.lab03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Files;
import java.nio.file.Paths;

import lombok.SneakyThrows;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import web.technologies.lab03.asset.BobaFett;
import web.technologies.lab03.asset.StarDestroyer;
import web.technologies.lab03.asset.TIEFighter;
import web.technologies.lab03.config.EmpireConfiguration;
import web.technologies.lab03.manager.DeploymentServiceManager;
import web.technologies.lab03.service.AssetDeployment;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpringContextTest {

    @Autowired
    private ApplicationContext springContext;

    @Test
    @Order(1)
    public void testStarDestroyerBeans() {
        String[] beanNames = {"devastator", "executor"};

        testBeans(beanNames, StarDestroyer.class);
    }

    @Test
    @Order(2)
    public void testTIEFighterBeans() {
        String[] beanNames = {"ALPHA-001", "BRAVO-002", "CHARLIE-003"};

        testBeans(beanNames, TIEFighter.class);
    }

    @Test
    @Order(3)
    public void testBobaFettBeans() {
        String[] beanNames = {"bobaOriginal", "bobaClone"};

        testBeans(beanNames, BobaFett.class);
    }

    @Test
    @Order(4)
    public void testEmpireConfigurationBean() {
        testBean("empireConfiguration", EmpireConfiguration.class);
    }

    @Test
    @Order(5)
    public void testAssetDeploymentBeans() {
        String[] beanNames = {"deathStarDeployment", "endorDeployment", "frontierPatrol"};

        testBeans(beanNames, AssetDeployment.class);
    }

    @Test
    @Order(6)
    public void testDeploymentServiceManagerBean() {
        testBean("deploymentServiceManager", DeploymentServiceManager.class);
    }

    @Test
    @Order(7)
    @SneakyThrows
    public void testLogContent() {
        final var testFilePath = System.getProperty("user.dir") + "/src/main/resources/log.txt";
        final var testFileContent = Files.readString(Paths.get(testFilePath));

        final var logFilePath = System.getProperty("user.dir") + "/src/main/resources/log.txt";
        final var logFileContent = Files.readString(Paths.get(logFilePath));

        assertEquals(testFileContent, logFileContent);
    }

    private void testBeans(String[] beanNames, Class<?> beanClass) {
        for (String beanName : beanNames) {
            testBean(beanName, beanClass);
        }
    }

    private void testBean(String beanName, Class<?> beanClass) {
        assertTrue(springContext.containsBean(beanName));

        final var bean = springContext.getBean(beanName);
        assertTrue(beanClass.isInstance(bean));
    }
}
