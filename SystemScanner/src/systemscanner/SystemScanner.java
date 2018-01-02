package systemscanner;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.SystemColor;

public class SystemScanner extends JFrame {


	public JList listHata_1;
	private JPanel contentPane;
	private JTextField txtHata;
	private JTextField txtBosAlan;	
	private JButton btnTara;
	public String[] temizle_listesi;
	GereksizDosyaTarayici gdt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemScanner frame = new SystemScanner();
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
	public SystemScanner() {
		setTitle("System Scanner - Yi\u011Fit KURT\u00C7U");		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 510);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnTemizle = new JButton("TEM\u0130ZLE");
		btnTemizle.setForeground(new Color(0, 0, 0));
		btnTemizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				gdt.Temizle(temizle_listesi);
				JOptionPane.showMessageDialog(null, gdt.silinen + " dosya silindi, " + gdt.silinemeyen + " tanesi ise kullanildiklari icin silinemediler.");
			}
		});
		btnTemizle.setVisible(false);
		btnTemizle.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		JButton btnTara = new JButton("TARA");
		btnTara.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = System.getProperty("user.name");
				LinkedList liste = new LinkedList();				
				liste.InsertFirst("C:\\Users\\" + username + "\\AppData\\Local\\Temp");
				liste.InsertFirst("C:\\Users\\" + username + "\\AppData\\Local\\Microsoft\\Windows\\Explorer");
				liste.InsertFirst("C:\\Users\\" + username + "\\AppData\\Local\\Microsoft\\Windows\\INetCache\\IE");
				gdt = new GereksizDosyaTarayici();
				LinkedList hatalistesi = new LinkedList();
				hatalistesi = gdt.Tara(liste);

				Node tmp = hatalistesi.Head;
				temizle_listesi = new String[hatalistesi.Size];
				for(int i = 0; i<hatalistesi.Size; i++)
				{
					temizle_listesi[i] = tmp.Value;
					tmp = tmp.Next;
				}

				txtHata.setText("" + gdt.sayac);
				txtBosAlan.setText("" + gdt.byte_kazanc/1024 + " mb");
				txtBosAlan.setForeground(Color.RED);
				hata_Listele(hatalistesi);
				btnTara.setVisible(false);
				btnTemizle.setVisible(true);
				btnTemizle.setForeground(new Color(34, 139, 34));
				JOptionPane.showMessageDialog(null, "Tarama Tamamlandi.");
			}
		});
		
		JLabel lblHata = new JLabel("Bulunan Gereksiz Dosya Say\u0131s\u0131 : ");
		lblHata.setFont(new Font("Tahoma", Font.BOLD, 14));
		



		txtHata = new JTextField();
		txtHata.setText("?");
		txtHata.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtHata.setColumns(10);
		
		JLabel lblBosAlanKaybi = new JLabel("Bo\u015F Alan Kayb\u0131 :");
		lblBosAlanKaybi.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtBosAlan = new JTextField();
		txtBosAlan.setForeground(Color.BLACK);
		txtBosAlan.setText("?");
		txtBosAlan.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtBosAlan.setColumns(10);
		
		

		
		JScrollPane scrollPane = new JScrollPane();

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblBosAlanKaybi, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHata))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtHata, 0, 0, Short.MAX_VALUE)
								.addComponent(txtBosAlan, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnTemizle, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
						.addComponent(btnTara, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE)
					.addGap(78))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(84)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txtHata, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblHata)
									.addGap(9)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtBosAlan, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblBosAlanKaybi, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnTara, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnTemizle, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(52, Short.MAX_VALUE))
		);
		
		listHata_1 = new JList();
		scrollPane.setViewportView(listHata_1);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	public void hata_Listele(LinkedList hatalist)
	{	
		DefaultListModel<String> listModel;
		listModel = new DefaultListModel<String>();
		
		int hatasayisi = hatalist.Size;
		for(int i = 0; i<hatasayisi; i++)
		{
			
			listModel.addElement(hatalist.Head.Value);
			hatalist.DeleteFirst();
		}

			listHata_1.setModel(listModel);

			
		
	}
}
