package banque;

public class ComptePlacement extends CompteCredit{

	public ComptePlacement(double sol, personne p) {
		super(sol, p);
	}
	
	@Override
	public Boolean crediter(double money)
	{
		System.out.println("on ne peut pas ajouter de l'argent");
		return false;
	}
	@Override
	public Boolean debiter(double money)
	{
		System.out.println("deit impossible");
		return false;
	}
	@Override
	public Boolean virement(Compte c,double money)
	{
		System.out.println("virement impossible");
		return false;
	}
	
	@Override
	   public void afficher()
	   {
	       System.out.println("Compte Placement");
	       super.afficher();
	   }
}
