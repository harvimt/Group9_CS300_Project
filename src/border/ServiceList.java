/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ServiceList.java
 *
 * Created on Feb 7, 2011, 7:13:14 PM
 */

package border;

import border.util.FormattedRenderer;
import border.util.JTextFieldLimit;

import java.text.DecimalFormat;
import java.util.List;

import javax.swing.JOptionPane;

import org.jdesktop.application.Action;

import entity.Service;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.math.BigDecimal;
import java.text.NumberFormat;
import javax.swing.DefaultCellEditor;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

/**
 * @author Brandon
 */
@SuppressWarnings("serial")
public class ServiceList extends javax.swing.JFrame {

	private ServiceListTableModel model;
	private DefaultTableColumnModel columnModel;

	static public class ServiceListTableModel
			extends AbstractTableModel{

		private List<Service> dataList;

		public List<Service> getDataList(){
			return dataList;
		}

		public void setDataList(List<Service> dataList){
			this.dataList = dataList;
			fireTableDataChanged();
		}
		
		@Override
		public int getRowCount() {
			if( dataList == null )
				return 0;
			else
				return dataList.size();

		}
		
		@Override
		public int getColumnCount() {
			return 3;
		}

		@Override
		public String getColumnName(int columnIndex){
			switch(columnIndex){
				case 0:
					return "Sevice Name";
				case 1:
					return "Service Number";
				case 2:
					return "Service Fee";
				default:
					break;
			}
			return null;
		}

		@Override
		public Class<?> getColumnClass(int columnIndex){
			if( columnIndex == 0 ){
				return String.class;
			} else if( columnIndex == 1 ){
				return Integer.class;
			} else if( columnIndex == 2) {
				return BigDecimal.class;
			} else {
				return null;
			}
		}

		@Override
		public boolean isCellEditable( int rowIntex, int columnIndex){
			if(columnIndex == 0 || columnIndex == 2){
				return true;
			} else {
				return false;
			}
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Service row = dataList.get(rowIndex);
			switch(columnIndex){
				case 0:
					return row.getServiceName();
				case 1:
					return Integer.valueOf(row.getServiceId());
				case 2:
					return row.getFee();
				default:
					return null;
			}
		}

		@Override
		public void setValueAt(
				Object aValue,
				int rowIndex,
				int ColumnIndex){
			Service row = dataList.get(rowIndex);
			switch(ColumnIndex){
				case 0:
					row.setServiceName((String) aValue);
					break;
				case 1:
					// can't set Code
					break;
				case 2:
					row.setFee(new BigDecimal((String)aValue));
			}
			try {
				row.save();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Failed to Edit Service Info", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			fireTableCellUpdated(rowIndex, ColumnIndex);
		}

	}

	/** Creates new form ServiceList */
	public ServiceList() {
		initTable();
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        editButton = new javax.swing.JButton();
        deleteButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pdx.edu.cs300_group9.DesktopApplication2.class).getContext().getResourceMap(ServiceList.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setColumnModel(columnModel);
        jTable1.setAutoCreateColumnsFromModel(false);
        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(model);
        jTable1.setName("jTable1"); // NOI18N
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(pdx.edu.cs300_group9.DesktopApplication2.class).getContext().getActionMap(ServiceList.class, this);
        addButton.setAction(actionMap.get("addButtonClicked")); // NOI18N
        addButton.setText(resourceMap.getString("addButton.text")); // NOI18N
        addButton.setName("addButton"); // NOI18N

        searchField.setText(resourceMap.getString("searchField.text")); // NOI18N
        searchField.setName("searchField"); // NOI18N
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });

        editButton.setAction(actionMap.get("editButtonClicked")); // NOI18N
        editButton.setText(resourceMap.getString("editButton.text")); // NOI18N
        editButton.setName("editButton"); // NOI18N

        deleteButton1.setAction(actionMap.get("deleteButtonClicked")); // NOI18N
        deleteButton1.setText(resourceMap.getString("deleteButton1.text")); // NOI18N
        deleteButton1.setName("deleteButton1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addButton)
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteButton1)
                            .addComponent(editButton)))
                    .addComponent(jLabel1, 0, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
		reloadData();
	}//GEN-LAST:event_formWindowGainedFocus

	private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
		reloadData();
	}//GEN-LAST:event_searchFieldKeyReleased
	
	private void reloadData(){
		String search_string = null;
		if (searchField != null) {
			search_string = searchField.getText();

		}
		try {
			List<Service> services = Service.getServices(search_string);
			model.setDataList(services);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Failed to load Servce List", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void initTable(){
		model = new ServiceListTableModel();

		columnModel = new DefaultTableColumnModel();

		TableColumn col1 = new TableColumn(0);
		col1.setHeaderValue("Service Name");
		col1.setCellEditor(new DefaultCellEditor(new JTextField(new JTextFieldLimit(25), "", 0)));
		columnModel.addColumn(col1);

		TableColumn col2 = new TableColumn(1);
		col2.setHeaderValue("Service Number");
		FormattedRenderer serv_num_renderer = new FormattedRenderer(new DecimalFormat("000000"));
		col2.setCellRenderer(serv_num_renderer);
		columnModel.addColumn(col2);

		TableColumn col3 = new TableColumn(2);
		col3.setHeaderValue("Service Fee");
		col3.setCellEditor(new DefaultCellEditor(new JFormattedTextField(new DecimalFormat("0.00"))));
		col3.setCellRenderer(new FormattedRenderer(NumberFormat.getCurrencyInstance()));
		columnModel.addColumn(col3);

		reloadData();

	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ServiceList().setVisible(true);
			}
		});
	}

	@Action
	public void addButtonClicked() {
		ServiceForm serviceForm = new ServiceForm();
		serviceForm.setVisible(true);
		serviceForm.addWindowListener(new WindowListener() {

			@Override
			public void windowClosed(WindowEvent e) {
				reloadData();
			}

			@Override
			public void windowOpened(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
			}

			@Override
			public void windowIconified(WindowEvent e) {
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			public void windowActivated(WindowEvent e) {
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}
		});
	}

	@Action
	public void editButtonClicked() {
		int row = jTable1.getSelectedRow();
		if(row >= 0){
			int val = (Integer) jTable1.getValueAt(row, 1);
			ServiceForm serviceForm = new ServiceForm(val);
			serviceForm.setVisible(true);
			serviceForm.addWindowListener(new WindowListener() {
				
				@Override
				public void windowClosed(WindowEvent arg0) {
					reloadData();
				}
				
				@Override
				public void windowOpened(WindowEvent arg0) {
				}
				
				@Override
				public void windowIconified(WindowEvent arg0) {
				}
				
				@Override
				public void windowDeiconified(WindowEvent arg0) {
				}
				
				@Override
				public void windowDeactivated(WindowEvent arg0) {
				}
				
				@Override
				public void windowClosing(WindowEvent arg0) {
				}
				
				@Override
				public void windowActivated(WindowEvent arg0) {
				}
			});
		}
	}

	@Action
	public void deleteButtonClicked() {
		int row = jTable1.getSelectedRow();
		if(row == -1 )
			return; // no row selected
		int val = (Integer) jTable1.getValueAt(row, 1);
		int response = JOptionPane.showConfirmDialog(null, "Delete Service: " + jTable1.getValueAt(row, 0), null, JOptionPane.YES_NO_OPTION);
		if( response == JOptionPane.YES_OPTION ){
			Service serv;
			try {
				serv = new Service(val);
				serv.delete();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Failed to delete Service", "ERROR", ERROR);
			}
			reloadData();
		}
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton1;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables

}
