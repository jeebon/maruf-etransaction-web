package com.jeebon.etransaction.etransactionapp.entity;
import javax.persistence.*;

@Entity
@Table(name="summary_transactions")
public class SummaryTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(columnDefinition="nvarchar(255)", nullable = true)
    private String fundCode;

    @Column(columnDefinition="Decimal(24,8)", nullable = true)
    private float amount;

    @Column(columnDefinition="Decimal(24,8)", nullable = true)
    private float marketValue;

    @Column(columnDefinition="Decimal(24,8)", nullable = true)
    private float accrued;

    @Column(columnDefinition="Decimal(24,8)", nullable = true)
    private float settlementCash;

    @Column(columnDefinition="Decimal(24,8)", nullable = true)
    private float receivable;

    @Column(columnDefinition="Decimal(24,8)", nullable = true)
    private float payable;

    @Column(columnDefinition="Decimal(24,8)", nullable = true)
    private float unapplied;

    @Column(columnDefinition="Decimal(24,8)", nullable = true)
    private float valuationMargin;

    @Column(columnDefinition="Decimal(24,8)", nullable = true)
    private float offBalance;

    @Column(columnDefinition="Decimal(24,8)", nullable = true)
    private float nav;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(float marketValue) {
        this.marketValue = marketValue;
    }

    public float getAccrued() {
        return accrued;
    }

    public void setAccrued(float accrued) {
        this.accrued = accrued;
    }

    public float getSettlementCash() {
        return settlementCash;
    }

    public void setSettlementCash(float settlementCash) {
        this.settlementCash = settlementCash;
    }

    public float getReceivable() {
        return receivable;
    }

    public void setReceivable(float receivable) {
        this.receivable = receivable;
    }

    public float getPayable() {
        return payable;
    }

    public void setPayable(float payable) {
        this.payable = payable;
    }

    public float getUnapplied() {
        return unapplied;
    }

    public void setUnapplied(float unapplied) {
        this.unapplied = unapplied;
    }

    public float getValuationMargin() {
        return valuationMargin;
    }

    public void setValuationMargin(float valuationMargin) {
        this.valuationMargin = valuationMargin;
    }

    public float getOffBalance() {
        return offBalance;
    }

    public void setOffBalance(float offBalance) {
        this.offBalance = offBalance;
    }

    public float getNav() {
        return nav;
    }

    public void setNav(float nav) {
        this.nav = nav;
    }
}
