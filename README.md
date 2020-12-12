# CurrencyConverter

## DB creation (psql):
create database currency_converter;<br/>

\c currency_converter<br/>

create table exchange_rate_journal(<br/>
id bigint primary key,<br/>
cbr_id varchar(255),<br/>
num_code bigint,<br/>
nominal varchar(255),<br/>
name varchar(255),<br/>
value bigint,<br/>
date varchar(255)<br/>
);<br/>

create table calculation_journal(<br/>
id bigint primary key,<br/>
currency_from bigint references exchange_rate_journal(id),<br/>
currency_to bigint references exchange_rate_journal(id),<br/>
amount_from bigint,<br/>
amount_to bigint,<br/>
date varchar(255)<br/>
);<br/>

create table application_state(<br/>
id bigint primary key,<br/>
last_download_date varchar(255)<br/>
);<br/>

insert into application_state (id, last_download_date)<br/>
values (1, '01.01.1971');<br/>