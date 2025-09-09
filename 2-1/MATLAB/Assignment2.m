%%Assignment2
%%q.1
%%a
E=8.854*(10^(-12));
c_cell=cell(2,3);
d=[0.003 0.004 0.005 0.01];
L=[1 2 3];
r=[0.001 0.002 0.003];

c_cell={"d","L","r";d,L,r};

C=(pi*E*c_cell{2,2}(2))/log((c_cell{2,1}(3)-c_cell{2,3}(1))/c_cell{2,3}(1));

%%q.2
vctD=[0:3:27]
vctDop=fliplr(vctD)

%%q.3
H=[1.25:0.25:2.75;1 2 3 1 2 3 4;45:-5:15];
%a
G([1 2],:)=[H(1,1:3) H(1,6:7);H(3,3:7)]
%b
K(:,[1 2 3 4])=H(:,[2 3 5 7]);
K=K'

%%q.4
V0=24;R=3800;C=4000*(10^-6);t0=R*C;
time=0:2:20;
Vc=V0*(1-exp((-time)/t0));
i=V0*exp((-time)/t0)/R;
table=vertcat(time,Vc,i)'

%%q.5
left=[-4 3 1;5 6 -2;2 -5 4.5];
right=[-18.2;-48.8;92.5];
left\right

%%q.6
mixes=struct('Peanuts',[],'Almonds',[],'Walnuts',[],'Raisins',[],'M_Ms',[]);

mixes(1).Peanuts=3;mixes(1).Almonds=1;mixes(1).Walnuts=1;mixes(1).Raisins=2;mixes(1).M_Ms=1;
mixes(2).Peanuts=1;mixes(2).Almonds=2;mixes(2).Walnuts=1;mixes(2).Raisins=3;mixes(2).M_Ms=1;
mixes(3).Peanuts=1;mixes(3).Almonds=1;mixes(3).Walnuts=0;mixes(3).Raisins=3;mixes(3).M_Ms=3;
mixes(4).Peanuts=2;mixes(4).Almonds=0;mixes(4).Walnuts=3;mixes(4).Raisins=1;mixes(4).M_Ms=2;
mixes(5).Peanuts=1;mixes(5).Almonds=2;mixes(5).Walnuts=3;mixes(5).Raisins=0;mixes(5).M_Ms=2;