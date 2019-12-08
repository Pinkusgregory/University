
program pr_1;

const
  q = 40;
  w = 60;

type
  mass = array[1..q, 1..w] of integer;

var
  a, b: mass;
  n, m, h, u, y, x: integer;
  f: text;
  g: string;

procedure vvodmatr(var ma: mass);
var
  i, j: integer;
begin
  Assign(f, g);
  Reset(f);
  for i := 1 to n do
    for j := 1 to m do
      read(f, ma[i, j]);
  Close(f);
end;

procedure vivodmatr(ma: mass);
var
  i, j: integer;
begin
  for i := 1 to n do
  begin
    for j := 1 to m do
      write(ma[i, j], ' ');
    writeln;
  end;
end;

procedure zapolnmatr();
var
  i, j: integer;
begin
  randomize;
  Assign(f, g);
  Rewrite(f);
  for i := 1 to n do
  begin
    for j := 1 to m do
      write(f, random(50)-25, ' ');
    writeln(f);
  end;
  Close(f);
end;

procedure vivodstroki(var ma: mass; k: integer);
var
  i: integer;
begin
  for i := 1 to m do
    write(ma[k, i], ' ');
end;

procedure vivodvektor(var ma: mass; k: integer);
var
  i, j, s: integer;
begin
  for i := 1 to n do
  begin
    s := 0;
    for j := 1 to m do
      if ma[i, j] < k
        then s := s + ma[i, j];
    write(s, ' ');
  end;
end;

procedure sortirovka(var ma: mass);
var
  i, j, k: integer;
  b: boolean;
begin
  for i := 1 to n do
  begin
    b := false;
    while not b do
    begin
      b := true;
      for j := 1 to m - 1 do
        if  ma[i, j] > ma[i, j + 1]
              then
        begin
          k := ma[i, j]; 
          ma[i, j] := ma[i, j + 1];
          ma[i, j + 1] := k;
          b := false;
          break;
        end;
    end;
  end;
end;

function iter(var ma:mass; k:integer):integer;
  var i,s:integer;
begin
  s:=0;
  for i:=1 to m do
    if ma[k,i]<0
      then s:=s+abs(ma[k,i]);
  iter:=s;
end;

function rekurs(var ma:mass; k,first,last:integer):integer;
  var i,j,s,te:integer;
begin
  s:=0;
  if first<=last
    then if first=last
      then s:=ma[k,first]
      else
        begin
          te:=rekurs(ma,k,first+1,last);
          if abs(ma[k,first])>abs(te)
            then s:=ma[k,first]
            else s:=te;
        end;
    rekurs:=s;
end;
begin
  writeln('MATR A');
  write('n=');
  readln(n);
  write('m=');
  readln(m);
  write('filename=');
  read(g);
  zapolnmatr();
  vvodmatr(a);
  vivodmatr(a);
  writeln('nomer stroki');
  readln(h);
  vivodstroki(a, h);
  writeln;
  writeln('vvedite a');
  readln(u);
  vivodvektor(a, u);
  writeln;
  writeln;
  sortirovka(a);
  vivodmatr(a);
  writeln('vvedite nomer stroki=');
  readln(y);
  writeln('iter=',iter(a,y));
  writeln('vvedite nomer stroki=');
  readln(x);
  writeln('rekurs=',rekurs(a,x,1,m));
  writeln('MATR B');
  write('n=');
  readln(n);
  write('m=');
  readln(m);
  write('filename=');
  read(g);
  zapolnmatr();
  vvodmatr(b);
  vivodmatr(b);
  writeln('nomer stroki');
  readln(h);
  vivodstroki(b, h);
  writeln;
  writeln('vvedite a');
  read(u);
  vivodvektor(b, u);
  writeln;
  writeln;
  sortirovka(b);
  vivodmatr(b);
  writeln('vvedite nomer stroki=');
  readln(y);
  writeln('iter=',iter(b,y));
  writeln('vvedite nomer stroki=');
  readln(x);
  writeln('rekurs=',rekurs(b,x,1,m));
end.