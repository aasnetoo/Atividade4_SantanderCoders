
public class Questao4_SC {

    public static final String VOTO_OBRIGATORIO = "VOTO OBRIGATORIO";
    public static final String VOTO_FACULTATIVO = "VOTO FACULTATIVO";
    public static final String NAO_PODE_VOTAR = "NAO PODE VOTAR";
    public static void main(String[] args) {

        String[][] testeVoto = {
                {"50", "VOTO OBRIGATORIO"},
                {"25", "VOTO OBRIGATORIO"},
                {"16", "VOTO FACULTATIVO"},
                {"17", "VOTO FACULTATIVO"},
                {"14", "NAO PODE VOTAR"},
                {"45", "VOTO OBRIGATORIO"},
                {"75", "VOTO FACULTATIVO"},
                {"-10", "NAO PODE VOTAR"},
                {"10", "NAO PODE VOTAR"},
        };

        String[] armazenarTeste = new String[20];
        String[][] testeFalha = new String[20][20];

        int cont = 0;

        for (int i = 0; i < testeVoto.length; i++) {
            if (testeVoto[i][1].equalsIgnoreCase(podeVotar(Integer.parseInt(testeVoto[i][0])))) {
                System.out.println("Teste " + (i + 1) + " = Sucesso");
                cont++;
            } else {
                System.out.println("Teste " + (i + 1) + " = Falha");
                testeFalha[i][0] = (testeVoto[i][1]);
                testeFalha[i][1] = (podeVotar(Integer.parseInt(testeVoto[i][0])));
                armazenarTeste[i] = ("Teste "+(i+1));
                }
            }

        if(cont == 9){
            System.out.println("Testes executados com sucesso");
        }
        else{
            cont = 0;
            System.out.println("Os seguintes testes falharam: ");
            for (int i = 0; i < testeFalha.length-1; i++) {
                    if (armazenarTeste[i] != null && testeFalha[i][0] != null & testeFalha[i][1] != null){
                        String teste = armazenarTeste[i];
                        String resultadoTeste = testeFalha[i][0]; // 0 - 2 - 4 - 6
                        String resultadoMetodo = testeFalha[i][1]; //1+0+0 - 3 - 5 - 7
                        cont++;
                        System.out.println(teste+" - Resultado: "+resultadoTeste+" - Correto: "+resultadoMetodo);
                    }
            }


        }
    }
    public static String podeVotar(int idade) {

        if (idade >= 16 && idade <= 18) {
            return VOTO_FACULTATIVO;
        } else if (idade >= 70) {
            return VOTO_FACULTATIVO;
        } else if (idade < 16) {
            return NAO_PODE_VOTAR;
        } else {
            return VOTO_OBRIGATORIO;
        }

    }

}
