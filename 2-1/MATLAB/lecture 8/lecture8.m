%%Week 08
%P.1
%a
a=input('');
disp(fact_for(a));
%b
a=input('');
disp(fact_while(a));

%P.2
x=[45,23,17,34,85,33];
count=0;
for k=1:length(x)
    if x(k)>30
        count=count+1;
    end
end
disp(count);
length(find(x>30))
hap=0;
for k=1:length(x)
    hap=hap+x(k);
end
disp(hap)
s=sum(x)

%P.3
t=1;
while((mod(t,13)~=0)||(mod(t,16)~=0)||(sqrt(t)<=120))
    t=t+1;
end
fprintf("The required number is:%d",t);

%P.4
Fi(1)=0;
Fi(2)=1;
for k=3:20
    Fi(k)=Fi(k-1)+Fi(k-2);
end
Fi

%P.5
format long 
n=[100,10000,1000000];
for k=1:3
    tmp=0;
    for l=1:n(k)
        tmp=tmp+1/l^2;
    end
    sqrt(6*tmp)
end
PI=pi
        
%P.6
random=randi([-10,10],1,20);
SUM=0;
for k=1:20
    if(random(k)>0)
        SUM=SUM+random(k)
    end
end
disp(SUM);

%P.7
format short
x=[4.5 5 -16.12 21.8 10.1 10 -16.11 5 14 -3 3 2];
for i=1:length(x)
    for j=1:i
        if(x(i)<x(j))
            temp=x(i);
            x(i)=x(j);
            x(j)=temp;
        end
    end
end
disp(x);

%P.8
exam_score=[31, 70, 92, 5, 47, 88, 81, 73, 51, 76, 80, 90, 55, 23, 43, 98, 36, 87, 22, 61, 19, 69, 26, 82, 89, 99, 71, 59, 49, 64];
a_c=0;
b_c=0;
c_c=0;
d_c=0;
e_c=0;
for k=1:30
    if(exam_score(k)<20)
        a_c=a_c+1;
    end
    if(exam_score(k)<40)
        b_c=b_c+1;
    end
    if(exam_score(k)<60)
        c_c=c_c+1;
    end
    if(exam_score(k)<80)
        d_c=d_c+1;
    end
    if(exam_score(k)<100)
        e_c=e_c+1;
    end
end
fprintf("Grades between 0 and 19 %d students",a_c);
fprintf("Grades between 20 and 39 %d students",b_c);
fprintf("Grades between 40 and 59 %d students",c_c);
fprintf("Grades between 60 and 79 %d students",d_c);
fprintf("Grades between 80 and 100 %d students",e_c);

%P.9
