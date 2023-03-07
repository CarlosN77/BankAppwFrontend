public class Cartão {

    private Client client;
    private Conta conta;
    public static int pin;
    public int numerodecartao;

    public Cartão(Client client, Conta conta, int pin, int numerodecartao) {
        this.client = client;
        this.conta = conta;
        this.pin = pin;
        this.numerodecartao = numerodecartao;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getNumerodecartao() {
        return numerodecartao;
    }

    public void setNumerodecartao(int numerodecartao) {
        this.numerodecartao = numerodecartao;
    }

   


    
}
