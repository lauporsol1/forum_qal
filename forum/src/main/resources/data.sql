create table threads (
	title varchar(255)
);

create type category as enum ('question','suggestion','clarification');

create table posts (
	title varchar(255),
	category category,
	body varchar(255),
	image varchar(255),
	thread_id int
);

create table users (
     email varchar(255),
     first_name varchar(255),
     last_name varchar(255),
     password varchar(655)
);

insert into threads (title)
values('Thread 1');
insert into threads (title)
values('Thread 2');

insert into posts (title,category,body,image,thread_id)
values('Post 1','question','body','https://image.com',1);
insert into posts (title,category,body,image,thread_id)
values('Post 2','suggestion','body','https://image.com',1);
insert into posts (title,category,body,image,thread_id)
values('Post 3','clarification','body','https://image.com',2);
insert into posts (title,category,body,image,thread_id)
values('Post 4','question','body','https://image.com',2);

insert into users (email,first_name,last_name,password)
values('user1@mail.com','User1','LastName1','12345abcd');