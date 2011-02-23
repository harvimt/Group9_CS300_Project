
--
-- TABLE: services_rendered
-- 
--  

CREATE TABLE IF NOT EXISTS services_rendered (
  transaction_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  service_logged int NOT NULL DEFAULT (date('now')),
  service_provided int NOT NULL ,
  provider_id int NOT NULL REFERENCES providers,
  service_id int NOT NULL REFERENCES services,
  member_id int NOT NULL REFERENCES members,
  comments varchar(100) NOT NULL,
  fee decimal NOT NULL  DEFAULT 0
);