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

                    Numero [] posibles = getPosibles(bloque, vecinoxX, vecinosY);

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
        for(Bloque bloque2: matrizSudoku.getBloques()){
            if(bloque2==bloque){
                break;
            }
            for(Numero numero2: bloque2.getNumeros()){
                if()
            }
        }

    }

    public int [] getIdBloques(Bloque bloque){
        if(bloque.getId()==1){
            return new int[]{2,3,4,7};
        }else if(bloque.getId()==2){
            return new int[]{1,3,5,8};
        }else if(bloque.getId()==3){
            return new int[]{1,2,6,9};
        }else if(bloque.getId()==4){
            return new int[]{1,5,6,};
        }else if(bloque.getId()==2){
            return new int[]{1,3,5,8};
        }else if(bloque.getId()==2){
            return new int[]{1,3,5,8};
        }else if(bloque.getId()==2){
            return new int[]{1,3,5,8};
        }else if(bloque.getId()==2){
            return new int[]{1,3,5,8};
        }else if(bloque.getId()==2){
            return new int[]{1,3,5,8};
        }
    }

    public Numero [] getVecinosY(Matriz matrizSudoku, Bloque bloque, Numero posicion){

    }

    public Numero [] getPosibles(Bloque bloque, Numero [] vecinosX, Numero[] vecinosY){

    }
}
