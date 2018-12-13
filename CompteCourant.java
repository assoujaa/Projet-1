
public class CompteCourant extends Compte {
	private double montantDecouvertAutorise;
	
	public CompteCourant(){}
	
	public CompteCourant(Personne proprietaire, double solde, double dec){
		super(proprietaire, solde);
                montantDecouvertAutorise=dec ;
	}
        @Override
        public void retirer(double montant, String libelle) { //throws EMontantMinException{
            
		if(this.solde - montant  < -montantDecouvertAutorise  ){
		System.err.println("Découvert autorisé dépasé!!!!");return ;	
                    //throw new EMontantMinException("Découvert autorisé dépasé!!!!");
		}
	super.retirer(montant,libelle);
	}
	public void Virer(Compte Dest , double montant)
        {
            if(this.solde - montant  < -montantDecouvertAutorise  ){
		System.err.println("Découvert autorisé dépasé!!!!");return ;
            }
         if(montant >0 )
         {
             this.solde-=montant; Dest.setSolde(Dest.getSolde()+montant);
             this.getListeOperations().add(new Operation(montant, "DEBIT"));
             Dest.getListeOperations().add(new Operation(montant, Libelle.VIREMENT));
         }
         else
                System.err.println("Montant doit être positif!!!");
            
        }
	public double getMontantDecouvertAutorise() {
		return montantDecouvertAutorise;
	}

	public void setMontantDecouvertAutorise(double montantDecouvertAutorise) {
		this.montantDecouvertAutorise = montantDecouvertAutorise;
	}
	
	
}
