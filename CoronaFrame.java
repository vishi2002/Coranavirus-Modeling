import javax.swing.JFrame;

public class CoronaFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		CoronaPanel panel = new CoronaPanel();
		
		frame.add(panel);
		frame.getContentPane();
		frame.pack();
		frame.setVisible(true);
		
		
	}

}