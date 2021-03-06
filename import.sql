drop table if exists Regra;
drop table if exists Procedimento;
create table Procedimento (id integer not null, codigo integer unique, primary key (id));
create table Regra (id integer not null, id_procedimento integer, idade integer, sexo varchar(255), primary key (id), permitido boolean not null);
alter table Regra add constraint PROCEDIMENTO_ID_FK foreign key (id_procedimento) references Procedimento;
insert into procedimento values (1, 1234);
insert into procedimento values (2, 4567);
insert into procedimento values (3, 6789);
insert into Regra VALUES (1, 1, 10, 'M', 'true');
insert into Regra VALUES (2, 2, 20, 'M', 'true');
insert into Regra VALUES (3, 3, 10, 'F', 'true');
insert into Regra VALUES (4, 3, 10, 'M', 'true');
insert into Regra VALUES (5, 1, 20, 'M', 'true');
insert into Regra VALUES (6, 2, 30, 'F', 'true');