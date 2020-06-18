package tema27_java;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PowerMethod extends ReadImage3{
	
	double power=1.2;//puterea la care este ridicata valoarea pixelului
	double ampl=0.3;//factorul de ampificare
	
	public PowerMethod() {
		
		//constructor fara parametru, utilizat in cazul in care utilizatorul nu introduce
		//fisierul sursa si nici fiesierul destinatie ca parametrii in linia de comanda
		System.out.println("****The constructor without parameters PowerMethod has been called****");
		System.out.println("You did not specify the input file and the output file");
		
	}

	public PowerMethod(String address) {
		
		super(address);//apelez constructorul din clasa pe care o mosteneste
		long startTime = System.nanoTime();
		for(int i = 0; i < height; i++){
		      for(int j = 0; j < width; j++){
		     
				  pixel[i][j] = image.getRGB(j,i);//salvez imaginea
				  red[i][j] = (pixel[i][j]>>16)&0xff;//matricea corespunzatoare pentru culoarea rosie
				  green[i][j] = (pixel[i][j]>>8)&0xff;//matricea corespunzatoare pentru culoarea verde
				  blue[i][j] = (pixel[i][j])&0xff;//matricea corespunzatoare pentru culoarea albastra
		    
		      }
		}
		
		long endTime = System.nanoTime();
        System.out.println("The time required to prepare the image for processing "+(endTime - startTime)/ 1_000_000 + " milliseconds");
		
	}
@Override
public void execute() {
	
		long startTime = System.nanoTime();
		//pentru fiecare pixel (element al matricei) execut operatia de transformare
		for(int i = 0; i < height; i++){
		      for(int j = 0; j < width; j++){
		    	 
			      red[i][j] = (int)(ampl * Math.pow(red[i][j],power));
			      green[i][j] =(int)(ampl * Math.pow(green[i][j],power));
			      blue[i][j] = (int)(ampl * Math.pow(blue[i][j],power));
			      pixel[i][j] = (red[i][j]<<16) | (green[i][j]<<8) | (blue[i][j]);
			      image.setRGB(j, i, pixel[i][j]);
		    
		      }
		}
		
		long endTime = System.nanoTime();
        System.out.println("Image was processed in "+(endTime - startTime)/ 1_000_000 + " milliseconds");
		
	}

	@Override
	public void save(String address) {
		
		long startTime = System.nanoTime();
		//salvez imaginea dupa prelucrare
		try
        {
             ImageIO.write(image, "bmp", new File(address));
        } 
		
        catch (IOException exceptie) 
        {
            exceptie.printStackTrace();
        }
		
		System.out.println("Operatie cu gama presetat");
		
		long endTime = System.nanoTime();
        System.out.println("Save image in "+(endTime - startTime)/ 1_000_000 + " milliseconds");
		
	}

	
}
