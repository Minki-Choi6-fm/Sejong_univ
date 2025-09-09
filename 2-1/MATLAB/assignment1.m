%%assignment 1
clc,clear all
%%(a)
a=5;b=7;r=25;
c=sqrt(a^2+b^2-(2*a*b*cosd(r)))
%%b
alpha=asind(a*sind(r))/c
beta=180-(asind((b*sind(r))/c))
%%c
format short g
left=(a-b)/(a+b);
right=tan((alpha-beta)/2)/tan((alpha+beta)/2)
left==right