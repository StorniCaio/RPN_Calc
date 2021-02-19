package dados.Numero;


public class Inteiro implements Numero {

    private int real;
    
    public Inteiro(int _a){
        real = _a;
    }

    public void soma(Numero a, Numero b){
        real = a.get() + b.get();
    }

    public void diminui(Numero a, Numero b){
        real = a.get() - b.get();
    }

    public void multiplica(Numero a, Numero b){
        real = a.get() * b.get();
    }

    public void dividir(Numero a, Numero b){
            real = a.get()/b.get();

    }

    public double getReal(){
        return 0;
    }
    
    public double getImag(){
        return 0;
    }
    
    public int get(){
        return real;
    }

    public String toString(){
        return Integer.toString(real);
    }
}
