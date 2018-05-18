package cn.sdkd.ccse.cise.ces;

import cn.sdkd.ccse.cise.ces.pojo.Similarity;
import cn.sdkd.ccse.cise.ces.pojo.SimilarityPair;
import cn.sdkd.ccse.cise.ces.similarity.ServiceFacade;
import cn.sdkd.ccse.cise.ces.similarity.SimilarityFactory;
import cn.sdkd.ccse.cise.ces.similarity.SimilarityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sam on 2018/5/17.
 */
public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    /* 获取文本 */
    /* 计算相似度 */
    /* 输出结果*/
    public static void checkExperimentSimilarity(String dirRealPath) {
        byte type = 0;

        File file = new File(dirRealPath);
        File[] files = file.listFiles();
        ArrayList<HashMap<String, ArrayList<String>>> resList =  new ArrayList<HashMap<String, ArrayList<String>>>();
        //获取word内容、分词
        LOGGER.info("--------开始获取内容并分词-------");
        ServiceFacade serviceFacade = new ServiceFacade();

        serviceFacade.multiThreadHandleWords(files, resList);

        LOGGER.info("-------获取内容并分词结束--------");
        LOGGER.info("-------开始分析相似度--------");
        //获取相似度实例
        SimilarityService simiService = SimilarityFactory.getSimiralityType(type);
        //多线程分析相似度
        List<SimilarityPair> res = simiService.analyseSimilaritySingleThread(resList);
        LOGGER.info("-------分析相似度结束-------");
    }

    /**
     *
     * @param dirRealPath 文件目录
     * @param type 算法类型：0共有词汇，1cos相似度，2simhash
     */
    public static void checkExperimentSimilaritySingleThread(String dirRealPath, byte type) {

        File file = new File(dirRealPath);
        File[] files = file.listFiles();
        ArrayList<HashMap<String, ArrayList<String>>> resList =  new ArrayList<HashMap<String, ArrayList<String>>>();
        //获取word内容、分词
        LOGGER.info("--------开始获取内容并分词-------");
        ServiceFacade serviceFacade = new ServiceFacade();

        serviceFacade.singleThreadHandleWords(files, resList);

        LOGGER.info("-------获取内容并分词结束--------");
        LOGGER.info("-------开始分析相似度--------");
        //获取相似度实例
        SimilarityService simiService = SimilarityFactory.getSimiralityType(type);
        //多线程分析相似度
        List<SimilarityPair> res = simiService.analyseSimilaritySingleThread(resList);
        LOGGER.info("-------分析相似度结束-------");
    }
    public static void main(String[] args) {
        String path = "E:\\IntelliJ_IDEA_workspace\\check-similarity\\src\\main\\webapp\\files\\ThuMay17100709CST2018";
        path = "G:\\360云盘工作目录\\计算机同步文件夹\\工作目录\\教学\\数据库设计\\计算机15数据库设计实验\\实验0 数据库任务陈述与系统定义";
        byte type = 2;

        checkExperimentSimilaritySingleThread(path, type);
//        checkExperimentSimilarity(path);
    }
}
