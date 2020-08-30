public class NBody{
	/*given a file name, return the radius of the universe*/
	public static double readRadius (String file){
		In in = new In(file);
		in.readInt();
		return in.readDouble();

	}

	/*given a file name, return a planet array*/
	public static Planet[] readPlanets (String file){
		In in = new In(file);
		int n = in.readInt();
		in.readDouble();
		Planet[] allp = new Planet[n];
		for (int i = 0; i < n; i = i + 1){
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m = in.readDouble(); 
			String img = in.readString();
			Planet p = new Planet(xP,yP,xV,yV,m,img);
			allp[i] = p;
		}

		return allp;
	}

	/*drawing the initial universe state*/
	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2] ;
		double radius = readRadius(filename);
		Planet[] allp = readPlanets(filename);

		// set the scale of the coordinate system
		StdDraw.setXscale(-radius, radius);
        StdDraw.setYscale(-radius, radius);
        
        StdDraw.enableDoubleBuffering();
        
        double t = 0.0;
        while (t < T){
        	double [] xForces = new double[allp.length];
        	double [] yForces = new double[allp.length];
        	// update forces
        	for (int i = 0; i < allp.length; i += 1){
        		xForces[i] = allp[i].calcNetForceExertedByX(allp);
        		yForces[i] = allp[i].calcNetForceExertedByY(allp);
        	}
        	// update position
        	for (int i = 0; i < allp.length; i += 1){
        		allp[i].update(dt, xForces[i],yForces[i]);
        	}

        	// drawo the background
        	StdDraw.picture(0,0,"images/starfield.jpg");
        	// draw all planet
			for (Planet p: allp){
				p.draw();
			}
			StdDraw.show();
			StdDraw.pause(20);
			t += dt;	
        }

	}

}