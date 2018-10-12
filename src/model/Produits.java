/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jk
 */
public class Produits {
    
    private int id_prod;
    private String ref_prod;
    private String nom_prod;
    private int prix;
    private int quantite;
    private Categories categorie;

    public Produits() {
    }

    public Produits(String ref_prod, String nom_prod, int prix, int quantite) {
        this.ref_prod = ref_prod;
        this.nom_prod = nom_prod;
        this.prix = prix;
        this.quantite = quantite;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getRef_prod() {
        return ref_prod;
    }

    public void setRef_prod(String ref_prod) {
        this.ref_prod = ref_prod;
    }

    public String getNom_prod() {
        return nom_prod;
    }

    public void setNom_prod(String nom_prod) {
        this.nom_prod = nom_prod;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Categories getCategorie() {
        return categorie;
    }

    public void setCategorie(Categories categorie) {
        this.categorie = categorie;
    }

    
    
    
    
    
    
    
    
}
