import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Menu {

    static Database database = Database.getInstance();


    public static void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Fazer log in na app");
            System.out.println("2. Usar ATM");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int option = sc.nextInt();

            if (option == 1) {
                logIn();
            } else if (option == 2) {
                ATMVirtual();
            } else if (option == 3) {
                System.out.println("Adeus e até á proxima!");
                break;
            } else {
                System.out.println("Opção invalida. Escolha uma opção valida.");
            }
        }
    }

    private static void ATMVirtual() {
    }

    public static void logIn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Sign in");
        System.out.println("2. Log in");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
        int option = sc.nextInt();

        switch (option) {
            case 1:
                System.out.println("Insira o primeiro nome:");
                String primeironome = sc.next();
                System.out.println("Insira o segundo nome:");
                String segundonome = sc.next();
                System.out.println("Insira o seu NIF:");
                String nif = sc.next();
                System.out.println("Escolha uma password:");
                String senha = sc.next();
                System.out.println("Qual a sua data de nascimento (YYYY-MM-DD): ");
                String dataNascimentoString = sc.next();
                String[] dataNascimentoArray = dataNascimentoString.split("-");
                int ano = Integer.parseInt(dataNascimentoArray[0]);
                int mes = Integer.parseInt(dataNascimentoArray[1]);
                int dia = Integer.parseInt(dataNascimentoArray[2]);
                LocalDate dataNascimento = LocalDate.of(ano, mes, dia);
                LocalDate today = LocalDate.now();
                Period age = Period.between(dataNascimento, today);
                if (age.getYears() < 18) {
                    System.out.println("O cliente deve ter mais de 18 anos.");
                    break;
                }
                System.out.println("Insira o seu numero de telefone:");
                int telefone = sc.nextInt();
                System.out.println("Insira o seu numero de telemovel:");
                int telemovel = sc.nextInt();
                System.out.println("Insira o seu email:");
                String email = sc.next();
                System.out.println("Qual a sua profissão:");
                String profissao = sc.next();
                // code to create account
                Conta newConta = null;
                Client newClient = new Client(nif, senha, primeironome, segundonome, newConta, dataNascimento, telefone, telemovel, email, profissao);
                database.addClient(newClient);
                newConta = new Conta(Accountnumbergenerator.generateAccountNumber(), newClient, 50.00);
                newClient.setConta(newConta);
                System.out.println("Conta criada com sucesso!");
                break;

            case 2:
                System.out.println("Insira o NIF:");
                nif = sc.next();
                System.out.println("Insira a senha:");
                senha = sc.next();

                boolean clientfound = false;
                for (Client c : database.getClient()) {
                    if (nif.equals(c.getNif()) && senha.equals(c.getSenha())) {
                        System.out.println("Bem vindo, " + c.getPrimeironome() + " " + c.getSegundonome());
                        clientfound = true;
                        optionsAfterLogin(c);

                    }
                }
                if (!clientfound) {
                    System.out.println("Passord ou NIF invalido");
                }
                break;


        }

    }


    public static void optionsAfterLogin(Client loggedInClient) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Selecionar conta");
            System.out.println("2. Ver informações da conta");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int option = sc.nextInt();
            if (option == 1) {
                // code to select account
                List<Conta> contas = Collections.singletonList(loggedInClient.getConta());
                int i = 1;
                for (Conta c : contas) {
                    System.out.println(i + ". " + c.getTitularprincipal());
                    i++;
                }
                System.out.println("Escolha a conta que deseja usar: ");
                int accountOption = sc.nextInt();
                Conta selectedAccount = contas.get(accountOption - 1);
                accountOptions(selectedAccount);
            } else if (option == 2) {
                // code to view personal information
                System.out.println("Nome: " + loggedInClient.getPrimeironome() + " " + loggedInClient.getSegundonome());
                System.out.println("NIF: " + loggedInClient.getNif());
                System.out.println("Data de nascimento: " + loggedInClient.getDatadenascimento());
                System.out.println("Numero de conta: " + loggedInClient.getConta().getNumerodeconta());
                System.out.println("Telefone: " + loggedInClient.getTelefone());
                System.out.println("Telemóvel: " + loggedInClient.getTelemovel());
                System.out.println("Email: " + loggedInClient.getEmail());
                System.out.println("Profissão: " + loggedInClient.getProfissao());
            } else if (option == 3) {
                System.out.println("Saindo do menu...");
                break;
            } else {
                System.out.println("Opção inválida. Escolha uma opção válida.");
                break;
            }
        }
    }


    public static void accountOptions(Conta selectedAccount) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Ver saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Levantar");
            System.out.println("4. Transferir");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int option = sc.nextInt();
            if (option == 1) {
                System.out.println("Saldo: " + selectedAccount.getSaldo());
            }
                if (option == 2) {
                    // code to deposit
                    System.out.println("Quanto quer depositar: ");
                    double amount = sc.nextDouble();
                    selectedAccount.deposito(amount);
                    System.out.println("Novo saldo: " + selectedAccount.getSaldo());
                } else if (option == 3) {
                    // code to withdraw
                    System.out.println("Quanto quer levantar: ");
                    double amount = sc.nextDouble();
                    selectedAccount.levantar(amount);
                    System.out.println("Novo saldo: " + selectedAccount.getSaldo());
                } else if (option == 4) {
                    System.out.println("Insira o numero da conta para a qual quer transferir: ");
                    int accountNum = sc.nextInt();
                    Conta accountToGet = new Conta(accountNum);
                    Conta accountToTransfer = new Conta(accountNum);

                    System.out.println("Qual o valor a transferir: ");
                    double amount = sc.nextDouble();
                    selectedAccount.transferir(accountToTransfer,accountToGet, amount);
                    selectedAccount.setSaldo(selectedAccount.getSaldo() - amount);
                    accountToGet.setSaldo(accountToGet.getSaldo() + amount);
                    System.out.println("Novo saldo: " + selectedAccount.getSaldo());
                } else if (option == 5) {
                    System.out.println("Saindo do menu...");
                    break;
                }


            }
        }



    }


