package pelasEArte.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ErroView extends JDialog {
	private static final long serialVersionUID = -8250676096280833625L;
	private final JPanel contentPanel = new JPanel();
	private JLabel mensagemErro;

	/**
	 * Create the dialog.
	 */
	public ErroView() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		mensagemErro = new JLabel("Mensagem de Erro Qualquer");
		mensagemErro.setFont(new Font("Arial", Font.PLAIN, 20));
		mensagemErro.setHorizontalAlignment(SwingConstants.CENTER);
		mensagemErro.setBounds(10, 66, 414, 99);
		contentPanel.add(mensagemErro);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(e -> fechar());
			}
		}
	}
	
	private void fechar() {
		setVisible(false);
		dispose();
	}

	public void definirMensagemErro(String mensagem) {
		mensagemErro.setText(mensagem);
	}
}
