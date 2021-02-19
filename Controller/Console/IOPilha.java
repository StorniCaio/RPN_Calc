package Controller.Console;
import dados.Numero.*;
import dados.*;

public class IOPilha {
    protected Pilha pilha;
    private Numero numero;
    private Opera operador;

    public IOPilha (Pilha _pilha){
        pilha = _pilha;
        operador = new Opera(pilha);
    }

    private void setComplex(String text){
        String[] cmpl = text.split(" ");
        try{
        numero = new Complexo(Double.parseDouble(cmpl[0]),Double.parseDouble(cmpl[1]));
        }
        catch (IndexOutOfBoundsException ex){
            numero = new Complexo(Double.parseDouble(cmpl[0]),0);
        }

    }
    
    public void add(String text, String tipo){
        try{
        switch(tipo){
            case "COMPLEXO":
            setComplex(text);
            break;

            case "INTEIRO":
            numero = new Inteiro(Integer.parseInt(text));
            break;
        }
        pilha.push(numero);
    }
    catch(NumberFormatException ex){
    }
    }

    public void opera(String operacao){
        switch (operacao){  
            case "+":
            operador.soma();
            break;

            case "-":
            operador.diminui();
            break;

            case "*":
            operador.multiplica();
            break;

            case "/":
            operador.divide();
            break;
        }

    }

    public void clean(String modo){

        switch(modo){
            case "clcLast":
                try{
                    pilha.pop();
                }
                catch(IndexOutOfBoundsException exc){
                    System.out.println("A pilha esta vazia");
                }
            break;

            case "clcAll":
                pilha.clean();
            break;

        }
    }
}