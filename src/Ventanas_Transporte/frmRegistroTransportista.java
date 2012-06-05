/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmRegistroTransportista.java
 *
 * Created on 14/10/2011, 14:45:59
 */
package Ventanas_Transporte;


import Hibernate.GestorHibernate;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Clases_Modulo_Transporte.*;
import Gestores_Clases.*;
import java.awt.event.ActionListener;
import Gestores_Vista.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TimeZone;
import javax.swing.ButtonGroup;

/**
 *
 * @author Charito
 */
public class frmRegistroTransportista extends javax.swing.JInternalFrame{

    gestorBarrio gBarrio = new gestorBarrio();
    gestorCondicionContratacion gCondicion = new gestorCondicionContratacion();
    gestorDepartamento gdepto = new gestorDepartamento();
    gestorLocalidad gLocalidad = new gestorLocalidad();
    gestorPais gPais = new gestorPais();
    gestorProvincia gProvincia = new gestorProvincia();
    gestorTipoDocumento gtipoDoc = new gestorTipoDocumento();
    gestorTipoTelefono gTipoTel = new gestorTipoTelefono();
    gestorRegistroTransportista gRegistro = new gestorRegistroTransportista();
    
    public frmRegistroTransportista() {
        initComponents();    
        cmbPais.setModel(gPais.getComboModelPais());
        cmbMarcaCamion.setModel(gRegistro.rellenaComboMarca());
        //Las siguientes lineas son para dar a la pantalla el tamaño requerido y luego centrarla en la pantalla.
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla = kit.getScreenSize();
        int ancho = 1020;
        int alto = 620;
        this.setSize(ancho, alto);
        this.setLocation(50, 0);
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(buttonAcoplado);
        grupo.add(buttonCamion);
        grupo.add(buttonCamionAcoplado);
        buttonCamion.setSelected(true);
        
        txtFecha.setEnabled(false);
        txtFecha.setEditable(false);
        txtHora.setEditable(false);
        txtHora.setEnabled(false);
        //setear el campo de fecha con la del sistema
        GregorianCalendar gc=new GregorianCalendar();
        GregorianCalendar.getInstance();
        gc.setTimeZone(TimeZone.getTimeZone("GMT-3"));
        gc.get(Calendar.DAY_OF_WEEK);
        gc.get(Calendar.MONTH);
        gc.get(Calendar.YEAR);
        SimpleDateFormat formateador= new SimpleDateFormat("dd-MM-yyyy");
        txtFecha.setText(formateador.format(gc.getTime()));
        //setear el campo de hora con la del sistema
        GregorianCalendar calendario=new GregorianCalendar();
        GregorianCalendar.getInstance();
        gc.setTimeZone(TimeZone.getTimeZone("GMT-3"));
        calendario.get(Calendar.HOUR);
        calendario.get(Calendar.MINUTE);
        SimpleDateFormat formateadorHora=new SimpleDateFormat("hh:mm");
        txtHora.setText(formateadorHora.format(calendario.getTime()));
        
        
        //redimensionar columnas de la tabla
        tblVehiculo.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblVehiculo.getColumnModel().getColumn(1).setPreferredWidth(120);
        tblVehiculo.getColumnModel().getColumn(2).setPreferredWidth(120);
        tblVehiculo.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblVehiculo.getColumnModel().getColumn(4).setPreferredWidth(80);
        tblTelefono.getColumnModel().getColumn(0).setPreferredWidth(5);
        tblTelefono.getColumnModel().getColumn(1).setPreferredWidth(80);
    
        //Carga Tipo Documento
        cmbTipoDoc.setModel(gRegistro.rellenaComboTipoDoc());
        
        //Carga Provincia de acuerdo al Pais
        cmbPais.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0){
            cmbProvincia.setModel(gRegistro.rellenaCombo(cmbPais.getSelectedItem().toString()));
        }
        }
        );
        cmbProvincia.setModel(gRegistro.rellenaCombo(cmbPais.getSelectedItem().toString()));
        //Relleno Departamento de acuerdo a la Provincia
        cmbProvincia.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                cmbDepto.setModel(gRegistro.rellenaComboDepartamento(cmbProvincia.getSelectedItem().toString()));
            }
        });
        cmbDepto.setModel(gRegistro.rellenaComboDepartamento(cmbProvincia.getSelectedItem().toString()));
       
        //Relleno Localidad de acuerdo al Departamento
        cmbDepto.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                cmbLocalidad.setModel(gRegistro.rellenaComboLocalidad(cmbDepto.getSelectedItem().toString()));
            }
        });
        cmbLocalidad.setModel(gRegistro.rellenaComboLocalidad(cmbDepto.getSelectedItem().toString()));
        //Carga Barrio de acuerdo a Localidad
        cmbLocalidad.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0){
            cmbBarrio.setModel(gRegistro.rellenaComboBarrio(cmbLocalidad.getSelectedItem().toString()));
        }
        }
        );
         cmbBarrio.setModel(gRegistro.rellenaComboBarrio(cmbLocalidad.getSelectedItem().toString()));
         
         //Deshabilito Componentes Vehiculo
         gRegistro.deshabilitarCombo(cmbAnioAcoplado, cmbAnioCamion, cmbEjesAcoplado, cmbMarcaAcoplado, cmbMarcaCamion, cmbModeloCamion);
         gRegistro.deshabilitarTxt(txtAnchoAcoplado, txtDominioAcoplado, txtLargoAcplado, txtSerieAcoplado, txtTaraAcoplado, txtAnchoCamion, txtDominioCamion, txtKilometros, txtLargoCamion, txtTaraCamion);
//         btnAceptarCamion.setEnabled(true);
    
         cmbMarcaCamion.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0){
            cmbModeloCamion.setModel(gRegistro.rellenaComboModelo(cmbMarcaCamion.getSelectedItem().toString()));
        }
        }
        );
        cmbModeloCamion.setModel(gRegistro.rellenaComboModelo(cmbMarcaCamion.getSelectedItem().toString()));
         
         
         
         
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelTransportista = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbTipoDoc = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbEstadoCivil = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        cmbTipoTel = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTelefono = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        btnEliminarTel = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        btnAgregarTel = new javax.swing.JButton();
        calendarioNacimiento = new datechooser.beans.DateChooserCombo();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtCalle = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtDepto = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtPiso = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cmbProvincia = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        cmbLocalidad = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        cmbPais = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        cmbBarrio = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        cmbDepto = new javax.swing.JComboBox();
        jPanel18 = new javax.swing.JPanel();
        btnAgregarDepartamento = new javax.swing.JButton();
        btnAgregarPais = new javax.swing.JButton();
        btnAgregarBarrio = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        btnAgregarProvincia = new javax.swing.JButton();
        btnAgregarLocalidad = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        cmbTipoContratacion = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtCUIL = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        calendarioFin = new datechooser.beans.DateChooserCombo();
        calendarioIngreso = new datechooser.beans.DateChooserCombo();
        jPanel8 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        btnBuscarTransportista = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        panelVehiculo = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        cmbModeloCamion = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        cmbMarcaCamion = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        cmbAnioCamion = new javax.swing.JComboBox();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtKilometros = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtDominioCamion = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtLargoCamion = new javax.swing.JTextField();
        txtTaraCamion = new javax.swing.JTextField();
        txtAnchoCamion = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        pnlAcoplado = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        cmbMarcaAcoplado = new javax.swing.JComboBox();
        jLabel39 = new javax.swing.JLabel();
        cmbEjesAcoplado = new javax.swing.JComboBox();
        jLabel40 = new javax.swing.JLabel();
        cmbAnioAcoplado = new javax.swing.JComboBox();
        jLabel41 = new javax.swing.JLabel();
        txtDominioAcoplado = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtTaraAcoplado = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txtLargoAcplado = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txtSerieAcoplado = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txtAnchoAcoplado = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        buttonCamion = new javax.swing.JRadioButton();
        buttonAcoplado = new javax.swing.JRadioButton();
        buttonCamionAcoplado = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVehiculo = new javax.swing.JTable();
        btnEliminarVehiculo = new javax.swing.JButton();
        btnAgregarCamionAcoplado = new javax.swing.JButton();
        btnAgregarCamion = new javax.swing.JButton();
        btnAgregarAcoplado = new javax.swing.JButton();
        btnEditarVehiculo = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEmitirFicha = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setIconifiable(true);
        setMaximizable(true);
        setTitle("Transportista");
        setPreferredSize(new java.awt.Dimension(1021, 50));

        jPanel4.setPreferredSize(new java.awt.Dimension(1001, 400));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Fecha");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Hora");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Usuario");

        panelTransportista.setLayout(null);

        jPanel2.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Apellido");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 10, 100, 20);

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });
        jPanel2.add(txtApellido);
        txtApellido.setBounds(130, 10, 240, 20);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Nombres");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(390, 10, 70, 20);

        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });
        jPanel2.add(txtNombres);
        txtNombres.setBounds(450, 10, 240, 20);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Tipo Documento");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(10, 40, 100, 20);

        jPanel2.add(cmbTipoDoc);
        cmbTipoDoc.setBounds(130, 40, 120, 20);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Numero Documento");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(330, 40, 120, 20);

        txtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentoKeyTyped(evt);
            }
        });
        jPanel2.add(txtDocumento);
        txtDocumento.setBounds(450, 40, 120, 20);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Fecha de Nacimiento");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(10, 70, 120, 20);

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Estado Civil");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(380, 70, 70, 20);

        cmbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Soltero", "Casado", "Viudo" }));
        jPanel2.add(cmbEstadoCivil);
        cmbEstadoCivil.setBounds(450, 70, 120, 20);

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Tipo Teléfono");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(10, 100, 80, 20);

        jPanel2.add(cmbTipoTel);
        cmbTipoTel.setBounds(130, 100, 120, 20);

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("Número Teléfono");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(350, 100, 100, 20);

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel2.add(txtTelefono);
        txtTelefono.setBounds(450, 100, 170, 20);

        tblTelefono.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo Teléfono", "Número Teléfono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTelefono.getTableHeader().setResizingAllowed(false);
        tblTelefono.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblTelefono);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(210, 130, 320, 60);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel7);
        jPanel7.setBounds(-20, -50, 700, 40);

        btnEliminarTel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        btnEliminarTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTelActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminarTel);
        btnEliminarTel.setBounds(530, 150, 40, 30);

        btnAgregarTel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Agregar.png"))); // NOI18N
        btnAgregarTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(btnAgregarTel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnAgregarTel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel10);
        jPanel10.setBounds(580, 70, 100, 70);
        jPanel2.add(calendarioNacimiento);
        calendarioNacimiento.setBounds(130, 70, 120, 20);

        panelTransportista.add(jPanel2);
        jPanel2.setBounds(140, 30, 720, 190);

        jPanel3.setLayout(null);

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setText("Calle");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(10, 10, 40, 20);

        txtCalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCalleKeyTyped(evt);
            }
        });
        jPanel3.add(txtCalle);
        txtCalle.setBounds(50, 10, 240, 20);

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setText("Número");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(330, 10, 50, 20);

        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroKeyTyped(evt);
            }
        });
        jPanel3.add(txtNumero);
        txtNumero.setBounds(380, 10, 60, 20);

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setText("Piso");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(475, 10, 30, 20);
        jPanel3.add(txtDepto);
        txtDepto.setBounds(630, 10, 50, 20);

        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setText("Depto");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(590, 10, 40, 20);

        txtPiso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPisoKeyTyped(evt);
            }
        });
        jPanel3.add(txtPiso);
        txtPiso.setBounds(510, 10, 50, 20);

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setText("País");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(70, 40, 40, 20);

        jPanel3.add(cmbProvincia);
        cmbProvincia.setBounds(440, 50, 190, 20);

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setText("Provincia");
        jPanel3.add(jLabel18);
        jLabel18.setBounds(380, 50, 60, 20);

        jPanel3.add(cmbLocalidad);
        cmbLocalidad.setBounds(440, 90, 190, 20);

        jLabel19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel19.setText("Departamento");
        jPanel3.add(jLabel19);
        jLabel19.setBounds(20, 80, 100, 20);

        jPanel3.add(cmbPais);
        cmbPais.setBounds(100, 40, 190, 20);

        jLabel20.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel20.setText("Localidad");
        jPanel3.add(jLabel20);
        jLabel20.setBounds(380, 90, 60, 20);

        jPanel3.add(cmbBarrio);
        cmbBarrio.setBounds(100, 120, 190, 20);

        jLabel21.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel21.setText("Barrio");
        jPanel3.add(jLabel21);
        jLabel21.setBounds(60, 120, 50, 20);

        jPanel3.add(cmbDepto);
        cmbDepto.setBounds(100, 80, 190, 20);

        btnAgregarDepartamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Agregar.png"))); // NOI18N
        btnAgregarDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDepartamentoActionPerformed(evt);
            }
        });

        btnAgregarPais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Agregar.png"))); // NOI18N
        btnAgregarPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPaisActionPerformed(evt);
            }
        });

        btnAgregarBarrio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Agregar.png"))); // NOI18N
        btnAgregarBarrio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarBarrioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarPais, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarDepartamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarBarrio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(btnAgregarPais, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregarDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregarBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jPanel3.add(jPanel18);
        jPanel18.setBounds(250, 30, 100, 120);

        btnAgregarProvincia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Agregar.png"))); // NOI18N
        btnAgregarProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProvinciaActionPerformed(evt);
            }
        });

        btnAgregarLocalidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Agregar.png"))); // NOI18N
        btnAgregarLocalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarLocalidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarProvincia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarLocalidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnAgregarProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregarLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel20);
        jPanel20.setBounds(590, 20, 100, 110);

        panelTransportista.add(jPanel3);
        jPanel3.setBounds(140, 220, 720, 150);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de contratacion", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        jPanel5.setLayout(null);

        jLabel22.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel22.setText("Tipo de Contratación");
        jPanel5.add(jLabel22);
        jLabel22.setBounds(10, 20, 150, 20);
        jPanel5.add(cmbTipoContratacion);
        cmbTipoContratacion.setBounds(130, 20, 120, 20);

        jLabel23.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel23.setText("Fecha de Ingreso");
        jPanel5.add(jLabel23);
        jLabel23.setBounds(280, 20, 100, 20);

        jLabel24.setText("CUIL");
        jPanel5.add(jLabel24);
        jLabel24.setBounds(100, 50, 30, 20);

        txtCUIL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCUILKeyTyped(evt);
            }
        });
        jPanel5.add(txtCUIL);
        txtCUIL.setBounds(130, 50, 160, 20);

        jLabel25.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel25.setText("Fecha de Salida");
        jPanel5.add(jLabel25);
        jLabel25.setBounds(500, 20, 110, 20);
        jPanel5.add(calendarioFin);
        calendarioFin.setBounds(590, 20, 100, 20);
        jPanel5.add(calendarioIngreso);
        calendarioIngreso.setBounds(380, 20, 100, 20);

        panelTransportista.add(jPanel5);
        jPanel5.setBounds(170, 370, 700, 80);

        jPanel8.setLayout(null);

        jLabel26.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel26.setText("Buscar Transportista");
        jPanel8.add(jLabel26);
        jLabel26.setBounds(10, 0, 130, 30);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel13);
        jPanel13.setBounds(580, 70, 100, 70);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel14);
        jPanel14.setBounds(580, 70, 100, 70);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel15);
        jPanel15.setBounds(580, 70, 100, 70);

        btnBuscarTransportista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar.png"))); // NOI18N
        btnBuscarTransportista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTransportistaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnBuscarTransportista, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(btnBuscarTransportista, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel19);
        jPanel19.setBounds(120, 0, 100, 40);

        panelTransportista.add(jPanel8);
        jPanel8.setBounds(360, 0, 250, 40);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        panelTransportista.add(jPanel16);
        jPanel16.setBounds(580, 70, 100, 70);

        jTabbedPane1.addTab("Transportista", panelTransportista);

        panelVehiculo.setLayout(null);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del camión", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        jPanel9.setLayout(null);

        jLabel27.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel27.setText("Marca");
        jPanel9.add(jLabel27);
        jLabel27.setBounds(50, 40, 50, 20);

        jPanel9.add(cmbModeloCamion);
        cmbModeloCamion.setBounds(330, 40, 130, 20);

        jLabel28.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel28.setText("Modelo");
        jPanel9.add(jLabel28);
        jLabel28.setBounds(280, 40, 60, 20);

        jPanel9.add(cmbMarcaCamion);
        cmbMarcaCamion.setBounds(100, 40, 130, 20);

        jLabel29.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel29.setText("Año de Compra");
        jPanel9.add(jLabel29);
        jLabel29.setBounds(10, 70, 90, 20);

        jPanel9.add(cmbAnioCamion);
        cmbAnioCamion.setBounds(100, 70, 100, 20);

        jLabel30.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel30.setText("Kilometros");
        jPanel9.add(jLabel30);
        jLabel30.setBounds(260, 70, 80, 20);

        jLabel31.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel31.setText("Dominio");
        jPanel9.add(jLabel31);
        jLabel31.setBounds(50, 100, 60, 20);

        txtKilometros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKilometrosKeyTyped(evt);
            }
        });
        jPanel9.add(txtKilometros);
        txtKilometros.setBounds(330, 70, 100, 20);

        jLabel32.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel32.setText("Largo");
        jPanel9.add(jLabel32);
        jLabel32.setBounds(60, 130, 40, 20);
        jPanel9.add(txtDominioCamion);
        txtDominioCamion.setBounds(100, 100, 100, 20);

        jLabel33.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel33.setText("Ancho");
        jPanel9.add(jLabel33);
        jLabel33.setBounds(280, 130, 60, 20);

        jLabel34.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel34.setText("Tara");
        jPanel9.add(jLabel34);
        jLabel34.setBounds(290, 100, 60, 20);

        txtLargoCamion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLargoCamionKeyTyped(evt);
            }
        });
        jPanel9.add(txtLargoCamion);
        txtLargoCamion.setBounds(100, 130, 100, 20);

        txtTaraCamion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTaraCamionKeyTyped(evt);
            }
        });
        jPanel9.add(txtTaraCamion);
        txtTaraCamion.setBounds(330, 100, 100, 20);

        txtAnchoCamion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnchoCamionKeyTyped(evt);
            }
        });
        jPanel9.add(txtAnchoCamion);
        txtAnchoCamion.setBounds(330, 130, 100, 20);

        jLabel36.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel36.setText("mts");
        jPanel9.add(jLabel36);
        jLabel36.setBounds(430, 130, 30, 20);

        jLabel37.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel37.setText("mts");
        jPanel9.add(jLabel37);
        jLabel37.setBounds(200, 130, 30, 20);

        panelVehiculo.add(jPanel9);
        jPanel9.setBounds(40, 60, 471, 190);

        pnlAcoplado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del acoplado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        pnlAcoplado.setLayout(null);

        jLabel38.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel38.setText("Marca");
        pnlAcoplado.add(jLabel38);
        jLabel38.setBounds(60, 40, 50, 20);

        pnlAcoplado.add(cmbMarcaAcoplado);
        cmbMarcaAcoplado.setBounds(100, 40, 130, 20);

        jLabel39.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel39.setText("Ejes");
        pnlAcoplado.add(jLabel39);
        jLabel39.setBounds(250, 40, 60, 20);

        pnlAcoplado.add(cmbEjesAcoplado);
        cmbEjesAcoplado.setBounds(290, 40, 90, 20);

        jLabel40.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel40.setText("Año de Compra");
        pnlAcoplado.add(jLabel40);
        jLabel40.setBounds(10, 70, 90, 20);

        pnlAcoplado.add(cmbAnioAcoplado);
        cmbAnioAcoplado.setBounds(100, 70, 100, 20);

        jLabel41.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel41.setText("Dominio");
        pnlAcoplado.add(jLabel41);
        jLabel41.setBounds(230, 70, 70, 20);
        pnlAcoplado.add(txtDominioAcoplado);
        txtDominioAcoplado.setBounds(290, 70, 100, 20);

        jLabel42.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel42.setText("Serie");
        pnlAcoplado.add(jLabel42);
        jLabel42.setBounds(250, 100, 70, 20);

        txtTaraAcoplado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTaraAcopladoKeyTyped(evt);
            }
        });
        pnlAcoplado.add(txtTaraAcoplado);
        txtTaraAcoplado.setBounds(100, 100, 100, 20);

        jLabel43.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel43.setText("Largo");
        pnlAcoplado.add(jLabel43);
        jLabel43.setBounds(60, 130, 40, 20);

        txtLargoAcplado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLargoAcpladoKeyTyped(evt);
            }
        });
        pnlAcoplado.add(txtLargoAcplado);
        txtLargoAcplado.setBounds(100, 130, 100, 20);

        jLabel44.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel44.setText("mts");
        pnlAcoplado.add(jLabel44);
        jLabel44.setBounds(390, 130, 30, 20);

        jLabel45.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel45.setText("Ancho");
        pnlAcoplado.add(jLabel45);
        jLabel45.setBounds(250, 130, 50, 20);
        pnlAcoplado.add(txtSerieAcoplado);
        txtSerieAcoplado.setBounds(290, 100, 100, 20);

        jLabel46.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel46.setText("mts");
        pnlAcoplado.add(jLabel46);
        jLabel46.setBounds(200, 130, 30, 20);

        jLabel47.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel47.setText("Tara");
        pnlAcoplado.add(jLabel47);
        jLabel47.setBounds(70, 100, 50, 20);

        txtAnchoAcoplado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnchoAcopladoKeyTyped(evt);
            }
        });
        pnlAcoplado.add(txtAnchoAcoplado);
        txtAnchoAcoplado.setBounds(290, 130, 100, 20);

        panelVehiculo.add(pnlAcoplado);
        pnlAcoplado.setBounds(517, 60, 418, 190);

        jPanel11.setLayout(null);

        jLabel35.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel35.setText("Tipo de Vehiculo");
        jPanel11.add(jLabel35);
        jLabel35.setBounds(10, 10, 140, 20);

        buttonCamion.setText("Camión");
        buttonCamion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCamionActionPerformed(evt);
            }
        });
        jPanel11.add(buttonCamion);
        buttonCamion.setBounds(130, 10, 93, 23);

        buttonAcoplado.setText("Acoplado");
        buttonAcoplado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAcopladoActionPerformed(evt);
            }
        });
        jPanel11.add(buttonAcoplado);
        buttonAcoplado.setBounds(220, 10, 80, 23);

        buttonCamionAcoplado.setText("Camión y Acoplado");
        buttonCamionAcoplado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCamionAcopladoActionPerformed(evt);
            }
        });
        jPanel11.add(buttonCamionAcoplado);
        buttonCamionAcoplado.setBounds(310, 10, 120, 23);

        panelVehiculo.add(jPanel11);
        jPanel11.setBounds(309, 11, 535, 43);

        tblVehiculo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dominio Camión", "Marca", "Modelo", "Dominio Acoplado", "Serie"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVehiculo.getTableHeader().setResizingAllowed(false);
        tblVehiculo.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblVehiculo);

        panelVehiculo.add(jScrollPane1);
        jScrollPane1.setBounds(220, 310, 570, 130);

        btnEliminarVehiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        panelVehiculo.add(btnEliminarVehiculo);
        btnEliminarVehiculo.setBounds(800, 410, 40, 30);

        btnAgregarCamionAcoplado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Agregar.png"))); // NOI18N
        btnAgregarCamionAcoplado.setText("Agregar");
        btnAgregarCamionAcoplado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCamionAcopladoActionPerformed(evt);
            }
        });
        panelVehiculo.add(btnAgregarCamionAcoplado);
        btnAgregarCamionAcoplado.setBounds(460, 270, 110, 30);

        btnAgregarCamion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Agregar.png"))); // NOI18N
        btnAgregarCamion.setText("Agregar");
        btnAgregarCamion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCamionActionPerformed(evt);
            }
        });
        panelVehiculo.add(btnAgregarCamion);
        btnAgregarCamion.setBounds(460, 270, 110, 30);

        btnAgregarAcoplado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Agregar.png"))); // NOI18N
        btnAgregarAcoplado.setText("Agregar");
        btnAgregarAcoplado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAcopladoActionPerformed(evt);
            }
        });
        panelVehiculo.add(btnAgregarAcoplado);
        btnAgregarAcoplado.setBounds(460, 270, 110, 30);

        btnEditarVehiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        btnEditarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarVehiculoActionPerformed(evt);
            }
        });
        panelVehiculo.add(btnEditarVehiculo);
        btnEditarVehiculo.setBounds(800, 370, 40, 30);

        jTabbedPane1.addTab("Vehiculo", panelVehiculo);

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/UsuarioLogueado.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 509, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(2, 2, 2)
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(95, 95, 95))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)))
                    .addComponent(jLabel48)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnNuevo.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icononuevo.PNG"))); // NOI18N
        btnNuevo.setText("Nuevo");

        btnGuardar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEmitirFicha.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnEmitirFicha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/emitir ficha.png"))); // NOI18N
        btnEmitirFicha.setText("Emitir Ficha");

        btnCancelar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(344, 344, 344)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEmitirFicha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmitirFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    if(tblVehiculo.getRowCount()!=0){
    DefaultTableModel modelo = (DefaultTableModel) tblTelefono.getModel();
    GestorHibernate gestorH = new GestorHibernate();
    Transportista transportista= new Transportista();

    transportista.setApellido(txtApellido.getText());
    transportista.setFechaNacimiento(calendarioNacimiento.getText());
    transportista.setNombre(txtNombres.getText());
    transportista.setNumeroDocumento(txtDocumento.getText());
    for(int i=0;i<modelo.getRowCount();i++){
        transportista.setNumeroTelefono((String)modelo.getValueAt(i, 1));
        transportista.setTipoTelefono((Set<TipoTelefono>)(TipoTelefono) modelo.getValueAt(i, 0));
    }
    transportista.setCondicionContratacion((CondicionContratacion)cmbTipoContratacion.getSelectedItem());
    transportista.setCuil(txtCUIL.getText());
    transportista.setEstadoCivil((String)cmbEstadoCivil.getSelectedItem());
    transportista.setFechaIngreso(calendarioNacimiento.getText());
    transportista.setFechaSalida(calendarioFin.getText());
    transportista.setTipoDocumento((TipoDocumento)cmbTipoDoc.getSelectedItem());
    Pais pais= new Pais();
    pais.setNombrePais((String)cmbPais.getSelectedItem());
    Provincia provincia = new Provincia();
    provincia.setNombreProvincia((String)cmbProvincia.getSelectedItem());
    provincia.setPais(pais);
    Departamento departamento = new Departamento();
    departamento.setNombreDepartamento((String)cmbDepto.getSelectedItem());
    departamento.setProvincia(provincia);
    Localidad localidad = new Localidad();
    localidad.setNombreLocalidad((String)cmbLocalidad.getSelectedItem());
    localidad.setDepartamento(departamento);
    Barrio barrio = new Barrio();
    barrio.setNombreBarrio((String)cmbBarrio.getSelectedItem());
    barrio.setLocalidad(localidad);
    Domicilio domicilio = new Domicilio();
    domicilio.setCalle(txtCalle.getText());
    domicilio.setDepartamento(txtDepto.getText());
    domicilio.setNumero((Integer.parseInt(txtNumero.getText())));
    domicilio.setPiso((Integer.parseInt(txtPiso.getText())));
    domicilio.setBarrio(barrio);
    gestorH.guardarObjeto(domicilio);
    transportista.setDomicilio(domicilio);
    gestorH.guardarObjeto(transportista);
    DefaultTableModel modeloT = (DefaultTableModel) tblVehiculo.getModel();
    for (int i =0; i<tblVehiculo.getRowCount(); i++){
        Vehiculo vehiculo = new Vehiculo();
        vehiculo = gRegistro.editar((String) modeloT.getValueAt(i, 0));
        vehiculo.setTransportista(transportista);

    }
    
}  else{
        JOptionPane.showMessageDialog(null, "No posee un vehiculo asociado.\n Registre un vehiculo");
    }
        
}//GEN-LAST:event_btnGuardarActionPerformed

private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    int respuesta = JOptionPane.showConfirmDialog(null, "Confirma que desea cancelar la operación?");
    if (respuesta==0){
    dispose();
    }
}//GEN-LAST:event_btnCancelarActionPerformed

private void buttonCamionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCamionActionPerformed
     gRegistro.habilitar(txtAnchoCamion, txtDominioCamion, txtKilometros, txtLargoCamion, txtTaraCamion, cmbAnioCamion, cmbMarcaCamion, cmbModeloCamion);
     gRegistro.deshabilitar(txtAnchoAcoplado, txtDominioAcoplado, txtLargoAcplado, txtLargoAcplado, txtSerieAcoplado, cmbAnioAcoplado, cmbEjesAcoplado, cmbMarcaAcoplado);
//     btnAceptarCamion.setVisible(true);
     btnAgregarCamion.setVisible(false);
     btnAgregarCamionAcoplado.setVisible(false);
}//GEN-LAST:event_buttonCamionActionPerformed

private void buttonAcopladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAcopladoActionPerformed
    gRegistro.habilitar(txtAnchoAcoplado, txtDominioAcoplado, txtLargoAcplado, txtLargoAcplado, txtSerieAcoplado, cmbAnioAcoplado, cmbEjesAcoplado, cmbMarcaAcoplado);
    gRegistro.deshabilitar(txtAnchoCamion, txtDominioCamion, txtKilometros, txtLargoCamion, txtTaraCamion, cmbAnioCamion, cmbMarcaCamion, cmbModeloCamion);
    btnAgregarCamion.setVisible(true);
//    btnAceptarCamion.setVisible(false);
    btnAgregarCamionAcoplado.setVisible(false);
}//GEN-LAST:event_buttonAcopladoActionPerformed

private void buttonCamionAcopladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCamionAcopladoActionPerformed
     gRegistro.habilitar(txtAnchoAcoplado, txtDominioAcoplado, txtLargoAcplado, txtLargoAcplado, txtSerieAcoplado, cmbAnioAcoplado, cmbEjesAcoplado, cmbMarcaAcoplado);
     gRegistro.habilitar(txtAnchoCamion, txtDominioCamion, txtKilometros, txtLargoCamion, txtTaraCamion, cmbAnioCamion, cmbMarcaCamion, cmbModeloCamion);
     btnAgregarCamion.setVisible(false);
//     btnAceptarCamion.setVisible(false);
     btnAgregarCamionAcoplado.setVisible(true);
}//GEN-LAST:event_buttonCamionAcopladoActionPerformed

private void btnAgregarCamionAcopladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCamionAcopladoActionPerformed
   DefaultTableModel modeloTabla = (DefaultTableModel) tblVehiculo.getModel();
    GestorHibernate gestorH= new GestorHibernate();
    Vehiculo vehiculo = new Vehiculo();
    vehiculo.setAncho((Integer.parseInt(txtAnchoCamion.getText())));
    vehiculo.setAnioCompra((AnioCompra)cmbAnioCamion.getSelectedItem());
    vehiculo.setCantidadKms((Double.parseDouble (txtKilometros.getText())));
    vehiculo.setDominio(txtDominioCamion.getText());
    vehiculo.setLargo(Double.parseDouble(txtLargoCamion.getText()));
    vehiculo.setModelo((Modelo)cmbModeloCamion.getSelectedItem());
    vehiculo.setTara(Double.parseDouble(txtTaraCamion.getText()));
    gestorH.guardarObjeto(vehiculo);
    Acoplado acoplado = new Acoplado();
    acoplado.setAncho(Double.parseDouble(txtAnchoAcoplado.getText()));
    acoplado.setAnioCompra((AnioCompra)cmbAnioAcoplado.getSelectedItem());
    acoplado.setDominio(txtDominioAcoplado.getText());
    acoplado.setLargo(Double.parseDouble(txtLargoAcplado.getText()));
    acoplado.setMarca((Marca)cmbMarcaAcoplado.getSelectedItem());
    acoplado.setVehiculo(vehiculo);
    gestorH.guardarObjeto(acoplado);
    Object fila[]= {txtDominioCamion.getText(), cmbMarcaCamion.getSelectedItem(), cmbModeloCamion.getSelectedItem(), txtDominioAcoplado.getText(), txtSerieAcoplado.getText()};
    modeloTabla.addRow(fila);
    tblVehiculo.setModel(modeloTabla);
    txtTaraCamion.setText("");
    txtAnchoCamion.setText("");
    txtDominioCamion.setText("");
    txtKilometros.setText("");
    txtLargoCamion.setText("");
    txtAnchoAcoplado.setText("");
    txtDominioAcoplado.setText("");
    txtSerieAcoplado.setText("");
    txtLargoAcplado.setText("");
    txtTaraAcoplado.setText("");
//    btnAceptarCamion.setEnabled(true);
}//GEN-LAST:event_btnAgregarCamionAcopladoActionPerformed

private void btnEditarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarVehiculoActionPerformed
    if(buttonAcoplado.isSelected()==true){
    DefaultTableModel modeloTabla = (DefaultTableModel) tblVehiculo.getModel();
    int fila= tblVehiculo.getSelectedRow();
    Vehiculo v= gRegistro.editar((String) modeloTabla.getValueAt(fila, 0));
    txtAnchoCamion.setText(String.valueOf(v.getAncho()));
    txtDominioCamion.setText(v.getDominio());
    txtKilometros.setText(String.valueOf(v.getCantidadKms()));
    txtLargoCamion.setText(String.valueOf(v.getLargo()));
    txtTaraCamion.setText(String.valueOf(v.getTara()));
    cmbAnioCamion.setSelectedItem(v.getAnioCompra());
    cmbModeloCamion.setSelectedItem(v.getModelo());
    Modelo mod= v.getModelo();
    Marca marca = mod.getMarca();
    cmbMarcaCamion.setSelectedItem(marca);
    modeloTabla.removeRow(tblVehiculo.getSelectedRow());
   }
}//GEN-LAST:event_btnEditarVehiculoActionPerformed

private void btnAgregarTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTelActionPerformed
    DefaultTableModel modeloTabla = (DefaultTableModel)tblTelefono.getModel();
    Object fila[] = {cmbTipoTel.getSelectedItem(), txtTelefono.getText()};
    modeloTabla.addRow(fila);
    tblTelefono.setModel(modeloTabla);
    txtTelefono.setText("");
}//GEN-LAST:event_btnAgregarTelActionPerformed

private void btnEliminarTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTelActionPerformed
    DefaultTableModel modeloT = (DefaultTableModel) tblTelefono.getModel();
    modeloT.removeRow(tblTelefono.getSelectedRow());
}//GEN-LAST:event_btnEliminarTelActionPerformed

private void btnAgregarDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDepartamentoActionPerformed
    frmRegistrarProvincia provincia = new frmRegistrarProvincia();
    frmPrincipal.Escritorio.add(provincia);
    provincia.toFront();
    provincia.setVisible(true);
}//GEN-LAST:event_btnAgregarDepartamentoActionPerformed

private void btnBuscarTransportistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTransportistaActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_btnBuscarTransportistaActionPerformed

private void btnAgregarAcopladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAcopladoActionPerformed
    DefaultTableModel modeloTabla = (DefaultTableModel) tblVehiculo.getModel();
    GestorHibernate gestorH = new GestorHibernate();
    Vehiculo vehiculo = gRegistro.editar(txtDominioCamion.getText());
    Acoplado acoplado = new Acoplado();
    acoplado.setAncho(Double.parseDouble(txtAnchoAcoplado.getText()));
    acoplado.setAnioCompra((AnioCompra)cmbAnioAcoplado.getSelectedItem());
    acoplado.setDominio(txtDominioAcoplado.getText());
    acoplado.setLargo(Double.parseDouble(txtLargoAcplado.getText()));
    acoplado.setMarca((Marca)cmbMarcaAcoplado.getSelectedItem());
    acoplado.setVehiculo(vehiculo);
    gestorH.guardarObjeto(acoplado);

    Object fila[]= {txtDominioCamion.getText(), cmbMarcaCamion.getSelectedItem(), cmbModeloCamion.getSelectedItem(), txtDominioAcoplado.getText(), txtSerieAcoplado.getText()};
    modeloTabla.addRow(fila);
    tblVehiculo.setModel(modeloTabla);
    txtTaraCamion.setText("");
    txtAnchoCamion.setText("");
    txtDominioCamion.setText("");
    txtKilometros.setText("");
    txtLargoCamion.setText("");
    txtAnchoAcoplado.setText("");
    txtDominioAcoplado.setText("");
    txtSerieAcoplado.setText("");
    txtLargoAcplado.setText("");
    txtTaraAcoplado.setText("");
//    btnAceptarCamion.setEnabled(true);
}//GEN-LAST:event_btnAgregarAcopladoActionPerformed

private void btnAgregarCamionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCamionActionPerformed
    DefaultTableModel modeloTabla = (DefaultTableModel) tblVehiculo.getModel();
    GestorHibernate gestorH = new GestorHibernate();
    Vehiculo vehiculo = new Vehiculo();
    vehiculo.setAncho((Integer.parseInt(txtAnchoCamion.getText())));
    vehiculo.setAnioCompra((AnioCompra)cmbAnioCamion.getSelectedItem());
    vehiculo.setCantidadKms((Double.parseDouble (txtKilometros.getText())));
    vehiculo.setDominio(txtDominioCamion.getText());
    vehiculo.setLargo(Double.parseDouble(txtLargoCamion.getText()));
    vehiculo.setModelo((Modelo)cmbModeloCamion.getSelectedItem());
    vehiculo.setTara(Double.parseDouble(txtTaraCamion.getText()));
    gestorH.guardarObjeto(vehiculo);

    Object fila[]= {txtDominioCamion.getText(), cmbMarcaCamion.getSelectedItem(), cmbModeloCamion.getSelectedItem(), "No posee", "No posee"};
    modeloTabla.addRow(fila);
    tblVehiculo.setModel(modeloTabla);
    txtTaraCamion.setText("");
    txtAnchoCamion.setText("");
    txtDominioCamion.setText("");
    txtKilometros.setText("");
    txtLargoCamion.setText("");
//    btnAceptarCamion.setEnabled(true);
}//GEN-LAST:event_btnAgregarCamionActionPerformed

private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
    char c = evt.getKeyChar();
        if (Character.isDigit(c) == false) {
          
        }else{
           evt.consume();
              }
}//GEN-LAST:event_txtApellidoKeyTyped

private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
    char c = evt.getKeyChar();
        if (Character.isDigit(c) == false) {
          
        }else{
           evt.consume();
              }
}//GEN-LAST:event_txtNombresKeyTyped

private void txtDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoKeyTyped
    char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }
}//GEN-LAST:event_txtDocumentoKeyTyped

private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }
}//GEN-LAST:event_txtTelefonoKeyTyped

private void txtCalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCalleKeyTyped
    char c = evt.getKeyChar();
        if (Character.isDigit(c) == false) {
          
        }else{
           evt.consume();
              }
}//GEN-LAST:event_txtCalleKeyTyped

private void txtNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyTyped
    char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }
}//GEN-LAST:event_txtNumeroKeyTyped

private void txtPisoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPisoKeyTyped
char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }
}//GEN-LAST:event_txtPisoKeyTyped

private void txtCUILKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCUILKeyTyped
    char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }
}//GEN-LAST:event_txtCUILKeyTyped

private void txtLargoCamionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLargoCamionKeyTyped
    char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }
}//GEN-LAST:event_txtLargoCamionKeyTyped

private void txtKilometrosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKilometrosKeyTyped
    char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }
}//GEN-LAST:event_txtKilometrosKeyTyped

private void txtTaraCamionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTaraCamionKeyTyped
    char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }
}//GEN-LAST:event_txtTaraCamionKeyTyped

private void txtAnchoCamionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnchoCamionKeyTyped
    char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }
}//GEN-LAST:event_txtAnchoCamionKeyTyped

private void txtTaraAcopladoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTaraAcopladoKeyTyped
    char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }
}//GEN-LAST:event_txtTaraAcopladoKeyTyped

private void txtLargoAcpladoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLargoAcpladoKeyTyped
    char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }
}//GEN-LAST:event_txtLargoAcpladoKeyTyped

private void txtAnchoAcopladoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnchoAcopladoKeyTyped
    char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }
}//GEN-LAST:event_txtAnchoAcopladoKeyTyped

    private void btnAgregarProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProvinciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarProvinciaActionPerformed

    private void btnAgregarLocalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarLocalidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarLocalidadActionPerformed

    private void btnAgregarPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarPaisActionPerformed

    private void btnAgregarBarrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarBarrioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarBarrioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarAcoplado;
    private javax.swing.JButton btnAgregarBarrio;
    private javax.swing.JButton btnAgregarCamion;
    private javax.swing.JButton btnAgregarCamionAcoplado;
    private javax.swing.JButton btnAgregarDepartamento;
    private javax.swing.JButton btnAgregarLocalidad;
    private javax.swing.JButton btnAgregarPais;
    private javax.swing.JButton btnAgregarProvincia;
    private javax.swing.JButton btnAgregarTel;
    private javax.swing.JButton btnBuscarTransportista;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditarVehiculo;
    private javax.swing.JButton btnEliminarTel;
    private javax.swing.JButton btnEliminarVehiculo;
    private javax.swing.JButton btnEmitirFicha;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JRadioButton buttonAcoplado;
    private javax.swing.JRadioButton buttonCamion;
    private javax.swing.JRadioButton buttonCamionAcoplado;
    private datechooser.beans.DateChooserCombo calendarioFin;
    private datechooser.beans.DateChooserCombo calendarioIngreso;
    private datechooser.beans.DateChooserCombo calendarioNacimiento;
    private javax.swing.JComboBox cmbAnioAcoplado;
    private javax.swing.JComboBox cmbAnioCamion;
    private javax.swing.JComboBox cmbBarrio;
    private javax.swing.JComboBox cmbDepto;
    private javax.swing.JComboBox cmbEjesAcoplado;
    private javax.swing.JComboBox cmbEstadoCivil;
    private javax.swing.JComboBox cmbLocalidad;
    private javax.swing.JComboBox cmbMarcaAcoplado;
    private javax.swing.JComboBox cmbMarcaCamion;
    private javax.swing.JComboBox cmbModeloCamion;
    private javax.swing.JComboBox cmbPais;
    private javax.swing.JComboBox cmbProvincia;
    private javax.swing.JComboBox cmbTipoContratacion;
    private javax.swing.JComboBox cmbTipoDoc;
    private javax.swing.JComboBox cmbTipoTel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panelTransportista;
    private javax.swing.JPanel panelVehiculo;
    private javax.swing.JPanel pnlAcoplado;
    private javax.swing.JTable tblTelefono;
    private javax.swing.JTable tblVehiculo;
    private javax.swing.JTextField txtAnchoAcoplado;
    private javax.swing.JTextField txtAnchoCamion;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCUIL;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtDepto;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtDominioAcoplado;
    private javax.swing.JTextField txtDominioCamion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtKilometros;
    private javax.swing.JTextField txtLargoAcplado;
    private javax.swing.JTextField txtLargoCamion;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPiso;
    private javax.swing.JTextField txtSerieAcoplado;
    private javax.swing.JTextField txtTaraAcoplado;
    private javax.swing.JTextField txtTaraCamion;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
