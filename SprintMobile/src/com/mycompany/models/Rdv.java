/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author jasser
 */
public class Rdv {
    private int id;
    private String nom,prenom,specialite,meet;
    private String date;

    public Rdv() {
    }

    public Rdv(int id, String nom, String prenom, String specialite,String date, String meet ) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
       
        this.date = date; 
        this.meet = meet;
    }

    public Rdv(String nom, String prenom, String specialite, String date ,String meet) {
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        
        this.date = date;
        this.meet = meet;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getMeet() {
        return meet;
    }

    public String getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setMeet(String meet) {
        this.meet = meet;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Rdv{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", specialite=" + specialite + ", meet=" + meet + ", date=" + date + '}';
    }

  /*  public void setDate(String dateString) {
       this.date = date;
    }*/
    
   
    
}
