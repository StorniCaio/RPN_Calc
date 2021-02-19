import java.awt.BorderLayout;
import java.awt.*;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import dados.Pilha;
import Controller.ControllerEntra;
import Controller.ControllerInput;
import Controller.ControllerOpera;
import Controller.ControllerLimpa;

import view.*;

class App extends JFrame{

    private Pilha pilha = new Pilha();
    private Visor visor;

    public App (){
        super("Calculadora RPN");
        montaJanela();
    }
    public void montaJanela(){

        //Implementação do Visor da Calculadora
        JPanel painelVisor = new JPanel(new BorderLayout());
        painelVisor.setBorder(BorderFactory.createLineBorder(Color.BLACK, 30));
        JTextArea textoVisor = new JTextArea(4, 10);
        JScrollPane scroll = new JScrollPane(textoVisor);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        textoVisor.setFont(textoVisor.getFont().deriveFont(25f));
        textoVisor.setEditable(false);
        textoVisor.setSelectionStart(2);
        painelVisor.add(scroll);
        visor = new Visor(pilha, textoVisor);


        //Implementaççao do RadioButton para o tipo de Número
        JPanel tipoNumero = new JPanel(new GridLayout(2,0));
        JRadioButton intergerButton = new JRadioButton("Inteiro");
        JRadioButton complexButton = new JRadioButton("Complexo");
        ButtonGroup tipo = new ButtonGroup();
        tipoNumero.setBorder(BorderFactory.createTitledBorder("Tipo de Número"));
        tipo.add(intergerButton);
        tipo.add(complexButton);
        tipoNumero.add(intergerButton);
        tipoNumero.add(complexButton);
        intergerButton.setSelected(true);


        //Painel botão limpa tudo e limpa ultimo
        JPanel clearPanel = new JPanel(new GridLayout(2,0,8,8));
        JButton clearAllButton = new JButton("Limpa Tudo") ;
        JButton cleanButton = new JButton("Limpa Ultimo");
        clearPanel.add(clearAllButton);
        clearPanel.add(cleanButton);


        //Painel RadioButton e Botao Limpar tudo
        JPanel radioCleanPanel = new JPanel(new GridLayout(1,1,8,8));
        radioCleanPanel.add(tipoNumero);
        radioCleanPanel.add(clearPanel);


        //Implementação dos botoes Principais
        JButton enterButton = new JButton("Entra");
        JButton clcTextButton = new JButton("Limpa Texto");
        JButton signalNegativo = new JButton("-");
        JPanel painelButton = new JPanel(new GridLayout(0,3,8,8));
        painelButton.add(signalNegativo);
        painelButton.add(clcTextButton);
        painelButton.add(enterButton);
        

        //Painel da de Texto de Entrada
        JTextField entradaText = new JTextField(10);
        JPanel  entradaTextPanel = new JPanel(new GridLayout(2,0,5,5));
        entradaText.setFont(textoVisor.getFont().deriveFont(20f));
        entradaTextPanel.add(entradaText);
        entradaTextPanel.add(painelButton);

        // Painel que contem o radiobutton, enterbutto, clean button e caixa de entrada
        JPanel painelMeio = new JPanel(new GridLayout(2,0,5,5));
        painelMeio.add(radioCleanPanel);
        painelMeio.add(entradaTextPanel);


        //Painel com os botoes de numero e operação
        JPanel painelComandos = new JPanel(new GridLayout(4,4,6,6));
        JButton bt9 = new JButton("9");
        JButton bt8 = new JButton("8");
        JButton bt7 = new JButton("7");
        JButton btSoma = new JButton("+");
        JButton bt6 = new JButton("6");
        JButton bt5 = new JButton("5");
        JButton bt4 = new JButton("4");
        JButton btSubt = new JButton("-");
        JButton bt3 = new JButton("3");
        JButton bt2 = new JButton("2");
        JButton bt1 = new JButton("1");
        JButton btMult = new JButton("*");
        JButton btSpc = new JButton("_");
        JButton bt0 = new JButton("0");
        JButton btDecimal = new JButton(",");
        JButton btDivi = new JButton("/");
        painelComandos.add(bt7);
        painelComandos.add(bt8);
        painelComandos.add(bt9);
        painelComandos.add(btSoma);
        painelComandos.add(bt4);
        painelComandos.add(bt5);
        painelComandos.add(bt6);
        painelComandos.add(btSubt);
        painelComandos.add(bt1);
        painelComandos.add(bt2);
        painelComandos.add(bt3);
        painelComandos.add(btMult);
        painelComandos.add(btSpc);
        painelComandos.add (bt0);
        painelComandos.add(btDecimal);
        painelComandos.add (btDivi);

        //Listener dos Botões
        enterButton.addActionListener(new ControllerEntra(pilha,visor, entradaText, intergerButton, complexButton));
        cleanButton.addActionListener(new ControllerLimpa("clcLast", pilha,visor, entradaText, intergerButton, complexButton));
        clearAllButton.addActionListener(new ControllerLimpa("clcAll", pilha,visor, entradaText, intergerButton, complexButton));
        clcTextButton.addActionListener(new ControllerLimpa("clcText", pilha, visor, entradaText, intergerButton, complexButton));
        signalNegativo.addActionListener(new ControllerInput("-", entradaText));
        bt7.addActionListener(new ControllerInput("7", entradaText));
        bt8.addActionListener(new ControllerInput("8", entradaText));
        bt9.addActionListener(new ControllerInput("9", entradaText));
        bt4.addActionListener(new ControllerInput("4", entradaText));
        bt5.addActionListener(new ControllerInput("5", entradaText));
        bt6.addActionListener(new ControllerInput("6", entradaText));
        bt1.addActionListener(new ControllerInput("1", entradaText));
        bt2.addActionListener(new ControllerInput("2", entradaText));
        bt3.addActionListener(new ControllerInput("3", entradaText));
        bt0.addActionListener(new ControllerInput("0", entradaText));
        btDecimal.addActionListener(new ControllerInput(".", entradaText));
        btSpc.addActionListener(new ControllerInput(" " ,entradaText));
        btSoma.addActionListener(new ControllerOpera(pilha, "+", visor));
        btSubt.addActionListener(new ControllerOpera(pilha, "-", visor));
        btMult.addActionListener(new ControllerOpera(pilha, "*", visor));
        btDivi.addActionListener(new ControllerOpera(pilha, "/", visor));


        //Painel Principal!
        JPanel painelPrincipal = new JPanel(new GridLayout(3,0,5,5));
        painelPrincipal.setBorder(BorderFactory.createLineBorder(painelPrincipal.getBackground (), 10));
        painelPrincipal.add(painelVisor);
        painelPrincipal.add(painelMeio);
        painelPrincipal.add(painelComandos);

        //Painel Janela
        JPanel janela = new JPanel(new BorderLayout());
        TitledBorder titulo = BorderFactory.createTitledBorder("Por Caio Storni");
        titulo.setTitleJustification(TitledBorder.RIGHT);
        titulo.setTitlePosition(TitledBorder.BOTTOM);
        janela.setBorder(titulo);

        janela.add(painelPrincipal, BorderLayout.CENTER);
        
        
        this.add(janela);
        this.pack();
        this.setSize(400, 650);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
    
    public static void main(String[] args) {
        App cal = new App();
        cal.setVisible(true);
    }
}