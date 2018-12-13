package banque;

import java.util.*;

public class Banque {

	
	Vector<Compte> bank = new Vector<Compte>();
	
	public Boolean creerCompte(int type,int solde,personne person)
	{
		if(type==0)
		{
			Compte c = new Compte(person,solde);
			bank.add(c);
			System.out.println("Compte ajouter.");
			return true;
		}
		if(type==1)
		{
			CompteCredit c = new CompteCredit(solde,person);
			bank.add(c);
			System.out.println("Compte credit ajouter.");
			return true;
		}
		if(type==2)
		{
			ComptePlacement c = new ComptePlacement(solde,person);
			bank.add(c);
			System.out.println("Compte placement ajouter.");
			return true;
		}
		return false;
	}
	
	public Boolean supprimerCompte(int num)
	{
		/*for(Compte c : bank)
		{
			if(c.getIdCompte() == num)
			{
				bank.remove(c);
				return true;
			}
		}
		return false;
		*/
		Compte c = new Compte();
		c.setNum(num);
		
		
		return bank.remove(c);
	}
	
	
	public Compte getCompte(int num)
	{
		/*for(Compte c : bank)
		{
			if(c.getIdCompte() == num)
			{
				return c;
			}
		}
		return null;
		
		*/
		Compte c = new Compte();
		c.setNum(num);
		int pos = bank.indexOf(c);
		if(pos==-1)
			return null;
		
		return bank.get(pos);
	}
	
	public Vector<Compte> rechercheCompte(String nom)
	{
		Vector<Compte> res = new Vector<Compte>();
		for(Compte c : bank)
		{
			if(c.getPers().getNom().equals(nom))
			{
				res.add(c);
			}
		}
		return res;
	}
	
	public void afficherSolde(String nom)
	{
		Vector<Compte> res = rechercheCompte(nom);
		for(Compte c : res)
			
		{
			//System.out.println("Numero compte : "+c.getIdCompte());
			//System.out.println("Solde : "+c.getSolde());
			System.out.println();
			c.afficher();
		}
	}
}
