package datatypes;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.util.Scanner;

class WordNet {
	
	private Hashtable<String, Integer> ufSynsets;
	private Hashtable<Integer, String> synsetGloss;
	
	private void readSynsets(String synsets) throws IOException{
		
		Path path = Paths.get(synsets);
		Scanner scanner = new Scanner(path);
		
		String nextLine;
		String gloss;
		String nextLineSplit[], splitSyns[];	
		int synsetId;
		
		
		while(scanner.hasNextLine()){
			nextLine = scanner.nextLine();
			nextLineSplit = nextLine.split(",");
			splitSyns = nextLineSplit[1].split(" ");
			
			synsetId = Integer.parseInt(nextLineSplit[0]);
			gloss = nextLineSplit[nextLineSplit.length];
			
			for(String syn: splitSyns){
				
				System.out.println(syn+ " " + synsetId);
				ufSynsets.put(syn, synsetId);
			}
			
			System.out.println("....................." + synsetId+ " " + gloss);
			synsetGloss.put(synsetId, gloss);
		}
		scanner.close();
	}	
	
	private void readHypernyms(String hypernyms){
		//TODO: implement readHypernyms
	}
	
	// constructor takes the name of the two input files
	public WordNet(String synsets, String hypernyms) throws IOException{
		readSynsets(synsets);
		readHypernyms(hypernyms);		
	}

	// the set of nouns (no duplicates), returned as an Iterable
	public Iterable<String> nouns(){
		return null;
		
	}

	// is the word a WordNet noun?
	public boolean isNoun(String word){
		return false;
		
	}

	// distance between nounA and nounB (defined below)
	public int distance(String nounA, String nounB){
		return 0;
		
	}

	// a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
	// in a shortest ancestral path (defined below)
	public String sap(String nounA, String nounB){
		return nounB;
		
	}

	// for unit testing of this class
	public static void main(String[] args){
		
	}
}
