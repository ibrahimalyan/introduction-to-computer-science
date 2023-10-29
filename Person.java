
public class Person {
	
	//field
	public String name;
	public int id;
	public double height;
	public double weight;	
	public double temperature;
	public boolean hasMask;
	//person method
	public Person() {
	name="";
	id=-1;
	height=-1;
	weight=-1;
	temperature=-1;
	hasMask=false;
	}
	//person method
	public Person(String name, int id, double weight,
	double height, double temperature, boolean hasMask) {
	this.name=name;
	this.id=id;
	this.weight=weight;
	this.height=height;
	this.temperature=temperature;
	this.hasMask=hasMask;
	}
	//getters&&setters
	public String getName() {
	    return name;
	}

	public void setName(String newName) {
	    name=newName;
	}


	public int getId() {
		return id;
	}

	public void setId(int newId) {
		if(newId>0) id=newId;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double newHeight) {
		if(newHeight>0) height=newHeight;
	}
	  
	public double getWeight() {
		 return weight;
	}

	public void setWeight(double newWeight) {
		if(newWeight>0) weight=newWeight;
	}

	public double getTemperature() {
	    return temperature;
	}

	public void setTemperature(double newTemperature) {
		if(newTemperature>0) temperature=newTemperature;
	}

	public boolean getHasMask() {
		return hasMask;
	}

	public void setHasMask(boolean newHasMask) {
		hasMask=newHasMask;
	}
	//toString method
	public String toString() {
		String heightprint,weightprint,temprint,hasmaskprint="";
		heightprint=String.format("%.2f",height);
		weightprint=String.format("%.2f",weight);
		temprint=String.format("%.2f",temperature);
		if(hasMask==true) {
			hasmaskprint="";
		}
		if (hasMask==false) {
			hasmaskprint="not";
		}
		return "person "+name+ ", "+id+": height"+ heightprint+
				", weight"+weightprint+", temp"+temprint+
				" (is "+ hasmaskprint+" wearing a mask)";
				}
	//ncrementTemperature method
	public void incrementTemperature(double num) {
		if (num > 0) {
			temperature += num;
		}
	}
	//toFahrenheit method
	public double toFahrenheit() {
		return (temperature * 1.8)+32;
	}
	//temperature method
	public double temperature(boolean isCelsius) {
		if(isCelsius==true) {
			return temperature;
		}
		else {
			double fahren= toFahrenheit();
			return fahren;}
		}
	//bmi method
	 public double bmi() {
		 return weight/((height/100)*(height/100)); 
	}
	 //bmiDescription method
	 public String bmiDescription() {
		double bmi = bmi();
		if(bmi<=18.5) {
			return "underweight";}
		else if (bmi>=18.5 && bmi<=24.9) {
				return "normal";
			}
			else {
				return "overweight";
			}
	 }
	 //shouldBeInQuarantine method
	 public boolean shouldBeInQuarantine() {
		 double bmi = bmi();
		 if(bmi<20 && temperature>37.8) {
			 return true;
		 }
		 else if(bmi>=20 && temperature>38.1) {
			 return true;
		 }
		 else {
			 return false;
		 }
	 }}





	

