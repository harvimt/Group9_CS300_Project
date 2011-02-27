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


		// status bar initialization - message timeout, idle icon and busy animation, etc
		/*ResourceMap resourceMap = getResourceMap();
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
		 */
	}

	@Action
	public void showAboutBox() {
		if (aboutBox == null) {

			JFrame mainFrame = DesktopApplication2.getApplication().getMainFrame();
			aboutBox = new AboutBox(mainFrame);
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

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        invalidID = new javax.swing.JLabel();
        authenticateButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        logServiceButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        autenticateMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        listMenu = new javax.swing.JMenu();
        memberMenuItem = new javax.swing.JMenuItem();
        providerMenuItem = new javax.swing.JMenuItem();
        servicesMenuItem = new javax.swing.JMenuItem();
        reportMenu = new javax.swing.JMenu();
        providerReportMenuItem = new javax.swing.JMenuItem();
        memberReportMenuItem = new javax.swing.JMenuItem();
        accountsPayabelMenuItem = new javax.swing.JMenuItem();
        addMenu = new javax.swing.JMenu();
        addMemberMenuItem = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();

        mainPanel.setName("mainPanel"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pdx.edu.cs300_group9.DesktopApplication2.class).getContext().getResourceMap(HomeScreen.class);
        invalidID.setFont(resourceMap.getFont("invalidID.font")); // NOI18N
        invalidID.setForeground(resourceMap.getColor("invalidID.foreground")); // NOI18N
        invalidID.setText(resourceMap.getString("invalidID.text")); // NOI18N
        invalidID.setName("invalidID"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(pdx.edu.cs300_group9.DesktopApplication2.class).getContext().getActionMap(HomeScreen.class, this);
        authenticateButton.setAction(actionMap.get("authenticateMember")); // NOI18N
        authenticateButton.setText(resourceMap.getString("authenticateButton.text")); // NOI18N
        authenticateButton.setName("authenticateButton"); // NOI18N

        jTextField1.setName("jTextField1"); // NOI18N

        logServiceButton.setAction(actionMap.get("openLogServiceForm")); // NOI18N
        logServiceButton.setText(resourceMap.getString("logServiceButton.text")); // NOI18N
        logServiceButton.setName("logServiceButton"); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(authenticateButton)
                        .addGap(69, 69, 69)
                        .addComponent(logServiceButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(invalidID))
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(invalidID)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(authenticateButton)
                    .addComponent(logServiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        autenticateMenuItem.setText(resourceMap.getString("autenticateMenuItem.text")); // NOI18N
        autenticateMenuItem.setName("autenticateMenuItem"); // NOI18N
        fileMenu.add(autenticateMenuItem);

        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        listMenu.setAction(actionMap.get("openProviderList")); // NOI18N
        listMenu.setText(resourceMap.getString("listMenu.text")); // NOI18N
        listMenu.setName("listMenu"); // NOI18N

        memberMenuItem.setAction(actionMap.get("openMemberList")); // NOI18N
        memberMenuItem.setText(resourceMap.getString("memberMenuItem.text")); // NOI18N
        memberMenuItem.setName("memberMenuItem"); // NOI18N
        listMenu.add(memberMenuItem);

        providerMenuItem.setAction(actionMap.get("openProviderList")); // NOI18N
        providerMenuItem.setText(resourceMap.getString("providerMenuItem.text")); // NOI18N
        providerMenuItem.setName("providerMenuItem"); // NOI18N
        listMenu.add(providerMenuItem);

        servicesMenuItem.setAction(actionMap.get("openServicesList")); // NOI18N
        servicesMenuItem.setText(resourceMap.getString("servicesMenuItem.text")); // NOI18N
        servicesMenuItem.setName("servicesMenuItem"); // NOI18N
        listMenu.add(servicesMenuItem);

        menuBar.add(listMenu);

        reportMenu.setAction(actionMap.get("openProviderReport")); // NOI18N
        reportMenu.setText(resourceMap.getString("reportMenu.text")); // NOI18N
        reportMenu.setName("reportMenu"); // NOI18N

        providerReportMenuItem.setAction(actionMap.get("openMemberReport")); // NOI18N
        providerReportMenuItem.setText(resourceMap.getString("providerReportMenuItem.text")); // NOI18N
        providerReportMenuItem.setName("providerReportMenuItem"); // NOI18N
        reportMenu.add(providerReportMenuItem);

        memberReportMenuItem.setAction(actionMap.get("openProviderReport")); // NOI18N
        memberReportMenuItem.setText(resourceMap.getString("memberReportMenuItem.text")); // NOI18N
        memberReportMenuItem.setName("memberReportMenuItem"); // NOI18N
        reportMenu.add(memberReportMenuItem);

        accountsPayabelMenuItem.setAction(actionMap.get("openAccountsPayableReport")); // NOI18N
        accountsPayabelMenuItem.setText(resourceMap.getString("accountsPayabelMenuItem.text")); // NOI18N
        accountsPayabelMenuItem.setName("accountsPayabelMenuItem"); // NOI18N
        reportMenu.add(accountsPayabelMenuItem);

        menuBar.add(reportMenu);

        addMenu.setText(resourceMap.getString("addMenu.text")); // NOI18N
        addMenu.setName("addMenu"); // NOI18N

        addMemberMenuItem.setAction(actionMap.get("addNewMember")); // NOI18N
        addMemberMenuItem.setText(resourceMap.getString("addMemberMenuItem.text")); // NOI18N
        addMemberMenuItem.setName("addMemberMenuItem"); // NOI18N
        addMenu.add(addMemberMenuItem);

        jMenuItem2.setAction(actionMap.get("addNewProvider")); // NOI18N
        jMenuItem2.setText(resourceMap.getString("jMenuItem2.text")); // NOI18N
        jMenuItem2.setName("jMenuItem2"); // NOI18N
        addMenu.add(jMenuItem2);

        jMenuItem3.setAction(actionMap.get("addNewService")); // NOI18N
        jMenuItem3.setText(resourceMap.getString("jMenuItem3.text")); // NOI18N
        jMenuItem3.setName("jMenuItem3"); // NOI18N
        addMenu.add(jMenuItem3);

        menuBar.add(addMenu);

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
		logServiceForm = new LogServiceForm();
		JFrame mainFrame = DesktopApplication2.getApplication().getMainFrame();
		logServiceForm.setLocale(mainFrame.getLocale());
		logServiceForm.setVisible(true);
	}

	@Action
	public void authenticateMember() {
		if(jTextField1 == null)
			invalidID.setVisible(false);
		else
			invalidID.setVisible(true);
	}

	@Action
	public void openMemberList() {
		memberList = new MemberList();
		memberList.setVisible(true);
	}

	@Action
	public void openProviderList() {
		providerList = new ProviderList();
		providerList.setVisible(true);
	}

	@Action
	public void openServicesList() {
		servicesList = new ServiceList();
		servicesList.setVisible(true);
	}

	@Action
	public void openProviderReport() {
		providerReport = new ProviderReportUI();
		providerReport.setVisible(true);
	}

	@Action
	public void openMemberReport() {
		memberReport = new MemberReportUI();
		memberReport.setVisible(true);
	}

    @Action
    public void addNewMember() {
        MemberForm memberForm = new MemberForm();
        memberForm.setVisible(true);
    }

    @Action
    public void addNewProvider() {
        ProviderForm providerForm = new ProviderForm();
        providerForm.setVisible(true);
    }

    @Action
    public void addNewService() {
        ServiceForm serviceForm = new ServiceForm();
        serviceForm.setVisible(true);
    }

    @Action
    public void openAccountsPayableReport() {
        ReportToAccountsPayableUI accountsPayableUI = new ReportToAccountsPayableUI();
        accountsPayableUI.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem accountsPayabelMenuItem;
    private javax.swing.JMenuItem addMemberMenuItem;
    private javax.swing.JMenu addMenu;
    private javax.swing.JMenuItem autenticateMenuItem;
    private javax.swing.JButton authenticateButton;
    private javax.swing.JLabel invalidID;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JMenu listMenu;
    private javax.swing.JButton logServiceButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuItem memberMenuItem;
    private javax.swing.JMenuItem memberReportMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem providerMenuItem;
    private javax.swing.JMenuItem providerReportMenuItem;
    private javax.swing.JMenu reportMenu;
    private javax.swing.JMenuItem servicesMenuItem;
    // End of variables declaration//GEN-END:variables

	/*private final Timer messageTimer;
	private final Timer busyIconTimer;
	private final Icon idleIcon;
	private final Icon[] busyIcons = new Icon[15];
	private int busyIconIndex = 0;
	 */
	private JDialog aboutBox;
	private javax.swing.JFrame logServiceForm;
	private javax.swing.JFrame memberList;
	private javax.swing.JFrame providerList;
	private javax.swing.JFrame servicesList;
	private javax.swing.JFrame providerReport;
	private javax.swing.JFrame memberReport;
}
