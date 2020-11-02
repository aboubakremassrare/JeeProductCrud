
<%@ include file="../Template/header.jsp" %>

			<div class="container col-md-8 col-xs-12 col-md-offset-2">
			   <div class="panel panel-primary">
			   
					    <div class="panel-heading">Saisir un produit</div>
					     <div class="panel-body">
					     
					     
				               <div class="form-group">
					              <label class="control-label">ID:</label>	
					               <label class="control-label">${produit.id}</label>			             
					            </div>
				
					        
						         <div class="form-group">
						             <label class="control-label">Designation</label>	
						              <label class="control-label">${produit.designation}</label>			             
						          </div>
						          
						          <div class="form-group">
						             <label class="control-label">Prix</label>
						              <label class="control-label">${produit.prix}</label>	
							             
						          </div>
						          
						          <div class="form-group">
						             <label class="control-label">Quantite</label>
						              <label class="control-label">${produit.quantite}</label>	
									             
						           </div>
						          
						
				      
					    </div>
			    </div>
			
			</div>
 


</body>
</html>