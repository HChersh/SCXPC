package com.cherish.header;
/**
 * Ĭ��Groupʵ��
 * 
 * @author Brad.Wu
 * @version 1.0
 */
public class DefaultGroup implements Group {
    private int row = 0;

    private int column = 0;

    private int rowSpan = 1;

    private int columnSpan = 1;

    private Object headerValue = null;

    /*
     * ���� Javadoc��
     * 
     * @see com.eplat.realty.view.component.table.Group#getRow()
     */
    public int getRow() {
        return this.row;
    }

    /**
     * @param row Ҫ���õ� row��
     */
    public void setRow(int row) {
        this.row = row;
    }

    /*
     * ���� Javadoc��
     * 
     * @see com.eplat.realty.view.component.table.Group#getColumn()
     */
    public int getColumn() {
        return this.column;
    }

    /**
     * @param column Ҫ���õ� column��
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /*
     * ���� Javadoc��
     * 
     * @see com.eplat.realty.view.component.table.Group#getColumnSpan()
     */
    public int getColumnSpan() {
        return this.columnSpan;
    }

    /**
     * @param columnSpan Ҫ���õ� columnSpan��
     */
    public void setColumnSpan(int columnSpan) {
        this.columnSpan = columnSpan;
    }

    /*
     * ���� Javadoc��
     * 
     * @see com.eplat.realty.view.component.table.Group#getRowSpan()
     */
    public int getRowSpan() {
        return this.rowSpan;
    }

    /**
     * @param rowSpan Ҫ���õ� rowSpan��
     */
    public void setRowSpan(int rowSpan) {
        this.rowSpan = rowSpan;
    }

    /*
     * ���� Javadoc��
     * 
     * @see com.eplat.realty.view.component.table.Group#getHeaderValue()
     */
    public Object getHeaderValue() {
        return this.headerValue;
    }

    /**
     * @param headerValue Ҫ���õ� headerValue��
     */
    public void setHeaderValue(Object headerValue) {
        this.headerValue = headerValue;
    }
}