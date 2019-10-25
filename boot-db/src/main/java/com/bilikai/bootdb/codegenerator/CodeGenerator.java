package com.bilikai.bootdb.codegenerator;



import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lhw<br>
 * @version 1.0<br>
 * @Description <Description> <br>
 * @taskId: <br>
 * @createDate 2019/10/25 9:15 <br>
 * @see com.bilikai.bootdb.codegenerator <br>
 */
public class CodeGenerator {
	public static String scanner(String tip){
		Scanner scanner =new Scanner(System.in);
		StringBuilder strBuilder =new StringBuilder();
		strBuilder.append("请输入"+tip+":");
		System.out.println(strBuilder.toString());
		if (scanner.hasNext()){
			String ipt =scanner.next();
			if (StringUtils.isNotEmpty(ipt)){
				return ipt;
			}
		}
		throw new MybatisPlusException("请输入正确的" + tip + "！");
	}

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		//代码生成器
		AutoGenerator autoGenerator = new AutoGenerator();
		//全局配置
		GlobalConfig globalConfig = new GlobalConfig();
		//String projectPath=System.getProperty("E:\\boot-sw\\boot-db");
		String projectPath="E:/boot-sw/boot-db";
		globalConfig.setOutputDir(projectPath+"/src/main/java");
		globalConfig.setAuthor("long");
		globalConfig.setOpen(false);
		globalConfig.setSwagger2(true);//
		autoGenerator.setGlobalConfig(globalConfig);

		//数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setUrl("jdbc:mysql://127.0.0.1:3306/user?useUnicode=true&useSSL=false&characterEncoding=utf8");
		dsc.setDriverName("com.mysql.cj.jdbc.Driver");//
		dsc.setUsername("root");
		dsc.setPassword("123456789");
		autoGenerator.setDataSource(dsc);

		//包配置
		PackageConfig packagec =new PackageConfig();
		packagec.setModuleName("accounts");//模块名：
		packagec.setParent("com.bilikai.boot");//项目包路径
		autoGenerator.setPackageInfo(packagec);

		// 自定义配置
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				// to do nothing
			}
		};

		// 如果模板引擎是 freemarker
		String templatePath = "/templates/mapper.xml.ftl";
		// 如果模板引擎是 velocity
		// String templatePath = "/templates/mapper.xml.vm";


		// 自定义输出配置
		List<FileOutConfig> focList = new ArrayList<>();
		// 自定义配置会被优先输出
		focList.add(new FileOutConfig(templatePath) {
			@Override
			public String outputFile(TableInfo tableInfo) {
				// 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
				return projectPath + "/src/main/resources/mapper/" + packagec.getModuleName()
						+ "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
			}
		});
		cfg.setFileOutConfigList(focList);
		autoGenerator.setCfg(cfg);

		// 配置模板
		TemplateConfig templateConfig = new TemplateConfig();

		// 配置自定义输出模板
		//指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
		// templateConfig.setEntity("templates/entity2.java");
		// templateConfig.setService();
		// templateConfig.setController();

		templateConfig.setXml(null);
		autoGenerator.setTemplate(templateConfig);

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setNaming(NamingStrategy.underline_to_camel);
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
		strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
		strategy.setEntityLombokModel(true);
		strategy.setRestControllerStyle(true);
		// 公共父类
		strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
		// 写于父类中的公共字段
		strategy.setSuperEntityColumns("id");
		strategy.setInclude(scanner("accounts").split(","));
		strategy.setControllerMappingHyphenStyle(true);
		strategy.setTablePrefix(packagec.getModuleName() + "_");
		autoGenerator.setStrategy(strategy);
		autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
		autoGenerator.execute();

	}
}
