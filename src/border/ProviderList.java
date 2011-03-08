/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ProviderList.java
 *
 * Created on Feb 7, 2011, 6:19:14 PM
 */
package border;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

import org.jdesktop.application.Action;

import border.util.FormattedRenderer;
import border.util.JTextFieldLimit;
import entity.Provider;

/**
 * 
 * @author Brandon
 */
public class ProviderList extends javax.swing.JFrame {

	private ProviderListTableModel model;
	private DefaultTableColumnModel columnModel;

	public class ProviderListTableModel
			extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 974082985600624015L;
		private List<Provider> dataList;

		public List<Provider> getDataList() {
			return dataList;
		}

		public void setDataList(
				List<Provider> dataList) {
			this.dataList = dataList;
			fireTableDataChanged();
		}

		@Override
		public int getRowCount() {
			if (dataList == null) {
				return 0;
			} else {
				return dataList.size();
			}
		}

		@Override
		public int getColumnCount() {
			return 3;
		}

		@Override
		public String getColumnName(int columnIndex) {
			switch (columnIndex) {
				case 0:
					return "Provider Name";
				case 1:
					return "Provider Number";
				case 2:
					return "Provider Email";
				default:
					break;
			}
			return null;
		}

		@Override
		public Class<?> getColumnClass(
				int columnIndex) {
			if (columnIndex == 0 || columnIndex == 2) {
				return String.class;
			} else if (columnIndex == 1) {
				return Integer.class;
			} else {
				return null;
			}
		}

		@Override
		public boolean isCellEditable(
				int rowIndex,
				int columnIndex) {
			if (columnIndex == 0 || columnIndex == 2) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public Object getValueAt(
				int rowIndex,
				int columnIndex) {

			Provider row = dataList.get(rowIndex);
			switch (columnIndex) {
				case 0:
					return row.getProviderName();

				case 1:
					return row.getProviderId();

				case 2:
					return row.getEmail();

				default:
					return null;
			}
		}

		@Override
		public void setValueAt(
				Object aValue,
				int rowIndex,
				int columnIndex) {

			Provider row = dataList.get(rowIndex);
			switch (columnIndex) {
				case 0:
					row.setProviderName((String) aValue);
					break;

				case 1:
					//can't set ID
					break;

				case 2:
					row.setEmail((String) aValue);
					break;

				default:
					break;
			}

			try {
				row.save();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Failed to Edit Provider Info", "ERROR", JOptionPane.ERROR_MESSAGE);
			}

			fireTableCellUpdated(rowIndex, columnIndex);
		}
	}
	
	private static final long serialVersionUID = -7954895459629722542L;

	/** Creates new form ProviderList */
	public ProviderList() {
		initTable();
		initComponents();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pdx.edu.cs300_group9.DesktopApplication2.class).getContext().getResourceMap(ProviderList.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setColumnModel(columnModel);
        jTable1.setModel(model);
        jTable1.setName("jTable1"); // NOI18N
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(pdx.edu.cs300_group9.DesktopApplication2.class).getContext().getActionMap(ProviderList.class, this);
        addButton.setAction(actionMap.get("addButtonClicked")); // NOI18N
        addButton.setText(resourceMap.getString("addButton.text")); // NOI18N
        addButton.setName("addButton"); // NOI18N

        searchField.setName("searchField"); // NOI18N
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchFieldKeyPressed(evt);
            }
        });

        deleteButton.setAction(actionMap.get("deleteButtonClicked")); // NOI18N
        deleteButton.setText(resourceMap.getString("deleteButton.text")); // NOI18N
        deleteButton.setName("deleteButton"); // NOI18N

        editButton.setAction(actionMap.get("editButtonClicked")); // NOI18N
        editButton.setText(resourceMap.getString("editButton.text")); // NOI18N
        editButton.setName("editButton"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(217, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)))
                .addGap(107, 107, 107)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addButton)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editButton)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
		reloadData();
	}//GEN-LAST:event_formFocusGained

	private void searchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyPressed
		reloadData();
	}//GEN-LAST:event_searchFieldKeyPressed

	private void reloadData() {
		String search_string = null;
		if (searchField != null) {
			search_string = searchField.getText();
		}
		try {
			List<Provider> providers = Provider.getProviders(search_string);
			model.setDataList(providers);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Failed to Load Provider List", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void initTable() {
		model = new ProviderListTableModel();

		columnModel = new DefaultTableColumnModel();

		TableColumn col1 = new TableColumn(0);
		col1.setIdentifier("Provider Name");
		col1.setCellEditor(new DefaultCellEditor(new JTextField(new JTextFieldLimit(25), "", 0)));
		columnModel.addColumn(col1);

		TableColumn col2 = new TableColumn(1);
		col2.setIdentifier("Provider Number");
		FormattedRenderer prov_num_renderer = new FormattedRenderer();
		prov_num_renderer.setFormatter(new DecimalFormat("000000000"));
		col2.setCellRenderer(prov_num_renderer);
		columnModel.addColumn(col2);

		TableColumn col3 = new TableColumn(2);
		col3.setIdentifier("Provider Email");
		col3.setCellEditor(new DefaultCellEditor(new JTextField(new JTextFieldLimit(128), "", 0)));
		columnModel.addColumn(col3);

		reloadData();
	}

	/**
	 * convenient for debugging; but shouldn't be used in real-world.
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new ProviderList().setVisible(true);
			}
		});
	}

	@Action
	public void addButtonClicked() {
		ProviderForm providerForm = new ProviderForm();
		providerForm.setVisible(true);
		providerForm.addWindowListener(new WindowListener() {

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
		if (row >= 0) {
			int val = (Integer) jTable1.getValueAt(row, 1);
			ProviderForm providerForm = new ProviderForm(val);
			providerForm.setVisible(true);
			providerForm.addWindowListener(new WindowListener() {

				public void windowOpened(WindowEvent e) {
				}

				public void windowClosing(WindowEvent e) {
				}

				public void windowClosed(WindowEvent e) {
					reloadData();
				}

				public void windowIconified(WindowEvent e) {
				}

				public void windowDeiconified(WindowEvent e) {
				}

				public void windowActivated(WindowEvent e) {
				}

				public void windowDeactivated(WindowEvent e) {
				}
			});
		}
	}

	@Action
	public void deleteButtonClicked() {
		int row = jTable1.getSelectedRow();
		if (row == -1) {
			return; //no row selected
		}
		int val = (Integer) jTable1.getValueAt(row, 1);
		int response = JOptionPane.showConfirmDialog(null, "Delete Provider: " + jTable1.getValueAt(row, 0), null, JOptionPane.YES_NO_OPTION);

		if (response == JOptionPane.YES_OPTION) {
			Provider prov;
			try {
				prov = new Provider(val);
				prov.delete();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Failed to delete Provider", "ERROR", ERROR);
			}
			reloadData();
		}
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
