package ntu.vdt63135407.bai1;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DoiChieuDai extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldInput;
	private JLabel lblOutput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoiChieuDai frame = new DoiChieuDai();
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
	public DoiChieuDai() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInput = new JLabel("Input:");
		lblInput.setBounds(10, 105, 80, 25);
        lblInput.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(lblInput);

        textFieldInput = new JTextField();
        textFieldInput.setBounds(100, 105, 150, 25);
        contentPane.add(textFieldInput);
        textFieldInput.setColumns(10);

        JButton btnConvert = new JButton("Convert");
        btnConvert.setBounds(302, 105, 100, 25);
        btnConvert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertLength();
            }

			private void convertLength() {
				try {
		            // Lấy giá trị đầu vào từ text field
		            double inputLength = Double.parseDouble(textFieldInput.getText());

		            // Chuyển đổi đơn vị từ inch sang centimet
		            double outputLength = inputLength * 2.54;

		            // Hiển thị kết quả
		            lblOutput.setText(String.format("%.2f cm", outputLength));
		        } catch (NumberFormatException ex) {
		            // Xử lý nếu người dùng nhập không đúng định dạng số
		            lblOutput.setText("Invalid input");
		        }
				
			}
        });
        contentPane.add(btnConvert);

        JLabel lblResult = new JLabel("Output:");
        lblResult.setBounds(10, 155, 80, 25);
        lblResult.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(lblResult);

        lblOutput = new JLabel("");
        lblOutput.setBounds(100, 155, 150, 25);
        contentPane.add(lblOutput);
        
        JButton btnBack = new JButton("Quay lại");
        btnBack.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		ManHinhChinh home = new ManHinhChinh();
    			home.setVisible(true);
    			SwingUtilities.getWindowAncestor((Component)e.getSource()).setVisible(false);
        	}
        });
        btnBack.setBounds(51, 35, 89, 23);
        contentPane.add(btnBack);
        
        JLabel lblInch = new JLabel("Inch");
        lblInch.setHorizontalAlignment(SwingConstants.CENTER);
        lblInch.setBounds(252, 105, 41, 25);
        contentPane.add(lblInch);
	}

}
