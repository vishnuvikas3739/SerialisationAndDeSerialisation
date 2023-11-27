package Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Developer implements Serializable{
	int number;
	String name;
	Developer(int number,String name)
	{
		this.number=number;
		this.name=name;
	}
}
public class SerializeDemo {
public static void main(String args[])
{
	Developer d=new Developer(134,"VishnuVikas");
	
	// code for Serialization.
	try {
		//to convert the object into byteStream we are going to save the object in a file
		FileOutputStream fout=new FileOutputStream("vishnuvikas.txt");
		//To use the serialization we need class name called as ObjectOutputStream
		ObjectOutputStream out=new ObjectOutputStream(fout);
		//We need to use writeObject() method
		out.writeObject(d);
		out.close();
	    fout.close();
	    System.out.println("Successfully Compiled");
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	//code for Deserialisation.
	try {
		FileInputStream fin=new FileInputStream("vishnuvikas.txt");
		ObjectInputStream in=new ObjectInputStream(fin);
		Developer de=(Developer)in.readObject();
		in.close();
		fin.close();
		System.out.println(de.number+" "+de.name);
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
}
}
