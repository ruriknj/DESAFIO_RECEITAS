package testeCRUD;

import java.util.ArrayList

import java.util.List;
import Entidade.Profissional;
import Entidade.Receita;
import dao.ProfissionalDAOImp;
import util.EntityManagerUtil;

public class TesteCRUD {

	//static String emailSelecionado;

	static List<Profissional> listaProfissional;
	
	static Receita receita = new Receita();
	
	static Profissional profissional = new Profissional();

	static ProfissionalDAOImp profissionalDAO = new ProfissionalDAOImp(EntityManagerUtil.getEntityManager());

	public static void main(String [] args) {

		//salvarTest();
		//removerTest();
		// alterarTest();
		pesquisarTest();

		// EntityManagerFactory entityManagerFactory =
		// Persistence.createEntityManagerFactory("cozinha");
		// EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Profissional pro = new Profissional();
		// Receita rec = new Receita();

		// static String emailSelecionado;

	}

	public static void salvarTest() {

		List<Profissional> listaProfissional;
		listaProfissional = new ArrayList<Profissional>();
		//user.setReceitas(new ArrayList<Receita>());
		//listaProfissional = profissionalDAO.lista();
		

		receita.setNomeRec("Bolo6");
		receita.setProfissional(profissional);
		receita.setIngrediente("6. massa, 2. ovos, manteiga, açucar, etc");
		receita.setQuantidade("6k, 12ovos");
		receita.setDescricao("misture6, depis2 faça isto, faca aquilo, etc");
		receita.setProfissional(profissional);
		profissional.getReceitas().add(receita);

		System.out.println(receita);

		profissional.setNomePro("teste6666");
		profissional.setSenhaLog("testew666");
		profissional.setEmail("teste666@com.br");

		profissionalDAO.cria(profissional);

		System.out.println("Lista de usuários: " + listaProfissional);

	}

	public static void pesquisarTest() {

		//Profissional user = new Profissional();
		
		listaProfissional = profissionalDAO.lista();

		//user.setReceitas(new ArrayList<Receita>());
		
		
		System.out.println("Entrou PEsquisar ====");
		System.out.println(listaProfissional);

	}
}
