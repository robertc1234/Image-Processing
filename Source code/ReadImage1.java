
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ReadImage1 implements ReadImage {
	
	int[][] red, green, blue, pixel;//matricile R, G, B

	BufferedImage image=null;
	int width,height;
	
	public ReadImage1() {
		
		System.out.println("****The constructor without parameters ReadImage1 has been called****");
		
	}
	
	public ReadImage1(String address)
	{
		long startTime = System.nanoTime();
		File picture = new File(address);
		
		try
        {
            image = ImageIO.read(picture);//citire imagine
            width = image.getWidth(); //obtin dimensiunile imaginilor
            height = image.getHeight();
            red = new int[height][width];//aloc matricile
            pixel = new int[height][width];
        } 
        
		catch (IOException exceptie) 
        {
            exceptie.printStackTrace();
        }
         
        System.out.println("Citire R efectuata cu succes ");
        long endTime = System.nanoTime();
        System.out.println("Read first matrix in "+(endTime - startTime)/ 1_000_000 + " milliseconds");
		
	}

	@Override
	public void execute() {
		long startTime = System.nanoTime();
		
		for(int i = 0; i < height; i++){
		      for(int j = 0; j < width; j++){
		         pixel[i][j] = image.getRGB(j,i);
		         red[i][j] = (pixel[i][j]>>16)&0xff;//salvez matricea corespunzatoare pentru culoarea rosie
		    
		      }
		}	
		long endTime = System.nanoTime();
        System.out.println("Extract first matrix in "+(endTime - startTime)/ 1_000_000 + " milliseconds");
	}

	@Override
	public void save(String address) {
		
		try
        {
             ImageIO.write(image, "bmp", new File(address));//salvez imaginea in fisierul destinatie
        } 
		
        catch (IOException exceptie) 
        {
            exceptie.printStackTrace();
        }
		
		System.out.println("Operatie pe o singura culoare (rosu)");
		
	}
	
}
