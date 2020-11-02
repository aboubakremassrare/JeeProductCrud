




<%@ include file="../Template/header.jsp" %>

			<div class="container col-md-10 col-md-offset-1">
			
			   <div class="panel panel-primary">
					    <div class="panel-heading">
					      Rechercher les produits
					    </div>
					     <div class="panel-body">
					       <form action="chercher.aspx" method="get">
					         <label for="">Mot Cle</label>
					         <input type="text" name="motcle" value="${model.motCle}"/>
					         <button type="submit" class="btn btn-primary" >chercher</button>
					       </form>
					       <table class="table table-striped">
					         <tr>
					           <th>ID</th>
					           <th>DESIGNATION</th>
					           <th>PRIX</th>
					           <th>QUANTITE</th>
					         </tr>
					                 
					       <c:forEach items="${model.produits}" var="p">
					         
					         <tr>
					           <td>${p.id}</td>
					           <td>${p.designation }</td>
					           <td>${p.prix}</td>
					           <td>${p.quantite}</td>
					           <td><a onclick="return confirm('Etes vous sure ?')" href="supprimer.aspx?id=${p.id}">Supprimer</a></td>
					           <td><a href="edit.aspx?id=${p.id}">Modifier</a></td>
					         </tr>
					         </c:forEach>
					       </table>
					    </div>
			    </div>
			
			</div>
 


</body>
</html>