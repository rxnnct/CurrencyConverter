# CurrencyConverterTrialProject

## DB Creation (psql):
create database currency_converter; 

\c currency_converter

create table exchange_rate_journal(
	id bigint primary key,
	cbr_id varchar(255),
	num_code bigint,
	nominal varchar(255),
	name varchar(255),
	value bigint,
	date varchar(255)
);

create table calculation_journal(
	id bigint primary key,
	currency_from bigint references exchange_rate_journal(id),
	currency_to bigint references exchange_rate_journal(id),
	amount_from bigint,
	amount_to bigint,
	date varchar(255)
);
