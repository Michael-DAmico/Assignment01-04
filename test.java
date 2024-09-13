package flightpack;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Airport apl = new Airport("Delta", "York", "Maine");
		System.out.println(apl.getName()+", "+apl.getCity()+", "+apl.getState());
		System.out.println(args[0]);
}

}
