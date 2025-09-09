%%Lecture5
%P.1
T=input("T:");
R=input("R:");
HI = -42.379 + 2.04901523 * T + 10.14333127 * R - 0.22475541 * T * R - 6.83783e-3 * T^2 - 5.481717e-2 * R^2 + 1.22874e-3 * T^2 * R + 8.5282e-4 * T * R^2 - 1.99e-6 * T^2 * R^2;
fprintf("The Heat Index temperature is: %d",HI);
%P.2
r2=[12;16;20;24;28];
r1=0.7*r2;
V=(pi^2*(r1+r2).*(r2-r1).^2)/4;
S=pi^2*(r2.^2-r1.^2);
arr=horzcat(r2,r1,V,S);
%P.3
W=500;L=120;h=50;
x=[10 30 50 70 90];
T=(W*L*sqrt(h.^2+x.^2))/h.*x
%P.4
vector=input("vector:")
fprintf("There are %d grades\n",length(vector));
fprintf("The average grade is %d\n",mean(vector));
fprintf("The standard deviation is %d\n",std(vector));
fprintf("The median grade is %d\n",median(vector));
%P.5
N=input("N:");L=input("L:");r=input("r:");
P=L*((r/1200)*(1+r/1200)^(12*N))/((1+r/1200)^(12*N)-1);
fprintf("The monthly payment of a %d years %6.2f mortgage with interest rate of %2.2f percent is $%4.2f",N,L,r,P);
%P.6
h=[-500:500:10000];
p=29.921*(1-6.8753*10^6*h);
Tb=49.161*log(p)+44.932;
table=[h;Tb]';
