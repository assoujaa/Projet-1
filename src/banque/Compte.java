package banque;

public class Compte {
	
	private int idCompte;
	private personne per;
	private double solde = 0,decouvertMax = 800,debitMax = 1000;
	
	private static int nbCompte = 0;
	
	public Compte() {}
	public Compte(personne p,double Solde)
	{
		idCompte = ++nbCompte;
		per = p;
		solde = Solde;
	}
	public void setNum(int n)
	{
		idCompte = n;
	}
	
	
	public Compte(personne p,double Solde,double deb,double decvr)
	{
		this(p,Solde);
		decouvertMax = decvr;
		debitMax = deb;
	}
	
	public int getIdCompte() {
		return idCompte;
	}

	public personne getPers() {
		return per;
	}

	public double getSolde()
	{
		return solde;
	}
	
	public double getDecouvertMax() {
		return decouvertMax;
	}

	public double getDebitMax() {
		return debitMax;
	}

	public void setDecouvert(double dec)
	{
		decouvertMax = dec;
	}
	public void setDebit(double deb)
	{
		debitMax = deb;
	}
	
	public double Decouvert()
	{
		if(solde < 0)
			return -solde;
		return 0;
	}
	
	public Boolean aDecouvert()
	{
		if(solde < 0)
			return true;
		return false;
	}
	public Boolean crediter(double money)
	{
		if(money > 0)
		{
			solde += money;
			return true;
		}
		return false;
	}
	
	public Boolean debiter(double money)
	{
		if(money>0 && (solde-money>-decouvertMax) && (money<debitMax))
		{
			solde -= money;
			return true;
		}
		return false;
	}
	
	public Boolean virement(Compte c,double money)
	{
		if(c != null)
		{
			if(debiter(money) && c.crediter(money))
			{
				return true;
			}
		}
		return false;
	}
	
	public void afficher()
	{
		System.out.println("Numero du compte : "+idCompte);
		System.out.println("Nom du titulaire : "+per.getNom()+" "+per.getPrenom());
		System.out.println("Decouvert max autorise : "+decouvertMax+" DH.");
		System.out.println("Debit max autorise : "+debitMax+" DH.");
		System.out.println("Solde : "+solde+" DH.");
		if(aDecouvert())
			System.out.println("le compte est a decouvert.");
		System.out.println();
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return ((Compte) o).getIdCompte()==getIdCompte();
	}
	
	
}
