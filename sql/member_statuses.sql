
--
-- TABLE: member_statuses
-- An enum representing the values "VALID" "SUSPENDED", "BANNED", or "CANCELED".
--  

CREATE TABLE member_statuses (
  status_id int unsigned NOT NULL ,
  status_name varchar(10) NOT NULL 
);

CREATE INDEX member_statuses_status_id_index  ON member_statuses(status_id);
ALTER TABLE member_statuses CHANGE status_id status_id int unsigned  NOT NULL AUTO_INCREMENT ;

-- 
ALTER TABLE member_statuses ADD CONSTRAINT member_status_pk PRIMARY KEY (status_id);

-- CHECK Constraints are not supported in Mysql ( as of version 5.x )
-- But it'll parse the statements without error 
CREATE INDEX member_statuses_status_id_index  ON member_statuses(status_id);

CREATE INDEX member_statuses_status_name_index  ON member_statuses(status_name);
ALTER TABLE member_statuses ADD CONSTRAINT  FOREIGN KEY () REFERENCES member_statuses ();
