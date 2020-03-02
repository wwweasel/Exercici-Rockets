import java.util.ArrayList;
import java.util.List;

public class Rocket extends Thread {
	private String code;
	private int thruster_number;
	private ArrayList<Thruster> thrusters;
	private boolean engine_is_running = false;
	private int init_velocity;
	private int velocity;
	
	public Rocket( String code){
		this.code = code;
		//this.throttle_number = throttle_number;
		this.thrusters = new ArrayList<Thruster>();
	}
	
	public void add_thruster( int id, int power) {
		thrusters.add(new Thruster(id,power));
	}
	
	public ArrayList<Thruster> get_thrusters() {
		return this.thrusters;
	}
	
	@Override
	public String toString() {
		return "rocket_code = " + code + " number_of_thrusters = " + thrusters.size() + "\n" +"\t" + "thrusters = " + thrusters;
	}
	
	public void start_engine() {
//		for (Thruster thruster : thrusters) {
//			thruster.start();
//		}
		this.start();
		engine_is_running = true;
	}
	
	public void stop_engine() {
//		for (Thruster thruster : thrusters) {
//			thruster.interrupt();
//		}
		this.interrupt();
		engine_is_running = false;
	}
	
	@Override
	public void run() {
		while(engine_is_running) {
			accelerate();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
	
	public void accelerate() {
		for (Thruster thruster : thrusters) {
			if( thruster.get_current_power() < thruster.get_maximun_power() ) {
				thruster.increment_current_power();
				System.out.print(thruster.toString() + " has a current_power of: "+thruster.get_current_power()+"___");
			}else if(thruster.get_current_power() == thruster.get_maximun_power()) {
				System.out.println(thruster.toString() + " has a reached its maximum power! ");
			}
		}
		System.out.println("\n");
	}
	
	public void brake() {
		for (Thruster thruster : thrusters) {
			if( thruster.get_current_power() > 0 ) {
				thruster.decrement_current_power();
			}
		}
	}
	
	public void go_into_freakin_space(int init_velocity) {
		this.init_velocity = init_velocity;
		// sum up the power of all thrusters
		int maximun_velocity = 0;
		for (Thruster thruster : this.thrusters) {
			maximun_velocity = maximun_velocity + thruster.get_maximun_power();
		}
		
		// Calculate how much power you have to accumulate into the system in order to reach the highest speed possible
		if(this.init_velocity > maximun_velocity) {
			System.out.println("Init_velocity is higher than the Roket's maximun_velocity");
		}else if(init_velocity == maximun_velocity) {
			System.out.println("There's nothing more to do, because the maximun_velocity is already given through the init_velocity.");
		}else {
			int rest_velocity = maximun_velocity - init_velocity;
			for (Thruster thruster : thrusters) {
				int init_current_power = Math.round(100 / (float)(rest_velocity) * thruster.get_maximun_power());// 
				thruster.set_current_power(init_current_power);
			}
			
		}	
		
	}
}
