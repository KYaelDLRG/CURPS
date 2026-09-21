import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        char sexoFiltro;

        // 1. Obtención de n (por parámetro o por consola)
        if (args.length > 0) {
            n = Integer.parseInt(args[0]);
        } else {
            System.out.print("Ingrese la cantidad de CURPs a generar: ");
            n = scanner.nextInt();
        }

        // 2. Generar y almacenar n CURPs en un ArrayList
        ArrayList<String> curps = new ArrayList<>();
        System.out.println("CURPs generadas: " + n);
        for (int i = 0; i < n; i++) {
            String curp = getCURP();
            curps.add(curp);
            System.out.println("CURP = " + curp);
        }

        // 3. Obtención del sexo a eliminar (por parámetro args[1] o por consola)
        if (args.length > 1) {
            sexoFiltro = Character.toUpperCase(args[1].charAt(0));
        } else {
            System.out.print("\nElija el sexo que desea eliminar (H/M): ");
            sexoFiltro = Character.toUpperCase(scanner.next().charAt(0));
        }

        // 4. Filtrar la lista usando obligatoriamente el cursor Iterator
        Iterator<String> it = curps.iterator();
        while (it.hasNext()) {
            String curp = it.next();
            // El sexo se encuentra en la posición 11 (índice 10)
            if (curp.charAt(10) == sexoFiltro) {
                it.remove();
            }
        }

        // 5. Reimprimir la lista filtrada
        System.out.println("\nEl ArrayList de CURPs filtrando los registros " + sexoFiltro + " es:");
        System.out.println(curps);

        scanner.close();
    }

    static String getCURP() {
        String Letra = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Numero = "0123456789";
        String Sexo = "HM";
        String Entidad[] = { "AS", "BC", "BS", "CC", "CS", "CH", "CL", "CM", "DF", "DG", "GT",
                "GR", "HG", "JC", "MC", "MN", "MS", "NT", "NL", "OC", "PL", "QT", "QR", "SP", "SL", "SR", "TC",
                "TL", "TS", "VZ", "YN", "ZS" };
        int indice;

        StringBuilder sb = new StringBuilder(18);

        for (int i = 1; i < 5; i++) {
            indice = (int) (Letra.length() * Math.random());
            sb.append(Letra.charAt(indice));
        }

        for (int i = 5; i < 11; i++) {
            indice = (int) (Numero.length() * Math.random());
            sb.append(Numero.charAt(indice));
        }

        indice = (int) (Sexo.length() * Math.random());
        sb.append(Sexo.charAt(indice));

        sb.append(Entidad[(int) (Math.random() * Entidad.length)]);

        for (int i = 14; i < 17; i++) {
            indice = (int) (Letra.length() * Math.random());
            sb.append(Letra.charAt(indice));
        }

        for (int i = 17; i < 19; i++) {
            indice = (int) (Numero.length() * Math.random());
            sb.append(Numero.charAt(indice));
        }

        return sb.toString();
    }
}