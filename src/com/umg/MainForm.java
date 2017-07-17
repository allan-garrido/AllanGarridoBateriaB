package com.umg;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.util.*;
import java.util.List;

public class MainForm extends JDialog {
    private JPanel contentPane;
    private JTextField TXTTiendanombre;
    private JTextField TXTtiendadireccion;
    private JTextField TXTTiendaempleados;
    private JTextField TXTTiendafechacreacion;
    private JTextField TXTTiendaespecialidad;
    private JButton guardarDatosButton;
    private JLabel LBLTiendanombre;
    private JLabel LBLTiendadireccion;
    private JLabel LBLTiendacempleados;
    private JLabel LBLTiendafecha;
    private JLabel LBLTiendaespecialidad;
    private JTextField TXTEmpnombre;
    private JTextField TXTEmpedad;
    private JTextField TXTEmpexp;
    private JTextField TXTEmpcargo;
    private JButton añadirEmpleadoButton;
    private JTable table1;
    private JTextField TXTAutomarca;
    private JTextField TXTAutoanio;
    private JTextField TXTAutomodelo;
    private JTextField TXTAutoprecio;
    private JButton añadirAutomovilButton;
    private JTable table2;
    private JButton promedioDeEdadDeButton;
    private JPanel dgPanel;
    private JButton verPrecioDeAutosButton;
    private JPanel ttPanel;
    private JTable table3;
    private JPanel eePanel;
    private JLabel LBLTotalv;
    private JLabel LBLTotalt;
    private DefaultTableModel tablemodel = new DefaultTableModel();
    private DefaultTableModel tablemodela = new DefaultTableModel();
    private DefaultTableModel tm3 = new DefaultTableModel();

    Tienda tienda = new Tienda();

    public MainForm() {
        setContentPane(contentPane);
        setModal(true);

        tablemodel.addColumn("Nombre");
        tablemodel.addColumn("Edad");
        tablemodel.addColumn("Experiencia");
        tablemodel.addColumn("Cargo");
        table1.setModel(tablemodel);

        tablemodela.addColumn("Marca");
        tablemodela.addColumn("Año");
        tablemodela.addColumn("Modelo");
        tablemodela.addColumn("Precio");
        table2.setModel(tablemodela);

        ttPanel.setVisible(false);

        tm3.addColumn("Modelo");
        tm3.addColumn("Año");
        tm3.addColumn("Precio");
        table3.setModel(tm3);


        guardarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tienda.setNombrecomercial(TXTTiendanombre.getText());
                tienda.setDireccion(TXTtiendadireccion.getText());
                tienda.setCantempleados(Integer.parseInt(TXTTiendaempleados.getText()));
                tienda.setFechacreacion(TXTTiendafechacreacion.getText());
                tienda.setEspecialidad(TXTTiendaespecialidad.getText());

                LBLTiendanombre.setText(tienda.getNombrecomercial());
                LBLTiendadireccion.setText(tienda.getDireccion());
                LBLTiendacempleados.setText(String.valueOf(tienda.getCantempleados()));
                LBLTiendafecha.setText(tienda.getFechacreacion());
                LBLTiendaespecialidad.setText(tienda.getEspecialidad());

                dgPanel.setVisible(false);
            }
        });

        añadirEmpleadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Empleado emp = new Empleado();

                emp.setNombre(TXTEmpnombre.getText());
                emp.setExperiencia(Integer.parseInt(TXTEmpexp.getText()));
                emp.setEdad(Integer.parseInt(TXTEmpedad.getText()));
                emp.setCargo(TXTEmpcargo.getText());

                tienda.addEmpleado(emp);

                for(int i = tablemodel.getRowCount()-1; i>=0; i--)
                    tablemodel.removeRow(i);

                for (Empleado tmpE:tienda.getEmpleados()
                     ) {
                    tablemodel.addRow(new Object[]{tmpE.getNombre(),
                                                    tmpE.getEdad(),
                                                    tmpE.getExperiencia(),
                                                    tmpE.getCargo()});
                }

                TXTEmpcargo.setText("");
                TXTEmpedad.setText("");
                TXTEmpexp.setText("");
                TXTEmpnombre.setText("");
            }
        });
        añadirAutomovilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Automovil a = new Automovil();

                a.setPrecio(Float.parseFloat(TXTAutoprecio.getText()));
                a.setModelo(TXTAutomodelo.getText());
                a.setAniofabricacion(Integer.parseInt(TXTAutoanio.getText()));
                a.setMarca(TXTAutomarca.getText());

                tienda.addAutomovil(a);

                for(int i = tablemodela.getRowCount()-1; i>=0; i--)
                    tablemodela.removeRow(i);

                float totalv =0;
                for (Automovil tmpA:tienda.getAutomoviles()
                     ) {
                    tablemodela.addRow(new Object[]{tmpA.getMarca(),
                                                    tmpA.getAniofabricacion(),
                                                    tmpA.getModelo(),
                                                    tmpA.getPrecio()});
                    totalv+=tmpA.getPrecio();
                    LBLTotalv.setText("Total Q."+String.valueOf(totalv));
                }

                TXTAutoprecio.setText("");
                TXTAutomodelo.setText("");
                TXTAutoanio.setText("");
                TXTAutomarca.setText("");

                eePanel.setVisible(false);
            }
        });
        promedioDeEdadDeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"El promedio de edad de los directores es de " +
                                                tienda.edadpromedioempleados("Director")+ " años.");
            }
        });
        verPrecioDeAutosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               List<Automovil> toyotas = new ArrayList<>();

                toyotas = tienda.precioautomovil("toyota");

                for(int i = tm3.getRowCount()-1; i>=0; i--)
                    tm3.removeRow(i);

                float totalt=0;
                for (Automovil tmpA:toyotas
                     ) {
                    tm3.addRow(new Object[]{
                            tmpA.getModelo(),
                            tmpA.getAniofabricacion(),
                            tmpA.getPrecio()});

                    totalt+=tmpA.getPrecio();
                }

                LBLTotalv.setText("Total Q."+String.valueOf(totalt));
                ttPanel.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        MainForm dialog = new MainForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
