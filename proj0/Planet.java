public class Planet {
	/*six instance variables*/
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	/*planet constructor*/
	public Planet(double xP, double yP, double xV,
	double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	/*planet constructor,
	take in a Planet object
	and initialize an idential Planet object*/
	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	/*method, distance between two planets*/
	public double calcDistance(Planet p){
		return Math.pow((Math.pow((this.xxPos - p.xxPos),2) + 
		Math.pow((this.yyPos-p.yyPos),2)),0.5);
	}

	/*method, force between two planets*/
	public double calcForceExertedBy(Planet p){
		double G = 6.67e-11;
		return G*this.mass*p.mass*Math.pow(this.calcDistance(p),-2);
	}

	/*method, force x*/
	public double calcForceExertedByX(Planet p){
		return (p.xxPos-this.xxPos)*this.calcForceExertedBy(p)
		/this.calcDistance(p);
	}

	/*method, force y*/
	public double calcForceExertedByY(Planet p){
		return (p.yyPos-this.yyPos)*this.calcForceExertedBy(p)
		/this.calcDistance(p);
	}

	/*method, net force x*/
	public double calcNetForceExertedByX(Planet [] allp){
		double netforce = 0;
		for (int i = 0; i < allp.length; i +=1){
			if (this.equals(allp[i])){
				continue;
			}
			netforce += this.calcForceExertedByX(allp[i]);
		}
		return netforce;
	}

	/*method, net force y*/
	public double calcNetForceExertedByY(Planet [] allp){
		double netforce = 0;
		for (int i = 0; i < allp.length; i +=1){
			if (this.equals(allp[i])){
				continue;
			}
			netforce += this.calcForceExertedByY(allp[i]);
		}
		return netforce;
	}

	/*method, update position*/
	public void update(double dt, double fx, double fy){
		double ax = fx/this.mass;
		double ay = fy/this.mass;
		this.xxVel += dt * ax;
		this.yyVel += dt * ay;
		this.xxPos += dt * this.xxVel;
		this.yyPos += dt * this.yyVel;

	}

	/*method, use StdDraw to draw the Planet's image*/
	public void draw(){
		double xp = this.xxPos;
		double yp = this.yyPos;
		String img = this.imgFileName;
		StdDraw.picture(xp,yp,"images/"+img);
	}



}
