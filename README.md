# PL2.1 - Ordenamiento de estudiantes con Comparator y Comparable

**Autor:** Samantha Siavichay  
**Carrera:** Computación  
**Asignatura:** Estructura de Datos  
**Práctica:** PL2.1 Comparators  
**Tema:** Ordenamiento de estudiantes con Comparator y Comparable.

## 1. Objetivo

El objetivo de esta práctica es aprender a ordenar una lista de estudiantes de diferentes maneras utilizando Comparable y Comparator en Java. Para esto se realizaron varios ordenamientos tomando en cuenta datos como el código, nombre, nota, edad y carrera de cada estudiante.

También se buscó comprobar que los ordenamientos funcionen correctamente, que no se pierdan estudiantes y que los datos de la lista original se mantengan sin cambios.

## 2. Estructura del proyecto

El proyecto está organizado de la siguiente manera:

- **src/**: contiene los archivos principales del programa.
  - `App.java`: permite ejecutar el programa, realizar las consultas y mostrar los resultados.
  - `Comparadores.java`: contiene las diferentes formas de ordenar a los estudiantes.
  - `DatosEstudiantes.java`: contiene la información de los 20 estudiantes.
  - `Estudiante.java`: contiene los datos de cada estudiante y sus métodos.
- **bin/**: carpeta donde se guardan los archivos compilados.
- **lib/**: carpeta destinada a las librerías.
- **evidencias/**: contiene las capturas de pantalla de las pruebas realizadas.
- `README.md`: contiene información sobre el proyecto y su funcionamiento.

## 3. Herramientas utilizadas

- Lenguaje de programación: Java.
- Entorno de desarrollo: Visual Studio Code.
- JDK: 17.
- Bibliotecas utilizadas: bibliotecas estándar de Java.
- Control de versiones: Git.

## 4. Descripción del funcionamiento

Primero se creó la clase Estudiante, donde se guardan los datos de cada persona, como su código, nombre, edad, nota y carrera.

Después se utilizó Comparable para establecer un orden inicial de los estudiantes según su código, desde el menor hasta el mayor.

También se utilizó Comparator para realizar otros ordenamientos sin tener que cambiar la forma original de ordenar los estudiantes. Con esto fue posible organizarlos por diferentes datos y combinar varios criterios.

Para realizar las consultas se hicieron copias de la lista original, de esta manera cada ordenamiento se realiza por separado y los datos iniciales no se modifican.

## 5. Consultas realizadas

| Consulta | Criterio de ordenamiento | Implementación |
|---|---|---|
| C1 | Código ascendente. | Comparable y orden natural. |
| C2 | Nombre ascendente y código ascendente. | Comparator con expresión lambda. |
| C3 | Nota ascendente. | comparingDouble y referencia a método. |
| C4 | Nota descendente y nombre ascendente. | reversed y thenComparing. |
| C5 | Edad ascendente y nombre descendente. | comparingInt y criterio secundario invertido. |
| C6 | Carrera ascendente, nota descendente, nombre ascendente y código ascendente. | Composición de varios comparadores. |
| C7 | Nota ajustada descendente, nombre ascendente y código ascendente. | Comparator y cálculo de nota ajustada. |

### Comparación de C2

En C2 se realizaron dos formas diferentes de ordenar a los estudiantes por nombre y código. La primera utiliza una expresión lambda y la segunda utiliza comparing() y thenComparing().

Al ejecutar las dos formas se comprobó que ambas muestran el mismo orden de estudiantes y producen la misma secuencia de códigos.

### Ordenamiento descendente y desempates

Durante la práctica también se pudo observar que se pueden utilizar varios criterios para ordenar una lista. Primero se toma en cuenta el criterio principal y, cuando dos estudiantes tienen el mismo valor, se utiliza el siguiente criterio.

Por ejemplo, en C4 se ordena primero por nota de mayor a menor y después por nombre de forma ascendente. En C5 se toma primero la edad de menor a mayor y después el nombre de mayor a menor.

También se comprobó que al invertir un comparador se debe tener cuidado, porque se pueden cambiar todos los criterios y no solamente el que queremos ordenar de forma descendente.

### Comparación por nota

En C3 se ordena a los estudiantes solamente por su nota. Por eso, cuando dos o más estudiantes tienen la misma calificación, el comparador no utiliza el código ni el nombre para decidir quién va primero.

En este caso se puede observar la estabilidad del ordenamiento, porque los estudiantes que tienen la misma nota mantienen su posición relativa de la lista original.

## 6. Resultados obtenidos

Se realizaron las siete consultas utilizando los 20 estudiantes registrados en el programa.

Los resultados obtenidos fueron los siguientes:

- **C1:** los estudiantes quedaron ordenados por código de forma ascendente.
- **C2:** se ordenaron por nombre y después por código. Las dos formas utilizadas dieron el mismo resultado.
- **C3:** se ordenaron por nota de menor a mayor. Los estudiantes con nota 8.5 conservaron su orden original: E014, E007, E005, E008 y E010.
- **C4:** se ordenaron por nota de mayor a menor y por nombre de forma ascendente. Los primeros códigos fueron E017, E011 y E001.
- **C5:** se ordenaron por edad de menor a mayor y por nombre de mayor a menor. Los primeros códigos fueron E001, E016 y E004.
- **C6:** se ordenaron por carrera, nota, nombre y código. Los primeros códigos fueron E001, E018, E005, E010 y E014.
- **C7:** se ordenaron utilizando la nota ajustada. E001 obtuvo una nota de 10.0 y E018 obtuvo 9.7. Las notas originales no fueron modificadas.

También se realizaron pruebas adicionales con una lista vacía, una lista con un solo estudiante y dos ordenamientos propios para comprobar que el programa funcione con diferentes situaciones.

## 7. Tabla de pruebas

| Escenario | Resultado esperado | Resultado obtenido | Estado |
|---|---|---|---|
| C1 con 20 estudiantes | Códigos en orden ascendente. | Los códigos quedaron ordenados correctamente. | Correcto |
| C2 con 20 estudiantes | Nombre ascendente y código ascendente. | Las dos formas dieron la misma secuencia. | Correcto |
| C3 con 20 estudiantes | Nota ascendente y estabilidad de los empates. | Los estudiantes con nota 8.5 conservaron su orden original. | Correcto |
| C4 con 20 estudiantes | Nota descendente y nombre ascendente. | Los primeros códigos fueron E017, E011 y E001. | Correcto |
| C5 con 20 estudiantes | Edad ascendente y nombre descendente. | Los primeros códigos fueron E001, E016 y E004. | Correcto |
| C6 con 20 estudiantes | Carrera, nota, nombre y código. | Los primeros códigos fueron E001, E018, E005, E010 y E014. | Correcto |
| C7 con 20 estudiantes | Nota ajustada descendente sin cambiar la original. | E001 obtuvo 10.0 y E018 obtuvo 9.7. | Correcto |
| Lista vacía | Procesarse sin errores. | Se procesó correctamente y mostró 0 estudiantes. | Correcto |
| Lista de un estudiante | Mantener el único registro. | Se conservó el estudiante. | Correcto |
| C4 con E014, E005 y E010 | Conservar el orden original cuando existe un empate completo. | Se mantuvo el orden E014, E005 y E010. | Correcto |
| Prueba extra 1 | Ordenar los estudiantes por código. | Los 20 estudiantes quedaron ordenados por código ascendente. | Correcto |
| Prueba extra 2 | Ordenar los estudiantes por carrera. | Los 20 estudiantes quedaron agrupados según su carrera. | Correcto |
| Conservación de la lista original | Mantener los 20 estudiantes en su orden inicial. | La lista original no presentó cambios. | Correcto |

## 8. Evidencias

En la carpeta `evidencias/` se guardaron las capturas de pantalla que muestran los resultados obtenidos al ejecutar el programa.

Las evidencias permiten comprobar que las consultas se realizaron correctamente, que las validaciones se completaron y que la lista original se mantuvo sin cambios.

Dentro de las evidencias se encuentran:

- **onsola/Validaciones C1_C7.pngra las validaciones de las siete consultas.
- **Consola/List Orginal.png:** muestra que la lista original no cambió y que conserva los 20 estudiantes.

## 9. Repositorio Git

**Enlace del repositorio:** [Pegar aquí el enlace de tu repositorio].

**Hash del commit final:** [Pegar aquí el hash de tu último commit].

## 10. Conclusiones

1. En esta práctica aprendí a utilizar Comparable y Comparator para ordenar una lista de diferentes maneras. Comprendí que Comparable permite establecer un orden inicial y Comparator ayuda a realizar otros ordenamientos según los datos que necesitamos, como se hizo en las consultas C1 y C2.

2. También aprendí que se pueden combinar varios criterios para ordenar a los estudiantes y que es importante tener cuidado con los desempates. En C4 y C5 pude observar que primero se toma en cuenta un dato y después otro cuando los estudiantes tienen valores iguales.

3. Finalmente, comprendí la importancia de la estabilidad y de conservar los datos originales. En C3 comprobé que los estudiantes con la misma nota mantienen su orden y en C4 observé que E014, E005 y E010 conservaron su posición porque tenían la misma nota y el mismo nombre. Además, comprobé que las consultas no modificaron la lista original.

## 11. Recomendaciones

- Realizar una copia de la lista original antes de ordenar los estudiantes para evitar modificar los datos iniciales.
- Revisar bien los criterios de cada comparador para obtener el orden que se necesita.
- Comprobar que todos los estudiantes se mantengan después de realizar cada consulta.
- Verificar que las notas originales no cambien al calcular las notas ajustadas.
- Realizar pruebas con listas vacías y con pocos estudiantes para comprobar que el programa funcione correctamente.
- Revisar las capturas y los resultados de la terminal antes de entregar la práctica.