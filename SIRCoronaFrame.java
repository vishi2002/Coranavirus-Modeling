
import javax.swing.JFrame;

public class SIRCoronaFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame("SIR Model");
		final int WIDTH = 2000;
		final int HEIGHT = 900;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(WIDTH, HEIGHT);
		frame.getContentPane().add(new SIRCorona());
		frame.setVisible(true);
		
		
	}

}
