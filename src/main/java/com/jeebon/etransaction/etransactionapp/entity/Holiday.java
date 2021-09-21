package com.jeebon.etransaction.etransactionapp.entity;

import javax.persistence.*;

@Entity
@Table(name="holidays")
public class Holiday {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(columnDefinition="nvarchar(255)", nullable = true)
    private String businessDate;

    @Column(columnDefinition="nvarchar(255)", nullable = true)
    private String presentDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate;
    }

    public String getPresentDate() {
        return presentDate;
    }

    public void setPresentDate(String presentDate) {
        this.presentDate = presentDate;
    }
}
