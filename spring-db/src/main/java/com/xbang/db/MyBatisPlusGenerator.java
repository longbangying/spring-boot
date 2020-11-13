package com.xbang.db;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * Description  mybatis plus 自动生成代码
 *
 * @author admin
 * @version: 1.0
 * create date: 2020/10/26
 * update date: 2020/10/26
 */
public class MyBatisPlusGenerator {

    public static void main(String[] args) {
        //代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();
        //配置
        GlobalConfig  globalConfig = new GlobalConfig();
        //项目路径  到父项目的POM文件那一级
        String modeName = "spring-jta";
        String basePackage= "com.xbang.jta";
        String projectPath = System.getProperty("user.dir") + "/" + modeName;
        globalConfig.setOutputDir(projectPath+"/src/main/java");
        globalConfig.setAuthor("admin");
        globalConfig.setOpen(false);
        autoGenerator.setGlobalConfig(globalConfig);
        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://47.104.171.254:3306/java_db?useUnicode=true&characterEncoding=gbk&zeroDateTimeBehavior=convertToNull&useSSL=false");
        dataSourceConfig.setUsername("java_opr");
        dataSourceConfig.setPassword("Soar18786611964!");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setDbType(DbType.MYSQL);
        autoGenerator.setDataSource(dataSourceConfig);
        //包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(basePackage);
        packageConfig.setMapper("dao.mapper");
        packageConfig.setEntity("dao.entity");
        autoGenerator.setPackageInfo(packageConfig);
        //自定义配置
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                //do nothing
            }
        };

        List<FileOutConfig> fileOutConfigList = new ArrayList<>();
        String templatePath = "/templates/mapper.xml.ftl";
        fileOutConfigList.add(new FileOutConfig(templatePath){
            @Override
            public String outputFile(TableInfo tableInfo) {
                //自定义输出文件，如果entity设置了前后缀，此处主义xml的名称也会跟着变化
                return projectPath + "/src/main/resources/mapper"+ packageConfig.getModuleName() + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        injectionConfig.setFileOutConfigList(fileOutConfigList);
        autoGenerator.setCfg(injectionConfig);

        //配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        autoGenerator.setTemplate(templateConfig);

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setTablePrefix("t_");
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setControllerMappingHyphenStyle(true);
        //表名
        strategyConfig.setInclude("t_user_info");
        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        autoGenerator.execute();
    }
}
