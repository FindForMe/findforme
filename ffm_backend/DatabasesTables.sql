create table category(

	id int auto_increment,
	name varchar(30),
	description varchar(200),
	image_url varchar(50),
	active varchar(6) default 'false',
	
	constraint pk_category primary key(id)
);
