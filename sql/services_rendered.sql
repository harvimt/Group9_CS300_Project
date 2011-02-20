
--
-- TABLE: services_rendered
-- 
--  

CREATE TABLE services_rendered (
  service_logged timestamp without timezone NOT NULL  DEFAULT NOW(),
  service_provided date NOT NULL ,
  provider_id int NOT NULL ,
  service_id int unsigned NOT NULL ,
  member_id int(9) unsigned NOT NULL ,
  comments varchar(100) NOT NULL ,
  fee decimal NOT NULL  DEFAULT 0
);

CREATE INDEX providers_provider_id_index  ON services_rendered(provider_id);

CREATE INDEX services_index  ON services_rendered();

CREATE INDEX members_index  ON services_rendered();

-- 
ALTER TABLE services_rendered ADD CONSTRAINT rendered_provider_fk FOREIGN KEY (provider_id) REFERENCES providers(provider_id) ON UPDATE NO ACTION ON DELETE NO ACTION;

-- 
ALTER TABLE services_rendered ADD CONSTRAINT rendered_service_fk FOREIGN KEY () REFERENCES services() ON UPDATE NO ACTION ON DELETE NO ACTION;

-- 
ALTER TABLE services_rendered ADD CONSTRAINT rendered_member_fk FOREIGN KEY () REFERENCES members() ON UPDATE NO ACTION ON DELETE NO ACTION;

-- CHECK Constraints are not supported in Mysql ( as of version 5.x )
-- But it'll parse the statements without error 
CREATE INDEX services_rendered_member_id_index  ON services_rendered(member_id);
ALTER TABLE services_rendered ADD CONSTRAINT  FOREIGN KEY () REFERENCES providers ();
ALTER TABLE services_rendered ADD CONSTRAINT  FOREIGN KEY () REFERENCES members ();
