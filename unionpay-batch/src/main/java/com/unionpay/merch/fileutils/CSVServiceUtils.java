package com.unionpay.merch.fileutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.unionpay.merch.model.ICqpMerchantInfoModel;
import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.common.processor.BeanWriterProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;

/**
 * 
 * <p>Title: CSVServiceUtils</p>
 * <p>Description:生成CSV文件工具类</p>
 * <p>Company: eh</p>
 * @author li liang zhong
 * @date 2019年3月26日 下午2:53:36
 * @version 1.0
 *
 */
public class CSVServiceUtils
{
	private static final Logger logger = LoggerFactory.getLogger(CSVServiceUtils.class);
    
	/**
	 * <p>Title: core</p>
	 * <p>Description: 通过框架-</p>
	 * @param out  --文件输出流(文件输出的位置)
	 * @param sourceList  --实体类集合(转化为文件行数据集合)
	 * @param classType   --实体类型
	 * @param characterEncode --文件写入编码格式
	 * boolean --true:成功 ; false:失败
	 * @author li liang zhong
	 * @date 2019年3月26日 下午2:57:25
	 * @version 1.0
	 */
	public static <T, U> boolean export(OutputStream out, List<T> sourceList,
			Class<U> classType, String characterEncode)
	{
		List<U> targetList = new ArrayList<>();
		CsvWriterSettings settings = new CsvWriterSettings();
		BeanWriterProcessor<U> beanWriterProcessor = new BeanWriterProcessor<>(classType);
		settings.setRowWriterProcessor(beanWriterProcessor);
		CsvWriter writer = new CsvWriter(out, Charset.forName(characterEncode), settings);
		writer.writeHeaders();
		if (sourceList == null)
		{
			writer.close();
			return false;
		}
		try
		{
			for (T t : sourceList)
			{
				U u = classType.newInstance();
				BeanUtils.copyProperties(t, u);
				targetList.add(u);
			}
			targetList.forEach(writer::processRecord);
		} catch (Exception e)
		{
			logger.error("生成CSV文件失败", e);
		} finally
		{
			if (writer != null)
				writer.close();
		}
		return true;
	}
	
	/**
	 * 
	 * <p>Title: core</p>
	 * <p>Description:读取CSV文件并转化为</p>
	 * @param filePath
	 * @param characterEncode
	 * @param clazz
	 * @return
	 * @throws IOException
	 * List<T>
	 * @author li liang zhong
	 * @date 2019年3月26日 下午4:35:59
	 * @version 1.0
	 */
//	public static <T, U> List<RatingScaleModel> readCSVDev(String filePath,
//			String characterEncode, RatingScaleModel ratingScaleModel) throws IOException
//	{
//		InputStream in = null;
//	    InputStreamReader reader = null;
//	    List<RatingScaleModel> resolvedBeans = new ArrayList<RatingScaleModel>();
//	    List<String[]> listStr = null;
//	    try
//	    {
//	    	long startTime = System.currentTimeMillis();
//	    	File file = new File(filePath);
//			in = new FileInputStream(file);
//		    reader = new InputStreamReader(in, characterEncode);
//		    RowListProcessor  rowProcessor = new RowListProcessor();
//	    	CsvParserSettings settings = new CsvParserSettings();
//	        settings.setHeaderExtractionEnabled(true);
//	        settings.setProcessor(rowProcessor);
//	        settings.getFormat().setLineSeparator("\n");
//	        CsvParser parser = new CsvParser(settings);
//	        parser.parse(reader);
//	        long halfwayTime = System.currentTimeMillis();
//	        logger.info("读取csv文件耗时====>" + (halfwayTime-startTime) + " 毫秒");
//	        listStr = rowProcessor.getRows();
//	        for(int index = 0; index < listStr.size(); index++)
//	        {
//	        	String[] row = listStr.get(index);
//	        	ratingScaleModel = new RatingScaleModel();
//	        	ratingScaleModel.setResultId(Integer.valueOf(row[0]));
//	        	ratingScaleModel.setBatchNo(row[1]);
//	        	ratingScaleModel.setMchntNo(row[2]);
//	        	ratingScaleModel.setMchntName(row[3]);
//	        	ratingScaleModel.setScorecardId(Integer.valueOf(row[4]));
//	        	ratingScaleModel.setTotalScore(Integer.valueOf(row[5]));
//	        	ratingScaleModel.setMchntGrade(Integer.valueOf(row[6]));
//	        	ratingScaleModel.setGradeTime(row[7]);
//	        	ratingScaleModel.setGradeType(row[8]);
//	        	ratingScaleModel.setPolicyId(row[9]);
//	        	ratingScaleModel.setGradeOrgId(row[10]);
//	        	resolvedBeans.add(ratingScaleModel);
//	        }
//	        if(in != null)
//	        	in.close();
//	        if(reader != null)
//	        	reader.close();
//	        long endTime = System.currentTimeMillis();
//	        logger.info("读取csv文件总耗时===>[" + (endTime-startTime) + "]毫秒");
//	    }
//		catch(Exception e)
//	    {
//			logger.error("读取csv文件失败");
//			e.printStackTrace();
//	    }
//	    finally
//	    {
//	    	if(in != null)
//	    		in.close();
//	    	if(reader != null)
//	    		reader.close();
//	    }
//        return resolvedBeans;
//    }
	
	/**
	 * 
	 * <p>Title: core</p>
	 * <p>Description:读取CSV文件并转化为对象集合</p>
	 * @param filePath
	 * @param characterEncode
	 * @param clazz
	 * @return
	 * @throws IOException
	 * List<T>
	 * @author li liang zhong
	 * @date 2019年3月26日 下午4:35:59
	 * @version 1.0
	 */
	public static <T, U> List<T> readCSV(String filePath,
			String characterEncode, Class<T> clazz) throws IOException
	{
		InputStream in = null;
	    InputStreamReader reader = null;
	    List<T> resolvedBeans = null;
	    long startTime = System.currentTimeMillis();
	    try
	    {
	    	File file = new File(filePath);
			in = new FileInputStream(file);
		    reader = new InputStreamReader(in, characterEncode);
	    	CsvParserSettings parserSettings = new CsvParserSettings();
	    	parserSettings.getFormat().setLineSeparator("\n");
	    	parserSettings.setHeaderExtractionEnabled(true);
	        BeanListProcessor<T> rowProcessor = new BeanListProcessor<T>(clazz);
	        parserSettings.setProcessor(rowProcessor);
	        CsvParser parser = new CsvParser(parserSettings);
	        parser.parseAll(reader);
	        long halfwayTime = System.currentTimeMillis();
	        logger.info("读取csv文件耗时===>" + (halfwayTime-startTime) + " 毫秒");
	        resolvedBeans = rowProcessor.getBeans();
	        if(in != null)
	        	in.close();
	        if(reader != null)
	        	reader.close();
	        long endTime = System.currentTimeMillis();
	        logger.info("读取文件总耗时===>【" + (endTime-startTime) + "】毫秒");
	    }
		catch(Exception e)
	    {
			logger.error("读取csv文件失败，文件路径为======>" + filePath);
			e.printStackTrace();
	    }
	    finally
	    {
	    	if(in != null)
	    		in.close();
	    	if(reader != null)
	    		reader.close();
	    }
        return resolvedBeans;
    }
	
	public static void main(String[] args) throws ParseException, IOException
	{
		int handNum = 2000000;
		long startTime = System.currentTimeMillis();
		//String filePath = "d:\\baseTest.csv";
        String filePath = "d:\\merchInfo.csv";
//		File file = new File(filePath);
//		OutputStream out = new FileOutputStream(file);
//		List<ICqpMerchantInfoModel> listModels = new ArrayList<ICqpMerchantInfoModel>();
//		String orgCode = "03060000";
//		for (int i = 0; i < handNum; i++)
//		{
//			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			ICqpMerchantInfoModel iCqpMerchantInfoModel = new ICqpMerchantInfoModel();
//			iCqpMerchantInfoModel.setAcqMerId(String.valueOf(System.currentTimeMillis()));
//			iCqpMerchantInfoModel.setAcqOrgCode("03060000");
//			iCqpMerchantInfoModel.setAcquiringAgreementPhoto("m.png");
//			iCqpMerchantInfoModel.setAlipayChannelId("28625478");
//			iCqpMerchantInfoModel.setArea("110561");
//			iCqpMerchantInfoModel.setAuthorizedCertPhotoBack("morg.png");
//			iCqpMerchantInfoModel.setAuthorizedCertPhotoFront("horg.png");
//			iCqpMerchantInfoModel.setAuthorizedPersonCertNo("10120190327");
//			iCqpMerchantInfoModel.setAuthorizedPersonCertType("10");
//			iCqpMerchantInfoModel.setBankCardPhotoBack("Mkard.png");
//			iCqpMerchantInfoModel.setBankCardPhotoFront("Hkard.png");
//			iCqpMerchantInfoModel.setBankCardRateLevel1("10");
//			iCqpMerchantInfoModel.setBankCardRateLevel2("12");
//			iCqpMerchantInfoModel.setBusinessAddress("广东省广州市天河区建中路");
//			iCqpMerchantInfoModel.setBusinessLicenseCode("10023056");
//			iCqpMerchantInfoModel.setBusinessLicenseExpired("建设树");
//			iCqpMerchantInfoModel.setBusinessLicenseName("建树");
//			iCqpMerchantInfoModel.setBusinessLicensePhoto("j.png");
//			iCqpMerchantInfoModel.setCity("110567");
//			iCqpMerchantInfoModel.setContactPerson("李生");
//			iCqpMerchantInfoModel.setContactPhone("18797903448");
//			iCqpMerchantInfoModel.setEmail("83678049@qq.com");
//			iCqpMerchantInfoModel.setFeeRateAlipay("0.3");
//			iCqpMerchantInfoModel.setFeeRateUnionpayCredit("0.1");
//			iCqpMerchantInfoModel.setFeeRateUnionpayDebit("0.6");
//			iCqpMerchantInfoModel.setFeeRateWechatpay("0.3");
//			iCqpMerchantInfoModel.setIndustryCategoryId("102564");
//			iCqpMerchantInfoModel.setLawyerCertNo(String.valueOf(System.currentTimeMillis()));
//			iCqpMerchantInfoModel.setLawyerCertPhotoBack("ml.png");
//			iCqpMerchantInfoModel.setLawyerCertPhotoFront("hl.png");
//			iCqpMerchantInfoModel.setLawyerCertType("13");
//			iCqpMerchantInfoModel.setLawyerName("发卡机构");
//			iCqpMerchantInfoModel.setMchntCd(String.valueOf(System.currentTimeMillis()));
//			iCqpMerchantInfoModel.setMerchantName("上海智能识别股份有限公司");
//			iCqpMerchantInfoModel.setMerchantTyp("102");
//			iCqpMerchantInfoModel.setMerId(String.valueOf(System.currentTimeMillis()));
//			iCqpMerchantInfoModel.setOpenBank("广发银行广州分行");
//			iCqpMerchantInfoModel.setOpenBankCode("03063214");
//			iCqpMerchantInfoModel.setOpenBankReservePhone("13592405516");
//			iCqpMerchantInfoModel.setOpeningLicenseAccountPhoto("am.png");
//			iCqpMerchantInfoModel.setOpenSubBank("广发银行广州支行");
//			iCqpMerchantInfoModel.setProvince("1005618");
//			iCqpMerchantInfoModel.setReqReserved("102346");
//			iCqpMerchantInfoModel.setReserve1("67543");
//			iCqpMerchantInfoModel.setSerProvId("105897");
//			iCqpMerchantInfoModel.setServiceTel("18797903500");
//			iCqpMerchantInfoModel.setSettleAccount("李生");
//			iCqpMerchantInfoModel.setSettleAccountNo("623514698745121");
//			iCqpMerchantInfoModel.setSettleAccountType("15");
//			iCqpMerchantInfoModel.setSettleAuthLetterPhoto("54687");
//			iCqpMerchantInfoModel.setSettlePeriod("502");
//			iCqpMerchantInfoModel.setStoreCashierPhoto("zj.png");
//			iCqpMerchantInfoModel.setStoreHallPhoto("sh.png");
//			iCqpMerchantInfoModel.setStoreHeadPhoto("sd.png");
//			iCqpMerchantInfoModel.setStoreShopPhoto("ss.png");
//			iCqpMerchantInfoModel.setWechatChannelId("10216587");
//			listModels.add(iCqpMerchantInfoModel);
//		}
//		long endTime = System.currentTimeMillis();
//		System.out.println("生成【" + handNum + "】行数据，总耗时【" + (endTime - startTime) + " 毫秒");
//		CSVServiceUtils.export(out, listModels, ICqpMerchantInfoModel.class, "GBK");
//		long lastTime = System.currentTimeMillis();
//		System.out.println("生成文件总耗时==" + (lastTime - startTime) + "毫秒");

//		List<String[]> result = readCSV(filePath, "GBK");
//		System.out.println(result.get(1)[0]);
		List<ICqpMerchantInfoModel> rows = readCSV(filePath, "GBK", ICqpMerchantInfoModel.class);
//		ICqpMerchantInfoModel iCqpMerchantInfoModel = null;
//		
//		List<ICqpMerchantInfoModel> rows  = readCSVDev(filePath, "GBK", iCqpMerchantInfoModel);
//		/**经过测试，类似这种大数据量加载到内存的日志打印，程序中避免出现，否则会增加CPU和内存的负担，影响性能*/
		logger.info("读取csv文件的数据===>" + rows.get(0).toString()); 
		
//		RatingScaleModel ratingScaleModels = null;
//		List<RatingScaleModel> list = readCSVDev(filePath, "GBK", ratingScaleModels);
//		for(RatingScaleModel ratingScaleModel : list)
//		{
//		    System.out.println("==============" + ratingScaleModel.toString());
//		}
	}
}
