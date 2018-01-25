              //mapper class

import java.io.IOException; 
import java.util.*;
import org.apache.hadoop.io.*;  		  
import org.apache.hadoop.mapreduce.*; 

public class MapCR extends Mapper<Object, Text, Text, IntWritable>{

	 
	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
		String line = value.toString();
		String elements[]=line.split(" ");
		    
		Text Cname=new Text(elements[0]);
		int i=Integer.parseInt(elements[2]);
		IntWritable price=new IntWritable(i);
		context.write(Cname,price);
		    			  
    }
}

