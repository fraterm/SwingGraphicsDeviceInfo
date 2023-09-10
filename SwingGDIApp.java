import javax.swing.*;
import java.awt.*;

class SwingGDIApp {
	public static void main(String args[]) {
		/* TODO -- command line arguments */

		/* GraphicsEnvironment is the Collection of GraphicsDevice objects 
		 * GraphicsDevice objects can be screens printers or image buffers 
		 * This application is initially just concerned with screens and 
		 * their characteristics
		 * */
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] screenDevices = ge.getScreenDevices();
		int screenDevNum = screenDevices.length;
		System.out.format("screenDevices: %d\n", screenDevNum);

		JFrame appFrame = new JFrame("SwingGDI app");
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/* TODO sensible default size or something dynamic */
		appFrame.setSize(640,480);
		// The Layout
		// MenuBar - CenterPanel with main app components - Footerthingy
		// MenuBar
		JMenuBar mb = new JMenuBar();
		JMenu m1 = new JMenu ("File");
		JMenu m2 = new JMenu ("Help");
		// CenterPanel
		JPanel panel = new JPanel();
		// the following components are in the CenterPanel panel
		/* a button to gather the information for the environments device(s)
		 * and emit it into the text area */
		JButton gatherButton = new JButton("Gather Info");
		/* JTextArea  for the screenDevice information to be inserted into 
		 * a JScrollPane */
		JTextArea infoTextArea = new JTextArea(10,30);
		JScrollPane infoTextScrollPane = new JScrollPane(infoTextArea);
		infoTextScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		infoTextScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		// add to the panel

		/* populate with components */
		/* gridbag layout */
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx=0;
		constraints.gridy=0;
		panel.add(infoTextScrollPane,constraints); 
		// AddComponentsToFrame
		appFrame.getContentPane().add(BorderLayout.NORTH, mb);
		//appFrame.getContentPane().add(BorderLayout.WEST, something);
		appFrame.getContentPane().add(BorderLayout.CENTER, panel);
		//appFrame.getContentPane().add(BorderLayout.EAST, something);
		appFrame.getContentPane().add(BorderLayout.SOUTH, gatherButton);
		appFrame.setVisible(true);
	}
}

/* 
 * GraphicsEnvironment ge = GraphicsEnvironment.
   getLocalGraphicsEnvironment();
   GraphicsDevice[] gs = ge.getScreenDevices();
   for (int j = 0; j < gs.length; j++) {
      GraphicsDevice gd = gs[j];
      GraphicsConfiguration[] gc =
      gd.getConfigurations();
      for (int i=0; i < gc.length; i++) {
         JFrame f = new
         JFrame(gs[j].getDefaultConfiguration());
         Canvas c = new Canvas(gc[i]);
         Rectangle gcBounds = gc[i].getBounds();
         int xoffs = gcBounds.x;
         int yoffs = gcBounds.y;
         f.getContentPane().add(c);
         f.setLocation((i*50)+xoffs, (i*60)+yoffs);
         f.show();
      }
   }
   */
