
create view jdbcrealm_user (username, password) as
select username, password
from account;

create view jdbcrealm_group (username, groupname) as
select username, 'Users'
from account;

insert into account (username,dob,email,fullname,password) values('bipin','1/1/1990','bipin@gmail.com','bipin','9387bd0ec09043ca09ee0fa64f969d79310872b2127fc9d43f9cfbb75ed4ec11');
