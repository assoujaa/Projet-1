
public class TestBanque {

	public static void main(String[] args) {
		Banque B=new Banque("BP");
		B.Add(new CompteCourant(new Personne("AA","AA"),2000,1000));
		B.Add(new CompteCourant(new Personne("BB","BB"),3000,1500));
		B.Add(new CompteCourant(new Personne("CC","CC"),4000,2000));
		B.Lister();
		Compte c1=new Compte();
		c1.setNumero(2);
		B.Delete(c1);
		B.Lister();

	}

}
