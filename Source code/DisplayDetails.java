package tema27_java;

public class DisplayDetails extends ImageDetails {

	public DisplayDetails(String address, String destination) {
		
		super(address, destination);//apelez constructorul clasei de baza

	}

	@Override
	public void display() {
		//functie de afisare a rezolutiei
		String result=this.getResolution();
		System.out.println("Picture resolution is " + result + " px");
		
	}

}
