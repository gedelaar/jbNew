package presentation;

import java.util.ArrayList;
import java.util.List;

import slideFactory.SlideAbstractFactory;

public interface Presentation {
	
	
	Presentation load();

	void save();

	set<SlideAbstractFactory> open();
	
	

}