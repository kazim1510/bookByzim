
create view jdbcrealm_user (username, password) as
select username, password
from account;

create view jdbcrealm_group (username, groupname) as
select username, groupname
from account;


insert into account (username,dob,email,fullname,password,groupname,version) values('bipin','1/1/1990','bipin@gmail.com','bipin','9387bd0ec09043ca09ee0fa64f969d79310872b2127fc9d43f9cfbb75ed4ec11','Admins',0);
insert into account (username,dob,email,fullname,password,groupname,version) values('kazim','1/1/1990','kazim@gmail.com','kazim','b237694bbe44509cc2d7de4cf6b903f7b7b98397cea6655e99ab7b4056bedba7','Admins',0);
insert into account (username,dob,email,fullname,password,groupname,version) values('chintan','1/1/1990','kazim@gmail.com','kazim','b237694bbe44509cc2d7de4cf6b903f7b7b98397cea6655e99ab7b4056bedba7','Admins',0);


