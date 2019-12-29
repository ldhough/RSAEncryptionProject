package RSAEncrypt;

public class MVC {

	private Controller myController;
	
	public static void main(String[] args) {
		new MVC();
	}
	
	public MVC() {
		setController(new Controller());
	}
	
	public void setController(Controller controller) {
		myController = controller;
	}
	
	public Controller getController() {
		return myController;
	}
	
}
