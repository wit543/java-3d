package com.mime.game.graphic;

public class Render {
	public final int width;
	public final int height;
	public final int[] pixel;
	
	public Render (int width,int height){
		this.width = width;
		this.height = height;
		pixel = new int[width*height];
	}
		
	public void draw(Render render,int xOffset,int yOffset){
		
		for(int y=0;y<render.height;y++){
			int yPix=y+yOffset;
					for(int x=0;x<render.width;x++){
						int xPix=x+xOffset;
						
						pixel[xPix+yPix*width] =render.pixel[x+y*render.width];
					}  
		} 

	}
}
