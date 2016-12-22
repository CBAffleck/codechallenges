import java.util.*;
import java.lang.*;
import java.io.*;
import java.net.URI;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.text.*;
import java.awt.Color;

/* 
	Creates images from Julia sets based off the numbers the user inputs.
	Number suggestions: (-0.055, .680), (-0.47, -0.656), (-0.221, -0.713)
*/

public class Julia_Fractals {

	static double REAL_NUM;
	static double IMAGINARY_NUM;

	static class Complex {
		double re;
		double im;

		public Complex(double real, double imaginary) {
			this.re = real;
			this.im = imaginary;
		}

		public void applyFunc() {
			double new_real = re * re - im * im + REAL_NUM;
			double new_im = 2 * re * im + IMAGINARY_NUM;
			this.re = new_real;
			this.im = new_im;
		}

		public double absolute() {
			return Math.sqrt(re * re + im * im);
		}
	}

	public static void main(String[] args) throws IOException {

		System.out.println("Enter a decimal number between -1 and 1: ");
		Scanner in1 = new Scanner(System.in);
		REAL_NUM = in1.nextDouble();

		System.out.println("Enter another decimal number between -1 and 1: ");
		Scanner in2 = new Scanner(System.in);
		IMAGINARY_NUM = in2.nextDouble();

		long start = System.currentTimeMillis();
		int WIDTH = 1920;
		int HEIGHT = 1200;
		int threshold = 2;

		BufferedImage fractal = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				double real_1 = x * 2.0 / WIDTH - 1;
				double imaginary_1 = y * 2.0 / HEIGHT - 1;

				Complex complex_num = new Complex(real_1, imaginary_1);
				int i;
				for (i = 0; i < 256 && complex_num.absolute() <= threshold; i++) {
					complex_num.applyFunc();
				}

				// Black and white designs
				int red = i;
				int green = i + 1;
				int blue = i + 2;
				int rgb = (red << 16) | (green << 8) | blue;
				fractal.setRGB(x, y, rgb);

				// Colored designs with base of red/orange
				// float Hue = (i%256) / 255.0f;
				// Color color = Color.getHSBColor((float)Hue, 1f, 1f);
				// fractal.setRGB(x, y, color.getRGB());
			}
		}

		ImageIO.write(fractal, "png", new File("Julia_Fractal6.png"));

		long end = System.currentTimeMillis();
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.println("Runtime: " + formatter.format((end - start) / 1000d) + " seconds");
	}
}