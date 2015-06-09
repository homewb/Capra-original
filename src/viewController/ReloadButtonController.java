package viewController;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.teamdev.jxbrowser.chromium.Browser;

import routePlannerModel.RouteModel;
import viewComponent.MainAppView;

public class ReloadButtonController implements ActionListener {
	private RouteModel model;
	private MainAppView view;
	
	public ReloadButtonController(RouteModel model, MainAppView view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Browser browser = view.getBrowser();
		
		browser.loadURL("file:///" + System.getProperty("user.dir") + "/map.html");
//		browser.loadURL("file:///C:/Users/Bo%20Wang/workspace/Capra%20v1.0/map.html");
		
		view.setLegendOne(new Color(255, 0, 0), "CAPRA (Normal)");
		view.setLegendTwo(new Color(255, 153, 0), "CAPRA (Without Contour)");
		view.setLegendThree(new Color(51, 153, 255), "Google");
		view.setLegendFour(new Color(51, 204, 51), "A* Distance");
		
	}

}
