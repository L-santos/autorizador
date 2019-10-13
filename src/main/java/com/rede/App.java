package com.rede;

import com.rede.autorizador.Autorizador;

public class App 
{
    public static void main( String[] args )
    {
        if(args.length == 3){
            System.out.println( new Autorizador().autoriza(args[0], args[1], args[2]) ? "SIM" : "NAO");
        }
    }
}
