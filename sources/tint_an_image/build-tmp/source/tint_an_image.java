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

int BG_COLOR = color(160, 160, 160);
int LINES_COLOR = color(80, 80, 80);
int FILL_COLOR = color(224, 224, 224);
String IMG_URL = "images/paterson-drawing.png";

int centerX;
int centerY;

PImage source;

int[] targetDimensions;
PImage linesImage;
PImage fillImage;


//===========/----------------------------------------------
//  [_PRO]  /  Processing
//=========/------------------------------------------------

public void setup()
{
	size(640, 640, P2D);
	background(BG_COLOR);

	//
	centerX = PApplet.parseInt(width * 0.5f);
	centerY = PApplet.parseInt(height * 0.5f);

	// set source
	source = loadImage(IMG_URL);
	source.loadPixels();

	// var relative to source
	int numPixels = source.pixels.length;
	setTargetDimensions(source.width, source.height);

	// instantiate fill color
	linesImage = createImage	(
								source.width, 
								source.height,
								ARGB
							);
	linesImage.loadPixels();

	// instantiate lines color
	fillImage = createImage	(
									source.width, 
									source.height,
									ARGB
								);
	fillImage.loadPixels();

	// loop through source
	int threshold = 128;
	for(int i = 0; i < numPixels; i++)
	{
		// fill color
		linesImage.pixels[i] = color	(
											red(LINES_COLOR),
											green(LINES_COLOR),
											blue(LINES_COLOR),
											alpha(source.pixels[i])
										); 

		// lines color
		if	(
				red(source.pixels[i]) > threshold 
				&& green(source.pixels[i]) > threshold
				&& blue(source.pixels[i]) > threshold
			)
		{
			fillImage.pixels[i] = FILL_COLOR;
		}
	}
	linesImage.updatePixels();
}


public void draw()
{
	background(BG_COLOR);

	image	(
				linesImage, 
				centerX, 
				centerY,
				targetDimensions[0],
				targetDimensions[1]
			);
	image	(
				fillImage, 
				centerX, 
				centerY,
				targetDimensions[0],
				targetDimensions[1]
			);

	imageMode(CENTER);
}


//===========/----------------------------------------------
//  [_MTD]  /  Methods
//=========/------------------------------------------------

public void setTargetDimensions(int w, int h)
{
	targetDimensions = new int[2];

	float MAX_SOURCE_SIZE = 1920;
	float TARGET_SIZE = 480;
	float RATIO = TARGET_SIZE / MAX_SOURCE_SIZE;

	if(w > h)
	{
		targetDimensions[0] = PApplet.parseInt(TARGET_SIZE);
		targetDimensions[1] = PApplet.parseInt(h * RATIO);
	}
	else
	{
		targetDimensions[0] = PApplet.parseInt(w * RATIO);
		targetDimensions[1] = PApplet.parseInt(TARGET_SIZE);
	}
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
