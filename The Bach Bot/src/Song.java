import java.util.ArrayList;

public class Song 
{
	ArrayList<String> keySignatureArray;
	ArrayList<ArrayList<String>> keys; //moved out of chooseKeySignature()
	ArrayList<String> currentKey;
	String key;
	int beatsPerMeasure;
	int numberOfMeasures;
	int totalBeats;
	
	ArrayList<String> chordProgression;
	ArrayList<String> bassRange;
	ArrayList<String> sopranoRange;
	ArrayList<String> altoRange;
	ArrayList<String> tenorRange;
	ArrayList<ArrayList<String>> bassVoice;
	ArrayList<ArrayList<String>> sopranoVoice;
	ArrayList<ArrayList<String>> altoVoice;
	ArrayList<ArrayList<String>> tenorVoice;
	
	public Song() //constructor for song
	{
		keys = new ArrayList<ArrayList<String>>();//required to compile
		fillKeysArray();
		currentKey = keys.get((int) (Math.random()*keys.size()));
		key = currentKey.get(0);
		beatsPerMeasure = chooseBeatsPerMeasure();
		numberOfMeasures = chooseNumberOfMeasures();
		totalBeats = beatsPerMeasure * numberOfMeasures;
		
		//chordProgression = generateInitialChordProgression(); 
		bassRange = findBassRange();
		sopranoRange = findSopranoRange();
		tenorRange = findTenorRange();
		altoRange = findAltoRange();
		//bassVoice = generateBassVoice(); //ArrayList of measure; measure contains individual notes 
		//sopranoVoice = generateSopranoVoice();
		//altoVoice = generateAltoVoice();
		//tenorVoice = generateTenorVoice();
	}
	public Song(int keysig, int bpm, int measures) //same as no-args constructor, except all song info is represented by integers (i.e. 0 = cmajor, 1 = gmajor, etc.)
	{
		fillKeysArray();
		currentKey = keys.get(keysig);
		key = currentKey.get(0);
		beatsPerMeasure = chooseBeatsPerMeasure();
		numberOfMeasures = chooseNumberOfMeasures();
		totalBeats = beatsPerMeasure * numberOfMeasures;
		bassRange = findBassRange();
		sopranoRange = findSopranoRange();
		tenorRange = findTenorRange();
		altoRange = findAltoRange();
		
		chordProgression = generateInitialChordProgression(); 
		//bassVoice = generateBassVoice(); //ArrayList of measure; measure contains individual notes 
		//sopranoVoice = generateSopranoVoice();
		//altoVoice = generateAltoVoice();
		//tenorVoice = generateTenorVoice();  
	}
	public int chooseBeatsPerMeasure() //returns 2,3, or 4
	{
		return 2;
	}
	public int chooseNumberOfMeasures() //returns int as number of measures; probably a multiple of 4
	{
		return 16;
	}
	public void fillKeysArray() //made void from ArrayList<String>
	{
		ArrayList<String> cMajor = new ArrayList<String>(); 
		cMajor.add("cMajor"); cMajor.add("C"); cMajor.add("D"); cMajor.add("E"); cMajor.add("F"); cMajor.add("G"); cMajor.add("A"); cMajor.add("B"); 
		ArrayList<String> gMajor = new ArrayList<String>();
		gMajor.add("gMajor"); gMajor.add("G"); gMajor.add("A"); gMajor.add("B"); gMajor.add("C"); gMajor.add("D"); gMajor.add("E"); gMajor.add("F#"); 
		ArrayList<String> dMajor = new ArrayList<String>();
		dMajor.add("dMajor");dMajor.add("D");dMajor.add("E");dMajor.add("F#");dMajor.add("G");dMajor.add("A");dMajor.add("B");dMajor.add("C#");
		ArrayList<String> aMajor = new ArrayList<String>();
		aMajor.add("aMajor");aMajor.add("A");aMajor.add("B");aMajor.add("C#");aMajor.add("D");aMajor.add("E");aMajor.add("F#");aMajor.add("G#");
		ArrayList<String> eMajor = new ArrayList<String>();
		eMajor.add("eMajor");eMajor.add("E");eMajor.add("F#");eMajor.add("G#");eMajor.add("A");eMajor.add("B");eMajor.add("C#");eMajor.add("D#");
		ArrayList<String> bMajor = new ArrayList<String>();
		bMajor.add("bMajor");bMajor.add("B");bMajor.add("C#");bMajor.add("D#");bMajor.add("E");bMajor.add("F#");bMajor.add("G#");bMajor.add("A#");
		ArrayList<String> fSharpMajor = new ArrayList<String>();
		fSharpMajor.add("fSharpMajor");fSharpMajor.add("F#");fSharpMajor.add("G#");fSharpMajor.add("A#");fSharpMajor.add("B");fSharpMajor.add("C#");fSharpMajor.add("D#");fSharpMajor.add("E#");
		ArrayList<String> cSharpMajor = new ArrayList<String>();
		cSharpMajor.add("cSharpMajor");cSharpMajor.add("C#");cSharpMajor.add("D#");cSharpMajor.add("E#");cSharpMajor.add("F#");cSharpMajor.add("G#");cSharpMajor.add("A#");cSharpMajor.add("B");
		ArrayList<String> fMajor = new ArrayList<String>();
		fMajor.add("fMajor");fMajor.add("F");fMajor.add("G");fMajor.add("A");fMajor.add("Bb");fMajor.add("C");fMajor.add("D");fMajor.add("E");
		ArrayList<String> bFlatMajor = new ArrayList<String>();
		bFlatMajor.add("bFlatMajor");bFlatMajor.add("Bb");bFlatMajor.add("C");bFlatMajor.add("D");bFlatMajor.add("Eb");bFlatMajor.add("F");bFlatMajor.add("G");bFlatMajor.add("A");
		ArrayList<String> eFlatMajor = new ArrayList<String>();
		eFlatMajor.add("eFlatMajor");eFlatMajor.add("Eb");eFlatMajor.add("F");eFlatMajor.add("G");eFlatMajor.add("Ab");eFlatMajor.add("Bb");eFlatMajor.add("C");eFlatMajor.add("D");
		ArrayList<String> aFlatMajor = new ArrayList<String>();
		aFlatMajor.add("aFlatMajor");aFlatMajor.add("Ab");aFlatMajor.add("Bb");aFlatMajor.add("C");aFlatMajor.add("Db");aFlatMajor.add("Eb");aFlatMajor.add("F");aFlatMajor.add("G");
		ArrayList<String> dFlatMajor = new ArrayList<String>();
		dFlatMajor.add("dFlatMajor");dFlatMajor.add("Db");dFlatMajor.add("Eb");dFlatMajor.add("F");dFlatMajor.add("Gb");dFlatMajor.add("Ab");dFlatMajor.add("Bb");dFlatMajor.add("C");
		ArrayList<String> gFlatMajor = new ArrayList<String>();
		gFlatMajor.add("gFlatMajor");gFlatMajor.add("Gb");gFlatMajor.add("Ab");gFlatMajor.add("Bb");gFlatMajor.add("Cb");gFlatMajor.add("Db");gFlatMajor.add("Eb");gFlatMajor.add("F");
		ArrayList<String> cFlatMajor = new ArrayList<String>();
		cFlatMajor.add("cFlatMajor");cFlatMajor.add("Cb");cFlatMajor.add("Db");cFlatMajor.add("Eb");cFlatMajor.add("Fb");cFlatMajor.add("Gb");cFlatMajor.add("Ab");cFlatMajor.add("Bb");
		
		keys.add(cMajor); keys.add(gMajor); keys.add(dMajor);keys.add(aMajor);keys.add(eMajor);keys.add(bMajor);keys.add(fSharpMajor);keys.add(cSharpMajor);
		keys.add(fMajor);keys.add(bFlatMajor);keys.add(eFlatMajor);keys.add(aFlatMajor);keys.add(dFlatMajor);keys.add(gFlatMajor); keys.add(cFlatMajor);
        
	}
	public ArrayList<String> generateInitialChordProgression() //generates chordProgression with no inversion
	{
		ArrayList<String> tempChordProgression = new ArrayList<String>();
		tempChordProgression.add("ERROR");
		
		
		
		
		return tempChordProgression;
	}
	
	public ArrayList<String> findBassRange()
	{
		ArrayList<String> bassNoteRange = new ArrayList<String>(14); //Range of E2 to C4
		bassNoteRange.add("ERROR");
		int lowNoteIndex = 0; int highNoteIndex = 0;
		for(int i = 1; i < currentKey.size(); i++) //finds index of F (lowest bass) and C highest bass
		{
			String currentNote = currentKey.get(i);
			if(currentNote.contains("E"))
			{
				lowNoteIndex = i;
			}
			else if(currentNote.contains("C"))
			{
				highNoteIndex = i;
			}
		}
		int currentKeyIndex = lowNoteIndex;
		while(!(currentKey.get(currentKeyIndex).contains("C"))) //adds E2 --> B2
		{
			bassNoteRange.add(currentKey.get(currentKeyIndex) + "2");
			if(currentKeyIndex < 7)
			{
				currentKeyIndex++;
			}
			else
			{
				currentKeyIndex = 1; 
			}
		}
		bassNoteRange.add(currentKey.get(currentKeyIndex) + "3"); //adds C3 or C#3
		currentKeyIndex++;
		if(currentKeyIndex > 7)
		{
			currentKeyIndex = 1;
		}
		while(!currentKey.get(currentKeyIndex).contains("C"))
		{
			bassNoteRange.add(currentKey.get(currentKeyIndex) + "3");
			if(currentKeyIndex < 7)
			{
				currentKeyIndex++;
			}
			else
			{
				currentKeyIndex = 1; 
			}
		}
		bassNoteRange.add(currentKey.get(currentKeyIndex) + "4"); //adds C4
		return bassNoteRange;
	}
	public ArrayList<String> findSopranoRange()
	{
		ArrayList<String> sopranoNoteRange = new ArrayList<String>(14); //Range of C4 to A5
		sopranoNoteRange.add("ERROR");
		int lowNoteIndex = 0; int highNoteIndex = 0;
		for(int i = 1; i < currentKey.size(); i++) //finds index of F (lowest bass) and C highest bass
		{
			String currentNote = currentKey.get(i);
			if(currentNote.contains("B"))
			{
				lowNoteIndex = i;
			}
			else if(currentNote.contains("A"))
			{
				highNoteIndex = i;
			}
		}
		int currentKeyIndex = lowNoteIndex;
		while(!(currentKey.get(currentKeyIndex).contains("C"))) //adds B3
		{
			sopranoNoteRange.add(currentKey.get(currentKeyIndex) + "3");
			if(currentKeyIndex < 7)
			{
				currentKeyIndex++;
			}
			else
			{
				currentKeyIndex = 1; 
			}
		}
		sopranoNoteRange.add(currentKey.get(currentKeyIndex) + "4"); //adds C4 or C#4
		currentKeyIndex++;
		if(currentKeyIndex > 7)
		{
			currentKeyIndex = 1;
			
		}
		while(!(currentKey.get(currentKeyIndex).contains("C"))) //D4-B4
		{
			sopranoNoteRange.add(currentKey.get(currentKeyIndex) + "4");
			if(currentKeyIndex < 7)
			{
				currentKeyIndex++;
			}
			else
			{
				currentKeyIndex = 1; 
			}
		}
		if(currentKeyIndex > 7)
		{
			currentKeyIndex = 1;
		}
		sopranoNoteRange.add(currentKey.get(currentKeyIndex) + "5");
		currentKeyIndex++;
		if(currentKeyIndex > 7)
		{
			currentKeyIndex = 1;
		}
		while(!currentKey.get(currentKeyIndex).contains("B")) //D5 --> A5
		{
			sopranoNoteRange.add(currentKey.get(currentKeyIndex) + "5");
			if(currentKeyIndex < 7)
			{
				currentKeyIndex++;
			}
			else
			{
				currentKeyIndex = 1; 
			}
		}
		return sopranoNoteRange;
	}
	public ArrayList<String> findTenorRange()
	{
		ArrayList<String> tenorNoteRange = new ArrayList<String>(14); //Range of C3 to A4
		tenorNoteRange.add("ERROR");
		int lowNoteIndex = 0; int highNoteIndex = 0;
		for(int i = 1; i < currentKey.size(); i++) //finds index of C (lowest bass) and G highest bass
		{
			String currentNote = currentKey.get(i);
			if(currentNote.contains("C"))
			{
				lowNoteIndex = i;
			}
			else if(currentNote.contains("G"))
			{
				highNoteIndex = i;
			}
		}
		int currentKeyIndex = lowNoteIndex;
		tenorNoteRange.add(currentKey.get(currentKeyIndex) + "3");
		currentKeyIndex++;
		if(currentKeyIndex > 7)
		{
			currentKeyIndex = 1; 
		}
		while(!(currentKey.get(currentKeyIndex).contains("C"))) //adds D3-B3
		{
			tenorNoteRange.add(currentKey.get(currentKeyIndex) + "3");
			if(currentKeyIndex < 7)
			{
				currentKeyIndex++;
			}
			else
			{
				currentKeyIndex = 1; 
			}
		}
		tenorNoteRange.add(currentKey.get(currentKeyIndex) + "4"); //adds C3 or C#3
		currentKeyIndex++;
		if(currentKeyIndex > 7)
		{
			currentKeyIndex = 1;
		}
		while(!currentKey.get(currentKeyIndex).contains("B")) //up to B4
		{
			tenorNoteRange.add(currentKey.get(currentKeyIndex) + "4");
			if(currentKeyIndex < 7)
			{
				currentKeyIndex++;
			}
			else
			{
				currentKeyIndex = 1; 
			}
		}
		return tenorNoteRange;
	}
	public ArrayList<String> findAltoRange()
	{
		ArrayList<String> altoNoteRange = new ArrayList<String>(14); //Range of F3 to D4
		altoNoteRange.add("ERROR");
		int lowNoteIndex = 0; int highNoteIndex = 0;
		for(int i = 1; i < currentKey.size(); i++) //finds index of F (lowest bass) and C highest bass
		{
			String currentNote = currentKey.get(i);
			if(currentNote.contains("F"))
			{
				lowNoteIndex = i;
			}
			else if(currentNote.contains("C"))
			{
				highNoteIndex = i;
			}
		}
		int currentKeyIndex = lowNoteIndex;
		while(!(currentKey.get(currentKeyIndex).contains("C"))) 
		{
			altoNoteRange.add(currentKey.get(currentKeyIndex) + "3");
			if(currentKeyIndex < 7)
			{
				currentKeyIndex++;
			}
			else
			{
				currentKeyIndex = 1; 
			}
		}
		altoNoteRange.add(currentKey.get(currentKeyIndex) + "4"); //adds C3 or C#3
		currentKeyIndex++;
		if(currentKeyIndex > 7)
		{
			currentKeyIndex = 1;
		}
		while(!currentKey.get(currentKeyIndex).contains("C"))
		{
			altoNoteRange.add(currentKey.get(currentKeyIndex) + "4");
			if(currentKeyIndex < 7)
			{
				currentKeyIndex++;
			}
			else
			{
				currentKeyIndex = 1; 
			}
		}
		while(!currentKey.get(currentKeyIndex).contains("E"))
		{
			altoNoteRange.add(currentKey.get(currentKeyIndex) + "5");
			if(currentKeyIndex < 7)
			{
				currentKeyIndex++;
			}
			else
			{
				currentKeyIndex = 1; 
			}
		}
		return altoNoteRange;
	}
	//public ArrayList<ArrayList<String>> generateBassVoice()
	{
		
	}
	//public void optimizeBass()
	{
		
	}
	//public ArrayList<ArrayList<String>> generateSopranoVoice()
	{
		
	}
	//public void optimizeSoprano()
	{
		
	}
	//public ArrayList<ArrayList<String>> generateAltoVoice()
	{
		
	}
	//public void optimizeAlto()
	{
		
	}
	//public ArrayList<ArrayList<String>> generateTenorVoice()
	{
		
	}
	//public void optimizeTenor()
	{
		
	}
}

