package dados.Numero;
import java.lang.Math;


public class Complexo implements Numero{

    private double real, imag;

    public Complexo(double _real, double _imag){
        real = _real;
        imag =_imag;
    }

    public void soma(Numero a, Numero b){
        real = a.getReal() + b.getReal();
        imag = a.getImag() + b.getImag();
    }
    
    public void diminui(Numero a, Numero b){
        real = a.getReal() - b.getReal();
        imag = a.getImag() - b.getImag();
    }

    public void multiplica(Numero a, Numero b){
        real = (a.getReal()*b.getReal()) - (a.getImag()*b.getImag());
        imag = (a.getReal()*b.getImag()) + (a.getImag()*b.getReal());
    }

    public void dividir(Numero a, Numero b){

        double den = b.getReal()*b.getReal()+ b.getImag()*b.getImag();
        real = (a.getReal()*b.getReal() + a.getImag()*b.getImag())/den;
        imag = (a.getReal()*b.getImag() - a.getImag()*b.getReal())/den;
    }
    
    public double getReal(){
        return real;
    }
    
    public double getImag(){
        return imag;
    }
    
    public int get(){return 0;}

    public String toString(){
        //return Double.toString(Math.sqrt(real*real + imag*imag)) +" | "+Double.toString(Math.atan(imag/real))  +"º";

        System.out.println(real+" "+imag);
        if (imag >= 0)
            return Double.toString(real)+" + j"+Double.toString(imag);
        else
            return Double.toString(real)+" - j"+Double.toString(imag).replace("-","");

    }

    public String toStringPolar(){

        return Double.toString(Math.sqrt(real*real + imag*imag)) +" | "+Double.toString(Math.atan(imag/real))  +"º";
    }
}






