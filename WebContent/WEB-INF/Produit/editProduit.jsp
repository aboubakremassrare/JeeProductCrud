
<%@ include file="../Template/header.jsp" %>

			<div class="container col-md-8 col-xs-12 col-md-offset-2">
			   <div class="panel panel-primary">
			   
					    <div class="panel-heading">Saisir un produit</div>
					     <div class="panel-body">
					        <form action="updtaeProduit.aspx" method="post">
					        
					             <div class="form-group">
						             <input type="hidden" name="id" class="form-control" value="${produit.id}" required/>				             
						          </div>
					        
						         <div class="form-group">
						             <label class="control-label">Designation</label>
						             <input type="text" name="designation" class="form-control" value="${produit.designation}" required/>				             
						          </div>
						          
						          <div class="form-group">
						             <label class="control-label">Prix</label>
						             <input type="text" name="prix" class="form-control" value="${produit.prix}" required/>				             
						          </div>
						          
						          <div class="form-group">
						             <label class="control-label">Quantite</label>
						             <input type="text" name="quantite" class="form-control" value="${produit.quantite}" required/>				             
						           </div>
						          
						          <div>
						            <button type="submit" class="btn btn-primary" >Save</button>
						          </div>
						          
					        </form>
				      
					    </div>
			    </div>
			
			</div>
 


</body>
</html>