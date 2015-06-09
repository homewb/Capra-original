package viewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;
import javax.xml.stream.XMLStreamException;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserFunction;
import com.teamdev.jxbrowser.chromium.JSValue;

import dataModel.LatLngException;
import dataModel.CapraPathNotFoundException;
import routePlannerModel.*;
import viewComponent.*;

public class SearchButtonController implements ActionListener {
	private RouteModel model;
	private MainAppView view;
	
	public SearchButtonController(RouteModel model, MainAppView view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String inputText_Origin = view.getOriginAddress();
		
		String name = model.getTrainStationName(inputText_Origin);
		String origin = model.getOriginLatLng();
		String destin = model.getDesinLatLng();
		
		view.setTrainStationName(name);
		view.setOriginLocation(origin);
		view.setDestinationLocation(destin);
		
//		String originLocation = 
//				model.getOriginCoordinate(inputText_Origin);
//		String destinLocation = 
//				model.getDestinationCoordinate(inputText_Destin);
//		
//		view.setOriginLocation(originLocation);	
//		view.setDestinationLocation(destinLocation);
		
		System.out.println("origin = " + origin + ", destin = " + destin);
		
		try {
			model.calcPath();
			
			Browser browser = view.getBrowser();
			
			// ======== Function registration starts ==============
			browser.registerFunction("getStartLat", new BrowserFunction() {
	            public JSValue invoke(JSValue... args) {
	                double stratLat = model.getStartLat();
	            	
	                return JSValue.create(stratLat);
	            }
	        });
	        
	        browser.registerFunction("getStartLng", new BrowserFunction() {
	            public JSValue invoke(JSValue... args) {
	            	double startLng = model.getStartLng();
	                
	                return JSValue.create(startLng);
	            }
	        });
	        
	        browser.registerFunction("getEndLat", new BrowserFunction() {
	            public JSValue invoke(JSValue... args) {
	            	double endLat = model.getEndLat();
	                
	                return JSValue.create(endLat);
	            }
	        });
	        
	        browser.registerFunction("getEndLng", new BrowserFunction() {
	            public JSValue invoke(JSValue... args) {
	            	double endLng = model.getEndLng();
	                
	                return JSValue.create(endLng);
	            }
	        });
	        
	        browser.registerFunction("getFirstLat", new BrowserFunction() {
	            public JSValue invoke(JSValue... args) {
	            	Double methodValue = new Double(args[0].getNumber());
	            	int method = methodValue.intValue();
	            	
	            	double lat = model.getFirstPathLat(method);
	                
	                return JSValue.create(lat);
	            }
	        });
	        
	        browser.registerFunction("getFirstLng", new BrowserFunction() {
	            public JSValue invoke(JSValue... args) {
	            	Double methodValue = new Double(args[0].getNumber());
	            	int method = methodValue.intValue();
	            	
	            	double lng = model.getFirstPathLng(method);
	                
	                return JSValue.create(lng);
	            }
	        });
	        
	        browser.registerFunction("getLat", new BrowserFunction() {
	            public JSValue invoke(JSValue... args) {
	            	Double value = new Double(args[0].getNumber());
	            	int index = value.intValue();
	            	
	            	Double methodValue = new Double(args[1].getNumber());
	            	int method = methodValue.intValue();
	            	
	            	double lat = model.getPathLat(index, method);
	                
	                return JSValue.create(lat);
	            }
	        });
	        
	        browser.registerFunction("getLng", new BrowserFunction() {
	            public JSValue invoke(JSValue... args) {
	            	Double value = new Double(args[0].getNumber());
	            	int index = value.intValue();
	            	
	            	Double methodValue = new Double(args[1].getNumber());
	            	int method = methodValue.intValue();
	            	
	            	double lng = model.getPathLng(index, method);
	                
	                return JSValue.create(lng);
	            }
	        });
	        
	        browser.registerFunction("getPathSize", new BrowserFunction() {
	            public JSValue invoke(JSValue... args) {
	            	Double methodValue = new Double(args[0].getNumber());
	            	int method = methodValue.intValue();
	            	
	            	int size = model.getPathSize(method);
	            	
	                return JSValue.create(size);
	            }
	        });
	        
	        browser.registerFunction("getMoaFirstLat", new BrowserFunction() {
	            public JSValue invoke(JSValue... args) {
	            	Double pathIndexValue = new Double(args[0].getNumber());
	            	int pathIndex = pathIndexValue.intValue();
	            	
	            	double lat = model.getMoaFirstPathLat(pathIndex);
	                
	                return JSValue.create(lat);
	            }
	        });
	        
	        browser.registerFunction("getMoaFirstLng", new BrowserFunction() {
	            public JSValue invoke(JSValue... args) {
	            	Double pathIndexValue = new Double(args[0].getNumber());
	            	int pathIndex = pathIndexValue.intValue();
	            	
	            	double lng = model.getMoaFirstPathLng(pathIndex);
	                
	                return JSValue.create(lng);
	            }
	        });
	        
	        browser.registerFunction("getMoaLat", new BrowserFunction() {
	            public JSValue invoke(JSValue... args) {
	            	Double stepIndexValue = new Double(args[0].getNumber());
	            	int stepIndex = stepIndexValue.intValue();
	            	
	            	Double pathIndexValue = new Double(args[1].getNumber());
	            	int pathIndex = pathIndexValue.intValue();
	            	
	            	double lat = model.getMoaPathLat(stepIndex, pathIndex);
	                
	                return JSValue.create(lat);
	            }
	        });
	        
	        browser.registerFunction("getMoaLng", new BrowserFunction() {
	            public JSValue invoke(JSValue... args) {
	            	Double stepIndexValue = new Double(args[0].getNumber());
	            	int stepIndex = stepIndexValue.intValue();
	            	
	            	Double pathIndexValue = new Double(args[1].getNumber());
	            	int pathIndex = pathIndexValue.intValue();
	            	
	            	double lng = model.getMoaPathLng(stepIndex, pathIndex);
	                
	                return JSValue.create(lng);
	            }
	        });
	        
	        browser.registerFunction("getMoaPathSize", new BrowserFunction() {
	            public JSValue invoke(JSValue... args) {
	            	Double pathIndexValue = new Double(args[0].getNumber());
	            	int pathIndex = pathIndexValue.intValue();
	            	
	            	int size = model.getMoaPathSize(pathIndex);
	            	
	                return JSValue.create(size);
	            }
	        });
	        
	        browser.registerFunction("getMoaSize", new BrowserFunction() {
	            public JSValue invoke(JSValue... args) {
	            	int size = model.getMoaSize();
	                
	                return JSValue.create(size);
	            }
	        });
	        // ======== Function registration ends ==============
	        
//	        browser.loadURL("file:///C:/Users/Bo%20Wang/"
//	        		+ "workspace/Capra%20v1.0/map.html");
	        browser.loadURL("file:///" + System.getProperty("user.dir") + "/map.html");
			
		} catch (FileNotFoundException | XMLStreamException | LatLngException
				| CapraPathNotFoundException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), 
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
