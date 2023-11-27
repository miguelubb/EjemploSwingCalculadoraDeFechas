import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("\nPeríodo transcurrido entre fechas\n");
        System.out.println("Ingrese la fecha Incial(dd/mm/yyyy): ");
        String fIni=input.next();
        System.out.println("Fecha final (dd/mm/yyyy): ");
        String fFin=input.next();

        //para convertir las fechas de manera fácil se usará un DateTimeFormater
        //DateTimeFormater, es un objeto que define el formato de Fecha y hora que queremos usar.
        //Sirve tanto para convertir string a LocalDate como para convertir LocalDate a String
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ini=LocalDate.parse(fIni,formatter);
        LocalDate fin=LocalDate.parse(fFin,formatter);

        Period p=Period.between(ini,fin);
        long diasTranscurridos = ChronoUnit.DAYS.between(ini,fin);
        System.out.println("Han transcurrido : "+
                p.getDays()+" dias, "+
                p.getMonths()+" meses y "+
                p.getYears()+" años.");
        System.out.printf("Equivalente a: %,10d días%n", diasTranscurridos);
        System.out.println("\nHoy es: "+
                LocalDate.now().format(formatter));


    }
}
