package GUI;

import java.awt.Component;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class DefaultTableCellNhaCungCap extends DefaultTableCellRenderer implements TableCellRenderer{

	DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
	SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");

    TableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {
		/**
		 * 
		 */
    	
		private static final long serialVersionUID = 1L;
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");

		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if( value instanceof Date) {
				value = f.format(value);
			}
			return super.getTableCellRendererComponent(table, value, isSelected,
					hasFocus, row, column);
		}

	};

	/*
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		
		if( value instanceof SimpleDateFormat) {
			value = f.format(value);
		}
		table.setAutoCreateRowSorter(true);		
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}	
   */
}
