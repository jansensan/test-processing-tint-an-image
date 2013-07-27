color BG_COLOR = color(240, 240, 240);
String IMG_URL = "images/paterson-drawing-320x320.png";
String FLAT_COLOR_BLOCK_URL = "images/white-320x320.png";


PImage linesColor;
PImage fillColor;

PImage fillMask;


void setup()
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


void draw()
{
	background(BG_COLOR);

	// draw lines
	// image(linesColor, width * 0.5, height * 0.5);
	// tint(240, 0, 0);

	// draw colors
	image(fillColor, width * 0.5, height * 0.5);
	fillColor.mask(fillMask);
	tint(0, 0, 240);

	imageMode(CENTER);
}
