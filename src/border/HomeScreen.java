/*
 * DesktopApplication2View.java
 */

package border;

import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;

import pdx.edu.cs300_group9.DesktopApplication2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * The application's main frame.
 */
public class HomeScreen extends FrameView {

	public HomeScreen(SingleFrameApplication app) {
		super(app);

		initComponents();

		// status bar initialization - message timeout, idle icon and busy
		// animation, etc
		ResourceMap resourceMap = getResourceMap();
		int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
		messageTimer = new Timer(messageTimeout, new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		messageTimer.setRepeats(false);
		int busyAnimationRate = resourceMap
				.getInteger("StatusBar.busyAnimationRate");
		for (int i = 0; i < busyIcons.length; i++) {
			busyIcons[i] = resourceMap
					.getIcon("StatusBar.busyIcons[" + i + "]");
		}
		busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				busyIconIndex = (busyIconIndex + 1) % busyIcons.length;

			}
		});
		idleIcon = resourceMap.getIcon("StatusBar.idleIcon");

	}

	@Action
	public void showAboutBox() {
		if (aboutBox == null) {
			JFrame mainFrame = DesktopApplication2.getApplication()
					.getMainFrame();
			// aboutBox = new DesktopApplication2AboutBox(mainFrame);
			aboutBox.setLocationRelativeTo(mainFrame);
		}
		DesktopApplication2.getApplication().show(aboutBox);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		mainPanel = new javax.swing.JPanel();
		jButton1 = new javax.swing.JButton();
		jTextField1 = new javax.swing.JTextField();
		jButton2 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		menuBar = new javax.swing.JMenuBar();
		javax.swing.JMenu fileMenu = new javax.swing.JMenu();
		jMenuItem5 = new javax.swing.JMenuItem();
		exitMenuItem = new javax.swing.JMenuItem();
		jMenu1 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenuItem2 = new javax.swing.JMenuItem();
		jMenuItem3 = new javax.swing.JMenuItem();
		jMenu2 = new javax.swing.JMenu();
		jMenuItem4 = new javax.swing.JMenuItem();
		jMenuItem6 = new javax.swing.JMenuItem();
		javax.swing.JMenu helpMenu = new javax.swing.JMenu();
		javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();

		mainPanel.setName("mainPanel"); // NOI18N

		javax.swing.ActionMap actionMap = org.jdesktop.application.Application
				.getInstance(pdx.edu.cs300_group9.DesktopApplication2.class)
				.getContext().getActionMap(HomeScreen.class, this);
		jButton1.setAction(actionMap.get("authenticateMember")); // NOI18N
		org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application
				.getInstance(pdx.edu.cs300_group9.DesktopApplication2.class)
				.getContext().getResourceMap(HomeScreen.class);
		jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
		jButton1.setName("jButton1"); // NOI18N

		jTextField1.setText(resourceMap.getString("jTextField1.text")); // NOI18N
		jTextField1.setName("jTextField1"); // NOI18N

		jButton2.setAction(actionMap.get("openLogServiceForm")); // NOI18N
		jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
		jButton2.setName("jButton2"); // NOI18N

		jLabel1.setName("jLabel1"); // NOI18N

		jLabel2.setName("jLabel2"); // NOI18N

		jLabel3.setFont(resourceMap.getFont("jLabel3.font")); // NOI18N
		jLabel3.setForeground(resourceMap.getColor("jLabel3.foreground")); // NOI18N
		jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
		jLabel3.setName("jLabel3"); // NOI18N

		javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(
				mainPanel);
		mainPanel.setLayout(mainPanelLayout);
		mainPanelLayout
				.setHorizontalGroup(mainPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								mainPanelLayout
										.createSequentialGroup()
										.addGap(41, 41, 41)
										.addGroup(
												mainPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(jButton1)
														.addComponent(jLabel1))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												176, Short.MAX_VALUE)
										.addComponent(jButton2)
										.addGap(88, 88, 88))
						.addGroup(
								mainPanelLayout.createSequentialGroup()
										.addGap(196, 196, 196)
										.addComponent(jLabel2)
										.addContainerGap(331, Short.MAX_VALUE))
						.addGroup(
								mainPanelLayout.createSequentialGroup()
										.addGap(166, 166, 166)
										.addComponent(jLabel3)
										.addContainerGap(173, Short.MAX_VALUE))
						.addGroup(
								mainPanelLayout
										.createSequentialGroup()
										.addGap(184, 184, 184)
										.addComponent(
												jTextField1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												159,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(184, Short.MAX_VALUE)));
		mainPanelLayout
				.setVerticalGroup(mainPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								mainPanelLayout
										.createSequentialGroup()
										.addGap(71, 71, 71)
										.addComponent(jLabel2)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel3)
										.addGap(12, 12, 12)
										.addGroup(
												mainPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(jLabel1)
														.addComponent(
																jTextField1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																20,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												89, Short.MAX_VALUE)
										.addGroup(
												mainPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButton1)
														.addComponent(jButton2))
										.addGap(44, 44, 44)));

		menuBar.setName("menuBar"); // NOI18N

		fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
		fileMenu.setName("fileMenu"); // NOI18N

		jMenuItem5.setText(resourceMap.getString("jMenuItem5.text")); // NOI18N
		jMenuItem5.setName("jMenuItem5"); // NOI18N
		fileMenu.add(jMenuItem5);

		exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
		exitMenuItem.setName("exitMenuItem"); // NOI18N
		fileMenu.add(exitMenuItem);

		menuBar.add(fileMenu);

		jMenu1.setText(resourceMap.getString("jMenu1.text")); // NOI18N
		jMenu1.setName("jMenu1"); // NOI18N

		jMenuItem1.setText(resourceMap.getString("jMenuItem1.text")); // NOI18N
		jMenuItem1.setName("jMenuItem1"); // NOI18N
		jMenu1.add(jMenuItem1);

		jMenuItem2.setText(resourceMap.getString("jMenuItem2.text")); // NOI18N
		jMenuItem2.setName("jMenuItem2"); // NOI18N
		jMenu1.add(jMenuItem2);

		jMenuItem3.setText(resourceMap.getString("jMenuItem3.text")); // NOI18N
		jMenuItem3.setName("jMenuItem3"); // NOI18N
		jMenu1.add(jMenuItem3);

		menuBar.add(jMenu1);

		jMenu2.setText(resourceMap.getString("jMenu2.text")); // NOI18N
		jMenu2.setName("jMenu2"); // NOI18N

		jMenuItem4.setText(resourceMap.getString("jMenuItem4.text")); // NOI18N
		jMenuItem4.setName("jMenuItem4"); // NOI18N
		jMenu2.add(jMenuItem4);

		jMenuItem6.setName("jMenuItem6"); // NOI18N
		jMenuItem6.setName("jMenuItem6"); // NOI18N
		jMenu2.add(jMenuItem6);

		menuBar.add(jMenu2);

		helpMenu.setAction(actionMap.get("showAboutBox")); // NOI18N
		helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
		helpMenu.setName("helpMenu"); // NOI18N
		helpMenu.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				helpMenuMouseClicked(evt);
			}
		});
		helpMenu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				helpMenuActionPerformed(evt);
			}
		});

		aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
		aboutMenuItem.setName("aboutMenuItem"); // NOI18N
		helpMenu.add(aboutMenuItem);

		menuBar.add(helpMenu);

		setComponent(mainPanel);
		setMenuBar(menuBar);
	}// </editor-fold>//GEN-END:initComponents

	private void helpMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_helpMenuActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_helpMenuActionPerformed

	private void helpMenuMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_helpMenuMouseClicked
		// TODO add your handling code here:
	}// GEN-LAST:event_helpMenuMouseClicked

	@Action
	public void openLogServiceForm() {
	}

	@Action
	public void authenticateMember() {
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JMenuItem exitMenuItem;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem jMenuItem4;
	private javax.swing.JMenuItem jMenuItem5;
	private javax.swing.JMenuItem jMenuItem6;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JPanel mainPanel;
	private javax.swing.JMenuBar menuBar;
	// End of variables declaration//GEN-END:variables

	private final Timer messageTimer;
	private final Timer busyIconTimer;
	private final Icon idleIcon;
	private final Icon[] busyIcons = new Icon[15];
	private int busyIconIndex = 0;

	private JDialog aboutBox;
}
