
public class CompteEpargne extends Compte {
	private double taux;
		
	public CompteEpargne(){ }
	public CompteEpargne(Personne proprietaire, double solde, double taux){
		super(proprietaire, solde);
		this.taux = taux;
	}
	
	public double calculInterets(){
//		this.solde *= taux;
		return this.solde * taux;
	}
	public void retirer(double montant, String libelle){
                //throws EMontantMinException{
		if(this.solde < montant ){
                    System.err.println("Solde Insuffisant !!!!");return ;
			//throw new EMontantMinException("Solde Insuffisant !!!!");
		}
		super.retirer(montant,libelle);
	}
	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	public String toString(){
		return super.toString() + "Taux : " + taux;
	}
}
