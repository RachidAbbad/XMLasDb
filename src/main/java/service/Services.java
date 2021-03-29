package service;

import model.Produit;

import java.util.List;

public interface Services {

    public boolean add(Produit produit);
    public List<Produit> getAll();
    public boolean remove(String code);
    public boolean update(Produit p);

    public Produit getProduit(String code);

}
