package gui;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.TextField;
import javax.swing.ImageIcon;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
 
	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(630, 280));
		setResizable(false);
		setContentPane(contentPane);
		init();
	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 212);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		tabInformation.setLayout(null);
		
		// JLabel
		JLabel JLlu = new JLabel("LU");
		JLlu.setBounds(10, 20, 23, 19);
		tabInformation.add(JLlu);
		
		JLabel JLapellido = new JLabel("Apellido");
		JLapellido.setBounds(10, 50, 68, 19);
		tabInformation.add(JLapellido);
		
		JLabel JLnombre = new JLabel("Nombre");
		JLnombre.setBounds(10, 80, 45, 19);
		tabInformation.add(JLnombre);
		
		JLabel JLmail = new JLabel("E-mail");
		JLmail.setBounds(10, 110, 45, 19);
		tabInformation.add(JLmail);
		
		JLabel JLgithub = new JLabel("Github URL");
		JLgithub.setBounds(10, 140, 79, 19);
		tabInformation.add(JLgithub);
		
		// TEXT Field
		TextField TFlu = new TextField();
		TFlu.setText((String) null);
		TFlu.setBounds(94, 20, 321, 19);
		TFlu.setText(""+studentData.getId());
		tabInformation.add(TFlu);
		
		TextField TFapellido = new TextField();
		TFapellido.setBounds(94, 50, 321, 19);
		TFapellido.setText(studentData.getLastName());
		tabInformation.add(TFapellido);
		
		TextField TFnombre = new TextField();
		TFnombre.setText((String) null);
		TFnombre.setBounds(94, 80, 321, 19);
		TFnombre.setText(studentData.getFirstName());
		tabInformation.add(TFnombre);
		
		TextField TFmail = new TextField();
		TFmail.setText((String) null);
		TFmail.setBounds(94, 110, 321, 19);
		TFmail.setText(studentData.getMail());
		tabInformation.add(TFmail);
		
		TextField TFgithub = new TextField();
		TFgithub.setText((String) null);
		TFgithub.setBounds(94, 140, 321, 19);
		TFgithub.setText(studentData.getGithubURL());
		tabInformation.add(TFgithub);
		
		//fecha y hora de apertura de ventana
		LocalTime HoraA= LocalTime.now();
		LocalDate FechaA= LocalDate.now();
		contentPane.add(tabbedPane);
		JLabel JLFechaHoraV = new JLabel("Esta ventana fue generada el "+FechaA.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+" a las "+HoraA.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
		JLFechaHoraV.setBounds(5, 215, 405, 19);
		contentPane.add(JLFechaHoraV);
		
		//Foto del Alumno
		JLabel JLFoto = new JLabel("");
		JLFoto.setBounds(442, 30, 166, 160);
		ImageIcon miFoto =new ImageIcon(SimplePresentationScreen.class.getResource(studentData.getPathPhoto()));
		Image EscalarFoto = miFoto.getImage().getScaledInstance(JLFoto.getWidth(),JLFoto.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon miFotoEscalada = new ImageIcon(EscalarFoto);
		JLFoto.setIcon(miFotoEscalada);
		contentPane.add(JLFoto);
		
		
		//Icono de ventana
		setIconImage(new ImageIcon(SimplePresentationScreen.class.getResource("/images/tdp.png")).getImage());
		
		
	}
}
