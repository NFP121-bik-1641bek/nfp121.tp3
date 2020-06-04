package question2;



import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile4 implements PileI, Cloneable {
	/** la liste des Maillons/Elements */
	private Maillon stk;
	/** la capacit� de la pile */
	private int capacite;
	/** le nombre */
	private int nombre;

	/**
	 * Classe interne "statique" contenant chaque �l�ment de la chaine c'est une
	 * proposition, vous pouvez l'ignorer !
	 */
	private static class Maillon implements Cloneable {
		private Object element;
		private Maillon suivant;

		public Maillon(Object element, Maillon suivant) {
			this.element = element;
			this.suivant = suivant;
		}

		public Maillon suivant() {
			return this.suivant;
		}

		public Object element() {
			return this.element;
		}

		public Object clone() throws CloneNotSupportedException {
			Maillon m = (Maillon) super.clone();
			m.element = element;
			return m;
		}
	}

	/**
	 * Cr�ation d'une pile.
	 * 
	 * @param taille
	 *            la taille de la pile, la taille doit �tre > 0
	 */
	public Pile4(int taille) {
		if (taille <= 0)
			taille = CAPACITE_PAR_DEFAUT;
		this.stk = new Maillon(null,null);
		this.capacite = taille;
		this.nombre = 0;
	}

	public Pile4() {
		this(PileI.CAPACITE_PAR_DEFAUT);
	}

	public void empiler(Object o) throws PilePleineException {
		if (estPleine())
			throw new PilePleineException();
		if(o != null){
		try{
		    Maillon stk1 = (Maillon) stk.clone();
		    
		    stk.element = o;
		    stk.suivant = stk1;
		    nombre++;
		    System.out.println(stk.element);
		    System.out.println(stk.suivant());
		  }catch(Exception e){}
	}}

	public Object depiler() throws PileVideException {
		if (estVide())
			throw new PileVideException();
		// � compl�ter
		Object elem = stk.element;
		stk = stk.suivant();
		this.nombre--;
		return elem;
	}

	public Object sommet() throws PileVideException {
		if (estVide())
			throw new PileVideException();
		return stk.element;
	}

	/**
	 * Effectue un test de l'�tat de la pile.
	 * 
	 * @return vrai si la pile est vide, faux autrement
	 */
	public boolean estVide() {
		if (stk.element == null && this.nombre == 0) return true;
                return false;	
}

	/**
	 * Effectue un test de l'�tat de la pile.
	 * 
	 * @return vrai si la pile est pleine, faux autrement
	 */
	public boolean estPleine() {
		if (this.nombre == capacite) return true; // � compl�ter
                return false;	
}

	/**
	 * Retourne une repr�sentation en String d'une pile, contenant la
	 * repr�sentation en String de chaque �l�ment.
	 * 
	 * @return une repr�sentation en String d'une pile
	 */
	public String toString() {
//TO REVIEW
	    StringBuffer sb = new StringBuffer("[");
	    //while(stk.element != null && stk.suivant() != null){
	        
	    //       sb.append(stk.element);
	    //       stk = stk.suivant();
	           
	    //       sb.append(", ");
	       
	    //}
	    
	    if(stk.element == null) return "[]";
	    //System.out.println(stk.element);
	    //System.out.println(stk.suivant().element);
	    traverse(sb,stk);
	    
	    sb.append("]");
	    return sb.toString();   
	    
	    ///////////////////////////////////////////////////////////////////
	    
	    
	    
		//StringBuffer sb = new StringBuffer("[");
              //  for(int i = taille()-1 ; i >= 0 ; i--){
                  //  if(stk.suivant() != null){
                    
                   //     sb.append(stk.element);
                    
                   //     stk = stk.suivant();
                  //      if (i > 0)
                  //          sb.append(", ");
                  //  }
               // } 		
		// sb.append("]");
                // return sb.toString();
	}
	
	public void traverse(StringBuffer sb , Maillon a){
	   
	   if(a != null && a.suivant()  != null){
	   
	       
	       
	       sb.append(a.element.toString());
	       if(a.suivant().element != null){
	           sb.append(", ");
	       }
	       //System.out.println(sb);
	   
	       traverse(sb , a.suivant());
	   
        }}

	public boolean equals(Object o) {
		
			if(o instanceof PileI){
		 	 if(this.capacite() ==(int) ((PileI)o).capacite()){
                               if(this.taille() == (int) ((PileI)o).taille()){
                                     if(this.toString().equals((String) ((PileI)o).toString() )){
                                            return true;
                                     } return false;}
                               
                          }
                                return false;
                          
                        }
		return false;
	}

	public int capacite() {
		return this.capacite;
	}

	public int hashCode() {
		return toString().hashCode();
	}

	public int taille() {
		return nombre;
	}
}