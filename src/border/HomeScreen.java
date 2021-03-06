/*
 * DesktopApplication2View.java
 */

package border;

import control.ChocAnApp;
import control.Cron;
import org.jdesktop.application.Action;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;

import pdx.edu.cs300_group9.DesktopApplication2;

import javax.swing.JFrame;
import entity.Member;
import entity.MemberStatus;
import entity.Provider;
import entity.Service;
import entity.ServiceRendered;
import java.awt.Color;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 * The application's main frame.
 */
public class HomeScreen extends FrameView {

	public HomeScreen(SingleFrameApplication app) {
		super(app);
		try {
			ChocAnApp.getConnection();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null,
					"Failed to initialize DB connection",
					"ERROR",JOptionPane.ERROR_MESSAGE);
		}

		initComponents();

		invalidID.setVisible(false);
	
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        invalidID = new javax.swing.JLabel();
        authenticateButton = new javax.swing.JButton();
        logServiceButton = new javax.swing.JButton();
        memberNumberField = new javax.swing.JFormattedTextField();
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
        providerAddMenuItem = new javax.swing.JMenuItem();
        serviceAddMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        mainPanel.setName("mainPanel"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pdx.edu.cs300_group9.DesktopApplication2.class).getContext().getResourceMap(HomeScreen.class);
        invalidID.setFont(resourceMap.getFont("invalidID.font")); // NOI18N
        invalidID.setForeground(resourceMap.getColor("invalidID.foreground")); // NOI18N
        invalidID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalidID.setText("Invalid ID"); // NOI18N
        invalidID.setName("invalidID"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(pdx.edu.cs300_group9.DesktopApplication2.class).getContext().getActionMap(HomeScreen.class, this);
        authenticateButton.setAction(actionMap.get("authenticateMember")); // NOI18N
        authenticateButton.setText(resourceMap.getString("authenticateButton.text")); // NOI18N
        authenticateButton.setName("authenticateButton"); // NOI18N

        logServiceButton.setAction(actionMap.get("openLogServiceForm")); // NOI18N
        logServiceButton.setText(resourceMap.getString("logServiceButton.text")); // NOI18N
        logServiceButton.setName("logServiceButton"); // NOI18N

        memberNumberField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("000000000"))));
        memberNumberField.setName("memberNumberField"); // NOI18N
        memberNumberField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                memberNumberFieldFocusGained(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(authenticateButton)
                .addGap(84, 84, 84)
                .addComponent(logServiceButton)
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(invalidID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(memberNumberField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                .addGap(137, 137, 137))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(invalidID)
                .addGap(51, 51, 51)
                .addComponent(memberNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(authenticateButton)
                    .addComponent(logServiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
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

        providerAddMenuItem.setAction(actionMap.get("addNewProvider")); // NOI18N
        providerAddMenuItem.setText(resourceMap.getString("providerAddMenuItem.text")); // NOI18N
        providerAddMenuItem.setName("providerAddMenuItem"); // NOI18N
        addMenu.add(providerAddMenuItem);

        serviceAddMenuItem.setAction(actionMap.get("addNewService")); // NOI18N
        serviceAddMenuItem.setText(resourceMap.getString("serviceAddMenuItem.text")); // NOI18N
        serviceAddMenuItem.setName("serviceAddMenuItem"); // NOI18N
        addMenu.add(serviceAddMenuItem);

        menuBar.add(addMenu);

        jMenu1.setText(resourceMap.getString("jMenu1.text")); // NOI18N
        jMenu1.setName("jMenu1"); // NOI18N

        jMenuItem1.setText(resourceMap.getString("jMenuItem1.text")); // NOI18N
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText(resourceMap.getString("jMenuItem2.text")); // NOI18N
        jMenuItem2.setName("jMenuItem2"); // NOI18N
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        menuBar.add(jMenu1);

        setComponent(mainPanel);
        setMenuBar(menuBar);
    }// </editor-fold>//GEN-END:initComponents

    private void memberNumberFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_memberNumberFieldFocusGained
		memberNumberField.setText("");
	}//GEN-LAST:event_memberNumberFieldFocusGained

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
		try{
			Service[] services = new Service[]{
				new Service("Massage", new BigDecimal("200.20")),
				new Service("Therapy", new BigDecimal("400.00")),
				new Service("Purging Bath", new BigDecimal("200.20")),
				new Service("Diet Advice", new BigDecimal("400.00"))
			};

			Provider[] providers = new Provider[]{
				new Provider("Yogi Bear", "yogi@example.com"),
				new Provider("Boo Boo", "boo_boo@example.com"),
				new Provider("Dr. Phill", "phil@example.com")
			};

			Member[] members = new Member[]{
				new Member("Jane Doe",MemberStatus.ACTIVE,
					"123 Foobar st.","Barfoo","OR","97201","jane@example.net"),

				new Member("John Doe",MemberStatus.ACTIVE,
					"321 Foobar st.","Barfoo","OR","97201","john@example.net"),

				new Member("Betty Boop",MemberStatus.ACTIVE,
					"671 Excellent St","Winning","OR","99871","betty@example.net"),
			};

			DateFormat df = new SimpleDateFormat("MMM dd, yyyy");
			DateFormat dtf = DateFormat.getDateTimeInstance();

			ServiceRendered[] sr_log = new ServiceRendered[]{
				new ServiceRendered(
					dtf.parse("Jan 16, 2011 8:13:24 PM"),
					df.parse("Jan 16, 2011"),
					new BigDecimal("200.03"), providers[0], services[0], members[0], "FOOBAR"),
				new ServiceRendered(
					dtf.parse("Jan 19, 2011 8:27:55 PM"),
					df.parse("Jan 18, 2011"),
					new BigDecimal("200.30"), providers[1], services[1], members[1], "BARFOO")
			};

			for(Service service : services){
				service.save();
			}

			for(Provider provider : providers){
				provider.save();
			}

			for(Member member : members){
				member.save();
			}

			for(ServiceRendered sr : sr_log){
				sr.save();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Failed to add debug data","ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}//GEN-LAST:event_jMenuItem1ActionPerformed

	private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
		Cron.getInstance().runCron();
	}//GEN-LAST:event_jMenuItem2ActionPerformed

	@Action
	public void openLogServiceForm() {
		if(authMemberHelper()){
			logServiceForm = new LogServiceForm(((Number)memberNumberField.getValue()).intValue());
			JFrame mainFrame = DesktopApplication2.getApplication().getMainFrame();
			logServiceForm.setLocale(mainFrame.getLocale());
			logServiceForm.setVisible(true);
		}
	}

	public boolean authMemberHelper(){
		if(memberNumberField == null){
			invalidID.setVisible(false);
		} else {
			MemberStatus status;
			invalidID.setVisible(true);
			
			try {
				Member mem = new Member(((Number) memberNumberField.getValue()).intValue());
				status = mem.getMemberStatus();
			}catch(Exception e){
				status = MemberStatus.INVALID;
			}

			invalidID.setText("Member " + status.toString());
			
			if(status == MemberStatus.ACTIVE){
				invalidID.setForeground(Color.green);	
				return true;
			}else{
				invalidID.setForeground(Color.red);
			}
		}
		return false;
	}

	@Action
	public void authenticateMember() {
		authMemberHelper();

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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu listMenu;
    private javax.swing.JButton logServiceButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuItem memberMenuItem;
    private javax.swing.JFormattedTextField memberNumberField;
    private javax.swing.JMenuItem memberReportMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem providerAddMenuItem;
    private javax.swing.JMenuItem providerMenuItem;
    private javax.swing.JMenuItem providerReportMenuItem;
    private javax.swing.JMenu reportMenu;
    private javax.swing.JMenuItem serviceAddMenuItem;
    private javax.swing.JMenuItem servicesMenuItem;
    // End of variables declaration//GEN-END:variables

	private javax.swing.JFrame logServiceForm;
	private javax.swing.JFrame memberList;
	private javax.swing.JFrame providerList;
	private javax.swing.JFrame servicesList;
	private javax.swing.JFrame providerReport;
	private javax.swing.JFrame memberReport;
}
