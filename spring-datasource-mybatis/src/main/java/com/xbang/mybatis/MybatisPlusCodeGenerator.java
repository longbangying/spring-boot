package com.xbang.mybatis;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MybatisPlusCodeGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();
        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        //设置输出路径
        globalConfig.setOutputDir(projectPath + "/spring-datasource-mybatis/src/main/java").setAuthor("xbang").setOpen(false);
        globalConfig.setFileOverride(true);

        globalConfig.setBaseResultMap(true);
        globalConfig.setBaseColumnList(true);
        globalConfig.setActiveRecord(true);
        autoGenerator.setGlobalConfig(globalConfig);

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL).setDriverName("com.mysql.jdbc.Driver").setUsername("root")
                .setPassword("Soar18786611964_").setUrl("jdbc:mysql://192.168.153.128:3306/java_db?useUnicode=true&characterEncoding=gbk&zeroDateTimeBehavior=convertToNull&useSSL=false");
        autoGenerator.setDataSource(dataSourceConfig);

        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.xbang.mybatis");
        packageConfig.setMapper("dao.mapper");
        packageConfig.setEntity("dao.entity");
        packageConfig.setService("service.face");
        packageConfig.setServiceImpl("service.impl");
        packageConfig.setController("controller");
        packageConfig.setXml("dao.xml");
        autoGenerator.setPackageInfo(packageConfig);

        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(false);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);

        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setEntityTableFieldAnnotationEnable(true);
        strategyConfig.setInclude("t_user_info"); //需要生成的表名

        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.execute();

    }
}
