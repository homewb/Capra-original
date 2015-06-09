package viewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import routePlannerModel.RouteModel;
import viewComponent.MainAppView;

public class GraphPathButtonController implements ActionListener {
	private RouteModel model;
	private MainAppView view;
	
	public GraphPathButtonController(RouteModel model, MainAppView view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String filename = "image.jpg";
		String mapImageUrl = model.getPathImageUrl();
		
		try {
			String destinationFile = filename;
			URL url = new URL(mapImageUrl);
			InputStream in = url.openStream();
			OutputStream os = new FileOutputStream(destinationFile);
			
			byte[] b = new byte[2048];
			int lengh;
			
			while ((lengh = in.read(b)) != -1) {
				os.write(b, 0, lengh);
			}
			
			in.close();
			os.close();
		}
		catch (IOException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		
		ImageIcon imageIcon = new ImageIcon(filename);
		imageIcon.getImage().flush();
		JLabel picLabel = new JLabel(imageIcon);
		JOptionPane.showMessageDialog(null, picLabel, "About", JOptionPane.PLAIN_MESSAGE, null);
		
		
		
	}

}
