package testNGSelection;

import org.testng.annotations.Test;

public class testSelectionTestNG {

	@Test(groups={"NA","US","Desktop"})
	public void usDesktop() {
		System.out.println("NA - US - Dektop case");
	}
	
	@Test(groups={"NA","US","Mobile"})
	public void usMobile() {
		System.out.println("NA - US - Mobile case");
	}
	
	@Test(groups={"NA","CA","Desktop"})
	public void caDesktop() {
		System.out.println("NA - CA - Desktop case");
	}
	
	@Test(groups={"NA","CA","Mobile"})
	public void caMobile() {
		System.out.println("NA - CA - Mobile case");
	}
	
	@Test(groups={"EU","UK","Desktop"})
	public void ukDesktop() {
		System.out.println("EU - UK - Desktop case");
	}
	
	@Test(groups={"EU","UK","Mobile"})
	public void ukMobile() {
		System.out.println("EU - UK - Mobile case");
	}
	
	@Test(groups={"EU","FR","Desktop"})
	public void frDesktop() {
		System.out.println("EU - FR - Desktop case");
	}
	
	@Test(groups={"EU","FR","Mobile"})
	public void frMobile() {
		System.out.println("EU - FR - Mobile case");
	}
}
