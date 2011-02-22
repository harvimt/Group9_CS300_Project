
--
-- TABLE: services
-- 
--  

CREATE TABLE IF NOT EXISTS services (
  service_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  service_name varchar(32) NOT NULL UNIQUE ,
  fee decimal NOT NULL  DEFAULT 0
);