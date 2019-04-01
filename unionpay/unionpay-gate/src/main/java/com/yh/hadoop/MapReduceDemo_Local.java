package com.yh.hadoop;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MapReduceDemo_Local {
	private static Configuration conf = new Configuration();
	private static FileSystem fs;

	static {
		// 如果是执行本地测试的MR程序，这个配置不会被调用
		conf.set("fs.defaultFS", "hdfs://172.16.88.11:8020");
		conf.set("mapred.job.tracker", "172.16.88.11:8021");
		conf.set("fs.hdfs.impl","org.apache.hadoop.hdfs.DistributedFileSystem");
		try {
			fs = FileSystem.get(conf);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static class DemoMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
		@Override
		public void setup(Context context) throws IOException,InterruptedException {

		}

		@Override
		public void cleanup(Context context) throws IOException,InterruptedException {

		}

		@Override
		public void map(LongWritable key, Text value, Context context)throws IOException, InterruptedException {
			
			//key:行号; value:这行的文本数据; context:用来向reducer传递参数的上下文			
			if (value.toString().indexOf("WARN") != -1) {
				
				//如果包含该关键字，则向context写入一个key-value数据，如：put("WARN",1); 表示出现了一次
				context.write(new Text("WARN"), new LongWritable(1L));
			} else if (value.toString().indexOf("INFO") != -1) {
				context.write(new Text("INFO"), new LongWritable(1L));
			}
		}
	}

	public static class DemoReduer extends Reducer<Text, LongWritable, Text, Text> {
		@Override
		public void setup(Context context) throws IOException,InterruptedException {

		}

		@Override
		public void cleanup(Context context) throws IOException,InterruptedException {

		}

		@Override
		public void reduce(Text key, Iterable<LongWritable> values,
				Context context) throws IOException, InterruptedException {
			long totalCout = 0;
			
			//key:map里面出现的文本关键字，如：WARN,INFO
			//values:保存一堆数据“1”的一个容器；全部数据都是数字1
			
			//遍历容器 values,每次取出元素，赋给count变量
			for (LongWritable count : values) {
				totalCout += count.get();
			}

			context.write(key, new Text(Long.toString(totalCout)));
			
			//直接在程序中输出执行结果；保存到本地文件会出现 “cygpath”的报错
			System.out.println(key + " 出现的次数 = " + totalCout);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			// TAG 
			long TAG = System.currentTimeMillis();
			// local file
			Job job = new Job();
			job.setJarByClass(MapReduceDemo_Local.class);

			job.setMapperClass(DemoMapper.class);
			job.setReducerClass(DemoReduer.class);

			// local input file
			Path inputPath = new Path("D:\\hadoop\\hbase-demo-mr\\hbase-demo\\data");
			FileInputFormat.setInputPaths(job, inputPath);

			// local output file
			//如果用PATH的方式去创建本地文件会出现 “cygpath”的报错。需要安装先安装好cygwin然后配置好环境变量
			Path outputPath = new Path("D:\\hadoop\\hbase-demo-mr\\hbase-demo\\output-" + TAG);
			FileOutputFormat.setOutputPath(job, outputPath);
		
			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(LongWritable.class);
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(Text.class);

			// job.setNumReduceTasks(2);

			System.out.println("开始执行job");
			
			// 开始执行,等待job执行结束
			job.setJobName("miki's test job");
			job.waitForCompletion(true);

			System.out.println("job执行完成");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
