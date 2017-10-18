package com.hxqh.eam.generate;

import com.hxqh.eam.common.FileUtil;
import com.hxqh.eam.common.LetterUtil;

import java.io.*;

/**
 * 生成字段类
 *
 * @author lh
 */
public class GenerateClass {


    private static final String VIEWMODEL = "import com.hxqh.eam.model.";
//    private static final String VIEWMODEL = "import com.hxqh.eam.model.view.";
    private static final String MODEL = "import com.hxqh.eam.model.";
    private static final String DATE = "2017-7-20 ";
    private static final String DAO = "import com.hxqh.eam.dao.";

    public static void main(String[] args) throws IOException {
        generateDaoCode();
        //generateControllerAndServiceCode("enterprise", "view");
    }


    /**
     * 生成Controller 页面跳转代码
     */
    private static void generateControllerAndServiceCode(String model, String view) {
        File controllerTemplate = new File("src/test/resources/controller.property");
        File controllerMethod = new File("src/test/resources/controllerMethod.property");
        File serviceTemplate = new File("src/test/resources/service.property");
        File serviceMethod = new File("src/test/resources/serviceMethod.property");

        File serviceImpTemplate = new File("src/test/resources/serviceImpl.property");
        File serviceImplMethod = new File("src/test/resources/serviceImplMethod.property");
        File serviceImplDeclare = new File("src/test/resources/serviceImplDeclare.property");


        //功能列表
        File func = new File("src/test/resources/func.list");
        String s = FileUtil.txt2String(func);

        String[] functionAll = s.split("\r\n");

        StringBuilder impModel = new StringBuilder(60);

        StringBuilder impDao = new StringBuilder(1024);
        StringBuilder methodPageAndData = new StringBuilder(1024);

        StringBuilder methodService = new StringBuilder(1024);
        StringBuilder methodServiceImpl = new StringBuilder(1024);
        StringBuilder methodServiceImplDeclare = new StringBuilder(1024);

        int i = 0;
        for (String fun : functionAll) {
            if (i == 0) {
                i++;
                continue;
            }
            controllerMethodString(model, controllerMethod, methodPageAndData, fun);
            impCodeString(view, impModel, fun);

            impDao.append(DAO).append(fun).append("Dao").append(";").append("\r\n");

            serviceMethodString(serviceMethod, methodService, fun);
            serviceImplString(model, serviceImplMethod, methodServiceImpl, fun);
            serviceDeclareString(model, serviceImplDeclare, methodServiceImplDeclare, fun);


        }

        persistController(model, controllerTemplate, impModel, methodPageAndData);
        persistService(model, serviceTemplate, impModel, methodService);
        persistServiceImpl(model, serviceImpTemplate, impModel, impDao, methodServiceImpl, methodServiceImplDeclare);


    }

    private static void serviceImplString(String model, File serviceImplMethod, StringBuilder methodServiceImpl, String fun) {
        //去掉首字母并将首字母小写
        String firstLetterSubString = LetterUtil.firstLetterSubStringAndToLowercase(fun);

        //Method
        String method = FileUtil.txt2String(serviceImplMethod).
                replace("_GET_", "get" + firstLetterSubString + "Data").
                replaceAll("_RAW_", fun).
                replaceAll("_FUNCTION_", firstLetterSubString);

        methodServiceImpl.append(method);
    }


    private static void serviceDeclareString(String model, File serviceImplDeclare, StringBuilder methodServiceImplDeclare, String fun) {
        String firstLetterSubString = LetterUtil.firstLetterSubStringAndToLowercase(fun);
        //Method
        String method = FileUtil.txt2String(serviceImplDeclare).
                replaceAll("_RAW_", fun).
                replaceAll("_FUNCTION_", firstLetterSubString);

        methodServiceImplDeclare.append(method);
    }

    private static void persistServiceImpl(String model, File serviceImpTemplate, StringBuilder impModel,
                                           StringBuilder impDao, StringBuilder methodServiceImpl,
                                           StringBuilder methodServiceImplDeclare) {
        //处理ServiceImpl主类 并持久化
        String modelName = LetterUtil.firstLetterToUpper(model);
        String templateServiceImpl = FileUtil.txt2String(serviceImpTemplate)
                .replaceAll("_IMPORT_MODEL_", impModel.toString())
                .replaceAll("_DAOLIST_", impDao.toString())
                .replaceAll("_DATE_", DATE)
                .replaceAll("_model_", model)
                .replaceAll("_MODEL_", modelName)
                .replaceAll("METHOD", methodServiceImpl.toString())
                .replace("DECLARE", methodServiceImplDeclare.toString());

        FileUtil.WriteStringToFile("src/" + modelName + "ServiceImpl" + ".java", templateServiceImpl);
    }



    private static void persistService(String model, File serviceTemplate, StringBuilder impModel, StringBuilder methodService) {
        //处理Service主类 并持久化
        String modelName = LetterUtil.firstLetterToUpper(model);
        String templateService = FileUtil.txt2String(serviceTemplate)
                .replaceAll("_IMPORT_MODEL_", impModel.toString())
                .replaceAll("_MODEL_", modelName)
                .replaceAll("_DATE_", DATE)
                .replaceAll("METHOD", methodService.toString());

        FileUtil.WriteStringToFile("src/" + modelName + "Service" + ".java", templateService);
    }

    private static void serviceMethodString(File serviceMethod, StringBuilder methodService, String fun) {
        //去掉首字母并将首字母小写
        String firstLetterSubString = LetterUtil.firstLetterSubStringAndToLowercase(fun);

        //Method
        String method = FileUtil.txt2String(serviceMethod).
                replace("_GET_", "get" + firstLetterSubString + "Data").
                replaceAll("_RAW_", fun);

        methodService.append(method);
    }

    private static void persistController(String model, File controllerTemplate, StringBuilder impModel, StringBuilder methodPageAndData) {
        //处理Controller主类 并持久化
        String modelName = LetterUtil.firstLetterToUpper(model);
        String templateController = FileUtil.txt2String(controllerTemplate)
                .replaceAll("_IMPORT_MODEL_", impModel.toString())
                .replaceAll("_MODEL_", modelName)
                .replaceAll("_model_", model)
                .replaceAll("_DATE_", DATE)
                .replaceAll("METHOD", methodPageAndData.toString());

        //System.out.println(template);
        FileUtil.WriteStringToFile("src/" + modelName + "Controller" + ".java", templateController);
    }

    private static void impCodeString(String view, StringBuilder impModel, String fun) {
        //import
        if (view.equals("view"))
            impModel.append(VIEWMODEL + fun).append(";").append("\r\n");
        else
            impModel.append(MODEL + fun).append(";").append("\r\n");
    }

    private static void controllerMethodString(String model, File controllerMethod, StringBuilder methodPageAndData, String fun) {
        //去掉首字母并将首字母小写
        String firstLetterSubString = LetterUtil.firstLetterSubStringAndToLowercase(fun);

        //Method
        String method = FileUtil.txt2String(controllerMethod).
                replaceAll("_FUNCTION_", firstLetterSubString).
                replaceAll("_model_", model).
                replaceAll("_DATA_", firstLetterSubString + "Data").
                replace("_GET_", "get" + firstLetterSubString + "Data").
                replaceAll("_RAW_", fun);

        methodPageAndData.append(method);
    }


    /**
     * 生成Dao模块
     */
    private static void generateDaoCode() {
        File mboFile = new File("src/test/resources/dao.property");
        File daoImpl = new File("src/test/resources/daoImpl.property");

        //生成Mbo实体
        File file = new File("src/test/resources/table.list");
        String s = FileUtil.txt2String(file);
        //        System.out.println(s);
        String[] mBOName = s.split("\r\n");

        int i = 0;
        for (String string : mBOName) {
            if (i == 0) {
                i++;
                continue;
            }
            String mboStr = FileUtil.txt2String(mboFile).replaceAll("XXXXX", string + "Dao").replaceAll("YYYYY", string);
            FileUtil.WriteStringToFile("src/" + string + "Dao" + ".java", mboStr);

            //daoImpl
            StringBuilder sb = new StringBuilder(string);
            sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
            String daoImplStr = FileUtil.txt2String(daoImpl).replaceAll("XXXX", string + "Dao").replaceAll("YYYY", string)
                    .replaceAll("ZZZZ", string + "DaoImpl").replaceAll("WWWW", sb.toString() + "Dao");
            FileUtil.WriteStringToFile("src/" + string + "DaoImpl" + ".java", daoImplStr);
            i++;
        }

        System.out.println("Generate Success!");
    }


}
