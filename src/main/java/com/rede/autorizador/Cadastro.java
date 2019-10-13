package com.rede.autorizador;

import com.rede.domain.Regra;
import com.rede.repository.RegraRepository;

public class Cadastro {
    Regra regra;
    public Regra cadastrar(Regra regra) {
        regra = new RegraRepository().save(regra);
        return regra;
    }
}
