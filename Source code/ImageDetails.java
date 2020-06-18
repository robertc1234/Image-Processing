
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;



public abstract class ImageDetails {
	
	String src, dst;
	
	BufferedImage image = null;
	int width,height;
	
	public ImageDetails(String address, String destination){
		
		src=address;//salvez sursa
		dst=destination;//salvez destinatia
		
		File picture = new File(address);
		
		try
        {
            
			image = ImageIO.read(picture);//citire imagine
            width = image.getWidth(); //obtin dimensiunile imaginilor
            height = image.getHeight();
           
        } 
        
		catch (IOException exceptie) 
        {
            exceptie.printStackTrace();
        }
		
	}
	
	public void getCommandInfo(String... s) {
		
		System.out.println("The Varargs function returned:");
		System.out.println("\n");
		
		int c = 1;
		
		 for(Object i:s) {
			 
			 System.out.println("Parameter" + c + " is: ");
			 System.out.println(i);
			 System.out.println("\n");
			 c=c+1;
			 
		 }
		 
		 //System.out.println("\n");
		 System.out.println("End of varargs function");
	    
		
		
	}
	
	public String getResolution() {
		
		return height + "x" + width;//returnez rezolutia imaginii
		
	}
	
	public String getSource() {
		
		return src;//returnez sursa
		
	}
	
	public String getDestination() {
		
		return dst;//returnez destinatia
		
	}
	
	public abstract void display();//metoda abstracta de afisare

}
