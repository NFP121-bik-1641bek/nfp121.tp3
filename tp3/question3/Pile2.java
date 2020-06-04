package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    
    private Stack<T> stk;
    
    private int capacite;

    private int ptr;
    
    
    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille){
         stk = new Stack<T>();
        if(taille <=0) capacite = CAPACITE_PAR_DEFAUT;
        else {capacite = taille;}
        ptr = 0;
    }

    public Pile2(){
       this(0);
    }
    public boolean estPleine(){
     if (ptr == capacite) return true;
        
        return false;
    
    }
    
    public boolean estVide(){
    return stk.empty();
    
    }
    
    public int taille(){
    
    return this.stk.size();
    
    
    }
    
    public int capacite(){
    
    return this.capacite;
    
    }
    
    public void empiler(T o) throws PilePleineException{
        if (estPleine())
            throw new PilePleineException();
        if(o == null || o.equals(null)){
           
        }else{
            
            
        this.stk.push(o);
        this.ptr++;
       }
    }

    public T depiler() throws PileVideException{
      if (estVide())
            throw new PileVideException();
        this.ptr--;
        return this.stk.pop();
    }

    public T sommet() throws PileVideException{
         if(estVide()) throw new PileVideException();
        return this.stk.peek();
    }

    
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
    
    
    
    // recopier ici toutes les autres méthodes
    // qui ne sont pas modifiées en fonction
    // du type des éléments de la pile

} // Pile2