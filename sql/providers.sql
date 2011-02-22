
--
-- TABLE: providers
-- 
--  

CREATE TABLE IF NOT EXISTS providers (
  provider_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  provider_name varchar(32) NOT NULL ,
  email varchar(128) NOT NULL 
);

CREATE INDEX IF NOT EXISTS providers_provider_name_index  ON providers(provider_name);
