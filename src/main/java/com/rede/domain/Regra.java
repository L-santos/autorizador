package com.rede.domain;

import com.rede.values.Sexo;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Regra {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "seq_regra_id", strategy = "increment")
    private Integer id;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "id_procedimento",
            foreignKey = @ForeignKey(name = "PROCEDIMENTO_ID_FK")
    )
    private Procedimento procedimento;

    private Integer idade;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    private boolean permitido;

    public Regra() {}

    public Regra(Procedimento procedimento, Integer idade, Sexo sexo, boolean permitido) {
        this.procedimento = procedimento;
        this.idade = idade;
        this.sexo = sexo;
        this.permitido = permitido;
    }

    @Override
    public String toString() {
        return String.format("%d %d %s %s", procedimento.getCodigo(), idade, sexo, permitido);
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public boolean isPermitido() {
        return permitido;
    }

    public void setPermitido(boolean permitido) {
        this.permitido = permitido;
    }
}