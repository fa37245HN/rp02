import java.io.*;

public class FallAndLandWithLog {
    public static void main(String args[]) {
	double x, y, x_speed, y_speed, x_initial_speed, x_wind_speed1;
	double y_power, y_fuel, y_braking_point;
	double r;
	double g;
	int c;

	String buf;

	g = -9.80665;

	x = 0;
	y = 100000;
	x_initial_speed = 800;
	x_wind_speed1 = 200;
	y_power = 50;
	y_fuel = 200;

	y_braking_point = 20000;

	x_speed = x_initial_speed;
	y_speed = 0;

	r = 100000;

	c = 0;

	try {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    System.err.print("y_brking_point = ");
	    buf = br.readLine();
	    y_braking_point = Double.parseDouble(buf);
	    System.err.print("y_fuel = ");
	    buf = br.readLine();
	    y_fuel = Double.parseDouble(buf);
	    System.err.print("y_power = ");
	    buf = br.readLine();
	    y_power = Double.parseDouble(buf);

	} catch(Exception e) {
	    System.err.print("Error:" + e);
	}

	while(y >= 0) {
	    y_speed += g/r;

	    if(y_fuel > 0) {
		/* use thruster */
		if(y < y_braking_point && y_speed < -2.0) {
		    y_speed += y_power/r;
		    y_fuel -= 1.0/r;
		}
	    }

	    x += x_speed/r;
	    y += y_speed/r;

	    c++;
	    if(c >= r) {
		System.out.print("" + x + "\t" + y + "\n");
		c = 0;
	    }
	}
	System.err.print("estimated distance = " + x + "\n");
	System.err.print("landing y speed = " + y_speed + "\n");
	System.err.print("rest fuel = " + y_fuel + "\n");

	return;
    }
}
