package net.approachzero.app;
//package SwingGDIApp.src.main.java.net.approachzero.app;
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
		GraphicsEnvironment graphicsEnvironment = 
				GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice defaultScreenDevice = graphicsEnvironment.getDefaultScreenDevice();
		GraphicsDevice[] scrDevs = 
				graphicsEnvironment.getScreenDevices();
		int scrDevCount = scrDevs.length;
		System.out.format("screenDevices: %d\n", scrDevCount);
		boolean isDefaultScreenDevice;
		// iterate over graphicsDevices
		for ( GraphicsDevice sd : scrDevs) 
		{
			System.out.println("Information about Device:"+sd.getIDstring().toString());
			if (defaultScreenDevice.equals(sd)) {
				isDefaultScreenDevice = true;
				System.out.println("is the Default Screen Device");
			}else {
				isDefaultScreenDevice = false;
				System.out.println("is not the Default Screen Device");

			}
			System.out.println("DisplayMode:"+sd.getDisplayMode().toString());
			System.out.println("display modes array length:"+ sd.getDisplayModes().length);
			System.out.format("raw type value:%d\n", sd.getType());  // TYPE_IMAGE_BUFFER = 2, TYPE_PRINTER = 1, TYPE_RASTER_SCREEN = 0
			System.out.format("availableAcceleratedMemory:%d\n", sd.getAvailableAcceleratedMemory());
			System.out.println("getIDstring returns:"+ sd.getIDstring().toString());
			System.out.println("Bit Depth:"+ sd.getDisplayMode().getBitDepth());
			System.out.println("Height:"+ sd.getDisplayMode().getHeight());
			System.out.println("Width"+ sd.getDisplayMode().getWidth());
		}
		

		JFrame appFrame = new JFrame("SwingGDI app");
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/* TODO sensible default size or something dynamic */
		appFrame.setSize(640,480);
		// The Layout
		// MenuBar - CenterPanel with main app components - Footerthingy
		// MenuBar
		JMenuBar mb = new JMenuBar();
		JMenu menuFile = new JMenu ("File");
		//menuFile.setMnemonic(KeyEvent.VK_F);
		mb.add(menuFile);
		JMenu menuHelp = new JMenu ("Help");
		//menuHelp.setMnemonic(KeyEvent.VK_H);
		mb.add(menuHelp);
		// CenterPanel
		JPanel panel = new JPanel();
		// the following components are in the CenterPanel panel
		/* a button to gather the information for the environments device(s)
		 * and emit it into the text area */
		JButton gatherButton = new JButton("Gather Info");
		/* JTextArea  for the screenDevice information to be inserted into 
		 * a JScrollPane */
		JTextArea infoTextArea = new JTextArea(25,80);
		JScrollPane infoTextScrollPane = new JScrollPane(infoTextArea);
		//infoTextScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//infoTextScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		// add to the panel

		/* populate with components */
		panel.add(infoTextScrollPane); 
		// AddComponentsToFrame
		appFrame.getContentPane().add(BorderLayout.NORTH, mb);
		//appFrame.getContentPane().add(BorderLayout.WEST, something);
		appFrame.getContentPane().add(BorderLayout.CENTER, panel);
		//appFrame.getContentPane().add(BorderLayout.EAST, something);
		appFrame.getContentPane().add(BorderLayout.SOUTH, gatherButton);
		appFrame.setVisible(true);
	}
}
/* *
 * 
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class ScreenDevice {

    public static void main(String[] args) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gd = ge.getScreenDevices();

        for (GraphicsDevice g : gd) {
            System.out.println("The type of the screen device is " + g.getType());
        }
    }
}
 * 
 * */
