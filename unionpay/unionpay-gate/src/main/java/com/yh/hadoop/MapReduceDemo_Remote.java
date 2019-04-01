package com.yh.hadoop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/*
 * 类名：MapReduceDemo_Local.java
 * 版本：1.0
 * 日期：2014/05/18
 * 描述：演示编写mapreduce代码在hadoop上调试
 * 作者：miki
 */

public class MapReduceDemo_Remote {
	private static Configuration conf = new Configuration();
	private static FileSystem fs;

	static {

		// 指定hadoop集群的参数;namenode和jobtraker
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
		public void setup(Context context) throws IOException,
				InterruptedException {

		}

		@Override
		public void cleanup(Context context) throws IOException,InterruptedException {

		}

		@Override
		public void map(LongWritable key, Text value, Context context)throws IOException, InterruptedException {
			if (value.toString().indexOf("WARN") != -1) {
				context.write(new Text("WARN"), new LongWritable(1L));
			} else if (value.toString().indexOf("INFO") != -1) {
				context.write(new Text("INFO"), new LongWritable(1L));
			}
		}
	}

	public static class DemoReduer extends
			Reducer<Text, LongWritable, Text, Text> {
		@Override
		public void setup(Context context) throws IOException,InterruptedException {

		}

		@Override
		public void cleanup(Context context) throws IOException,
				InterruptedException {

		}

		@Override
		public void reduce(Text key, Iterable<LongWritable> values,Context context) throws IOException, InterruptedException {
			long totalCout = 0;
			for (LongWritable count : values) {
				totalCout += count.get();
			}

			context.write(key, new Text(Long.toString(totalCout)));
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long TAG = System.currentTimeMillis();
		
		try {
			// cluster jobd from conf
			Job job = new Job(conf);
			job.setJobName("miki-test2");
			job.setJarByClass(MapReduceDemo_Remote.class);

			job.setMapperClass(DemoMapper.class);
			job.setReducerClass(DemoReduer.class);

			//注意：在HDFS读写文件都有权限控制的，登陆账号只能够操作以属于自己的文件
			//如果是windows系统，账号就是自己的系统账号，如：Administrator
			
			// cluster input file
			Path inputPath = new Path("/user/Administrator/demo/input");
			FileInputFormat.setInputPaths(job, inputPath);

			// cluster output file
			Path outputPath = new Path("/user/Administrator/demo/output-" +TAG);
			if (fs.exists(outputPath)) {
				// putput目录必须保证不存在，如果存了，需要先删除
				fs.delete(outputPath, false);
			}
			FileOutputFormat.setOutputPath(job, outputPath);

			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(LongWritable.class);
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(Text.class);

			// job.setNumReduceTasks(2);
			job.waitForCompletion(true);

			//从hdfs将产生的计算结果文件获取下来
			Path filePath = new Path("/user/Administrator/demo/output-" +TAG+ "/part-r-00000");
			FSDataInputStream is = fs.open(filePath);
			FileStatus fileStats = fs.getFileStatus(filePath);
			int len = (int) fileStats.getLen();
			byte[] buffer = new byte[len];
			is.read(buffer);
			is.close();
			FileOutputStream fos = new FileOutputStream(new File("part-r-00000"));
			fos.write(buffer, 0, len);
			fos.close();
			
			System.out.println("执行完毕，执行结果文件被成功获取到");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
