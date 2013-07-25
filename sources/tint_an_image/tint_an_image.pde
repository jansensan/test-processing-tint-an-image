color BG_COLOR = color(255, 160, 160);


PImage linesColor;
PImage fillColor;

PImage linesMask;
PImage fillMask;


void setup()
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


void draw()
{
	background(BG_COLOR);

	image(linesColor, width * 0.5, height * 0.5);

	image(fillColor, width * 0.5, height * 0.5);
	fillColor.mask(fillMask);

	imageMode(CENTER);
}
