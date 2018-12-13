package banque;

public class CompteCredit extends Compte{
	
	private double tauxIntr = 0.05;
	
	public CompteCredit(double sol, personne p) {
		super(p, sol);
	}

	public CompteCredit(double sol, personne p,double taux) {
		super(p, sol);
		tauxIntr = taux;
	}

	public void setTaux(double t)
	{
		tauxIntr = t;
	}
	
	public double getTaux()
	{
		return tauxIntr;
	}
	
	public double interet()
	{
		return getSolde()*tauxIntr;
	}
	
	@Override
	   public void afficher()
	   {
	       System.out.println("Compte Credit");
	       super.afficher();
	       System.out.println("Taux d'interet: "+tauxIntr);
	       
	   }
}
