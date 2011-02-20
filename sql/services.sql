
--
-- TABLE: services
-- 
--  

CREATE TABLE services (
  service_id int(6) unsigned NOT NULL ,
  service_name varchar(32) NOT NULL ,
  fee decimal NOT NULL  DEFAULT 0
);

CREATE INDEX services_service_id_index  ON services(service_id);
ALTER TABLE services CHANGE service_id service_id int unsigned  NOT NULL AUTO_INCREMENT ;

-- 
ALTER TABLE services ADD CONSTRAINT unique_service_names UNIQUE (service_name);

-- 
ALTER TABLE services ADD CONSTRAINT service_pk PRIMARY KEY (service_id);

-- CHECK Constraints are not supported in Mysql ( as of version 5.x )
-- But it'll parse the statements without error ALTER TABLE services ADD CONSTRAINT  FOREIGN KEY () REFERENCES services_rendered ();
