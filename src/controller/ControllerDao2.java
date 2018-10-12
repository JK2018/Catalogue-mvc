/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
public class ControllerDao2 implements ActionListener {

    private IGestCat catM;
    private IGestProd prodM;
    private CategoriesDao cDao;
    private ProduitsDao pDao;
    private static DefaultTableModel tableModel = new DefaultTableModel();

    public static DefaultTableModel getTableModel() {
        return tableModel;
    }

    //constructeur
    /* public ControllerDao(IGestCat catM, CategoriesDao cDao) {
        this.catM = catM;
        this.cDao = cDao;
    }*/
    public ControllerDao2(IGestProd prodM, ProduitsDao pDao) {
        this.prodM = prodM;
        this.pDao = pDao;
    }

    public ControllerDao2(IGestCat catM, CategoriesDao cDao, ProduitsDao pDao) {
        this.catM = catM;
        this.cDao = cDao;
        this.pDao = pDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //ADD PROD
        if (e.getSource() == prodM.getBtAddProd()) {
            Produits prod = new Produits();
            Categories cat = new Categories();
            prod.setNom_prod(prodM.getTxtNomProd().getText());
            prod.setRef_prod(prodM.getTxtRefProd().getText());
            prod.setPrix(Integer.parseInt(prodM.getTxtPrixProd().getText()));
            prod.setQuantite(Integer.parseInt(prodM.getTxtQteProd().getText()));
            cat.setId_cat(Integer.parseInt(prodM.getTxtCatProd().getText()));
            prod.setCategorie(cat);
            pDao.addProduit(prod, cat.getId_cat());
            Object[] rowData = new Object[4];
            rowData[0] = prod.getRef_prod();
            rowData[1] = prod.getNom_prod();
            rowData[2] = prod.getPrix();
            rowData[3] = prod.getQuantite();
            tableModel.addRow(rowData);

        }

        //DEL PROD
        if (e.getSource() == prodM.getBtDelProd()) {
            int i = prodM.getjTable1().getSelectedRow();
            Produits prod = new Produits();
            prod.setId_prod(Integer.parseInt(prodM.getTxtIdProd().getText()));
            pDao.deleteProduit(prod.getId_prod());
            prodM.getTxtRefProd().setText("");
            prodM.getTxtNomProd().setText("");
            prodM.getTxtIdProd().setText("");
            prodM.getTxtQteProd().setText("");
            prodM.getTxtPrixProd().setText("");
            prodM.getTxtCatProd().setText("");
            tableModel.removeRow(i);

        }

        //UPDATE PROD
        if (e.getSource() == prodM.getBtUpdProd()) {
            int i = prodM.getjTable1().getSelectedRow();
            Produits prod = new Produits();
            prod.setNom_prod(prodM.getTxtNomProd().getText());
            prod.setRef_prod(prodM.getTxtRefProd().getText());
            prod.setPrix(Integer.parseInt(prodM.getTxtPrixProd().getText()));
            prod.setQuantite(Integer.parseInt(prodM.getTxtQteProd().getText()));
            prod.setId_prod(Integer.parseInt(prodM.getTxtIdProd().getText()));
            pDao.updateProduit(prod);
            tableModel.removeRow(i);
            Object[] rowData = new Object[5];
            rowData[0] = prod.getRef_prod();
            rowData[1] = prod.getNom_prod();
            rowData[2] = prod.getQuantite();
            rowData[3] = prod.getPrix();
            rowData[4] = prod.getId_prod();
            tableModel.addRow(rowData);
            prodM.getTxtRefProd().setText("");
            prodM.getTxtNomProd().setText("");
            prodM.getTxtIdProd().setText("");
            prodM.getTxtQteProd().setText("");
            prodM.getTxtPrixProd().setText("");
            prodM.getTxtCatProd().setText("");
        }

        //BY ID PROD
        if (e.getSource() == prodM.getBtIdProd()) {
            tableModel.setRowCount(0);
            int i = prodM.getjTable1().getSelectedRow();
            Produits prod = new Produits();
            Produits prod2 = new Produits();
            prod.setId_prod(Integer.parseInt(prodM.getTxtIdProd().getText()));
            prod2 = pDao.getProduit(prod.getId_prod());
            Object[] colName = new Object[6];
            colName[0] = "Ref Prod";
            colName[1] = "Nom Prod";
            colName[2] = "Quantité";
            colName[3] = "Prix";
            colName[4] = "ID";
            colName[5] = "N° Cat";
            tableModel.setColumnIdentifiers(colName);
            Object[] rowData = new Object[5];
            rowData[0] = prod2.getRef_prod();
            rowData[1] = prod2.getNom_prod();
            rowData[2] = prod2.getQuantite();
            rowData[3] = prod2.getPrix();
            rowData[4] = prod2.getId_prod();
            tableModel.addRow(rowData);
            prodM.getjTable1().setModel(tableModel);
            prodM.getTxtIdProd().setText("");
            prodM.deplacer(i);
        }

        //ALL PROD
        if (e.getSource() == prodM.getBtAllProd()) {
            tableModel.setRowCount(0);
            int i = prodM.getjTable1().getSelectedRow();
            Produits prod = new Produits();
            List<Produits> Lprod = new ArrayList();
            Lprod = pDao.getAllProduits();
            String col[] = {"Ref Prod", "Nom Prod", "Quantité", "Prix", "ID"/*, "Num Cat"*/};
            tableModel.setColumnIdentifiers(col);
            JTable table = new JTable(tableModel);
            for (Produits p : Lprod) {
                Object[] objs = {p.getRef_prod(), p.getNom_prod(), p.getQuantite(), p.getPrix(), p.getId_prod() /*, p.getCategorie().getId_cat()*/};
                tableModel.addRow(objs);
            }
            prodM.getTxtRefProd().setText("");
            prodM.getTxtNomProd().setText("");
            prodM.getTxtIdProd().setText("");
            prodM.getTxtQteProd().setText("");
            prodM.getTxtPrixProd().setText("");
            prodM.getTxtCatProd().setText("");
            prodM.getjTable1().setModel(tableModel);
            prodM.deplacer(i);

        }

    }

}
