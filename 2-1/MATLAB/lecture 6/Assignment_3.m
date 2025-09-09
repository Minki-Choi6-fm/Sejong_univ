%% Assignment#3
%Q.1
clc;clear all;
data=load("Q.1.txt","-ascii");
M=data(1,1);b=data(1,2);t=data(1,3);a=data(1,4);
A=a/b;B=(pi*a)/2;
C=sqrt(tan(B)/B)*((0.923+0.199*(1-sin(B))^2)/cos(B));
o=(6*M)/t*b^2;
K=C*o*sqrt(pi*a);
fprintf("The stress intensity factor for a beam that is %.2fm wide and %.2fm thick with an edge crack of %.2fm and an applied moment of %dN-m is %d Pa-sqrt(m)\n",b,t,a,M,K);
%Q.2
q2 = xlsread('Q.2.xlsx');
min_col=min(q2)
max_col=max(q2)
%Q.3
Q=8000;R=1.987;k0=1200;
T=100:50:500;
k=k0.*exp(-Q./(T.*R));
tableTK(:,1)=T;
tableTK(:,2)=k;

disp('Temperature(K) Rate Constant(1/min)')
disp(' ')
disp(tableTK);
%Q.4
x=0:0.1:2;
q4=@(x)10*exp(-2*x);
plot(x,q4(x));
xlabel('x'); ylabel('q4(x)');
title('Plot of 10e^{-2x}');
%Q.5
heat=@(w)2*w;
cal_to_J=@(j)j*4.2;

save('functions.mat','cal_to_J','heat');
