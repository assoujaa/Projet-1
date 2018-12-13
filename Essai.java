
import java.util.Scanner;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Essai {
	public static void main(String[] args){
		Compte c;
		int n;
		Scanner reader = new Scanner(System.in);
		System.out.println("Entrer votre nom : ");
		String nom = reader.next();
		System.out.println("Entrer votre Prenom : ");
		String prenom = reader.next();
		Personne prop = new Personne(nom, prenom);
		do{
			System.out.println("Veuillez choisir le type du compte :"
                                + "\n 1-Epargne\n2-Courant");
			n = reader.nextInt();
		}while(n != 1 && n != 2);
		
		if(n == 1)
			c = new CompteEpargne(prop, 0, 0);
		else
			c = new CompteCourant(prop, 0,300);
		
		do{
			System.out.println("1 - Ajouter solde\n2 - Retirer\n"
                                + "3 - Voir le proprietaire\n 4 - Voir l'historique"
					+ "\n5 - Voir le solde\n 6 - Voir le compte\n"
                                + "7-Calculer les interets "+
                                "8-Virement \n"
                                + "\n0 - Exit");
			System.out.println("Entrer votre choix : ");
			int choix = reader.nextInt();
			switch (choix){
				case 1:
					System.out.print("Entrer un montant : ");
					double montant = reader.nextDouble();
					
                        { c.verser(montant, "CREDIT");
                              
                        }
					break;
				case 2:
					System.out.print("Entrer un montant : ");
						c.retirer(reader.nextDouble(), "DEBIT");
		
					break;
				case 3:
					System.out.println(c.getProprietaire());
					break;
				case 4:
					System.out.println("Nbre opérations ?");
					c.Historique(reader.nextInt());
					break;
				case 5:
					System.out.println("Le solde est : "+ c.getSolde());
					break;
				case 6:
					System.out.println(c);
					break;
				case 7:
					if(c instanceof CompteCourant){
						System.out.println("Impossible pour ce genre de compte");
						break;
					}
					double interets = ((CompteEpargne)c).calculInterets();
                                     
                                         c.verser(interets, "CREDIT");
             
					break;
                                case 8 : Compte D = new CompteCourant(new Personne("ALAMI","ALI"), 2500, 0.1);
                                         if(c instanceof CompteCourant){
                                             System.out.println("Montant à virer : ");
						c.Virer(D, reader.nextFloat());
						break;    }
                                        
				case 0:
					n = 0;
					break;
			}
		}while(n != 0);
		
		System.out.println("END");
		
		
		reader.close(); 

	}
}
