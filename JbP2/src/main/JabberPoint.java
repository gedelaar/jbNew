package main;

import java.util.Set;

import presentation.Presentation;
import presentation.SlideShow;
import slideFactory.SlideAbstractFactory;

public class JabberPoint {

	public static void main(String[] args) {
		Presentation presentation = new SlideShow();
		presentation.load();
 
		System.out.println((Set<SlideAbstractFactory>) presentation.open());
		
		System.out.println("hello");
		
	}

}
