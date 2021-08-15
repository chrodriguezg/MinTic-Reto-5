package view;

import controller.ControladorRequerimientosReto4;

import model.vo.Requerimiento1;
import model.vo.Requerimiento2;
import model.vo.Requerimiento3;


import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class VistaRequerimientosReto4{
    
    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    public static void requerimiento1(){
        JFrame frame = new JFrame("My Primer Requerimiento");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 1));

        JTextField txt1 = new JTextField(10);
        txt1.setHorizontalAlignment(JTextField.TRAILING);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("*** Lideres por Salario ***");
        panel.add(label);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.getContentPane().add(panel);

        panel = new JPanel();
        JComboBox<String> cb = new JComboBox<>();
        cb.setFont(new Font("Arial", Font.PLAIN, 20));

        try{
            ArrayList<Requerimiento1> requerimiento_1 = controlador.consultarRequerimiento_1();
            // Cada VO cargado, mostrarlo en la vista
            for(Requerimiento1 requerimiento1 : requerimiento_1){
                cb.addItem("El Lider "+ requerimiento1.getNombre()+ " "+
                requerimiento1.getPrimerApellido()+ " con Id "+
                requerimiento1.getIdLider()+ " Tien un salario de "+
                requerimiento1.getSalario()
                );
            };

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
        panel.add(cb);
        frame.getContentPane().add(panel);
        frame.setSize(700, 100);
        frame.setLocationRelativeTo(null);
        frame.setLocation(300, 100);
        frame.setVisible(true);
    }

    public static void requerimiento2(){
        JFrame frame = new JFrame("My Segundo Requerimiento");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 1));

        JTextField txt1 = new JTextField(10);
        txt1.setHorizontalAlignment(JTextField.TRAILING);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("*** Proyectos por Tipo ***");
        panel.add(label);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.getContentPane().add(panel);

        panel = new JPanel();
        JComboBox<String> cb = new JComboBox<>();
        cb.setFont(new Font("Arial", Font.PLAIN, 20));
  
        try{
            ArrayList<Requerimiento2> requerimiento_2 = controlador.consultarRequerimiento_2();
            // Cada VO cargado, mostrarlo en la vista
            for(Requerimiento2 requerimiento2 : requerimiento_2){
                cb.addItem("El proyecto de ID "+ requerimiento2.getIdProyecto()+ " de la constructora: "+
                requerimiento2.getConstructora()+ " de la ciudad  "+
                requerimiento2.getCiudad()+ " , tiene un estrato asignado de "+
                requerimiento2.getEstrato()
                );
            }
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
        panel.add(cb);
        frame.getContentPane().add(panel);
        frame.setSize(1200, 100);
        frame.setLocationRelativeTo(null);
        frame.setLocation(50, 200);
        frame.setVisible(true);        
    }

    public static void requerimiento3(){
        JFrame frame = new JFrame("My Tercer Requerimiento");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 1));

        JTextField txt1 = new JTextField(10);
        txt1.setHorizontalAlignment(JTextField.TRAILING);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("*** Lideres por Nombre ***");
        panel.add(label);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.getContentPane().add(panel);

        panel = new JPanel();
        JComboBox<String> cb = new JComboBox<>();
        cb.setFont(new Font("Arial", Font.PLAIN, 20));    

        try{
            ArrayList<Requerimiento3> requerimiento_3 = controlador.consultarRequerimiento_3();
            // Cada VO cargado, mostrarlo en la vista
            for(Requerimiento3 requerimiento3 : requerimiento_3){
                cb.addItem("El Lider con Id "+ requerimiento3.getIdLider()+ "  se llama "+
                requerimiento3.getNombre()+ " "+
                requerimiento3.getPrimerApellido()
                );
            }            
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
        panel.add(cb);
        frame.getContentPane().add(panel);
        frame.setSize(500, 100);
        frame.setLocationRelativeTo(null);
        frame.setLocation(400, 300);
        frame.setVisible(true);        
    }

}
