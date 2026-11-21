import java.util.Comparator;

public class Comparadores {

    public static Comparator<Estudiante> C2() {
        return (a, b) -> {
            int resultado = a.getNombre().compareTo(b.getNombre());

            if (resultado == 0) {
                resultado = a.getCodigo().compareTo(b.getCodigo());
            }

            return resultado;
        };
    }

    public static Comparator<Estudiante> C2b() {
        return Comparator.comparing(Estudiante::getNombre)
                .thenComparing(Estudiante::getCodigo);
    }

    public static Comparator<Estudiante> C3() {
        return Comparator.comparingDouble(Estudiante::getNota);
    }

    public static Comparator<Estudiante> C4() {
        return Comparator.comparingDouble(Estudiante::getNota)
                .reversed()
                .thenComparing(Estudiante::getNombre);
    }

    public static Comparator<Estudiante> C5() {
        return Comparator.comparingInt(Estudiante::getEdad)
                .thenComparing(
                    Estudiante::getNombre,
                    Comparator.reverseOrder()
                );
    }

    public static Comparator<Estudiante> C6() {
        return Comparator.comparing(Estudiante::getCarrera)
                .thenComparing(
                    Comparator.comparingDouble(Estudiante::getNota).reversed()
                )
                .thenComparing(Estudiante::getNombre)
                .thenComparing(Estudiante::getCodigo);
    }

    public static Comparator<Estudiante> C7() {
        return Comparator.comparingDouble(
                    (Estudiante e) -> notaAjustada(e)
                ).reversed()
                .thenComparing(Estudiante::getNombre)
                .thenComparing(Estudiante::getCodigo);
    }

    public static double notaAjustada(Estudiante e) {
        if (e.getCarrera().equals("Computacion")) {
            return Math.min(10.0, e.getNota() + 0.5);
        }

        return e.getNota();
    }
}