package dao;

import java.util.List;

import metier.entites.Produit;

public class TestDAO {

	public static void main(String[] args) {
		
		ProduitDaoImpl dao=new ProduitDaoImpl();
		/*Produit p1=dao.save(new Produit("HP OMEN",12000,3));
		Produit p2=dao.save(new Produit("HP Imprimante vs 6500",6000,2));
		Produit p3=dao.save(new Produit("HP Scanner HJ54650",8000,4));
		
		System.out.println(p1.toString());
		System.out.println(p1.toString());
		System.out.println(p1.toString());*/
		System.out.println("chercher un produit");
		List <Produit> produits=dao.produitsParMC("%OMEN%");
		for(Produit p:produits) {
			System.out.println(p.toString());
		}
		
	}

}
