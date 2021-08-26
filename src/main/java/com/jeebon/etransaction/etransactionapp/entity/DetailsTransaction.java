package com.jeebon.etransaction.etransactionapp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="details_transactions")
public class DetailsTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Temporal(TemporalType.DATE)
    private Date created;

    @Column(columnDefinition="nvarchar(255)", nullable = true)
    private String portfolio;

    @Column(columnDefinition="Decimal(24,8)", nullable = true)
    private float value;

    @Column(columnDefinition="nvarchar(255) default 'JYP'")
    private String currency;

    @Column(columnDefinition="nvarchar(255) default 'NAV_OVR'", nullable = true)
    private String datatype;

    @Temporal(TemporalType.DATE)
    private Date dataAsofDate;

    @Column(columnDefinition="nvarchar(255) default 'POJ'", nullable = true)
    private String dataSource;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public Date getDataAsofDate() {
        return dataAsofDate;
    }

    public void setDataAsofDate(Date dataAsofDate) {
        this.dataAsofDate = dataAsofDate;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }
}

