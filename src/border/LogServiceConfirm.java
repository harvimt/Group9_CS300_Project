/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConfirmLogService.java
 *
 * Created on Feb 7, 2011, 6:22:19 PM
 */

package border;


import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import org.jdesktop.application.Action;


/**
 * 
 * @author Brandon
 */
public class LogServiceConfirm extends javax.swing.JFrame {


	/** Creates new form ConfirmLogService */
	public LogServiceConfirm() {
		initComponents();
	}

	public void setFields( javax.swing.JFormattedTextField dateEntered,
			javax.swing.JTextField dateRendered,
			javax.swing.JTextField providerNumber,
			javax.swing.JTextField memberNumber,
			javax.swing.JTextField serviceCode,
			javax.swing.JTextArea comments){
		dateTextField.setText( dateEntered.getText() );
		dateServiceRendered.setText( dateRendered.getText() );
		providerNumberField.setText( providerNumber.getText() );
		memberNumberField.setText( memberNumber.getText() );
		this.serviceCode.setText( serviceCode.getText() );
		this.commentsTextArea.setText( comments.getText());
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        titleLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dateTextField = new javax.swing.JFormattedTextField();
        dateServiceRendered = new javax.swing.JTextField();
        providerNumberField = new javax.swing.JTextField();
        memberNumberField = new javax.swing.JTextField();
        serviceCode = new javax.swing.JTextField();
        comments = new javax.swing.JScrollPane();
        commentsTextArea = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();
        finishButton = new javax.swing.JButton();

        jTextField1.setName("jTextField1"); // NOI18N

        jTextField7.setName("jTextField7"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pdx.edu.cs300_group9.DesktopApplication2.class).getContext().getResourceMap(LogServiceConfirm.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        titleLabel.setText(resourceMap.getString("titleLabel.text")); // NOI18N
        titleLabel.setName("titleLabel"); // NOI18N

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        dateTextField.setEditable(false);
        dateTextField.setName("dateTextField"); // NOI18N

        dateServiceRendered.setEditable(false);
        dateServiceRendered.setName("dateServiceRendered"); // NOI18N
        dateServiceRendered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateServiceRenderedActionPerformed(evt);
            }
        });

        providerNumberField.setEditable(false);
        providerNumberField.setName("providerNumberField"); // NOI18N
        providerNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                providerNumberFieldActionPerformed(evt);
            }
        });

        memberNumberField.setEditable(false);
        memberNumberField.setName("memberNumberField"); // NOI18N
        memberNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberNumberFieldActionPerformed(evt);
            }
        });

        serviceCode.setEditable(false);
        serviceCode.setAutoscrolls(false);
        serviceCode.setName("serviceCode"); // NOI18N
        serviceCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serviceCodeActionPerformed(evt);
            }
        });

        comments.setName("comments"); // NOI18N

        commentsTextArea.setColumns(20);
        commentsTextArea.setEditable(false);
        commentsTextArea.setRows(5);
        commentsTextArea.setName("commentsTextArea"); // NOI18N
        comments.setViewportView(commentsTextArea);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(pdx.edu.cs300_group9.DesktopApplication2.class).getContext().getActionMap(LogServiceConfirm.class, this);
        backButton.setAction(actionMap.get("closeLogServiceConfirm")); // NOI18N
        backButton.setText(resourceMap.getString("backButton.text")); // NOI18N
        backButton.setName("backButton"); // NOI18N

        finishButton.setAction(actionMap.get("commitRecordToDatabase")); // NOI18N
        finishButton.setText(resourceMap.getString("finishButton.text")); // NOI18N
        finishButton.setName("finishButton"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(backButton, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(finishButton)
                            .addComponent(dateServiceRendered)
                            .addComponent(providerNumberField)
                            .addComponent(memberNumberField)
                            .addComponent(comments)
                            .addComponent(serviceCode, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(titleLabel)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateServiceRendered, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(providerNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memberNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serviceCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(comments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton)
                    .addComponent(finishButton))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


	protected void serviceCodeActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub

	}


	protected void memberNumberFieldActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub

	}


	protected void providerNumberFieldActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub

	}

	protected void dateServiceRenderedActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub

	}


	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new LogServiceConfirm().setVisible(true);
			}
		});
	}


	@Action
	public void closeLogServiceConfirm() {
		dispose();
	}

	@Action
	public void commitRecordToDatabase() {
		// TODO finalizing code
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JScrollPane comments;
    private javax.swing.JTextArea commentsTextArea;
    private javax.swing.JTextField dateServiceRendered;
    private javax.swing.JFormattedTextField dateTextField;
    private javax.swing.JButton finishButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField memberNumberField;
    private javax.swing.JTextField providerNumberField;
    private javax.swing.JTextField serviceCode;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

}
