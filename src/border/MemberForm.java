/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MemberForm.java
 *
 * Created on Feb 7, 2011, 6:21:52 PM
 */

package border;



import org.jdesktop.application.Action;

import entity.Member;
import entity.MemberStatus;
import javax.swing.JOptionPane;

/**
 * 
 * @author Brandon
 */
public class MemberForm extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6822738359999263635L;
	Member member;

	/** Creates new form MemberForm */
	public MemberForm() {
		initComponents();
	}

	public MemberForm(int val){
		initComponents();
		try {
			member = new Member(val);
			nameField.setValue(member.getFullName());
			numberField.setValue(member.getMemberId());
			addressField.setValue(member.getStreetAddress());
			cityField.setValue(member.getCity());
			stateField.setValue(member.getState());
			zipField.setValue(member.getZipCode());
			emailField.setText(member.getEmail());
			
			if(member.getMemberStatus() == MemberStatus.ACTIVE)
				activeRadioButton.setSelected(true);
			else if(member.getMemberStatus() == MemberStatus.SUSPENDED)
				suspendedRadioButton.setSelected(true);
			else if(member.getMemberStatus() == MemberStatus.CANCELLED)
				cancelledRadioButton.setSelected(true);
			else if(member.getMemberStatus() == MemberStatus.BANNED)
				bannedRadioButton.setSelected(true);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Failed to Load Member info", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nameField = new javax.swing.JFormattedTextField();
        numberField = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        cityField = new javax.swing.JFormattedTextField();
        stateField = new javax.swing.JFormattedTextField();
        zipField = new javax.swing.JFormattedTextField();
        addressField = new javax.swing.JFormattedTextField();
        activeRadioButton = new javax.swing.JRadioButton();
        suspendedRadioButton = new javax.swing.JRadioButton();
        cancelledRadioButton = new javax.swing.JRadioButton();
        bannedRadioButton = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pdx.edu.cs300_group9.DesktopApplication2.class).getContext().getResourceMap(MemberForm.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        try {
            nameField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("*************************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        nameField.setName("nameField"); // NOI18N

        numberField.setEditable(false);
        try {
            numberField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        numberField.setName("numberField"); // NOI18N

        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N

        try {
            cityField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("**************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cityField.setName("cityField"); // NOI18N

        try {
            stateField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UU")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        stateField.setName("stateField"); // NOI18N

        try {
            zipField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        zipField.setName("zipField"); // NOI18N

        try {
            addressField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("*************************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        addressField.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        addressField.setName("addressField"); // NOI18N

        buttonGroup1.add(activeRadioButton);
        activeRadioButton.setText(resourceMap.getString("activeRadioButton.text")); // NOI18N
        activeRadioButton.setName("activeRadioButton"); // NOI18N

        buttonGroup1.add(suspendedRadioButton);
        suspendedRadioButton.setText(resourceMap.getString("suspendedRadioButton.text")); // NOI18N
        suspendedRadioButton.setName("suspendedRadioButton"); // NOI18N

        buttonGroup1.add(cancelledRadioButton);
        cancelledRadioButton.setText(resourceMap.getString("cancelledRadioButton.text")); // NOI18N
        cancelledRadioButton.setName("cancelledRadioButton"); // NOI18N

        buttonGroup1.add(bannedRadioButton);
        bannedRadioButton.setText(resourceMap.getString("bannedRadioButton.text")); // NOI18N
        bannedRadioButton.setName("bannedRadioButton"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(pdx.edu.cs300_group9.DesktopApplication2.class).getContext().getActionMap(MemberForm.class, this);
        jButton1.setAction(actionMap.get("cancelButtonClicked")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        jButton2.setAction(actionMap.get("finishButtonClicked")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N

        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N

        emailField.setText(resourceMap.getString("emailField.text")); // NOI18N
        emailField.setName("emailField"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(90, 90, 90))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addContainerGap())
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(emailField, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                .addComponent(zipField, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                .addComponent(stateField, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                .addComponent(cityField, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                .addComponent(addressField, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                .addComponent(nameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                .addComponent(numberField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                            .addGap(94, 94, 94))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bannedRadioButton)
                                .addComponent(cancelledRadioButton)
                                .addComponent(suspendedRadioButton)
                                .addComponent(activeRadioButton))
                            .addContainerGap()))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(numberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zipField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(activeRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(suspendedRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelledRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bannedRadioButton)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1)))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MemberForm().setVisible(true);
			}
		});
	}

    @Action
    public void cancelButtonClicked() {
        dispose();
    }

    @Action
    public void finishButtonClicked() {
    	MemberStatus status = null;
    	if(buttonGroup1.getSelection() == activeRadioButton)
    		status = MemberStatus.ACTIVE;
    	else if(buttonGroup1.getSelection() == suspendedRadioButton)
    		status = MemberStatus.SUSPENDED;
    	else if(buttonGroup1.getSelection() == cancelledRadioButton)
    		status = MemberStatus.CANCELLED;
    	else if(buttonGroup1.getSelection() == bannedRadioButton)
    		status = MemberStatus.BANNED;

    	if( member != null ){
    		member.setFullName(nameField.getText());
    		member.setMemberStatus(status);
    		member.setStreetAddress(addressField.getText());
    		member.setCity(cityField.getText());
    		member.setState(stateField.getText());
    		member.setEmail(emailField.getText());
    		try {
				member.save();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Failed to Edit Member Info","ERROR",JOptionPane.ERROR_MESSAGE);
			}
    	}
    	else{
    		try {
				new Member(nameField.getText().toString(), status, addressField.getText().toString(), cityField.getText().toString(), stateField.getText().toString(), zipField.getText().toString(), emailField.getText().toString()).save();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Failed to Save New Member Info ", "ERROR",JOptionPane.ERROR_MESSAGE);
			}
    	}
    	dispose();	
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton activeRadioButton;
    private javax.swing.JFormattedTextField addressField;
    private javax.swing.JRadioButton bannedRadioButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton cancelledRadioButton;
    private javax.swing.JFormattedTextField cityField;
    private javax.swing.JTextField emailField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JFormattedTextField nameField;
    private javax.swing.JFormattedTextField numberField;
    private javax.swing.JFormattedTextField stateField;
    private javax.swing.JRadioButton suspendedRadioButton;
    private javax.swing.JFormattedTextField zipField;
    // End of variables declaration//GEN-END:variables

}
