
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App {

    public static void mostrar(String titulo, List<Estudiante> lista) {
        System.out.println("\n" + titulo);

        for (Estudiante e : lista) {
            System.out.println("* " + e);
        }
    }

    public static List<Estudiante> copiar(List<Estudiante> estudiantes) {
        return new ArrayList<>(estudiantes);
    }

    public static List<String> obtenerCodigos(List<Estudiante> lista) {
        List<String> codigos = new ArrayList<>();

        for (Estudiante e : lista) {
            codigos.add(e.getCodigo());
        }

        return codigos;
    }

    public static void validarConsulta(String nombre,
            List<Estudiante> resultado,
            List<Estudiante> original,
            Comparator<Estudiante> comparador) {

        boolean conservaCantidad = resultado.size() == original.size();

        List<String> codigosResultado = obtenerCodigos(resultado);
        List<String> codigosOriginales = obtenerCodigos(original);

        boolean sinRepetidos = true;

        for (int i = 0; i < codigosResultado.size(); i++) {
            for (int j = i + 1; j < codigosResultado.size(); j++) {
                if (codigosResultado.get(i).equals(codigosResultado.get(j))) {
                    sinRepetidos = false;
                }
            }
        }

        Collections.sort(codigosResultado);
        Collections.sort(codigosOriginales);

        boolean conservaRegistros =
                codigosResultado.equals(codigosOriginales);

        boolean ordenCorrecto = true;

        for (int i = 0; i < resultado.size() - 1; i++) {
            if (comparador.compare(resultado.get(i),
                    resultado.get(i + 1)) > 0) {
                ordenCorrecto = false;
                break;
            }
        }

        System.out.println("\nValidacion " + nombre);
        System.out.println("* Conserva los 20 estudiantes: " + conservaCantidad);
        System.out.println("* No tiene codigos repetidos: " + sinRepetidos);
        System.out.println("* Conserva todos los registros: " + conservaRegistros);
        System.out.println("* El orden es correcto: " + ordenCorrecto);

        if (conservaCantidad && sinRepetidos
                && conservaRegistros && ordenCorrecto) {
            System.out.println("Resultado: Correcto");
        } else {
            System.out.println("Resultado: Revisar");
        }
    }

    public static void main(String[] args) {

        List<Estudiante> estudiantes =
                DatosEstudiantes.obtenerEstudiantes();

        List<String> codigosIniciales = obtenerCodigos(estudiantes);

        List<Estudiante> c1 = copiar(estudiantes);
        Collections.sort(c1);
        mostrar("C1 - Codigo ascendente", c1);

        List<Estudiante> c2 = copiar(estudiantes);
        c2.sort(Comparadores.C2());
        mostrar("C2 - Nombre y codigo ascendente", c2);

        List<Estudiante> c2b = copiar(estudiantes);
        c2b.sort(Comparadores.C2b());
        mostrar("C2 - Segunda forma", c2b);

        System.out.println("\nLas dos formas de C2 son iguales: "
                + obtenerCodigos(c2).equals(obtenerCodigos(c2b)));

        List<Estudiante> c3 = copiar(estudiantes);
        c3.sort(Comparadores.C3());
        mostrar("C3 - Nota ascendente", c3);

        List<Estudiante> c4 = copiar(estudiantes);
        c4.sort(Comparadores.C4());
        mostrar("C4 - Nota descendente y nombre ascendente", c4);

        List<Estudiante> c4Especial = new ArrayList<>();

        for (Estudiante e : estudiantes) {
            if (e.getCodigo().equals("E014")
                    || e.getCodigo().equals("E005")
                    || e.getCodigo().equals("E010")) {
                c4Especial.add(e);
            }
        }

        c4Especial.sort(Comparadores.C4());

        mostrar("Prueba especial C4 - Empates", c4Especial);

        List<String> ordenC4 = obtenerCodigos(c4Especial);

        System.out.println("Orden esperado: E014, E005, E010");
        System.out.println("Orden obtenido: " + ordenC4);

        System.out.println("Se conserva el orden E014, E005, E010: "
                + ordenC4.equals(List.of("E014", "E005", "E010")));

        List<Estudiante> c5 = copiar(estudiantes);
        c5.sort(Comparadores.C5());
        mostrar("C5 - Edad ascendente y nombre descendente", c5);

        List<Estudiante> c6 = copiar(estudiantes);
        c6.sort(Comparadores.C6());
        mostrar("C6 - Carrera, nota, nombre y codigo", c6);

        List<Estudiante> c7 = copiar(estudiantes);
        c7.sort(Comparadores.C7());
        mostrar("C7 - Nota ajustada descendente", c7);

        System.out.println("\nNotas originales y ajustadas");

        for (Estudiante e : c7) {
            System.out.println("* " + e.getCodigo()
                    + " | " + e.getNombre()
                    + " | Nota original: " + e.getNota()
                    + " | Nota ajustada: "
                    + Comparadores.notaAjustada(e));
        }

        List<Estudiante> vacia = new ArrayList<>();
        vacia.sort(Comparadores.C2());

        System.out.println("\nPrueba con lista vacia: " + vacia.size());

        List<Estudiante> uno = new ArrayList<>();
        uno.add(estudiantes.get(0));
        uno.sort(Comparadores.C3());

        System.out.println("Prueba con un estudiante: " + uno.size());

        List<Estudiante> prueba1 = copiar(estudiantes);
        prueba1.sort(Comparator.comparing(Estudiante::getCodigo));
        mostrar("Prueba extra 1 - Codigo", prueba1);

        List<Estudiante> prueba2 = copiar(estudiantes);
        prueba2.sort(Comparator.comparing(Estudiante::getCarrera));
        mostrar("Prueba extra 2 - Carrera", prueba2);

        System.out.println("\nValidaciones");

        validarConsulta("C1", c1, estudiantes,
                Comparator.naturalOrder());

        validarConsulta("C2", c2, estudiantes,
                Comparadores.C2());

        validarConsulta("C3", c3, estudiantes,
                Comparadores.C3());

        validarConsulta("C4", c4, estudiantes,
                Comparadores.C4());

        validarConsulta("C5", c5, estudiantes,
                Comparadores.C5());

        validarConsulta("C6", c6, estudiantes,
                Comparadores.C6());

        validarConsulta("C7", c7, estudiantes,
                Comparadores.C7());

        List<String> notas85 = new ArrayList<>();

        for (Estudiante e : c3) {
            if (e.getNota() == 8.5) {
                notas85.add(e.getCodigo());
            }
        }

        System.out.println("\nEstabilidad de C3");

        System.out.println("Orden esperado: E014, E007, E005, E008, E010");
        System.out.println("Orden obtenido: " + notas85);

        System.out.println("C3 es estable: "
                + notas85.equals(List.of(
                        "E014", "E007", "E005", "E008", "E010")));

        System.out.println("\nLista original");

        System.out.println("La lista original no cambio: "
                + codigosIniciales.equals(obtenerCodigos(estudiantes)));

        System.out.println("Cantidad de estudiantes originales: "
                + estudiantes.size());
    }
}
