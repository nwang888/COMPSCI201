
/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author N Wang
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		for (int i = 0; i < size ; i++)
			myWords[i] = source[i+start];
		myToString = this.toString();
		myHash = this.hashCode();
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Returns how many strings are contained within myWords
	 * @return the length of the myWords array
	 */
	public int length(){
		return myWords.length;
	}


	/**
	 * Returns whether the strings within each object are equivalent
	 * @param other an Object to be compared
	 * @return true if the Object is a WordGram and has an equivalent myString; otherwise,
	 * 		   false
	 */
	@Override
	public boolean equals(Object other) {
		if (! (other instanceof WordGram) || other == null){
			return false;
		}
		WordGram word = (WordGram) other;
		return this.toString().equals(word.toString());
	}

	@Override
	public int hashCode(){
		if (myHash == 0)
			myHash = myToString.hashCode();
		return myHash;
	}

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return
	 */
	public WordGram shiftAdd(String last) {
		String[] stor = new String[myWords.length+1];
		for (int i = 0 ; i < myWords.length; i++){
			stor[i] = myWords[i];
		}
		stor[myWords.length] = last;

		WordGram wg = new WordGram(stor,1,myWords.length);
		return wg;
	}

	@Override
	public String toString(){
		if (myToString == null)
			myToString = String.join(" ", myWords);
		return myToString;
	}
}
