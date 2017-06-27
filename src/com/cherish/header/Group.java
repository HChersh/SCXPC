package com.cherish.header;
public interface Group {
    /**
     * ��ȡ������
     * 
     * @return
     */
    public int getRow();

    /**
     * ��ȡ������
     * 
     * @return
     */
    public int getColumn();

    /**
     * ��ȡռ�и���
     * 
     * @return
     */
    public int getColumnSpan();

    /**
     * ��ȡռ�и���
     * 
     * @return
     */
    public int getRowSpan();

    /**
     * ��ȡ����
     * 
     * @return
     */
    public Object getHeaderValue();
}