package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import Model.Pais;
import Service.PaisService;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaisTest {
	Pais pais;
	PaisService pp;
	static int id = 0;
	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete.
	 * Certifique-se também que sobrecarregou o equals na classe
	 * Pais.
	 * Certifique-se que a fixture pais1 foi criada no banco.
	 * Além disso, a ordem de execução dos testes é importante; por
	 * isso a anotação FixMethodOrder logo acima do nome desta classe
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		
		pais = new Pais(1, "Brasil", 200000000, 453.543 );
		
		System.out.println(pais);
		
		//System.out.println(id);
	}
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		Pais fixture = new Pais(1, "Brasil", 200000000, 453.543 );
		pp.carregarPais(fixture);
		assertEquals("testa inclusao", fixture);
	}
	@Test
	public void test01Criar() {
		System.out.println("criar");
		pp.criarPais(pais);
		id = pais.getId();
		System.out.println(id);
		
		assertEquals("testa criacao", pais);
	}
	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		pais.setPopulacao(999999);
		pp.atualizarPais(pais);
		pp.carregarPais(pais);
		assertEquals("testa atualizacao", pais);
	}
	
}