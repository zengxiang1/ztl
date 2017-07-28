package org.zx.database;

public class Field{
    private String fieldName;
    private String fieldType;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    private String remarks;

    public Field(String fieldName, String fieldType, String remarks) {
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.remarks = remarks;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }
}