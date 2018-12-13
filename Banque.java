import java.util.Vector;

public class Banque {
	private Vector<Compte> LesComptes;
	private String Nom;
	
	public Banque(String Nom) {
		LesComptes=new Vector<Compte>();
		this.Nom=Nom;
	}

	public void Add(Compte c) {
		LesComptes.add(c);
		
	}
	public void Delete(Compte c) {
		LesComptes.remove(c);
	}
	public void Delete(int num) {
		Compte c=new Compte();
		c.setNumero(num);
		Delete(c);
	}
	public void Lister() {
		for(Compte c : LesComptes)
			System.out.println(c);
	}
}
