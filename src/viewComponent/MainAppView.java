package viewComponent;

import java.awt.Color;

import com.teamdev.jxbrowser.chromium.Browser;

public interface MainAppView {
	public void setOriginLocation(String location);
	
	public void setDestinationLocation(String location);
	
	public String getOriginAddress();
	
	public Browser getBrowser();
	
	public void setTrainStationName(String location);
	
	public void setLegendOne(Color color, String text);
	
	public void setLegendTwo(Color color, String text);
	
	public void setLegendThree(Color color, String text);
	
	public void setLegendFour(Color color, String text);

}
