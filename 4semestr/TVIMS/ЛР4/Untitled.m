%  онярпнемхе цпютхйю опнжеяяю
clear all;
close all;
Ts=0.01;
T= 100;
[F_Name,PathName]= uigetfile('*.png','яМХЛНЙ');
I=imread(F_Name);
figure(1);
imshow(I);
A=double(I);
variable = A(:,1);
figure(2);
stem(variable);   
title('PROCES');   
ylabel('Y');
xlabel('N');

%  онярпнемхе цхярнцпюллш    
n=length(variable);
k=round(sqrt(n));
figure(3);
hist(variable, k);
title('HISTOGRAMMA');
ylabel('Q');
xlabel('N');

% %  онярпнемхе яо опх онлных опнжедспш PSD
fsp=250;
df=1/T;
Fmax=1/Ts;
f=-Fmax/2:df:Fmax/2;
dovg=length(f);
[c, f]=periodogram(variable, [], dovg, Fmax);
psdplot(Pxx,w,'','','PSD');
% figure(4);
% title('PSD');  
% ylabel('SP');  
% xlabel('frequency');

%  онярпнемхе юйнбт яксвюимнцн опнжеяяю
R=xcorr2(variable);
tau=-1.98:0.01:1.98;
figure(5);
plot( tau, R);  grid;
title('AKVF');
label('Bcov'); 
xlabel('tau');

%  онярпнемхе юйнпт яксвюимнцн опнжеяяю
R1=xcov(variable);
tau=-1.98:0.01:1.98;
figure(6);
plot( tau, R1);  grid;
title('AKRF');
label('Bcor'); 
xlabel('tau');