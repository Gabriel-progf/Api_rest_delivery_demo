create table occurrence (
	
    id bigint not null auto_increment,
    delivery_id bigint not null,
    description text not null,
    register_date datetime,
    
    primary key(id)


);

alter table occurrence add constraint fk_delivery_occurence foreign key (delivery_id) references delivery (id);
