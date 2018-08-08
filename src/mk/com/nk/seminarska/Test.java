package mk.com.nk.seminarska;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Test extends JFrame {

	private JPanel contentPane;
	private JPanel contentPanelListaSlavenici;
	private JTextField textFieldIme;
	private JTextField textFieldPrezime;
	private JTextField textFieldGodini;
	private JTextField textFieldUlica;
	private JTextField textFieldGrad;
	private JTextField textFieldLocal;
	private JTextField textFieldGosti;
	private JTextField textFieldSearch;
	
	CitajXml objCitaj = new CitajXml();
	MetodiXml objXml = new MetodiXml();
	
	Lokacija lokacija;
	private Slavenik slavenikZaEditiranje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPanelListaSlavenici = new JPanel();
		contentPanelListaSlavenici.setBounds(300, 40, 300, 500);
		contentPane.add(contentPanelListaSlavenici);
		
		JLabel lblIme = new JLabel("\u0418\u043C\u0435:");
		lblIme.setBounds(10, 11, 46, 14);
		contentPane.add(lblIme);

		textFieldIme = new JTextField();
		textFieldIme.setBounds(66, 8, 86, 20);
		contentPane.add(textFieldIme);
		textFieldIme.setColumns(10);
		
		JLabel lblPrezime = new JLabel("\u041F\u0440\u0435\u0437\u0438\u043C\u0435:");
		lblPrezime.setBounds(10, 39, 46, 14);
		contentPane.add(lblPrezime);

		textFieldPrezime = new JTextField();
		textFieldPrezime.setBounds(66, 36, 86, 20);
		contentPane.add(textFieldPrezime);
		textFieldPrezime.setColumns(10);
		
		JLabel lblGodini = new JLabel("\u0413\u043E\u0434\u0438\u043D\u0438:");
		lblGodini.setBounds(10, 64, 46, 14);
		contentPane.add(lblGodini);

		textFieldGodini = new JTextField();
		textFieldGodini.setBounds(66, 61, 86, 20);
		contentPane.add(textFieldGodini);
		textFieldGodini.setColumns(10);
		
		JLabel lblUlica = new JLabel("\u0423\u043B\u0438\u0446\u0430:");
		lblUlica.setBounds(10, 89, 46, 14);
		contentPane.add(lblUlica);

		JLabel lblGrad = new JLabel("\u0413\u0440\u0430\u0434:");
		lblGrad.setBounds(10, 114, 46, 14);
		contentPane.add(lblGrad);

		JLabel lblLokal = new JLabel("\u041B\u043E\u043A\u0430\u043B:");
		lblLokal.setBounds(10, 139, 46, 14);
		contentPane.add(lblLokal);

		JLabel lblGosti = new JLabel("\u0413\u043E\u0441\u0442\u0438:");
		lblGosti.setBounds(10, 164, 46, 14);
		contentPane.add(lblGosti);
		
		textFieldUlica = new JTextField();
		textFieldUlica.setBounds(66, 86, 86, 20);
		contentPane.add(textFieldUlica);
		textFieldUlica.setColumns(10);
		
		textFieldGrad = new JTextField();
		textFieldGrad.setBounds(66, 111, 86, 20);
		contentPane.add(textFieldGrad);
		textFieldGrad.setColumns(10);
		
		textFieldLocal = new JTextField();
		textFieldLocal.setBounds(66, 136, 86, 20);
		contentPane.add(textFieldLocal);
		textFieldLocal.setColumns(10);
		
		textFieldGosti = new JTextField();
		textFieldGosti.setBounds(66, 161, 86, 20);
		contentPane.add(textFieldGosti);
		textFieldGosti.setColumns(10);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(300, 10, 200, 20);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JButton btnVnesi = new JButton("\u0412\u043D\u0435\u0441\u0438");
		btnVnesi.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
			{
			Slavenik slavenik = new Slavenik(textFieldIme.getText(), textFieldPrezime.getText(), 
					Integer.parseInt(textFieldGodini.getText()), new Lokacija(textFieldUlica.getText(),
							textFieldGrad.getText(), textFieldLocal.getText(),
							Integer.parseInt(textFieldGosti.getText())));
			try {
				if(slavenikZaEditiranje!=null){
					izbrisiSlavenik(slavenikZaEditiranje);
					slavenikZaEditiranje=null;
				}
				objXml.zacuvajVoXml(slavenik);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			prikaziSlavenici(objCitaj.zemiGiSiteSlavenici());
		}
			}
		});
		btnVnesi.setBounds(31, 192, 89, 23);
		contentPane.add(btnVnesi);

		JButton buttonPrebarajSlavenik = new JButton("\u0411\u0430\u0440\u0430\u0458");
		buttonPrebarajSlavenik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Slavenik> slavenikXml = objCitaj.find(textFieldSearch.getText());
				if(slavenikXml.size()>0){
					System.out.println("Najdeno");
					prikaziSlavenici(slavenikXml);
				} else {
					contentPanelListaSlavenici.removeAll();
					contentPanelListaSlavenici.revalidate();
					contentPanelListaSlavenici.repaint();
				}
			}
		});
		buttonPrebarajSlavenik.setBounds(500, 10, 100, 20);
		contentPane.add(buttonPrebarajSlavenik);
		prikaziSlavenici(objCitaj.zemiGiSiteSlavenici());
		
	}
	
	public void prikaziSlavenici(List<Slavenik> siteSlavenici){
		
		contentPanelListaSlavenici.removeAll();
		contentPanelListaSlavenici.revalidate();
		contentPanelListaSlavenici.repaint();
		
		int y=30;
		
		for (final Slavenik slavenik : siteSlavenici) {
		
			JLabel lblVneseniImePrezime = new JLabel("Ime i Prezime: " +slavenik.getIme() + " " + slavenik.getPrezime());
			lblVneseniImePrezime.setBounds(500, y , 200, 20);
			contentPanelListaSlavenici.add(lblVneseniImePrezime);
			
			JLabel lblVneseniLokal = new JLabel("Lokal: " + slavenik.getLokacija().getLokal());
			lblVneseniLokal.setBounds(500, y+20 , 200, 20);
			contentPanelListaSlavenici.add(lblVneseniLokal);
			
			JButton btnEditSlavenik = new JButton("Izmeni");
			btnEditSlavenik.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					izmeniSlavenik(slavenik);
				}
			});
			btnEditSlavenik.setBounds(700, y, 100, 20);
			contentPanelListaSlavenici.add(btnEditSlavenik);
			
			JButton btnDeleteSlavenik = new JButton("Izbrisi");
			btnDeleteSlavenik.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					izbrisiSlavenik(slavenik);
				}
			});
			btnDeleteSlavenik.setBounds(700, y+20, 100, 20);
			contentPanelListaSlavenici.add(btnDeleteSlavenik);
			
			JLabel lblSeparator = new JLabel("-------------------------------------------------------------------------------");
			lblSeparator.setBounds(500, y+40 , 400, 20);
			contentPanelListaSlavenici.add(lblSeparator);
			y+=70;
		}
	}
	
	public void izmeniSlavenik(Slavenik slavenik) {
		slavenikZaEditiranje = slavenik;
		textFieldIme.setText(slavenik.getIme());
		textFieldPrezime.setText(slavenik.getPrezime());
		textFieldGodini.setText(String.valueOf(slavenik.getGodini()));
		textFieldGrad.setText(slavenik.getLokacija().getGrad());
		textFieldUlica.setText(slavenik.getLokacija().getUlica());
		textFieldLocal.setText(slavenik.getLokacija().getLokal());
		textFieldGosti.setText(String.valueOf(slavenik.getLokacija().getBrNaGosti()));
	}
	
	public void izbrisiSlavenik(Slavenik slavenik) {
		objCitaj.izbrisiSlavenik(slavenik);
		prikaziSlavenici(objCitaj.zemiGiSiteSlavenici());
	}
	
}
