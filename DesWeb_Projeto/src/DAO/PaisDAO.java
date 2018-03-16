package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Pais;
import TO.PaisTO;

public class PaisDAO {

	
	ConnectionFactory c = new ConnectionFactory();
	public void criarPais(Pais p) {
		String sqlInsert = "INSERT INTO pais(nome, populacao, area) VALUES (?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		
		try (Connection conn = c.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, p.getNome());
			stm.setLong(2, p.getPopulacao());
			stm.setDouble(3, p.getArea());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if(rs.next()){
					p.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void carregar(Pais p) {
		String sqlSelect = "SELECT nome, populacao, area FROM pais WHERE pais.id_pais = ?";
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = c.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, p.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					p.setNome(rs.getString("nome"));p.setPopulacao(rs.getLong("populacao"));
					p.setArea(rs.getDouble("area"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
	}
	public void atualizar(Pais p) {
		String sqlUpdate = "UPDATE pais SET nome=?, populacao=?, area=? WHERE id_pais=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = c.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, p.getNome());
			stm.setLong(2, p.getPopulacao());
			stm.setDouble(3, p.getArea());
			stm.setInt(4, p.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void excluir(Pais p) {
		String sqlDelete = "DELETE FROM pais WHERE id_pais = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = c.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, p.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
		
}
