public class Bloque {

    private Numero [] numeros;
    private int id;

    public Bloque (int id){
        this.id=id;
    }

    public Numero[] getNumeros() {
        return numeros;
    }

    public void setNumeros(Numero[] numeros) {
        this.numeros = numeros;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
