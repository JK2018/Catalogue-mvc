/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jk
 */
public class ProduitsDao implements Imetier {

    @Override
    public void addCategorie(Categories categorie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addProduit(Produits produit, int id_cat) {
        Connection conn =  Connexion.getConnexion();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO produits (ref_prod, nom_prod, prix, quantite, id_cat) VALUES (?, ?, ?, ?, ?);");
            ps.setString(1, produit.getRef_prod());
            ps.setString(2, produit.getNom_prod());
            ps.setInt(3, produit.getPrix());
            ps.setInt(4, produit.getQuantite());
            ps.setInt(5, id_cat);
            System.err.println("Added successfully");
            ps.executeUpdate();
            ps.close();
 //           Connexion.closeConnexion();
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
           ex.printStackTrace();
           
        }
        
    }

    @Override
    public List<Categories> getAllCategories() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produits> getAllProduits() {
        Connection conn =  Connexion.getConnexion();
        List<Produits> Lprod = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs;
            rs = st.executeQuery("SELECT * FROM produits");
            while(rs.next()){
                Produits produit = new Produits();
                Categories categorie = new Categories();
                produit.setId_prod(rs.getInt("id_prod"));
                produit.setNom_prod(rs.getString("nom_prod"));
                produit.setPrix(rs.getInt("prix"));
                produit.setQuantite(rs.getInt("quantite"));
                produit.setRef_prod(rs.getString("ref_prod"));
                //produit.setCategorie(categorie.setId_cat(rs.getInt("id_cat")));
                Lprod.add(produit);
            }
  //          System.out.println("Select all successfull");
            st.close();
 //           Connexion.closeConnexion(); 
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
           ex.printStackTrace(); 
        } return Lprod;
        
    }

    @Override
    public Categories getCategorie(int id_cat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produits getProduit(int id_prod) {
       Connection conn =  Connexion.getConnexion();
       Produits produit = new Produits();
       try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM produits WHERE id_prod=?;");
            ps.setInt(1, id_prod);
            ResultSet rs;
            rs = ps.executeQuery();
            if(rs.next()){
            produit.setId_prod(rs.getInt("id_prod"));
            produit.setNom_prod(rs.getString("nom_prod"));
            produit.setPrix(rs.getInt("prix"));
            produit.setQuantite(rs.getInt("quantite"));
            produit.setRef_prod(rs.getString("ref_prod"));
            }
  //          System.err.println("selectbyID successfull");
            ps.close();
//            Connexion.closeConnexion();
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
           ex.printStackTrace();
           
        } return produit;
       
       
    }

    @Override
    public void deleteCategorie(int id_cat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteProduit(int id_prod) {
        Connection conn =  Connexion.getConnexion();
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM produits WHERE id_prod=?;");
            ps.setInt(1, id_prod);
            System.err.println("Deleted successfully");
            ps.executeUpdate();
            ps.close();
    //        Connexion.closeConnexion();
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
           ex.printStackTrace();
           
        }
    }

    @Override
    public void updateCategorie(Categories categorie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateProduit(Produits produit) {
        Connection conn =  Connexion.getConnexion();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE produits SET ref_prod=?, nom_prod=?, prix=?, quantite=? WHERE id_prod=?;");
            ps.setString(1, produit.getRef_prod());
            ps.setString(2, produit.getNom_prod());
            ps.setInt(3, produit.getPrix());
            ps.setInt(4, produit.getQuantite());
            ps.setInt(5, produit.getId_prod());
            System.err.println("Updated successfully");
            ps.executeUpdate();
            ps.close();
//            Connexion.closeConnexion();
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
           ex.printStackTrace();
           
        }
    }
    
}
