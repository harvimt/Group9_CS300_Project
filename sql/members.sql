
--
-- TABLE: members
-- 
--  

CREATE TABLE members (
  member_id int unsigned NOT NULL ,
  full_name varchar(25) NOT NULL ,
  member_status  NOT NULL ,
  street_address varchar(25) NOT NULL ,
  city varchar(14) NOT NULL ,
  state char(2) NOT NULL ,
  zip_code char(5) NOT NULL ,
  email varchar(128) NOT NULL 
);

CREATE INDEX members_member_id_index  ON members(member_id);
ALTER TABLE members CHANGE member_id member_id int unsigned  NOT NULL AUTO_INCREMENT ;

-- 
ALTER TABLE members ADD CONSTRAINT member_pk PRIMARY KEY (member_id);

CREATE INDEX member_statuses_status_id_index  ON members(status_id);

-- 
ALTER TABLE members ADD CONSTRAINT member_status_fk FOREIGN KEY (member_status) REFERENCES member_statuses(status_id) ON UPDATE NO ACTION ON DELETE NO ACTION;

-- CHECK Constraints are not supported in Mysql ( as of version 5.x )
-- But it'll parse the statements without error 
CREATE INDEX members_full_name_index  ON members(full_name);
ALTER TABLE members ADD CONSTRAINT  FOREIGN KEY () REFERENCES member_statuses ();
ALTER TABLE members ADD CONSTRAINT  FOREIGN KEY () REFERENCES services_rendered ();
ALTER TABLE members ADD CONSTRAINT  FOREIGN KEY () REFERENCES member_statuses ();
