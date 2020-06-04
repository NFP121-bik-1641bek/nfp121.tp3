package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author Remy Zakarian
 * @version 1.0
 */
public class Pile3 implements PileI {

    private Vector<Object> v;

    public Pile3() {
        this(0);
    }

    public Pile3(int taille) {
        // traiter le cas <=0
        // à compléter
        
                if(taille <=0) v = new Vector<Object>(CAPACITE_PAR_DEFAUT);
                else {v = new Vector<Object>(taille);}
                
        
        
        
    }

    public void empiler(Object o) throws PilePleineException {
        // à compléter
        if (estPleine())
                    throw new PilePleineException();
                if(o == null || o.equals(null)){
            
        }else{
                
                this.v.add(o);
        }
        }

    public Object depiler() throws PileVideException {
        // à compléter
          if (estVide())
                      throw new PileVideException();
                     
                      Object last = v.elementAt(v.size()-1);
                      v.remove(v.size()-1);
                      return last;
        
    }

    public Object sommet() throws PileVideException {
        if(estVide()) throw new PileVideException();
        return v.elementAt(v.size()-1);
    }

    public int taille() {
        
        return v.size();
    }

    public int capacite() {
        
        return v.capacity();
    }

    public boolean estVide() {
        
        return v.isEmpty();
    }

    public boolean estPleine() {
        
        if (v.size() == v.capacity()) return true;
        return false;
        
    }

    public String toString() {
        // à compléter
                StringBuffer sb = new StringBuffer("[");
                 for (int i = v.size() - 1; i >= 0; i--) {
                    sb.append(this.v.elementAt(i).toString());
                    if (i > 0)
                    sb.append(", ");
                 }
                 sb.append("]");
                 return sb.toString();
    }

    public boolean equals(Object o) {
        if(o instanceof PileI){
         if(this.capacite() ==(int) ((PileI)o).capacite()){
            if(this.taille() == (int) ((PileI)o).taille()){
                if(this.toString().equals((String) ((PileI)o).toString() )){
                    return true;
                }
                return false;
            }
                 return false;
            
        }
            return false;
        
    }return false;
}

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}
