
package primerproyecto;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrimerProyecto {

    public static void main(String[] args) {
         // 1. Obtener la fecha y hora actual del dispositivo
        LocalDateTime ahora = LocalDateTime.now();
        
        // Formato para mostrar la fecha de manera limpia
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Hora actual: " + ahora.format(formato));

        // 2. Definir cuántas horas quieres sumar (ejemplo: 5 horas)
        int horasASumar = 22;

        // 3. Sumar las horas
        LocalDateTime nuevaFecha = ahora.plusHours(horasASumar);
        System.out.println("Nueva hora:  " + nuevaFecha.format(formato));
    }
    
}
