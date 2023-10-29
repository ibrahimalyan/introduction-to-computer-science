//ibrahim alyan
//322675356
public class ArrayUtils {
	
//String toString method a special way will let us us print the object
	public static String toString(int[] arr) {
		if (arr == null) {
			return null;}
		if (arr.length==0) {
			return "[]";
		}
	
			String ans = "[" +arr[0];
			for ( int i=1;i<arr.length;i++) {
				ans += ", "+ arr[i];}
			ans+="]";
			return ans;
	}
//absArray method that accepts an array of integers and returns a new array whose members are the 
//absolute values of the array obtained. If arr is null, the method returns null.
	public static int[] absArray(int[] arr) {
		if  (arr == null) {
			return null;
		}
		if (arr.length==0) {
			return arr;
		}
		int [] new_arr = new int [arr.length];
		for (int i = 0; i <new_arr.length; i++) {
			new_arr[i]=(int) Math.sqrt(arr[i]*arr[i]);
  }
			
			return new_arr;
		}
//fill method that accepts an array of integer numbers and a valued value and changes the array accordingly
//That it puts in each cell in the array the value val. If arr is null, the method does nothing
		public static void fill(int[] arr, int value) {
			if  (arr == null) {
				return;}
			if (arr.length==0) {
				return;}
			
		
				for (int i =0;i<arr.length;i++) {
					arr[i] = value;
				}}
		
//fill method that accepts an array of integers, a selection value and two indexes at the beginning		
//And end. The method changes the resulting array so that it puts the val value in eachThe method does not change the array array
//if arr is null or one of the indexes is invalid 
		public static void fill(int[] arr, int value,int start, int end) {
			if(arr == null) {
				return;}
			if (arr.length==0) {
				return;}
			if ( start>=end || start <0 || start >arr.length-1 || end <0 || end >arr.length-1 ) {
				return;}

			for (int i =start;i<end;i++) {
				arr[i] = value;}
		}
		
//contains method that receives two sets and returns true if it contains the members in the second set
//Appear in the first array. Otherwise, false will be returned. If one of the arrays or both arenull, will be returned false	
		public static boolean contains(int[] arr1, int[] arr2) {
			if  (arr1 == null || arr2 == null) {
				return false;}
			if( arr2.length==0) {
				return false;}
			 boolean contain_array=false;
			 for (int i = 0; i < arr2.length ; i++) {
               if(contain_array==false && i>0) {
              	 break;}
               
               contain_array=false;
               for (int j = 0; j < arr1.length; j++) {
                       if(arr2[i]==arr1[j]) {
                       contain_array=true;}}
               }
       
       return contain_array;
			
		}
		
//getMaxPosition method that receives an array of integer numbers and returns the index of		 
//The maximum limb. If the array array obtained is null, 1- is returned.
		public static int getMaxPosition(int[] arr) {
			if(arr == null) {
				return -1;}
			if (arr.length==0) {
				return-1;}
			int Max=0;
			for(int i = 0; i < arr.length; i++) {
				
			if (arr[i]>Max) {
				Max=i;}}
			return Max;
			}
			
//getMult method that accepts an array of integer numbers and returns the product of each organ
//The array. If the array array obtained is null, 1- is returned
		public static int getMult(int[] arr) {
			if(arr == null) {
				return Integer.MAX_VALUE;}
			if (arr.length==0) {
				return Integer.MAX_VALUE;}
			int sum=1;
			for(int i = 0; i < arr.length; i++) {
			sum *= arr[i];}
			return sum;
		}
		
//getReverse method that receives an array of integers and returns a new array with them
//Organs in reverse order. If the resulting array array is null, null will be returned
		public static int[] getReverse(int[] arr) {
			if(arr == null) {
				return null;}
			int[] new_array =new int[arr.length];
          if(arr.length==0) {
          	return new_array;}
    
          int counter=0;
          
          for (int i =  new_array.length-1; i >=0; i--) {
          	 new_array[counter]=arr[i];
                  counter++;
          }
          return new_array;
  }
			
		       
			
		    
//reverse method that accepts an array named arr of integer numbers and changes the same as the next
//Running the method it will contain the same organs in reverse order. If the array array obtained
//Is null, null will be returned
		    public static void reverse(int[] arr) {
		    	if(arr == null) {
					return;}
		    	
				int a = 0;
			    int long_array = arr.length - 1;
			    int tmp;
			    while (long_array > a) {
			        tmp = arr[long_array ];
			        arr[long_array ] = arr[a];
			        arr[a] = tmp;
			        long_array --;
			        a++;
		    			    }}
			
//findMax method that receives an array named arr, an integer array of integers, 
//and looks for the maximum number that appears in arr The function returns a one-dimensional 	    
//array with two members indicating the position where the maximum number is If the resulting array array is null, null will be returned
		    public static int[] findMax (int[][] arr) {
		    	 if(arr==null){
		    			return null;}
		    			    
		    	 if(arr.length==0) {
		    	         return null;}
		    	 int row_of_max = 0;
		    	 int column_of_max = 0;
		         int max = 0;
		    	 for (int current_row=0;current_row < arr.length; current_row++) {
		       	 for (int current_col=0;current_col < arr[current_row].length; current_col++) {
		    	 if (arr[current_row][current_col]>max) { 
		    	     row_of_max = current_row;
		    	     column_of_max = current_col;
		    	     max = arr[current_row][current_col];}}
		    	                		}
		    	        		
		    	                 
		    	     int []new_array = {row_of_max,column_of_max};     
		    		return new_array;
		    	        }
//sumTables method  which receives two two-dimensional arrays and returns a new two-dimensional array which is their sum
//If one of the parameters is null, or the arrays do not have the same dimensions, return null
		    public static int[][] sumTables(int[][] table1, int[][] table2){
		    	if(table1==null || table2==null) {
		    		return null;}
		    	
              if(table1.length !=table2.length) {
              	return null;}
              
             
              int[][] new_array = new int[table1.length][table1[0].length];
              
              for(int i = 0 ; i < table1.length ; i ++) {
            	  for(int k = 0 ; k < table1[0].length ; k ++) {
            		  new_array[i][k] = table1[i][k] + table2[i][k];
            	  }
              }
                     
              
              return new_array;
              
		    }
              
		    	
		
	}
	
