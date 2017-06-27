package com.cherish.header;
import java.awt.Component;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
/**
 * ���Ժϲ�����ͷ
 * 
 * @author Brad.Wu
 * @version 1.0
 */
@SuppressWarnings("serial")
public class GroupableTableHeader extends JTableHeader {
    private int rowCount = 0;

    private int columnCount = 0;

    private List<Group> groups = new ArrayList<Group>();

    public GroupableTableHeader() {
                                           // ����Ǳ����, ��Ϊ��������϶��е�λ��, ��ôһ�ж��군��.
                                           // �������ʵ���������, ��ôֻ�����Լ�ȥ����, �ҿɲ��������, ����ȥ������
        this.setReorderingAllowed(false);
    }

    /*
     * ���� Javadoc��
     * @see javax.swing.table.JTableHeader#updateUI()
     */
    @Override
    public void updateUI() {
        setUI(new GroupableTableHeaderUI());
    }

    /*
     * ��ȡָ�����е�λ��
     */
    public Rectangle getHeaderRect(int row, int column) {
        Rectangle r = new Rectangle();
        TableColumnModel cm = getColumnModel();

        Group group = this.getGroup(row, column);
        r.height = getHeight();

        if (column < 0) {
            // x = width = 0;
            if (!getComponentOrientation().isLeftToRight()) {
                r.x = getWidthInRightToLeft();
            }
        } else if (column >= cm.getColumnCount()) {
            if (getComponentOrientation().isLeftToRight()) {
                r.x = getWidth();
            }
        } else {
            for (int i = 0; i < group.getColumn(); i++) {
                r.x += cm.getColumn(i).getWidth();
            }
            for (int i = group.getColumn(), j = group.getColumn() + group.getColumnSpan() - 1; i < j; i++) {
                r.width += cm.getColumn(i).getWidth();
            }
            if (!getComponentOrientation().isLeftToRight()) {
                r.x = getWidthInRightToLeft() - r.x - r.width;
            }
            // r.width = cm.getColumn(column).getWidth();
        }
        return r;
    }

    /**
     * ��ȡGroup��Yλ��
     * 
     * @param group
     * @return
     */
    public int getYOfGroup(Group group) {
        int row = group.getRow();
        TableCellRenderer renderer = this.getDefaultRenderer();
        Component comp = renderer.getTableCellRendererComponent(getTable(), group.getHeaderValue(),
                false, false, group.getRow(), group.getColumn());
        return row * comp.getPreferredSize().height;
    }

    /**
     * ��ȡGroup�ĸ߶�
     * 
     * @param group
     * @return
     */
    public int getHeightOfGroup(Group group) {
        int rowSpan = group.getRowSpan();
        TableCellRenderer renderer = this.getDefaultRenderer();
        Component comp = renderer.getTableCellRendererComponent(getTable(), group.getHeaderValue(),
                false, false, group.getRow(), group.getColumn());
        return rowSpan * comp.getPreferredSize().height;
    }

    private int getWidthInRightToLeft() {
        if ((table != null) && (table.getAutoResizeMode() != JTable.AUTO_RESIZE_OFF)) {
            return table.getWidth();
        }
        return super.getWidth();
    }

    /**
     * ����Group
     * 
     * @param group
     */
    public void addGroup(Group group) {
        groups.add(group);
        int row = group.getRow();
        int rowSpan = group.getRowSpan();
        rowCount = Math.max(rowCount, row + rowSpan);
        int column = group.getColumn();
        int columnSpan = group.getColumnSpan();
        columnCount = Math.max(columnCount, column + columnSpan);
    }

    /**
     * �Ƴ�����Group
     */
    public void removeAllGroups() {
        groups.clear();
    }

    /**
     * ��ȡ���е�Group
     * 
     * @return
     */
    public List<Group> getGroups() {
        List<Group> list = new ArrayList<Group>();
        list.addAll(groups);
        return list;
    }

    /**
     * ��ȡָ�����ϵ�Group
     * 
     * @param columnIndex
     * @return
     */
    public List<Group> getGroupsAtColumn(int columnIndex) {
        List<Group> list = new ArrayList<Group>();
        for (Group group : groups) {
            int minColumnIndex = group.getColumn();
            int maxColumnIndex = minColumnIndex + group.getColumnSpan() - 1;
            if (minColumnIndex <= columnIndex && maxColumnIndex >= columnIndex) {
                list.add(group);
            }
        }
        return list;
    }

    /**
     * ��ȡָ�����ϵ�����Group
     * 
     * @param rowIndex
     * @return
     */
    public List<Group> getGroupsAtRow(int rowIndex) {
        List<Group> list = new ArrayList<Group>();
        for (Group group : groups) {
            int minRowIndex = group.getRow();
            int maxRowIndex = minRowIndex + group.getRowSpan() - 1;
            if (minRowIndex <= rowIndex && maxRowIndex >= rowIndex) {
                list.add(group);
            }
        }
        return list;
    }

    /**
     * ��ȡ����
     * 
     * @return
     */
    public int getRowCount() {
        return this.rowCount;
    }

    /**
     * @return Returns the columnCount.
     */
    public int getColumnCount() {
        return this.columnCount;
    }

    @Override
    public void setTable(JTable table) {
        super.setColumnModel(table.getColumnModel());
        super.setTable(table);
    }

    /**
     * ��ȡָ�����е�Group
     * @param row
     * @param column
     * @return
     */
    public Group getGroup(int row, int column) {
        for (Group group : groups) {
            int rowIndex = group.getRow();
            int columnIndex = group.getColumn();
            int rowSpan = group.getRowSpan();
            int columnSpan = group.getColumnSpan();
            if (rowIndex <= row && rowIndex + rowSpan > row && columnIndex <= column
                    && columnIndex + columnSpan > column)
                return group;
        }
        return null;
    }

    @Override
    protected TableCellRenderer createDefaultRenderer() {
        return new TableHeaderRenderer();
    }
}
