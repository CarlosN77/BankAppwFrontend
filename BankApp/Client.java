public class Client {

    public String nome;
    public String senha;
    public int nif;
    public int datadenascimento;
    public int telefone;
    public int telemovel;
    public String email;
    public String profissao;

    public Client(String nome, String senha, int nif, int datadenascimento, int telefone, int telemovel, String email, String profissao) {
        this.nome = nome;
        this.senha = senha;
        this.nif = nif;
        this.datadenascimento = datadenascimento;
        this.telefone = telefone;
        this.telemovel = telemovel;
        this.email = email;
        this.profissao = profissao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public int getDatadenascimento() {
        return datadenascimento;
    }

    public void setDatadenascimento(int datadenascimento) {
        this.datadenascimento = datadenascimento;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(int telemovel) {
        this.telemovel = telemovel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public void alterarnome(String novonome){this.nome = novonome;}

}
