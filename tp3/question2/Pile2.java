package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par delegation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacite de la pile */
    private int capacite;

    private int ptr;
    /**
     * Creation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit etre > 0
     */
    public Pile2(int taille) {
        // prevoir le cas <=0
        // a completer
        stk = new Stack<Object>();
        if(taille <=0) capacite = CAPACITE_PAR_DEFAUT;
        else {capacite = taille;}
        ptr = 0;
    }

    // constructeur fourni
    public Pile2() {
        this(0);
    }

    public void empiler(Object o) throws PilePleineException {
         if (estPleine())
            throw new PilePleineException();
        this.stk.push(o);
        this.ptr++;
    }

    public Object depiler() throws PileVideException {
        // a completer
         if (estVide())
            throw new PileVideException();
        this.ptr--;
        return this.stk.pop();
        
    }

    public Object sommet() throws PileVideException {
        // a completer
        if(estVide()) throw new PileVideException();
        return this.stk.peek();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        // a completer
        return stk.empty();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        // a completer
        if (ptr == capacite) return true;
        
        return false;
    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
        String s = "[";
        // a completer
        
        Object arr[] = stk.toArray();
        StringBuffer sb = new StringBuffer();
        for(int i = arr.length - 1 ; i >=0 ; i--){
            sb.append(arr[i].toString());
            if (i > 0)
                sb.append(", ");
        
        }
        s = s + sb;
        return s + "]";
    }

    public boolean equals(Object o) {
        // a completer
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

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * Retourne le nombre d'element d'une pile.
     * 
     * @return le nombre d'element
     */
    public int taille() {
        // a completer
       return this.stk.size();
    }

    /**
     * Retourne la capacite de cette pile.
     * 
     * @return le nombre d'element
     */
    public int capacite() {
        // a completer
        return this.capacite;
    }

} // Pile2.java
