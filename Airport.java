/**
 * 
 */
package flightpack;

/**
 * @author Michael
 *
 */
/**
 * @author Michael
 *
 */
public class Airport {
	
	 private String name;
	 private String city;
	 private String state;
	 
	 public Airport(String name, String city, String state) {
		 setName(name);
		 setCity(city);
		 setState(state);
		 
	 }

	   

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
