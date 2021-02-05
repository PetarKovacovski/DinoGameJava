package dinoGame;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;

public class GameFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame window = new GameFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Offline Dino");
		frame.setBounds(100, 100, 604, 385);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Player = new JLabel("Dino");
		Player.setBounds(49, 259, 40, 43);
		Player.setIcon(new ImageIcon(getClass().getResource("/Resources/main-character3.png")));
		frame.getContentPane().add(Player);
		
		
		JLabel Dino = new JLabel("Cactus");
		Dino.setBounds(600, 256, 23,46 );
		Dino.setIcon(new ImageIcon(getClass().getResource("/Resources/cactus1.png")));
		frame.getContentPane().add(Dino);
		moveDino obj = new moveDino();
		obj.moveLeft(Dino,Player);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(0, 302, 586, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		frame.addKeyListener(new KeyAdapter() {
			
		
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_SPACE) {
					if (Player.getY()==259) {
					moveDino obj = new moveDino();
					obj.jump(Player);
					}
				}
			}
		});
		
	}
}
