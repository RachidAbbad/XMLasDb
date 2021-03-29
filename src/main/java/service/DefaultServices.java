package service;

import dao.ProduitDao;
import dao.ProduitXmlDao;
import model.Produit;

import java.util.List;

public class DefaultServices implements Services{

    private ProduitDao produitDao;
    private static DefaultServices instance=null;
    public static DefaultServices getInstance()
    {
        if(instance==null)
            instance=new DefaultServices();
        return instance;
    }
    private DefaultServices() {
        this.produitDao=new ProduitXmlDao();
    }
    @Override
    public boolean add(Produit produit) {
        return produitDao.add(produit);
    }

    @Override
    public List<Produit> getAll() {
        return produitDao.getAll();
    }

    @Override
    public boolean remove(String code) {
        return produitDao.remove(code);
    }

    @Override
    public boolean update(Produit p) {
        return produitDao.update(p);
    }

    @Override
    public Produit getProduit(String code) {
        return produitDao.getProduit(code);
    }

}
