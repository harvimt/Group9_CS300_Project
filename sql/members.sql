
--
-- TABLE: members
-- 
--  

CREATE TABLE IF NOT EXISTS members (
  member_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  full_name varchar(25) NOT NULL ,
  member_status  NOT NULL REFERENCES member_statuses,
  street_address varchar(25) NOT NULL ,
  city varchar(14) NOT NULL ,
  state char(2) NOT NULL ,
  zip_code char(5) NOT NULL ,
  email varchar(128) NOT NULL 
);

CREATE INDEX IF NOT EXISTS members_full_name_index ON members(full_name);
