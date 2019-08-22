
public class ContaMagica {
	
	private String nome;
	private double  saldo;
	private Categorias categoria;
	public ContaMagica(String nome) {
		this.nome = nome;
		saldo = 0;
		categoria = Categorias.Silver;
	}
	
	public String getNomeCliente() {
		return nome;
	}
	
	public double getSaldo() 
	{
		return saldo;
	}
	
	public Categorias getCategoria() {
		return categoria;
	}
	
	public void Deposito(float valor) 
	{
		if(valor > 0) {
			saldo += valor * Multiplicador();
			verificaCategoria();
		}else throw new IllegalArgumentException();
	}
	public void Retirada(float valor) {
		if(saldo - valor >= 0 && valor > 0) {
			saldo -= valor;
			verificaCategoria();
		}else throw new IllegalArgumentException();
	}
	
	private double Multiplicador() {
		if(categoria == Categorias.Silver) return 1;
		else if(categoria == Categorias.Gold) return 1.01;
		else return 1.025;
	}
	
	private void verificaCategoria() {
		if(saldo < 50000) categoria = Categorias.Silver;
		else if (saldo >= 50000 && saldo < 200000) categoria = Categorias.Gold;
		else if (saldo >= 200000) categoria = Categorias.Platinum;
	}
	
}
