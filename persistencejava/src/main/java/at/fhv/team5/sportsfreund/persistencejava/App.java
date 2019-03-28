package at.fhv.team5.sportsfreund.persistencejava;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import at.fhv.team5.sportsfreund.persistencejava.entities.Actor;
import at.fhv.team5.sportsfreund.persistencejava.facade.Facade;


public class App 
{

    public static void main( String[] args ) {
    	Facade facade = new Facade();
    	
//    	Actor actor = new Actor("Orlando", "Bloom");
//    	facade.saveEntity(actor);
    	
    	ArrayList<Actor> actors = (ArrayList<Actor>) facade.loadAllActors();
    	
    	for(Actor act: facade.loadAllActors()) {
    		System.out.println(act.getfName());
    	}
    	
    	
    	//TODO save and load
    	
    }
}
