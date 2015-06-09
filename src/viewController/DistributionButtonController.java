package viewController;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserFunction;
import com.teamdev.jxbrowser.chromium.JSValue;

import routePlannerModel.RouteModel;
import viewComponent.MainAppView;

public class DistributionButtonController implements ActionListener {
	private RouteModel model;
	private MainAppView view;
	
	public DistributionButtonController(RouteModel model, MainAppView view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
        Browser browser = view.getBrowser();
        
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
        
        browser.registerFunction("getEdgeStartLat", new BrowserFunction() {
            public JSValue invoke(JSValue... args) {
            	Double value = new Double(args[0].getNumber());
            	int index = value.intValue();
                
            	double startLat = model.getEdgeStartLat(index);
            	
                return JSValue.create(startLat);
            }
        });
        
        browser.registerFunction("getEdgeStartLng", new BrowserFunction() {
            public JSValue invoke(JSValue... args) {
            	Double value = new Double(args[0].getNumber());
            	int index = value.intValue();
                
            	double startLng = model.getEdgeStartLng(index);
            	
                return JSValue.create(startLng);
            }
        });
        
        browser.registerFunction("getEdgeEndLat", new BrowserFunction() {
            public JSValue invoke(JSValue... args) {
            	Double value = new Double(args[0].getNumber());
            	int index = value.intValue();
                
            	double endLat = model.getEdgeEndLat(index);
            	
                return JSValue.create(endLat);
            }
        });
        
        browser.registerFunction("getEdgeEndLng", new BrowserFunction() {
            public JSValue invoke(JSValue... args) {
            	Double value = new Double(args[0].getNumber());
            	int index = value.intValue();
                
            	double endLng = model.getEdgeEndLng(index);
            	
                return JSValue.create(endLng);
            }
        });
        
        browser.registerFunction("getEdgeWeight", new BrowserFunction() {
            public JSValue invoke(JSValue... args) {
            	Double value = new Double(args[0].getNumber());
            	int index = value.intValue();
            	
            	int weight = model.getEdgeWeight(index);
                
                return JSValue.create(weight);
            }
        });
        
        browser.registerFunction("getEdgeSize", new BrowserFunction() {
            public JSValue invoke(JSValue... args) {
            	int size = model.getEdgeSize();
                
                return JSValue.create(size);
            }
        });
		
//		browser.loadURL("file:///C:/Users/Bo%20Wang/workspace"
//				+ "/Capra%20v1.0/Distribution.html");
		browser.loadURL("file:///" + System.getProperty("user.dir") + "/Distribution.html");
		
		view.setLegendOne(new Color(0, 204, 0), "Ideal");
		view.setLegendTwo(new Color(51, 153, 255), "Accessible");
		view.setLegendThree(new Color(255, 255, 0), "Below Accessible");
		view.setLegendFour(new Color(255, 0, 0), "Inaccessible");
		
	}

}
