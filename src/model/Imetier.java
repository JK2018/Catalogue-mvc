/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author jk
 */
public interface Imetier {
    
    
    public void addCategorie(Categories categorie);
    public void addProduit(Produits produit, int id_cat);
    
    public List<Categories> getAllCategories();
    public List<Produits> getAllProduits();
    
    public Categories  getCategorie(int id_cat);
    public Produits getProduit(int id_prod);
    
    public void deleteCategorie(int id_cat);
    public void deleteProduit(int id_prod);
    
    public void updateCategorie(Categories categorie);
    public void updateProduit(Produits produit);
    
    
    
}
