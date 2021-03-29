package dao;

import java.util.List;

import model.Produit;

public interface ProduitDao {

    public boolean add(Produit produit);
    public List<Produit> getAll();
    public boolean remove(String code);
    public boolean update(Produit p);
    public Produit getProduit(String code);

}
