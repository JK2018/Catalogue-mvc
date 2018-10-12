/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jk
 */
public class Categories {
    
    
    private int id_cat;
    private String nom_cat;
    private List<Produits> produits = new ArrayList<Produits>();
    
    
    

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public String getNom_cat() {
        return nom_cat;
    }

    public void setNom_cat(String nom_cat) {
        this.nom_cat = nom_cat;
    }

    public List<Produits> getProduits() {
        return produits;
    }

    public void setProduits(List<Produits> produits) {
        this.produits = produits;
    }

    
    
    
    
    
    
    
    
    public Categories() {
    }


    
    public Categories(int id_cat, String nom_cat) {
        this.id_cat = id_cat;
        this.nom_cat = nom_cat;
    }
    
    
    
    
    
    
    
    
    
}
