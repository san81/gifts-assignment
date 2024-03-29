package giftsmaker.latest;

// StartGUI.java
// 
// objects.
//
import giftsmaker.GiftsConstants;
import giftsmaker.common.CommandProcessor;
import giftsmaker.common.MoveResources;
import giftsmaker.listeners.MyClient;
import giftsmaker.listeners.MyServer;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class StartGUI {

	private JMenuBar menuBar;
	private JFrame frame = new JFrame("Welcome to Gifts company");
	public Component centerComponent;
	CommandProcessor processor = new GUICommandProcessor();

	public StartGUI() {

		// Create a menu bar and give it a bevel border.
		menuBar = new JMenuBar();
		menuBar.setBorder(new BevelBorder(BevelBorder.RAISED));

		// Create a menu and add it to the menu bar.
		JMenu menu = new JMenu("Menu");
		menuBar.add(menu);

		// Instantiate a sample action with the NAME property of
		// "Download" and the appropriate SMALL_ICON property.
		menu.add(new JMenuItem(new SampleAction("All Products")));
		menu.add(new JMenuItem(new SampleAction("List Inventory")));
		menu.add(new JMenuItem(new SampleAction("Check RequiredInventory")));
		menu.add(new JMenuItem(new SampleAction("Save Inventory")));
		menu.add(new JMenuItem(new SampleAction("Load Inventory")));
		menu.add(new JMenuItem(new SampleAction("Add new Inventory")));
		menu.add(new JMenuItem(new SampleAction("Add new Product")));
	}

	class SampleAction extends AbstractAction {
		// This is our sample action. It must have an actionPerformed() method,
		// which is called when the action should be invoked.
		public SampleAction(String text) {
			super(text);
		}

		public void actionPerformed(ActionEvent e) {

			String command = e.getActionCommand();
			int commandNo = 1;
			if (GiftsConstants.JMENUITEM_ALL_PRODUCTS.equals(command))
				commandNo = 1;
			else if (GiftsConstants.JMENUITEM_LIST_INVENTORY.equals(command))
				commandNo = 2;
			else if (GiftsConstants.JMENUITEM_CHECK_REQUIRED.equals(command))
				commandNo = 3;
			else if (GiftsConstants.JMENUITEM_SAVE_INVENTORY.equals(command))
				commandNo = 4;
			else if (GiftsConstants.JMENUITEM_LOAD_INVENTORY.equals(command))
				commandNo = 5;
			else if (GiftsConstants.JMENUITEM_ADD_INVENTORY.equals(command))
				commandNo = 6;
			else if (GiftsConstants.JMENUITEM_ADD_PRODUCT.equals(command))
				commandNo = 7;

			if (centerComponent != null)
				frame.remove(centerComponent);

			centerComponent = (Component) processor.processCommand(commandNo);
			frame.getContentPane().add((Component) centerComponent, BorderLayout.CENTER);
			frame.pack();

			if (commandNo == 3) {
				Object response = JOptionPane.showInputDialog(centerComponent,
						"check required invetory for the following product?",
						"Select a Destination", JOptionPane.QUESTION_MESSAGE,
						null, new Object[] { new Integer(1), new Integer(2), new Integer(3),
						new Integer(4), new Integer(3), new Integer(6), new Integer(7) }, new Integer(2));
				String productAvailability = "";
				productAvailability = (String) ((GUICommandProcessor) processor)
						.checkRequired(((Integer)response).intValue());
				if (productAvailability.indexOf("not") != -1)
					JOptionPane.showMessageDialog(centerComponent,
							productAvailability);
				else {
					int userOrder = JOptionPane.showConfirmDialog(
							centerComponent, productAvailability);
					if (userOrder == 0) {

						if (!MyServer.serverStarted) {
							new Thread() {
								public void run() {
									try {
										MyServer.startServer();
									} catch (Exception eee) {
										eee.printStackTrace();
									}
								}
							}.start();
							MyServer.serverStarted=true;
						}
						try {
							MyClient.sendProductMakingOrder(((Integer)response).intValue());
						} catch (Exception eee) {
							eee.printStackTrace();
						}

					}
				}

			}

		}
	}

	public JFrame getFrame() {
		return frame;
	}

	public static void main(String s[]) {
		new MoveResources().moveAllResources();
		StartGUI example = new StartGUI();
		JFrame frame = example.getFrame();		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(example.menuBar);
		frame.getContentPane().add(new JPanel(), BorderLayout.CENTER);
		example.setCenterComponent(new JLabel("Welcome to gifts company"));
		frame.getContentPane().add(example.getCenterComponent(), BorderLayout.CENTER);
		frame.setSize(400, 400);
		frame.setVisible(true);
	}

	public Component getCenterComponent() {
		return centerComponent;
	}

	public void setCenterComponent(Component centerComponent) {
		this.centerComponent = centerComponent;
	}
}
