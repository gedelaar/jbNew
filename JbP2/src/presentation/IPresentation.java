package presentation;

import java.util.List;

import slideFactory.SlideAbstractFactory;

public interface IPresentation {
	
	
	IPresentation load();

	void save();

	List<SlideAbstractFactory> open();
	
	

}