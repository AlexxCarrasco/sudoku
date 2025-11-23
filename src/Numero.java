public class Numero {

    private int numero;
    private int contX = 0;
    private int contY = 0;
    private int [] posibles;
    private Numero [] vecinosX;
    private Numero [] vecinosY;
    private int posicionX;
    private int posicionY;

    public Numero(int numero) {
        this.numero = numero;
        vecinosX = new Numero[6];
        vecinosY = new Numero[6];
    }

    public int getNumero() {
        return numero;
    }

    public void addVecinoX(Numero numero) {
        vecinosX[contX] = numero;
        contX++;
    }

    public void addVecinoY(Numero numero) {
        vecinosY[contY] = numero;
        contY++;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int[] getPosibles() {
        return posibles;
    }

    public void setPosibles(int[] posibles) {
        this.posibles = posibles;
    }

    public Numero[] getVecinosX() {
        return vecinosX;
    }

    public void setVecinosX(Numero[] vecinosX) {
        this.vecinosX = vecinosX;
    }

    public Numero[] getVecinosY() {
        return vecinosY;
    }

    public void setVecinosY(Numero[] vecinosY) {
        this.vecinosY = vecinosY;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }
}
