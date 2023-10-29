
public class City {
	//feild 
			private String name;
			private String country;
			private int numQuarantined;
			private int numSick;
			private int numHealthy;
			private double coronaScore;
			private String color;
			private int population;
			
			//method colorcity
			public void colorcity() {
				 population = numQuarantined+numSick+numHealthy;
				coronaScore= (double)(numQuarantined+numSick)/population;
				if (coronaScore < 0.3) {
					color = "Green";			
				}
				else if (coronaScore >= 0.7) {
					color = "Red";
				}
				else {
					color = "Orange";
				}
			}
			
			
			
			
			//constructar
			public City(String name, String country, int numHealthy, int numSick, int numQuarantined) {
				this.name=name;
				this.country=country;
				this.numHealthy=numHealthy;
				this.numSick=numSick;
				this.numQuarantined=numQuarantined;		
				colorcity();
			}
			
			//copy constructar
			public City(City other) {
				this.name=other.name;
				this.country=other.country;
				this.numHealthy=other.numHealthy;
				this.numSick=other.numSick;
				this.numQuarantined=other.numQuarantined;
				this.coronaScore=other.coronaScore;
				this.color=other.color;
				
			}
			//constructar
			public City(City city1, City city2) {
				this.name=city1.name + "-" + city2.name;
				this.country=city1.country;
				this.numHealthy=city1.numHealthy+city2.numHealthy;
				this.numSick=city1.numSick+city2.numSick;
				this.numQuarantined=city1.numQuarantined+city2.numQuarantined;
				colorcity();
				
			}
			
			  //getters
			public String getName() {
				return name;
			}

			public String getCountry() {
				return country;
			}

			public int getNumQuarantined() {
				return numQuarantined;
			}

			public int getNumSick() {
				return numSick;
			}

			public int getNumHealthy() {
				return numHealthy;
			}

			public double getCoronaScore() {
				return coronaScore;
			}

			public String getColor() {
				return color;
			}
			
			//method equals 
			public boolean equals(City other) {
				if(this.name == other.name && this.country == this.country ) {
					return true;
					
				}
				else {
					return false;
				}}
				
				//methodsaferThan	
		    public boolean saferThan(City other) {
		    	if(this.numSick < other.numSick && this.numQuarantined < other.numQuarantined) {
		    		return true;
		    	}
		    	else {
		    		return false;
		    	}}
				
		    //method biggerThan
		    public boolean biggerThan(City other) {
		    if(this.population > other.population) {
		    	return true;
		   
		    }
		    else {
		    	return false;
		    
		    	
		    }}
		     //methodtostring
		    public String toString() {
		    	double numhealthy=(double)(numHealthy*100)/(double)population;
		    	String healthyper = String.format("%.2f",numhealthy );
		    	String scorona = String.format("%.3f",coronaScore );
		    	
		    	return "City "+this.name+", "+this.country+" has "+this.population+" residents (healthy:"+
		    			this.numHealthy+", sick: "+this.numSick+", quarantined:"+numQuarantined+
		    			"). %healthy = "+ healthyper+"%,  Corona score:"+scorona+" ("+color+")";
		    
		    }
		    
		   //methodgetSickRati 
		    public double getSickRatio() {
		    	return (double) numSick/ (double) population;
		    	
		    }
		  
		    //methodgetQuarantinedRatio
		    public double getQuarantinedRatio() {
		    	return (double) numQuarantined/(double) population;
		    }
		    
		    //method getHealthyRatio
		    public double getHealthyRatio() {
		    	return (double) numHealthy/(double) population;
		    	
		    }
		    
		    //methodaddHealthyResidents 
		    public void addHealthyResidents(int numHealthy) {
		    	this.numHealthy +=numHealthy;
		    	colorcity();
		    }
		    
		    //methodsendToQuarantine
		    public void sendToQuarantine(int numNewQuarantine) {
		    	if (numNewQuarantine>0) {
		    		if(numNewQuarantine>=numHealthy) {
		    			numQuarantined+=numHealthy;
		    			numHealthy=0;}
		    		
		    		else if(numNewQuarantine<numHealthy) {
		    			numHealthy-=numNewQuarantine;
		    			numQuarantined+=numNewQuarantine;}
		    		
		    		colorcity();
		    		}}
		    		
		    	
		    	//methodreleaseFromQuarantine
		    	public void releaseFromQuarantine(int numNewHealthy) {
		    		if(numNewHealthy>0) {
		    			if(numNewHealthy>=numQuarantined) {
		    			numHealthy+=numNewHealthy;numQuarantined=0;}
		    			else if(numNewHealthy<numQuarantined) {
		    		    numQuarantined-=numNewHealthy;
		    		    numHealthy+=numNewHealthy;}
		    			colorcity();}
		    	}
		    	
		    	//methodmultiplySickResidents
		    	public void multiplySickResidents(int factor) {
		    		int pat = (factor * numSick) - numSick;
		    		if(factor>0) {
		    			
		    		
		    		if(pat > numHealthy +  numQuarantined ) {
		    			 numQuarantined=0;
		    			 numHealthy=0;}
		    		else if(pat >= numQuarantined &&pat < numHealthy) {
		    			 numSick *= factor;
		    	           pat -=numQuarantined;
		    	           numHealthy -=pat;
		    	           numQuarantined =0;}
		    		 else if(pat < numQuarantined) {
		    	            numSick*=factor;
		    	            numQuarantined-=pat;}
		    	         	colorcity();}
		    		}
		    	
		    	//methodreleaseFromHospital
		    	public void releaseFromHospital(int numGotHealthy) {
		    		if(numGotHealthy>0) {
		    			if(numGotHealthy>=numSick) {
		    				numHealthy+=numSick;numSick=0;}
		    			
		    			else if(numGotHealthy<numSick) {
		    				
		    				numHealthy+=numGotHealthy;
		    				numSick-=numGotHealthy;}
		    			
		    			colorcity();}}
		    			
		    		
		    	}

		    	



