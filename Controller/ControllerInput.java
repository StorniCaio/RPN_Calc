package Controller;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerInput implements ActionListener{

    private JTextField caixaEntrada;
    String name;

    public ControllerInput(String botao, JTextField _caixaEntrada){
        caixaEntrada = _caixaEntrada;
        name = botao;
    }

    public void actionPerformed(ActionEvent e) {
        caixaEntrada.setText(caixaEntrada.getText()+name);
    }
}