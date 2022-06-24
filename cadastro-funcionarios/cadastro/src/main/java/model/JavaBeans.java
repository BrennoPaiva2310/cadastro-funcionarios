package model;

public class JavaBeans {
	private int idfunc;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;

	public JavaBeans() {
		// TODO Auto-generated constructor stub
	}

	public JavaBeans(int idfunc, String nome, String cpf, String telefone, String email) {
		super();
		this.idfunc = idfunc;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
	}

	public int getIdfunc() {
		return idfunc;
	}

	public void setIdfunc(int idfunc) {
		this.idfunc = idfunc;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
