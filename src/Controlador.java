import java.util.ArrayList;
import java.util.Arrays;

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
                    if(numero.getVecinosX()[0]==null){
                        getVecinosX(matrizSudoku, bloque, numero);
                        getVecinosY(matrizSudoku, bloque, numero);
                    }
                    int [] posibles = getPosibles(bloque, numero);
                    System.out.println("Numero es " + numero.getNumero());
                    System.out.println("En el bloque " + bloque.getId());
                    System.out.println(Arrays.toString(posibles));
                    if(posibles.length==1){
                        numero.setNumero(posibles[0]);
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
            if(!matchBloques(bloque2,bloquesVecinosX)){
                continue;
            }
            getVecinosX(bloque2,posicion);
        }
        return posicion.getVecinosX();
    }

    public void getVecinosX(Bloque bloque, Numero posicion){
        for(Numero numero: bloque.getNumeros()){
            if(numero.getPosicionY()==posicion.getPosicionY()){
                posicion.addVecinoX(numero);
            }
        }
    }

    public Numero [] getVecinosY(Matriz matrizSudoku, Bloque bloque, Numero posicion){
        int [] bloquesVecinosY = getIdBloquesY(bloque);
        for(Bloque bloque2: matrizSudoku.getBloques()){
            if(!matchBloques(bloque2,bloquesVecinosY)){
                continue;
            }
            getVecinosY(bloque2,posicion);
        }
        return posicion.getVecinosY();
    }

    public void getVecinosY(Bloque bloque, Numero posicion){
        for(Numero numero: bloque.getNumeros()){
            if(numero.getPosicionX()==posicion.getPosicionX()){
                posicion.addVecinoY(numero);
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

    public int [] getPosibles(Bloque bloque, Numero posicion){
        int [] getX = getPosiblesBloque(posicion.getVecinosX());
        int [] getY = getPosiblesBloque(posicion.getVecinosY());
        int [] getB = getPosiblesBloque(bloque.getNumeros());

        return getPosiblesTotal(getX,getY,getB);
    }

    public int [] getPosiblesTotal(int [] numerosX, int [] numerosY, int [] numerosB){
        ArrayList<Integer> posiblesSemiFinal = new ArrayList<>();
        ArrayList<Integer> posiblesFinal = new ArrayList<>();
        for(int i=0; i<numerosX.length; i++){
            for(int j=0; j<numerosY.length; j++){
                if(numerosX[i]==numerosY[j]){
                    posiblesSemiFinal.add(numerosX[i]);
                }
            }
        }

        for(int i=0; i<Integer.min(posiblesSemiFinal.size(), numerosB.length); i++){
            if(posiblesSemiFinal.get(i)==numerosB[i]){
                posiblesFinal.add(posiblesSemiFinal.get(i));
            }
        }

        int [] numerosArr = new int[posiblesFinal.size()];
        for(int i=0; i<posiblesFinal.size(); i++){
            numerosArr[i] = posiblesFinal.get(i);
        }
        return numerosArr;
    }

    public int [] getPosiblesBloque(Numero [] numeros){
        boolean encontrado = true;
        ArrayList<Integer> posibles = new ArrayList<Integer>();

        for(int j=0; j<9; j++) {
            for (int i = 0; i < numeros.length; i++) {
                if (buscar(numeros[i], j+1)) {
                    encontrado = true;
                    continue;
                }
            }
            if (!encontrado) {
                posibles.add(j+1);
            }
            encontrado = false;
        }

        int [] numerosArr = new int[posibles.size()];
        for(int i=0; i<posibles.size(); i++){
            numerosArr[i] = posibles.get(i);
        }
        return numerosArr;
    }

    public boolean buscar (Numero numero, int num){
        if(numero.getNumero()==0){
            return false;
        }

        if(numero.getNumero()==num){
            return true;
        }

        return false;
    }
}
