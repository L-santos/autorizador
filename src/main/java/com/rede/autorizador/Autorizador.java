package com.rede.autorizador;

import com.rede.domain.Regra;
import com.rede.repository.RegraRepository;

import java.util.ArrayList;
import java.util.List;

public class Autorizador {

    List<Regra> regras;

    public boolean autoriza(Regra regra) {
        regras = new ArrayList<>();
        regras = new RegraRepository().find(regra);
        return !regras.isEmpty();
    }
}