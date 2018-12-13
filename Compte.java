import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.text.SimpleDateFormat;

public class Compte {
	//static int MAX_DECOUVERT = 20;
	static int NUMERO_COMPTE = 0;
	boolean decouvert = true;
	private int numero;
	private Personne proprietaire;
	protected double solde;
	private Date dateOuverture;
	private List<Operation> listeOperations;
	private int hj;
	
	

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Compte(){
		numero = ++NUMERO_COMPTE;
		solde = 0;
		dateOuverture = new Date();
		listeOperations = new ArrayList<Operation>();
	}
	
	public Compte(Personne proprietaire, double solde, Date dateOuverture){
		this.numero = ++NUMERO_COMPTE;
		this.proprietaire = proprietaire;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
		listeOperations = new ArrayList<Operation>();
	}
	
	public Compte(Personne proprietaire, double solde){
		this(proprietaire, solde, new Date());
	}
	
	public Compte(String nom, String prenom, double solde, Date dateOuverture){
		this(new Personne(nom, prenom), solde, dateOuverture);
	}
	
	public Compte(String nom, String prenom, double solde){
		this(new Personne(nom, prenom), solde, new Date());
	}
        public Compte(String nom, String prenom){
		this(new Personne(nom, prenom), 0, new Date());
	}
	public int getNumero() {
		return numero;
	}

	public Personne getProprietaire() {
		return proprietaire;
	}
	
	public void verser(double montant, String libelle){ //throws EMontantMinException{
            if(montant<0) {
                System.err.println("Montant doit être >0");return ;
            }
                //throw new EMontantMinException("Montant doit être >0");
		this.listeOperations.add(new Operation(montant, libelle));
		this.solde += montant;
	}
	
	public void retirer(double montant, String libelle){ // throws EMontantMinException{
		
		this.listeOperations.add(new Operation(montant, libelle));
		this.solde -= montant;
	}
	
        public void Virer(Compte Dest , double montant)
        {
            
        }
	public void Historique(int nombreOperations){
		System.out.println("Solde : " + solde);
		for(int i = listeOperations.size()-1; i >= 0 && nombreOperations > 0; --i, --nombreOperations){
			System.out.println(listeOperations.get(i));
                        
		}
	}
	
	public double getSolde() {
		return solde;
	}

	public Date getDateOuverture() {
		return dateOuverture;
	}

	public List getListeOperations() {
		return listeOperations;
	}

    public void setSolde(double solde) {
        this.solde = solde;
    }
	
	public String toString(){
		String timeStamp = new SimpleDateFormat("EEE dd MMM hh:mm:ss yyyy", Locale.FRANCE)
	            .format(dateOuverture);
		return "Numero : " + numero + "\nProprietaire : " 
					+ proprietaire + "\nSolde : " + solde + "\nDate d'ouverture : " + timeStamp + "\n";
	}

	

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Compte) {
			if(this.numero==((Compte)obj).getNumero()) {
				return true;
			}
			return false;
		}
			return false;
	}
	
	
}
