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
import view.IPrincipale;

/**
 *
 * @author jk
 */
public class ControllerGestCat implements ActionListener{
    private IGestCat vue;
   // private CategoriesDao categoriesDao;
    //private ProduitsDao produitsDao;

    
    public ControllerGestCat(IGestCat vue) {
        this.vue = vue;
        //this.categoriesDao = categoriesDao;
        //this.produitsDao = produitsDao;
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
            //go to main page (not functionnal)
             if( e.getSource() == vue.getjMenuIP()){
            IPrincipale p = new IPrincipale();
            p.setLocationRelativeTo(null);
            vue.setVisible(false);
            p.setVisible(true);
            
        }
        
    }
}
