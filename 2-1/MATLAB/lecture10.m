%%Lecture 10
%Q.1
f1=[0.1 -0.2 -1 5 -41.5 235];
x=linspace(-6,6);
plot(polyval(f1,x));
figure;
%Q.2
a=[-1 0 5 -1];
b=[1 2 0 -16 5];
conv(a,b);
%Q.3
f3=poly([0 1.7 -0.5 0.7 -1.5]);
x=linspace(-1.6,1.8);
plot(x,polyval(f3,x));
figure;
%Q.4
x=[-0.24 1.6 1.5 -7.41 -1.8 -4 -75.2 -91];
y=[-0.8 0 5 6.5];
[f4_1,f4_2]=deconv(x,y);
disp(f4_1);
disp(f4_2);
%Q.5
%r=roots(x(x+1)-6972)
%Q.6
x=[2 5 6 8 9 13 15];
y=[7 8 10 11 12 14 15];
p=polyfit(x,y,1);
Y=p(1)*x+p(2);
plot(x,y,'o',x,Y);
figure;
%Q.7
h=[0 600 1500 2300 3000 6100 7900];
T=[100 98.8 95.1 92.2 90 81.2 75.6];
p=polyfit(h,T,1)
Y=p(1)*h+p(2);
disp(p(1)*5000+p(2));
plot(h,T,'o',h,Y);
%Q.8
t=[0 620 2266 3482];
T=[145 130 103 90];
p=polyfit(t,T-68,1);
Y=p(1)*t+p(2);
(120-p(2))/p(1)
%Q.9
week=[1 3 5 7 9 11 13];
height=[22 51 127 202 227 248 252];
p=polyfit(week,height,3);
xp=1:13;
yp=polyval(p,xp);

