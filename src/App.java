import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App {

    public static void mostrar(String titulo, List<Estudiante> lista) {
        System.out.println("\n====================================");
        System.out.println(titulo);
        System.out.println("====================================");

        for (Estudiante e : lista) {
            System.out.println(e);
        }
    }

    public static List<Estudiante> copiar(List<Estudiante> estudiantes) {
        return new ArrayList<>(estudiantes);
    }

    public static void main(String[] args) {

        List<Estudiante> estudiantes = DatosEstudiantes.obtenerEstudiantes();

        // C1: Orden por codigo
        List<Estudiante> c1 = copiar(estudiantes);
        Collections.sort(c1);
        mostrar("C1 - Codigo ascendente", c1);

        // C2: Nombre y codigo
        List<Estudiante> c2 = copiar(estudiantes);
        c2.sort(Comparadores.C2());
        mostrar("C2 - Nombre y codigo ascendente", c2);

        // C2 segunda forma
        List<Estudiante> c2b = copiar(estudiantes);
        c2b.sort(Comparadores.C2b());
        mostrar("C2 - Segunda forma", c2b);

        // Comprobar que las dos formas de C2 son iguales
        System.out.println("\nC2: Las dos formas son iguales: "
                + obtenerCodigos(c2).equals(obtenerCodigos(c2b)));

        // C3: Nota ascendente
        List<Estudiante> c3 = copiar(estudiantes);
        c3.sort(Comparadores.C3());
        mostrar("C3 - Nota ascendente", c3);

        // C4: Nota descendente y nombre ascendente
        List<Estudiante> c4 = copiar(estudiantes);
        c4.sort(Comparadores.C4());
        mostrar("C4 - Nota descendente y nombre ascendente", c4);

        // C5: Edad ascendente y nombre descendente
        List<Estudiante> c5 = copiar(estudiantes);
        c5.sort(Comparadores.C5());
        mostrar("C5 - Edad ascendente y nombre descendente", c5);

        // C6: Carrera, nota, nombre y codigo
        List<Estudiante> c6 = copiar(estudiantes);
        c6.sort(Comparadores.C6());
        mostrar("C6 - Carrera, nota, nombre y codigo", c6);

        // C7: Nota ajustada
        List<Estudiante> c7 = copiar(estudiantes);
        c7.sort(Comparadores.C7());
        mostrar("C7 - Nota ajustada descendente", c7);

        System.out.println("\nNOTAS AJUSTADAS:");
        for (Estudiante e : c7) {
            System.out.println(
                e.getNombre() +
                " | Nota original: " + e.getNota() +
                " | Nota ajustada: " + Comparadores.notaAjustada(e)
            );
        }

        // Prueba con lista vacia
        List<Estudiante> vacia = new ArrayList<>();
        vacia.sort(Comparadores.C2());
        System.out.println("\nPrueba lista vacia: " + vacia.size());

        // Prueba con un estudiante
        List<Estudiante> uno = new ArrayList<>();
        uno.add(estudiantes.get(0));
        uno.sort(Comparadores.C3());
        System.out.println("Prueba un estudiante: " + uno.size());

        // Dos pruebas adicionales
        List<Estudiante> prueba1 = copiar(estudiantes);
        prueba1.sort(Comparator.comparing(Estudiante::getCodigo));
        mostrar("PRUEBA EXTRA 1 - Codigo", prueba1);

        List<Estudiante> prueba2 = copiar(estudiantes);
        prueba2.sort(Comparator.comparing(Estudiante::getCarrera));
        mostrar("PRUEBA EXTRA 2 - Carrera", prueba2);

        // Verificar que la lista original no cambio
        System.out.println("\nLa lista original conserva sus 20 estudiantes: "
                + (estudiantes.size() == 20));
    }

    public static List<String> obtenerCodigos(List<Estudiante> lista) {
        List<String> codigos = new ArrayList<>();

        for (Estudiante e : lista) {
            codigos.add(e.getCodigo());
        }

        return codigos;
    }
}