import java.util.Scanner;

// ==================================================
// CLASSE Pessoa
// ==================================================

class Pessoa {

    String nome;
    int idade;
    double peso;
    double altura;
}

// ==================================================
// CLASSE PRINCIPAL
// ==================================================

public class Main {

    public static final int TAM = 100;

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Pessoa[] pessoas = new Pessoa[TAM];

        int qtd = 0;
    }

    // ==================================================
    // QUESTÃO 1
    // cadastrarPessoa
    // ==================================================

    public static int cadastrarPessoa(Pessoa[] v, int qtd) {

        // verifica se vetor está cheio
        if (qtd >= v.length) {

            System.out.println("Vetor cheio.");

            return qtd;
        }

        Pessoa nova = new Pessoa();

        // leitura do nome
        System.out.println("Digite o nome:");

        nova.nome = input.nextLine();

        // verifica nome duplicado
        while (buscarPessoa(v, qtd, nova.nome) != -1) {

            System.out.println("Nome já existe. Digite outro:");

            nova.nome = input.nextLine();
        }

        // leitura idade
        System.out.println("Digite a idade:");

        nova.idade = input.nextInt();

        // leitura peso
        System.out.println("Digite o peso:");

        nova.peso = input.nextDouble();

        // leitura altura
        System.out.println("Digite a altura:");

        nova.altura = input.nextDouble();

        input.nextLine();

        // adiciona no vetor
        v[qtd] = nova;

        // aumenta quantidade
        qtd++;

        return qtd;
    }

    // função auxiliar da questão 1
    public static int buscarPessoa(
        Pessoa[] v,
        int qtd,
        String nome
    ) {

        for (int i = 0; i < qtd; i++) {

            if (v[i].nome.equals(nome)) {

                return i;
            }
        }

        return -1;
    }

    // ==================================================
    // QUESTÃO 2
    // imprimirPessoas
    // ==================================================

    public static void imprimirPessoas(
        Pessoa[] v,
        int qtd
    ) {

        for (int i = 0; i < qtd; i++) {

            System.out.printf(
                "%s | %d anos | %.2f kg | %.2f m | IMC = %.2f\n",
                v[i].nome,
                v[i].idade,
                v[i].peso,
                v[i].altura,
                imc(v[i])
            );
        }
    }

    // função auxiliar da questão 2
    public static double imc(Pessoa p) {

        return p.peso / (p.altura * p.altura);
    }

    // ==================================================
    // QUESTÃO 3
    // maisVelhaIMCMagreza
    // ==================================================

    public static int maisVelhaIMCMagreza(
        Pessoa[] v,
        int qtd
    ) {

        int indice = -1;

        for (int i = 0; i < qtd; i++) {

            // verifica IMC magreza
            if (imc(v[i]) < 18.5) {

                // primeira pessoa válida
                if (indice == -1) {

                    indice = i;
                }

                // compara idade
                else if (v[i].idade > v[indice].idade) {

                    indice = i;
                }
            }
        }

        return indice;
    }

    // ==================================================
    // QUESTÃO 4
    // insertionSortPorNome
    // ==================================================

    public static void insertionSortPorNome(
        Pessoa[] v,
        int qtd
    ) {

        for (int i = 1; i < qtd; i++) {

            Pessoa chave = v[i];

            int j = i - 1;

            while (
                j >= 0 &&
                v[j].nome.compareTo(chave.nome) > 0
            ) {

                v[j + 1] = v[j];

                j--;
            }

            v[j + 1] = chave;
        }
    }

    // ==================================================
    // QUESTÃO 5
    // contarMaioresIdade
    // ==================================================

    public static int contarMaioresIdade(
        Pessoa[] v,
        int qtd
    ) {

        int contador = 0;

        for (int i = 0; i < qtd; i++) {

            if (v[i].idade >= 18) {

                contador++;
            }
        }

        return contador;
    }
}
