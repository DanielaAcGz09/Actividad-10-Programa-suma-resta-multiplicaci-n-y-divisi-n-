import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculadora extends JFrame {
    private JTextField txtNumero1;
    private JTextField txtNumero2;
    private JTextField txtResultado;
    private JButton btnSumar;
    private JButton btnRestar;
    private JButton btnMultiplicar;
    private JButton btnDividir;
    private Component miPanel;

    public calculadora() {
        setTitle("Calculadora");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblNumero1 = new JLabel("Número 1:");
        lblNumero1.setBounds(30, 30, 80, 30);
        add(lblNumero1);

        txtNumero1 = new JTextField();
        txtNumero1.setBounds(120, 30, 150, 30);
        add(txtNumero1);

        JLabel lblNumero2 = new JLabel("Número 2:");
        lblNumero2.setBounds(30, 70, 80, 30);
        add(lblNumero2);

        txtNumero2 = new JTextField();
        txtNumero2.setBounds(120, 70, 150, 30);
        add(txtNumero2);

        txtResultado = new JTextField();
        txtResultado.setBounds(120, 190, 150, 30);
        txtResultado.setEditable(false);
        add(txtResultado);

        btnSumar = new JButton("Sumar");
        btnSumar.setBounds(30, 120, 80, 30);
        add(btnSumar);

        btnRestar = new JButton("Restar");
        btnRestar.setBounds(120, 120, 80, 30);
        add(btnRestar);

        btnMultiplicar = new JButton("Multiplicar");
        btnMultiplicar.setBounds(210, 120, 100, 30);
        add(btnMultiplicar);

        btnDividir = new JButton("Dividir");
        btnDividir.setBounds(320, 120, 80, 30);
        add(btnDividir);

        btnSumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("sumar");
            }
        });

        btnRestar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("restar");
            }
        });

        btnMultiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("multiplicar");
            }
        });

        btnDividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("dividir");
            }
        });
    }

    private void realizarOperacion(String operacion) {
        try {
            double numero1 = Double.parseDouble(txtNumero1.getText());
            double numero2 = Double.parseDouble(txtNumero2.getText());
            double resultado = 0;

            switch (operacion) {
                case "sumar":
                    resultado = numero1 + numero2;
                    break;
                case "restar":
                    resultado = numero1 - numero2;
                    break;
                case "multiplicar":
                    resultado = numero1 * numero2;
                    break;
                case "dividir":
                    if (numero2 != 0) {
                        resultado = numero1 / numero2;
                    } else {
                        JOptionPane.showMessageDialog(miPanel, "Error");
                        return;
                    }
                    break;
            }

            txtResultado.setText(String.valueOf(resultado));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Numeros no validos.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new calculadora().setVisible(true);
            }
        });
    }
}
