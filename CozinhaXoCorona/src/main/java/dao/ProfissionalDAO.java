package dao;

import java.util.List;
import Entidade.Profissional;

public interface ProfissionalDAO {

	public boolean cria(Profissional profissional);

	public void update(Profissional profissional);

	public void delete(Profissional profissional);
	
	public Profissional pesquisar(long id_pro);

	public List<Profissional> lista();
	
	public Profissional findByName(String nomePro);

	

}
