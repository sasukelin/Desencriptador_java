import java.util.Scanner;

public class desencriptador {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingresa el mensaje cifrado");
        String mensajeCifrado = lector.nextLine();
        System.out.println("Cuántas veces se movió la letra al encriptar");
        int veces = lector.nextInt();

        String mensajeOriginal = "";

        for (int i = 0; i < mensajeCifrado.length(); i++) {
            char letra = mensajeCifrado.charAt(i);
            boolean minuscula = (letra >= 'a' && letra <= 'z');
            boolean mayuscula = (letra >= 'A' && letra <= 'Z');

            if (!(minuscula || mayuscula)) {
                mensajeOriginal += letra;
            } else {
                int ascii = (int) letra;
                int baseAscii = (int) 'a';
                if (mayuscula) {
                    baseAscii = (int) 'A';
                }
                int nuevoAscii = (ascii - baseAscii - veces) % 26 + baseAscii;
                if (nuevoAscii < baseAscii) {
                    nuevoAscii += 26;
                }
                char nuevaLetra = (char) nuevoAscii;

                mensajeOriginal += nuevaLetra;
            }
        }
        System.out.println("Mensaje original: " + mensajeOriginal);
    }
}
