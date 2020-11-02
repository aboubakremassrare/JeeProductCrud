package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IProduitDao;
import dao.ProduitDaoImpl;
import metier.entites.Produit;


@WebServlet(name="ControleurServlet",urlPatterns= {"*.aspx"})
public class ControleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IProduitDao metier;
	
	@Override
	public void init() throws ServletException {
		metier=new ProduitDaoImpl();
	}
       
    public ControleurServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Produit p;
		String designation;
		double prix;
		int quantite;
		ProduitModel model;
		List<Produit> produits;
		long id;
		String path=request.getServletPath();
		switch(path) {
		
			
		
			    case "/index.aspx":
			    	
					model=new ProduitModel();
					produits=metier.produitsParMC("%%");
					model.setProduits(produits);
					request.setAttribute("model", model);
					this.getServletContext().getRequestDispatcher("/WEB-INF/Produit/produit.jsp").forward(request, response);
				break;
				
			    case "/chercher.aspx":
			    	String motCle=request.getParameter("motcle");
				    model=new ProduitModel();
					model.setMotCle(motCle);
					produits=metier.produitsParMC("%"+motCle+"%");
					model.setProduits(produits);
					request.setAttribute("model", model);
					this.getServletContext().getRequestDispatcher("/WEB-INF/Produit/produit.jsp").forward(request, response);
				break;
				
			    case "/create.aspx":
			     	request.setAttribute("produit", new Produit());
					this.getServletContext().getRequestDispatcher("/WEB-INF/Produit/create.jsp").forward(request, response);
				break;
				
			    case "/saveProduit.aspx":
			    	if(request.getMethod().equals("POST")) {
			    		designation=request.getParameter("designation");
			    		prix=Double.parseDouble(request.getParameter("prix"));
			    		quantite=Integer.parseInt(request.getParameter("quantite"));
			    		p=metier.save(new Produit(designation,prix,quantite));
			    		request.setAttribute("produit", p);
			    		this.getServletContext().getRequestDispatcher("/WEB-INF/Produit/confirmation.jsp").forward(request, response);
			    	}
				break;
				
			    case "/supprimer.aspx":
			    	id=Long.parseLong(request.getParameter("id"));
			    	metier.deleteProduit(id);
			    	
			    	response.sendRedirect("index.aspx");
				break;
				
			    case "/edit.aspx":
			    	id=Long.parseLong(request.getParameter("id"));
			    	p=metier.getProduit(id);
			    	request.setAttribute("produit", p);
			    	this.getServletContext().getRequestDispatcher("/WEB-INF/Produit/editProduit.jsp").forward(request, response);
				break;
				
			    case "/updtaeProduit.aspx":
			    	if(request.getMethod().equals("POST")) {
			    		id=Long.parseLong(request.getParameter("id"));
			    		designation=request.getParameter("designation");
			    		prix=Double.parseDouble(request.getParameter("prix"));
			    		quantite=Integer.parseInt(request.getParameter("quantite"));
			    		p =new Produit(designation,prix,quantite);
			    		p.setId(id);
			    		metier.update(p);
			    		request.setAttribute("produit", p);
			    		response.sendRedirect("index.aspx");
			    	}
				break;
				
			    default:
			    	response.sendError(response.SC_NOT_FOUND);
				break;
		
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
