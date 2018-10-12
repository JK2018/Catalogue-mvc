/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ControllerGestCat;
import controller.ControllerGestProd;
import controller.ControllerMenu;
import java.util.ArrayList;
import java.util.List;
import static model.Connexion.getConnexion;
import view.IGestCat;
import view.IGestProd;
import view.IPrincipale;

/**
 *
 * @author jk
 */
public class BoutiqueMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      
        
       //getConnexion();
       
       // test add categ
       /*ategories cat = new Categories();
       cat.setNom_cat("high tech");
       CategoriesDao cDao = new CategoriesDao();
       cDao.addCategorie(cat);*/
       
       
       /* //test insert prod
       Produits prod = new Produits();
       prod.setNom_prod("tintin au chnouf");
       prod.setPrix(20);
       prod.setQuantite(1);
       prod.setRef_prod("TAC");
       ProduitsDao pDao = new ProduitsDao();
       pDao.addProduit(prod, 2);
*/
       
       
       //test update cat
        /*Categories cat = new Categories();
       cat.setNom_cat("Roman");
       cat.setId_cat(1);
       CategoriesDao cDao = new CategoriesDao();
       cDao.updateCategorie(cat);*/
        
        
        //test update prod
      /* Produits prod = new Produits();
       prod.setNom_prod("tintin au updated");
       prod.setPrix(0);
       prod.setQuantite(0);
       prod.setRef_prod("XXX");
       prod.setId_prod(4);
       ProduitsDao pDao = new ProduitsDao();
       pDao.updateProduit(prod);
       */
      
      
      //test delete cat
      /*CategoriesDao cDao = new CategoriesDao();
      cDao.deleteCategorie(1);*/
      
      //test get 1 cat
      /*CategoriesDao cDao = new CategoriesDao();
      Categories categorie = new Categories();
      categorie = cDao.getCategorie(4);
      System.out.println(categorie.getId_cat() +" - "+ categorie.getNom_cat());
     */
      
      //getall cat
     /*  List<Categories> catList = new ArrayList<>();
       CategoriesDao cDao = new CategoriesDao();
       catList = cDao.getAllCategories();
       for(Categories c : catList){
           System.out.println(c.getId_cat() +" - "+ c.getNom_cat());
       }*/
 
      //test delete prod
      /*ProduitsDao pDao = new ProduitsDao();
      pDao.deleteProduit(4);*/
      
      //getALL prod
      /*List<Produits>Lprod = new ArrayList<>();
ProduitsDao pDao = new ProduitsDao();
Lprod = pDao.getAllProduits();
System.out.println("ref - nom du produit - prix - qte - id");
for(Produits p : Lprod){
    System.out.println(p.getRef_prod() +" - "+ p.getNom_prod()+" - "+ p.getPrix()+" - "+ p.getQuantite()+" - "+ p.getId_prod());
}*/
      
      //test get 1 prod
     /* ProduitsDao pDao = new ProduitsDao();
      Produits produit = new Produits();
      produit = pDao.getProduit(6);
      System.out.println(produit.getRef_prod() +" - "+ produit.getNom_prod()+" - "+ produit.getPrix()+" - "+ produit.getQuantite()+" - "+ produit.getId_prod());
    */
     IPrincipale p = new IPrincipale();
        p.setLocationRelativeTo(null);
        p.setVisible(true);
        
        
    IGestCat catM = new IGestCat();
    
     //IGestProd prodM = new IGestProd();
     CategoriesDao cDao = new CategoriesDao();
     ProduitsDao pDao = new ProduitsDao();
     ControllerMenu contM = new ControllerMenu(p,cDao,pDao);
     ControllerGestCat contC = new ControllerGestCat(catM);
     //ControllerGestProd contP = new ControllerGestProd(prodM,cDao,pDao);
     
  
     //mainFrame
    p.getjMenuGC().addActionListener(contM);
    p.getjMenuGD().addActionListener(contM);
    
    //gestCat
    catM.getjMenuIP().addActionListener(contC);
    
    //gestProd
   //prodM.getjMenuIP().addActionListener(contP);
     
     
     
   
     
    }
}
