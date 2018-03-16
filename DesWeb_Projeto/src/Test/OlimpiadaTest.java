package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Model.Olimpiada;
import Service.OlimpiadaService;

public class OlimpiadaTest {
	Olimpiada ol;
	OlimpiadaService oS;
	
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
		
		ol = new Olimpiada("V", 2017, id);
		
		System.out.println(ol);
		
		System.out.println(id);
	}
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		ol = new Olimpiada("V",2016, 1);
		oS.carregarOlimpiada(ol);assertEquals("testa inclusao", ol);
	}
	@Test
	public void test01Criar() {
		System.out.println("criar");
		oS.criarOlimpiada(ol);
		id = ol.getId();
		System.out.println(id);
		
		assertEquals("testa criacao", ol);
	}
	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		ol.setAno(999999);
		oS.atualizarOlimpiada(ol);
		oS.carregarOlimpiada(ol);
		assertEquals("testa atualizacao", ol);
	}

	
}
