package presentacion;

//import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

//import datatypes.DtCurso;
import datatypes.DtEdicion;
//import datatypes.DtDocente;
import interfaces.IControladorCurso;

//import logica.Docente;
import javax.swing.JButton;
import excepciones.EdicionRepatida_Exception;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import javax.swing.JList;
import java.awt.ScrollPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;


public class AltadeEdiciondeCurso extends JInternalFrame {
	
	IControladorCurso iconCur;
	
	private JTextField textFieldNombre;
	private JTextField textFieldCupo;
	private JComboBox<String> comboBoxCursos;
	private JComboBox<String> comboBoxInstitutos;
	private JDateChooser dateChooserFechaInicio;
	private JDateChooser dateChooserFechaFin;
	private JDateChooser dateChooserFechaPub;
	private JList<String> listDocentes;
	private JScrollPane scrollPaneDocentes;
	

	private static final long serialVersionUID = 1L;
	/**
	 * Create the frame.
	 */
	public AltadeEdiciondeCurso(IControladorCurso iconCur) {
		
		this.iconCur = iconCur;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(false);
		setTitle("Alta de Edición de Curso");
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
				
		comboBoxInstitutos = new JComboBox<String>();
		comboBoxInstitutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//ACTION PERFORMED DE JCOMBOBOX DE CURSOS
				comboBoxInit2();
				listDocentesInit();
			}
		});
		comboBoxInstitutos.setBounds(91, 26, 114, 20);
		getContentPane().add(comboBoxInstitutos);
	
		JLabel lblInstituto = new JLabel("Institutos");
		lblInstituto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInstituto.setBounds(0, 29, 79, 15);
		getContentPane().add(lblInstituto);
		
		comboBoxCursos = new JComboBox<String>();
		comboBoxCursos.setBounds(91, 53, 114, 20);
		getContentPane().add(comboBoxCursos);
		
		JLabel lblCurso = new JLabel("Cursos");
		lblCurso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCurso.setBounds(0, 56, 79, 15);
		getContentPane().add(lblCurso);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(91, 93, 114, 20);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldCupo = new JTextField();
		textFieldCupo.setBounds(91, 187, 114, 20);
		getContentPane().add(textFieldCupo);
		textFieldCupo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(0, 96, 79, 15);
		getContentPane().add(lblNombre);
		
		JLabel lblFechaInicio = new JLabel("Fecha inicio");
		lblFechaInicio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaInicio.setBounds(0, 124, 79, 15);
		getContentPane().add(lblFechaInicio);
		
		JLabel lblFechafin = new JLabel("Fecha fin");
		lblFechafin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechafin.setBounds(0, 159, 79, 15);
		getContentPane().add(lblFechafin);
		
		JLabel lblCupo = new JLabel("Cupo");
		lblCupo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCupo.setBounds(0, 190, 79, 15);
		getContentPane().add(lblCupo);
		
		JLabel lblFechapub = new JLabel("Fecha pub.");
		lblFechapub.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechapub.setBounds(0, 224, 79, 15);
		getContentPane().add(lblFechapub);
		
		JLabel lblDocente = new JLabel("Docentes");
		lblDocente.setHorizontalAlignment(SwingConstants.CENTER);
		lblDocente.setBounds(225, 29, 57, 15);
		getContentPane().add(lblDocente);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmarAltadeEdiciondeCurso_ActionPerformed(e);
			}
		});
		btnAceptar.setBounds(288, 179, 114, 25);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelarAltaInstituto_actionPerformed(e); //La funci�n est� definida abajo
			}
		});
		btnCancelar.setBounds(288, 214, 114, 25);
		getContentPane().add(btnCancelar);
		
		dateChooserFechaInicio = new JDateChooser();
		dateChooserFechaInicio.setBounds(91, 123, 114, 20);
		getContentPane().add(dateChooserFechaInicio);
		
		dateChooserFechaFin = new JDateChooser();
		dateChooserFechaFin.setBounds(91, 154, 114, 20);
		getContentPane().add(dateChooserFechaFin);
		
		dateChooserFechaPub = new JDateChooser();
		dateChooserFechaPub.setBounds(91, 219, 114, 20);
		getContentPane().add(dateChooserFechaPub);
		
		listDocentes = new JList<String>();
		listDocentes.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		listDocentes.setBounds(288, 21, 117, 87);
		//getContentPane().add(listDocentes);
		
		scrollPaneDocentes = new JScrollPane();
		scrollPaneDocentes.setBounds(288, 26, 114, 113);
		getContentPane().add(scrollPaneDocentes);

	}
	public void comboBoxInit() {
		DefaultComboBoxModel<String> modelInstitutos = new DefaultComboBoxModel<String>(iconCur.listarInstitutos());
		comboBoxInstitutos.setModel(modelInstitutos);
	}
	
	public void comboBoxInit2() {
		String strCurso = this.comboBoxInstitutos.getSelectedItem().toString();
		DefaultComboBoxModel<String> modelCursos = new DefaultComboBoxModel<String>(iconCur.listarCursos(strCurso));
		comboBoxCursos.setModel(modelCursos);
	}
	
	public void listDocentesInit() {
		String[] docentes = iconCur.listarDocentes(this.comboBoxInstitutos.getSelectedItem().toString());
		this.listDocentes.setListData(new String[0]);
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		for(String doc: docentes) {
			listModel.addElement(doc);
		}		
				
		this.listDocentes.setModel(listModel);
		
		scrollPaneDocentes.getViewport().setView(listDocentes);

		
	}
	
	protected void ConfirmarAltadeEdiciondeCurso_ActionPerformed(ActionEvent e) {
		
		if (comprobarCampos()) {
			//OBTENGO TODOS LOS DATOS DE LA PRESENTACION
			String nombre = this.textFieldNombre.getText();
			String cupo = this.textFieldCupo.getText();
			int c = Integer.parseInt(cupo);
			
			//OBTENER LOS DOCENTES
			List<String> docentes = (List<String>) this.listDocentes.getSelectedValuesList();
			
			//OBTENGO LAS FECHAS DATE Y LAS CONVIERTO A LOCALDATE
			Date fechaIniD = new Date();
			fechaIniD = this.dateChooserFechaInicio.getDate();
			LocalDate fechaIni = fechaIniD.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			
			Calendar fechaCalendarIni = GregorianCalendar.from(fechaIni.atStartOfDay(ZoneId.systemDefault()));
			
			Date fechaFinD = new Date();
			fechaFinD = this.dateChooserFechaFin.getDate();
			LocalDate fechaFin = fechaFinD.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();	
			
			Calendar fechaCalendarFin = GregorianCalendar.from(fechaFin.atStartOfDay(ZoneId.systemDefault()));
			
			Date fechaPubD = new Date();
			fechaPubD = this.dateChooserFechaPub.getDate();
			LocalDate fechaPub = fechaPubD.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			
			Calendar fechaCalendarPub = GregorianCalendar.from(fechaPub.atStartOfDay(ZoneId.systemDefault()));
			
			//CREACION DEL DT EDICION. INSTITUTO Y CURSO
			DtEdicion edicion = new DtEdicion(nombre,fechaCalendarIni,fechaCalendarFin,c,fechaCalendarPub); //COMO TRABAJAR EL DTDOCENTE(LISTA DE DOCENTES)
			String instituto = this.comboBoxInstitutos.getSelectedItem().toString();
			String curso = this.comboBoxCursos.getSelectedItem().toString();
				try{
					this.iconCur.AltadeEdiciondeCurso(edicion, instituto,curso);
					JOptionPane.showMessageDialog(this, "Edicion creada con exito", "Alta exitosa", JOptionPane.INFORMATION_MESSAGE);
					limpiarCampos();
					this.listDocentes.clearSelection();
				}
				catch(EdicionRepatida_Exception ex){
					JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			for(String doc: docentes) {
				this.iconCur.asociarEdicion(doc, edicion, instituto, curso);
			}
		}
	}
	protected void CancelarAltaInstituto_actionPerformed(ActionEvent e) {
		limpiarCampos();
		setVisible(false);
	}
	private void limpiarCampos() {
		this.textFieldNombre.setText("");
		this.textFieldCupo.setText("");
		this.dateChooserFechaInicio.setCalendar(null);
		this.dateChooserFechaFin.setCalendar(null);
		this.dateChooserFechaPub.setCalendar(null);
		this.listDocentes.clearSelection();
	}
	private boolean comprobarCampos() {
		int comboBoxCursos = this.comboBoxCursos.getItemCount();
		int comboBoxInstitutos = this.comboBoxInstitutos.getItemCount();
		String nombre = this.textFieldNombre.getText();
		String cupo = this.textFieldCupo.getText();
		List<String> docentes = this.listDocentes.getSelectedValuesList();
		Date fechaIniD = this.dateChooserFechaInicio.getDate();
		Date fechaFinD = this.dateChooserFechaFin.getDate();
		Date fechaPubD = this.dateChooserFechaPub.getDate();
		int c = 0;
		if(nombre.isEmpty() || cupo.isEmpty() || docentes == null || fechaIniD == null || fechaFinD == null || fechaPubD == null || comboBoxCursos == 0 || comboBoxInstitutos == 0) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Error",
                    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		try {
			c = Integer.parseInt(cupo);
			
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "El cupo debe ser un numero", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
		}
		return true;
				 
	}
}
