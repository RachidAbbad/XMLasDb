package dao;

import model.Produit;

import java.util.List;

import utils.XMLParser;

public class ProduitXmlDao implements ProduitDao{
    public final String PATH="C:\\Users\\BIG CHOIX\\Desktop\\git\\XMLasDb\\data\\produits.xml";

    @Override
    public boolean add(Produit produit) {
        List<Produit> produits=XMLParser.lire(PATH, Produit.class);
        for (Produit p: produits) {
            if(p.getCode().equals(produit.getCode()))
                return false;
        }
        produits.add(produit);
        return XMLParser.ecrire(PATH, produits);
    }

    @Override
    public List<Produit> getAll() {
        return XMLParser.lire(PATH, Produit.class);
    }

    @Override
    public boolean remove(String code) {
        List<Produit> produits=XMLParser.lire(PATH, Produit.class);
        for (int i =0;i<produits.size();i++) {
            if(produits.get(i).getCode().equals(code)){
                produits.remove(i);
            }
        }
        return XMLParser.ecrire(PATH, produits);
    }

    @Override
    public boolean update(Produit produit) {
        List<Produit> produits=XMLParser.lire(PATH, Produit.class);
        for (Produit p: produits) {
            if(p.getCode().equals(produit.getCode())){
                p.setNom(produit.getNom());
                p.setPrix(produit.getPrix());
            }

        }
        return XMLParser.ecrire(PATH, produits);
    }


    @Override
    public Produit getProduit(String code) {
        List<Produit> produits=XMLParser.lire(PATH, Produit.class);
        for (Produit p: produits) {
            if(p.getCode().equals(code))
                return p;
        }
        return null;
    }

}
