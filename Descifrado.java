import java.util.Scanner;

public class Descifrado {public static void main(String[] args) {
    Scanner lector = new Scanner(System.in);
    System.out.println("Ingresa el mensaje cifrado");
    String mensaje = lector.next();
    System.out.println("Cuántas veces quieres mover la letra");
    int veces = lector.nextInt();

    StringBuilder mensajeCifrado = new StringBuilder();

    for(int i = 0; i < mensaje.length(); i++) {
        char letra = mensaje.charAt(i);
        boolean minuscula = (letra >= 'a' && letra <='z');
        boolean mayuscula = (letra >= 'A' && letra <='Z');
        if(!(minuscula || mayuscula))
            mensajeCifrado.append(letra);
        else {
            int baseAscii = 'a';
            if(mayuscula)
                baseAscii = 'A';
            int nuevoAscii = ((int)letra - baseAscii - veces) % 26 + baseAscii;
            if(nuevoAscii<baseAscii) {
                if (mayuscula) {
                    nuevoAscii = 'Z' - (baseAscii - nuevoAscii) + 1;
                } else {
                    nuevoAscii = 'z' - (baseAscii - nuevoAscii) + 1;
                }
            }
            char nuevaLetra = (char)nuevoAscii;
            mensajeCifrado.append(nuevaLetra);
        }
    }
    System.out.println(mensajeCifrado);

}
}

