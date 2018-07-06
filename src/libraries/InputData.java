package libraries;
import java.util.*;
public class InputData 
{
	  private static Scanner Reader = newScanner();
	  
	  private final static String ERRORE_FORMATO = "Wait: the input data is not in the right format";
	  private final static String ERRORE_MINIMO= "Wait: it is required a value greater equal to ";
	  private final static String ERRORE_STRINGA_VUOTA= "Wait: you must insert a character";
	  private final static String ERRORE_MASSIMO= "Wait: it is requied a value less equal to ";
	  private final static String MESSAGGIO_AMMISSIBILI= "Wait: allowable characters are: ";

	  private final static char RISPOSTA_SI='Y';
	  private final static char RISPOSTA_NO='N';

	  
 
	  private static Scanner newScanner ()
	  {
	   Scanner scan = new Scanner(System.in);
	   scan.useDelimiter(System.getProperty("line.separator"));
	   return scan;
	  }
	  
	  public static String readString (String message)
	  {
		  System.out.print(message);
		  return Reader.next();
	  }
	  
	  public static String readNotEmptyString(String message)
	  {
	   boolean end = false;
	   String lettura = null;
	   do
	   {
		 lettura = readString(message);
		 lettura = lettura.trim();
		 if (lettura.length() > 0)
		  end=true;
		 else
		  System.out.println(ERRORE_STRINGA_VUOTA);
	   } while (!end);
	   
	   return lettura;
	  }
	  
	  public static char readChar (String message)
	  {
	   boolean finito = false;
	   char valoreLetto = '\0';
	   do
	    {
	     System.out.print(message);
	     String lettura = Reader.next();
	     if (lettura.length() > 0)
	      {
	       valoreLetto = lettura.charAt(0);
	       finito = true;
	      }
	     else
	      {
	       System.out.println(ERRORE_STRINGA_VUOTA);
	      }
	    } while (!finito);
	   return valoreLetto;
	  }
	  
	  public static char readUpperChar (String messaggio, String allowable)
	  {
	   boolean finito = false;
	   char valoreLetto = '\0';
	   do
	   {
	    valoreLetto = readChar(messaggio);
	    valoreLetto = Character.toUpperCase(valoreLetto);
	    if (allowable.indexOf(valoreLetto) != -1)
		 finito  = true;
	    else
	     System.out.println(MESSAGGIO_AMMISSIBILI + allowable);
	   } while (!finito);
	   return valoreLetto;
	  }
	  
	  
	  public static int readInteger (String message)
	  {
	   boolean finito = false;
	   int valoreLetto = 0;
	   do
	    {
	     System.out.print(message);
	     try
	      {
	       valoreLetto = Reader.nextInt();
	       finito = true;
	      }
	     catch (InputMismatchException e)
	      {
	       System.out.println(ERRORE_FORMATO);
	       String daButtare = Reader.next();
	      }
	    } while (!finito);
	   return valoreLetto;
	  }

	  public static int readPositiveInteger(String messaggio)
	  {
		  return readIntegerGreaterEqualThan(messaggio,1);
	  }
	  
	  public static int readNotNegativeInteger(String messaggio)
	  {
		  return readIntegerGreaterEqualThan(messaggio,0);
	  }
	  
	  
	  public static int readIntegerGreaterEqualThan(String message, int minimum)
	  {
	   boolean finito = false;
	   int valoreLetto = 0;
	   do
	    {
	     valoreLetto = readInteger(message);
	     if (valoreLetto >= minimum)
	      finito = true;
	     else
	      System.out.println(ERRORE_MINIMO + minimum);
	    } while (!finito);
	     
	   return valoreLetto;
	  }

	  public static int readInteger(String message, int minimum, int maximum)
	  {
	   boolean finito = false;
	   int valoreLetto = 0;
	   do
	    {
	     valoreLetto = readInteger(message);
	     if (valoreLetto >= minimum && valoreLetto<= maximum)
	      finito = true;
	     else
	      if (valoreLetto < minimum)
	         System.out.println(ERRORE_MINIMO + minimum);
	      else
	    	 System.out.println(ERRORE_MASSIMO + maximum); 
	    } while (!finito);
	     
	   return valoreLetto;
	  }

	  
	  public static double readDouble (String message)
	  {
	   boolean finito = false;
	   double valoreLetto = 0;
	   do
	    {
	     System.out.print(message);
	     try
	      {
	       valoreLetto = Reader.nextDouble();
	       finito = true;
	      }
	     catch (InputMismatchException e)
	      {
	       System.out.println(ERRORE_FORMATO);
	       String daButtare = Reader.next();
	      }
	    } while (!finito);
	   return valoreLetto;
	  }
	 
	  public static double readDoubleGraterEqualThan (String message, double minimum)
	  {
	   boolean finito = false;
	   double valoreLetto = 0;
	   do
	    {
	     valoreLetto = readDouble(message);
	     if (valoreLetto >= minimum)
	      finito = true;
	     else
	      System.out.println(ERRORE_MINIMO + minimum);
	    } while (!finito);
	     
	   return valoreLetto;
	  }

	  
	  public static boolean yesOrNo(String message)
	  {
		  String mioMessaggio = message + "("+RISPOSTA_SI+"/"+RISPOSTA_NO+")";
		  char valoreLetto = readUpperChar(mioMessaggio,String.valueOf(RISPOSTA_SI)+String.valueOf(RISPOSTA_NO));
		  
		  if (valoreLetto == RISPOSTA_SI)
			return true;
		  else
			return false;
	  }

}
