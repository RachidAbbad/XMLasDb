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

public class ListeProduits extends HttpServlet {
    DefaultServices service;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        service = DefaultServices.getInstance();
        switch (action) {
            case "/delete":
                deleteProduits(req, resp);
                break;
            case "/edit":
                showEditForm(req, resp);
                break;
            case "/update":
                updateProduits(req, resp);
                break;
        }
        listProduits(req, resp);
        getServletContext().getRequestDispatcher("/App.jsp").forward(req, resp);
    }

    private void deleteProduits(HttpServletRequest req, HttpServletResponse resp) {
        List<Produit> listProduits = service.getAll();
        String code = req.getParameter("id");
        service.remove(code);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    private void listProduits(HttpServletRequest req, HttpServletResponse resp) {
        List<Produit> listProduits = service.getAll();
        req.setAttribute("listProduits", listProduits);
        req.setAttribute("title", "Liste du Produits");

    }
    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
        String code = req.getParameter("id");
        Produit produit = service.getProduit(code);
        req.setAttribute("produit",produit);
        req.setAttribute("title", "Update Produit");
    }
    private void updateProduits(HttpServletRequest req, HttpServletResponse resp) {
        List<Produit> listProduits = service.getAll();
        String code = req.getParameter("id");
        String nom = req.getParameter("nom");
        float prix = Float.parseFloat(req.getParameter("prix"));
        Produit newProduit = new Produit(code,nom,prix);
        if(service.update(newProduit))
            req.setAttribute("successMessage","Votre produit a été mise à jour avec succé");
        else
            req.setAttribute("errorMessage","Erreur durant mise à jour");
    }
}


