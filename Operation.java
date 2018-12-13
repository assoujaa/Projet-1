import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Operation {
	private double montant;
	private Date date;
	private Libelle libelle; 
	
	public Operation(double montant, Date date){
		this.montant = montant;
		this.date = date;
	}
	
	public Operation(double montant){
		this(montant, new Date());
	}
	public Operation(double montant, Libelle lib){
		this.montant = montant;
		this.libelle = lib;
		this.date = new Date();
	}
	public Operation(double montant, String libelle){
		this.montant = montant;
		this.libelle = Libelle.valueOf(libelle);
		this.date = new Date();
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Libelle getLibelle() {
		return libelle;
	}

	private void setLibelle(Libelle libelle) {
		this.libelle = libelle;
	}
	
	public String toString(){
		String timeStamp = new SimpleDateFormat("EEE MMM dd hh:mm:ss yyyy", Locale.FRANCE)
	            .format(date);
		return libelle + " - " + montant + " - " + timeStamp;
	}
	
	
	
}
