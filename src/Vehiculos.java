import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Vehiculos {
    private JTextField search;
    private JButton SearchButton;
    private JTextField marcaT;
    private JTextField anioT;
    private JTextField cilinT;
    private JButton GuardarButton;
    private JButton leftButton;
    private JButton rightButton;
    private JPanel Vehi;
    private JLabel marcaL;
    private JLabel anioL;
    private JLabel cilindrajeL;
    private JLabel respuestaL;
    private JButton CargarButton;
    private JButton cleanButton;

    private ArrayList carrosM = new ArrayList();
    private ArrayList carrosA = new ArrayList();
    private ArrayList carrosC = new ArrayList();
    private boolean car=false;
    private int i=0;

    public Vehiculos() {
        GuardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carrosM.add(marcaT.getText());
                carrosA.add(anioT.getText());
                carrosC.add(cilinT.getText());
                marcaT.setText("");
                anioT.setText("");
                cilinT.setText("");
                respuestaL.setText("Se a guardado el auto correctamente");
            }
        });

        CargarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car=true;
                if (carrosM.size() == 0){
                    respuestaL.setText("No existen datos");
                }
                else{
                    marcaT.setText((String) carrosM.get(0));
                    anioT.setText((String) carrosA.get(0));
                    cilinT.setText((String) carrosC.get(0));
                }
            }
        });
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int aux = carrosM.size();
                if (car){
                    if (i < aux-1){
                        respuestaL.setText("");
                        i = i+1;
                        marcaT.setText((String) carrosM.get(i));
                        anioT.setText((String) carrosA.get(i));
                        cilinT.setText((String) carrosC.get(i));
                    }
                    else {
                        respuestaL.setText("No existen mas elementos");
                    }
                }
                else{
                    respuestaL.setText("Cargue los datos primero");
                }
            }
        });
        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (car) {
                    if (i > 0) {
                        i = i - 1;
                        respuestaL.setText("");
                        marcaT.setText((String) carrosM.get(i));
                        anioT.setText((String) carrosA.get(i));
                        cilinT.setText((String) carrosC.get(i));
                    } else {
                        respuestaL.setText("No existen mas elementos");
                    }
                }
                else{
                    respuestaL.setText("Cargue los datos primero");
                }
            }
        });
        cleanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(car){
                    marcaT.setText("");
                    anioT.setText("");
                    cilinT.setText("");
                    car=false;
                }
                else{
                    marcaT.setText("");
                    anioT.setText("");
                    cilinT.setText("");
                }
            }
        });
        SearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (carrosM.size() == 0){
                    respuestaL.setText("No existen datos");
                }
                else {

                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Vehiculos");
        frame.setContentPane(new Vehiculos().Vehi);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
