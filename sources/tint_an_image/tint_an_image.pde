color BG_COLOR = color(160, 160, 160);
color LINES_COLOR = color(80, 80, 80);
color FILL_COLOR = color(224, 224, 224);
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

void setup()
{
	size(640, 640, P2D);
	background(BG_COLOR);

	//
	centerX = int(width * 0.5);
	centerY = int(height * 0.5);

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


void draw()
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

void setTargetDimensions(int w, int h)
{
	targetDimensions = new int[2];

	float MAX_SOURCE_SIZE = 1920;
	float TARGET_SIZE = 480;
	float RATIO = TARGET_SIZE / MAX_SOURCE_SIZE;

	if(w > h)
	{
		targetDimensions[0] = int(TARGET_SIZE);
		targetDimensions[1] = int(h * RATIO);
	}
	else
	{
		targetDimensions[0] = int(w * RATIO);
		targetDimensions[1] = int(TARGET_SIZE);
	}
}