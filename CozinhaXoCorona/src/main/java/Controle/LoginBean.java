package Controle;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import Entidade.Profissional;

@ManagedBean(name = "LoginBean")
@RequestScoped
public class LoginBean {

	Profissional profissional = new Profissional();

	private String usarioAdmin = "admin";
	private String senhaAdmin = "admin";
	private String usuarioAdm = "";
	private String senhaAdm = "";

	private static final String PESQUISAR = "pesquisarUsuario.xhtml";
//	private ProfissionalDAO profissionalDAO;
	private String mensagem;

	public LoginBean() {

	}

	public String entrar() {

		this.profissional.setNomePro(usuarioAdm);
		this.profissional.setSenhaLog(senhaAdm);

		System.out.println("lista profissionais inputs 1: " + this.profissional.getNomePro() + ", "
				+ this.profissional.getSenhaLog());

		if (this.usuarioAdm.equals(this.usarioAdmin) && this.senhaAdm.equals(this.senhaAdmin))

			try {

				FacesContext.getCurrentInstance().getExternalContext().redirect(PESQUISAR);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		else {

			if (this.usuarioAdm != null) {

				try {

					System.out.println("lista profissionais inputs 3: " + this.profissional.getNomePro() + ", "
							+ this.profissional.getSenhaLog());

					// this.profissional =
					// this.profissionalDAO.buscaProfissional(this.profissional);

					FacesContext.getCurrentInstance().getExternalContext().redirect(PESQUISAR);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {

				this.mensagem = "Profissional ou senha errada";

			}

		}
		return "input";

	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public static String getPesquisar() {
		return PESQUISAR;
	}

	public String getUsarioAdmin() {
		return usarioAdmin;
	}

	public void setUsarioAdmin(String usarioAdmin) {
		this.usarioAdmin = usarioAdmin;
	}

	public String getSenhaAdmin() {
		return senhaAdmin;
	}

	public void setSenhaAdmin(String senhaAdmin) {
		this.senhaAdmin = senhaAdmin;
	}

	public String getUsuarioAdm() {
		return usuarioAdm;
	}

	public void setUsuarioAdm(String usuarioAdm) {
		this.usuarioAdm = usuarioAdm;
	}

	public String getSenhaAdm() {
		return senhaAdm;
	}

	public void setSenhaAdm(String senhaAdm) {
		this.senhaAdm = senhaAdm;
	}

}
