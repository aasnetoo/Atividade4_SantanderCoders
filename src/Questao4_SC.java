
public class Questao4_SC {

    public static final String VOTO_OBRIGATORIO = "VOTO OBRIGATORIO";
    public static final String VOTO_FACULTATIVO = "VOTO FACULTATIVO";
    public static final String NAO_PODE_VOTAR = "NAO PODE VOTAR";

    public static void main(String[] args) {

        String[][] testeVoto = {{"37", "VOTO OBRIGATORIO"},
                {"20", "VOTO OBRIGATORIO"},
                {"16", "VOTO FACULTATIVO"},
                {"17", "VOTO FACULTATIVO"},
                {"14", "NAO PODE VOTAR"},
                {"45", "VOTO OBRIGATORIO"},
                {"75", "VOTO FACULTATIVO"},
                {"-10", "NAO PODE VOTAR"},
                {"10", "NAO PODE VOTAR"},
        };

        String[] testesFalha = new String[20];
        String[] armazenarTeste = new String[20];

        int cont = 0;
        int cont1 = 0;
        int cont2 = 0;

        for (int i = 0; i < testeVoto.length; i++) {
            if (testeVoto[i][1].equalsIgnoreCase(podeVotar(Integer.parseInt(testeVoto[i][0])))) {
                System.out.println("Teste " + (i + 1) + " = Sucesso");
                cont++;
            } else {
                System.out.println("Teste " + (i + 1) + " = Falha");
                testesFalha[i+cont1] = (podeVotar(Integer.parseInt(testeVoto[i][0])));
                testesFalha[i+cont1+1] = (testeVoto[i][1]);
                cont1++;
                armazenarTeste[i] = ("Teste "+(i+1));
                }
            }

        if(cont == 9){
            System.out.println("Testes executados com sucesso");
        }
        else{
            System.out.println("Os seguintes testes falharam: ");
            for (int i = 0; i < testesFalha.length-1; i++) {
                    if (armazenarTeste[i] != null && testesFalha[i+cont2] != null & testesFalha[i+1+cont2] != null){
                        String teste = armazenarTeste[i];
                        String resultadoTeste = testesFalha[i+cont2]; // 0 - 2 - 4 - 6
                        String resultadoMetodo = testesFalha[i+cont2+1]; //1+0+0 - 3 - 5 - 7
                        cont2++;
                        System.out.println(teste+" - Resultado: "+resultadoMetodo+" - Correto: "+resultadoTeste);
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
