<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${produit == null}">
    <caption><h2>Ajouter Produit</h2></caption>
    <form action="/AjouterProduit" method="post">
</c:if>
<c:if test="${produit != null}">
    <caption><h2>Update Produit</h2></caption>
    <form action="update?id=<c:out value='${produit.code}'/>" method="post">
</c:if>
    <div class="form-group">
    <label for="exampleInputEmail1">Code :</label>
    <input value="<c:out value='${produit.code}'/>" type="text" class="form-control" id="exampleInputEmail1" name="code" aria-describedby="emailHelp" placeholder="Enter Code">
    </div>
    <div class="form-group">
    <label for="exampleInputNom">Nom :</label>
    <input value="<c:out value='${produit.nom}'/>" type="text" class="form-control" id="exampleInputNom" name="nom" aria-describedby="nomHelp" placeholder="Enter Nom">
    </div>
    <div class="form-group">
    <label for="exampleInputPrix">Code :</label>
    <input value="<c:out value='${produit.prix}'/>" type="text" class="form-control" id="exampleInputPrix" name="prix" aria-describedby="prixHelp" placeholder="Enter Prix">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    </form>

