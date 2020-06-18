
import java.util.Scanner;
import java.io.*;

public class MainClass {

	public static void main(String[] args)throws IOException {
		
		long startTime = System.nanoTime();//salvez timpul curent
		
		if(args.length==2) {
			
		double gamma;//parametrul care va fi citit de la tastatura
		String source=new String(args[0]);//salvare fisier sursa imagine
		String dest=new String(args[1]);//salvare fisier destinatie imagine
		source = source.replace("\\","/");//replace daca este cazul
		dest = dest.replace("\\","/");
		String valid1 = new String("default");//string-uri pentru verificare
		String valid2 = new String("custom");
		
		System.out.println("************************Program Start************************");
		System.out.println("\n");
			
			System.out.println("Do you want to run the program with default or custom parameters ?");
			System.out.println("\n");
			System.out.println("Please press 'default' for default mode or 'custom' for custom mode!");
			System.out.println("\n");
		
			String input = System.console().readLine();
			while(input.equals(valid1)!=true && input.equals(valid2)!=true)//daca parametrii nu sunt valizi
			{
				System.out.println("****The value entered is not valid!!!****");
				System.out.println("\n");
				System.out.println("****Please type a valid one!!! ('default' or 'custom')****");
				input = System.console().readLine();
			}
			if(input.equals(valid1)==true)
			{
				ReadImage image = new PowerMethod (source);//daca a fost ales modul default
				image.execute();//execut operatiile asupra obiectului de tip ReadImage
				image.save(dest);//scriu imaginea in fisier
				System.out.println("\n");
				ImageDetails dd2=new DisplayDetails2(source,dest); 
				dd2.display();
				ImageDetails dd=new DisplayDetails(source,dest); 
				dd.display();
				dd.getCommandInfo(source,dest);
				System.out.println("\n");
				System.out.println("********************End of Program************************");
			}
			if(input.equals(valid2)==true)
			{
				System.out.println("\n");
				System.out.println("Please type gamma parameter!");
				System.out.println("\n");
				System.out.println("Gamma must be between 1.8 and 2.5");
				System.out.println("\n");
				Scanner scan = new Scanner( System.in );//citesc gamma pentru modul custom
				gamma = scan.nextDouble();
				ReadImage image = new PowerMethodParameter (source,gamma);//creez obiectul
				image.execute();//execut operatii asupra lui
				image.save(dest);//efectuez scrierea in fisier
				scan.close();
				System.out.println("\n");
				ImageDetails dd2=new DisplayDetails2(source,dest); 
				dd2.display();//afisez fisierul sursa si pe cel destinatie
				ImageDetails dd=new DisplayDetails(source,dest); 
				dd.display();//afisez rezolutia imaginii
				String gm=String.valueOf(gamma);
				dd.getCommandInfo(input,source,dest,gm);
				System.out.println("\n");
				System.out.println("********************End of Program************************");
			}
		
		
		}
		
		else {
			
			System.out.println("************************Program Start************************");
			System.out.println("\n");
			ReadImage image = new PowerMethod ();
			System.out.println("\n");
			System.out.println("**********************End of Program*************************");
			
		}
		
		long endTime = System.nanoTime();//salvez timpul curent, de la finalul executiei
        System.out.println("Total time "+(endTime - startTime)/ 1_000_000 + " milliseconds");
        //calculez timpul final
		
	}

}
