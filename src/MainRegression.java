import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class MainRegression {

	
	private final static int SIZE=100;
	
	private final static int NUM_ITERATIONS=1000;
	private final static Point[] store=new Point[SIZE];
	private final static String readFile="data2";
	private final static double learningRate=0.5;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
		BufferedReader user =  new BufferedReader(new InputStreamReader(System.in));
		System.out.println("X: ");
		double X=Double.parseDouble(user.readLine());
		System.out.println("Y: ");
		double Y=Double.parseDouble(user.readLine());
		BufferedReader rd=new BufferedReader(new FileReader(readFile+".txt"));
		
	
		double coorX,coorY;
		String group=rd.readLine();
		int index=0;

		
		//dimension is 2 here!
		while(group!=null){
			StringTokenizer token=new StringTokenizer(group," ");
			coorX=Double.parseDouble(token.nextToken());
			coorY=Double.parseDouble(token.nextToken());
			store[index]=new Point(coorX,coorY);
			index++;
			group=rd.readLine();
		}
		
		
		double theta1=0;
		double theta0=0;
		double temp1;
		int cnt=0;
		
		while(cnt<NUM_ITERATIONS){
			
			temp1=theta0-learningRate*gradient0(store,theta1,theta0);
			theta1=theta1-learningRate*gradient1(store,theta1,theta0);
			theta0=temp1;
			cnt++;
		}
		
		System.out.println("y= "+theta0+" + "+theta1+" x");
		System.out.println("Predicted Y value is: "+fncValue(X,theta1,theta0));
		System.out.println("Standard Deviation is: "+stdDevY(store,theta1,theta0));
	

		System.out.println("pValue:"+pValue(Y,fncValue(X,theta1,theta0),varianceY(store,theta1,theta0)));
		double confidence=1-2*Math.abs(0.5-CDF(Y,fncValue(X,theta1,theta0),varianceY(store,theta1,theta0)));;
		System.out.println("We are "+(100*confidence) +"% confident that your data is another sample of this data");
		
		
		
		
		
		
		
		rd.close();
		
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	
	private static double fncValue(double X,double m,double yInter){
		return X*m+yInter;
	}
	private static double gradient0(Point[] data,double theta1,double theta0){
		double sum=0;
		for(int i=0; i<data.length;i++){
			sum+= (fncValue(data[i].getX(),theta1,theta0) -data[i].getY());
		}
		return sum/(2*data.length);
	}
	private static double gradient1(Point[] data,double theta1,double theta0){
		double sum=0;
		for(int i=0; i<data.length;i++){
			sum+= (fncValue(data[i].getX(),theta1,theta0) -data[i].getY())*data[i].getX();
		}
		return sum/(2*data.length);
	}
	private static double varianceY(Point[] data,double theta1,double theta0){
		double sum=0;
		for(int i=0; i<data.length;i++){
			sum+= Math.pow((fncValue(data[i].getX(),theta1,theta0) -data[i].getY()),2);
		}
		return sum/data.length;
	}
	private static double stdDevY(Point[] data,double theta1,double theta0){
		return Math.sqrt(varianceY(data,theta1,theta0));
	}
	

	private static double CDF(double x){
		
		if(x>5){
			return 1;
		}
		if(x<-5){
			return 0;
		}
		double prob=x;
		double val=x;
		double coeff1=1/Math.sqrt(2*Math.PI);
		double coeff2=Math.pow(Math.E,-(x*x)/2);
		for(int i=1; i<40;i++){
			val=(val*x*x/(2*i+1));
			prob+=val;
		
		}
		//System.out.println(prob+" "+coeff1+" "+coeff2);
		return 0.5+prob*coeff1*coeff2;
		
	}
	private static double CDF(double x,double mean, double variance){
		return CDF((x-mean)/Math.sqrt(variance));
		
	}
	private static double pValue(double input,double mean, double variance){
		return (CDF(input,mean,variance)-0.5)/Math.sqrt(variance);
		//return 1-2*Math.abs(0.5-CDF(input,mean,variance));
	}
}
