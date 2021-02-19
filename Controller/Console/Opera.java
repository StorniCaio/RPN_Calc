package Controller.Console;
import dados.Numero.*;
import dados.Pilha;

public class Opera{

    private Pilha pilha;
    private Numero a, b;

    public Opera(Pilha _pilha){
        pilha =_pilha;
        a = null;
        b = null;
    }

    private void popNums(){
        a = pilha.pop();
        b = pilha.pop();
    }

    private void pushRes(){
        pilha.push(a);
        a = null;
        b = null;
    }

    void soma(){
        try{
        popNums();
        a.soma(a, b);
        pushRes();
        }
        catch(NullPointerException ex){
            pilha.push(a);
        }

    }   

    void diminui(){
        try{
            popNums();
            a.diminui(a, b);
            pushRes();
        }
        catch(NullPointerException ex){
            pilha.push(a);
        }
            

    }   

    void multiplica(){
        try{
            popNums();
            a.multiplica(a, b);
            pushRes();
        }
        catch(NullPointerException ex){
            pilha.push(a);
        }

    }   

    void divide(){
        try{
            popNums();
            a.dividir(a, b);
            pushRes();
            }
            catch(NullPointerException ex){
                pilha.push(a);
            }
            catch(ArithmeticException ex){
                pilha.push(b);
                pilha.push(a);
            }

    }   

}
