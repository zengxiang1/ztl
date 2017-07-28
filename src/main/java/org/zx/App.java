package org.zx;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zx.database.DatabaseModel;
import org.zx.database.DbHelper;

import java.io.*;


/**
 * Hello world!
 *
 */
public class App 
{

   private static Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args ) throws Exception{

        DbHelper dbHelper = new DbHelper();
        DatabaseModel databaseModel = dbHelper.warpModel("user");
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_26);
        ClassTemplateLoader classTemplateLoader = new ClassTemplateLoader(App.class,"/controller");
        configuration.setTemplateLoader(classTemplateLoader);
        Template template = configuration.getTemplate("entity.ftl","UTF-8");
        File file = new File(App.class.getResource("/org/zx/entity/User.java").getPath());
        Writer writer = new OutputStreamWriter(new FileOutputStream(file));
        logger.debug(databaseModel.getTableName(),databaseModel);
        template.process(databaseModel,writer);
    }
}
