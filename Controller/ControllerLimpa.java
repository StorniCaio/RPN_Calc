package Controller;
import javax.swing.*;
import dados.*;
import java.awt.event.ActionEvent;
import view.Visor;

public class ControllerLimpa extends ControllerEntra{
    private String name;
    private JTextField entrada;
    private JRadioButton intButton, combButton;
    private Visor visor;

    public ControllerLimpa(String name, Pilha _pilha, Visor _visor, JTextField _entrada, JRadioButton _inteiro, JRadioButton _complex){
        super( _pilha,  _visor,  _entrada,  _inteiro,  _complex);
        this.name = name;
        visor = _visor;
        entrada = _entrada;
        intButton = _inteiro;
        combButton = _complex;
    }
    
    public void actionPerformed(ActionEvent e) {

        if (name.equalsIgnoreCase("clcText")){
            entrada.setText("");
        }
        else{

            clean(this.name);
            if (pilha.isEmpty()){
                intButton.setEnabled(true);
                combButton.setEnabled(true);
            }
        }
        visor.atualiza();

    }
    
}
