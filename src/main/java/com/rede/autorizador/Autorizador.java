package com.rede.autorizador;

import com.rede.domain.Procedimento;
import com.rede.domain.Regra;
import com.rede.repository.RegraRepository;
import com.rede.values.Sexo;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Autorizador {

    List<Regra> regras;

    public boolean autoriza(String procedimento, String idade, String sexo) throws IllegalArgumentException{
        regras = new ArrayList<>();
        Integer p = Integer.parseInt(procedimento);
        Integer i = Integer.parseInt(idade);
        Sexo s = Sexo.valueOf(sexo.toUpperCase());
        regras = new RegraRepository().find(new Regra(new Procedimento(p), i, s, true));
        return !regras.isEmpty();
    }
}