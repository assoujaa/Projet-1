package banque;

public class personne {
	private String nom,prenom,titre,sexe;
	private int date_n,etat_civil;
	private personne conjoint = null;

	public void setSexe(String s)
	{
		sexe = s;
	}
	public String getSexe()
	{
		return sexe;
	}
	public void setNom(String n)
	{
		nom = n;
	}
	public String getNom()
	{
		return nom;
	}
	public void setPrenom(String p)
	{
		prenom = p;
	}
	public String getPrenom()
	{
		return prenom;
	}
	public void setTitre(String t)
	{
		titre = t;
	}
	public String getTitre()
	{
		return titre;
	}
	public void setDate(int d)
	{
		date_n = d;
	}
	public int getDate()
	{
		return date_n;
	}
	public void setConjoint(personne conj)
	{
		conjoint = conj;
	}
	public personne getConjoint()
	{
		return conjoint;
	}
	//marie = 1,celib = 0
	public void setEtat(int et)
	{
		etat_civil = et;
	}

	public int age(int d)
	{
		return d-date_n;
	}
	
	public String toString()
	{
		String ret = titre+". "+prenom+" "+nom+" est ne en "+date_n+", est ";
		String situa;
		if(etat_civil==1)
			situa = "marie";
		else
			situa = "celibataire";
		return ret+situa;
	}
	
	public void marier(personne p)
	{
		if(etat_civil==0 && p.etat_civil==0)
		{
			if((sexe.equals("M") && p.getSexe().equals("F")) || (sexe.equals("F") && p.getSexe().equals("M")))
			{
				etat_civil = 1;
				p.setEtat(1);
				conjoint = p;
				p.setConjoint(this);
				if(sexe.equals("F"))
				{
					titre = "Mme";
					nom = p.getNom()+" nee "+nom;
				}
				else if(p.getSexe().equals("F"))
				{
					p.setTitre("Mme");
					p.setNom(nom+" nee "+p.getNom());
				}
				
				System.out.println("felicitation !you are married!");
			}
			else
			{
				System.out.println("same sex mariage is not allowed");
			}
		}
		else
		{
			System.out.println("la polygamie est interdite");
		}
		
	}
	
	public void divorcer(personne p)
	{
		if(p.getConjoint()==this)
		{
			etat_civil = 0;
			p.setEtat(0);
			p.setConjoint(null);
			conjoint = null;
			if(sexe.equals("F"))
			{
				titre = "Mlle";
				nom = nom.substring(nom.lastIndexOf(" ")+1); 
			}
			else if(p.getSexe().equals("F"))
			{
				p.setTitre("Mlle");
				p.setNom(p.getNom().substring(p.getNom().lastIndexOf(" ")+1));
			}	
			System.out.println("felicitation !you are no longer married!");
		}
		else	
			System.out.println("you can't get a divorce cuz you aren't married!");
	}
}
