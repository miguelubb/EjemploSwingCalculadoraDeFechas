import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class CalculadoraFechas extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField tfInicial;
    private JTextField tfFinal;
    private JButton calcularButton;
    private JTextArea salida;
    private JLabel lbSalida;

    public CalculadoraFechas() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try {
                   //aquí va mi código.
                   //para convertir las fechas de manera fácil se usará un DateTimeFormater
                   //DateTimeFormater, es un objeto que define el formato de Fecha y hora que queremos usar.
                   //Sirve tanto para convertir string a LocalDate como para convertir LocalDate a String
                   String fIni = tfInicial.getText();
                   String fFin = tfFinal.getText();
                   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                   LocalDate ini = LocalDate.parse(fIni, formatter);
                   LocalDate fin = LocalDate.parse(fFin, formatter);

                   Period p = Period.between(ini, fin);
                   long diasTranscurridos = ChronoUnit.DAYS.between(ini, fin);
                   String dias = String.format("Días transcurridos: %,d", diasTranscurridos);
                   String periodo = String.format("%d días, %d meses, %d años",
                           p.getDays(), p.getMonths(), p.getYears());
                   salida.setText(dias + "\n" + periodo);
               }catch (DateTimeParseException ex){
                   JOptionPane.showMessageDialog(null,
                           "Error en formato de fecha",
                           "Error",
                           JOptionPane.ERROR_MESSAGE);
               }
            }

        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        CalculadoraFechas dialog = new CalculadoraFechas();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
