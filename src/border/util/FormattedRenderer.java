package border.util;

import java.text.Format;

import javax.swing.table.DefaultTableCellRenderer;

public class FormattedRenderer
	extends
	DefaultTableCellRenderer {
	
	private static final long serialVersionUID = 5246937088298071463L;
	private Format formatter;
	
	public void setValue(Object value) {
        setText((value == null) ? "" : formatter.format(value));
    }

	public Format getFormatter() {
		return formatter;
	}

	public void setFormatter(
		Format formatter) {
		this.formatter = formatter;
	}

}
