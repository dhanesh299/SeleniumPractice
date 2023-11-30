
public class exceptionExample {

	public static void main(String[] args) {
		exceptionExample e = new exceptionExample();
		e.myOwnException();
	}

	public void myOwnException() {
		System.out.println("Hi");
		try {
			throw new Exception("Own Exception");
		}
		catch (Exception ae) {
			ae.printStackTrace();
		}
	}
}
