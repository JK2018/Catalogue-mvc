/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.ControllerDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Categories;
import model.CategoriesDao;
import model.Produits;
import model.ProduitsDao;
import view.IGestCat;
import view.IGestProd;

/**
 *
 * @author jk
 */
public class ControllerDao implements ActionListener {

    private IGestCat catM;
    private IGestProd prodM;
    private CategoriesDao cDao;
    private ProduitsDao pDao;
    private static DefaultTableModel tableModel = new DefaultTableModel();

    public static DefaultTableModel getTableModel() {
        return tableModel;
    }

    //constructeur
    public ControllerDao(IGestCat catM, CategoriesDao cDao) {
        this.catM = catM;
        this.cDao = cDao;
    }

    /*      public ControllerDao(IGestProd prodM, ProduitsDao pDao) {
        this.prodM = prodM;
        this.pDao = pDao;
    }*/
    public ControllerDao(IGestCat catM, CategoriesDao cDao, ProduitsDao pDao) {
        this.catM = catM;
        this.cDao = cDao;
        this.pDao = pDao;
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void actionPerformed(ActionEvent e) {

        //ADD CAT
        if (e.getSource() == catM.getBtAddCat()) {
            Categories cat = new Categories();
            cat.setNom_cat(catM.getTxtNomCat().getText());
            cDao.addCategorie(cat);
            catM.getTxtNomCat().setText("");
            Object[] rowData = new Object[2];
            rowData[0] = cat.getNom_cat();
            rowData[1] = cat.getId_cat();
            tableModel.addRow(rowData);
        }
        //DEL CAT
        if (e.getSource() == catM.getBtDelCat()) {
            int i = catM.getjTable1().getSelectedRow();
            Categories cat = new Categories();
            cat.setId_cat(Integer.parseInt(catM.getTxtIdCat().getText()));
            cDao.deleteCategorie(cat.getId_cat());
            catM.getTxtNomCat().setText("");
            catM.getTxtIdCat().setText("");
            tableModel.removeRow(i);
        }

        //UPDATE CAT
        if (e.getSource() == catM.getBtUpdCat()) {
            int i = catM.getjTable1().getSelectedRow();
            Categories cat = new Categories();
            cat.setNom_cat(catM.getTxtNomCat().getText());
            cat.setId_cat(Integer.parseInt(catM.getTxtIdCat().getText()));
            cDao.updateCategorie(cat);
            catM.getTxtIdCat().setText("");
            catM.getTxtNomCat().setText("");
            tableModel.removeRow(i);
            Object[] rowData = new Object[2];
            rowData[0] = cat.getNom_cat();
            rowData[1] = cat.getId_cat();
            tableModel.addRow(rowData);
        }

        //BY ID CAT
        if (e.getSource() == catM.getBtIdCat()) {
            tableModel.setRowCount(0);
            int i = catM.getjTable1().getSelectedRow();
            Categories cat = new Categories();//pour le param de getCategorie
            Categories cat2 = new Categories();//pour stocker le return 
            cat.setId_cat(Integer.parseInt(catM.getTxtIdCat().getText()));// set le ID cat dans cat
            cat2 = cDao.getCategorie(cat.getId_cat()); //recup l objet retourné par le dao?
            Object[] colName = new Object[2];
            colName[0] = "nom cat";
            colName[1] = "id cat";
            tableModel.setColumnIdentifiers(colName);
            Object[] rowData = new Object[2];
            rowData[0] = cat2.getNom_cat();
            rowData[1] = cat2.getId_cat();
            tableModel.addRow(rowData);
            catM.getjTable1().setModel(tableModel);
            catM.getTxtNomCat().setText("");
            catM.getTxtIdCat().setText("");
            catM.deplacer(i);
        }

        //ALL CAT
        if (e.getSource() == catM.getBtAllCat()) {
            tableModel.setRowCount(0);
            int i = catM.getjTable1().getSelectedRow();
            Categories cat = new Categories();
            List<Categories> catList = new ArrayList();
            catList = cDao.getAllCategories();
            String col[] = {"Nom Catégorie", "ID Cat"};
            tableModel.setColumnIdentifiers(col);
            JTable table = new JTable(tableModel);
            for (Categories c : catList) {
                Object[] objs = {c.getNom_cat(), c.getId_cat()};
                tableModel.addRow(objs);
            }
            catM.getTxtNomCat().setText("");
            catM.getTxtIdCat().setText("");
            catM.getjTable1().setModel(tableModel);
            catM.deplacer(i);
        }

    }

}
