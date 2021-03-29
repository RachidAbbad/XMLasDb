package controller;

import model.Produit;
import service.DefaultServices;
import utils.XMLParser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AjouterProduit extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Traitement ajouter produit
        String code = req.getParameter("code");
        String nom = req.getParameter("nom");
        float prix = Float.parseFloat(req.getParameter("prix"));
        DefaultServices service = DefaultServices.getInstance();
        Produit newProduit = new Produit(code,nom,prix);
        if(service.add(newProduit))
            req.setAttribute("successMessage","Votre produit a été enregistrer avec succé");
        else
            req.setAttribute("errorMessage","Le produit avec ce code est déja existe");

        List<Produit> listProduits = service.getAll();
        req.setAttribute("listProduits", listProduits);
        req.setAttribute("title", "Liste du Produits");
        getServletContext().getRequestDispatcher("/App.jsp").forward(req, resp);
    }
}
