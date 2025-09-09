%Q.1
exp(2);
x=linspace(-2,4);
fx=x.^3-2.*x.^2-10.*sin(x).^2-exp(0.9*x);
f_d=3*x.^2 - 4*x - 10*sin(2*x) - 0.9*exp(0.9*x);
plot(x,fx);hold on;
plot(x, f_d, '--');hold off;
figure;
legend('f(x)','f''(x)');

%Q.2
x=linspace(-4,3);
fx=-3*x.^4+10*x.^2-3;
plot(x,fx);hold on;
x=linspace(-4,4);
plot(x,fx);hold off;
figure;

%Q.3
fplot('(sin(2*x)+cos(5*x).^2).*exp(-0.2.*x)',[-6,6]);
figure;

%Q.4
t=linspace(-pi,pi);
x=sin(t).*cos(t);
y=1.5*cos(t);
xlim([-2, 2]);
ylim([-2, 2]);
plot(x,y);
figure;

%Q.5
t=linspace(0,2*pi);
x=cos(t).^3;
y=sin(t).^3;
u=sin(t);
v=cos(t);
xlim([-2,2]);
ylim([-2,2]);
plot(x,y);hold on;
plot(u,v);hold off;
figure;

%Q.6
theta=linspace(0,2*pi);
r=2*sin(3.*theta).*sin(theta);
polarplot(theta,r);
