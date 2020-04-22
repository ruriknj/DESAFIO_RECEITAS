package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import Entidade.Profissional;

public class ProfissionalDAOImp implements ProfissionalDAO {

	private EntityManager ent;

	public ProfissionalDAOImp(EntityManager ent) {

		this.ent = ent;
	}

	@Override
	public boolean cria(Profissional profissional) {

		try {

			System.out.println("Chegou lá");

			EntityTransaction tx = ent.getTransaction();
			tx.begin();

			ent.merge(profissional);
			tx.commit();
			ent.flush();
			ent.close();

			System.out.println("Usuario salvo com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();

		}
		return true;

	}

	@Override
	public void update(Profissional profissional) {
		System.out.println("Chegou lá");

		EntityTransaction tx = ent.getTransaction();
		tx.begin();

		ent.merge(profissional);
		tx.commit();

		System.out.println("Usuario salvo com sucesso!");

	}

	@Override
	public void delete(Profissional profissional) {

		EntityTransaction tx = ent.getTransaction();
		tx.begin();

		ent.remove(profissional);
		tx.commit();

	}

	@Override
	public Profissional findByName(String nomePro) {
		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public Profissional pesquisar(long id_pro) {

		Profissional profissional = ent.find(Profissional.class, id_pro);

		return profissional;

	}

	public List<Profissional> lista() {
		Query query = ent.createQuery("from Profissional u");

		@SuppressWarnings("unchecked")
		List<Profissional> profissionals = query.getResultList();

		return profissionals;
	}

}