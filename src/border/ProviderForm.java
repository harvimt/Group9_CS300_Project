/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ProviderForm.java
 *
 * Created on Feb 7, 2011, 6:21:38 PM
 */
package border;

import border.util.EmailValidator;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.jdesktop.application.Action;

import border.util.JTextFieldLimit;
import entity.Provider;

/**
 * 
 * @author Brandon
 */
@SuppressWarnings("serial")
public class ProviderForm extends javax.swing.JFrame {

	/** Creates new form ProviderForm */
	public ProviderForm() {
		initComponents();
	}

	public ProviderForm(int val) {
		initComponents();
		try {
			provider = new Provider(val);
			providerNameField.setText(provider.getProviderName());
			providerNumberField.setValue(Integer
				.valueOf(val));
			providerEmailField.setText(provider.getEmail());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Failed to Load Provider Info", "ERROR", JOptionPane.ERROR_MESSAGE);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        providerNumberField = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        providerEmailField = new javax.swing.JTextField();
        providerNameField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pdx.edu.cs300_group9.DesktopApplication2.class).getContext().getResourceMap(ProviderForm.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(pdx.edu.cs300_group9.DesktopApplication2.class).getContext().getActionMap(ProviderForm.class, this);
        jButton1.setAction(actionMap.get("cancelButtonClicked")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        jButton2.setAction(actionMap.get("finishButtonClicked")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N

        providerNumberField.setEditable(false);
        providerNumberField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("000000000"))));
        providerNumberField.setName("providerNumberField"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        providerEmailField.setDocument(new JTextFieldLimit(128));
        providerEmailField.setInputVerifier(new EmailValidator());
        providerEmailField.setName("providerEmailField"); // NOI18N

        providerNameField.setDocument(new JTextFieldLimit(25));
        providerNameField.setName("providerNameField"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel1)
                .addContainerGap(170, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(147, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(41, 41, 41)
                .addComponent(jButton2)
                .addGap(133, 133, 133))
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(providerEmailField)
                    .addComponent(providerNumberField)
                    .addComponent(providerNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(providerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(providerNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(providerEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(48, 48, 48))
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
				new ProviderForm().setVisible(true);
			}
		});
	}

	@Action
	public void cancelButtonClicked() {
		dispose();
	}

	@Action
	public void finishButtonClicked() {
		if (provider != null) {
			provider.setProviderName(providerNameField.getText());
			provider.setEmail(providerEmailField.getText());
			try {
				provider.save();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(this, "Failed to Edit Provider Info","ERROR",JOptionPane.ERROR_MESSAGE);
			}
		} else {
			try {
				new Provider(providerNameField.getText(), providerEmailField.getText()).save();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(this, "Failed to Save New Provider Info","ERROR",JOptionPane.ERROR_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Failed to Save New Provider Info","ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}
		dispose();
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField providerEmailField;
    private javax.swing.JTextField providerNameField;
    private javax.swing.JFormattedTextField providerNumberField;
    // End of variables declaration//GEN-END:variables
    
    private Provider provider;

}
