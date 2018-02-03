/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gl.appbank;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author NAT
 */
public class Transaction {

    private int numeroTransaction;
    private Date dateTransaction;
    private String typeTransaction;
    private double montantTransaction;
    private Compte compte;

    public Transaction() {
    }

    public int getNumeroTransaction() {
        return numeroTransaction;
    }

    public void setNumeroTransaction(int numeroTransaction) {
        this.numeroTransaction = numeroTransaction;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public String getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public double getMontantTransaction() {
        return montantTransaction;
    }

    public void setMontantTransaction(double montantTransaction) {
        this.montantTransaction = montantTransaction;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.numeroTransaction;
        hash = 13 * hash + Objects.hashCode(this.dateTransaction);
        hash = 13 * hash + Objects.hashCode(this.typeTransaction);
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.montantTransaction) ^ (Double.doubleToLongBits(this.montantTransaction) >>> 32));
        hash = 13 * hash + Objects.hashCode(this.compte);
        return hash;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Transaction other = (Transaction) obj;
        if (this.numeroTransaction != other.numeroTransaction) {
            return false;
        }
        if (this.typeTransaction != other.typeTransaction) {
            return false;
        }
        if (Double.doubleToLongBits(this.montantTransaction) != Double.doubleToLongBits(other.montantTransaction)) {
            return false;
        }
        if (!Objects.equals(this.dateTransaction, other.dateTransaction)) {
            return false;
        }
        if (!Objects.equals(this.compte, other.compte)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transaction{" + "numeroTransaction=" + numeroTransaction + ", dateTransaction=" 
                + dateTransaction + ", typeTransaction=" + typeTransaction + ", montantTransaction=" 
                + montantTransaction + ", compte=" + compte + '}';
    }



}
