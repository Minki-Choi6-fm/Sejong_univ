bridge=struct('Location','SmithSt.','Maxload','80','yearbuilt','1928','Dueformaintenance','2011');
bridge(2)=struct('Location','HopeAve.','Maxload','90','yearbuilt','1950','Dueformaintenance','2013');
bridge(3)=struct('Location','ClarkSt.','Maxload','85','yearbuilt','1933','Dueformaintenance','2012');
bridge(4)=struct('Location','NorthRd.','Maxload','100','yearbuilt','1960','Dueformaintenance','2012');
cell={'Motor 28C','Test ID 6';[3 9;7 2],[6 5 1]}
cell(1,1)
cell(2,1)
s=[50;100;150;200;250;300];
r=sqrt(s/pi)/2;
v=(4*pi*r.^3)/3;
horzcat(r,v)
A=[2.5 -1.0 3.0 1.5 -2.0;3.0 4.0 -2.0 2.5 -1.0;-4.0 3.0 1.0 -6.0 2.0;2.0 3.0 1.0 -2.5 4.0;1.0 2.0 5.0 -3.0 4.0];
B=[57.1;27.6;-81.2;-22.2;-12.2];
C=A\B