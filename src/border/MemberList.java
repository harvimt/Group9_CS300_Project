package border;

import border.util.EmailValidator;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
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
import entity.Member;
import entity.MemberStatus;
import java.util.Arrays;
import javax.swing.JComboBox;

/*
 * Created on Feb 7, 2011, 1:35:39 PM
 * 
 * @author Brandon
 */
public class MemberList extends javax.swing.JFrame {
	private static final long serialVersionUID = -484134655678221995L;
	private MemberListTableModel model;
	private DefaultTableColumnModel columnModel;
	static final private List <Member> empty_list = new LinkedList<Member>();

	public class MemberListTableModel
			extends AbstractTableModel{

		 
		private static final long serialVersionUID = -2590145503825646055L;
		private List<Member> dataList;

		public List<Member> getDataList() {
			return dataList;
		}

		public void setDataList(
				List<Member> dataList) {
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
			return 8;
		}
		@Override
		public Class<?> getColumnClass(
				int columnIndex) {
			if (columnIndex == 0 || 3 <= columnIndex && columnIndex <= 7) {
				return String.class;
			} else if (columnIndex == 1) {
				return Integer.class;
			} else if(columnIndex == 2){
				return MemberStatus.class;
			} else {
				return null;
			}
		}

		@Override
		public boolean isCellEditable(
				int rowIndex,
				int columnIndex) {
			
			if(columnIndex == 0){
				return true;
			}else if (columnIndex == 1) {
				return false;
			} else if (columnIndex <= 7){
				return true;
			}

			return false;
		}

		@Override
		public Object getValueAt(
				int rowIndex,
				int columnIndex) {

			Member row = dataList.get(rowIndex);
			switch (columnIndex) {
				case 0:
					return row.getFullName();
				case 1:
					return Integer.valueOf(row.getMemberId());
				case 2:
					return row.getMemberStatus();
				case 3:
					return row.getStreetAddress();
				case 4:
					return row.getCity();
				case 5:
					return row.getState();
				case 6:
					return row.getZipCode();
				case 7:
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

			Member row = dataList.get(rowIndex);
			switch (columnIndex) {
				case 0:
					row.setFullName((String) aValue);
					reloadData();
					break;
				case 1:
					//can't set ID
					break;
				case 2:
					row.setMemberStatus((MemberStatus)aValue);
					reloadData();
					break;
				case 3:
					row.setStreetAddress((String) aValue);
					break;
				case 4:
					row.setCity((String) aValue);
					break;
				case 5:
					row.setState((String) aValue);
					break;
				case 6:
					row.setZipCode((String) aValue);
					break;
				case 7:
					row.setEmail((String) aValue);
					break;
				default:
					break;
			}

			try {
				row.save();
			}
			catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Could not save Member",
						"ERROR",JOptionPane.ERROR_MESSAGE);
			}

			fireTableCellUpdated(rowIndex, columnIndex);
		}
	}
	/** Creates new form Report */
	public MemberList() {
		initTable();
		initComponents();
		reloadData();
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
        searchField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        activeCheckBox = new javax.swing.JCheckBox();
        cancelledCheckBox = new javax.swing.JCheckBox();
        bannedCheckBox = new javax.swing.JCheckBox();
        suspendedCheckBox = new javax.swing.JCheckBox();
        allCheckBox = new javax.swing.JCheckBox();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(pdx.edu.cs300_group9.DesktopApplication2.class).getContext().getResourceMap(MemberList.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1.setAutoCreateColumnsFromModel(false);
        jTable1.setAutoCreateRowSorter(true);
        jTable1.setColumnModel(columnModel);
        jTable1.setModel(model);
        jTable1.setName("jTable1"); // NOI18N
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setName("jLabel1"); // NOI18N

        searchField.setName("searchField"); // NOI18N
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });

        jLabel2.setName("jLabel2"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(pdx.edu.cs300_group9.DesktopApplication2.class).getContext().getActionMap(MemberList.class, this);
        activeCheckBox.setAction(actionMap.get("activeBoxChecked")); // NOI18N
        activeCheckBox.setSelected(true);
        activeCheckBox.setText(resourceMap.getString("activeCheckBox.text")); // NOI18N
        activeCheckBox.setName("activeCheckBox"); // NOI18N

        cancelledCheckBox.setAction(actionMap.get("cancelledBoxChecked")); // NOI18N
        cancelledCheckBox.setText(resourceMap.getString("cancelledCheckBox.text")); // NOI18N
        cancelledCheckBox.setName("cancelledCheckBox"); // NOI18N

        bannedCheckBox.setAction(actionMap.get("bannedBoxChecked")); // NOI18N
        bannedCheckBox.setText(resourceMap.getString("bannedCheckBox.text")); // NOI18N
        bannedCheckBox.setName("bannedCheckBox"); // NOI18N

        suspendedCheckBox.setAction(actionMap.get("suspendedBoxChecked")); // NOI18N
        suspendedCheckBox.setText(resourceMap.getString("suspendedCheckBox.text")); // NOI18N
        suspendedCheckBox.setName("suspendedCheckBox"); // NOI18N

        allCheckBox.setAction(actionMap.get("allCheckBoxChecked")); // NOI18N
        allCheckBox.setText(resourceMap.getString("allCheckBox.text")); // NOI18N
        allCheckBox.setName("allCheckBox"); // NOI18N

        addButton.setAction(actionMap.get("addButtonClicked")); // NOI18N
        addButton.setText(resourceMap.getString("addButton.text")); // NOI18N
        addButton.setName("addButton"); // NOI18N

        editButton.setAction(actionMap.get("editButtonClicked")); // NOI18N
        editButton.setText(resourceMap.getString("editButton.text")); // NOI18N
        editButton.setName("editButton"); // NOI18N

        deleteButton.setAction(actionMap.get("deleteButtonClicked")); // NOI18N
        deleteButton.setText(resourceMap.getString("deleteButton.text")); // NOI18N
        deleteButton.setName("deleteButton"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel1)
                .addGap(525, 525, 525))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(311, 311, 311))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(activeCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(suspendedCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelledCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bannedCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(allCheckBox)
                        .addGap(18, 18, 18)))
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(activeCheckBox)
                    .addComponent(suspendedCheckBox)
                    .addComponent(cancelledCheckBox)
                    .addComponent(bannedCheckBox)
                    .addComponent(allCheckBox)
                    .addComponent(addButton)
                    .addComponent(editButton)
                    .addComponent(deleteButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
		reloadData();
	}//GEN-LAST:event_formFocusGained

	private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
		reloadData();
	}//GEN-LAST:event_searchFieldKeyReleased


	private void reloadData() {
		ArrayList<MemberStatus> status = new ArrayList<MemberStatus>();
		MemberStatus[] status_arr = null;
		if(allCheckBox != null && !allCheckBox.isSelected()){
			if(activeCheckBox.isSelected())
				status.add(MemberStatus.ACTIVE);
			if(suspendedCheckBox.isSelected())
				status.add(MemberStatus.SUSPENDED);
			if(cancelledCheckBox.isSelected())
				status.add(MemberStatus.CANCELLED);
			if(bannedCheckBox.isSelected())
				status.add(MemberStatus.BANNED);
			
			if(status.isEmpty()){
				model.setDataList(empty_list);
				return;
			}
			status_arr = (MemberStatus[]) status.toArray(new MemberStatus[0]);
		}

		String search_string = null;
		if (searchField != null) {
			search_string = searchField.getText();
		}
		try {
			List<Member> members = Member.getMembers(search_string,status_arr);
			model.setDataList(members);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Failed to Load Member List", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void initTable() {
		model = new MemberListTableModel();
        columnModel = new DefaultTableColumnModel();

		TableColumn col1 = new TableColumn(0);
		col1.setHeaderValue("Member Name");
		col1.setCellEditor(new DefaultCellEditor(new JTextField(new JTextFieldLimit(25), "",0)));
		columnModel.addColumn(col1);

		TableColumn col2 = new TableColumn(1);
		col2.setHeaderValue("Number");
		FormattedRenderer mem_num_renderer = new FormattedRenderer();
		mem_num_renderer.setFormatter(new DecimalFormat("00000000"));
		col2.setCellRenderer(mem_num_renderer);
		columnModel.addColumn(col2);

		TableColumn col3 = new TableColumn(2);
		col3.setHeaderValue("Status");
		
		MemberStatus[] statuses = MemberStatus.values();
		MemberStatus[] statuses_not_invalid = Arrays.copyOfRange(statuses, 0, statuses.length - 1);
		JComboBox cbo = new JComboBox(statuses_not_invalid);
		col3.setCellEditor(new DefaultCellEditor(cbo));
		columnModel.addColumn(col3);

		TableColumn col4 = new TableColumn(3);
		col4.setHeaderValue("Street");
		col4.setCellEditor(new DefaultCellEditor(new JTextField(new JTextFieldLimit(25), "",0)));
		columnModel.addColumn(col4);

		TableColumn col5 = new TableColumn(4);
		col5.setHeaderValue("City");
		col5.setCellEditor(new DefaultCellEditor(new JTextField(new JTextFieldLimit(14), "",0)));
		columnModel.addColumn(col5);

		TableColumn col6 = new TableColumn(5);
		col6.setHeaderValue("State");
		col6.setCellEditor(new DefaultCellEditor(new JTextField(new JTextFieldLimit(2), "",0)));
		columnModel.addColumn(col6);

		TableColumn col7 = new TableColumn(6);
		col7.setHeaderValue("Zip");
		col7.setCellEditor(new DefaultCellEditor(new JTextField(new JTextFieldLimit(5), "",0)));
		columnModel.addColumn(col7);

		TableColumn col8 = new TableColumn(7);
		col8.setHeaderValue("Email");
		JTextField emailField = new JTextField(new JTextFieldLimit(128), "", 0);
		emailField.setInputVerifier(new EmailValidator());
		col8.setCellEditor(new DefaultCellEditor(emailField));
		columnModel.addColumn(col8);
	}


	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MemberList().setVisible(true);
			}
		});
	}



	@Action
	public void addButtonClicked() {
		MemberForm memberForm = new MemberForm();
		memberForm.setVisible(true);
		memberForm.addWindowListener(new WindowListener() {

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
			MemberForm memberForm = new MemberForm(val);
			memberForm.setVisible(true);
			memberForm.addWindowListener(new WindowListener() {

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
		if( row == -1)
			return; // no row selected

		int val = (Integer) jTable1.getValueAt(row, 1);
		int response = JOptionPane.showConfirmDialog(null, "Delete Member: " + jTable1.getValueAt(row, 0), null, JOptionPane.YES_NO_OPTION);

		if( response == JOptionPane.YES_OPTION ){
			Member member;
			try {
				member = new Member(val);
				member.delete();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Failed to delete Provider", "error", ERROR);
			}
			reloadData();
		}
	}

	@Action
	public void allCheckBoxChecked() {
		if( allCheckBox.isSelected() == true ){
			activeCheckBox.setSelected(true);
			suspendedCheckBox.setSelected(true);
			cancelledCheckBox.setSelected(true);
			bannedCheckBox.setSelected(true);
		}
		else{
			activeCheckBox.setSelected(false);
			suspendedCheckBox.setSelected(false);
			cancelledCheckBox.setSelected(false);
			bannedCheckBox.setSelected(false);
		}
		reloadData();
	}

	@Action
	public void activeBoxChecked() {
		if( activeCheckBox.isSelected() != true ){
			allCheckBox.setSelected(false);
		}
		checkSelected();
		reloadData();
	}

	@Action
	public void suspendedBoxChecked() {
		if( !suspendedCheckBox.isSelected() )
			allCheckBox.setSelected(false);
		checkSelected();
		reloadData();
	}

	@Action
	public void cancelledBoxChecked() {
		if( !cancelledCheckBox.isSelected() )
			allCheckBox.setSelected(false);
		checkSelected();
		reloadData();
	}

	@Action
	public void bannedBoxChecked() {
		if( !bannedCheckBox.isSelected() )
			allCheckBox.setSelected(false);
		checkSelected();
		reloadData();
	}

	private void checkSelected(){
		if(		activeCheckBox.isSelected() &&
				suspendedCheckBox.isSelected() &&
				cancelledCheckBox.isSelected() &&
				bannedCheckBox.isSelected() )
			allCheckBox.setSelected(true);
	}



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox activeCheckBox;
    private javax.swing.JButton addButton;
    private javax.swing.JCheckBox allCheckBox;
    private javax.swing.JCheckBox bannedCheckBox;
    private javax.swing.JCheckBox cancelledCheckBox;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField searchField;
    private javax.swing.JCheckBox suspendedCheckBox;
    // End of variables declaration//GEN-END:variables

}
