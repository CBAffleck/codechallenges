import java.util.*;
import java.lang.*;
import java.io.*;
import java.net.URI;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Julia_Fractals {

	static final double REAL_NUM = -0.221;
	static final double IMAGINARY_NUM = -0.713;

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
		int WIDTH = 1200;
		int HEIGHT = 1000;
		int threshold = 2;

		BufferedImage fractal = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

		for (int y = 0; y < HEIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				double real_1 = x * 2.0 / WIDTH - 1;
				double imaginary_1 = y * 2.0 / HEIGHT - 1;

				Complex complex_num = new Complex(real_1, imaginary_1);
				int i;
				for (i = 0; i < 128 && complex_num.absolute() <= threshold; i++) {
					complex_num.applyFunc();
				}
				System.out.println("X: " + x + " Y: " + y + " a: " + real_1 + " b: " + imaginary_1 + " Rslt: " + complex_num.absolute() + " Iterations: " + i);
				fractal.setRGB(x, y, i);
			}
		}

		ImageIO.write(fractal, "png", new File("Julia_Fractal.png"));
	}
}