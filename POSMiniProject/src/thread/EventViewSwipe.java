package thread;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.pos.swipe.POSMainCenterMenu;

public class EventViewSwipe extends Thread {
	private POSMainCenterMenu panel;
	private JFrame frame;
	private ImageIcon[] icons = {new ImageIcon("images/pos/Event.png"), new ImageIcon("images/pos/Event1.png")};
	private int cnt= 0;
	public EventViewSwipe(POSMainCenterMenu panel,JFrame frame) {
		this.panel = panel;
		this.frame = frame;
	}

	@Override
	public void run() {
		while(true){
			if(cnt == icons.length){
				cnt = 0;
			}
			panel.getEventImage().setIcon(icons[cnt]);
/*			
			new JLabel(new ImageIcon("images/pos/Event.png"));
			eventImage.setBounds(800, 0, 400, 150);*/
			panel.repaint();
			frame.repaint();
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			cnt++;
			
			
		}
	}
}
