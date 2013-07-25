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

int BG_COLOR = color(255, 160, 160);


PImage linesColor;
PImage fillColor;

PImage linesMask;
PImage fillMask;


public void setup()
{
	size(640, 360, P2D);
	background(BG_COLOR);

	fillColor = loadImage("white-394x320.png");
	tint(0, 0, 240);

	fillMask = loadImage("paterson-drawing-394x320.png");
	noTint();

	linesColor = loadImage("paterson-drawing-394x320.png");
	linesColor.filter(INVERT);
	noTint();
}


public void draw()
{
	background(BG_COLOR);

	image(linesColor, width * 0.5f, height * 0.5f);

	image(fillColor, width * 0.5f, height * 0.5f);
	fillColor.mask(fillMask);

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
