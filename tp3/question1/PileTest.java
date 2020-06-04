package question1;

public class PileTest extends junit.framework.TestCase {
    
    private Pile p1;
    

    public void setUp() {
        p1 = new Pile();
        
    }

    public void test_Pile_capacite() {
        assertEquals(Pile.TAILLE_PAR_DEFAUT, p1.capacite());
    }
    
    public void test_Pile_empilerNull() throws Exception{
        try{
        Pile p = new Pile(3);
        p.empiler(null);
        assertEquals("[]",p.toString());
        
        p.empiler(1);
        p.empiler(2);
        p.empiler(3);
        }catch(NullPointerException e){
            fail();
        }
        catch(PilePleineException e){
            assertTrue(e instanceof question1.PilePleineException);
        }
        
    }

    public void test_Pile_estPleine() throws Exception {
        Pile p = new Pile(3);
        p.empiler(3);
        assertEquals(1, p.taille());
        p.empiler(2);
        assertEquals(2, p.taille());
        p.empiler(1);
        assertEquals(3, p.taille());

        
        assertEquals(true, p.estPleine());
        assertEquals(p.taille(), p.capacite());
        try {
            p.empiler(0);
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PilePleineException);
        }
    }

    public void test_Pile_sommet() throws Exception {
        Pile p = new Pile(3);
        assertEquals(true, p.estVide());

        p.empiler(new Integer(3));
        
        assertEquals(" depiler ?? ", new Integer(3), p.depiler());
        assertEquals(0, p.taille());
    }

    public void test_Pile_estVide() throws Exception {
        Pile p = new Pile(3);
        assertEquals(true, p.estVide());
        try {
            Object r = p.depiler();
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PileVideException);
        }
    }

    public void test_Pile_toString() throws Exception {
        Pile pile1 = new Pile(3);
        assertEquals("toString incorrect ? ", "[]", pile1.toString());
        pile1.empiler(4);
        assertEquals("toString incorrect ? ", "[4]", pile1.toString());
        pile1.empiler(5);
        assertEquals("toString incorrect ? ", "[5, 4]", pile1.toString());
        pile1.empiler(3);
        assertEquals("toString incorrect ? ", "[3, 5, 4]", pile1.toString());

    }

    public void test_Pile_TailleNegative() {
        Pile p = new Pile(-3);
        assertEquals(p.TAILLE_PAR_DEFAUT, p.capacite());

    }

    
    
    
}
