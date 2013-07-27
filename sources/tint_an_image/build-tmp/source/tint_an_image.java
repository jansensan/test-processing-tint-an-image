import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class tint_an_image extends PApplet {

int BG_COLOR = color(240, 240, 240);
String IMG_URL = "images/paterson-drawing-320x320.png";
String FLAT_COLOR_BLOCK_URL = "images/white-320x320.png";


PImage linesColor;
PImage fillColor;

PImage fillMask;


public void setup()
{
	size(640, 640, P2D);
	background(BG_COLOR);

	// set lines
	linesColor = loadImage(IMG_URL);
	linesColor.filter(INVERT);

	// set fill
	fillColor = loadImage(FLAT_COLOR_BLOCK_URL);
	fillMask = loadImage(IMG_URL);
}


public void draw()
{
	background(BG_COLOR);

	// draw lines
	// image(linesColor, width * 0.5, height * 0.5);
	// tint(240, 0, 0);

	// draw colors
	image(fillColor, width * 0.5f, height * 0.5f);
	fillColor.mask(fillMask);
	tint(0, 0, 240);

	imageMode(CENTER);
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "tint_an_image" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
