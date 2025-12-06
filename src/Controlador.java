
public class Controlador {

    private static Controlador instance = null;

    // interfaz para notificar a la GUI
    public interface SudokuUpdateListener {
        // blockId es del 1 al 9, ordenados horizontalmente, post x es 1 o 2 o 3 y pos x es 1 o 2 o 3, valor es el numero
        void actualizarBloque(int blockId, int posX, int posY, int valor);
        void resetearBloque(int blockId, int posX, int posY);
    }

    private Controlador(){

    }

    public static Controlador getInstance(){
        if(instance==null){
            instance = new Controlador();
        }
        return instance;
    }

    public Matriz resolver(Matriz matrizSudoku, SudokuUpdateListener interfaz){
        solveBacktracking(matrizSudoku, interfaz);
        return matrizSudoku;
    }

    // backtracking que va resolviendo el sudoku, interfaz es para actualizar la GUI
    private boolean solveBacktracking(Matriz matrizSudoku, SudokuUpdateListener interfaz) {

        Numero celdaVacia = null;
        Bloque bloqueVacio = null;

        // encontrar la siguiente celda vacía
        for (Bloque bloque : matrizSudoku.getBloques()) {
            for (Numero numero : bloque.getNumeros()) {
                if (numero.getNumero() == 0) {
                    celdaVacia = numero;
                    bloqueVacio = bloque;
                    break;
                }
            }
            if (celdaVacia != null) {
                break;
            }
        }

        // si no se encuentra una celda vacía, se completo el alg.
        if (celdaVacia == null) {
            return true;
        }

        // si no hay vecinos se pobla con vecinos
        if (celdaVacia.getVecinosX()[0] == null) {
            getVecinosX(matrizSudoku, bloqueVacio, celdaVacia);
            getVecinosY(matrizSudoku, bloqueVacio, celdaVacia);
        }

        // probar valores del 1 al 9
        for (int valor = 1; valor <= 9; valor++) {

            // si se puede insertar ingresa al if
            if (esValido(bloqueVacio, celdaVacia, valor)) {
                celdaVacia.setNumero(valor);

                interfaz.actualizarBloque(
                        bloqueVacio.getId(),
                        celdaVacia.getPosicionX(),
                        celdaVacia.getPosicionY(),
                        valor
                );

                if (solveBacktracking(matrizSudoku, interfaz)) {
                    // si la recursión tiene éxito, devuelve true
                    return true;
                }

                // si la recursión falla, retrocede
                celdaVacia.setNumero(0);
                interfaz.resetearBloque(
                        bloqueVacio.getId(),
                        celdaVacia.getPosicionX(),
                        celdaVacia.getPosicionY()
                );
            }
        }

        return false;
    }

    private boolean esValido(Bloque bloque, Numero posicion, int valor){

        // verificar en el Bloque
        for(Numero num: bloque.getNumeros()){
            // se comprueba si el número ya existe en el bloque
            if(num != posicion && num.getNumero() == valor){
                return false;
            }
        }

        // verificar en la fila (vecinosX)
        for(Numero num: posicion.getVecinosX()){
            if(num != null && num.getNumero() == valor){
                return false;
            }
        }

        // verificar en la columna (vecinosY)
        for(Numero num: posicion.getVecinosY()){
            if(num != null && num.getNumero() == valor){
                return false;
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
}