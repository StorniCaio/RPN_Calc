package Controller;
import javax.swing.*;
import view.Visor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dados.Pilha;
import Controller.Console.IOPilha;


public class ControllerEntra extends IOPilha implements ActionListener{
    private JTextField entrada;
    private JRadioButton intButton, compButton;
    private Visor visor;

    public ControllerEntra(Pilha _pilha, Visor _visor, JTextField _entrada, JRadioButton _inteiro, JRadioButton _complex){
        super(_pilha);
        visor = _visor;
        entrada = _entrada;
        intButton = _inteiro;
        compButton = _complex;
    }

    public void actionPerformed(ActionEvent e) {
            if (intButton.isSelected()){
                add(entrada.getText() , "INTEIRO");
                compButton.setEnabled(false);
            }
            else if (compButton.isSelected()){
                add(entrada.getText() , "COMPLEXO");
                intButton.setEnabled(false);
            }
            visor.atualiza();
            entrada.setText("");

            if(pilha.isEmpty()){
                    compButton.setEnabled(true);
                    intButton.setEnabled(true);
            }
    }


    }



