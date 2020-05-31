package question2;



import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile4 implements PileI, Cloneable {
	/** la liste des Maillons/Elements */
	private Maillon stk;
	/** la capacité de la pile */
	private int capacite;
	/** le nombre */
	private int nombre;

	/**
	 * Classe interne "statique" contenant chaque élément de la chaine c'est une
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
	 * Création d'une pile.
	 * 
	 * @param taille
	 *            la taille de la pile, la taille doit être > 0
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
		
		
		    Maillon stk1 = stk;
		    
		    stk.element = o;
		    stk.suivant = stk1;
		    nombre++;
                
	}

	public Object depiler() throws PileVideException {
		if (estVide())
			throw new PileVideException();
		// à compléter
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
	 * Effectue un test de l'état de la pile.
	 * 
	 * @return vrai si la pile est vide, faux autrement
	 */
	public boolean estVide() {
		if (stk.element == null && this.nombre == 0) return true;
                return false;	
}

	/**
	 * Effectue un test de l'état de la pile.
	 * 
	 * @return vrai si la pile est pleine, faux autrement
	 */
	public boolean estPleine() {
		if (this.nombre == capacite) return true; // à compléter
                return false;	
}

	/**
	 * Retourne une représentation en String d'une pile, contenant la
	 * représentation en String de chaque élément.
	 * 
	 * @return une représentation en String d'une pile
	 */
	public String toString() {
//TO REVIEW
	    StringBuffer sb = new StringBuffer("[");
	    while(stk.element != null && stk.suivant() != null){
	        
	           sb.append(stk.element);
	          stk = stk.suivant();
	           
	               sb.append(", ");
	       
	    }
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

	public boolean equals(Object o) {
		
			
		 	 if(this.capacite() ==(int) ((PileI)o).capacite()){
                               if(this.taille() == (int) ((PileI)o).taille()){
                                     if(this.toString().equals((String) ((PileI)o).toString() )){
                                            return true;
                                     }else{ return false;}
                               }else{
                                      return false;
                               }
                          }else{
                                return false;
                          }
		 
		
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