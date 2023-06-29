create table cliente (data_di_nascita datetime(6), id bigint not null auto_increment, codice_fiscale varchar(255), cognome varchar(255), email varchar(255), nome varchar(255), telefono varchar(255), primary key (id)) engine=InnoDB;
create table indirizzo (numero_civico integer, id bigint not null auto_increment, cap varchar(255), via varchar(255), primary key (id)) engine=InnoDB;
create table cliente (data_di_nascita datetime(6), id bigint not null auto_increment, codice_fiscale varchar(255), cognome varchar(255), email varchar(255), nome varchar(255), telefono varchar(255), primary key (id)) engine=InnoDB;
create table indirizzo (numero_civico integer, id bigint not null auto_increment, cap varchar(255), via varchar(255), primary key (id)) engine=InnoDB;
