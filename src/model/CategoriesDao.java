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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jk
 */
public class CategoriesDao implements Imetier{

    @Override
    public void addCategorie(Categories categorie) {
       Connection conn =  Connexion.getConnexion();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO categories (nom_cat) VALUES (?);");
            ps.setString(1, categorie.getNom_cat());
            ps.executeUpdate();
            ps.close();
  //          Connexion.closeConnexion();
            System.err.println("Added successfully");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
           ex.printStackTrace();
           
        }
    }

    @Override
    public void addProduit(Produits produit, int id_cat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Categories> getAllCategories() {
            Connection conn =  Connexion.getConnexion();
              List<Categories> catList = new ArrayList();
        try {
            Statement st = conn.createStatement();
            ResultSet rs;
            rs = st.executeQuery("SELECT * FROM categories");
            while(rs.next()){
            Categories c = new Categories();
          c.setNom_cat(rs.getString("nom_cat")); 
          c.setId_cat(rs.getInt("id_cat"));
          catList.add(c);
            }
//            Connexion.closeConnexion();
 //           System.err.println("get all successfull");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
           ex.printStackTrace(); 
        }
        return catList;
        
    }

    @Override
    public List<Produits> getAllProduits() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categories getCategorie(int id_cat) {
               Connection conn =  Connexion.getConnexion();
               Categories categorie = new Categories();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM categories WHERE id_cat=?;");
            ps.setInt(1, id_cat);
            ResultSet rs;
            rs = ps.executeQuery();
            if(rs.next()){
            categorie.setId_cat(rs.getInt("id_cat"));
            categorie.setNom_cat(rs.getString("nom_cat"));
            }
            ps.close();
//            Connexion.closeConnexion();
//            System.err.println("get by id successfull");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
           ex.printStackTrace(); 
        }
        return categorie;
        
    }

    @Override
    public Produits getProduit(int id_prod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCategorie(int id_cat) {
              Connection conn =  Connexion.getConnexion();
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM categories WHERE id_cat = ?;");
            ps.setInt(1, id_cat);
            ps.executeUpdate();
            ps.close();
//            Connexion.closeConnexion();
            System.err.println("Deleted successfully");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
           ex.printStackTrace();
           
        }
    }

    @Override
    public void deleteProduit(int id_prod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCategorie(Categories categorie) {
             Connection conn =  Connexion.getConnexion();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE categories SET nom_cat=? WHERE id_cat = ?;");
            ps.setString(1, categorie.getNom_cat());
            ps.setInt(2, categorie.getId_cat());
            ps.executeUpdate();
            ps.close();
 //           Connexion.closeConnexion();
            System.err.println("Updated successfully");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
           ex.printStackTrace();
           
        }
    }

    @Override
    public void updateProduit(Produits produit) {
   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
