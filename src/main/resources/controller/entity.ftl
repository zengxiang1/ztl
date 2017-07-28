<#list types as type>
import ${type}
</#list>

public class ${tableName}{
    <#list fields as field>
    private ${field.fieldType} ${field.fieldName};
    </#list>

    <#list fields as field>
    public void set${field.fieldName?cap_first }(${field.fieldType } ${field.fieldName} ){
        this.${field.fieldName} = ${field.fieldName}
    }

    public ${field.fieldType } get${field.fieldName?cap_first }(){
        return this.${field.fieldName};
    }
    </#list>
}