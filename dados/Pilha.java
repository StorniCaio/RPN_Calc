package dados;
import java.util.ArrayList;
import java.util.List;
import dados.Numero.*;


public class Pilha{
    private List<Numero> dados;
    private Numero res;
    private int i;

    public Pilha(){
        dados = new ArrayList<>();
        i = 0;
        res = null;
    }

    public void push (Numero dado){
        dados.add(i,dado);
        i++;
    }

    public Numero pop(){
        try {
            res = dados.remove(i-1);
            i--;
            return res;
        }
        catch(IndexOutOfBoundsException e){
            return null;
        }

    }

    public int getIndice(){
        return i;
    }
    

    public void clean(){
        dados.clear();
        i = 0;
    }

    public boolean isEmpty(){
        return dados.isEmpty();
    }

    public Numero peek(){
        return dados.get(i-1);
    }
}