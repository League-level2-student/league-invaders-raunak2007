import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	public static final int WIDTH=500;
	public static final int HEIGHT=800;
	LeagueInvaders(JFrame f){
		this.frame=f;
	}
	void setup() {
		size(WIDTH,HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
