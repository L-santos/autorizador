package com.rede;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.rede.domain.Procedimento;
import com.rede.domain.Regra;
import com.rede.values.Sexo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Logger;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppTest {

    EntityManagerFactory factory;
    EntityManager manager;

    @BeforeAll
    void setUp() {
        factory = Persistence.createEntityManagerFactory("com.rede.autorizador");
        manager = factory.createEntityManager();
    }

    @AfterAll
    void tearDown() {
        manager.getTransaction().rollback();
        Logger.getLogger("AppTest").info(manager.createQuery("from Regra", Regra.class).getResultList().size()+"");
        factory.close();
        manager.close();
    }

    @Test
    public void insertCheck() {
        manager.getTransaction().begin();
        Procedimento procedimento = new Procedimento(1234);
        Regra regra = new Regra(procedimento,10, Sexo.M, true);
        manager.persist(procedimento);
        manager.persist(regra);
    }
}
