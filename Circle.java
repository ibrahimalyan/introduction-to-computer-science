
public class Circle {
	//fields
	public Point center;
	public double radius;
	
	public Circle() {
	this.center=new Point(0,0);
	this.radius=1;
	}
	//constructor   it will give us the values center and radius
	public Circle(Point center, double radius) {
		this.center=new Point(center);
		if(radius>0) {
		this.radius=radius;}
		else {
			this.radius=1;}
		
	}
	//copy constructor   it will give us the same values center and radius
	public Circle(Circle other) {
		this.center = new Point(other.center);
		this.radius=other.radius;
	}
  //getters&&setters
	public Point getCenter() {
		return new Point(center);
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		if(radius>0) {
		this.radius = radius;}
	}
	//method StringtoString a special way will let us us print the object
	public String toString() {
		return "Circle at "+center+", radius "+radius;
	}
	
	//method area it will give us the area
	public double area() {
	
		return Math.PI*radius*radius;
		
	}
	
	//method perimeter it will give us the perimeter 
	public double perimeter()
	{
	
		return 2*Math.PI*radius;
		
	}
	//method equals it will give us if They have the same radius and the same center between the two circle
	public boolean equals(Circle other) {
		return this.center.equals(other.center) && this.radius == other.radius;
		
		
		
	}
	//method touches it will give us if the two circle If there is a point of contact between the two circle
	public boolean touches(Circle other) {
	    return this.radius+other.radius==this.center.distanceFrom(other.center)
		    ||this.radius-other.radius==this.center.distanceFrom(other.center);
	}
	
	//method contains it will give us If the other first circle contains completely within the range
    public boolean contains(Circle other) {
	    return (this.center.equals(other.center)&&this.radius==other.radius) 
	        || this.radius>=this.center.distanceFrom(other.center)+other.radius;
	
}
    
    //method intersects it will give us  If you have a point of intersection between the two circles
    public boolean intersects(Circle other) {
    	return this.contains(other)||((this.center.distanceFrom(other.center)<this.radius+other.radius)
			&& (this.center.distanceFrom(other.center)<this.radius));
}
    
    //method contains it will give us If the circle contains a point
    public boolean contains(Point p) {
		return this.center.distanceFrom(p)<=this.radius;
}

    
    //method subCircle it will returns a circle which is a sub-circle of the circle
    public Circle subCircle() {
    	return new Circle (new Point((this.center.getX()+this.radius/2),this.center.getY()),this.radius/2);
}

}