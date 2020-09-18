package _03_jukebox;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import javazoom.jl.player.advanced.AdvancedPlayer;

/*   If you don't have javazoom.jar in your project, you can download it from here: http://bit.ly/javazoom
 *   Right click your project and add it as a JAR (Under Java Build Path > Libraries).*/

public class Jukebox implements Runnable, ActionListener {
Timer timer;
String m = null;
int duration = 0;
	Song i = new Song("");
	
	JButton album1 = new JButton();
	JButton album2 = new JButton();
	JButton album3 = new JButton();
	JButton album4 = new JButton();

	public void run() {

		// 1. Find an mp3 on your computer or on the Internet.
		// 2. Create a Song object for that mp3
		JFrame window = new JFrame();
		window.setVisible(true);
		JPanel panel = new JPanel();

		window.add(panel);
		panel.add(album1);
		panel.add(album2);
		panel.add(album3);
		panel.add(album4);
		
		window.pack();
		window.setSize(1000, 260);
		
		album1.addActionListener(this);
		album2.addActionListener(this);
		album3.addActionListener(this);
		album4.addActionListener(this);

		JLabel pic1 = loadImage("New_Jazz.jpg");
		JLabel pic2 = loadImage("New_Forest.jpg");
		JLabel pic3 = loadImage("New_Techno.jpg");
		JLabel pic4 = loadImage("cafe.jpg");

		album1.add(pic1);
		album2.add(pic2);
		album3.add(pic3);
		album4.add(pic4);
		// 3. Play the Song

		/*
		 * 4. Create a user interface for your Jukebox so that the user can to choose
		 * which song to play. You can use can use a different button for each song, or
		 * a picture of the album cover. When the button or album cover is clicked, stop
		 * the currently playing song, and play the one that was selected.
		 */
	}

	/* Use this method to add album covers to your Panel. */
	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		i.stop();
		
		//JButton buttonPressed = (JButton) e.getSource();
		
		/* If the buttonPressed was the leftButton.... */
		if (album1.equals(e.getSource())) {
			duration=99;
			m = "The-Jazz-Man.mp3";

		}

		if (album2.equals(e.getSource())) {

duration=91;
			m = "Forestry.mp3";

		}
		
		if (album3.equals(e.getSource())) {
duration=137;
			m = "Tech.mp3";

		}
		
		if (album4.equals(e.getSource())) {
duration=87;
			m = "Stage-Door.mp3";

		}
		
		i = new Song(m);
		i.play();
		
		timer = new Timer(duration*1000, this);
		timer.start();
	}

	class Song {

		private int duration;
		private String songAddress;
		private AdvancedPlayer mp3Player;
		private InputStream songStream;

		/**
		 * Songs can be constructed from files on your computer or Internet addresses.
		 * 
		 * Examples: <code> 
		 * 		new Song("everywhere.mp3"); 	//from default package 
		 * 		new Song("/Users/joonspoon/music/Vampire Weekend - Modern Vampires of the City/03 Step.mp3"); 
		 * 		new	Song("http://freedownloads.last.fm/download/569264057/Get%2BGot.mp3"); 
		 * </code>
		 */
		public Song(String songAddress) {
			this.songAddress = songAddress;
		}

		public void play() {
			loadFile();
			if (songStream != null) {
				loadPlayer();
				startSong();
			} else
				System.err.println("Unable to load file: " + songAddress);
		}

		public void setDuration(int seconds) {
			this.duration = seconds * 100;
		}

		public void stop() {
			if (mp3Player != null)
				mp3Player.close();
		}

		private void startSong() {
			Thread t = new Thread() {
				public void run() {
					try {
						if (duration > 0)
							mp3Player.play(duration);
						else
							mp3Player.play();
					} catch (Exception e) {
					}
				}
			};
			t.start();
		}

		private void loadPlayer() {
			try {
				this.mp3Player = new AdvancedPlayer(songStream);
			} catch (Exception e) {
			}
		}

		private void loadFile() {
			if (songAddress.contains("http"))
				this.songStream = loadStreamFromInternet();
			else
				this.songStream = loadStreamFromComputer();
		}

		private InputStream loadStreamFromInternet() {
			try {
				return new URL(songAddress).openStream();
			} catch (Exception e) {
				return null;
			}
		}

		private InputStream loadStreamFromComputer() {
			try {
				return new FileInputStream(songAddress);
			} catch (FileNotFoundException e) {
				return this.getClass().getResourceAsStream(songAddress);
			}
		}
	}
}
