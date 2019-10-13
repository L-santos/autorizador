package com.rede;

import com.rede.domain.Procedimento;
import com.rede.domain.Regra;
import com.rede.values.Permissao;
import com.rede.values.Sexo;

public class Cmd {
    /**
     * Parse args
     * @param procedimento
     * @param idade
     * @param sexo
     * @param permitido
     * @return Regra
     * @throws IllegalArgumentException
     */
    public static Regra parseRegra(String procedimento, String idade, String sexo, String permitido) throws IllegalArgumentException{
        Regra regra = new Regra();
        regra.setProcedimento(new Procedimento(Integer.parseInt(procedimento)));
        regra.setIdade(Integer.parseInt(idade));
        regra.setSexo(Sexo.valueOf(sexo.toUpperCase()));
        Permissao permissao = Permissao.valueOf(permitido.toUpperCase());
        regra.setPermitido(permissao == Permissao.SIM ? true : false);
        return regra;
    }
}
