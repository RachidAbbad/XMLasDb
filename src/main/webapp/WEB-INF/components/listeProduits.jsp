<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<caption><h2>Liste des Produits</h2></caption>
<table class="table table-striped table-dark">
    <tr>
        <th scope="col">Code</th>
        <th scope="col">Nom</th>
        <th scope="col">Prix</th>
        <th scope="col">Operations</th>
    </tr>
    <c:forEach var="produit" items="${listProduits}">
        <tr>
            <td scope="row"><c:out value="${produit.code}" /></td>
            <td><c:out value="${produit.nom}" /></td>
            <td><c:out value="${produit.prix}" /></td>
            <td>
                <a class="btn btn-primary" href="/edit?id=<c:out value='${produit.getCode()}'/>">Edit</a>
                <a class="btn btn-danger"  href="/delete?id=<c:out value='${produit.getCode()}'/>">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
