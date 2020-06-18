
public class DisplayDetails2 extends DisplayDetails {

	public DisplayDetails2(String address, String destination) {
		
		super(address, destination);//apelez constructorul clasei de baza
		
	}
	
	@Override
	public void display() {
		//functie care afiseaza sursa si destinatia introdusa
		String source=this.getSource();
		System.out.println("Image source is " + source);
		String dest=this.getDestination();
		System.out.println("Folder destination is " + dest);
		
	}

}
