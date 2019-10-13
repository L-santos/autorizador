package com.rede.repository;

import com.rede.domain.Regra;
import org.apache.logging.log4j.LogManager;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegraRepository {
    private EntityManagerFactory factory;

    public List<Regra> find(Regra r) {
        factory = Persistence.createEntityManagerFactory("com.rede.autorizador");
        EntityManager manager = factory.createEntityManager();

        String qlString = "from Regra r where r.procedimento.codigo = :procedimento"+
                " and idade = :idade and sexo = :sexo and permitido = :permitido";
        List<Regra> result = new ArrayList<>();
       // result = manager.createQuery("select r from Regra r inner join r.procedimento where r.procedimento.codigo = 1234", Regra.class).getResultList();

        Query query = manager.createQuery(qlString, Regra.class);
        query.setParameter("procedimento",  r.getProcedimento().getCodigo());
        query.setParameter("idade", r.getIdade());
        query.setParameter("sexo", r.getSexo());
        query.setParameter("permitido", r.isPermitido());
        result = query.getResultList();
        //LogManager.getLogger().info("Repo Fetch: "+ Arrays.toString(result.toArray()));
        manager.close();
        return result;
    }

    public Regra save(Regra regra) {
        factory = Persistence.createEntityManagerFactory("com.rede.autorizador");
        EntityManager manager = factory.createEntityManager();

        //manager.getTransaction().begin();
        //manager.persist(regra);
        //manager.getTransaction().commit();

        manager.close();
        return regra;
    }
}
