package Entidade;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RECEITA")
public class Receita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rec")
	private long idRec;
	private String nomeRec;
	private String ingrediente;
	private String quantidade;
	private String descricao;
	// private long id_pro;
	@ManyToOne
	@JoinColumn(name = "id_pro", referencedColumnName = "id_pro", nullable = false)
	Profissional profissional;

	public long getIdRec() {
		return idRec;
	}

	public void setIdRec(long idRec) {
		this.idRec = idRec;
	}

	public String getNomeRec() {
		return nomeRec;
	}

	public void setNomeRec(String nomeRec) {
		this.nomeRec = nomeRec;
	}

	public String getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	@Override
	public String toString() {
		return "Receita: " + nomeRec + ", " + "Ingrediente: " + ingrediente + ", " + "Quantidade: " + quantidade + ", "
				+ "Descricao: " + descricao;
	}

}