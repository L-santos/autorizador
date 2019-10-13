package com.rede;

import com.rede.autorizador.Autorizador;
import com.rede.autorizador.Cadastro;

public class App {

    public static void main(String[] args) {
        try {

            if (args.length == 3) {
                System.out.println(new Autorizador().autoriza(args[0], args[1], args[2]) ? "SIM" : "NAO");
            }else if(args.length == 4){
                new Cadastro().cadastrar(args[0], args[1], args[2], args[3]);
            }
        } catch (IllegalArgumentException e) {
            System.out.print("Argumentos Invalidos");
        }
    }
}
