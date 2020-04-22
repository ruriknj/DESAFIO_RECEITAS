package Controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Entidade.Profissional;
import Entidade.Receita;
import dao.ProfissionalDAO;
import dao.ProfissionalDAOImp;
import util.EntityManagerUtil;

@ManagedBean(name = "ProfissionalBean")
@SessionScoped
public class ProfissionalBean {

	private Profissional profissional;
	private Receita receita;
	private ProfissionalDAO profissionalDAO;
	private long idSelecionado;
	private List<Profissional> listaProfissional;

	public ProfissionalBean() {

		this.profissional = new Profissional();
		this.profissional.setReceitas(new ArrayList<Receita>());
		this.receita = new Receita();
		this.listaProfissional = new ArrayList<Profissional>();
		this.profissionalDAO = new ProfissionalDAOImp(EntityManagerUtil.getEntityManager());
		this.listaProfissional = this.profissionalDAO.lista();
	}

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void pesquisar() {

		this.listaProfissional = this.profissionalDAO.lista();

		System.out.println("Entrou PEsquisar ====");
		System.out.println(this.listaProfissional);
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void salva() {

		try {

			this.profissionalDAO.cria(this.profissional);

			System.out.println("Salvous: " + this.profissional);

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Sucesso !!!"));

			abrirPerquisarProfissional();

		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Erro ao inserir !!!"));
		}
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void adicionaRceita() {

		if (!this.existeReceita(receita)) {

			Receita receitanova = new Receita();

			receitanova.setNomeRec(this.receita.getNomeRec());
			receitanova.setIngrediente(this.receita.getIngrediente());
			receitanova.setQuantidade(this.receita.getQuantidade());
			receitanova.setDescricao(this.receita.getDescricao());
			// +++++++++++++++++++++++++++++++++++++++++++++++
			receitanova.setProfissional(this.profissional);
			this.profissional.getReceitas().add(receitanova);
			// +++++++++++++++++++++++++++++++++++++++++++++++
			this.receita = new Receita();

		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Receita já existe !!!"));
		}
	}

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private boolean existeReceita(Receita receita) {
		boolean retorno = false;

		for (Receita recLista : this.profissional.getReceitas()) {

			if (recLista.getNomeRec().equals(receita.getNomeRec())) {
				retorno = true;
			}
		}
		return retorno;
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void limpa() {
		this.listaProfissional = new ArrayList<Profissional>();
		this.profissional = new Profissional();
		this.profissional.setReceitas(new ArrayList<Receita>());
		this.receita = new Receita();
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void abrirPerquisarProfissional() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("pesquisarUsuario.xhtml");
	}

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void abrirManterProfissional() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("manterUsuario.xhtml");
	}

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void edita() throws IOException {
		Profissional profissionalEdicao = this.profissionalDAO.pesquisar(idSelecionado);

		this.profissional = profissionalEdicao;

		abrirManterProfissional();
	}

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public String remove() {
		Profissional profissionalRemocao = this.profissionalDAO.pesquisar(idSelecionado);
		this.profissionalDAO.delete(profissionalRemocao);
		this.listaProfissional = this.profissionalDAO.lista();
		return "";
	}

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	public List<Profissional> getListaProfissional() {
		return listaProfissional;
	}

	public void setListaProfissional(List<Profissional> listaProfissional) {
		this.listaProfissional = listaProfissional;
	}

	public ProfissionalDAO getProfissionalDAO() {
		return profissionalDAO;
	}

	public void setProfissionalDAO(ProfissionalDAO profissionalDAO) {
		this.profissionalDAO = profissionalDAO;
	}

	public long getIdSelecionado() {
		return idSelecionado;
	}

	public void setIdSelecionado(long idSelecionado) {
		this.idSelecionado = idSelecionado;
	}

}
