package Controller;
import dados.*;
import Controller.Console.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Visor;

public class ControllerOpera extends IOPilha implements ActionListener{
    private String operacao;
    private Visor visor;
    

    public ControllerOpera( Pilha _Pilha, String name, Visor _visor){
        
        super(_Pilha);
        operacao = name;
        visor = _visor;

    }
    public void actionPerformed(ActionEvent e){
        opera(operacao);
        visor.atualiza();
    }    
        

}
