/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gl.appbank;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author NAT
 */
public class AppBankLauncher {

    /**
     * @param args the command line arguments
     */
    //Liste des titulaires de compte de la banque 
    public static List<TitulaireCompte> listeTitulaireCompte = new ArrayList<>();
    public static List<Compte> listeCompte = new ArrayList<>();
    public static List<Transaction> listeTransactions = new ArrayList<>();
    public static String TYPE_DEPOT = "depot";
    public static String TYPE_RETRAIT = "retrait";

    private static Scanner sc = new Scanner(System.in);
    private static int entree = 0;

    public static void main(String[] args) {
        int yournumber = 4;
        String uu = String.format("%03d", yournumber);
        System.out.println(" hhh " + uu);
        int hh = Integer.valueOf(uu);
        System.out.println(" bbb " + hh);
        accueil();
        menuGenral();
    }

    public static void createCompteOptions(int entre) {
        switch (entre) {
            case 1:
                createCompteTitulaireNotExist();
                break;
            case 2:
                createCompteTitulaireExist();
                break;
            case 3:

                System.out.println("\n!!! Action annulee. Retour au menu principal !!!");
                break;
        }
    }

    public static void transactionOptions(int entre) {
        switch (entre) {
            case 1:
                depotSurCompte();
                break;
            case 2:
                retraitSurCompte();
                break;
            case 3:
                System.out.println("\n!!! Action annullee. Retour au menu principal !!!");
        }
    }

    public static void menuGenral() {
        while (true) {
            menuPrincipal();
            entree = 0;
            vericationDeLaSaisie(1, 9);
            switch (entree) {
                case 1:
                    entree = 0;
                    menuCreationCompte();
                    vericationDeLaSaisie(1, 3);
                    createCompteOptions(entree);
                    break;
                case 2:
                    entree = 0;
                    menuTransaction();
                    vericationDeLaSaisie(1, 3);
                    transactionOptions(entree);
                    break;
                case 3:
                    listerClients();
                    break;
                case 4:
                    listerComptes();
                    break;
                case 5:
                    listCompteParTitulaire();
                    break;
                case 6:
                    consulterCompte();
                    break;
                case 7:
                    rapportCompte();
                    break;
                case 8:
                    calculInteret();
                    break;
                case 9:
                    mettreFinAuProgramme();
                    break;
            }
        }
    }

    private static void accueil() {
        System.out.println("___________________MODULE DE GENIE LOGICIEL AVANCE___________________\n");
        System.out.println(" TP1.  MAYABA Solim Wapo & DAGBEGNIKIN Fo Kossi\n");
        System.out.println("_________________________________________________________________\n\n");
    }

    private static void menuPrincipal() {
        System.out.print("\n\n\t\tMENU PRINCIPAL DE GESTION BANCAIRE\n");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        System.out.print("1 : CREATION D'UN NOUVEAU COMPTE \n");
        System.out.print("2 : EFFECTUER UNE TRANSACTION SUR UN COMPTE\n");
        System.out.print("3 : LISTE DES CLIENTS\n");
        System.out.print("4 : LISTE DES COMPTES\n");
        System.out.print("5 : RECHERCHER COMPTES D'UN TITULAIRE\n");
        System.out.print("6 : CONSULTER SOLDE D'UN COMPTE\n");
        System.out.print("7 : RAPPORT DES COMPTE\n");
        System.out.print("8 : CALCUL D'INTERET ET MAJ COMPTE\n");
        System.out.print("9 : FIN\n");
        System.out.print("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\nChoix : ");
    }

    //Vérification numéro choix des menus
    private static void vericationDeLaSaisie(int borneInferieure, int borneSuperieure) {
        while (entree < borneInferieure || entree > borneSuperieure) {
            verificationTypeDeDonnee();
            entree = sc.nextInt();
            if (entree < borneInferieure || entree > borneSuperieure) {
                System.out.println("Entrez un numero entre " + borneInferieure + " et " + borneSuperieure + "\n");
            }
        }
    }

    //Fonction de verification de type 
    private static void verificationTypeDeDonnee() {
        if (!sc.hasNextInt()) {
            System.out.print("Saisir votre numero d'operation !!!\nChoix :");
            sc.nextLine();
            verificationTypeDeDonnee();
        }
    }

    //Fonction de verification de type 
    private static void verificationTypeDeDonneeNombre(int type) {
        switch (type) {
            case 1:
                if (!sc.hasNextInt()) {
                    System.out.print("Veuillez Saisir un nombre entier !!!\n ");
                    sc.nextLine();
                    verificationTypeDeDonneeNombre(type);
                }
                break;
            case 2:
                if (!sc.hasNextDouble()) {
                    System.out.print("Veuillez Saisir un nombre !!!\n ");
                    sc.nextLine();
                    verificationTypeDeDonneeNombre(type);
                }
                break;
        }

    }

    //Fin du programme
    private static void mettreFinAuProgramme() {
        System.out.println("\nFermeture du programme !\n");
        System.exit(0);
    }

    //Menu de création de compte
    private static void menuCreationCompte() {
        System.out.print("\n\n\t\tCREATION D'UN NOUVEAU COMPTE\n");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        System.out.print("1 : NOUVEAU CLIENT\n");
        System.out.print("2 : ANCIEN CLIENT\n");
        System.out.print("3 : SORTIR\n");
        System.out.print("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\nChoix : ");
    }

    //Menu transaction
    private static void menuTransaction() {
        System.out.print("\n\n\t\tTRANSACTION SUR UN COMPTE\n");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        System.out.print("1 : DEPOT D'ARGENT\n");
        System.out.print("2 : RETRAIT D'ARGENT\n");
        System.out.print("3 : SORTIR\n");
        System.out.print("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\nChoix : ");
    }

    //Création de compte si le titulaire existe déja
    private static void createCompteTitulaireExist() {
        System.out.print("\n\n~~~CREATION D'UN COMPTE~~~\n\n");
        System.out.print("IDENTIFIANT DU CLIENT : \n");
        verificationTypeDeDonneeNombre(1);
        int identifiant = sc.nextInt();
        TitulaireCompte ti = titulaireIsExist(identifiant);
        if (ti != null) {
            System.out.print("_______INFOS TITULAIRE_____ : \n");
            System.out.println("numéro =" + ti.getNumeroIdTitulaire()
                    + "nom =" + ti.getNomTitulaire());

//        int numeroIdentifiant = 1;    
            System.out.print("_______INFOS COMPTE_____ : \n");
            System.out.print("MONTANT : \n");
            verificationTypeDeDonneeNombre(1);
            double montant = sc.nextDouble();

            System.out.print("TAUX D'INTERET : \n");
            verificationTypeDeDonneeNombre(2);
            double taux = sc.nextDouble();

//            int numeroCompte = 001;
            System.out.print("Voulez-vous enregistrer ce compte?\t1 : OUI\t2 : NON\n");
            vericationDeLaSaisie(1, 2);
            entree = sc.nextInt();
            if (entree == 1) {
                Compte c = new Compte();
                c.setNumeroCompte(genererNumeroCompte());
                c.setSoldeCompte(montant);
                c.setTauxInteret(taux);
                c.setTitulaireCompte(ti);
                listeCompte.add(c);
                System.out.print("Opération enregistrée\n");
                menuGenral();

            } else {
                System.out.print("Opération annulée\n");
                menuGenral();
            }
            entree = 0;
        } else {

            menuCreationCompte();
            int numMenu = sc.nextInt();
            createCompteOptions(numMenu);
            vericationDeLaSaisie(1, 3);

        }

    }

    //Création de compte si le titulaire n'existe pas déja
    private static void createCompteTitulaireNotExist() {
        System.out.print("\n\n~~~CREATION D'UN COMPTE~~~\n\n");
        System.out.print("_______INFOS CLIENT_____ : \n");
        System.out.print("NOM DU CLIENT : \n");
        sc.nextLine();
        String nom = sc.nextLine();
        System.out.print("_______INFOS COMPTE_____ : \n");
        System.out.print("MONTANT : \n");
        verificationTypeDeDonneeNombre(2);
        double montant = sc.nextDouble();

        System.out.print("TAUX D'INTERET : \n");
        verificationTypeDeDonneeNombre(2);
        double taux = sc.nextDouble();

        System.out.print("Voulez-vous enregistrer ce compte?\t1 : OUI\t2 : NON\n");
        vericationDeLaSaisie(1, 2);
        entree = sc.nextInt();
        if (entree == 1) {
            TitulaireCompte t = new TitulaireCompte();
            t.setNomTitulaire(nom);
            t.setNumeroIdTitulaire(genererNumeroTitulaire());
            listeTitulaireCompte.add(t);
            Compte c = new Compte();
            c.setNumeroCompte(genererNumeroCompte());
            c.setSoldeCompte(montant);
            c.setTauxInteret(taux);
            c.setTitulaireCompte(t);
            listeCompte.add(c);
            System.out.print("Opération enregistrée\n");
            menuGenral();
        } else {
            System.out.print("Opération annulée\n");
            menuGenral();
        }

        entree = 0;
    }

    //Génération automatique du numéro du titulaire
    public static int genererNumeroTitulaire() {
        int num = 900;
        if (listeTitulaireCompte.isEmpty()) {
            num += 1;
        } else {
            num = listeTitulaireCompte.indexOf(0);

            for (TitulaireCompte t : listeTitulaireCompte) {
                if (t.getNumeroIdTitulaire() > num) {
                    num = t.getNumeroIdTitulaire();
                }
            }
            num++;
        }
        return num;
    }

    //Génération automatique du numéro de compte
    public static int genererNumeroCompte() {
        int num = 0;
        if (listeCompte.isEmpty()) {
            num = 1;
        } else {
            num = listeCompte.indexOf(0);

            for (Compte t : listeCompte) {
                if (t.getNumeroCompte() > num) {
                    num = t.getNumeroCompte();
                }
            }
            num++;
        }
        return num;
    }

    //Génération automatique du numéro de la transaction
    public static int genererNumeroTransaction() {
        int num = 0;
        if (listeTransactions.isEmpty()) {
            num = 1;
        } else {
            num = listeTransactions.indexOf(0);
            for (Transaction t : listeTransactions) {
                if (t.getNumeroTransaction() > num) {
                    num = t.getNumeroTransaction();
                }
            }
            num++;
        }
        return num;
    }

    //Afficher la liste des comptes
    private static void listerComptes() {
        System.out.print("\n\n~~~LISTE DES COMPTES~~~\n\n");
        System.out.print("\n\n~~~LISTE TITULAIRE DES COMPTES~~~\n\n");
        String leftAlignFormat = "| %-9s | %-29s | %-29f | %-29f |%n";

        System.out.format("+-----------+-------------------------------+-------------------------------+-------------------------------+%n");
        System.out.format("| Numero ID |          Nom titulaire        |          Montant              |   Taux d'interet en           |%n");
        System.out.format("+-----------+-------------------------------+-------------------------------+-------------------------------+%n");
        for (Compte tt : listeCompte) {
            System.out.format(leftAlignFormat,tt.getNumeroCompteString(),tt.getTitulaireCompte().getNomTitulaire(),tt.getSoldeCompte(),tt.getTauxInteret());
            System.out.format("|-----------|-------------------------------|-------------------------------|-------------------------------|%n");
        }
       /* for (Compte cc : listeCompte) {
            System.out.println("Le numero de compte = " + cc.getNumeroCompteString()
                    + "; Nom titulaire : " + cc.getTitulaireCompte().getNomTitulaire()
                    + " ; le numero d'identification = " + cc.getTitulaireCompte().getNumeroIdTitulaire()
                    + " ; le montant = " + cc.getSoldeCompte()
                    + " et le taux d'interet = " + cc.getTauxInteret() + "%");
        }*/
        entree = 0;
    }

    //Affiche la liste des clients
    private static void listerClients() {
        System.out.print("\n\n~~~LISTE TITULAIRE DES COMPTES~~~\n\n");
        String leftAlignFormat = "| %-9d | %-31s |%n";

        System.out.format("+-----------+---------------------------------+%n");
        System.out.format("| Numero ID |          Nom titulaire          |%n");
        System.out.format("+-----------+---------------------------------+%n");
        for (TitulaireCompte tt : listeTitulaireCompte) {
            System.out.format(leftAlignFormat,tt.getNumeroIdTitulaire(),tt.getNomTitulaire());
            System.out.format("|-----------|---------------------------------|%n");
        }
        /*for (TitulaireCompte tt : listeTitulaireCompte) {
            System.out.println("Numero identifiant titulaire : " + tt.getNumeroIdTitulaire()
                    + ",Nom titulaire : " + tt.getNomTitulaire());
        }*/
        entree = 0;
    }

    //verification du titulaire dans la liste
    public static TitulaireCompte titulaireIsExist(int num) {
        for (TitulaireCompte tt : listeTitulaireCompte) {
            if (num == tt.getNumeroIdTitulaire()) {
                return tt;
            }
        }
        return null;
    }

    //verification du titulaire dans la liste
    public static Compte compteIsExistt(int num) {
        for (Compte cc : listeCompte) {
            if (num == cc.getNumeroCompte()) {
                return cc;
            }
        }
        return null;
    }

    //liste des transactions pour un compte
    public static List<Transaction> transactionsByCompte(int num) {
        List<Transaction> l = new ArrayList<>();
        for (Transaction t : listeTransactions) {
            if (num == t.getCompte().getNumeroCompte()) {
                l.add(t);
            }
        }
        return l;
    }

    //depôt sur un compte
    private static void depotSurCompte() {
        Transaction transaction = new Transaction();
        System.out.println("Entrez le numéro du compte");
        verificationTypeDeDonneeNombre(1);
        int numCompte = sc.nextInt();
        double montantTransaction;
        Compte c = compteIsExistt(numCompte);
        if (c == null) {
            System.out.println("Ce compte n'existe pas");
            menuTransaction();
            int numMenu = sc.nextInt();
            transactionOptions(numMenu);
            vericationDeLaSaisie(1, 3);
        } else {
            transaction.setCompte(c);
            transaction.setDateTransaction(new Date());
            System.out.println("Montant à déposer");
            montantTransaction = sc.nextDouble();
            System.out.print("Voulez-vous enregistrer ce compte?\t1 : OUI\t2 : NON\n");
            vericationDeLaSaisie(1, 2);
            entree = sc.nextInt();
            if (entree == 1) {

                transaction.setMontantTransaction(montantTransaction);
                transaction.setNumeroTransaction(genererNumeroTransaction());
                transaction.setTypeTransaction(TYPE_DEPOT);
                updateCompte(transaction);
                //System.out.print("Opération enregistrée\n");
            } else {
                System.out.print("Opération annulée\n");
            }
            entree = 0;

        }
    }

    //retrait sur un compte
    private static void retraitSurCompte() {
        Transaction transaction = new Transaction();
        System.out.println("Entrez le numéro du compte");
        verificationTypeDeDonneeNombre(1);
        int numCompte = sc.nextInt();
        double montantTransaction;
        Compte c = compteIsExistt(numCompte);
        if (c == null) {
            System.out.println("Ce compte n'existe pas");
            menuTransaction();
            int numMenu = sc.nextInt();
            transactionOptions(numMenu);
            vericationDeLaSaisie(1, 3);
        } else {
            transaction.setCompte(c);
            System.out.println("Montant à retirer");
            montantTransaction = sc.nextDouble();
            System.out.print("Voulez-vous enregistrer ce compte?\t1 : OUI\t2 : NON\n");
            vericationDeLaSaisie(1, 2);
            entree = sc.nextInt();
            if (entree == 1) {
                transaction.setDateTransaction(new Date());
                transaction.setMontantTransaction(montantTransaction);
                transaction.setNumeroTransaction(genererNumeroTransaction());
                transaction.setTypeTransaction(TYPE_RETRAIT);
                updateCompte(transaction);
                

            } else {
                System.out.print("Opération annulée\n");
            }
            entree = 0;

        }
    }

    //ajout de transaction
    public static void addTransaction(Transaction t) {
        listeTransactions.add(t);

    }

    //Mise à jour des comptes
    public static void updateCompte(Transaction t) {
        //mise à jour du compte 
        for (Compte cc : listeCompte) {
            if (cc.getNumeroCompte() == t.getCompte().getNumeroCompte()) {
                switch (t.getTypeTransaction()) {
                    case "depot":
                        System.out.println("------- déposer un montant de "
                                + t.getMontantTransaction() + " Euros pour le compte "
                                + t.getCompte().getNumeroCompteString()
                                + " au " + t.getDateTransaction());

                        addTransaction(t);
                        cc.setSoldeCompte(cc.getSoldeCompte()
                                + t.getMontantTransaction());
                        System.out.print("Opération enregistrée\n");
                        
                        break;
                    case "retrait":
                        System.out.println("------- retirer un montant de "
                                + t.getMontantTransaction() + " Euros pour le compte "
                                + t.getCompte().getNumeroCompteString()
                                + " au " + t.getDateTransaction());

                        if (cc.getSoldeCompte() >= t.getMontantTransaction()) {

                            addTransaction(t);
                            cc.setSoldeCompte(cc.getSoldeCompte()
                                    - t.getMontantTransaction());
                            System.out.print("Opération enregistrée\n");
                            break;
                        }
                        System.out.println("Le solde du compte est insuffisant "
                                + "pour faire ce retrait ");
                        break;
                }
                break;
            }
        }
    }

    //Liste de compte par titulaire
    public static void listCompteParTitulaire() {
        System.out.print("\n\n~~~RECHERCHER COMPTES D'UN TITULAIRE ~~~\n\n");
        System.out.println("Entrer le numéro d'identification du titulaire");
        int numeroIDTitulaire = sc.nextInt();
        TitulaireCompte ti = titulaireIsExist(numeroIDTitulaire);
        if (ti != null) {
            System.out.print("_______INFOS TITULAIRE_____ : \n");
            System.out.println("numéro =" + ti.getNumeroIdTitulaire()
                    + "nom =" + ti.getNomTitulaire());

            int nbCmpt = 0;
            for (Compte cc : listeCompte) {
                if (ti.getNumeroIdTitulaire() == cc.getTitulaireCompte().getNumeroIdTitulaire()) {

                    System.out.println("Nom titulaire : " + cc.getTitulaireCompte().getNomTitulaire()
                            + " ; le numero d'identification = " + cc.getTitulaireCompte().getNumeroIdTitulaire()
                            + "Le numero de compte = " + cc.getNumeroCompteString());
                    nbCmpt++;
                }
            }
        } else {
            System.out.println("Désolé ce compte n'existe pas !!");
        }
    }

    //Consulter solde compte
    public static void consulterCompte() {
        System.out.print("\n\n~~~CONSULTER SOLDE COMPTE~~~\n\n");
        System.out.println("Numéro du compte à consulter: ");
        int numCompte = sc.nextInt();
        Compte cpt = compteIsExistt(numCompte);
        if (cpt == null) {
            System.out.println("Ce compte n'existe pas");
        } else {
            System.out.println("Le compte numéro =" + cpt.getNumeroCompteString()
                    + "; Titulaire nom= " + cpt.getTitulaireCompte().getNomTitulaire()
                    + "; Solde= " + cpt.getSoldeCompte());
        }

    }

    //Rapport comptes
    public static void rapportCompte() {
        System.out.print("\n\n~~~RAPPORT SUR LES COMPTES~~~\n\n");
        for (Compte cc : listeCompte) {
            System.out.println("___________________________________________________________________________________________");
            System.out.println("Le numero de compte = " + cc.getNumeroCompteString()
                    + "; Nom titulaire : " + cc.getTitulaireCompte().getNomTitulaire()
                    + " ; solde = " + cc.getSoldeCompte());
            List<Transaction> l = transactionsByCompte(cc.getNumeroCompte());
            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd MMMM yyyy", Locale.FRANCE);
//            DATE_FORMAT.format(listeTransactions.get(i).getDate());
            int i=0;
            if (l != null && !l.isEmpty()) {
                for (Transaction tr : l) {
                    System.out.println("Transaction = "
                            + tr.getTypeTransaction() + " de " 
                            + tr.getMontantTransaction() + "euros le " 
                            + DATE_FORMAT.format(l.get(i).getDateTransaction()));
                }
            } else {
                System.out.println("Aucune transaction éffectuée");
            }

        }

    }

    //Calcul intérêt sur compte et update compte
    public static void calculInteret() {
        System.out.print("\n\n~~~CALCUL D'INTERETS SUR LES COMPTES~~~\n\n");
        for (Compte cpt : listeCompte) {

            cpt.setSoldeCompte(cpt.getSoldeCompte() + cpt.getSoldeCompte() * cpt.getTauxInteret() * 0.01);
            System.out.println("Le numero de compte = " + cpt.getNumeroCompteString()
                    + "; Nom titulaire : " + cpt.getTitulaireCompte().getNomTitulaire()
                    + " ; le numero d'identification = " + cpt.getTitulaireCompte().getNumeroIdTitulaire()
                    + " ; le montant après TI= " + cpt.getSoldeCompte()
                    + " et le taux d'interet = " + cpt.getTauxInteret() + "%");
        }

    }
}
