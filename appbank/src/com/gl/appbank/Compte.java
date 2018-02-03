/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gl.appbank;

import java.util.Objects;

/**
 *
 * @author NAT
 */
public class Compte {
    private int numeroCompte;
    private double soldeCompte;
    private double tauxInteret;
    private TitulaireCompte titulaireCompte;

    public Compte() {
    }

    public Compte(int numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    
    public int getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(int numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public double getSoldeCompte() {
        return soldeCompte;
    }

    public void setSoldeCompte(double soldeCompte) {
        this.soldeCompte = soldeCompte;
    }

    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public TitulaireCompte getTitulaireCompte() {
        return titulaireCompte;
    }

    public void setTitulaireCompte(TitulaireCompte titulaireCompte) {
        this.titulaireCompte = titulaireCompte;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.numeroCompte;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.soldeCompte) ^ (Double.doubleToLongBits(this.soldeCompte) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.tauxInteret) ^ (Double.doubleToLongBits(this.tauxInteret) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.titulaireCompte);
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
        final Compte other = (Compte) obj;
        if (this.numeroCompte != other.numeroCompte) {
            return false;
        }
        if (Double.doubleToLongBits(this.soldeCompte) != Double.doubleToLongBits(other.soldeCompte)) {
            return false;
        }
        if (Double.doubleToLongBits(this.tauxInteret) != Double.doubleToLongBits(other.tauxInteret)) {
            return false;
        }
        if (!Objects.equals(this.titulaireCompte, other.titulaireCompte)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Compte{" + "numeroCompte=" + numeroCompte + ", soldeCompte=" + soldeCompte + ", tauxInteret=" + tauxInteret + ", titulaireCompte=" + titulaireCompte + '}';
    }

   
    
    
}