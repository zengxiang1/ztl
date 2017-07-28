package org.zx.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/28.
 */
public class DatabaseModel {
    private String tableName;

    private List<Field> fields;

    private List<String> types;

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public DatabaseModel() {
        fields = new ArrayList<Field>();
        types  = new ArrayList<String>();
    }

    public void addTypes(String type){
        type = type.trim();
        for (String typeTemp :types){
            if(typeTemp.equals(type)){
                return;
            }else{
             continue;
            }
        }
        types.add(type);
    }

    public void addField(String fieldName,String type,String remark){
        this.fields.add(new Field(fieldName,type,remark));
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }


}


