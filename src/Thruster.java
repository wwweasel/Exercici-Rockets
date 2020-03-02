
public class Thruster {
	private int maximum_power;
	private int current_power;
	private int id;
	
	public Thruster( int id, int maximum_power ) {
		set_maximum_power(maximum_power);
		this.current_power = 0;
		this.id = id;
	}
	
	public void set_maximum_power(int maximum_power) {
		if(maximum_power > 0) {
			this.maximum_power = maximum_power;
		}
	}
	
	public int get_maximun_power() {
		return this.maximum_power;
	}
	
	public int get_current_power() {
		return this.current_power;
	}
	
	public void set_current_power(int current_power) {
		this.current_power = current_power;
	}
	
	public void increment_current_power() {
		this.current_power++;
	}
	
	public void decrement_current_power() {
		this.current_power--;
	}

	@Override
	public String toString() {
		return "thruster_"+this.id; // + " maximum_power = " + maximum_power
	}

//	@Override
//	public void run() {
//		while(true) {
//			if( get_current_power()<get_maximun_power() ) {
//				increment_current_power();
//			}else if(get_current_power()>get_maximun_power()) {
//				decrement_current_power();
//			}
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}	
	
}
