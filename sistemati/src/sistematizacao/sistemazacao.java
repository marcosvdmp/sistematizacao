package sistematizacao;

	import java.util.HashMap;
	import java.util.Map;
	import java.util.Scanner;

	class InformacaoMedica {
	    private String alergias;
	    private String condicoesMedicas;

	    public InformacaoMedica(String alergias, String condicoesMedicas) {
	        this.alergias = alergias;
	        this.condicoesMedicas = condicoesMedicas;
	    }

	    public String getAlergias() {
	        return alergias;
	    }

	    public String getCondicoesMedicas() {
	        return condicoesMedicas;
	    }

	    public String toString() {
	        return "Alergias: " + alergias + ", Condições Médicas: " + condicoesMedicas;
	    }
	}

	class Empregado {
	    private String id;
	    private String nome;
	    private String email;
	    private String telefone;
	    private InformacaoMedica informacaoMedica;

	    public Empregado(String id, String nome, String email, String telefone, InformacaoMedica informacaoMedica) {
	        this.id = id;
	        this.nome = nome;
	        this.email = email;
	        this.telefone = telefone;
	        this.informacaoMedica = informacaoMedica;
	    }

	    public String getId() {
	        return id;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getTelefone() {
	        return telefone;
	    }

	    public InformacaoMedica getInformacaoMedica() {
	        return informacaoMedica;
	    }

	    @Override
	    public String toString() {
	        return "ID: " + id + "\nNome: " + nome + "\nEmail: " + email + "\nTelefone: " + telefone + "\n" + informacaoMedica.toString();
	    }
	}

	class GerenciadorEmpregados {
	    private Map<String, Empregado> empregados;

	    public GerenciadorEmpregados() {
	        this.empregados = new HashMap<>();
	    }

	    public void adicionarEmpregado(Empregado empregado) {
	        empregados.put(empregado.getId(), empregado);
	    }

	    public Empregado buscarEmpregado(String id) {
	        return empregados.get(id);
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        GerenciadorEmpregados gerenciador = new GerenciadorEmpregados();

	        while (true) {
	            System.out.println("1. Adicionar Empregado");
	            System.out.println("2. Buscar Empregado");
	            System.out.println("3. Sair");
	            System.out.print("Escolha uma opção: ");
	            int opcao = scanner.nextInt();
	            scanner.nextLine();

	            if (opcao == 1) {
	                System.out.print("ID: ");
	                String id = scanner.nextLine();
	                System.out.print("Nome: ");
	                String nome = scanner.nextLine();
	                System.out.print("Email: ");
	                String email = scanner.nextLine();
	                System.out.print("Telefone: ");
	                String telefone = scanner.nextLine();
	                System.out.print("Alergias: ");
	                String alergias = scanner.nextLine();
	                System.out.print("Condições Médicas: ");
	                String condicoesMedicas = scanner.nextLine();

	                InformacaoMedica informacaoMedica = new InformacaoMedica(alergias, condicoesMedicas);
	                Empregado empregado = new Empregado(id, nome, email, telefone, informacaoMedica);
	                gerenciador.adicionarEmpregado(empregado);

	                System.out.println("Empregado adicionado com sucesso!");
	            } else if (opcao == 2) {
	                System.out.print("ID do Empregado: ");
	                String id = scanner.nextLine();
	                Empregado empregado = gerenciador.buscarEmpregado(id);
	                if (empregado != null) {
	                    System.out.println("Informações do Empregado:");
	                    System.out.println(empregado.toString());
	                } else {
	                    System.out.println("Empregado não encontrado.");
	                }
	            } else if (opcao == 3) {
	                break;
	            } else {
	                System.out.println("Opção inválida. Tente novamente.");
	            }
	        }

	        scanner.close();
	    }
	}
