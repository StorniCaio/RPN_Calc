package view;
import javax.swing.*;
import dados.*;
import dados.Numero.*;

public class Visor {
    private Pilha pilha;
    private Pilha printBuffer;
    private JTextArea printArea;
    private StringBuffer sb;
    private String[] aux;
    private Numero n;

    public Visor(Pilha _pilha, JTextArea _printArea){
        pilha = _pilha;
        printArea =_printArea;
        n = null;
        printBuffer = new Pilha();
    }

    public void atualiza(){
        try{
        printArea.setText("");;
        montaBuffer();
        setText();
        }
        catch(NullPointerException ex){
            printArea.setText("ERROR \nNúmero não Inserido");
        }
    }
    private void  montaBuffer(){
        int i = pilha.getIndice();
        aux = new String[i];

        while(!pilha.isEmpty()){
        n = pilha.peek();
        printBuffer.push(n);
        aux[i-1] = "\n"+Integer.toString(printBuffer.getIndice()) +" <   " + n.toString();
        pilha.pop();
        i--;
        }

        while(!printBuffer.isEmpty()){
            n = printBuffer.peek();
            pilha.push(n);
            printBuffer.pop();
        }

    }

    private void setText(){
            sb = new StringBuffer();
            boolean flag = true;

            for(int j = 0; j < aux.length; j++) {
                if(aux.length <4 && flag){
                    for(int z = aux.length; z<4; z++)
                        sb.append("\n");
                    flag = false;
                }
            sb.append(aux[j]);
            }
            printArea.setText(sb.toString());

    }
   
}
