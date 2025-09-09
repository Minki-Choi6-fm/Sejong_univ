%aaaaa
%% add two num
a=input('Enter the value of a:');
b=input('Enter the value of b:');
str=input('text','s')
s=a+b
Sejong=struct('FSC',[]);
FSC=struct('AIRobotics',[],'IMTS',[]);
AIRobotics=struct('Students',[],'Faculty',[]);
IMTS=struct('Students',[],'Faculty',[]);
Students=struct('Name',[],'Reg_id',[],'Email',[]);
Faculty=struct('Name',[],'Fid',[],'Email',[]);
Sejong(1).FSC=FSC;
Sejong.FSC(1).AIRobotics=AIRobotics;
Sejong.FSC(1).IMTS=IMTS;
Sejong.FSC.AIRobotics(1).Students=Students;
Sejong.FSC.AIRobotics(1).Faculty=Faculty;
Sejong.FSC.IMTS(1).Students=Students;
Sejong.FSC.IMTS(1).Faculty=Faculty;
%%
% Define base structures
Students = struct('Name', [], 'Reg_id', [], 'Email', []);
Faculty = struct('Name', [], 'Fid', [], 'Email', []);

% Define AIRobotics and IMTS structures
AIRobotics = struct('Students', Students, 'Faculty', Faculty);
IMTS = struct('Students', Students, 'Faculty', Faculty);

% Define FSC structure
FSC = struct('AIRobotics', AIRobotics, 'IMTS', IMTS);

% Define Sejong structure
Sejong = struct('FSC', FSC);
%perplexity가 짜준 코드-훨씬 깔끔함
