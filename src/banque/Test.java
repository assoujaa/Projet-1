package banque;


public class Test {

	public static void main(String[] args) {
		Banque b = new Banque();
		personne p1 = new personne();
		personne p2 = new personne();
		personne p3 = new personne();
		p1.setNom("ALAMI");
		p1.setPrenom("Mohamed");
		p1.setDate(1965);
		p1.setEtat(0);
		p1.setTitre("M");
		p1.setSexe("M");
		
		
		p2.setNom("el gaabouri");
		p2.setPrenom("basma");
		p2.setDate(1995);
		p2.setEtat(0);
		p2.setTitre("Mlle");
		p2.setSexe("F");
		
		p3.setNom("ALAMI");
		p3.setPrenom("aaaaa");
		p3.setDate(1975);
		p3.setEtat(0);
		p3.setTitre("M");
		p3.setSexe("M");
		
		b.creerCompte(1,5000,p1);
		b.creerCompte(0,500,p2);
		b.creerCompte(2,900,p3);
		b.afficherSolde("ALAMI");
		//b.afficherSolde("el gaabouri");
		
		b.supprimerCompte(3);
		System.out.println("********");
		
		b.afficherSolde("ALAMI");
		System.out.println("********#######");
		Compte a = b.getCompte(5);
		if(a==null)
			System.out.println("pas de compte");
		else a.afficher();;
		
		
	}

}
