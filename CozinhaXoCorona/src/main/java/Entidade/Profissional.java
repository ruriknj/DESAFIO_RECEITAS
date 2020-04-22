package Entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PROFISSIONAL")
public class Profissional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_pro;
	private String email;
	private String nomePro;
	private String senhaLog;
	@OneToMany(mappedBy = "profissional", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Receita> receitas;

	public String getNomePro() {
		return nomePro;
	}

	public void setNomePro(String nomePro) {
		this.nomePro = nomePro;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenhaLog() {
		return senhaLog;
	}

	public void setSenhaLog(String senhaLog) {
		this.senhaLog = senhaLog;
	}

	public List<Receita> getReceitas() {
		return receitas;
	}

	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
	}

	public long getId_pro() {
		return id_pro;
	}

	public void setId_pro(long id_pro) {
		this.id_pro = id_pro;
	}

	@Override
	public String toString() {
		return "\n" + "Profissional: " + nomePro + ", " + "Email: " + email + ", " +  "Senha: " + senhaLog + "\n"
				+ receitas + "\n";

	}

}
