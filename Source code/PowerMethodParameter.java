
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PowerMethodParameter extends PowerMethod {

	double g;//valoarea lui gamma pentru modul custom 
	
	public PowerMethodParameter() {
		
		//constructor fara parametru, utilizat in cazul in care utilizatorul nu introduce
		//fisierul sursa si nici fiesierul destinatie ca parametrii in linia de comanda
		System.out.println("****The constructor without parameters PowerMethodParameter has been called****");
		System.out.println("You did not specify the input file and the output file");
		
	}
	
	public PowerMethodParameter(String address, double gamma) {
		
		super(address);//apelez constructorul clasei de baza
		
		long startTime = System.nanoTime();
		g=gamma;
		//salvez imaginea sub forma de matrice
		for(int i = 0; i < height; i++){
		      for(int j = 0; j < width; j++){
		         
		    	  pixel[i][j] = image.getRGB(j,i);
		    	  red[i][j] = (pixel[i][j]>>16)&0xff;
			      green[i][j] = (pixel[i][j]>>8)&0xff;
			      blue[i][j] = (pixel[i][j])&0xff;
		    
		      }
		}
		
		long endTime = System.nanoTime();
        System.out.println("The time required to prepare the image for processing: "+(endTime - startTime)/ 1_000_000 + " milliseconds");
		
	}
	
@Override
public void execute() {
		
		long startTime = System.nanoTime();
		//execut operatia pentru fiecare pixel in parte
		for(int i = 0; i < height; i++){
		      for(int j = 0; j < width; j++){
		    	  
		    	  red[i][j] = (int)(ampl * Math.pow(red[i][j],g));
			      green[i][j] =(int)(ampl * Math.pow(green[i][j],g));
			      blue[i][j] = (int)(ampl * Math.pow(blue[i][j],g));  
			      pixel[i][j] = (red[i][j]<<16) | (green[i][j]<<8) | (blue[i][j]<<0);
			      image.setRGB(j, i, pixel[i][j]);
		    
		      }
		}
		
		long endTime = System.nanoTime();
        System.out.println("Image was processed in "+(endTime - startTime)/ 1_000_000 + " milliseconds");
		
	}

	@Override
	public void save(String address) {
		
		long startTime = System.nanoTime();
		//dupa ce am efectuat prelucrarea, salvez imginea
		try
        {
             ImageIO.write(image, "bmp", new File(address));
        } 
		
        catch (IOException exceptie) 
        {
            exceptie.printStackTrace();
        }
		
		System.out.println("Operatie cu gama dat de la tastatura");
		
		long endTime = System.nanoTime();
        System.out.println("Save image in "+(endTime - startTime)/ 1_000_000 + " milliseconds");
		
	}

	
}
