package libraries;

import java.util.ArrayList;

/*
Questa classe rappresenta un menu testuale generico a piu' voci
Si suppone che la voce per uscire sia sempre associata alla scelta 0 
e sia presentata in fondo al menu

*/
public class MyMenu
{
  final private static String FRAME = "--------------------------------------------";
  final private static String EXIT_VOICE = "0\tExit";
  final private static String INPUT_REQUEST = "Insert the number of the chosen option > ";

  private String title;
  private ArrayList<String> voices;
  private int length;
  
  public MyMenu (String titolo, ArrayList<String> voci)
  {
	this.title = titolo;
	this.voices = voci;
	this.length = voci.size();
  }
  
  public int choose ()
  {
	  
	printMenu();
	return InputData.readInteger(INPUT_REQUEST, 0, length);	 
  }
  
  public int chooseWithNoExitOption ()
  {
	printLightMenu();
	return InputData.readInteger(INPUT_REQUEST, 0, length);	 
  }
		
  public void printMenu ()
  {
	printFrame();
	System.out.println();
	System.out.println(title);
	printFrame();
	System.out.println();
    for (int i=0; i<length; i++)
	 {
	  System.out.println( (i+1) + "\t" + voices.get(i));
	 }
    System.out.println();
	System.out.println(EXIT_VOICE);
    System.out.println();
  }
  
  public void printLightMenu ()
  {
	System.out.println(title);
    for (int i=0; i<length; i++)
	 {
	  System.out.println( (i+1) + "\t" + voices.get(i));
	 }
    System.out.println();
  }

  public void printFrame() {
	  for(int i = 0; i < length; i++)
		  System.out.print("-");
  }
}
