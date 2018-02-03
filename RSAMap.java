import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import org.apache.hadoop.io.*;  		  
import org.apache.hadoop.mapreduce.*; 

public class RSAMap extends Mapper<Object, Text, Text, NullWritable>{

	 
	private Text word = new Text();

	public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
		NullWritable one=NullWritable.get();
		String line = value.toString(); 
		StringTokenizer tokenizer = new StringTokenizer(line);
		while (tokenizer.hasMoreTokens()) {
			word.set(tokenizer.nextToken());
			int pt[]=new int[200];
			int ct[]=new int[200];
			int z,n,wlen,e;
			int p=11;     //any prime number greater than 11
			int q=3;    
			n=p*q;
			z=(p-1)*(q-1);
			for(e=2;e<z;e++)
			{
				if(gcd(e,z)==1)
					break;
			}
			wlen=word.getLength();
			  for(int i=0;i<wlen;i++)
			  {
				  pt[i]=word.charAt(i);
			  }
			  //chiper text is obtained
			  for(int i=0;i<wlen;i++)
			  {
				  ct[i]=mult(pt[i],e,n);
			  }
			 
			   
				String s[]=Arrays.stream(ct).mapToObj(String::valueOf).toArray(String[]::new);
				 for(int i=0;i<wlen;i++)
				 {
			          Text t=new Text(s[i]);
			     
				  context.write(t,one);
				 }
			
		}
		
	
	}

	private int mult(int base, int exp, int n) {
	 
		int res=1,j;
		  for(j=1;j<=exp;j++)
		  {
			  res=((res*base)%n);
		  }
		  return res;
	}

	private int gcd(int x, int y) {
		// TO calculate greatest common diviser
		if(y==0)
			return x;
		else
			return gcd(y,x%y);
	}
}
