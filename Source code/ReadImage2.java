
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ReadImage2 extends ReadImage1 {
	
	public ReadImage2() {
		
		System.out.println("****The constructor without parameters ReadImage2 has been called****");
		
	}

	public ReadImage2(String address)
	{
		super(address);//apelez constructorul clasei debaza
		green = new int[height][width];//aloc matricea pentru verde
	}
@Override
public void execute() {
		
		long startTime = System.nanoTime();
		
		for(int i = 0; i < height; i++){
		      for(int j = 0; j < width; j++){
		         pixel[i][j] = image.getRGB(j,i);//salvez imaginea ca matrice
		         red[i][j] = (pixel[i][j]>>16)&0xff;
		         green[i][j] = (pixel[i][j]>>8)&0xff;//salvez informatiile pentru primele 2 culori
		         //prin operatorul >> efectuez o shift-are pentru a salva blocul de interes
		      }
		}
		
		long endTime = System.nanoTime();
        System.out.println("Extract second matrix in "+(endTime - startTime)/ 1_000_000 + " milliseconds");
		
	}

	@Override
	public void save(String address) {
		
		try
        {
             ImageIO.write(image, "bmp", new File(address));//scriu rezultatul in fisier
        } 
		
        catch (IOException exceptie) 
        {
            exceptie.printStackTrace();
        }
		
		System.out.println("Operatie pe 2 culori (rosu si verde)");
		
	}
	
}
