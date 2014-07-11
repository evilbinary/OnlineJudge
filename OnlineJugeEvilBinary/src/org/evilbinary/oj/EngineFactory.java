package org.evilbinary.oj;

public class EngineFactory implements IEngineFactory{

	public IEngine createEngine() {
		return new JavaEngine();
	}
	public static Engine createEngine(String engineName){
		if("Java".equals(engineName)){
			return new JavaEngine();
		}else if("C".equals(engineName)){
			return new CEngine();
		}else if("C++".equals(engineName)){
			return new CppEngine();
		}else{
			System.out.println("No engine!");
			return null;
		}
	}
	
}
