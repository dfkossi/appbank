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
public class TitulaireCompte {
    
    private int numeroIdTitulaire;
    private String nomTitulaire;

    public TitulaireCompte() {
    }

    public TitulaireCompte(int numeroIdTitulaire, String nomTitulaire) {
        this.numeroIdTitulaire = numeroIdTitulaire;
        this.nomTitulaire = nomTitulaire;
    }
    

    public int getNumeroIdTitulaire() {
        return numeroIdTitulaire;
    }
    
    public String getNumeroIdTitulaireString(){
        return String.format("%03d", getNumeroIdTitulaire());
    }

    public void setNumeroIdTitulaire(int numeroIdTitulaire) {
        this.numeroIdTitulaire = numeroIdTitulaire;
    }

    public String getNomTitulaire() {
        return nomTitulaire;
    }

    public void setNomTitulaire(String nomTitulaire) {
        this.nomTitulaire = nomTitulaire;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.numeroIdTitulaire;
        hash = 17 * hash + Objects.hashCode(this.nomTitulaire);
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
        final TitulaireCompte other = (TitulaireCompte) obj;
        if (this.numeroIdTitulaire != other.numeroIdTitulaire) {
            return false;
        }
        if (!Objects.equals(this.nomTitulaire, other.nomTitulaire)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TitulaireCompte{" + "numeroIdTitulaire=" + numeroIdTitulaire + 
                ", nomTitulaire=" + nomTitulaire + '}';
    }
    
    
}
