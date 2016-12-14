# simpleLinearRegression
My first machine learning algorithm. It is a simple linear regression algorithm with one dimensional input and output sets. It reads a 
dataset readFile and obtain fixed sized data points. Then it executes gradient descent algorithm, which learns slope and y-intercept 
of the line that best-fits to data. It asks from user to try another point and checks whether the new point fits the line. It calculates pValue and maximum 
confidence level that we can say the point is another sample of this dataset.

data2 is a set of two dimensional points and they fit y=0.3x+1 line with some noise. This noise is the main reason for standard deviation
and variation from actual (calculated) y value. If noise increases, precision gets lower and standard deviation will go higher. Otherwise,
algorithm becomes very sure of its line and standard deviation gets close to zero. Sample output snippets are given below. 

X: 
1
Y: 
0.4
y= 0.10011726727988968 + 0.3029300669691639 x
Predicted Y value is: 0.4030473342490536
Standard Deviation is: 0.06486081154013905
pValue:-0.046982672228325854
We are 96.25270378353686% confident that your data is another sample of this data

X: 
1
Y: 
0.5
y= 0.10011726727988968 + 0.3029300669691639 x
Predicted Y value is: 0.4030473342490536
Standard Deviation is: 0.06486081154013905
pValue:1.4947803372911446
We are 13.49717795683345% confident that your data is another sample of this data

X: 
1
Y: 
0.6
y= 0.10011726727988968 + 0.3029300669691639 x
Predicted Y value is: 0.4030473342490536
Standard Deviation is: 0.06486081154013905
pValue:3.036543346810615
We are 0.23930769759639148% confident that your data is another sample of this data
