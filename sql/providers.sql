
--
-- TABLE: providers
-- 
--  

CREATE TABLE providers (
  provider_id int(9) NOT NULL ,
  provider_name varchar(32) NOT NULL ,
  email varchar(128) NOT NULL 
);

CREATE INDEX providers_provider_id_index  ON providers(provider_id);
ALTER TABLE providers CHANGE provider_id provider_id int   NOT NULL AUTO_INCREMENT ;

-- CHECK Constraints are not supported in Mysql ( as of version 5.x )
-- But it'll parse the statements without error 
CREATE INDEX providers_provider_id_index  ON providers(provider_id);

CREATE INDEX providers_provider_name_index  ON providers(provider_name);
