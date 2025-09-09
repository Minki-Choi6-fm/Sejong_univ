%Q.1
%Q.5
H=input('Enter your height: ');
W=input('Enter your weight: ');
BMI=703*W/H^2;
if BMI<18.5
    fprintf("Your BMI value is %.1f, which classifies you as Underweight,",BMI);
elseif BMI>=18.5&&BMI<25
        fprintf("Your BMI value is %.1f, which classifies you as Normal,",BMI);
elseif BMI>=25&&BMI<30
        fprintf("Your BMI value is %.1f, which classifies you as Overweight",BMI);
else
    fprintf("Your BMI value is %.1f, which classifies you as Obese",BMI);
end
%Q.6
pressure=input('Enter air pressure: ');
c_unit=input('Enter current units: ','s');
d_unit=input('Enter desire units:','s' );

f.pa=1;
f.psi=6894.76;
f.atm=101325;
f.torr=133.322;

temp=pressure/f.(c_unit);

Q6result=temp*f.(d_unit)

%Q.7
gen=input('Enter gender: ','s');
age=input('Enter age: ');
rhr=input('Enter rest heart rate: ');
fitness_level=input('Enter fitness level: ','s');
switch fitness_level
    case 'low'
        level=0.55;
    case 'medium'
        level=0.65;
    case 'high'
        level=0.8;
end
if gen=='male'
    THR=((220-age)-rhr)*level+rhr
elseif gen=='female'
    THR=((206-0.88*age)-rhr)*level+rhr
end