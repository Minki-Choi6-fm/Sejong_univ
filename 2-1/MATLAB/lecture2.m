%lecture 2
%%P.1 Define the variable x as x=6.7, then evaluate:
x=6.7;
P1.a=(0.01*(x^5))-(1.4*(x^3))+(80*x)+16.7
P1.b=sqrt((x^3)+exp(x)-(51/x))
%%P.2 Define the variable t as t=3.2, then evaluate:
t=3.2;
P2.a=(56*t)-(9.81*((t^2)/2))
P2.b=(14*exp(-0.1*t)*sin(2*pi*t))
%%P.3 Define the variables x and y as x=5.1 and y=4.2, then evaluate:
x=5.1;y=4.2;
P3.a=((3/4)*x*y)-(7*x/(y^2))+sqrt(x*y)
P3.b=((x*y)^2)-((x+y)/((x-y)^2))+sqrt((x+y)/(2*x-y))
%%P.4
A=11;B=9;
P4.L=(sqrt((B^2)+16*(A^2))/2)+((B^2)*log((4*A+sqrt((B^2)+16*(A^2)))/B))/(8*A)
%%P.5
x=pi/12;
P5.lg=sin(5*x)
P5.rg=5*sin(x)-20*(sin(x).^3)+16*(sin(x).^5)
P5.lh=(sin(x).^2)*(cos(x).^2)
P5.rh=(1-cos(4*x))/8
%%P.6
a=pi/6;b=3*pi/8;
P6.l=sin(a)+sin(b)
P6.r=2*sin((a+b)/2)*cos((a-b)/2)
%%P.7
a=16;b=11;
P7.C=pi(3*(a+b)-sqrt((3*a+b)*(a+3*b)))
%%P.8
P8.ans=ceil(315/37)
%%P.9
P9.ans=fix(739/54)
%%P.10
V=14;R1=120.6;R2=119.3;R3=121.2;R4=118.8;
P10.ans=V*((R1*R3-R2*R4)/(R1+R2)(R3+R4))
%%P.11
P11.a=gcd(91,147)
P11.b=gcd(555,962)
%%P.12
'b'>='c'-1
3==2+1
(3==2)+1
xor(5<6,8>4)
%%P.13
"MATLAB usually read input from left to right. so for example, if user type 5>4>1, it reads 5>4 first. And changes it to result which is 1. So input will be changed 1>1. So it will print 0."
%%P.14
"Similar with P.13"