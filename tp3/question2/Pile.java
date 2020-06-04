package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author Remy Zakarian
 * @version 1.0 28-5-2020
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;

    public Pile(int taille) {
        // traiter le cas <=0
        
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.zone = new Object[taille];
        this.ptr = 0;
    }

    public Pile() {
        this(0);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        if(o == null || o.equals(null)){
            
        }else{
            this.zone[this.ptr] = o;
            this.ptr++;
        }
    }

    public Object depiler() throws PileVideException {
         if (estVide())
            throw new PileVideException();
        this.ptr--;
        return zone[ptr];
    }

    public Object sommet() throws PileVideException {
        // a completer
        if(estVide()) throw new PileVideException();
        
        return zone[ptr - 1];
    }

    public int capacite() {
        // a completer
        return zone.length;
    }

    public int taille() {
        // a completer
        return ptr ;
    }

    public boolean estVide() {
        
        return ptr == 0;
    }

    public boolean estPleine() {
      
        return ptr == zone.length;
    }

    public boolean equals(Object o) {
        if(o instanceof PileI){
        if(this.capacite() ==(int) ((PileI)o).capacite()){
            if(this.taille() == (int) ((PileI)o).taille()){
                if(this.toString().equals((String) ((PileI)o).toString() )){
                    return true;
                } return false;
            }
                 return false;
            
        }
            return false;
        }
     return false;
}

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        // a completer
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(zone[i].toString());
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}