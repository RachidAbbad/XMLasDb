package model;

public class Produit {

    public String code;
    public String nom;
    public Float prix;

    public Produit(){};

    public Produit(String code, String nom, Float prix) {
        this.code = code;
        this.nom = nom;
        this.prix = prix;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Float getPrix() {
        return prix;
    }
    public void setPrix(Float prix) {
        this.prix = prix;
    }
    @Override
    public String toString() {
        return "Produit [code=" + code + ", nom=" + nom + ", prix=" + prix + "]";
    }

}
