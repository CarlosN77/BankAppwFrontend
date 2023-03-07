public class Conta {

    public int numerodeconta;
    private Client titularprincipal;
    private Client titularsecundario;
    public double saldo;

    public Conta(int numerodeconta, Client titularprincipal, double saldo) {
        this.numerodeconta = numerodeconta;
        this.titularprincipal = titularprincipal;
        this.saldo = saldo;
    }

    public Conta(int accountNum) {
    }


    public int getNumerodeconta() {
        return numerodeconta;
    }

    public void setNumerodeconta(int numerodeconta) {
        this.numerodeconta = numerodeconta;
    }

    public Client getTitularprincipal() {
        return titularprincipal;
    }

    public void setTitularprincipal(Client titularprincipal) {
        this.titularprincipal = titularprincipal;
    }

    public Client getTitularsecundario() {
        return titularsecundario;
    }

    public void setTitularsecundario(Client titularsecundario) {
        this.titularsecundario = titularsecundario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void deposito(double quantia){
        if (quantia > 0) {
            saldo += quantia;
        } else {
            System.out.println("Impossivel depositar");
        }
    }

    public void levantar(double quantia) {
        if (quantia > 0 && quantia <= saldo) {
            saldo -= quantia;
        } else {
            System.out.println("Impossível levantar essa quantia, saldo insuficiente");
        }
    }

    public void transferir(Conta contaDestino,Conta contaemissora, double quantia) {
        if(quantia > 0 && quantia <= saldo){
            //this.saldo -= quantia;
            Double saldoAtual = contaemissora.getSaldo();
            contaemissora.setSaldo(saldoAtual - quantia);

            Double saldoDestino = contaDestino.getSaldo();
            contaDestino.setSaldo(saldoDestino + quantia);

            //contaDestino.saldo += quantia;
        } else{
            System.out.println("Impossible to transfer, insufficient funds.");
        }
    }

    public void alterarpin(int novopin) {
        Cartão.pin = novopin;
    }


    public void transferir(int accountToTransfer, double amount) {
    }
}
