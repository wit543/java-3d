package com.mime.game;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.mime.game.graphic.Render;
import com.mime.game.graphic.Screen;

public class Display extends Canvas{
	
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 600;
	public static final int HEIGHT = 800;
	public static final String Title = "game";
	
	private Thread thread;
	private boolean running = false;
	private Render render;
	private Screen screen;
	private BufferedImage img;
	private int[] pixels;
	public Display(){
		screen = new Screen(WIDTH,HEIGHT);
		img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)img.getRaster().getDataBuffer()).getData();
	}
	private void start(){
		if(running){
		return;}
		running =true;
		thread = new Thread();
		thread.start();
		System.out.println("wotk");
	}
	
	public void stop(){
		if(!running);
		running = false;
					try{
				thread.join();
			}
			catch (Exception e){
				e.printStackTrace();
				System.exit(0);
			}
		return;
	}
	public void run(){
		while(running){
			trick();
			render();
			
		}
		
	}
	private void trick(){
		
		
	}
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			
			createBufferStrategy(3);
			return;
		}
		screen.render();
		for(int i=0;i<WIDTH*HEIGHT;i++){
			pixels[i] = screen.pixel[i];
			}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(img, 0, 0, WIDTH, HEIGHT,null);
		g.dispose();
		bs.show();
	}
	
	public static void main (String[] args){
		Display game = new Display();
		JFrame frame = new JFrame();
		frame.add(game);
		frame.pack();
		frame.setTitle(Title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		System.out.println("Running...");
	}
}
