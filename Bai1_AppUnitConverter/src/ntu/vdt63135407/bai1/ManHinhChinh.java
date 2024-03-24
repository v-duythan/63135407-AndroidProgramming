package ntu.vdt63135407.bai1;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManHinhChinh extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManHinhChinh frame = new ManHinhChinh();
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
	public ManHinhChinh() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CÔNG CỤ CHUYỂN ĐỔI ĐƠN VỊ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setBounds(31, 23, 358, 39);
		contentPane.add(lblNewLabel);
		
		JButton btnLength = new JButton("Chiều dài");
		btnLength.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        DoiChieuDai length = new DoiChieuDai();
		        length.setVisible(true);
		        SwingUtilities.getWindowAncestor((Component)e.getSource()).setVisible(false);
		    }
		});

		btnLength.setFont(new Font("Arial", Font.PLAIN, 14));
		btnLength.setBounds(35, 105, 354, 46);
		contentPane.add(btnLength);
		
		JButton btnWeight = new JButton("Trọng lượng");
		btnWeight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DoiTrongLuong weight = new DoiTrongLuong();
				weight.setVisible(true);
		        SwingUtilities.getWindowAncestor((Component)e.getSource()).setVisible(false);
			}
		});
		btnWeight.setFont(new Font("Arial", Font.PLAIN, 14));
		btnWeight.setBounds(35, 183, 354, 46);
		contentPane.add(btnWeight);
	}
}
