import java.awt.Color;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Rocket rocket1 = new Rocket("32WESSDS");
		rocket1.add_thruster(1,10);
		rocket1.add_thruster(2,30);
		rocket1.add_thruster(3,80);
		
		Rocket rocket2 = new Rocket("LDSFJA32");
		rocket2.add_thruster(1,30);
		rocket2.add_thruster(2,40);
		rocket2.add_thruster(3,50);
		rocket2.add_thruster(4,50);
		rocket2.add_thruster(5,30);
		rocket2.add_thruster(6,10);
		
		//System.out.println(rocket1.toString());
		//System.out.println(rocket2.toString());
		
		rocket1.go_into_freakin_space(10);
//		for (Thruster thruster : rocket1.get_thrusters()) {
//			System.out.println(thruster.get_current_power());
//		}
		rocket1.start_engine();
		
		
	}
}
