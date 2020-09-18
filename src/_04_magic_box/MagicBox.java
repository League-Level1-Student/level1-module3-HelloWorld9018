package _04_magic_box;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MagicBox extends JPanel implements Runnable, MouseListener {
	MediaPalace bob = new MediaPalace();
	JFrame frame = new JFrame("The Magic Box contains many secrets...");
	/*
	 * We are going to hide secrets within the magic box. 
	 * When the user clicks on a secret place, stuff will happen.
	 * 
	 * 1. Make the frame respond to mouse clicks.
	 * 
	 * 2. When the mouse is clicked, use the Media Palace (read the code in the magic_box package) to play sounds, 
	 *    show images or speak.
	 * 
	 * 3. Choose 3 different locations on the background image.You can either use the mouse position, 
	 *    or the color of the image, then decide what action the Media Palace should take in each case. 
	 *     backgroundImage.getRGB(e.getX(), e.getY()) will give you the color of the current pixel.
	 */

	BufferedImage backgroundImage;


	@Override
	public void run() {
		try {
			loadBackgroundImage("magic-box.jpg");
			createUI();
		} catch (Exception w) {
			System.err.println(w.getMessage());
		}
	}

	private void createUI() {
		
		frame.add(this);
		setPreferredSize(new Dimension(backgroundImage.getWidth(), backgroundImage.getHeight()));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addMouseListener(this);
	}

	private void loadBackgroundImage(String filename) throws Exception {
		String imageFile = "src/_04_magic_box/" + filename;
		try {
			backgroundImage = ImageIO.read(new File(imageFile));
		} catch (IOException e) {
			throw new Exception("Could not load image: " + imageFile);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(backgroundImage, 0, 0, null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x= e.getX();
		int y = e.getY();
		System.out.println("X: "+ x);
		System.out.println("Y: " + y);
		if (x >= 196 && x <=208 && y <= 570 && y>=530) {
			MediaPalace.speak("Hello, what brings you here today?");
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int x= e.getX();
		int y = e.getY();
		//int rbg = backgroundImage.getRGB(e.getX(), e.getY());
		//int r = rbg >> 16 & 0xff;
		//int g = rbg >> 8 & 0xff;
		//int b = rbg & 0xff;
		//System.out.println(r + ", " + g + ", "+ b);
		
		Color name = new Color(backgroundImage.getRGB(e.getX(), e.getY()));
		int red = name.getRed();
		System.out.println("red: " + red);
		
		int green = name.getGreen();
		System.out.println("green: " +  green);
		
		int blue = name.getBlue();
		System.out.println("blue: " + blue);
		/*if (red >= 104 && red<=210 ) {
			System.out.println("red works");
		}*/
		if(green >= 120 && green <=370) {
			System.out.println("green works");
			
			
		}
		
		/*if (blue >= 80 && blue <= 185) {
			System.out.println("blue works");
		}
		*/
		if (red >= 140 && red<=220 && green >= 120 && green <=370 && blue >= 80 && blue <= 185 && y<=442 && y >=338 && x>=246 && x<=437) {
			System.out.println("water");
		
			try {
				//System.out.println("new background");
				loadBackgroundImage("fish.png");
				setPreferredSize(new Dimension(backgroundImage.getWidth(), backgroundImage.getHeight()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
			
			frame.pack();
		
		}
	}
	

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		try {
			
			loadBackgroundImage("magic-box.jpg");
			setPreferredSize(new Dimension(backgroundImage.getWidth(), backgroundImage.getHeight()));
			//System.out.println("old background");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		frame.pack();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	//	MediaPalace sound  = new MediaPalace();
		//sound.public void playMusicOnComputer(String fileName) {
		//	File fileToPlay = new File(fileName);
			//try {
				//java.awt.Desktop.getDesktop().open(fileToPlay);
		//	} catch (IOException e1) {
			//	e1.printStackTrace();
			//}
	//	}
}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}


