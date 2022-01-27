-- creating tables
 -- drop solutions;
-- drop issues;

create table issues ( id serial primary key, title text not null, description text not null);


create table solutions ( id serial primary key, answer text not null, upvote int not null, issue_id int references issues(id));

-- seeding db

insert into issues (title, description)
values ('My code is not working',
        'My code no workie do not know why'), ('My code is working???',
                                               'My code works. I have no idea how');


insert into solutions (issue_id, answer, upvote)
values (1,
        'Have you tried crying yet? Maybe you can get empathy from your machine',
        0), (1,
             'Have you tried reading the error message? usually can be found in the console',
             10), (2,
                   'Please do not use this platform to brag about working code. ',
                   15);


select *
from issues;


select *
from solutions;

