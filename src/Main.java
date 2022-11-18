import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        String[][] testeVoto = {{"25", "VOTO OBRIGATORIO"},
                {"38", "VOTO OBRIGATORIO"},
                {"16", "VOTO FACULTATIVO"},
                {"17", "VOTO FACULTATIVO"},
                {"14", "NAO PODE VOTAR"},
                {"45", "VOTO OBRIGATORIO"},
                {"75", "VOTO FACULTATIVO"},
                {"-10", "NAO PODE VOTAR"},
                {"10", "NAO PODE VOTAR"},
        };

        List<String> testesFalha = new ArrayList<String>();
        List<String> armazenarTeste = new ArrayList<String>();

        int cont = 0;
        for (int i = 0; i < testeVoto.length; i++) {
            if (testeVoto[i][1].equalsIgnoreCase(podeVotar(Integer.parseInt(testeVoto[i][0])))) {
                System.out.println("Teste " + (i + 1) + " = Sucesso");
                cont++;
                // LISTA = [ERRADO, CERTO, ERRADO, CERTO, ERRADO, CERTO]
            } else {
                System.out.println("Teste " + (i + 1) + " = Falha");
                testesFalha.add(podeVotar(Integer.parseInt(testeVoto[i][0])));
                testesFalha.add(testeVoto[i][1]);
                // LISTA = [ERRADO, CERTO, ERRADO, CERTO, ERRADO, CERTO]
                armazenarTeste.add("Teste "+(i+1));
                // LISTA = [TESTE 3, TESTE 5, TESTE 7]

            }



        }
        int cont1 = 0;
        if (cont == 9){
            System.out.println("Testes executados com sucesso");
        }
        else{
            System.out.println("Os seguintes testes falharam: ");
            for (int i = 0; i < armazenarTeste.size(); i++) {
                String teste = armazenarTeste.get(i);
                String resultadoTeste = testesFalha.get(i+cont1); // 0 - 2 - 4 - 6
                String resultadoMetodo = testesFalha.get(i+1+cont1); //1+0+0 - 3 - 5 - 7
                cont1++;
                // 1 REPETIÇÃO: 0 - 1, 2-3; 4-5;
                System.out.println(teste+" - Resultado: "+resultadoMetodo+" - Correto: "+resultadoTeste);
            }
        }
    }
    public static String podeVotar(int idade) {

        if (idade >= 16 && idade <= 18) {
            return Constants.VOTO_FACULTATIVO;
        } else if (idade >= 70) {
            return Constants.VOTO_FACULTATIVO;
        } else if (idade < 16) {
            return Constants.NAO_PODE_VOTAR;
        } else {
            return Constants.VOTO_OBRIGATORIO;
        }

    }
}
