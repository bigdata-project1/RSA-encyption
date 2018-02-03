import org.apache.hadoop.conf.Configuration; 
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.util.GenericOptionsParser; 

public class DriverRSA  { 
	public static void main(String[] args) throws Exception { 
		/*if(args.length <2) {
			System.err.println("Usage:<inputpath> <outputpath>");
			System.exit(-1);
		}*/	

		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "RSA");
		job.getConfiguration().set("fs.file.impl", "WinLocalFileSystem");
		job.setJarByClass(DriverRSA.class); 		
		
		job.setMapperClass(RSAMap.class);
		job.setReducerClass(Reducer.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(NullWritable.class);		
			
		FileInputFormat.addInputPath(job, new Path(args[0]));
		//FileInputFormat.addInputPath(job, new Path("D:/Eclipse Project/HadoopV1/LogNASA.txt"));
		FileOutputFormat.setOutputPath(job,new Path(args[1]));
		//FileOutputFormat.setOutputPath(job, new Path("D:/Eclipse Project/HadoopV1/output4"));
		
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}	
}

 
