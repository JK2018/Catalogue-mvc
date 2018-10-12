/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.CategoriesDao;

import model.ProduitsDao;
import view.IGestCat;
import view.IGestProd;
import view.IPrincipale;

/**
 *
 * @author jk
 */
public class ControllerMenu implements ActionListener{
    
    //private IGestCat catM;
    //private IGestProd prodM;
    private IPrincipale vue;
    private CategoriesDao categoriesDao;
    private ProduitsDao produitsDao;

    public ControllerMenu(IPrincipale vue, CategoriesDao categoriesDao, ProduitsDao produitsDao) {
        //this.catM = catM;
        //this.prodM = prodM;
        this.vue = vue;
        this.categoriesDao = categoriesDao;
        this.produitsDao = produitsDao;
        
    }
    
    

  


 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //go to GestCat page
        if( e.getSource() == vue.getjMenuGC()){
            IGestCat catM = new IGestCat();
            catM.setLocationRelativeTo(null);
            vue.setVisible(false);
            catM.setVisible(true);
            
            //add listeners to all btns
            ControllerDao contDao = new ControllerDao(catM,this.categoriesDao);
            catM.getBtAddCat().addActionListener(contDao);
            catM.getBtDelCat().addActionListener(contDao);
            catM.getBtUpdCat().addActionListener(contDao);
            catM.getBtIdCat().addActionListener(contDao);
            catM.getBtAllCat().addActionListener(contDao);
            
            
        }
        
            //go to GestProd page
            if( e.getSource() == vue.getjMenuGD()){
            IGestProd prodM = new IGestProd();
            prodM.setLocationRelativeTo(null);
            vue.setVisible(false);
            prodM.setVisible(true);
            
            //add listeners to all btns
            ControllerDao2 contDao2 = new ControllerDao2(prodM,this.produitsDao);
            prodM.getBtAddProd().addActionListener(contDao2);
            prodM.getBtDelProd().addActionListener(contDao2);
            prodM.getBtUpdProd().addActionListener(contDao2);
            prodM.getBtIdProd().addActionListener(contDao2);
            prodM.getBtAllProd().addActionListener(contDao2);
            
        }
                
   
        
        
        
      
    }
}
