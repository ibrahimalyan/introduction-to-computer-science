//ibrahim alyan
//322675356
public class LimitedSentence {
//fields
	private String sentence;
	private char delimiter;
	
//LimitedSentence constructor empty
  public LimitedSentence() {
	    this.sentence="";
	    this.delimiter='_';

}
//LimitedSentence constructor receives a character separates and initializes the sentence to be an empty string.
//If the character is not Legitimate, we will initialize the separator to be a empty
  public LimitedSentence(char delimiter) {
  	 this.sentence="";
  	 if (is_en_char( delimiter )){
  		 this.delimiter='_';
  	 }
  	 else {
  		 this.delimiter=delimiter;	 
  	 }   		
}

//LimitedSentence copy constructor    
  public LimitedSentence(LimitedSentence other) {
	    this.sentence=other.sentence;
	    this.delimiter=other.delimiter;	
}
//getters
	public String getSentence() {
		return sentence;
	}

	public char getDelimiter() {
		return delimiter;
	}
  
//getFirstLette method  Returns the first character in the sentence
	public char getFirstLetter() {
		if(sentence !="") {
		char s=sentence.charAt(0);
		return s;}
		else {
			return 0;
		}
		
	}
	
//getMiddleLetter method Returns the middle character in a sentence for a pair-length sentence, or the character
//The first of the second half of the sentence (for a double-length sentence)
	public char getMiddleLetter() {
		if(sentence !="") {
		int sLength = sentence.length() ;

		int middle = sLength/2 ;

		char c = sentence.charAt(middle);
		return c;}
		else {
			return 0;
		}
	}
	
//getLastLetter method Returns the last character in the sentence
	public char getLastLetter() {
		if(sentence !="") {
		char last = sentence.charAt(sentence.length() -1);
		return last;}
		else {
			return 0;
		}
		
	}
	
//appendWordEnd method gets a word and tries to add it to the end of the sentence. The insertion is done
//Only if the word is validand only if the sentence obtained after the addition complies with the rules of the class
	public boolean appendWordEnd(String toAppend) {
		
		int sentence_length = sentence.length();
		
		int word_length = toAppend.length();
		
		if ( ( ( sentence_length + word_length + 1) > 25 ) ||  !Is_word_valid(toAppend) ) {
			return false;
		}
		
		if (sentence_length == 0) {
			sentence =  toAppend;
		}else {
			sentence = sentence + delimiter + toAppend;
		}
		
		return true;
			
		
	}
	
//appendWordFront method A method that gets a word and tries to add it to the beginning of the sentence. The addition is made
//Only if the word is valid and only if The sentence obtained after the addition complies with the rules of the department	
	public boolean appendWordFront(String toAppend) {
		
		
      int sentence_length = sentence.length();
      
		
		int word_length = toAppend.length();
		
		if ( ( ( sentence_length + word_length + 1) > 25 ) ||  !Is_word_valid(toAppend) ) {
			
			
			return false;
		}
		
		if (sentence_length == 0) {
			sentence =  toAppend;
		}else {
			sentence =  toAppend + delimiter + sentence ;
		}
		
		
		return true;
		
	}
	
//getIthWord method gets an index of a word and returns the word instead and
//If there is no word in the requested location, an empty string is returned
	public String getIthWord(int i) {
		
		int sentence_length = sentence.length();
		
		if( sentence_length == 0) {
			return "";
		}
		
		int word_count = countWords();
		
		if( i > word_count) {
			return "";
		}
		
		String[] words_arr = get_words_arr();
		
		return words_arr[i];
		
	}
	
//getIthWordReversed method gets a word index and returns the word instead, but vice versa and
//If there is no word in the requested location, an empty string is returned	
	public String getIthWordReversed(int i) {
		
		String word = getIthWord(i);
		
		if( word.length() == 0) {
			return "";
		}
		
		String new_word = "";
		
		for( int k = word.length()-1 ; k >= 0 ; k --) {
			
			new_word = new_word + word.charAt(k);
			
		}
      
		return new_word;
		
	}
	
//countWords method it will give us counts the number of words in a sentence and returns it.
	public int countWords() {
		 int count=0;  
       char char_arr[]= new char[ sentence.length()];     
       for(int i=0;i< sentence.length();i++) {
       
      	 char_arr[i]=  sentence.charAt(i);  
           if( ((i>0)&&(char_arr[i]!=delimiter)&&(char_arr[i-1]==delimiter)) || ((char_arr[0]!=delimiter)&&(i==0)) )  
               count++;  
       }  
       return count;  
	}
	
//reverseUpperLower method that changes the theorem that the object represents
	public void reverseUpperLower() {
		
      int sentence_length = sentence.length();
		
		if( sentence_length == 0) {
			return;
		}
		
		String new_sentence = "" ;
		
		for( int i = 0 ; i < sentence_length ; i ++ ) {
			
			char c = sentence.charAt(i);
			
			if( is_en_char(c) ) {
				
				if( is_capital(c) ) {
					
					new_sentence = new_sentence +  get_small_of(c);
					
				}else {
					new_sentence = new_sentence +  get_capital_of(c);
				}
				
			}else {
				new_sentence = new_sentence + c;
			}
			
		}
		
		sentence = new_sentence;
		
	}
	
//String toString method a special way will let us us print the object
	public String toString() {
		return sentence;
		
	}
	
	private boolean Is_word_valid( String word ) {
		
		for(int i = 0 ; i < word.length() ; i ++ ) {
			if( ! is_en_char( word.charAt(i)) ) {
				return false;
			}
		}
		
		return true;
		
	}
	
	private boolean is_en_char( char c ) {
		
		if ((c >='a' && c <='z') || (c >='A' && c <='Z')){
			return true;
		}
		return false;
	}
	
	private String[] get_words_arr() {
		
      int sentence_length = sentence.length();
		
		if( sentence_length == 0) {
			return new String[0];
		}
		
		int word_count = countWords();
	
		String[] words_arr = new String[word_count];
		
		int l = 0;
		
		for(int word_index = 0 ; word_index < word_count ; word_index ++ ) {
			
			String word = "";
			
			
			while( l < sentence_length  && sentence.charAt(l) != delimiter ) {
				
				word = word + sentence.charAt(l);
				
				l ++;
				
			}
			
			words_arr[word_index] = word;
			
			l ++;
			
		}
		
		return words_arr; 
		
	}
	
	private char get_small_of(char c) {
		final int DIFF = 32;
		if(c >= 'A' && c <= 'Z')
			c += DIFF;
		return c;

	}
	
	private char get_capital_of(char c) {
		final int DIFF = 32;
		if(c >= 'a' && c <= 'z')
			c -= DIFF;
		return c;

	}
	
	private boolean is_capital(char c) {
		if (c >='A' && c <='Z'){
			return true;
		}
		return false;
	}
		
		
		
		
		
		
		
		
		
				
				
				
	
		    
  
  
  
  
  
  
  
}