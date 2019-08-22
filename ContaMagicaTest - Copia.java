import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContaMagicaTest {

	private ContaMagica cm;
	@Before
	void SetUp() {
		cm = new ContaMagica("Victor");
	}
	
	@Test
	void TestDepositoBasico1() {
		cm.Deposito((float)11000.50);
		double valor = cm.getSaldo();
		assertTrue(valor == (float)11000.50);
	}
	
	@Test
	void TestDepositoBasico2() {
		cm.Deposito(-1000);
		double valor = cm.getSaldo();
		assertTrue(valor == 0);
	}
	
	@Test
	void TestRetiradaBasico1() {
		cm.Deposito((float)5000.50);
		cm.Retirada((float)250.75);
		double valor = cm.getSaldo();
		assertTrue(valor == 5000.50 - 250.75);
	}
	
	@Test 
	void TestRetiradaBasico2(){
		cm.Retirada(14023);
		double valor = cm.getSaldo();
		assertTrue(valor == 0);
	}
	
	@Test
	void TestRetiradaBasico3() {
		cm.Deposito(500);
		cm.Retirada(-3000);
		double valor = cm.getSaldo();
		assertFalse(valor == 500-3000);
	}
	
	@Test
	void TestCategoria1() {
		assertTrue(Categorias.Silver == cm.getCategoria());
	}
	
	@Test
	void TestCategoria2() {
		cm.Deposito((float)100000.50);
		assertTrue(Categorias.Gold == cm.getCategoria());
	}
	
	@Test
	void TestCategoria3() {
		cm.Deposito((float)1000000.30);
		assertTrue(Categorias.Platinum == cm.getCategoria());
	}
	
	@Test
	void TestCategoria4() {
		cm.Deposito((float)1000000.50);
		cm.Retirada((float)700000.50);
		assertTrue(Categorias.Gold == cm.getCategoria());
	}
	
	@Test
	void TestCategoria5() {
		cm.Deposito((float)1000000.50);
		cm.Retirada((float)990000.50);
		assertTrue(Categorias.Silver == cm.getCategoria());
	}
	@Test
	void TestDepositoComp1() {
		cm.Deposito((float)3.50);
		double valor = cm.getSaldo();
		assertTrue(valor == 3.50);
	}
	@Test
	void TestDepositoComp2() {
		cm.Deposito(600000);
		cm.Deposito((float)1000.50);
		double valor = cm.getSaldo();
		assertTrue(valor == 600000 + (1000.50 * 1.01));
	}
	
	@Test
	void TestDepositoComp3() {
		cm.Deposito(1000000);
		cm.Deposito((float)10752.50);
		double valor = cm.getSaldo();
		assertTrue(valor == 1000000 + (10752.50 * 1.025));
	}
	
	@Test
	void TestDepositoComp4() {
		cm.Deposito(60000);
		cm.Deposito(1000000);
		cm.Deposito((float)10752.50);
		double valor = cm.getSaldo();
		assertTrue(valor == 60000 + (1000000 * 1.01) + (10752.50*1.025));
	}
	

}
