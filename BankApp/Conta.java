public class Conta {

    public int numerodeconta;
    private String titularprincipal;
    private String titularsecundario;
    public int saldo;


    public Conta(int numerodeconta, String titularprincipal, String titularsecundario, int saldo) {
        this.numerodeconta = numerodeconta;
        this.titularprincipal = titularprincipal;
        this.titularsecundario = titularsecundario;
        this.saldo = saldo;
    }

    public int getNumerodeconta() {
        return numerodeconta;
    }

    public void setNumerodeconta(int numerodeconta) {
        this.numerodeconta = numerodeconta;
    }

    public String getTitularprincipal() {
        return titularprincipal;
    }

    public void setTitularprincipal(String titularprincipal) {
        this.titularprincipal = titularprincipal;
    }

    public String getTitularsecundario() {
        return titularsecundario;
    }

    public void setTitularsecundario(String titularsecundario) {
        this.titularsecundario = titularsecundario;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
