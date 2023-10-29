//ibrahim alyan
//322675356
public class DnaSequence {
//fields
	private String sequence;
	private int [] nucleotideCounts;
	
//empty constructor
	public DnaSequence() {
		this.sequence = "ACGT";
		this.nucleotideCounts = new int[]{1,1,1,1};
		
	}
	
//constructor  who gets a sequence. If it is a valid DNA sequence, it initializes both fields
//in accordance. Otherwise, the boot is done as in the empty builder. 
	public DnaSequence(String sequence) {
		
		if (isDnaSequence(sequence)) {
			this.sequence = sequence;
			this.nucleotideCounts =  getNucleotideCounts();
		}else {
			
			this.sequence = "ACGT";
			this.nucleotideCounts = new int[]{1,1,1,1};
			
		}
	}
	
//copy constructor
	public DnaSequence(DnaSequence other) {
		this.sequence = other.sequence;
		this.nucleotideCounts = other.nucleotideCounts;
	}
//getters&&setters
	public String getSequence() {
		return sequence;
	}

    public int[] getNucleotideCounts() {
    	
    	int i = 0;
    	
    	int[] new_zero_array = new int[]{0,0,0,0};
		
		return getNucleotideCounts(new_zero_array, i);
	}

	public void setSequence(String sequence) {
		if (isDnaSequence(sequence)) {
			this.sequence = sequence;
			this.nucleotideCounts =  getNucleotideCounts();
		}
	}

   
	
//isDnaSequence method that gets a string and checks if it is a valid DNA sequence
    public static boolean isDnaSequence(String sequence) {
		return isDnaSequence(sequence, 0);
	}
    
//changeCapitalization method Which turns each small letter in the sequence into a large letter and vice versa
    public void changeCapitalization() {
    	int i =0;
    	String new_seq = "";
    	changeCapitalization(i, new_seq);
    }
    

//addArray method Which gets 2 arrays and adds the second to the first, without changing the
//The second. If one of the arrays is null or the arrays are not the same length, the method
//Returns false. Otherwise, true will be returned
	public static boolean addArray(int[] arr1, int[] arr2) {
		if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
			return false;
		}
		
	    int [] sum_array = new int [arr1.length];
	   copy_array(arr1,add_Array(arr1,arr2,0,sum_array),0);
	  
		
		
		return true;
	}


//concatGenes method Which chains a DNA sequence at the end of the sequence of this. In addition the method updates the counts
    public void concatGenes(DnaSequence other) {
		
		this.sequence = this.sequence + other.getSequence();
		
		this.nucleotideCounts = getNucleotideCounts();
	}

//String toString method a special way will let us us print the object
    public String toString(){
		return this.sequence + ": (" + this.nucleotideCounts[0] + ", " 
	                                  + this.nucleotideCounts[1] + ", "
	                                  + this.nucleotideCounts[2] + ", "
	                                  + this.nucleotideCounts[3] + ")";
	                                             
				
			
	}
	
	
//it will give is if the the sentence sequence is legal 	
	private static boolean isDnaSequence(String sequence, int i) {
		
		if (sequence.charAt(i) != 'A' && sequence.charAt(i) != 'C' && sequence.charAt(i) != 'G' && sequence.charAt(i) != 'T' &&
				sequence.charAt(i) != 'a' && sequence.charAt(i) != 'c' && sequence.charAt(i) != 'g' && sequence.charAt(i) != 't') {
			return false;
		}
		
		if ( i < sequence.length()-1 ) {
			return isDnaSequence(sequence, i +1);
		}
		
		return true;
		
		
	}
	
 
//it will give us the letters of times the letters A C G T appear alone,either capital or small	
	private int[] getNucleotideCounts(int[] array, int i) {
		
		if (this.sequence.charAt(i) == 'A' || this.sequence.charAt(i) == 'a') {
			array[0] += 1;
			
		}
		
		if (this.sequence.charAt(i) == 'C' || this.sequence.charAt(i) == 'c') {
			array[1] += 1;		}
		
		if (this.sequence.charAt(i) == 'G' || this.sequence.charAt(i) == 'g') {
			array[2] += 1;
		}
		
		if (this.sequence.charAt(i) == 'T' || this.sequence.charAt(i) == 't') {
			array[3] += 1;
		}
		
		if ( i < this.sequence.length()-1 ) {
			return getNucleotideCounts(array, i + 1);
		}
		
		return array;
	}
//it will change the capital letters to small letters and vica versa	
    public void changeCapitalization(int i, String new_seq) {
		
		

		if ( is_capital(this.sequence.charAt(i)) ){
			new_seq = new_seq + get_small_of(this.sequence.charAt(i));
		}else {
			new_seq = new_seq + get_capital_of(this.sequence.charAt(i));
		}
		
		if (i < this.sequence.length()-1) {
			changeCapitalization(i+1,new_seq);
		}else {
			this.sequence = new_seq;
			return;
		}
	
		
	}
//it will change the capital letters to small letters
	private char get_small_of(char c) {
		final int DIFF = 32;
		if(c >= 'A' && c <= 'Z')
			c += DIFF;
		return c;

	}
//it will change the small letters to capital letters	
	private char get_capital_of(char c) {
		final int DIFF = 32;
		if(c >= 'a' && c <= 'z')
			c -= DIFF;
		return c;

	}
//it will scan if the letters is capital
	private boolean is_capital(char c) {
		if (c >='A' && c <='Z'){
			return true;
		}
		return false;
	}
	
//it will takes two arrays and will collect them and put thier value in sum_array and will return it
    private  static int[]  add_Array(int[] arr1, int[] arr2,int i, int [] sum_array) {
		if ( i < arr1.length) {
			sum_array[i] = arr1[i] + arr2[i];
			return add_Array(arr1,arr2,i+1,sum_array);
		}
			if(i == arr1.length-1) {
				return sum_array;
			}
				
			else {
				return sum_array;
			}
			}
		
	
 //it will takes arr1 and will copy it arr2 which come originally collect arr1+arr2 (sum_array)
//without change arr2 
    private static  void copy_array(int[]arr1,int[]arr2,int i) {
    	if (i < arr1.length) {
    		arr1[i]=arr2[i];
    		copy_array(arr1,arr2,i+1);
    	}
    	
    	
    }

}
