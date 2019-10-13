package com.rede.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Procedimento {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "seq_proc_id", strategy = "increment")
    private Integer id;

    @Column(unique = true)
    private Integer codigo;

    public Procedimento() {}

    public Procedimento(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
}