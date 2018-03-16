package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Olimpiada;

public class OlimpiadaDAO {
	
	
	ConnectionFactory c = new ConnectionFactory();
	public void criarOlimpiada(Olimpiada p) {
		String sqlInsert = "INSERT INTO olimpiada(tipo, ano) VALUES (?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		
		try (Connection conn = c.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, p.getTipo());
			stm.setInt(2, p.getAno());
			stm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void carregarOlimpiada(Olimpiada p) {
		String sqlSelect = "SELECT tipo, ano FROM olimpiada WHERE olimpiada.ano = ?";
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = c.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, p.getAno());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					p.setTipo(rs.getString("tipo"));p.setAno(rs.getInt("ano"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
	}
	public void atualizarOlimpiada(Olimpiada p) {
		String sqlUpdate = "UPDATE olimpiada SET tipo=?, ano=? WHERE ano=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = c.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, p.getTipo());
			stm.setInt(2, p.getAno());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void excluirOlimpiada(Olimpiada p) {
		String sqlDelete = "DELETE FROM olimpiada WHERE ano = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = c.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, p.getAno());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
