package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.Query;

public class DAO {
	// Paramentros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/dbfuncionario";
	private String user = "root";
	private String password = "bg231099";

	// Método de conexão

	private Connection conectar() {
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;

		} catch (Exception e) {
			System.out.println(e);
			return null;

		}

	}

	public void inserirFuncionario(JavaBeans func) {
		String insertQuery = "insert into funcionario(nome,cpf,telefone,email) values(?,?,?,?)";
		System.out.println("Chegou aqui");
		try {
			Connection con = conectar();

			PreparedStatement stmt = con.prepareStatement(insertQuery);

			stmt.setString(1, func.getNome());
			stmt.setString(2, func.getCpf());
			stmt.setString(3, func.getTelefone());
			
			System.out.println(func.getEmail());
			
			stmt.setString(4, "Sem email");
			if (func.getEmail().isEmpty()) {
				stmt.setString(4, "Sem Email");
			} else {
				stmt.setString(4, func.getEmail());
			}

			stmt.executeUpdate();

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList<JavaBeans> recuperaFuncionario() {
		String readQuery = "select *from funcionario order by idFunc";
		ArrayList<JavaBeans> contatos = new ArrayList<JavaBeans>();
		try {
			Connection con = conectar();

			PreparedStatement stmt = con.prepareStatement(readQuery);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String cpf = rs.getString(3);
				String telefone = rs.getString(4);
				String email = rs.getString(5);

				
				contatos.add(new JavaBeans(Integer.parseInt(idcon), nome, cpf, telefone, email));
			}

			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}
	
	public Connection deletar(JavaBeans func) {
		String readQuery = "delete from funcionario where idFunc=?";	
		try {
			
			Connection con = conectar();
			
			PreparedStatement stmt=  con.prepareStatement(readQuery);
			String id = Integer.toString(func.getIdfunc());
			stmt.setString(1, id);
			stmt.executeUpdate();
			con.close();
			return con;

		} catch (Exception e) {
			System.out.println(e);
			return null;

		}

	}
	


}
