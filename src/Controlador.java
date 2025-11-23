import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Controlador {

    private static Controlador instance = null;

    private Controlador(){

    }

    public static Controlador getInstance(){
        if(instance==null){
            instance = new Controlador();
        }
        return instance;
    }



    public Matriz resolver(Matriz matrizSudoku){

        for(Bloque bloque: matrizSudoku.getBloques()){
            for(Numero numero: bloque.getNumeros()){
                if(numero.getNumero()==0){
                    Numero [] vecinoxX = getVecinosX(matrizSudoku, bloque, numero);
                    Numero [] vecinosY = getVecinosY(matrizSudoku, bloque, numero);

                    Numero [] posibles = getPosibles(bloque, numero);

                    numero.setVecinosX(vecinoxX);
                    numero.setVecinosY(vecinosY);

                    if(posibles.length==1){
                        numero.setNumero(posibles[0].getNumero());
                    }else{
                        numero.setPosibles(posibles);
                    }
                }
            }
        }

        if(!completo((matrizSudoku))){
            resolver(matrizSudoku);
        }

        return matrizSudoku;
    }

    public boolean completo(Matriz matriz){
        for(Bloque bloque: matriz.getBloques()){
            for(Numero numero: bloque.getNumeros()){
                if(numero.getNumero()==0){
                    return false;
                }
            }
        }
        return true;
    }

    public Numero [] getVecinosX(Matriz matrizSudoku, Bloque bloque, Numero posicion){
        int [] bloquesVecinosX = getIdBloquesX(bloque);
        for(Bloque bloque2: matrizSudoku.getBloques()){
            if(!matchBloques(bloque,bloquesVecinosX)){
                break;
            }
            getVecinosX(bloque2,posicion);
        }
        return posicion.getVecinosX();
    }

    public void getVecinosX(Bloque bloque, Numero posicion){
        Numero [] vecinoX = new Numero[3];
        for(Numero numero: bloque.getNumeros()){
            if(numero.getPosicionX()==posicion.getPosicionX()){
                vecinoX[0]=numero;
                posicion.addVecinoX(vecinoX[0]);
            }
        }
    }

    public Numero [] getVecinosY(Matriz matrizSudoku, Bloque bloque, Numero posicion){
        int [] bloquesVecinosY = getIdBloquesY(bloque);
        for(Bloque bloque2: matrizSudoku.getBloques()){
            if(!matchBloques(bloque,bloquesVecinosY)){
                break;
            }
            getVecinosY(bloque2,posicion);
        }
        return posicion.getVecinosY();
    }

    public void getVecinosY(Bloque bloque, Numero posicion){
        Numero [] vecinoY = new Numero[3];
        for(Numero numero: bloque.getNumeros()){
            if(numero.getPosicionY()==posicion.getPosicionY()){
                vecinoY[0]=numero;
                posicion.addVecinoY(vecinoY[0]);
            }
        }
    }

    public boolean matchBloques(Bloque bloque, int [] bloques){
        for(int i=0; i<bloques.length; i++){
            if(bloque.getId()==bloques[i]){
                return true;
            }
        }
        return false;
    }

    public int [] getIdBloquesX(Bloque bloque){
        if(bloque.getId()==1){
            return new int[]{2,3};
        }else if(bloque.getId()==2){
            return new int[]{1,3};
        }else if(bloque.getId()==3){
            return new int[]{1,2};
        }else if(bloque.getId()==4){
            return new int[]{5,6};
        }else if(bloque.getId()==5){
            return new int[]{4,6};
        }else if(bloque.getId()==6){
            return new int[]{4,5};
        }else if(bloque.getId()==7){
            return new int[]{8,9};
        }else if(bloque.getId()==8){
            return new int[]{7,9};
        }else if(bloque.getId()==9){
            return new int[]{7,8};
        }
        return new int[]{};
    }

    public int [] getIdBloquesY(Bloque bloque){
        if(bloque.getId()==1){
            return new int[]{4,7};
        }else if(bloque.getId()==2){
            return new int[]{5,8};
        }else if(bloque.getId()==3){
            return new int[]{6,9};
        }else if(bloque.getId()==4){
            return new int[]{1,7};
        }else if(bloque.getId()==5){
            return new int[]{2,8};
        }else if(bloque.getId()==6){
            return new int[]{3,9};
        }else if(bloque.getId()==7){
            return new int[]{1,4};
        }else if(bloque.getId()==8){
            return new int[]{2,5};
        }else if(bloque.getId()==9){
            return new int[]{3,6};
        }
        return new int[]{};
    }

    public Numero [] getPosibles(Bloque bloque, Numero posicion){
        Numero [] getX = getPosibles(posicion.getVecinosX());
        Numero [] getY = getPosibles(posicion.getVecinosY());
        Numero [] getB = getPosibles(bloque.getNumeros());

        return getPosibles(getX,getY,getB);
    }

    public Numero [] getPosibles(Numero [] numerosX, Numero [] numerosY, Numero [] numerosB){
        ArrayList<Numero> posiblesSemiFinal = new ArrayList<>();
        ArrayList<Numero> posiblesFinal = new ArrayList<>();
        for(int i=0; i<Integer.max(numerosX.length, numerosY.length); i++){
            if(numerosX[i].getNumero()==numerosY[i].getNumero()){
                posiblesSemiFinal.add(numerosX[i]);
            }
        }

        for(int i=0; i<Integer.max(posiblesSemiFinal.size(), numerosB.length); i++){
            if(posiblesSemiFinal.get(i).getNumero()==numerosB[i].getNumero()){
                posiblesFinal.add(posiblesSemiFinal.get(i));
            }
        }

        return posiblesFinal.toArray(new Numero[0]);
    }

    public Numero [] getPosibles(Numero [] numeros){
        Arrays.sort(numeros);
        ArrayList<Numero>posibles=new ArrayList<>();
        for(int i=1; i<=numeros.length; i++){
            if(numeros[i].getNumero()!=i){
                posibles.add(numeros[i]);
            }
        }
        return posibles.toArray(new Numero[0]);
    }
}
