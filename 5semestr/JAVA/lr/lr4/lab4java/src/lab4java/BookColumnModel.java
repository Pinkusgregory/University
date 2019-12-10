package lab4java;

import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import java.lang.reflect.Field;

public class BookColumnModel extends DefaultTableColumnModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	public BookColumnModel(Class tClass, String[] headers) {
		int i = 0;
        for (Field tField : tClass.getDeclaredFields()){
            TableColumn tColumn = new TableColumn();
            tColumn.setHeaderValue(headers[i]);
            tColumn.setModelIndex(getColumnCount());
            tColumn.setIdentifier(tField);
            tField.setAccessible(true);
            this.addColumn(tColumn);
            i++;
        }
    }
}