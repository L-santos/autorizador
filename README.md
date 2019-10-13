#AUTORIZADOR

1: mvn package

----

Autorizar: [procedimento] [idade] [sexo]

Ex.: java -jar target/autorizador-1.0-SNAPSHOT.jar 1234 10 m

Cadastrar Regra: [procedimento] [idade] [sexo] [permissao "SIM/NAO"]

Ex.: java -jar target/autorizador-1.0-SNAPSHOT.jar 12334 14 f sim
