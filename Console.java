import dados.Pilha;
import Controller.Console.*;
import java.util.Scanner;
import java.lang.System;

public class Console {
    private Scanner teclado;
    private String entrada;


    private Pilha pilha;
    private IOPilha manipula;


    Console(){
        pilha = new Pilha();
        manipula = new IOPilha(pilha); 
        teclado = new Scanner(System.in);  
        informativos();
        entrada = teclado.nextLine();
        calculadora();
    }

    public void calculadora(){

        String tipo = entrada;
        while((!entrada.equals("INTEIRO") && !entrada.equals("COMPLEXO"))){
            System.out.println("Entre com um tipo válido");
            tipo = teclado.nextLine();
        }
        while(!entrada.equalsIgnoreCase("SAIR"))
        {         
                entrada = teclado.nextLine();  

                manipula.add(entrada, tipo);
                manipula.clean(entrada); 
                manipula.opera(entrada);

                
                try{       
                    switch(entrada){
                        case "TIPO":
                        tipo = teclado.nextLine();
                        pilha.clean();
                        break;

                        case "IMPRIME":
                        System.out.println(pilha.peek().toString());
                        break;

                    }
                }
                catch (IndexOutOfBoundsException ex){
                    System.out.println("Pilha vazia");
                }
            }
        }


    public void informativos(){
        System.out.println("\n\nCalculadora RPN\nPara fechar o programa digite SAIR");
        System.out.println("Para começar, entre com o comando do tipo de numero que deseja opera\n-INTEIRO\n-COMPLEXO");
        System.out.println("Em seguida entre com os números ");
        System.out.println("Utilize os comandos:\n-clcLast para apagar a ultima entrada na pilha");
        System.out.println("-clcAll para apagar todos.");
        System.out.println("Para imprimir o resultado do ultimo elemento utilize o comando IMPRIME");
        System.out.println("Caso queira mudar o tipo de número, usar o comando:\nTIPO e em seguinda\n-INTEIRO\n-COMPLEXO");
        System.out.println("Entre com os número e depois com a operação");
    }



    public static void main(String[] args) {
        Console app = new Console();
    }
    
}
