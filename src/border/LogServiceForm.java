/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ServiceForm.java
 *
 * Created on Feb 7, 2011, 6:21:20 PM
 */

package border;

import org.jdesktop.application.Action;


/**
 *
 * @author Brandon
 */
public class LogServiceForm extends javax.swing.JFrame {

    /** Creates new form ServiceForm */
    public LogServiceForm() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        providerNumberField = new javax.swing.JTextField();
        dateServiceRenderedField = new javax.swing.JFormattedTextField();
        memberNumberField = new javax.swing.JTextField();
        serviceCodeField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dateRecordEntered = new javax.swing.JFormattedTextField();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        comments = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pdx.edu.cs300_group9.DesktopApplication2.class).getContext().getResourceMap(LogServiceForm.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        providerNumberField.setText(resourceMap.getString("providerNumberField.text")); // NOI18N
        providerNumberField.setName("providerNumberField"); // NOI18N
        providerNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                providerNumberFieldActionPerformed(evt);
            }
        });
        dateServiceRenderedField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        dateServiceRenderedField.setName("dateServiceRenderedField"); // NOI18N

        memberNumberField.setText(resourceMap.getString("memberNumberField.text")); // NOI18N
        memberNumberField.setName("memberNumberField"); // NOI18N
        memberNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberNumberFieldActionPerformed(evt);
            }
        });

        serviceCodeField.setText(resourceMap.getString("serviceCodeField.text")); // NOI18N
        serviceCodeField.setName("serviceCodeField"); // NOI18N
        serviceCodeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serviceCodeFieldActionPerformed(evt);
            }
        });

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

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

        dateRecordEntered.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        dateRecordEntered.setName("dateRecordEntered"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(pdx.edu.cs300_group9.DesktopApplication2.class).getContext().getActionMap(LogServiceForm.class, this);
        jButton3.setAction(actionMap.get("openConfirmServiceLog")); // NOI18N
        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setName("jButton3"); // NOI18N

        jButton1.setAction(actionMap.get("cancelServiceLog")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        comments.setName("comments"); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setName("jTextArea1"); // NOI18N
        comments.setViewportView(jTextArea1);

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addGap(40, 40, 40)
                        .addComponent(dateRecordEntered, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jButton1)
                                .addGap(115, 115, 115)
                                .addComponent(jButton3)
                                .addGap(79, 79, 79))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comments, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                    .addComponent(memberNumberField, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                    .addComponent(providerNumberField, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                    .addComponent(serviceCodeField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                    .addComponent(dateServiceRenderedField, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel6)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(dateRecordEntered, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateServiceRenderedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
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
                    .addComponent(serviceCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(comments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void providerNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_providerNumberFieldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_providerNumberFieldActionPerformed

    private void dateServiceRenderedFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateServiceRenderedFieldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_dateServiceRenderedFieldActionPerformed

    private void memberNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberNumberFieldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_memberNumberFieldActionPerformed

    private void serviceCodeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serviceCodeFieldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_serviceCodeFieldActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogServiceForm().setVisible(true);
            }
        });
    }

    @Action
    public void cancelServiceLog() {
    	dispose();
    }

    @Action
    public void openConfirmServiceLog() {
    	logServiceConfirm = new LogServiceConfirm();
    	logServiceConfirm.setVisible(true);
    	logServiceConfirm.setFields(dateRecordEntered, dateServiceRenderedField, 
    								providerNumberField, memberNumberField, 
    								serviceCodeField, comments);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JFormattedTextField dateRecordEntered;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane comments;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField serviceCodeField;
    private javax.swing.JTextField memberNumberField;
    private javax.swing.JFormattedTextField dateServiceRenderedField;
    private javax.swing.JTextField providerNumberField;
    
    private LogServiceConfirm logServiceConfirm;
    // End of variables declaration//GEN-END:variables`
    
    

}
