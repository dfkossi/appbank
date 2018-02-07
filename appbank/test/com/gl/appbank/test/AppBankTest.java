/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gl.appbank.test;

import com.gl.appbank.AppBankLauncher;
import com.gl.appbank.Compte;
import com.gl.appbank.TitulaireCompte;
import com.gl.appbank.Transaction;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author NAT
 */
public class AppBankTest {

    private static Double soldeInitiale;
    private static Double montantAdeposer;
    private static Double montantAretirer;
    private static Compte compte = new Compte();
    private static TitulaireCompte titulaire = new TitulaireCompte();
    private static Transaction transaction = new Transaction();
    public static List<TitulaireCompte> listeTitulaireCompte = new ArrayList<>();
    public static List<Compte> listeCompte = new ArrayList<>();
    public static List<Transaction> listeTransactions = new ArrayList<>();

    public AppBankTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        soldeInitiale = 5000.0;
        montantAdeposer = 5000.0;
        montantAretirer = 2000.0;

        titulaire.setNumeroIdTitulaire(001);
        titulaire.setNomTitulaire("MAYABA Solim Wapo");
        AppBankLauncher.listeTitulaireCompte.add(titulaire);

        compte.setNumeroCompte(AppBankLauncher.genererNumeroCompte());
        compte.setSoldeCompte(5000);
        compte.setTauxInteret(5.0);
        compte.setTitulaireCompte(titulaire);
        AppBankLauncher.listeCompte.add(compte);
    }

    @AfterClass
    public static void tearDownClass() {
        soldeInitiale = compte.getSoldeCompte();
    }

    @Before
    public void setUp() {
        soldeInitiale = compte.getSoldeCompte();
    }

    @After
    public void tearDown() {
        soldeInitiale = compte.getSoldeCompte();
    }

    /**
     * Test of deposit method.
     */
    @Test
    public void testDepositCompte() {

        transaction.setCompte(compte);
        transaction.setDateTransaction(new Date());
        transaction.setMontantTransaction(montantAdeposer);
        transaction.setNumeroTransaction(AppBankLauncher.genererNumeroTransaction());
        transaction.setTypeTransaction("depot");
        AppBankLauncher.enregistrerTransaction(transaction);

        //nouveau solde attendu 
        Double expResult = soldeInitiale + montantAdeposer;
        //Nouveau solde du compte
        Double result = compte.getSoldeCompte();
        System.out.println("exp " + expResult);
        System.out.println("res " + result);
        assertEquals(expResult, result);

    }

    @Test
    public void testRetraitCompte() {

        transaction.setCompte(compte);
        transaction.setDateTransaction(new Date());
        transaction.setMontantTransaction(montantAretirer);
        transaction.setNumeroTransaction(AppBankLauncher.genererNumeroTransaction());
        transaction.setTypeTransaction("retrait");
        AppBankLauncher.enregistrerTransaction(transaction);

        //nouveau solde attendu 
        Double expResult = soldeInitiale - montantAretirer;
        //Nouveau solde du compte
        Double result = compte.getSoldeCompte();
        System.out.println("exp " + expResult);
        System.out.println("res " + result);
        assertEquals(expResult, result);

    }

}
