package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entites.Produit;

public class ProduitDaoImpl implements IProduitDao {

	@Override
	public Produit save(Produit p) {
		
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("INSERT INTO PRODUITS (DESIGNATION,PRIX,QUANTITE) VALUES(?,?,?)");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getquantite());
			ps.executeUpdate();
			PreparedStatement psSelect=connection.prepareStatement
					("SELECT MAX(ID) as MAX_ID FROM PRODUITS");
			ResultSet rs=psSelect.executeQuery();
			
			if(rs.next()) {
				p.setId(rs.getLong("MAX_ID"));
			}
			ps.close();
			//il faut pas fermer la connection en singleton
			//connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return p ;
	}
	@Override
	public List<Produit> produitsParMC(String mc) {
		List<Produit> produits=new ArrayList<>();
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM PRODUITS WHERE DESIGNATION LIKE ? ");
			ps.setString(1, mc);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Produit produit=new Produit();
				produit.setId(rs.getLong("ID"));
				produit.setDesignation(rs.getString("DESIGNATION"));
				produit.setPrix(rs.getDouble("PRIX"));
				produit.setquantite(rs.getInt("QUANTITE"));
				
				produits.add(produit);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return produits;
	}

	@Override
	public Produit getProduit(Long id) {
		Produit produit=null;
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("SELECT * FROM PRODUITS WHERE ID=? ");
			ps.setLong(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				produit=new Produit();
				produit.setId(rs.getLong("ID"));
				produit.setDesignation(rs.getString("DESIGNATION"));
				produit.setPrix(rs.getDouble("PRIX"));
				produit.setquantite(rs.getInt("QUANTITE"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return produit;
	}

	@Override
	public Produit update(Produit p) {
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("UPDATE  PRODUITS SET DESIGNATION=?,PRIX=?,QUANTITE=? WHERE ID=?");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getquantite());
			ps.setLong(4, p.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return p ;
	}

	@Override
	public void deleteProduit(Long id) {
		
		Connection connection=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement
					("DELETE FROM PRODUITS WHERE ID=?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		

	
		
	}

}
