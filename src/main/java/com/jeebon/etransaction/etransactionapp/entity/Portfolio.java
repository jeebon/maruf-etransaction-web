package com.jeebon.etransaction.etransactionapp.entity;

import javax.persistence.*;

@Entity
@Table(name="portfolios")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(columnDefinition="nvarchar(255)", nullable = true)
    private String code;

    @Column(columnDefinition="nvarchar(255)", nullable = true)
    private String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
