package com.rede;

import com.rede.autorizador.Autorizador;
import com.rede.autorizador.Cadastro;
import com.rede.domain.Procedimento;
import com.rede.domain.Regra;
import com.rede.values.Sexo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AppTest {

    Logger logger;
    EntityManagerFactory factory;
    EntityManager manager;

    @BeforeAll
    void setUp() {
        logger = LogManager.getRootLogger();
        factory = Persistence.createEntityManagerFactory("com.rede.autorizador");
        manager = factory.createEntityManager();

        //Populate tables
        try (BufferedReader reader = new BufferedReader(new FileReader("import.sql"))) {
            String line;
            manager.getTransaction().begin();
            while ((line = reader.readLine()) != null) {
                manager.createNativeQuery(line).executeUpdate();
            }
            manager.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    void tearDown() {
        factory.close();
        manager.close();
    }

    @Test
    @Order(1)
    public void autoriza() {
        assertTrue(new Autorizador().autoriza(new Regra(new Procedimento(1234), 10, Sexo.M, true)));
    }

    @Test
    @Order(2)
    public void negativa() {
        assertFalse(new Autorizador().autoriza(new Regra(new Procedimento(1234), 10, Sexo.F, true)));
    }

    @Test
    @Order(3)
    @Disabled
    public void criar() {
        assertTrue(new Autorizador()
                .autoriza(new Cadastro()
                        .cadastrar(
                                new Regra(new Procedimento(899756), 23, Sexo.F, true)
                        )));
    }

}
