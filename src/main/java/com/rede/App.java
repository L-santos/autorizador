package com.rede;

import com.rede.autorizador.Autorizador;
import com.rede.autorizador.Cadastro;
import com.rede.domain.Regra;

import static com.rede.Cmd.parseRegra;

public class App {

    public static void main(String[] args) {
        Regra regra = new Regra();
        try {
            if (args.length == 3) {
                System.out.println(new Autorizador().autoriza(parseRegra(args[0], args[1], args[2], "SIM")) ? "SIM" : "NAO");
            }else if(args.length == 4){
                System.out.println(new Cadastro().cadastrar(parseRegra(args[0], args[1], args[2], args[3])));
            }
        } catch (IllegalArgumentException e) {
            System.out.print("Argumentos Invalidos");
        }
    }
}
