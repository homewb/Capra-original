package viewComponent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import routePlannerModel.RouteModel;
import routePlannerModel.RouteModelImp;
import viewController.DistributionButtonController;
import viewController.GraphPathButtonController;
import viewController.ReloadButtonController;
import viewController.SearchButtonController;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Font;

public class MainAppImp implements MainAppView {
	private JFrame frame;
	private JTextField jtfOriginAddress;
	private JLabel jlbOrigin;
	private JLabel jlbDestination;
	private JLabel jlbStationName;
	private JLabel jlbColorOne;
	private JLabel jlbColorTwo;
	private JLabel jlbColorThree;
	private JLabel jlbColorFour;
	private JLabel jlbLegendOne;
	private JLabel jlbLegendTwo;
	private JLabel jlbLegendThree;
	private JLabel jlbLegendFour;
	
	private Browser browser = new Browser();
    private BrowserView browserView = new BrowserView(browser);
    private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RouteModel model = new RouteModelImp();
					MainAppImp window = new MainAppImp(model);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainAppImp(RouteModel model) {
		initialize(model);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(RouteModel model) {
		frame = new JFrame();
		frame.setBounds(100, 100, 961, 583);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel locationPanel = new JPanel();
		locationPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		locationPanel.setBounds(6, 6, 652, 30);
		frame.getContentPane().add(locationPanel);
		locationPanel.setLayout(null);
		
		JLabel lblOrigin = new JLabel("Start:");
		lblOrigin.setBounds(6, 6, 40, 16);
		locationPanel.add(lblOrigin);
		
		jlbOrigin = new JLabel("");
		jlbOrigin.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		jlbOrigin.setBounds(58, 6, 124, 16);
		locationPanel.add(jlbOrigin);
		
		JLabel lblDestination = new JLabel("End:");
		lblDestination.setBounds(194, 6, 32, 16);
		locationPanel.add(lblDestination);
		
		jlbDestination = new JLabel("");
		jlbDestination.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		jlbDestination.setBounds(238, 6, 124, 16);
		locationPanel.add(jlbDestination);
		
		JLabel lblDestinationAddress = new JLabel("Public Transport:");
		lblDestinationAddress.setBounds(374, 6, 120, 16);
		locationPanel.add(lblDestinationAddress);
		
		jlbStationName = new JLabel("");
		jlbStationName.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 14));
		jlbStationName.setBounds(506, 6, 140, 16);
		locationPanel.add(jlbStationName);
		
		JPanel planPanel = new JPanel();
		planPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		planPanel.setBounds(670, 6, 285, 185);
		frame.getContentPane().add(planPanel);
		planPanel.setLayout(null);
		
		JLabel lblOriginAddress = new JLabel("POI Address: ");
		lblOriginAddress.setBounds(6, 6, 102, 16);
		planPanel.add(lblOriginAddress);
		
		jtfOriginAddress = new JTextField();
		jtfOriginAddress.setBounds(6, 34, 273, 28);
		planPanel.add(jtfOriginAddress);
		jtfOriginAddress.setColumns(10);
		
		JButton jbtSearch = new JButton("Search");
		jbtSearch.addActionListener(new SearchButtonController(model, this));
		jbtSearch.setBounds(150, 143, 129, 29);
		planPanel.add(jbtSearch);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Public Transport Preference", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(16, 74, 246, 57);
		planPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Train");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(6, 20, 75, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		JPanel mapViewPanel = new JPanel();
		mapViewPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		mapViewPanel.setBounds(6, 48, 652, 507);
		frame.getContentPane().add(mapViewPanel);
		mapViewPanel.setLayout(new BorderLayout(0, 0));
		mapViewPanel.add(browserView, BorderLayout.CENTER);
		
		browser.loadURL("file:///" + System.getProperty("user.dir") + "/TestMap.html");
		
		JPanel controlPanel = new JPanel();
		controlPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		controlPanel.setBounds(670, 341, 285, 150);
		frame.getContentPane().add(controlPanel);
		controlPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 273, 139);
		controlPanel.add(panel);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Legend", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(null);
		
		jlbColorOne = new JLabel("");
		jlbColorOne.setBackground(new Color(255, 0, 0));
		jlbColorOne.setBounds(6, 23, 47, 16);
		jlbColorOne.setOpaque(true);
		panel.add(jlbColorOne);
		
		jlbColorTwo = new JLabel("");
		jlbColorTwo.setBackground(new Color(255, 153, 0));
		jlbColorTwo.setBounds(6, 51, 47, 16);
		jlbColorTwo.setOpaque(true);
		panel.add(jlbColorTwo);
		
		jlbColorThree = new JLabel("");
		jlbColorThree.setBackground(new Color(51, 153, 255));
		jlbColorThree.setBounds(6, 79, 47, 16);
		jlbColorThree.setOpaque(true);
		panel.add(jlbColorThree);
		
		jlbColorFour = new JLabel("");
		jlbColorFour.setBackground(new Color(51, 204, 51));
		jlbColorFour.setBounds(6, 107, 47, 16);
		jlbColorFour.setOpaque(true);
		panel.add(jlbColorFour);
		
		jlbLegendOne = new JLabel("CAPRA (Normal)");
		jlbLegendOne.setBounds(65, 23, 202, 16);
		panel.add(jlbLegendOne);
		
		jlbLegendTwo = new JLabel("CAPRA (Without Contour)");
		jlbLegendTwo.setBounds(65, 51, 202, 16);
		panel.add(jlbLegendTwo);
		
		jlbLegendThree = new JLabel("Google");
		jlbLegendThree.setBounds(65, 79, 202, 16);
		panel.add(jlbLegendThree);
		
		jlbLegendFour = new JLabel("A* Distance");
		jlbLegendFour.setBounds(65, 107, 202, 16);
		panel.add(jlbLegendFour);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(670, 203, 285, 126);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnReload = new JButton("Reload Directions Map");
		btnReload.setBounds(46, 9, 185, 29);
		panel_2.add(btnReload);
		
		JButton btnDistribution = new JButton("Show Distribution");
		btnDistribution.setBounds(46, 50, 185, 29);
		panel_2.add(btnDistribution);
		
		JButton jbtGraph = new JButton("Draw Line Chart");
		jbtGraph.setBounds(46, 91, 185, 29);
		panel_2.add(jbtGraph);
		jbtGraph.addActionListener(new GraphPathButtonController(model, this));
		btnDistribution.addActionListener(new DistributionButtonController(model, this));
		btnReload.addActionListener(new ReloadButtonController(model, this));
	}

	@Override
	public void setOriginLocation(String location) {
		this.jlbOrigin.setText(location);
	}

	@Override
	public void setDestinationLocation(String location) {
		this.jlbDestination.setText(location);
	}

	@Override
	public String getOriginAddress() {
		return this.jtfOriginAddress.getText();
	}

	@Override
	public Browser getBrowser() {
		return this.browser;
	}

	@Override
	public void setTrainStationName(String location) {
		this.jlbStationName.setText(location);
	}

	@Override
	public void setLegendOne(Color color, String text) {
		jlbColorOne.setBackground(color);
		jlbColorOne.setOpaque(true);
		jlbLegendOne.setText(text);	
	}

	@Override
	public void setLegendTwo(Color color, String text) {
		jlbColorTwo.setBackground(color);
		jlbColorTwo.setOpaque(true);
		jlbLegendTwo.setText(text);	
	}

	@Override
	public void setLegendThree(Color color, String text) {
		jlbColorThree.setBackground(color);
		jlbColorThree.setOpaque(true);
		jlbLegendThree.setText(text);	
	}

	@Override
	public void setLegendFour(Color color, String text) {
		jlbColorFour.setBackground(color);
		jlbColorFour.setOpaque(true);
		jlbLegendFour.setText(text);	
	}	
}
