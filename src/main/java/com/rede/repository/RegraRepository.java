package com.rede.repository;

import com.rede.domain.Regra;
import com.rede.values.Sexo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegraRepository {
    private EntityManagerFactory factory;

    public List<Regra> find(Regra r) {
        factory = Persistence.createEntityManagerFactory("com.rede.autorizador");
        EntityManager manager = factory.createEntityManager();

        //manager.getTransaction().begin();

       /* String qlString = "select r from Regra r inner join r.procedimento where r.procedimento.codigo = :procedimento"+
                " and idade = :idade and sexo = :sexo and permitido = true";*/
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
        //manager.getTransaction().commit();
        LogManager.getLogger().info("Repo Fetch: "+ Arrays.toString(result.toArray()));
        manager.close();
        return result;
    }
}
