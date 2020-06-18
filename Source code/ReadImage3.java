
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ReadImage3 extends ReadImage2 {
	
	public ReadImage3() {
		//constructor fara parametrii
		System.out.println("****The constructor without parameters ReadImage3 has been called****");
		
	}

	public ReadImage3(String address) {
		super(address);//apelez constructorul clasei de baza
		blue = new int[height][width];
	}

@Override
public void execute() {
	
		long startTime = System.nanoTime();
		//citesc imaginea
		for(int i = 0; i < height; i++){
		      for(int j = 0; j < width; j++){
		         pixel[i][j] = image.getRGB(j,i);
		         red[i][j] = (pixel[i][j]>>16)&0xff;
		         green[i][j] = (pixel[i][j]>>8)&0xff;
		         blue[i][j] = (pixel[i][j])&0xff;
		    
		      }
		}
		
		long endTime = System.nanoTime();
        System.out.println("Extract third matrix in "+(endTime - startTime)/ 1_000_000 + " milliseconds");
		
	}

	@Override
	public void save(String address) {
		
		try
        {
             ImageIO.write(image, "bmp", new File(address));//salveaza imaginea
        } 
		
        catch (IOException exceptie) 
        {
            exceptie.printStackTrace();
        }
		
		System.out.println("Operatie pe 3 culori (rosu, verde, albastru)");
		
	}

	
	
}
